package com.nure.pz3

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nure.pz3.databinding.FragmentSecondsBinding
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.Calendar

class SecondsFragment : Fragment() {

    private var _binding: FragmentSecondsBinding? = null
    private val binding get() = _binding!!

    // 11:30 on May 2, 366 BCE — year -365 in proleptic Gregorian (0 = 1 BCE, -365 = 366 BCE)
    private val startDateTime = LocalDateTime.of(-365, 5, 2, 11, 30, 0)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSecondsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPickDate.setOnClickListener {
            val today = Calendar.getInstance()
            DatePickerDialog(requireContext(), { _, year, month, day ->
                val endDateTime = LocalDateTime.of(year, month + 1, day, 12, 0, 0)
                val seconds = ChronoUnit.SECONDS.between(startDateTime, endDateTime)
                binding.tvResult.text = "$seconds\nсекунд"
            }, today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
