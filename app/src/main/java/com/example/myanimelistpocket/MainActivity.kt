package com.example.myanimelistpocket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.adapter.SearchAnimeAdapter
import com.example.myanimelistpocket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navControl: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        navControl = this.findNavController(R.id.fragNavHost)
//        NavigationUI.setupActionBarWithNavController(this, navControl)
        NavigationUI.setupWithNavController(binding.bottomNavigation, navControl)

        binding.bottomNavigation.setOnNavigationItemReselectedListener {
            if (!binding.bottomNavigation.menu.findItem(it.itemId).isChecked) navControl.navigate(it.itemId)
            true
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        if (navControl.navigateUp() == false){
//            //navigateUp() returns false if there are no more fragments to pop
//            onBackPressed()
//        }
//        return navControl.navigateUp()
//    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navControl = this.findNavController(R.id.fragNavHost)
//        return navControl.navigateUp()
//    }
}