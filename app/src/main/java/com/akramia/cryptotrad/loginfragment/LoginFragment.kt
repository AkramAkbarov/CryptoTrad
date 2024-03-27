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
import com.akramia.cryptotrad.databinding.FragmentLoginBinding
import com.akramia.cryptotrad.databinding.FragmentSignupBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException


class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        registerEvents()



    }




    private fun init(view: View){

        navController= Navigation.findNavController(view)
         auth=FirebaseAuth.getInstance()


    }
    private fun registerEvents(){



        binding.loginregsact.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)

        }


        binding.loginButton.setOnClickListener {
            val email= binding.emaillogin.text.toString().trim()
            val password=binding.passLog.text.toString().trim()



            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(context, "Login Successfully", Toast.LENGTH_SHORT).show()
                        navController.navigate(R.id.action_loginFragment_to_PiyasaFragment)
                    } else {
                        // Kullanıcı zaten kayıtlıysa, giriş yapma ekranına yönlendir
                        if (task.exception is FirebaseAuthUserCollisionException) {
                            navController.navigate(R.id.action_loginFragment_to_PiyasaFragment)
                        } else {
                            Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
        }
    }
/*binding.btn.setOnClickListener {
            val email= binding.emailEt.text.toString().trim()
            val password=binding.passEt.text.toString().trim()



            if (email.isNotEmpty()&&password.isNotEmpty()){

                    auto.createUserWithEmailAndPassword(email,password).addOnCompleteListener(
                        OnCompleteListener {
                            if (it.isSuccessful){
                                Toast.makeText(context,"Login Successfully", Toast.LENGTH_SHORT).show()
                                navController.navigate(R.id.action_signUpFragment_to_signInFragment)

                            }else{
                                Toast.makeText(context,it.exception?.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    )

            }
        }*/