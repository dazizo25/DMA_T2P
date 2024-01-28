package com.example.dma_t2p;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class TaskRepository {
    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTasks;

    TaskRepository(Application application) {
        TaskRoomDatabase db = TaskRoomDatabase.getDatabase(application);
        mTaskDao = db.taskDao();
        mAllTasks = mTaskDao.getAlphabetizedTasks();
    }
    LiveData<List<Task>> getAlltasks(){
        return mAllTasks;
    }
    void insert(Task task) {
        TaskRoomDatabase.databaseWriteExecutor.execute(() ->{
    mTaskDao.insert(task);
        });
    }
}
