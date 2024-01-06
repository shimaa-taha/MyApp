package com.week6.openpdf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.week6.openpdf.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val img: ImageView =findViewById(R.id.waff)
        //val bt_back: Button =findViewById(R.id.back)
        val bt_read: Button =findViewById(R.id.bt_read)
        val bt_description: Button =findViewById(R.id.bt_desc)
        val order: TextView =findViewById(R.id.text_order)
//        val pdfIdentifier = intent.getStringExtra("pdfIdentifier")
//
//        Log.d("PDF_DEBUG_SECOND", "PDF Identifier in SecondActivity: $pdfIdentifier")

        // Inside second_activity
        bt_read.setOnClickListener {

            // In SecondActivity
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

        }
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
                else -> false
            }
        }

        val pdfIdentifier = intent.getStringExtra("pdfIdentifier")
        var image=intent.getIntExtra("image",0)
        var description_text=intent.getStringExtra("description")
        img.setImageResource(image)
        Log.d("PDF_DEBUG_SECOND", "PDF Identifier in SecondActivity: $pdfIdentifier")
//        bt_back.setOnClickListener(){
//
//            val i= Intent(this, FirstActivity::class.java)
//            startActivity(i)
//            finish()
//
//        }

        bt_description.setOnClickListener  ()
        {

            order.text=description_text.toString()

        }

        bt_read.setOnClickListener  ()
        {

            val i= Intent(this, MainActivity::class.java)
            i.putExtra("pdfIdentifierM", pdfIdentifier)

            startActivity(i)
            finish()

        }

    }
}