package com.example.grocery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocery.R;
import com.example.grocery.model.AllCategoryModel;

import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder> {
    Context context;
    List<AllCategoryModel> categoryList;

    public AllCategoryAdapter(Context context, List<AllCategoryModel> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public AllCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_category_row_items,parent,false);
        return new AllCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryViewHolder holder, int position) {
        holder.allCategoryImage.setImageResource(categoryList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class AllCategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView allCategoryImage;

        public AllCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            allCategoryImage =itemView.findViewById(R.id.allCategoryImage);
        }
    }
}
