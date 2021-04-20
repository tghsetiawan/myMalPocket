package com.example.myanimelistpocket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myanimelistpocket.databinding.ItemCardviewBinding

class TopAnimeAdapter(private val dataTitle: ArrayList<String>, private val dataDesc: ArrayList<String>, private val dataImg: ArrayList<String>) : RecyclerView.Adapter<TopAnimeAdapter.ViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardviewBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Glide.with(viewHolder.itemView.getContext())
            .load(dataImg.get(position))
            .apply(RequestOptions().override(350, 550))
            .into(viewHolder.image)
        viewHolder.title.text = dataTitle[position]
        viewHolder.score.text = dataDesc[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataTitle.size

    class ViewHolder(binding: ItemCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.animeTitle
        val score = binding.animeScore
        val image = binding.imgItemPhoto
    }
}
