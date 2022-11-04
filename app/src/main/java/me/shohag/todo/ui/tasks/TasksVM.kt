package me.shohag.todo.ui.tasks


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import me.shohag.todo.data.TaskRepository
import me.shohag.todo.data.entity.Task
import javax.inject.Inject

@HiltViewModel
class TasksVM @Inject constructor(private val repository: TaskRepository) : ViewModel() {
    val tasks = repository.tasks

    fun updateTask(task: Task){
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }
//    fun allTasks(): Flow<PagingData<Task>> {
//        return Pager(PagingConfig(pageSize = 10)) {
//            repository.tasks
//        }.flow.cachedIn(viewModelScope)
//    }

}