package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView mainInfo = (TextView)findViewById(R.id.mainInfo);
        TextView surnameInfo = (TextView)findViewById(R.id.surnameInfo);
        TextView nameInfo = (TextView)findViewById(R.id.nameInfo);
        TextView emailInfo = (TextView)findViewById(R.id.emailInfo);
        TextView passwordInfo = (TextView)findViewById(R.id.passwordInfo);
        String surname =  getIntent().getStringExtra("Surname");
        String name =  getIntent().getStringExtra("Name");
        String email =  getIntent().getStringExtra("Email");;
        String password =  getIntent().getStringExtra("Password");
        surnameInfo.setText("Results:");
        surnameInfo.setText("Surname: "+ surname);
        nameInfo.setText("Name " + name);
        emailInfo.setText("Email "+ email);
        passwordInfo.setText("Password "+password);
    }

}