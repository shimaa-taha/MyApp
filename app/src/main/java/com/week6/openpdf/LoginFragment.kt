////package com.week6.openpdf
////
////import android.content.Context
////import android.content.Intent
////import android.content.SharedPreferences
////import android.os.Bundle
////import androidx.fragment.app.Fragment
////import android.view.LayoutInflater
////import android.view.View
////import android.view.ViewGroup
////import android.widget.Toast
////import androidx.fragment.app.FragmentTransaction
////import androidx.room.Room
////import com.week6.openpdf.databinding.FragmentLoginBinding
////
////class LoginFragment : Fragment() {
////    private var _binding: FragmentLoginBinding? = null
////    private val binding get() = _binding!!
////    private lateinit var sharedpref: SharedPreferences
////    private lateinit var taskDb: TaskDataBase
////
////
////    override fun onCreateView(
////        inflater: LayoutInflater, container: ViewGroup?,
////        savedInstanceState: Bundle?
////    ): View? {
////        sharedpref = requireContext().getSharedPreferences("share_file", Context.MODE_PRIVATE)
////        _binding = FragmentLoginBinding.inflate(inflater, container, false)
////        taskDb = Room.databaseBuilder(requireContext(), TaskDataBase::class.java, "task_database")
////            .fallbackToDestructiveMigration().allowMainThreadQueries().build()
////        var username = binding.firstName.text.toString()
////        var user_data = taskDb.dao().getuserName(username)
////
////        binding.bSignIn.setOnClickListener()
////        {
////
////            sharedpref.edit().putString("pass", binding.editPassword.text.toString()).apply()
////            if (user_data.userName.isEmpty() and user_data.password.isEmpty()) {
////                Toast.makeText(requireContext(), "please enter user", Toast.LENGTH_SHORT).show()
////            }
////            else if (user_data.password != binding.editPassword.text.toString()) {
////                Toast.makeText(requireContext(), "wrong password", Toast.LENGTH_SHORT).show()
////            }
////            else
////            {
////
////                val intent = Intent(requireContext(), FirstActivity::class.java)
////                startActivity(intent)
////                requireActivity().finish()
////            }
////        }
////        binding.bRegisterInLogin.setOnClickListener()
////        {
////            val f1: Fragment =RegisterFragment()
////            val fragmentTransaction: FragmentTransaction =parentFragmentManager.beginTransaction()
////            fragmentTransaction.replace(R.id.framelayout,f1).commit()
////        }
////        return binding.root
////        // }
////
////
////
////
////        // Inflate the layout for this fragment
////
////
////    }
////}
//
//import android.content.Context
//import android.content.Intent
//import android.content.SharedPreferences
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.FragmentTransaction
//import androidx.room.Room
//import com.week6.openpdf.FirstActivity
//import com.week6.openpdf.R
//
//import com.week6.openpdf.databinding.FragmentLoginBinding
//
//class LoginFragment : Fragment() {
//    private var _binding: FragmentLoginBinding? = null
//    private val binding get() = _binding!!
//    private lateinit var sharedpref: SharedPreferences
//    private lateinit var taskDb: TaskDataBase
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        sharedpref = requireContext().getSharedPreferences("share_file", Context.MODE_PRIVATE)
//        _binding = FragmentLoginBinding.inflate(inflater, container, false)
//
//        taskDb = Room.databaseBuilder(requireContext(), TaskDataBase::class.java, "task_database")
//            .fallbackToDestructiveMigration().allowMainThreadQueries().build()
//
//
//        binding.bSignIn.setOnClickListener {
//            val username = binding.firstName.text.toString()
//            val user_data = taskDb.dao()?.getuserName(username)
//
//            sharedpref.edit().putString("pass", binding.editPassword.text.toString()).apply()
//
//
//
//            if (user_data != null && user_data.userName.isNotEmpty() && user_data.password.isNotEmpty()) {
//                if (user_data.password != binding.editPassword.text.toString()) {
//                    Toast.makeText(requireContext(), "Wrong password", Toast.LENGTH_SHORT).show()
//                } else {
//                    // Login successful
//                    val intent = Intent(requireContext(), FirstActivity::class.java)
//                    startActivity(intent)
//                    requireActivity().finish()
//                }
//            } else {
//                Toast.makeText(requireContext(), "Please enter valid user", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        }
//
//
//            binding.bRegisterInLogin.setOnClickListener {
//            val f1: Fragment = RegisterFragment()
//            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.framelayout, f1).commit()
//        }
//
//        return binding.root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.room.Room
import com.week6.openpdf.FirstActivity

import com.week6.openpdf.FirstFragment
import com.week6.openpdf.R
import com.week6.openpdf.data.UserDataBase

import com.week6.openpdf.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedpref: SharedPreferences
    private lateinit var userDb: UserDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedpref = requireContext().getSharedPreferences("share_file", Context.MODE_PRIVATE)
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

//        try {
        userDb = Room.databaseBuilder(requireContext(), UserDataBase::class.java, "user_database")
                .fallbackToDestructiveMigration().allowMainThreadQueries().build()
//        } catch (e: Exception) {
//            e.printStackTrace()
//            // Handle the exception (e.g., log it) based on your requirements.
//            Toast.makeText(requireContext(), "Error initializing database", Toast.LENGTH_SHORT).show()
//        }

        binding.bSignIn.setOnClickListener {
            val username = binding.firstName.text.toString()
            val user_data = userDb.dao().getUserByUsername(username)
//

//
            if (user_data.isEmpty()) {
                Toast.makeText(requireContext(), "Wrong username", Toast.LENGTH_SHORT).show()
            } else if (user_data[0].password != binding.editPassword.text.toString()) {
                Toast.makeText(requireContext(), "Wrong password", Toast.LENGTH_SHORT).show()
            }
            else if(username.isEmpty()){
                Toast.makeText(requireContext(), "Please enter username", Toast.LENGTH_SHORT).show()
            }
            else if( binding.editPassword.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "Please enter password", Toast.LENGTH_SHORT).show()
            }

            else {
// Inside LoginFragment's bSignIn click listener

                sharedpref.edit().putString("Name", binding.firstName.text.toString()).apply()
                sharedpref.edit().putString("pass", binding.editPassword.text.toString()).apply()
//                val f2: Fragment =FirstFragment()
//                val fragmentTransaction: FragmentTransaction =parentFragmentManager.beginTransaction()
//                fragmentTransaction.replace(R.id.framelayout,f2).commit()
                val intent = Intent(requireContext(), FirstActivity::class.java)
                startActivity(intent)

            }
        }
//                }
//            } else {
//                Toast.makeText(requireContext(), "Please enter valid user", Toast.LENGTH_SHORT).show()
//            }
//        }

            binding.bRegisterInLogin.setOnClickListener {
//                val f2: Fragment =RegisterFragment()
//                val fragmentTransaction: FragmentTransaction =parentFragmentManager.beginTransaction()
//                fragmentTransaction.replace(R.id.fl_frame,f2).commit()
//                val intent = Intent(requireContext(), FirstActivity::class.java)
//                startActivity(intent)
                val f1: Fragment = RegisterFragment()
                val fragmentTransaction: FragmentTransaction =
                    parentFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.framelayout, f1).commit()
            }

            return binding.root
        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

