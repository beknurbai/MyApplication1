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
private Intent intent;

SomeClass someClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
getInt();
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
Close();
            Intent intent=new Intent();
            intent.putExtra(TEXT_KEY_2,someClass);
            setResult(RESULT_OK,intent);
            finish();

        }
    });


        }public void getInt(){
        intent=getIntent();
        someClass=(SomeClass) intent.getSerializableExtra("res");
        if (someClass!=null){
            getText();
        }

    }


        public void Close() {
        someClass.s=editText.getText().toString();
        someClass.age = editAge.getText().toString();
        someClass.phone = editPhone.getText().toString();
        someClass.group = editGroup.getText().toString();

        }
    public void getText() {
        editText.setText(someClass.s);
editAge.setText(someClass.age);
editGroup.setText(someClass.group);
editPhone.setText(someClass.phone);

    }
}




