package com.example.myanimelistpocket

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.databinding.ItemCardviewBinding

class TopAnimeAdapter(private val dataTitle: Array<String>, private val dataDesc: Array<String>) : RecyclerView.Adapter<TopAnimeAdapter.ViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardviewBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.text = dataTitle[position]
        viewHolder.desc.text = dataDesc[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataTitle.size

    class ViewHolder(binding: ItemCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvItemName
        val desc = binding.tvItemDetail
    }
}
