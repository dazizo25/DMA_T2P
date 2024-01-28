package com.example.dma_t2p;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
   private TaskRepository mRepository;
   private  final LiveData<List<Task>> mAllTasks;

   public  TaskViewModel (Application application){
       super(application);
       mRepository = new TaskRepository(application);
       mAllTasks = mRepository.getAlltasks();

   }
   LiveData<List<Task>> getmAllTasks() {return mAllTasks;}
    public void insert(Task task){mRepository.insert(task);}
}
