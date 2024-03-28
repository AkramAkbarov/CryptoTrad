package com.akramia.cryptotrad.loginfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.databinding.FragmentRecoveryBinding

class RecoveryFragment : Fragment() {

    private lateinit var binding:FragmentRecoveryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentRecoveryBinding.inflate(inflater,container,false)

        binding.BackButton.setOnClickListener{
            findNavController().navigate(R.id.action_recoveryFragment_to_loginFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}