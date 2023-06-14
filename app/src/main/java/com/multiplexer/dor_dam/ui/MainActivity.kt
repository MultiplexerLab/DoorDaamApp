package com.multiplexer.dor_dam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.kamrul_hasan.dor_dam.R
import com.kamrul_hasan.dor_dam.databinding.ActivityMainBinding
import com.multiplexer.dor_dam.network.NetworkConnection

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

//        setupActionBarWithNavController(navController)
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

        NetworkConnection().observe(this) {
            if (it) {
                binding.tvNoConnection.setBackgroundResource(R.color.primaryColor)
                binding.tvNoConnection.text = resources.getString(R.string.back_online)

                Handler(Looper.getMainLooper()).postDelayed({
                    binding.tvNoConnection.visibility = View.GONE
                }, 1500)

            } else {
                binding.tvNoConnection.text = resources.getString(R.string.no_connection)
                binding.tvNoConnection.setBackgroundResource(R.color.gray)
                binding.tvNoConnection.visibility = View.VISIBLE
            }
        }
    }

    /* override fun onSupportNavigateUp(): Boolean {
         return navController.navigateUp() || super.onSupportNavigateUp()
     }*/

}