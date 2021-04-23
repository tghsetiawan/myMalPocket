package com.example.myanimelistpocket.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.api.responsemodel.topresult.TopResult
import com.example.myanimelistpocket.databinding.ItemCardviewBinding

class TopAnimeAdapter : ListAdapter<TopResult, TopAnimeAdapter.ViewHolder>(DiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCardviewBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(private var binding: ItemCardviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(topResult: TopResult) {
            binding.item = topResult
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<TopResult>(){
        override fun areItemsTheSame(oldItem: TopResult, newItem: TopResult): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TopResult, newItem: TopResult): Boolean {
            return oldItem.mal_id == newItem.mal_id
        }
    }
}

