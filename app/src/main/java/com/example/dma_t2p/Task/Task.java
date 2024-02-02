package com.example.dma_t2p.Task;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//ADD COMs here
@Entity(tableName = "task_table")
public class Task {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID")
    private Integer taskID;

    @NonNull
    @ColumnInfo(name = "taskName")
    private String taskName;

    @NonNull
    @ColumnInfo(name = "numberOfTasks" )
    private Integer numberOfTasks;

    @NonNull
    @ColumnInfo(name = "taskStartingDate")
    private String taskStartingDate;

    @NonNull
    @ColumnInfo(name = "taskDueDate")
    private String taskDueDate;

    @NonNull
    @ColumnInfo(name = "assignmentID")
    private Integer assignmentID;

    @NonNull
    @ColumnInfo (name = "assignmentName")
    private String assignmentName;





    //geter and setters here
    //ADD COMs here

    @NonNull
    public Integer getTaskID() {
        return taskID;
    }
    public void setTaskID(@NonNull Integer taskID) {
        this.taskID = taskID;
    }

    @NonNull
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(@NonNull String taskName) {
        this.taskName = taskName;
    }

    @NonNull
    public Integer getNumberOfTasks() {
        return numberOfTasks;
    }

    public void setNumberOfTasks(@NonNull Integer numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    @NonNull
    public String getTaskStartingDate() {
        return taskStartingDate;
    }

    public void setTaskStartingDate(@NonNull String taskStartingDate) {
        this.taskStartingDate = taskStartingDate;
    }

    @NonNull
    public String getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(@NonNull String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    @NonNull
    public Integer getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(@NonNull Integer assignmentID) {
        this.assignmentID = assignmentID;
    }

    @NonNull
    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(@NonNull String assignmentName) {
        this.assignmentName = assignmentName;
    }





    //genrated to string here ADD COMs here
    @Override
    public String toString() {
        return "Task{" +
                "taskID=" + taskID +
                ", taskName='" + taskName + '\'' +
                ", numberOfTasks=" + numberOfTasks +
                ", taskStartingDate='" + taskStartingDate + '\'' +
                ", taskDueDate='" + taskDueDate + '\'' +
                ", assignmentID=" + assignmentID +
                ", assignmentName='" + assignmentName + '\'' +
                '}';
    }


    //constructor ADD COMs here


    public Task(@NonNull String taskName, @NonNull Integer numberOfTasks, @NonNull String taskStartingDate, @NonNull String taskDueDate, @NonNull Integer assignmentID, @NonNull String assignmentName) {
        this.taskName = taskName;
        this.numberOfTasks = numberOfTasks;
        this.taskStartingDate = taskStartingDate;
        this.taskDueDate = taskDueDate;
        this.assignmentID = assignmentID;
        this.assignmentName = assignmentName;
    }
}



