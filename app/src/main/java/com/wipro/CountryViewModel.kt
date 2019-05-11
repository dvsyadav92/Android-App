package com.wipro
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.view.View
import com.wipro.model.Country
import com.wipro.model.CountryBase


/**
 * Created by Digvijay Singh on 11/5/19.
 */
public class CountryViewModel : ViewModel() {
     var loading: ObservableInt
     var showEmpty: ObservableInt
      var pageTitle : ObservableField<String>
    private var countryBase : CountryBase
    init {
        countryBase= CountryBase()
        loading= ObservableInt(View.GONE)
        showEmpty= ObservableInt(View.GONE)
        pageTitle= ObservableField()
    }

    fun getCountry(): MutableLiveData<Country> {
        countryBase.fetchList()
        return countryBase.country
    }
}