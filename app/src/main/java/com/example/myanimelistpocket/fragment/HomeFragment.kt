package com.example.myanimelistpocket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myanimelistpocket.R
import com.example.myanimelistpocket.databinding.FragmentHomeBinding
import com.example.myanimelistpocket.databinding.FragmentTopAnimeBinding
import com.example.myanimelistpocket.viewmodel.TopAnimeViewModel

class HomeFragment : Fragment() {

//    private lateinit var viewModel : TopAnimeViewModel
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        (activity as AppCompatActivity).supportActionBar?.title = "Home"

//        viewModel = ViewModelProvider(this).get(TopAnimeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater)
//
//        binding.setLifecycleOwner(this)
//        binding.viewModel = viewModel

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        return binding.root
    }


}