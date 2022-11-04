package me.shohag.todo.ui.add_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import me.shohag.todo.data.entity.Task
import me.shohag.todo.databinding.FragmentAddTaskBinding


@AndroidEntryPoint
class AddTaskFragment : Fragment() {
    private lateinit var _binding: FragmentAddTaskBinding
    private val viewModel: AddTaskVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTaskBinding.inflate(layoutInflater)

        _binding.backButton.setOnClickListener {
            this.findNavController().navigateUp()
        }

        _binding.addTaskButton.setOnClickListener {
            val taskTitle = _binding.titleText.text.toString()
            if (taskTitle.isNotEmpty()) {
                val task = Task(taskTitle = taskTitle)
                viewModel.insertTask(task)
                Toast.makeText(context, "Task added", Toast.LENGTH_SHORT).show()
                this.findNavController().navigateUp()
            }
        }

        return _binding.root
    }

}