package com.example.myanimelistpocket.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myanimelistpocket.data.Club
import com.example.myanimelistpocket.R
import com.example.myanimelistpocket.adapter.ChildAdapter
import com.example.myanimelistpocket.adapter.HomePagerAdapter
import com.example.myanimelistpocket.adapter.ParentAdapter
import com.example.myanimelistpocket.adapter.ViewPagerAdapter
import com.example.myanimelistpocket.api.responsemodel.seasonslater.Anime
import com.example.myanimelistpocket.data.ParentDataFactory
import com.example.myanimelistpocket.databinding.FragmentHomeBinding
import com.example.myanimelistpocket.viewmodel.SeasonsLaterViewModel
import com.example.myanimelistpocket.viewmodel.TopAnimeViewModel


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    private lateinit var homePagerAdapter: HomePagerAdapter
    private lateinit var homePagerManager: RecyclerView.LayoutManager
    private lateinit var viewModel : SeasonsLaterViewModel

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(SeasonsLaterViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater)

        binding.setLifecycleOwner(this)

        //HomeViewPager
        homePagerManager = LinearLayoutManager(activity)
        homePagerAdapter = HomePagerAdapter()
        binding.viewPagerMain.adapter = homePagerAdapter
        binding.viewPagerMain.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //dotsPageIndicator
        val pageIndicatorView = binding.pageIndicatorView
        pageIndicatorView.setViewPager(binding.viewPagerMain)
        pageIndicatorView.radius = 4
        pageIndicatorView.padding = 15

//        binding.viewPagerMain.apply {
//            adapter = homePagerAdapter
//        }

        viewModel.items.observe(this, Observer { list -> homePagerAdapter.submitList(list) })
        initRecycler()

        return binding.root
    }

    private fun initRecycler(){
        recyclerView = binding.rvParent

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = ParentAdapter(ParentDataFactory.getParents(5))
        }
    }
}
