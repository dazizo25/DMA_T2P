package com.example.dma_t2p.Task;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.dma_t2p.Task.Task;

import java.util.List;

@Dao
public interface TaskDao {
@Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

@Query("DELETE FROM TASK_TABLE")
    void deleteAll();
@Query("SELECT * FROM TASK_TABLE ORDER BY ID ASC")
    LiveData<List<Task>> getAlphabetizedTasks();


}
