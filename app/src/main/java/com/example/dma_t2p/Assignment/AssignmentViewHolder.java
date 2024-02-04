package com.example.dma_t2p.Assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dma_t2p.R;

class AssignmentViewHolder extends RecyclerView.ViewHolder {
    private Assignment link;
    private Assignment assignment;
    private final TextView assignmentItemView;
    private AssignmentViewHolder(View itemView){
        super(itemView);
        //need to add find viewByIdn here
        assignmentItemView = itemView.findViewById();
    }
    public void bind(Assignment current){
        StringBuilder assignmentText = new StringBuilder();
        assignmentText.append(current.getAssignmentID()).append(" ");
        assignmentText.append(current.getAssignmentName()).append(" ");
        assignmentText.append(current.getAssignmentNumberOfTasks()).append(" ");
        assignmentText.append(current.getAssignmentStatus()).append(" ");

        assignmentItemView.setText(assignmentText);
        this.link = current;
    }
    static AssignmentViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_task, parent,false);
        return new AssignmentViewHolder(view);
    }
}
