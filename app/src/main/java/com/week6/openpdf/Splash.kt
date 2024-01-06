package com.week6.openpdf


import LoginFragment
import RegisterFragment
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import java.util.Timer
import java.util.TimerTask

class Splash : AppCompatActivity() {
    private lateinit var shared:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        shared=getSharedPreferences("share_file", Context.MODE_PRIVATE)
       Timer().schedule(object :TimerTask(){
           override fun run() {
               if(shared.getString("pass","" ).toString().isNotEmpty() )
               {
//                   val f2: Fragment =FirstFragment()
//                   val fragmentTransaction: FragmentTransaction =supportFragmentManager.beginTransaction()
//                   fragmentTransaction.replace(R.id.fl_frame,f2).commit()
                   val intent=Intent(this@Splash,FirstActivity::class.java)
                   startActivity(intent)
                   finish()
               }
               else
               {
//                   val f2: Fragment =LoginFragment()
//                   val fragmentTransaction: FragmentTransaction =supportFragmentManager.beginTransaction()
//                   fragmentTransaction.replace(R.id.fl_frame,f2).commit()
                   val intent=Intent(this@Splash,LoginActivity::class.java)
                   startActivity(intent)
                   finish()
               }
           }

       },3000)
    }
}