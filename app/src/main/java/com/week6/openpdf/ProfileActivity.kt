package com.week6.openpdf

import LoginFragment
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.week6.openpdf.databinding.ActivitySecondBinding
import com.week6.openpdf.databinding.ProfileActivityBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var sharedpref: SharedPreferences
    private lateinit var binding: ProfileActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.profile_activity)
        binding = ProfileActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Handle Home item click
                    val intent = Intent(this, FirstActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.profile -> {
                    // Handle Home item click
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                // Add other cases for additional menu items if needed
                else -> {
                    true
                }
            }
        }

        val f1: Fragment =ProfileFragment()
        val fragmentTransaction: FragmentTransaction =supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout2,f1).commit()

    }
}