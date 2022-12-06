package com.example.marsrover.marsgrid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsrover.models.MarsModels
import com.example.marsrover.network.MarsApi
import kotlinx.coroutines.launch

//class MarsGridViewModel {
//}





enum class MarsApiStatus { LOADING, ERROR, DONE }


class MarsGridViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<MarsApiStatus>()

    val status: LiveData<MarsApiStatus>
        get() = _status


    private val _properties = MutableLiveData<List<MarsModels>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val properties: LiveData<List<MarsModels>>
        get() = _properties

    // LiveData to handle navigation to the selected property
    private val _navigateToSelectedProperty = MutableLiveData<MarsModels?>()
    val navigateToSelectedProperty: MutableLiveData<MarsModels?>
        get() = _navigateToSelectedProperty



    init {
        getMarsRealEstateProperties()
    }


    private fun getMarsRealEstateProperties() {
        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try {
                _properties.value = MarsApi.retrofitService.getPhotos("DEMO_KEY",1000)?.body()?.photos
                _status.value = MarsApiStatus.DONE
            } catch (e: Exception) {
                Log.e("test",e.message.toString())
                _status.value = MarsApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }




    fun displayPropertyDetails(marsProperty: MarsModels) {
        _navigateToSelectedProperty.value = marsProperty
    }


    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}















































































































