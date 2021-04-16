package com.example.myanimelistpocket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.databinding.FragmentTopAnimeBinding

class TopAnimeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Star"

        val binding: FragmentTopAnimeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_anime, container, false)

        val title = arrayOf("d116df5",
            "36ffc75", "f5cfe78", "5b87628",
            "db8d14e", "9913dc4", "e120f96",
            "466251b")

        val secondaryTitle = arrayOf("Kekayaan", "Teknologi",
            "Keluarga", "Bisnis",
            "Keluarga", "Hutang",
            "Teknologi", "Pidana")

        val description = arrayOf("pertanyaan 9",
            "pertanyaan 11", "pertanyaan 17", "test forum",
            "pertanyaan 12", "pertanyaan 18", "pertanyaan 20",
            "pertanyaan 21")

        viewManager = LinearLayoutManager(activity)
        viewAdapter = TopAnimeAdapter(title, description)

        recyclerView = binding.myRecyclerView

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        // Inflate the layout for this fragment
        return binding.root
    }
//    }
}