package com.keepseung.animalsapp.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.keepseung.animalsapp.R

// d
fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImage(uri:String?, progrssDrrawable: CircularProgressDrawable){
    val options = RequestOptions
            .placeholderOf(progrssDrrawable)
            .error(R.mipmap.ic_launcher_round)
    Glide.with(context)
            .setDefaultRequestOptions(options)
            .load(uri)
            .into(this)

}

@BindingAdapter("android:imageUrl")
fun loadImage(view:ImageView, url:String){
    view.loadImage(url, getProgressDrawable(view.context))
}