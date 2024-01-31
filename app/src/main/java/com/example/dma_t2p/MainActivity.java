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
  public static final int NEW_TASK_ACTIVITY_REQUEST_CODE = 1;
  @Override
  protected void onCreate(Bundle savedInstanceState) {


    // Set up RecyclerView
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    RecyclerView recyclerView = findViewById(R.id.recyclerview);
    final TaskListAdapter adapter = new TaskListAdapter(new TaskListAdapter.TaskDiff());
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    mTaskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
    mTaskViewModel.getAllTasks().observe(this, task ->{
      adapter.submitList(task);
    });

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(view ->{
      Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);
      startActivityForResult(intent, NEW_TASK_ACTIVITY_REQUEST_CODE);
    });
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode,requestCode,data);
    if (requestCode == NEW_TASK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
      Task task = new Task(data.getStringExtra(NewTaskActivity.EXTRA_REPLY));
      mTaskViewModel.insert(task);
    } else{
      Toast.makeText(getApplicationContext(), R.string.empty_not_saved, Toast.LENGTH_LONG ).show();
    }
  }
}