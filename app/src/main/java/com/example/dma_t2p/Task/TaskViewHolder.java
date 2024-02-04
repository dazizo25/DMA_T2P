package com.example.dma_t2p.Task;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dma_t2p.R;

class TaskViewHolder extends RecyclerView.ViewHolder{
    private Task link;
    private final TextView taskItemView;
    private TaskViewHolder(View itemView){
        super(itemView);
        taskItemView = itemView.findViewById(R.id.textView);

    }
    public void bind(Task current){
        StringBuilder taskText = new StringBuilder();
        taskText.append(current.getTaskID()).append(" ");
        taskText.append(current.getTaskName()).append(" ");
        taskText.append(current.getTaskStartingDate()).append(" ");
        taskText.append(current.getTaskDueDate()).append(" ");
        taskText.append(current.getAssignmentID()).append(" ");
        taskText.append(current.getAssignmentName()).append(" ");

        taskItemView.setText(taskText);
        this.link = current;
    }

    static TaskViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_task, parent, false);
        return new TaskViewHolder(view);
    }

}
