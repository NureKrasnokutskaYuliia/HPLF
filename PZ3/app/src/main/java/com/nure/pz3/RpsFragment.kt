package com.nure.pz3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nure.pz3.databinding.FragmentRpsBinding
import kotlin.random.Random

class RpsFragment : Fragment() {

    private var _binding: FragmentRpsBinding? = null
    private val binding get() = _binding!!

    enum class Choice(val label: String, val emoji: String) {
        ROCK("Камінь", "🪨"),
        SCISSORS("Ножиці", "✂"),
        PAPER("Папір", "📄")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRpsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRock.setOnClickListener { play(Choice.ROCK) }
        binding.btnScissors.setOnClickListener { play(Choice.SCISSORS) }
        binding.btnPaper.setOnClickListener { play(Choice.PAPER) }
    }

    private fun play(player: Choice) {
        val computer = Choice.entries[Random.nextInt(Choice.entries.size)]
        val outcome = when {
            player == computer -> "🤝 Нічия!"
            beats(player, computer) -> "🎉 Ви перемогли!"
            else -> "💻 Комп'ютер переміг!"
        }
        binding.tvResult.text = "Ви: ${player.emoji} ${player.label}\nКомп'ютер: ${computer.emoji} ${computer.label}\n\n$outcome"
    }

    private fun beats(a: Choice, b: Choice) =
        (a == Choice.ROCK && b == Choice.SCISSORS) ||
        (a == Choice.SCISSORS && b == Choice.PAPER) ||
        (a == Choice.PAPER && b == Choice.ROCK)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
