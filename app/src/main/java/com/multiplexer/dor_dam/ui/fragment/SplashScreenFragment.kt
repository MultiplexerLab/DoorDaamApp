package com.multiplexer.dor_dam.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.multiplexer.dor_dam.R
import com.multiplexer.dor_dam.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {

    private var _binding: FragmentSplashScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSplashScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // logo animation
        binding.ivLogo.animate().scaleX(0.5f).scaleY(0.5f).duration = 1200
        Handler(Looper.getMainLooper()).postDelayed({
            binding.ivLogo.animate().scaleX(1.0f).scaleY(1.0f).duration = 1200
        }, 1200)

        //welcome massage animation
        binding.tvWelcome.animate().rotation(360f).translationXBy(-134f).translationYBy(-134f).duration = 2000

        Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.city_corporation)
            }, 4000)
    }

    override fun onResume() {
        super.onResume()
//        (activity as AppCompatActivity).supportActionBar?.hide()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_bar).visibility = View.GONE
    }

    override fun onStop() {
        super.onStop()
//        (activity as AppCompatActivity).supportActionBar?.show()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_bar).visibility = View.VISIBLE
    }
}