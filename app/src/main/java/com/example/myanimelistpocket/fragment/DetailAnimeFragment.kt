package com.example.myanimelistpocket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myanimelistpocket.R
import com.example.myanimelistpocket.databinding.FragmentDetailAnimeBinding
import com.example.myanimelistpocket.databinding.FragmentTopAnimeBinding
import com.example.myanimelistpocket.viewmodel.DetailAnimeViewModel
import com.example.myanimelistpocket.viewmodel.DetailAnimeViewModelFactory
import com.example.myanimelistpocket.viewmodel.TopAnimeViewModel

class DetailAnimeFragment : Fragment() {

    private lateinit var viewModel: DetailAnimeViewModel
    private lateinit var binding: FragmentDetailAnimeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailAnimeBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        //accept args
        var argUsername = DetailAnimeFragmentArgs.fromBundle(arguments!!).username
        val vmFactory = DetailAnimeViewModelFactory(argUsername)

        binding.viewModel = ViewModelProvider(this, vmFactory).get(DetailAnimeViewModel::class.java)

        return binding.root
    }
}