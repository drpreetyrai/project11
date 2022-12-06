package com.example.marsrover.models

import com.google.gson.annotations.SerializedName

//class RoverModels {
//}
//




data class RoverModels (

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("landing_date")
    val landing_date: String,

    @SerializedName("launch_date")
    val lauch_date: String,

    @SerializedName("status")
    val status: String,


    )




//"rover":{
//    "id":5,
//    "name":"Curiosity",
//    "landing_date":"2012-08-06",
//    "launch_date":"2011-11-26",
//    "status":"active"
//}













































