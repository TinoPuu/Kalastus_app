package com.example.kalastus_app.models

import java.sql.Struct

data class Kalantiedot(var Aika: String = "", var Kala : String = "", var Kalastaja: String = "",
                       var Paikka: String = "", var Paino : String = "", var Tapa : String = "")
