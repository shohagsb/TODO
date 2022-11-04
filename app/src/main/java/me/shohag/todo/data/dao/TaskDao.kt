package me.shohag.todo.data.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import me.shohag.todo.data.entity.Task


@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Query("SELECT * FROM tasks_table")
    fun getAllTasks(): LiveData<List<Task>>
//    fun getAllTasks(): PagingSource<Int, Task>
}