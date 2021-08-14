package com.example.myapplication.data.Song

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.item_song.view.*

class SongAdapter : RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(song: Song, onClickListener: (songName: String, text: String) -> Unit) {
            itemView.tvLyricSong.text = song.name
            itemView.setOnClickListener {
                onClickListener.invoke(song.name,song.text)
            }
        }
    }

    var onClickListener: (songName: String, text: String) -> Unit = { songName, text -> }
    var modelsSong: List<Song> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(modelsSong[position],onClickListener)
    }

    override fun getItemCount(): Int {
        return modelsSong.size
    }


}