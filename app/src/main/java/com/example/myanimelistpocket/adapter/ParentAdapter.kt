package com.example.myanimelistpocket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.R
import com.example.myanimelistpocket.data.ChildModel
import com.example.myanimelistpocket.data.ParentModel
import com.example.myanimelistpocket.databinding.ChildRecyclerBinding
import com.example.myanimelistpocket.databinding.ParentRecyclerBinding

class ParentAdapter(private val parents : List<ParentModel>) : RecyclerView.Adapter<ParentAdapter.ViewHolder>(){

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val v = LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler,parent,false)
//        return ViewHolder(v)

        return ViewHolder(ParentRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parents[position]
//        holder.textView.text = parent.title
//        val childLayoutManager = LinearLayoutManager(holder.recyclerView.context, RecyclerView.HORIZONTAL, false)
//        childLayoutManager.initialPrefetchItemCount = 4
//        holder.recyclerView.apply {
//            layoutManager = childLayoutManager
//            adapter = ChildAdapter(parent.children)
//            setRecycledViewPool(viewPool)
//        }

        holder.binding.item = parents?.get(position)
        val chilLayoutManager = LinearLayoutManager(holder.binding.rvChild.context, RecyclerView.HORIZONTAL, false)
        chilLayoutManager.initialPrefetchItemCount = 4
        holder.binding.rvChild.apply {
            layoutManager = chilLayoutManager
            adapter = ChildAdapter(parents[position].children)
            setRecycledViewPool(viewPool)
        }
    }

//    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
//        val recyclerView : RecyclerView = itemView.rv_child
//        val textView: TextView = itemView.textView
//    }

    inner class ViewHolder(var binding: ParentRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(parentModel: ParentModel){
            binding.item = parentModel
            binding.executePendingBindings()
        }
    }
}