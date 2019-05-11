package com.wipro.model

import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import android.databinding.ObservableBoolean
import com.wipro.network.APIClient
import com.wipro.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Digvijay Singh on 11/5/19.
 */
class CountryBase : BaseObservable() {
    val country = MutableLiveData<Country>()

    fun fetchList() {
        val apiInterface = APIClient.getClient().create(ApiInterface::class.java)
        val userList = apiInterface.doGetUserList()
        userList.enqueue(object : Callback<Country> {
            override fun onResponse(call: Call<Country>, response: Response<Country>) {
                country.postValue(response.body())
            }

            override fun onFailure(call: Call<Country>, t: Throwable) {
                country.postValue(null)
            }
        })
    }

}
