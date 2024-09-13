package kg.less.hm_03_05m.interfaces

import kg.less.hm_03_05m.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApiService {
    @GET("getPercentage")
    fun getPercent(
        @Header("X-RapidAPI-Key") apiKey: String = "c9ca6be028msh6d10d8cc640195dp1001edjsn6b0748def79b",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
    ): Call<LoveModel>
}