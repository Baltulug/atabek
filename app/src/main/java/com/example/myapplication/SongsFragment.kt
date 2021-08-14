package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.data.MyDatabase
import com.example.myapplication.data.Song.SongAdapter
import com.example.myapplication.data.Song.SongDao
import kotlinx.android.synthetic.main.songs_fragment.*

class SongsFragment : Fragment(R.layout.songs_fragment) {
    private val safeArgs: SongsFragmentArgs by navArgs()
    var adapterSong = SongAdapter()
    private lateinit var dao: SongDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvSingerName.text = safeArgs.singerName
        var singerId = safeArgs.singerId

        dao = MyDatabase.getInstance(requireContext()).songsDao()
        adapterSong.modelsSong = dao.getSongsBySingerId(singerId)



        recyclerViewSongs.adapter = adapterSong

        adapterSong.onClickListener = { songName, songText ->

            var sendSongName = songName
            var sendSongText = songText

            val action =
                SongsFragmentDirections.actionSongsFragmentToLyricSongFragment(songName = sendSongName,songText = sendSongText)
            findNavController().navigate(action)
        }

    }
}