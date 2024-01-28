package com.example.dma_t2p;
import androidx.annotation.StringRes;
import androidx.room.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;


//ADD COMs here
@Entity(tableName = "task_table")
public class Task {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID")
    private  Integer TaskID;

    @NonNull
    @ColumnInfo(name = "taskName")
    private String TaskName;

    @NonNull
    @ColumnInfo(name = "numberOfTasks" )
    private Integer NumberOfTasks;

    @NonNull
    @ColumnInfo(name = "taskStartingDate")
    private String TaskStartingDate;

    @NonNull
    @ColumnInfo(name = "taskDueDate")
    private String TaskDueDate;

    @NonNull
    @ColumnInfo(name = "assignmentID")
    private Integer AssignmentID;

    @NonNull
    @ColumnInfo (name = "assignmentName")
    private String AssignmentName;

 //genrated to string here ADD COMs here
    @Override
    public String toString() {
        return "Task{" +
                "TaskID=" + TaskID +
                ", TaskName='" + TaskName + '\'' +
                ", NumberOfTasks=" + NumberOfTasks +
                ", TaskStartingDate='" + TaskStartingDate + '\'' +
                ", TaskDueDate='" + TaskDueDate + '\'' +
                ", AssignmentID=" + AssignmentID +
                ", AssignmentName='" + AssignmentName + '\'' +
                '}';
    }

    //constructor ADD COMs here
    public Task(@NonNull Integer taskID, @NonNull String taskName, @NonNull Integer numberOfTasks, @NonNull String taskStartingDate, @NonNull String taskDueDate, @NonNull Integer assignmentID, @NonNull String assignmentName) {
        TaskID = taskID;
        TaskName = taskName;
        NumberOfTasks = numberOfTasks;
        TaskStartingDate = taskStartingDate;
        TaskDueDate = taskDueDate;
        AssignmentID = assignmentID;
        AssignmentName = assignmentName;
    }

    //geter and setters here
    //ADD COMs here
    @NonNull
    public Integer getTaskID() {
        return TaskID;
    }

    public void setTaskID(@NonNull Integer taskID) {
        TaskID = taskID;
    }

    @NonNull
    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(@NonNull String taskName) {
        TaskName = taskName;
    }

    @NonNull
    public Integer getNumberOfTasks() {
        return NumberOfTasks;
    }

    public void setNumberOfTasks(@NonNull Integer numberOfTasks) {
        NumberOfTasks = numberOfTasks;
    }

    @NonNull
    public String getTaskStartingDate() {
        return TaskStartingDate;
    }

    public void setTaskStartingDate(@NonNull String taskStartingDate) {
        TaskStartingDate = taskStartingDate;
    }

    @NonNull
    public String getTaskDueDate() {
        return TaskDueDate;
    }

    public void setTaskDueDate(@NonNull String taskDueDate) {
        TaskDueDate = taskDueDate;
    }

    @NonNull
    public Integer getAssignmentID() {
        return AssignmentID;
    }

    public void setAssignmentID(@NonNull Integer assignmentID) {
        AssignmentID = assignmentID;
    }

    @NonNull
    public String getAssignmentName() {
        return AssignmentName;
    }

    public void setAssignmentName(@NonNull String assignmentName) {
        AssignmentName = assignmentName;
    }


}



