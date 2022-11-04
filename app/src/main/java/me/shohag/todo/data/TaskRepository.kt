package me.shohag.todo.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.shohag.todo.data.dao.TaskDao
import me.shohag.todo.data.entity.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDao: TaskDao) {
    val tasks = taskDao.getAllTasks()

    suspend fun insertTask(task: Task) {
        withContext(Dispatchers.IO) {
            taskDao.insert(task)
        }
    }

    suspend fun updateTask(task: Task) {
        withContext(Dispatchers.IO) {
            taskDao.update(task)
        }
    }
}