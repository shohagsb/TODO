package me.shohag.todo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import me.shohag.todo.data.dao.TaskDao
import me.shohag.todo.data.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract val taskDao: TaskDao
}