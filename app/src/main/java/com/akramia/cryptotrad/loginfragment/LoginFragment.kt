package com.akramia.cryptotrad.loginfragment

import android.content.Intent
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
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.GoogleAuthProvider


class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController
    private lateinit var googleSignInClient: GoogleSignInClient

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

    private fun init(view: View) {
        navController = Navigation.findNavController(view)
        auth = FirebaseAuth.getInstance()

        // Google ile oturum açma istemcisi yapılandırması
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
    }

    private fun registerEvents() {
        binding.loginregsact.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

        binding.textView4.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_recoveryFragment)
        }

        binding.loginButton.setOnClickListener {
            val email = binding.emaillogin.text.toString().trim()
            val password = binding.passLog.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(context, "Login Successfully", Toast.LENGTH_SHORT).show()
                            navController.navigate(R.id.action_loginFragment_to_PiyasaFragment)
                        } else {
                            Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
            }


        }

        binding.imageView6.setOnClickListener {
            signInWithGoogle()
        }
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    companion object {
        private const val RC_SIGN_IN = 9001
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                // Google hesabıyla Firebase'e oturum açma
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Toast.makeText(
                    context,
                    "Google Sign In Failed: ${e.statusCode}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Firebase ile Google hesabıyla oturum açma başarılı
                    Toast.makeText(context, "Google Sign In Successful", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.action_loginFragment_to_PiyasaFragment)
                } else {
                    Toast.makeText(context, "Google Sign In Failed", Toast.LENGTH_SHORT).show()
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