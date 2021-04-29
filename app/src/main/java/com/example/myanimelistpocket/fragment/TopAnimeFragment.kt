package com.example.myanimelistpocket.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.adapter.TopAnimeAdapter
import com.example.myanimelistpocket.api.ControlApi
import com.example.myanimelistpocket.api.responsemodel.topresult.BaseDataTopResult
import com.example.myanimelistpocket.api.responsemodel.topresult.TopResult
import com.example.myanimelistpocket.databinding.FragmentTopAnimeBinding
import com.example.myanimelistpocket.viewmodel.TopAnimeViewModel

class TopAnimeFragment : Fragment() {

    private lateinit var viewAdapter: TopAnimeAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var viewModel : TopAnimeViewModel
    private lateinit var binding : FragmentTopAnimeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        (activity as AppCompatActivity).supportActionBar?.title = "Star"

        viewModel = ViewModelProvider(this).get(TopAnimeViewModel::class.java)
        binding = FragmentTopAnimeBinding.inflate(inflater)

        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        //add reyclerview
        viewManager = LinearLayoutManager(activity)
        viewAdapter = TopAnimeAdapter({item->showDetail(item)})
        binding.myRecyclerView.adapter = viewAdapter
        binding.myRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        viewModel.items.observe(this, Observer { list -> viewAdapter.submitList(list) })

        // Inflate the layout for this fragment
        return binding.root
    }

    fun showDetail(username: String){
        Log.d("showDetail: ","OnClick = " + username)
        //navigasi ke halaman lain
        this.findNavController()
            .navigate(TopAnimeFragmentDirections.actionTopAnimeFragmentToDetailAnimeFragment(username))
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }
}
