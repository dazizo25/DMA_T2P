package com.example.dma_t2p.Assignment;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class AssignmentRepository {
    private AssignmentDao mAssignmentDao;
    private LiveData<List<Assignment>> mAllAssignment;

    AssignmentRepository(Application application) {
        AssignmentRoomDatabase db = AssignmentRoomDatabase.getDatabase(application);
        mAssignmentDao = db.assignmentDao();
        mAllAssignment = mAssignmentDao.getAlphabetizedAssignment();
    }
    LiveData<List<Assignment>> getAllAssignment(){
        return mAllAssignment;
    }
    void insert(Assignment assignment) {
        AssignmentRoomDatabase.databaseWriteExecutor.execute(() ->{
            mAssignmentDao.insert(assignment);
        });
    }
}
