package com.example.myanimelistpocket.adapter
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.api.responsemodel.seasonslater.Anime
import com.example.myanimelistpocket.databinding.LayoutViewpagerBinding

class HomePagerAdapter : ListAdapter<Anime, HomePagerAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutViewpagerBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        Log.d("onBindViewHolder: ", item.title)
        item.title
        holder.bind(item)

    }

    inner class ViewHolder(private var binding: LayoutViewpagerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: Anime) {
            binding.item = anime
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Anime>(){
        override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem.mal_id == newItem.mal_id
        }
    }
}