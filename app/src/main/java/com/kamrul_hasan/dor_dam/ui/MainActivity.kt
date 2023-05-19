package com.kamrul_hasan.dor_dam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.kamrul_hasan.dor_dam.R
import com.kamrul_hasan.dor_dam.databinding.ActivityMainBinding
import com.kamrul_hasan.dor_dam.ui.fragment.CityCorporationFragment

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_host) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
        binding.bottomNavBar.setupWithNavController(navController)

        binding.bottomNavBar.setOnItemSelectedListener {
            Log.d(TAG, "onCreate: home fragment1")
            when (it.itemId) {
                R.id.city_corporation -> {
                    navController.navigate(R.id.city_corporation)
                    true
                }

                R.id.powroshova -> {
                    navController.navigate(R.id.powroshova)
                    true
                }

                R.id.lgd_ministry -> {
                    navController.navigate(R.id.lgd_ministry)
                    true
                }

                R.id.live_stock_ministry -> {
                    navController.navigate(R.id.live_stock_ministry)
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}