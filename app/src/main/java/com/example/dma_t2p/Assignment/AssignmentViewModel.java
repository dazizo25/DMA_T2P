package com.example.dma_t2p.Assignment;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AssignmentViewModel extends AndroidViewModel {
    private AssignmentRepository mRepository;
    private final LiveData<List<Assignment>> mAllAssignment;

    public AssignmentViewModel (Application application){
        super(application);
        mRepository = new AssignmentRepository(application);
        mAllAssignment = mRepository.getAllAssignment();
            }

    public LiveData<List<Assignment>> getAllAssignment() {return mAllAssignment;}
    public void insert(Assignment assignment){mRepository.insert(assignment);}
}
