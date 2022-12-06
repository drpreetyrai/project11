package com.example.marsrover.models

import com.google.gson.annotations.SerializedName

//class MarsModels {
//}
//


data class MarsModels(
    @SerializedName("id")
    val id:Int,

//    @SerializedName("sol")
//    val vehicleID:Int,


    @SerializedName("sol")
    val sol:Int,

    @SerializedName("camera")
    val camera: CameraModels,

    @SerializedName("img_src")
    val img_src: String,

    @SerializedName("earth_date")
    val earth_date: String,

    @SerializedName("rover")
    val rover: RoverModels,

    )


//
//"photos":[
//{
//    "id":102693,
//    "sol":1000,
//    "camera":{
//    "id":20,
//    "name":"FHAZ",
//    "rover_id":5,
//    "full_name":"Front Hazard Avoidance Camera"
//},
//    "img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
//    "earth_date":"2015-05-30",
//    "rover":{
//    "id":5,
//    "name":"Curiosity",
//    "landing_date":"2012-08-06",
//    "launch_date":"2011-11-26",
//    "status":"active"
//}
//},































































