package com.week6.openpdf

import LoginFragment
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.week6.openpdf.databinding.FragmentProfileBinding
import com.week6.openpdf.databinding.FragmentSignUpBinding
class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!
    private lateinit var sharedpref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedpref = requireContext().getSharedPreferences("share_file", Context.MODE_PRIVATE)
         var user_name:String=sharedpref.getString("Name","").toString()
         var user_pass:String=sharedpref.getString("pass","").toString()
         var user_email:String=sharedpref.getString("email","").toString()

      if( user_name.isNotEmpty()){
            binding.yourname.text="your name is : "+user_name
        }
        if( user_pass.isNotEmpty()){
            binding.yourpassword.text="your password is : "+user_pass
        }
        if( user_email.isNotEmpty()){
            binding.yourmail.text="email: \n "+user_email
        }

        binding.logout.setOnClickListener {
            // Handle logout logic here
            sharedpref.edit().putString("pass", "").apply()
            sharedpref.edit().putString("Name", "").apply()

          //  sharedpref.edit().putString("email", "").apply()
//            val f2: Fragment =LoginFragment()
//            val fragmentTransaction: FragmentTransaction =parentFragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.fl_frame,f2).commit()

            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }
    }

}