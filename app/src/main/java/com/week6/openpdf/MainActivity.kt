package com.week6.openpdf

import android.app.DownloadManager
import android.content.Context

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.FileProvider
import com.github.barteksc.pdfviewer.PDFView
import com.shockwave.pdfium.BuildConfig
import com.week6.openpdf.FirstActivity
import com.week6.openpdf.ProfileActivity
import com.week6.openpdf.databinding.MainActivityBinding
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    private var currentPageNumber = 0
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedpref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedpref = getSharedPreferences("share_file", Context.MODE_PRIVATE)

        var user_name:String=sharedpref.getString("Name","").toString()

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

//
        // Get the pdfIdentifier from the intent
//        val pdfIdentifier = intent.getStringExtra("pdfIdentifierM")
//        Log.d("PDF_DEBUG", "PDF Identifier: $pdfIdentifier")
        val pdfIdentifier = intent.getStringExtra("pdfIdentifierM")
        Log.d("PDF_DEBUG", "PDF Identifier: $pdfIdentifier")

        // Set FLAG_SECURE to prevent screenshots
//        //Window: Represents a window in an Android application. It is used to display the user interface and content of an activity or dialog.
//        // setFlags method: This method is used to set additional flags for the window.
//        //WindowManager.LayoutParams.FLAG_SECURE: This flag is used to make the window secure. When this flag is set, the content of the window will not be captured or recorded by screenshot applications or screen recording apps.
//        //By setting this flag, the application aims to protect sensitive information or content from being leaked through screenshots or screen recordings.
//        //Parameters of setFlags: The first parameter is the flag to be set, which is WindowManager.LayoutParams.FLAG_SECURE in this case.
//        //The second parameter is a mask that determines which bits in the window's flags will be affected by the operation. In this case, it's also WindowManager.LayoutParams.FLAG_SECURE.
//

        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)





        // Retrieve the last viewed page number from SharedPreferences
        currentPageNumber = sharedPreferences.getInt(pdfIdentifier, 0)

        binding.openPdfButton.setOnClickListener {
            binding.loadingProgressBar.visibility = View.VISIBLE

            // Load the PDF using the pdfIdentifier and jump to the last viewed page
            binding.pdfView.fromAsset(pdfIdentifier)
                .defaultPage(currentPageNumber)  // Jump to the last viewed page
                .onLoad {
                    // Hide loading indicator when the PDF is loaded
                    binding.loadingProgressBar.visibility = View.INVISIBLE
                }
                .onPageChange { page, pageCount ->
                    // Update the current page number
                    currentPageNumber = page
                }
                .load()
        }
        binding.btnav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Save the last viewed page number to SharedPreferences
//
            with(sharedPreferences.edit()) {
                putInt(pdfIdentifier, currentPageNumber)
                apply()
            }
                    // Handle Home item click
                    val intent = Intent(this, FirstActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.profile -> {
                    // Save the last viewed page number to SharedPreferences
//
            with(sharedPreferences.edit()) {
                putInt(pdfIdentifier, currentPageNumber)
                apply()
            }
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
//        binding.backToMain.setOnClickListener {
//            // Save the last viewed page number to SharedPreferences
//
//            with(sharedPreferences.edit()) {
//                putInt(pdfIdentifier, currentPageNumber)
//                apply()
//            }
//
//            val i = Intent(this, FirstActivity::class.java)
//            startActivity(i)
//            finish()
//        }

//        binding.profile.setOnClickListener {
//            // Save the last viewed page number to SharedPreferences before navigating to ProfileActivity
//            with(sharedPreferences.edit()) {
//                putInt(pdfIdentifier+user_name, currentPageNumber)
//                apply()
//            }
//
//            val intent = Intent(this, ProfileActivity::class.java)
//            startActivity(intent)
//        }
    }
}




//package com.week6.openpdf
//
//import android.app.DownloadManager
//import android.content.Context
//import android.content.Intent
//import android.content.SharedPreferences
//import android.net.Uri
//import android.os.Bundle
//import android.os.Environment
//import android.util.Log
//import android.view.View
//import android.view.WindowManager
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.ContextCompat.getSystemService
//import androidx.core.content.FileProvider
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentTransaction
//import com.github.barteksc.pdfviewer.PDFView
//import com.shockwave.pdfium.BuildConfig
//import com.week6.openpdf.databinding.MainActivityBinding
//import java.io.File
//import java.io.FileOutputStream
//import java.io.IOException
//import java.io.InputStream
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var binding: MainActivityBinding
//    private var currentPageNumber = 0
//    private lateinit var sharedPreferences: SharedPreferences
//    private lateinit var sharedpref: SharedPreferences
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        sharedpref = getSharedPreferences("share_file", Context.MODE_PRIVATE)
//
//        var user_name: String = sharedpref.getString("Name", "").toString()
//
//        sharedPreferences = getPreferences(Context.MODE_PRIVATE)
//
////
//        // Get the pdfIdentifier from the intent
////        val pdfIdentifier = intent.getStringExtra("pdfIdentifierM")
////        Log.d("PDF_DEBUG", "PDF Identifier: $pdfIdentifier")
//        val pdfIdentifier = intent.getStringExtra("pdfIdentifierM")
//        Log.d("PDF_DEBUG", "PDF Identifier: $pdfIdentifier")
//
//        // Set FLAG_SECURE to prevent screenshots
////        //Window: Represents a window in an Android application. It is used to display the user interface and content of an activity or dialog.
////        // setFlags method: This method is used to set additional flags for the window.
////        //WindowManager.LayoutParams.FLAG_SECURE: This flag is used to make the window secure. When this flag is set, the content of the window will not be captured or recorded by screenshot applications or screen recording apps.
////        //By setting this flag, the application aims to protect sensitive information or content from being leaked through screenshots or screen recordings.
////        //Parameters of setFlags: The first parameter is the flag to be set, which is WindowManager.LayoutParams.FLAG_SECURE in this case.
////        //The second parameter is a mask that determines which bits in the window's flags will be affected by the operation. In this case, it's also WindowManager.LayoutParams.FLAG_SECURE.
////
//
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_SECURE,
//            WindowManager.LayoutParams.FLAG_SECURE
//        )
//
//        binding = MainActivityBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Retrieve the last viewed page number from SharedPreferences
//        currentPageNumber = sharedPreferences.getInt(pdfIdentifier, 0)
//
//        binding.openPdfButton.setOnClickListener {
//            binding.loadingProgressBar.visibility = View.VISIBLE
//
//            // Load the PDF using the pdfIdentifier and jump to the last viewed page
//            binding.pdfView.fromAsset(pdfIdentifier)
//                .defaultPage(currentPageNumber)  // Jump to the last viewed page
//                .onLoad {
//                    // Hide loading indicator when the PDF is loaded
//                    binding.loadingProgressBar.visibility = View.INVISIBLE
//                }
//                .onPageChange { page, pageCount ->
//                    // Update the current page number
//                    currentPageNumber = page
//                }
//                .load()
//        }
//
//        binding.backToMain.setOnClickListener {
//            // Save the last viewed page number to SharedPreferences
//
//            with(sharedPreferences.edit()) {
//                putInt(pdfIdentifier, currentPageNumber)
//                apply()
//            }
////            val f2: Fragment =FirstFragment()
////            val fragmentTransaction: FragmentTransaction =supportFragmentManager.beginTransaction()
////            fragmentTransaction.replace(R.id.fl_frame,f2).commit()
//            val i = Intent(this, FirstActivity::class.java)
//            startActivity(i)
//            finish()
//        }
//
//        binding.profile.setOnClickListener {
//            // Save the last viewed page number to SharedPreferences before navigating to ProfileActivity
//            with(sharedPreferences.edit()) {
//                putInt(pdfIdentifier+user_name, currentPageNumber)
//                apply()
//            }
////            val f2: Fragment =ProfileFragment()
////            val fragmentTransaction: FragmentTransaction =supportFragmentManager.beginTransaction()
////            fragmentTransaction.replace(R.id.fl_frame,f2).commit()
//            val intent = Intent(this, ProfileActivity::class.java)
//            startActivity(intent)
//        }
//    }
//    }


