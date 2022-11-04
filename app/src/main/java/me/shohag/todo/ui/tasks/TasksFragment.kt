package me.shohag.todo.ui.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import me.shohag.todo.R
import me.shohag.todo.adapter.TaskListener
import me.shohag.todo.adapter.TasksAdapter
import me.shohag.todo.databinding.FragmentTasksBinding


@AndroidEntryPoint
class TasksFragment : Fragment() {
    private lateinit var _binding: FragmentTasksBinding
    private val viewModel: TasksVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTasksBinding.inflate(layoutInflater)

        _binding.addTaskButton.setOnClickListener {
            this.findNavController().navigate(
                R.id.action_tasksFragment_to_addTaskFragment
            )
        }
        getAllTasks()
        return _binding.root
    }

    private val adapter = TasksAdapter(TaskListener {
        val task = it
        task.isDone = true
        viewModel.updateTask(task)
    })

    private fun getAllTasks() {
        viewModel.tasks.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                _binding.notFoundText.visibility = View.VISIBLE
            } else {
                _binding.notFoundText.visibility = View.GONE
            }
            adapter.submitList(it)
            _binding.tasksRv.adapter = adapter
        }
    }
}