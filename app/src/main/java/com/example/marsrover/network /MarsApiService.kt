package com.example.marsrover.network

import com.example.marsrover.models.MarsModels
import com.example.marsrover.models.aaa
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//class MarsApiService {
//}




private const val BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [getProperties] method
 */
//interface MarsApiService {
//    /**
//     * Returns a Coroutine [List] of [MarsProperty] which can be fetched in a Coroutine scope.
//     * The @GET annotation indicates that the "realestate" endpoint will be requested with the GET
//     * HTTP method
//     */
//    @GET("realestate")
//    suspend fun getProperties(@Query("filter") type: String): List<MarsProperty>
//}


interface MarsApiService{
    // Base Url
    // https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/
    //
    // End Point Url
    // photos?sol=1000&api_key=DEMO_KEY


    // https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY

    // fun getPopularMovies(@Query("?sol=1000&api_key=DEMO_KEY") apiKey: String?): Call<MarsApiService?>?

    @GET("/photos")
    suspend fun getPhotos(@Query("api_key") apiKey:String?, @Query("sol") sol:Int) : Response<aaa>?


}



/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */

object MarsApi {
    val retrofitService : MarsApiService by lazy { retrofit.create(MarsApiService::class.java) }
}

























































































































