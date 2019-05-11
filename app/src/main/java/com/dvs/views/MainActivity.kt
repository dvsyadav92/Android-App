package com.dvs.views
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.dvs.Adapter.RowListAdapter
import com.dvs.CountryViewModel
import com.dvs.R
import com.dvs.databinding.ActivityMainBinding
import com.dvs.model.Country
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Digvijay Singh on 11/5/19.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CountryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()
        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        binding.myViewModel=viewModel

        /*initialiazed the listner  and make api request to fetch country details*/
        setupListner()
    }

    private fun setupListner() {
        viewModel.loading.set(View.VISIBLE)
        viewModel.getCountry().observe(this, Observer<Country> {
            viewModel.loading.set(View.GONE)
            it.let {
                populateList(it)
                viewModel.pageTitle.set(it?.title)
                viewModel.showEmpty.set(View.GONE)
            }

            if(it==null) {
                viewModel.showEmpty.set(View.VISIBLE)
            }
            stopRefreshView()
        })


        pullToRefresh.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener(){
            refreshData()
        })
    }

    private fun refreshData() {
        viewModel.showEmpty.set(View.GONE)
        viewModel.loading.set(View.VISIBLE)
        viewModel.getCountry()
    }


    private fun stopRefreshView() {
        if(pullToRefresh.isRefreshing)
            pullToRefresh.isRefreshing=false
    }

    private fun populateList(countryList: Country?) {
        /*setup recyclerviee*/
        recyclVCountryList.layoutManager=LinearLayoutManager(this)
        recyclVCountryList.adapter= RowListAdapter(countryList?.rows)
    }
}

