package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView surnameInfo = (TextView)findViewById(R.id.surnameInfo);
        TextView nameInfo = (TextView)findViewById(R.id.nameInfo);
        TextView emailInfo = (TextView)findViewById(R.id.emailInfo);
        TextView passwordInfo = (TextView)findViewById(R.id.passwordInfo);
        int id = item.getItemId();
        switch (id){
            case R.id.next_page:
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.change_text:

                surnameInfo.setText("Surname: "+ "Kyrylyuk");
                nameInfo.setText("Name " + "Olya");
                emailInfo.setText("Email "+ "olya@gmail.com");
                passwordInfo.setText("Password "+"1111");
                break;
            case R.id.change_orientation:
                System.out.println("orientation: "+ getResources().getConfiguration().orientation);
                if (getResources().getConfiguration().orientation ==
                        Configuration.ORIENTATION_PORTRAIT)
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                else if (getResources().getConfiguration().orientation ==
                        Configuration.ORIENTATION_LANDSCAPE)
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        }
        return true;
    }

}