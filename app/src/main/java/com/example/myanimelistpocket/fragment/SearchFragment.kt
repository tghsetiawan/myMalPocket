package com.example.myanimelistpocket.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.R
import com.example.myanimelistpocket.adapter.SearchAnimeAdapter
import com.example.myanimelistpocket.adapter.TopAnimeAdapter
import com.example.myanimelistpocket.databinding.FragmentHomeBinding
import com.example.myanimelistpocket.databinding.FragmentSearchBinding
import com.example.myanimelistpocket.viewmodel.SearchAnimeViewModel
import com.example.myanimelistpocket.viewmodel.TopAnimeViewModel

class SearchFragment : Fragment() {

    private lateinit var viewAdapter: SearchAnimeAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var viewModel : SearchAnimeViewModel
    private lateinit var binding : FragmentSearchBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(this).get(SearchAnimeViewModel::class.java)
        binding = FragmentSearchBinding.inflate(inflater)

        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        binding.btnCari.setOnClickListener {
            val title = binding.textInputEditText.text
            viewModel.searchAnime(title.toString())

            //add reyclerview
            viewManager = LinearLayoutManager(activity)
            viewAdapter = SearchAnimeAdapter({item->showDetail(item)})
            binding.myRecyclerView.adapter = viewAdapter
            binding.myRecyclerView.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }

            viewModel.items.observe(this, Observer { list -> viewAdapter.submitList(list) })
        }

        // Inflate the layout for this fragment
        return binding.root
//        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    fun showDetail(username: String){
        Log.d("showDetail: ","OnClick = " + username)
        //navigasi ke halaman lain
        this.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToDetailAnimeFragment(username))
    }
    
}