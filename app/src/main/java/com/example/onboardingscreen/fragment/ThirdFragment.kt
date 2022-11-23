package com.example.onboardingscreen.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.onboardingscreen.HomeActivity
import com.example.onboardingscreen.MainActivity
import com.example.onboardingscreen.R
import com.example.onboardingscreen.databinding.FragmentThirdBinding
import com.example.onboardingscreen.shared.SharePref

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = SharePref(requireContext())
        val activity = (activity as MainActivity)
        binding.button.setOnClickListener {
            val intent = Intent(activity, HomeActivity::class.java)
            activity.startActivity(intent)
            activity.finish()
            sharedPref.save(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}