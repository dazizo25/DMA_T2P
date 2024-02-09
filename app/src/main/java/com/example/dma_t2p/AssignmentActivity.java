package com.example.dma_t2p;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AssignmentActivity extends AppCompatActivity {
    private AssignmentViewModel mAssignmentViewModel;
    public static final int NEW_ASSIGNMENT_ACTIVITY_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_assignment);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final AssignmentListAdapter assignmentAdapter = new AssignmentListAdapter(new AssignmentListAdapter.AssignmentDiff());
        recyclerView.setAdapter(assignmentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAssignmentViewModel = new ViewModelProvider(this).get(AssignmentViewModel.class);
        mAssignmentViewModel.getAllAssignment().observe(this, assignments ->{
            assignmentAdapter.submitList(assignments);
                }
                );
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view ->{
            Intent intent = new Intent(AssignmentActivity.this, NewAssignmentActivity.class);
            startActivityForResult(intent,NEW_ASSIGNMENT_ACTIVITY_REQUEST_CODE);
        });
    }
    public void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == NEW_ASSIGNMENT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
        Bundle extras = data.getExtras();
        //todo this is an issue
        // int assignmentID = extras.getInt("EXTRA_ASSIGNMENT_ID");
        String assignmentName = extras.getString("EXTRA_ASSIGNMENT_NAME");
        int assignmentNumberOfTasks = extras.getInt("EXTRA_ASSIGNMENT_NUMBER_OF_TASKS");
        String assignmentStatus = extras.getString("EXTRA_ASSIGNMENT_STATUS");
        Assignment assignment = new Assignment(assignmentName,assignmentNumberOfTasks,assignmentStatus);

        mAssignmentViewModel.insert(assignment);
        }
        else{
            Toast.makeText(getApplicationContext(),R.string.empty_not_saved,Toast.LENGTH_LONG).show();
        }

    }
}
