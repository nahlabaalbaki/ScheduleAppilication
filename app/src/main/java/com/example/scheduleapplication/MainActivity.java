package com.example.scheduleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);

        try {
            SQLiteDatabase sql = this.openOrCreateDatabase("scheduleapp", MODE_PRIVATE, null);
            sql.execSQL("CREATE Table IF NOT EXISTS courses(name VARCHAR, website VARCHAR)");

            sql.execSQL("INSERT INTO courses(name,wesbite) VALUES ('Mobile Development','https://ionicframework.com/')");
            sql.execSQL("INSERT INTO courses(name,wesbite) VALUES ('Game Programming','https://unity.com/')");
            sql.execSQL("INSERT INTO courses(name,wesbite) VALUES ('Parallel Programming','https://www.open-mpi.org/')");
            sql.execSQL("INSERT INTO courses(name,wesbite) VALUES ('Natural Language Processing','https://www.nlp.com/what-is-nlp/')");


            Cursor c = sql.rawQuery("SELECT * from courses", null);
            int nameindex = c.getColumnIndex("name");
            int webindex = c.getColumnIndex("website");
            c.moveToFirst();

            while (c != null) {
                if (button1.getText() == "") {
                    button1.setText(nameindex);
                } else if (button2.getText() == "") {
                    button2.setText(nameindex);
                } else if (button3.getText() == "") {
                    button3.setText(nameindex);
                } else if (button4.getText() == "") {
                    button4.setText(nameindex);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mobile(View view){
        Intent intent1 = new Intent(this, Mobile.class);
        startActivity(intent1);
    }
    public void game(View view){
        Intent intent2 = new Intent(this, Game.class);
        startActivity(intent2);
    }
    public void parallel(View view){
        Intent intent3 = new Intent(this, Parallel.class);
        startActivity(intent3);
    }
    public void nlp(View view){
        Intent intent4 = new Intent(this, Nlp.class);
        startActivity(intent4);
    }
}