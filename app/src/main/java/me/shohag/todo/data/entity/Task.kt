package me.shohag.todo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,
    @ColumnInfo(name = "task_title")
    var taskTitle: String = "",
    @ColumnInfo(name = "is_done")
    var isDone: Boolean = false,
    @ColumnInfo(name = "add_time_milli")
    val addTimeMilli: Long = System.currentTimeMillis()
)
