package com.example.dma_t2p.Assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dma_t2p.R;
import com.example.dma_t2p.Task.Task;

class AssignmentViewHolder extends RecyclerView.ViewHolder {
    private Assignment link;
    private Assignment assignment;
    private final TextView assignmentItemView;
    private AssignmentViewHolder(View itemView){
        super(itemView);
        //need to add find viewByIdn here
        assignmentItemView = itemView.findViewById();
    }
    public void bind(Assignment currnet){
        StringBuilder assignmentText = new StringBuilder();
        assignmentText.append(currnet.getAssignmentID()).append(" ");
        assignmentText.append(currnet.getAssignmentName()).append(" ");
        assignmentText.append(currnet.getAssignmentNumberOfTasks()).append(" ");
        assignmentText.append(currnet.getAssignmentStatus()).append(" ");

        assignmentItemView.setText(assignmentText);
        this.link = currnet;
    }
    static AssignmentViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent,false);
        return new AssignmentViewHolder(view);
    }
}
