package com.example.myanimelistpocket

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopAnimeAdapter(private val dataTitle: Array<String>, private val dataDesc: Array<String>) : RecyclerView.Adapter<TopAnimeAdapter.ViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        val binding = ItemCardviewBinding.inflate(LayoutInflater.from(viewGroup.context))
//        return ViewHolder(binding)
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cardview, viewGroup, false)
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.text = dataTitle[position]
        viewHolder.desc.text = dataDesc[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataTitle.size

//    class ViewHolder(binding: ItemCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
//        val title = binding.tvItemName
//        val desc = binding.tvItemDetail
//        val btnAction = binding.btnDetail
//    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView
        var desc: TextView

        init {
            title = itemView.findViewById(R.id.tv_item_name)
            desc = itemView.findViewById(R.id.tv_item_detail)


        }
    }
}
