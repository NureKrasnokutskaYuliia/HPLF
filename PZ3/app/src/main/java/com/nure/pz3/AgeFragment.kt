package com.nure.pz3

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nure.pz3.databinding.FragmentAgeBinding
import java.util.Calendar

class AgeFragment : Fragment() {

    private var _binding: FragmentAgeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAgeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPickDate.setOnClickListener {
            val today = Calendar.getInstance()
            val initYear = today.get(Calendar.YEAR) - 20

            DatePickerDialog(requireContext(), { _, year, month, day ->
                val birth = Calendar.getInstance().apply { set(year, month, day) }
                val age = calculateAge(birth, today)
                binding.tvResult.text = "Вам $age ${ageWord(age)}"
            }, initYear, today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun calculateAge(birth: Calendar, today: Calendar): Int {
        var age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) age--
        return maxOf(0, age)
    }

    private fun ageWord(age: Int): String {
        val mod10 = age % 10
        val mod100 = age % 100
        return when {
            mod100 in 11..19 -> "років"
            mod10 == 1 -> "рік"
            mod10 in 2..4 -> "роки"
            else -> "років"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
