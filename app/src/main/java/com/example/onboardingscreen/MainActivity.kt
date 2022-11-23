package com.example.onboardingscreen

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.onboardingscreen.adapter.ViewPagerAdapter
import com.example.onboardingscreen.databinding.ActivityMainBinding
import com.zhpan.indicator.enums.IndicatorSlideMode

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()
//        window.statusBarColor = Color.parseColor("#ff8800")

        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        binding.indicator.apply {
            setSliderColor(Color.GRAY, Color.WHITE)
            setSliderWidth(18f)
            setSliderHeight(18f)
            setSlideMode(IndicatorSlideMode.WORM)
            setPageSize(binding.viewPager.adapter?.itemCount!!)
            notifyDataChanged()
        }
        binding.indicator.setupWithViewPager(binding.viewPager)
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.indicator.onPageSelected(position)
                if (position == 1) {
                    window.statusBarColor = Color.parseColor("#ffb800")
                } else {
                    window.statusBarColor = Color.parseColor("#ff8800")
                }
            }
        })
        binding.viewPager.isUserInputEnabled = false
    }

    override fun onBackPressed() {
        if (binding.viewPager.currentItem != 0) {
            binding.viewPager.currentItem = 0
        } else {
            super.onBackPressed()
        }
    }
}