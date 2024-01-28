package com.example.dma_t2p;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {
@Insert(onConflict = OnConflictStrategy.IGNORE)
Void insert(Task task);

@Query("DELETE FROM TASK_TABLE")
    void deleteAll();
@Query("SELECT * FROM TASK_TABLE ORDER BY ID ASC")
    LiveData<List<Task>> getAlphabetizedTasks();


}
