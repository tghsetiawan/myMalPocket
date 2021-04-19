package com.example.myanimelistpocket

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.api.ControlApi
import com.example.myanimelistpocket.api.CustomCallback
import com.example.myanimelistpocket.api.responsemodel.TopResult
import com.example.myanimelistpocket.databinding.FragmentTopAnimeBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TopAnimeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    var controlApi = ControlApi()

    val listTitle = ArrayList<String>()
    val listDesc = ArrayList<String>()
    val listImg = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Star"

        val binding: FragmentTopAnimeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_top_anime,
            container,
            false
        )

        controlApi.TopAnime(object : CustomCallback {
            override fun onSucess(message: String?, retData: Any?) {
                // ubah objek menjadi string JSON
                val gson = Gson()
                val jsonValue = gson.toJson(retData)

                // jadi List
                val type = object : TypeToken<List<TopResult>>(){}.type
                val mapList: List<TopResult> = gson.fromJson<List<TopResult>>(jsonValue, type)
                for (map in mapList) {
                    Log.e("title", map.title.toString())
                    listTitle.add(map.title)
                    listDesc.add(map.url)
                    listImg.add(map.image_url)
                }

                viewManager = LinearLayoutManager(activity)
                viewAdapter = TopAnimeAdapter(listTitle, listDesc, listImg)

                recyclerView = binding.myRecyclerView

                recyclerView.apply {
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
            }

            override fun onFailure(message: String?) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show()
            }
        })

//        viewManager = LinearLayoutManager(activity)
//        viewAdapter = TopAnimeAdapter(title, description)
//
//        recyclerView = binding.myRecyclerView
//
//        recyclerView.apply {
//            layoutManager = viewManager
//            adapter = viewAdapter
//        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

    }
}