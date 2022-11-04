package me.shohag.todo.ui.add_task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.shohag.todo.data.TaskRepository
import me.shohag.todo.data.entity.Task
import javax.inject.Inject

@HiltViewModel
class AddTaskVM @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    fun insertTask(task: Task){
        viewModelScope.launch {
            repository.insertTask(task)
        }
    }

}