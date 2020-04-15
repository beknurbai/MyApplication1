package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {
onClickable listener;
    private TextView textView;
    private SomeClass someClass;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.vh_text_view);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTextClick(someClass);
            }
        });
    }



    public void bind (SomeClass someClass) {
        this.someClass=someClass;
        textView.setText(someClass.s);

    }
}
