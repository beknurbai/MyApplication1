package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {
EditText editText,editAge,editGroup,editPhone;
public static String TEXT_KEY_2="text_key";
SomeClass someClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=findViewById(R.id.editTextName);
        editGroup = findViewById(R.id.editTextGroup);
        editPhone = findViewById(R.id.editTextNumber);
        editAge = findViewById(R.id.editTextAge);
        Button save=findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent=new Intent();
            someClass.s=editText.getText().toString();
            intent.putExtra(MainActivity.RESULT_KEY,someClass);
            setResult(RESULT_OK,intent);
            finish();

        }
    });
        if (getIntent()!=null){
        someClass=(SomeClass) getIntent().getSerializableExtra(TEXT_KEY_2);
        editText.setText(someClass.s);
                someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY_2);
                editAge.setText(someClass.age);
                someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY_2);
                editPhone.setText(someClass.phone);
                someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY_2);
                editGroup.setText(someClass.group);


        }}
        public void Close(View v) {

            someClass.age = editAge.getText().toString();
            someClass.phone = editPhone.getText().toString();
            someClass.group = editGroup.getText().toString();


            TextView age = (TextView) findViewById(R.id.editTextAge);
            age.setText(someClass.age);
            TextView phone = (TextView) findViewById(R.id.editTextNumber);
            phone.setText(someClass.phone);
            TextView group = (TextView) findViewById(R.id.editTextGroup);
            group.setText(someClass.age);

        }}

