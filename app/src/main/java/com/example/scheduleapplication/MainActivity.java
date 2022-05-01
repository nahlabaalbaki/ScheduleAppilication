package com.example.scheduleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            SQLiteDatabase sql = this.openOrCreateDatabase("scheduleapp",MODE_PRIVATE,null);
            sql.execSQL("CREATE Table IF NOT EXISTS courses(name VARCHAR, website VARCHAR)");

            sql.execSQL("INSERT INTO courses(name,wesbite) VALUES ('Mobile Development','https://ionicframework.com/')");
            sql.execSQL("INSERT INTO courses(name,wesbite) VALUES ('Game Programming','https://unity.com/')");
            sql.execSQL("INSERT INTO courses(name,wesbite) VALUES ('Parallel Programming','https://www.open-mpi.org/')");
            sql.execSQL("INSERT INTO courses(name,wesbite) VALUES ('Natural Language Processing','https://www.nlp.com/what-is-nlp/')");


        }catch(Exception e){

        }
        
    }
}