package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements onClickable {
    static String RESULT_KEY = "result_key";
    MainAdapter adapter;
    RecyclerView recyclerView;
    private ArrayList<SomeClass> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MainAdapter();
        adapter.listener = this;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        Button button=findViewById(R.id.buttonToStart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2Activity();
            }
        });

    }





    public void open2Activity() {
        Intent intent = new Intent(MainActivity.this, Main3Activity.class);
        startActivityForResult(intent, 1);
    }
    @Override
    public void onTextClick(int adapterPosition, SomeClass someClass) {
        list.remove(someClass);
        Intent intent=new Intent(this,Main3Activity.class);
        intent.putExtra("res",someClass);
        startActivityForResult(intent,1);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==RESULT_OK&&data!=null){
        SomeClass someClass = (SomeClass) data.getSerializableExtra(Main3Activity.TEXT_KEY_2);
list.add(someClass);
adapter.change(list);
adapter.notifyDataSetChanged();
    }}

}

