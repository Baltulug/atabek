package com.example.myapplication.data.singer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.item.view.*

class SingerAdapter : RecyclerView.Adapter<SingerAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(singer: Singer, onClickListener: (name: String, id: Int) -> Unit) {
            itemView.tvName.text = "${singer.name}"
            itemView.setOnClickListener {
                onClickListener.invoke(singer.name,singer.id)
            }
        }
    }
    var onClickListener: (name: String,id: Int) -> Unit = {  name,id ->  }

    var models: List<Singer> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position], onClickListener)
    }

    override fun getItemCount(): Int {
        return models.size
    }
}