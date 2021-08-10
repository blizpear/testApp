package ru.cft.shift2021summer.presentation.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.databinding.ListViewItemBinding
import ru.cft.shift2021summer.domain.model.CountryData

class CountryLinearAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<CountryData, CountryLinearAdapter.CountryViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<CountryData>() {

        override fun areItemsTheSame(oldItem: CountryData, newItem: CountryData): Boolean {

            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CountryData, newItem: CountryData): Boolean {
            return oldItem == newItem
        }
    }

    class CountryViewHolder(private var binding: ListViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(countryData: CountryData) {
            binding.CountryName.text = countryData.name
            binding.RegionName.text = countryData.region

        }

        companion object {
            fun from(parent: ViewGroup): CountryViewHolder {

                val layoutInflater = LayoutInflater.from(parent.context)

                val binding = ListViewItemBinding.inflate(layoutInflater, parent, false)

                return CountryViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        return CountryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        val countryData = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(countryData)
        }
        holder.bind(countryData)
    }

    class OnClickListener(val clickListener: (countryData: CountryData) -> Unit) {

        fun onClick(countryData: CountryData) = clickListener(countryData)
    }
}