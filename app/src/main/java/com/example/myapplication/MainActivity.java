package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements onClickable {
    static String RESULT_KEY = "result_key";
    MainAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MainAdapter();
        adapter.listener = this;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
    }




    public void open2Activity(SomeClass someClass) {
        Intent intent = new Intent(MainActivity.this, Main3Activity.class);
        intent.putExtra(Main3Activity.TEXT_KEY_2, someClass);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onTextClick(SomeClass someClass) {
        open2Activity(someClass);
    }

    void changeData(SomeClass someClass) {
        adapter.change(someClass);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SomeClass someClass = (SomeClass) data.getSerializableExtra(RESULT_KEY);
        changeData(someClass);
    }

}
