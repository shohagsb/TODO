package me.shohag.todo.add_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import me.shohag.todo.R
import me.shohag.todo.databinding.FragmentAddTaskBinding


class AddTaskFragment : Fragment() {
    private lateinit var _binding: FragmentAddTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTaskBinding.inflate(layoutInflater)
        _binding.backButton.setOnClickListener {
            this.findNavController().navigateUp()
        }

        return _binding.root
    }

}