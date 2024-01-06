//package com.week6.openpdf
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.Toast
//import androidx.room.Room
//import com.week6.openpdf.databinding.FragmentLoginBinding
//
//class RegisterFragment : Fragment() {
//    private var _binding: FragmentLoginBinding? = null
//    private val binding get() = _binding!!
//    private lateinit var taskDb: TaskDataBase
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val signup:Button=view.findViewById(R.id.sign_up)
//        _binding = FragmentLoginBinding.inflate(inflater, container, false)
//
//        taskDb = Room.databaseBuilder(requireContext(), TaskDataBase::class.java, "task_database")
//            .fallbackToDestructiveMigration().allowMainThreadQueries().build()
//        signup.setOnClickListener {
//            val username = binding.firstName.text.toString()
//            val user_data = taskDb.dao().getuserName(username)
//
//
//
//            if (user_data == null || (user_data.userName.isNotEmpty() && user_data.password.isNotEmpty())) {
//                if (user_data.password != binding.editPassword.text.toString()) {
//                    Toast.makeText(requireContext(), "Wrong password", Toast.LENGTH_SHORT).show()
//                } else {
//                    val intent = Intent(requireContext(), FirstActivity::class.java)
//                    startActivity(intent)
//                    requireActivity().finish()
//                }
//            } else {
//                Toast.makeText(requireContext(), "Please enter valid user", Toast.LENGTH_SHORT).show()
//            }
//        }
//        return binding.root
//    }
//
//}

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.room.Room
import com.week6.openpdf.FirstActivity
import com.week6.openpdf.FirstFragment

import com.week6.openpdf.R
import com.week6.openpdf.data.UserDataBase
import com.week6.openpdf.databinding.FragmentSignUpBinding
import com.week6.openpdf.models.userItem

class RegisterFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedpref: SharedPreferences

    private var userDb: UserDataBase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedpref = requireContext().getSharedPreferences("share_file", Context.MODE_PRIVATE)
        userDb = Room.databaseBuilder(requireContext(), UserDataBase::class.java, "user_database")
            .fallbackToDestructiveMigration().allowMainThreadQueries().build()

        val signUpButton: Button = view.findViewById(R.id.sign_up)

        signUpButton.setOnClickListener {
            val username = binding.firstNameRegister.text.toString()
            val password = binding.editPasswordRegister.text.toString()
            val email=binding.email.text.toString()

            var user=userDb!!.dao().getUserByUsername(username)
            if(username.isEmpty()){
                Toast.makeText(requireContext(), "please enter your name", Toast.LENGTH_SHORT).show()
            }
           else if(password.isEmpty()){
                Toast.makeText(requireContext(), "please your password should be at least 6 character ", Toast.LENGTH_SHORT).show()

            }
            else if(email.isEmpty()){
                Toast.makeText(requireContext(), "please enter your email ", Toast.LENGTH_SHORT).show()

            }
            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                // Email is not valid
                Toast.makeText(requireContext(), "enter valid mail", Toast.LENGTH_LONG).show()
            }
            else if (user.isNotEmpty()) {
                Toast.makeText(requireContext(), "this user is already exist try another", Toast.LENGTH_SHORT).show()
            }

           else {
                // val date_task=" "
                sharedpref.edit().putString("Name", username).apply()
                sharedpref.edit().putString("pass",password).apply()
                sharedpref.edit().putString("email",email).apply()
                // User doesn't exist, so register
                val newUser = userItem(0, username, password)
                userDb!!.dao()?.insertItem(newUser)
                val intent = Intent(requireContext(), FirstActivity::class.java)
                startActivity(intent)
//                val f2: Fragment =FirstFragment()
//                val fragmentTransaction: FragmentTransaction =parentFragmentManager.beginTransaction()
//                fragmentTransaction.replace(R.id.framelayout,f2).commit()

            }
        }
    }
}

