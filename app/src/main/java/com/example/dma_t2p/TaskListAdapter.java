package com.example.dma_t2p;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class TaskListAdapter extends ListAdapter<Task,TaskViewHolder> {
    public TaskListAdapter(@NonNull DiffUtil.ItemCallback<Task> diffCallback){
        super(diffCallback);
    }


    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TaskViewHolder.create(parent);
    }

    // need to cheak what its asking here
    // here i am using TaskName not TaskID need to check which one is the right one
    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
    Task current = getItem(position);
    holder.bind(current.getTaskName());

    }
    static class TaskDiff extends DiffUtil.ItemCallback<Task>{

        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getTaskName().equals(newItem.getTaskName());
        }
    }

}
