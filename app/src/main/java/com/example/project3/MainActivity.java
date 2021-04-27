package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText Surname = findViewById(R.id.surname);
        final EditText Name = findViewById(R.id.name);
        final EditText Email = findViewById(R.id.email);
        final EditText Password = findViewById(R.id.password);
        final Button sendDataButton = findViewById(R.id.sendDataButton);
        ImageView popup = findViewById(R.id.popup);
        popup.setOnClickListener(viewClickListener);;
        final Button changeButton = findViewById(R.id.change);
        sendDataButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("Surname", Surname.getText().toString());
                intent.putExtra("Name", Name.getText().toString());
                intent.putExtra("Email", Email.getText().toString());
                intent.putExtra("Password", Password.getText().toString());
                startActivity(intent);
            }
        });

        changeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("orientation: "+ getResources().getConfiguration().orientation);
                if (getResources().getConfiguration().orientation ==
                        Configuration.ORIENTATION_PORTRAIT)
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                else if (getResources().getConfiguration().orientation ==
                        Configuration.ORIENTATION_LANDSCAPE)
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });
    }
    View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.next_page:
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
                break;
            case R.id.change_text:
                final EditText Surname = findViewById(R.id.surname);
                final EditText Name = findViewById(R.id.name);
                final EditText Email = findViewById(R.id.email);
                final EditText Password = findViewById(R.id.password);
                Surname.setText("Kyrylyuk");
                Name.setText("Olya");
                Email.setText("olya@gmail.com");
                Password.setText("1111");
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

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popup);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.next_page1:
                                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                                startActivity(intent);

                                return true;
                            case R.id.change_text1:
                                final EditText Surname = findViewById(R.id.surname);
                                final EditText Name = findViewById(R.id.name);
                                final EditText Email = findViewById(R.id.email);
                                final EditText Password = findViewById(R.id.password);
                                Surname.setText("Kyrylyuk");
                                Name.setText("Olya");
                                Email.setText("olya@gmail.com");
                                Password.setText("1111");

                                return true;
                            case R.id.toast:
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "One of the options from menu - Toast with the violet picture",
                                        Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                LinearLayout toastContainer = (LinearLayout) toast.getView();
                                ImageView tostImageView = new ImageView(getApplicationContext());
                                tostImageView.setImageResource(R.drawable.picture);
                                toastContainer.addView(tostImageView,0);
                                toast.show();
                                return true;

                            default:
                                return false;
                        }
                    }
                });

        popupMenu.show();
    }

}