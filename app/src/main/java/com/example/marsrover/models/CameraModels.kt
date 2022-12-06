package com.example.marsrover.models

import com.google.gson.annotations.SerializedName

//class CameraModels {
//}


data class CameraModels (
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("rover_id")
    val rover_id: Int,

    @SerializedName("full_name")
    val full_name: String,


    )



//"camera":{
//    "id":20,
//    "name":"FHAZ",
//    "rover_id":5,
//    "full_name":"Front Hazard Avoidance Camera"
//},













































