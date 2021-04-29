package com.example.myanimelistpocket.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.api.responsemodel.searchresult.SearchResult
import com.example.myanimelistpocket.api.responsemodel.topresult.TopResult
import com.example.myanimelistpocket.databinding.ItemCardviewBinding
import com.example.myanimelistpocket.databinding.SearchCardviewBinding

class SearchAnimeAdapter(private val showDetail: (String) -> Unit) : ListAdapter<SearchResult, SearchAnimeAdapter.ViewHolder>(DiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SearchCardviewBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(private var binding: SearchCardviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(searchResult: SearchResult) {
            binding.item = searchResult

            binding.btnDetail.setOnClickListener {
                showDetail(searchResult.mal_id.toString())
            }

            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<SearchResult>(){
        override fun areItemsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
            return oldItem.mal_id == newItem.mal_id
        }
    }
}