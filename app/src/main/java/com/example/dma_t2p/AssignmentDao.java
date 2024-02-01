package com.example.dma_t2p;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

public interface AssignmentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Assignment assignment);

    @Query("DELETE FROM ASSIGNMENT_TABLE")
    void deleteAll();

    @Query("SELECT * FROM ASSIGNMENT_TABLE ORDER BY ID ASC")
    LiveData<List<Assignment>> getAlphabetizedAssignment();
}
