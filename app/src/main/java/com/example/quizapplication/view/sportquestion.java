package com.example.quizapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.quizapplication.R;
import com.example.quizapplication.admindbhelper;
import com.example.quizapplication.questionAdapter;

import java.util.ArrayList;

public class sportquestion extends AppCompatActivity {
ListView list;
admindbhelper Db=new admindbhelper(this);

    ArrayList<String> question;
    ArrayList<String> optiona;
    ArrayList<String> optionb;
    ArrayList<String> optionc;
    ArrayList<String> optiond;
    ArrayList<String> answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionlistitem);
        list = findViewById(R.id.list);
        question = new ArrayList<>();
        optiona = new ArrayList<>();
        optionb = new ArrayList<>();
        optionc = new ArrayList<>();
        optiond = new ArrayList<>();
        answer = new ArrayList<>();
        Cursor data = Db.viewdatasport();
        while (data.moveToNext()) {
//question=data.getString(0);
                    question.add(data.getString(1));
                    optiona.add(data.getString(2));
                    optionb.add(data.getString(3));
                    optionc.add(data.getString(4));
                    optiond.add(data.getString(5));
                    answer.add(data.getString(6));
                }
            questionAdapter adapter = new questionAdapter(sportquestion.this, question,optiona,optionb,optionc,optiond,answer);
            list.setAdapter(adapter);
        }

    }
