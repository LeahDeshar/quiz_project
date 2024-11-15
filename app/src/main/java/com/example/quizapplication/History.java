package com.example.quizapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.quizapplication.profile.userdatamodal;

import java.util.ArrayList;

public class History extends AppCompatActivity {


    GridView list;
    ArrayList<String> txtsubject;
    ArrayList<Integer> txtpoint;
    ArrayList<String> subject;
    ArrayList<String> point;
    ArrayList<String> date;

    String username;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);


        list = findViewById(R.id.gridview);
        subject = new ArrayList<>();
        txtpoint = new ArrayList<>();
        txtsubject = new ArrayList<>();
        point = new ArrayList<>();
        date = new ArrayList<>();

        username = getIntent().getStringExtra("email");

        admindbhelper Db = new admindbhelper(History.this);




            Cursor data = Db.viewdata(username);

            while (data.moveToNext()) {
                subject.add(data.getString(1));
                point.add(data.getString(2));
                date.add(data.getString(3));


            }

//else{
//            Toast.makeText(this, "History is blank", Toast.LENGTH_SHORT).show();
//}


//
//        Cursor data = Db.viewdata();
//
//        while (data.moveToNext()) {
//            subject.add(data.getString(1));
//            point.add(data.getString(2));
//            date.add(data.getString(3));
//
//
//        }

            Historyadapter adapter = new Historyadapter(History.this, subject, point, txtsubject, txtpoint, date);
            list.setAdapter(adapter);


        }

    }

