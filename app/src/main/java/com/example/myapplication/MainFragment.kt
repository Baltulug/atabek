package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.data.*
import com.example.myapplication.data.singer.SingerAdapter
import com.example.myapplication.data.singer.SingerDao
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(R.layout.main_fragment) {

    private var adapter = SingerAdapter()
    private lateinit var dao: SingerDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dao = MyDatabase.getInstance(requireContext()).singersDao()
        adapter.models = dao.getAllSinger()
        recyclerView.adapter = adapter

        adapter.onClickListener = { name, id ->
            var sendSingerName = name
            var sendSingerId = id

            val action =
                MainFragmentDirections.actionMainFragmentToSongsFragment(singerName = sendSingerName, singerId = sendSingerId)
            findNavController().navigate(action)
        }
    }
}