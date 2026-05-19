package com.nure.pz3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import com.nure.pz3.databinding.FragmentPrimeBinding

class PrimeFragment : Fragment() {

    private var _binding: FragmentPrimeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPrimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFind.setOnClickListener { findPrime() }
        binding.etNumber.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) { findPrime(); true } else false
        }
    }

    private fun findPrime() {
        val n = binding.etNumber.text.toString().toIntOrNull()
        if (n == null || n < 1) {
            binding.tvResult.text = "Введіть натуральне число"
            return
        }
        val prime = nthPrime(n)
        binding.tvResult.text = "$prime"
        binding.tvResult.contentDescription = "${n}-е просте число: $prime"
    }

    private fun nthPrime(n: Int): Long {
        var count = 0
        var num = 1L
        while (count < n) {
            num++
            if (isPrime(num)) count++
        }
        return num
    }

    private fun isPrime(n: Long): Boolean {
        if (n < 2L) return false
        if (n == 2L) return true
        if (n % 2 == 0L) return false
        var i = 3L
        while (i * i <= n) {
            if (n % i == 0L) return false
            i += 2
        }
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
