package com.wipro.network

import com.wipro.model.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Digvijay Singh on 11/5/19.
 */
interface ApiInterface {
    @GET("/s/2iodh4vg0eortkl/facts.json")
    fun doGetUserList(): Call<Country>


}