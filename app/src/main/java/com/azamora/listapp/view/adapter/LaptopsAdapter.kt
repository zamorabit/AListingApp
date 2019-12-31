package com.azamora.listapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.azamora.listapp.data.model.LaptopModel
import com.azamora.listapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_app_laptop_item.view.*

class LaptopsAdapter(private val laptops: MutableList<LaptopModel>,
                     private var listener: (LaptopModel) -> Unit) : RecyclerView.Adapter<LaptopsAdapter.LaptopHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaptopHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_app_laptop_item, parent, false)
        return LaptopHolder(view)
    }

    override fun getItemCount(): Int = laptops.size

    override fun onBindViewHolder(holder: LaptopHolder, position: Int) {
        holder.bind(laptops[position], position)
    }

    fun setLaptops(laptopsList: List<LaptopModel>) {
        this.laptops.clear()
        this.laptops.addAll(laptopsList)
        notifyDataSetChanged()
    }


    inner class LaptopHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(laptop: LaptopModel, position: Int) = with(view) {
            titleTextView.text = laptop.title
            shortDescriptionTextView.text = laptop.description
            view.setOnClickListener { listener(laptops?.get(position)) }
            when (laptop.image) {
                null -> imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.list_app_placeholder, null))
                else -> Picasso.get().load(laptop.image).placeholder(R.drawable.list_app_placeholder).into(imageView)
            }


        }
    }
}