package com.example.dma_t2p;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewAssignmentActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.dma_t2p.REPLY";


    private EditText mEditAssignmentID;
    private EditText mEditAssignmentName;
    private EditText mEditAssignmentNumberOfTasks ;
    private EditText mEditTAssignmentStatus;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_new_assignment);
        //not sure if that here is right
        mEditAssignmentID = findViewById(R.id.editAssignmentID);
        mEditAssignmentName = findViewById(R.id.editAssignmentName);
        mEditAssignmentNumberOfTasks = findViewById(R.id.editAssignmentNumberOfTasks);
        mEditTAssignmentStatus = findViewById(R.id.editAssignmentStatus);


        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view ->{
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditAssignmentID.getText())|| TextUtils.isEmpty(mEditAssignmentName.getText()) || TextUtils.isEmpty(mEditAssignmentNumberOfTasks.getText()) || TextUtils.isEmpty(mEditTAssignmentStatus.getText()) ){
                setResult(RESULT_CANCELED,replyIntent);
            } else {

                String assignmentName = mEditAssignmentName.getText().toString();
                int assignmentNumberOfTasks =Integer.parseInt(mEditAssignmentNumberOfTasks.getText().toString());
                String assignmentStatus = mEditTAssignmentStatus.getText().toString();
                int assignmentID = Integer.parseInt(mEditAssignmentID.getText().toString());


                Bundle extras = new Bundle();
                extras.putInt("EXTRA_ASSIGNMENT_ID",assignmentID);
                extras.putString("EXTRA_ASSIGNMENT_NAME",assignmentName);
                extras.putInt("EXTRA_ASSIGNMENT_NUMBER_OF_TASKS",assignmentNumberOfTasks);
                extras.putString("EXTRA_ASSIGNMENT_STATUS",assignmentStatus);

                replyIntent.putExtras(extras);
                setResult(RESULT_OK,replyIntent);
            }
            finish();
        });
    }



}



