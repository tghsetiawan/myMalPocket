package com.example.myanimelistpocket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.R
import com.example.myanimelistpocket.api.responsemodel.topresult.TopResult
import com.example.myanimelistpocket.data.ChildModel
import com.example.myanimelistpocket.databinding.ChildRecyclerBinding
import com.example.myanimelistpocket.databinding.ItemCardviewBinding

class ChildAdapter(private val children : List<ChildModel>) : RecyclerView.Adapter<ChildAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ChildRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val child = children[position]
//        holder.imageView.setImageResource(child.image)
//        holder.textView.text = child.title

        holder.binding.data = children?.get(position)
    }

//    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
//        val textView : TextView = itemView.child_textView
//        val imageView: ImageView = itemView.child_imageView
//    }
//
//    inner class ViewHolder(private var binding: ItemCardviewBinding): RecyclerView.ViewHolder(binding.root) {
//        fun bind(topResult: TopResult) {
//            binding.item = topResult
//
//            binding.btnDetail.setOnClickListener {
//                showDetail(topResult.mal_id.toString())
//            }
//
//            binding.executePendingBindings()
//        }
//    }

    inner class ViewHolder(var binding: ChildRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(childmodel: ChildModel){
            binding.data = childmodel
            binding.executePendingBindings()
        }
    }
}