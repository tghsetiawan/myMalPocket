package com.example.myanimelistpocket.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.Club
import com.example.myanimelistpocket.R
import com.example.myanimelistpocket.databinding.HalamanViewpagerBinding
import com.example.myanimelistpocket.databinding.ItemCardviewBinding

class ViewPagerAdapter(private var listClubs: MutableList<Club>?) :
    RecyclerView.Adapter<ViewPagerAdapter.MyViewHolder>() {

    class MyViewHolder(val itemBinding: HalamanViewpagerBinding) : RecyclerView.ViewHolder(itemBinding.root){

        private var binding : HalamanViewpagerBinding? = null

        init {
            this.binding = itemBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(HalamanViewpagerBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val inflater = LayoutInflater.from(ctx)
//        val binding: HalamanViewpagerBinding = DataBindingUtil.inflate(inflater, R.layout.halaman_viewpager,parent,false)
//        return MyViewHolder(binding)
//    }

    override fun getItemCount(): Int {
        listClubs?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemBinding.club = listClubs?.get(position)
    }

}