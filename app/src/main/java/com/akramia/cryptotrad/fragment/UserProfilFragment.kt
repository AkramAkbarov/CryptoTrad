package com.akramia.cryptotrad.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.databinding.FragmentUserProfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore


class UserProfilFragment : Fragment() {
    private lateinit var binding: FragmentUserProfilBinding
    // Firebase Realtime Database bağlantısını tanımla
    private lateinit var database: FirebaseDatabase
    private lateinit var userReference: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth

    // Fragment içinde verileri çekmek için gerekli değişkenler
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // FirebaseAuth ve FirebaseDatabase nesnelerini başlat
        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        // Mevcut kullanıcıyı kontrol et
        val user = firebaseAuth.currentUser
        if (user == null) {
            Toast.makeText(context, "Hiçbir kullanıcı oturum açmamış", Toast.LENGTH_SHORT).show()
            return
        }

        // Kullanıcı referansını belirle
        userReference = database.reference.child("users").child(user.uid)

        // Kullanıcı profili verilerini çek
        fetchUserProfile()
    }
    private fun fetchUserProfile() {
        userReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Veriler var, kullanıcı e-posta bilgilerini al
                    val email = dataSnapshot.child("email").getValue(String::class.java) ?: "E-posta yok"
                    binding.emailTextView.text = email
                } else {
                    // Veri yoksa kullanıcıya bildirim yap
                    Toast.makeText(context, "Kullanıcı profili bulunamadı", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Firebase veri çekme işlemi başarısız oldu
                Toast.makeText(context, "Profil yüklenemedi: ${databaseError.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}