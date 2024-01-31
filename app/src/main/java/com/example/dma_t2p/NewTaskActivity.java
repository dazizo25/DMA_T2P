package com.example.dma_t2p;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewTaskActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.dma_t2p.REPLY";

    private EditText mEditTaskName;
    private EditText mEditNumberOfTasks ;
    private EditText mEditTaskStartingDate;
    private EditText mEditTaskDueDate;
    private EditText mEditAssignmentID;
    private EditText mEditAssignmentName;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_new_task);
        mEditTaskName = findViewById(R.id.editTaskName);
        mEditNumberOfTasks = findViewById(R.id.editNumberOfTasks);
        mEditTaskStartingDate = findViewById(R.id.editTaskStartingDate);
        mEditTaskDueDate = findViewById(R.id.editTaskDueDate);
        mEditAssignmentID = findViewById(R.id.editAssignmentID);
        mEditAssignmentName = findViewById(R.id.editAssignmentName);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view ->{
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditTaskName.getText()) || TextUtils.isEmpty(mEditNumberOfTasks.getText()) || TextUtils.isEmpty(mEditTaskStartingDate.getText()) || TextUtils.isEmpty(mEditTaskDueDate.getText()) ||  TextUtils.isEmpty(mEditAssignmentID.getText()) ||  TextUtils.isEmpty(mEditAssignmentName.getText())){
                setResult(RESULT_CANCELED,replyIntent);
            } else {
                String taskName = mEditTaskName.getText().toString();
                int numberOFTasks = Integer.parseInt(mEditNumberOfTasks.getText().toString());
                String taskStartingDate = mEditTaskStartingDate.getText().toString();
                String taskDueDate = mEditTaskDueDate.getText().toString();
                int assignmentID = Integer.parseInt(mEditAssignmentID.getText().toString());
                String assignmentName = mEditAssignmentName.getText().toString();

                Bundle extras = new Bundle();
                extras.putString("EXTRA_TASK_NAME",taskName);
                extras.putInt("EXTRA_NUMBER_OF_TASKS",numberOFTasks);
                extras.putString("EXTRA_TASK_STARTING_DATE", taskStartingDate);
                extras.putString("EXTRA_TASK_DUE_DATE",taskDueDate);
                extras.putInt("EXTRA_ASSIGNMENT_ID",assignmentID);
                extras.putString("EXTRA_ASSIGNMENT_NAME",assignmentName);
                replyIntent.putExtras(extras);
                setResult(RESULT_OK,replyIntent);
            }
            finish();
        });
    }



}



