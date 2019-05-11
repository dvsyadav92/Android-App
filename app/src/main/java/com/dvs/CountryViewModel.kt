package com.dvs
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.view.View
import com.dvs.model.Country
import com.dvs.model.CountryBase


/**
 * Created by Digvijay Singh on 11/5/19.
 */


/*
* Managing the lifecycle of the component
* */
public class CountryViewModel : ViewModel() {
     var loading: ObservableInt
     var showEmpty: ObservableInt
      var pageTitle : ObservableField<String>
    private var countryBase : CountryBase
    init {
        /*initialized the properties*/
        countryBase= CountryBase()
        loading= ObservableInt(View.GONE)
        showEmpty= ObservableInt(View.GONE)
        pageTitle= ObservableField()
    }


/*
* To fetch country details
* */
    fun getCountry(): MutableLiveData<Country> {
        countryBase.fetchList()
        return countryBase.country
    }
}