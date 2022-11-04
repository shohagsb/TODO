package me.shohag.todo.di_modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.shohag.todo.data.database.TaskDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodoModule {
    @Singleton
    @Provides
    fun provideTaskDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app.applicationContext, TaskDatabase::class.java, "task_database"
    ).fallbackToDestructiveMigration().build()// The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideTaskDao(db: TaskDatabase) = db.taskDao // The reason we can implement a Dao for the database
}