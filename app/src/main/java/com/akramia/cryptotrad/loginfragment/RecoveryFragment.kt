package com.akramia.cryptotrad.loginfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.databinding.FragmentRecoveryBinding
import com.google.firebase.auth.FirebaseAuth

class RecoveryFragment : Fragment() {


    private lateinit var binding: FragmentRecoveryBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecoveryBinding.inflate(inflater, container, false)

        // Şifre sıfırlama tetikleyicisi
        binding.resetPasswordButton.setOnClickListener {
            val email = binding.emaillogin.text.toString().trim()  // E-posta adresini al

            if (email.isNotEmpty()) {  // E-posta boş değilse
                auth.sendPasswordResetEmail(email)  // Şifre sıfırlama isteği gönder
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(context, "Password reset email sent. Check your email.", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(context, "Email cannot be empty", Toast.LENGTH_SHORT).show()  // E-posta boşsa uyarı ver
            }
        }

        // Geri butonuna tıklandığında login sayfasına yönlendirin
        binding.BackButton.setOnClickListener {
            findNavController().navigate(R.id.action_recoveryFragment_to_loginFragment)
        }

        return binding.root
    }
}