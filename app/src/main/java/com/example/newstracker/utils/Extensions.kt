package com.example.newstracker.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

fun ImageView.loadByGlide(progressBar: ProgressBar,url:String){
    val lisnterFormGlide = object :RequestListener<Drawable>{
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            progressBar.apply {
                visibility = View.GONE
            }
            return false
        }

    }
    Glide.with(this)
        .load(url)
        .addListener(lisnterFormGlide)
        .into(this)
}