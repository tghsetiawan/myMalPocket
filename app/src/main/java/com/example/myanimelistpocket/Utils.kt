package com.example.myanimelistpocket

import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object Utils {
    @BindingAdapter("setBackgroundColor")
    @JvmStatic
    fun ConstraintLayout.setBgColor(color:Int){
        setBackgroundColor(ContextCompat.getColor(this.context,color))
    }

    @BindingAdapter("setImage")
    @JvmStatic
    fun ImageView.setLogo(resource:Int){
        setImageResource(resource)
    }

    @BindingAdapter("showImage")
    @JvmStatic
    fun showImage(imgView: ImageView, url: String?){
        Glide.with(imgView.context)
            .load(url)
            .into(imgView)
    }
}