package com.week6.openpdf

import Adapter
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.week6.openpdf.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var sharedpref: SharedPreferences
  //  private var arrayList: ArrayList<class_data> = ArrayList()
    //private lateinit var userItem2Dao: UserDoe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        sharedpref = requireActivity().getSharedPreferences("share_file", Context.MODE_PRIVATE)
//        val user = sharedpref.getString("Name", "").toString()
//
//        // Correct way to update the text of TextView
//        binding.welcome.text = "welcome $user"
//
//        arrayList.add(
//            class_data(
//                R.drawable.book7,
//                "فاتتنى صلاة",
//                "مؤلف:\tاسلام جمال\n" +
//                        "قسم:\tأركان الإسلام والإيمان \n" +
//                        "اللغة:\tالعربية\n" +
//                        "الناشر:\tمؤسسة زحمة كتاب للثقافة والنشر\n" +
//                        "الصفحات:\t215" ,"book_7.pdf"
//            )
//        )
//
//        arrayList.add(class_data(R.drawable.book8,"رقائق القرآن",
//
//            "مؤلف:\tابراهيم السكران\n" +
//                    "قسم:\tعلوم القرآن الكريم والسنة النبوية \n" +
//                    "اللغة:\tالعربية\n" +
//                    "الصفحات:\t178\n","book_8.pdf"))
//
//        arrayList.add(class_data(R.drawable.book6,"احوال المصطفى",
//            "احوال المصطفى \n" +"مؤلف:\tمحمد صالح المنجد\n" +
//                    "        قسم:\tالسيرة النبوية سيرة محمد صلى الله عليه وسلم [تعديل]\n" +
//                    "        اللغة:\tالعربية\n" +
//                    "        الصفحات:\t776"
//            ,"book_6.pdf"))
//
//        arrayList.add(class_data(R.drawable.book5,"كن لنفسك كل شئ","كتاب كن لنفسك كل شيء\n" +
//                "المؤلف : عمار الشمري\n" +
//                "قسم : التنمية البشرية وتطوير الذات\n" + " عدد الصفحات : 288\n" ,"book_5.pdf"))
//
//        arrayList.add(class_data(R.drawable.book2,"الوحش الذى يسكنك يمكن ان يكون لطيفا","كتاب :الوحش الذي يسكنك يمكن أن يكون لطيفًا\n" +"\n"+
//                "المؤلف:إيناس سمير \n" + "الناشر : عصير الكتب للترجمة والنشر والتوزيع\n" +
//                "عدد الصفحات: 264 \n" ,"book_2.pdf"))
//
//
//        arrayList.add(class_data(R.drawable.book4,"ابتسم فأنت ميت",
//            " المؤلف : حسن الجندي\n" +
//                    " اﻟﺘﺼﻨﻴﻒ : الأدب العربي\n" +
//                    " الفئة : روايات عربية\n" +
//                    " عدد الصفحات : 308\n","book_4.pdf"))
//
//        val r_v: RecyclerView = binding.recyclerView
//        r_v.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
//        val s = Adapter(arrayList)
//        r_v.adapter = s
    }
}


