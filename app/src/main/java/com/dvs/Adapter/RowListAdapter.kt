package com.dvs.Adapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dvs.databinding.AdaterItemRowBinding
import com.dvs.model.Country

/**
 * Created by Digvijay Singh on 11/5/19.
 */
class RowListAdapter(var countryList: MutableList<Country.Row>?) : RecyclerView.Adapter<RowListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdaterItemRowBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countryList?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*Bind the data with row spesific */
        holder.bind(countryList?.get(position))
    }

    class ViewHolder(var binding: AdaterItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Country.Row?) {
            binding.itemViewModel= data
            binding.executePendingBindings()
        }

    }
}