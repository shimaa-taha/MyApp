package com.week6.openpdf

import LoginFragment
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedpref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val f1: Fragment =LoginFragment()
        val fragmentTransaction: FragmentTransaction =supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,f1).commit()

    }
}