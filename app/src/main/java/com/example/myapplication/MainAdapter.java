package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder>{
  private ArrayList<SomeClass> data;
  onClickable listener;
  public MainAdapter(){
      data =new ArrayList<>();
  }

  public void change(ArrayList<SomeClass>someClass){
     data=someClass;
     notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_holder_main, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(v);
        viewHolder.listener=listener;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.bind(data.get(position));
        holder.listener=listener;
    }

    @Override
    public int getItemCount() {

      return data.size();
    }
}
