package com.akramia.cryptotrad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.akramia.cryptotrad.databinding.FragmentDetailsBinding
import com.akramia.cryptotrad.databinding.FragmentLogRegBinding
import com.akramia.cryptotrad.databinding.FragmentPiyasaBinding

class LogRegFragment : Fragment() {

    private lateinit var binding: FragmentLogRegBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLogRegBinding.inflate(inflater)

        binding.imageView7.setOnClickListener{
            findNavController().navigate(R.id.action_logRegFragment_to_loginFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}