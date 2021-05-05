package com.example.myanimelistpocket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.Club
import com.example.myanimelistpocket.R
import com.example.myanimelistpocket.adapter.ViewPagerAdapter
import com.example.myanimelistpocket.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewAdapter: ViewPagerAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        val listClubs = mutableListOf<Club>()
        listClubs.add(Club(R.drawable.jikan_logo,"Premier League","English Premier League or EPL",android.R.color.holo_purple))
        listClubs.add(Club(R.drawable.jikan_logo,"La Liga","The Campeonato Nacional de Liga de Primera División",android.R.color.holo_orange_dark))
        listClubs.add(Club(R.drawable.jikan_logo,"Bundesliga","Federal League",android.R.color.holo_red_dark))
        listClubs.add(Club(R.drawable.jikan_logo,"Serie A","Lega Nazionale Professionisti Serie A",android.R.color.holo_blue_dark))
        listClubs.add(Club(R.drawable.jikan_logo,"Ligue 1","Ligue 1 Conforama",android.R.color.holo_orange_light))

        viewManager = LinearLayoutManager(activity)
        viewAdapter = ViewPagerAdapter(listClubs)
        binding.viewPagerMain.adapter = viewAdapter
        binding.viewPagerMain.apply {
            adapter = viewAdapter
        }

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home, container, false)
        return binding.root
    }
}