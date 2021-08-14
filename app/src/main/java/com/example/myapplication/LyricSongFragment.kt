package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.myapplication.data.Song.SongDao
import kotlinx.android.synthetic.main.lyric_fragment.*

class LyricSongFragment: Fragment(R.layout.lyric_fragment) {

    private val safeArgs: LyricSongFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvLyricName.text = safeArgs.songName
        tvLyricText.text = safeArgs.songText


    }
}