package com.dvs.model

import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import com.dvs.network.APIClient
import com.dvs.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Digvijay Singh on 11/5/19.
 */
class CountryBase : BaseObservable() {
    val country = MutableLiveData<Country>()

    /*initializes api client and make api request and add it to the que*/
    fun fetchList() {
        val apiInterface = APIClient.getClient().create(ApiInterface::class.java)
        val userList = apiInterface.doGetUserList()
        userList.enqueue(object : Callback<Country> {
            override fun onResponse(call: Call<Country>, response: Response<Country>) {
                /*nootify data on response success*/
                country.postValue(response.body())
            }

            override fun onFailure(call: Call<Country>, t: Throwable) {
                /*notify if response is failure*/
                country.postValue(null)
            }
        })
    }

}
