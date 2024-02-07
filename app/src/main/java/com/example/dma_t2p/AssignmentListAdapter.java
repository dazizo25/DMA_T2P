package com.example.dma_t2p;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class AssignmentListAdapter extends ListAdapter<Assignment, AssignmentViewHolder>{

    public AssignmentListAdapter(@NonNull DiffUtil.ItemCallback<Assignment> diffCallback){
        super(diffCallback);
    }
    @Override
    public AssignmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return AssignmentViewHolder.create(parent);
    }
    @Override
    public void onBindViewHolder(AssignmentViewHolder holder, int position){
        Assignment current = getItem(position);
        holder.bind(current);
    }
   public static class AssignmentDiff extends DiffUtil.ItemCallback<Assignment>{
       @Override
       public boolean areItemsTheSame(@NonNull Assignment oldItem, @NonNull Assignment newItem){
           return oldItem == newItem;
       }

       @Override
       public boolean areContentsTheSame (@NonNull Assignment oldItem,@NonNull Assignment newItem){
           return oldItem.getAssignmentName().equals(newItem.getAssignmentName());
       }
   }
}
