package com.example.dma_t2p.Assignment;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "assignment_Table")
public class Assignment {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID")
    private Integer assignmentID;

    @NonNull
    @ColumnInfo(name = "assignmentName")
    private String assignmentName;

    @NonNull
    @ColumnInfo(name = "assignmentNumberOFTasks")
    private Integer assignmentNumberOfTasks;

    @NonNull
    @ColumnInfo(name = "assignmentStatus")
    private String assignmentStatus;


    //geter and setters here
    //ADD COMs here


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

    @NonNull
    public Integer getAssignmentNumberOfTasks() {
        return assignmentNumberOfTasks;
    }

    public void setAssignmentNumberOfTasks(@NonNull Integer assignmentNumberOfTasks) {
        this.assignmentNumberOfTasks = assignmentNumberOfTasks;
    }

    @NonNull
    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(@NonNull String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    //genrated to string here ADD COMs here


    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentID=" + assignmentID +
                ", assignmentName='" + assignmentName + '\'' +
                ", assignmentNumberOfTasks=" + assignmentNumberOfTasks +
                ", assignmentStatus='" + assignmentStatus + '\'' +
                '}';
    }

    //constructor ADD COMs here

    public Assignment(@NonNull String assignmentName, @NonNull Integer assignmentNumberOfTasks, @NonNull String assignmentStatus) {
        this.assignmentName = assignmentName;
        this.assignmentNumberOfTasks = assignmentNumberOfTasks;
        this.assignmentStatus = assignmentStatus;
    }
}
