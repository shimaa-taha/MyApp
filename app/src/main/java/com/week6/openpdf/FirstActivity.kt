//package com.week6.openpdf
//
//import Adapter
//import android.content.Context
//import android.content.Intent
//import android.content.SharedPreferences
//
//import android.widget.TextView
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import com.week6.openpdf.FirstFragment
//import com.week6.openpdf.R
//import com.week6.openpdf.databinding.ActivityFirstBinding
//
//class FirstActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityFirstBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityFirstBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragmentContainer, FirstFragment())
//                .commit()
//        }
//    }
//}






package com.week6.openpdf

import Adapter
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.week6.openpdf.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var intent: Intent
    private lateinit var binding: ActivityFirstBinding
    private lateinit var sharedpref: SharedPreferences
    private var arrayList :ArrayList<class_data> = ArrayList()
    private lateinit var userItem2Dao: UserDoe


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedpref = getSharedPreferences("share_file", Context.MODE_PRIVATE)
        val user = sharedpref.getString("Name", "").toString()

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
//        binding.logout1.setOnClickListener()
//        {
//            val intent = Intent(this, ProfileActivity::class.java)
//            startActivity(intent)
//        }
        // Correct way to update the text of TextView
        binding.welcome.text = "welcome $user"

        arrayList.add(
            class_data(
                R.drawable.book7,
                "فاتتنى صلاة",
                "مؤلف:\tاسلام جمال\n" +
                        "قسم:\tأركان الإسلام والإيمان \n" +
                        "اللغة:\tالعربية\n" +
                        "الناشر:\tمؤسسة زحمة كتاب للثقافة والنشر\n" +
                        "الصفحات:\t215" ,"book_7.pdf"
            )
        )

        arrayList.add(class_data(R.drawable.book8,"رقائق القرآن",

            "مؤلف:\tابراهيم السكران\n" +
                    "قسم:\tعلوم القرآن الكريم والسنة النبوية \n" +
                    "اللغة:\tالعربية\n" +
                    "الصفحات:\t178\n","book_8.pdf"))



        arrayList.add(class_data(R.drawable.book6,"احوال المصطفى",
            "احوال المصطفى \n" +"مؤلف:\tمحمد صالح المنجد\n" +
                    "        قسم:\tالسيرة النبوية سيرة محمد صلى الله عليه وسلم [تعديل]\n" +
                    "        اللغة:\tالعربية\n" +
                    "        الصفحات:\t776"
                    ,"book_6.pdf"))

        arrayList.add(class_data(R.drawable.book5,"كن لنفسك كل شئ","كتاب كن لنفسك كل شيء\n" +
                "المؤلف : عمار الشمري\n" +
                "قسم : التنمية البشرية وتطوير الذات\n" + " عدد الصفحات : 288\n" ,"book_5.pdf"))

        arrayList.add(class_data(R.drawable.book2,"الوحش الذى يسكنك يمكن ان يكون لطيفا","كتاب :الوحش الذي يسكنك يمكن أن يكون لطيفًا\n" +"\n"+
                "المؤلف:إيناس سمير \n" + "الناشر : عصير الكتب للترجمة والنشر والتوزيع\n" +
                "عدد الصفحات: 264 \n" ,"book_2.pdf"))



        arrayList.add(class_data(R.drawable.book4,"ابتسم فأنت ميت",
            " المؤلف : حسن الجندي\n" +
                    " اﻟﺘﺼﻨﻴﻒ : الأدب العربي\n" +
                    " الفئة : روايات عربية\n" +
                    " عدد الصفحات : 308\n","book_4.pdf"))

        val r_v: RecyclerView =findViewById(R.id.recycler_view)
        r_v.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        val s= Adapter(arrayList)
        r_v.adapter=s

    }
    }
