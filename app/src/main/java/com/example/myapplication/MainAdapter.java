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
      for (int i = 1; i <=10 ; i++) {
          SomeClass someClass=new SomeClass();
          someClass.position=i;
          someClass.s=i+" ";
          data.add(someClass);
      }


  }public void change(SomeClass someClass){
      data.set(someClass.position,someClass);
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
    }

    @Override
    public int getItemCount() {

      return data.size();
    }
}
