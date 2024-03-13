package com.akramia.cryptotrad.loginfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.akramia.cryptotrad.R

import com.google.firebase.auth.FirebaseAuth

import com.akramia.cryptotrad.databinding.FragmentSignupBinding
import com.bumptech.glide.Glide.init

class signupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var firebaseAuth:  FirebaseAuth
    private lateinit var navController: NavController



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        init(view)

        binding.SignUpBottom.setOnClickListener {
            navController.navigate(R.id.action_signupFragment_to_loginFragment)
        }

        binding.SignUpBottom.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.PasswordEt.text.toString()
            val verifyPass = binding.ConfirmPasswordEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && verifyPass.isNotEmpty()) {
                if (pass == verifyPass) {

                    registerUser(email, pass)

                } else {
                    Toast.makeText(context, "Password is not same", Toast.LENGTH_SHORT).show()
                }
            } else
                Toast.makeText(context, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
        }

    }

    private fun registerUser(email: String, pass: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
            if (it.isSuccessful)
                navController.navigate(R.id.action_signupFragment_to_loginFragment)
            else
                Toast.makeText(context, it.exception.toString(), Toast.LENGTH_SHORT).show()

        }
    }

    private fun init(view: View) {
        navController = Navigation.findNavController(view)
        firebaseAuth = FirebaseAuth.getInstance()
    }
    }

/*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView1.setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_signInFragment)
        }

        init(view)

        binding.buttonSignUp.setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_signInFragment)
        }

        binding.buttonSignUp.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.PassEt.text.toString()
            val verifyPass = binding.verifyPassEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && verifyPass.isNotEmpty()) {
                if (pass == verifyPass) {

                    registerUser(email, pass)

                } else {
                    Toast.makeText(context, "Password is not same", Toast.LENGTH_SHORT).show()
                }
            } else
                Toast.makeText(context, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
        }

    }

    private fun registerUser(email: String, pass: String) {
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
            if (it.isSuccessful)
                navController.navigate(R.id.action_signUpFragment_to_signInFragment)
            else
                Toast.makeText(context, it.exception.toString(), Toast.LENGTH_SHORT).show()

        }
    }

    private fun init(view: View) {
        navController = Navigation.findNavController(view)
        mAuth = FirebaseAuth.getInstance()
    }*/