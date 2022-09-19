package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.login.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty())
            {
                binding.etEmail.error="INGRESE EL CORREO lmorenom2021@cic.ipn.mx"
                binding.etEmail.requestFocus()
            }else if(password.isEmpty()){
                binding.etPassword.error="password KOTLIN"
                binding.etPassword.requestFocus()
            }else if(password=="KOTLIN" && email=="lmorenom2021@cic.ipn.mx"){
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }else{
                //Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                binding.etEmail.error="INGRESE EL CORREO lmorenom2021@cic.ipn.mx"
                binding.etPassword.error="password KOTLIN"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}