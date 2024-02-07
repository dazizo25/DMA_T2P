package com.example.dma_t2p;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
  private TaskViewModel mTaskViewModel;
  private AssignmentViewModel mAssignmentViewModel;
  public static final int NEW_TASK_ACTIVITY_REQUEST_CODE = 1;
  @Override
  protected void onCreate(Bundle savedInstanceState) {


    // Set up RecyclerView
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    RecyclerView recyclerView = findViewById(R.id.recyclerview);

    final TaskListAdapter taskAdapter = new TaskListAdapter(new TaskListAdapter.TaskDiff());
    recyclerView.setAdapter(taskAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    mTaskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
    mTaskViewModel.getAllTasks().observe(this, task ->{
      taskAdapter.submitList(task);
    });

    // Set up RecyclerView
    final AssignmentViewModel assignmentAdapter = new AssignmentViewModel(new AssignmentListAdapter.AssignmentDiff());
    recyclerView.setAdapter(assignmentAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    mAssignmentViewModel = new ViewModelProvider(this).get(AssignmentViewModel.class);
    mAssignmentViewModel.getAllAssignments().observe(this, assignments -> {
              assignmentAdapter.submitList(assignments);
    });



    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(view ->{
      Intent intent = new Intent(MainActivity.this, NewTaskActivity.class );
      startActivityForResult(intent, NEW_TASK_ACTIVITY_REQUEST_CODE);
    });
  }

  FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(view ->{
    Intent intent = new Intent(MainActivity.this, NewAssignmentActivity.class );
    startActivityForResult(intent, NEW_TASK_ACTIVITY_REQUEST_CODE);
  });
}

  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode,requestCode,data);
    if (requestCode == NEW_TASK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
      Bundle extras =data.getExtras();
      String taskName = extras.getString("EXTRA_TASK_NAME");
      int numberOfTask = extras.getInt("EXTRA_NUMBER_OF_TASKS");
      String taskStartingDate = extras.getString("EXTRA_TASK_STARTING_DATE");
      String taskDueDate = extras.getString("EXTRA_TASK_DUE_DATE");
      int assignmentID = extras.getInt("EXTRA_ASSIGNMENT_ID");
      String assignmentName = extras.getString("EXTRA_ASSIGNMENT_NAME");
      Task task = new Task(taskName,numberOfTask,taskStartingDate,taskDueDate,assignmentID,assignmentName);
      mTaskViewModel.insert(task);
    } else{
      Toast.makeText(getApplicationContext(), R.string.empty_not_saved, Toast.LENGTH_LONG ).show();
    }
  }
}