package me.shohag.todo.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import me.shohag.todo.R
import me.shohag.todo.databinding.FragmentTasksBinding


class TasksFragment : Fragment() {
    private lateinit var _binding: FragmentTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTasksBinding.inflate(layoutInflater)

        _binding.addTaskButton.setOnClickListener {
            this.findNavController().navigate(
                R.id.action_tasksFragment_to_addTaskFragment
            )
        }

        return _binding.root
    }
}