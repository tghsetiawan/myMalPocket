package com.example.myanimelistpocket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelistpocket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navControl = this.findNavController(R.id.fragNavHost)
//        NavigationUI.setupActionBarWithNavController(this, navControl)
        NavigationUI.setupWithNavController(binding.bottomNavigation, navControl)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navControl = this.findNavController(R.id.fragNavHost)
//        return navControl.navigateUp()
//    }
}