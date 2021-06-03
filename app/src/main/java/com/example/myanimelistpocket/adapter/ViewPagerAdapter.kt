package com.example.myanimelistpocket.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.api.responsemodel.topresult.TopResult
import com.example.myanimelistpocket.data.Club
import com.example.myanimelistpocket.databinding.HalamanViewpagerBinding
import com.example.myanimelistpocket.databinding.ItemCardviewBinding

class ViewPagerAdapter(private var listClubs: MutableList<Club>?) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HalamanViewpagerBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = getItem(position)
//        holder.bind(item)

        holder.itemBinding.club = listClubs?.get(position)
    }


    class ViewHolder(val itemBinding: HalamanViewpagerBinding) : RecyclerView.ViewHolder(itemBinding.root){
//        private var binding : HalamanViewpagerBinding? = null
//        init { this.binding = itemBinding }
        fun bind(club: Club) {
            itemBinding.club = club

            itemBinding.executePendingBindings()
        }
    }

//    companion object DiffCallback: DiffUtil.ItemCallback<TopResult>(){
//        override fun areItemsTheSame(oldItem: TopResult, newItem: TopResult): Boolean {
//            return oldItem === newItem
//        }
//
//        override fun areContentsTheSame(oldItem: TopResult, newItem: TopResult): Boolean {
//            return oldItem.mal_id == newItem.mal_id
//        }
//    }

    override fun getItemCount(): Int {
        listClubs?.let {
            return it.size
        }
        return 0
    }
}