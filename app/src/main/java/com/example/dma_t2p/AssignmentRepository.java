package com.example.dma_t2p;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class AssignmentRepository {
    private AssignmentDao mAssignmentDao;
    private LiveData<List<Assignment>> mAllAssignment;

    AssignmentRepository(Application application) {
        TaskRoomDatabase db = TaskRoomDatabase.getDatabase(application);
        mAssignmentDao = db.assignmentDao();
        mAllAssignment = mAssignmentDao.getAlphabetizedAssignment();
    }
    LiveData<List<Assignment>> getAllAssignment(){
        return mAllAssignment;
    }
    void insert(Assignment assignment) {
        TaskRoomDatabase.databaseWriteExecutor.execute(() ->{
            mAssignmentDao.insert(assignment);
        });
    }
}
