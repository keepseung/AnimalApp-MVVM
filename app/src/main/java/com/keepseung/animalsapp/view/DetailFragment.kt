package com.keepseung.animalsapp.view

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.keepseung.animalsapp.R
import com.keepseung.animalsapp.databinding.FragmentDetailBinding
import com.keepseung.animalsapp.model.Animal
import com.keepseung.animalsapp.model.AnimalPalette
import com.keepseung.animalsapp.util.getProgressDrawable
import com.keepseung.animalsapp.util.loadImage
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_list.*


class DetailFragment : Fragment() {

    var animal:Animal? = null
    private lateinit var dataBinding:FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        // Inflate the layout for this fragment
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            animal = DetailFragmentArgs.fromBundle(it).animal
        }

        animal?.imageUrl?.let{
            setupBackgroundColor(it)
        }

        dataBinding.animal = animal


    }

    fun setupBackgroundColor(url:String) {
        Glide.with(this).asBitmap().load(url).into(object :CustomTarget<Bitmap>(){
            override fun onLoadCleared(placeholder: Drawable?) {

            }

            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                Palette.from(resource)
                        .generate(){
                            palette ->
                            val intColor = palette?.lightMutedSwatch?.rgb ?:0
                            dataBinding.palette = AnimalPalette(intColor)
                        }
            }

        })
    }

}