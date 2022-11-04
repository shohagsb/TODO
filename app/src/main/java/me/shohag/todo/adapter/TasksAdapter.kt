package me.shohag.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.shohag.todo.data.entity.Task
import me.shohag.todo.databinding.ItemTaskBinding

class TasksAdapter(private val listener: TaskListener) :
    ListAdapter<Task, TasksAdapter.TaskVH>(DiffCallback) {

    class TaskVH private constructor(
        private val binding: ItemTaskBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task, listener: TaskListener) {
            binding.task = task
            binding.listener = listener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): TaskVH {
                val inflater = LayoutInflater.from(parent.context)
                val view = ItemTaskBinding.inflate(inflater, parent, false)
                return TaskVH(view)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.taskId == newItem.taskId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVH {
        return TaskVH.from(parent)
    }

    override fun onBindViewHolder(holder: TaskVH, position: Int) {
        holder.bind(getItem(position)!!, listener)
    }

}

class TaskListener(val listener: (task: Task) -> Unit) {
    fun onClick(task: Task) = listener(task)
}