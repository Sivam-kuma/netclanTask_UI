package com.example.netclantask

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
              supportActionBar?.hide()
        val viewPager=findViewById<ViewPager>(R.id.viewPager)
        val tabLayout=findViewById<TabLayout>(R.id.tabLayout)
        val other_icon=findViewById<ImageView>(R.id.otherIcon)
        // Set up the ViewPager with the custom adapter
        viewPager.adapter = TabPagerAdapter(supportFragmentManager)

        // Connect the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager)

        other_icon.setOnClickListener {
            // Create intent to navigate to ActivityY
            val intent = Intent(this, refine::class.java)

            // Start the target activity
            startActivity(intent)
        }
    }

    // Custom FragmentPagerAdapter to manage fragments
    inner class TabPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getCount(): Int = 3 // Number of tabs (chat, calls, status)

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> ChatFragment()
                1 -> CallsFragment()
                2 -> StatusFragment()
                else -> throw IllegalArgumentException("Invalid position: $position")
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Personal"
                1 -> "Business"
                2 -> "Merchant"
                else -> throw IllegalArgumentException("Invalid position: $position")
            }
        }
    }
}
