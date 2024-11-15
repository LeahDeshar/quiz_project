package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class play extends AppCompatActivity {
    TextView  question,id;
    RadioButton a,b,c,d;
    RadioGroup radio_g;
    String ans1;
    private List<Algorithm> tableRows = new ArrayList<>();
    Button next;
    int index=0;
    int wrong=0;
    int ind=1;
    int score=0;
    TextView result;

    ArrayList<String> questions;
    ArrayList<String> optiona;
    ArrayList<String> optionb;
    ArrayList<String> optionc;
    ArrayList<String> optiond;
    ArrayList<String> answer;
    String username1,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports);
        question=findViewById(R.id.question);
        id=findViewById(R.id.qid);
        a=findViewById(R.id.optionA);
        b=findViewById(R.id.optionB);
        c=findViewById(R.id.optionC);
        d=findViewById(R.id.optionD);
        next=findViewById(R.id.next);
        radio_g=findViewById(R.id.radiog);
        admindbhelper Db=new admindbhelper(play.this);
        username1 = getIntent().getStringExtra("username");
        questions=new ArrayList<>();
        optiona=new ArrayList<>();
        optionb=new ArrayList<>();
        optionc=new ArrayList<>();
        optiond=new ArrayList<>();
        answer=new ArrayList<>();


        Cursor data = Db.viewdataplayplay();
        while (data.moveToNext()) {

            questions.add(data.getString(1));
            optiona.add(data.getString(2));
            optionb.add(data.getString(3));
            optionc.add(data.getString(4));
            optiond.add(data.getString(5));
            answer.add(data.getString(6));
            tableRows.add(new Algorithm(data.getString(1),data.getString(2),data.getString(3),data.getString(4),data.getString(5),data.getString(6)));

        }
        id.setText("Current Question: "+(index+1)+"");



        Algorithm randomRow = getRandomRow();
        question.setText(randomRow.getQuestion());
        a.setText( randomRow.getOptiona());
        b.setText(randomRow.getOptionb());
        c.setText(randomRow.getOptionc());
        d.setText( randomRow.getOptiond());
        String q=questions.get(index);
        String A=optiona.get(index);
        String B=optionb.get(index);
        String C=optionc.get(index);
        String D=optiond.get(index);
        ans1=randomRow.getAnswer();




        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {



                if(index<=question.length() ) {
                    if (radio_g.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (a.isChecked()) {
                        String oa = a.getText().toString();

                        if (ans1.equals(oa)) {
                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                            score++;
                        } else {
                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                            wrong++;
                        }
                    }
                    else if (b.isChecked()) {
                        String ob = b.getText().toString();


                        if (ans1.equals(ob)) {
                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                            score++;
                        } else {
                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                            wrong++;
                        }
                    }
                    else if (c.isChecked()) {


                        String oc = c.getText().toString();

                        if (ans1.equals(oc)) {
                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                            score++;
                        } else {
                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                            wrong++;
                        }
                    }
                    else if (d.isChecked()) {
                        String od = d.getText().toString();


                        if (ans1.equals(d.getText().toString())) {
                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                            score++;
                        } else {
                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                            wrong++;
                        }
                    }
                    a.setChecked(false);
                    b.setChecked(false);
                    c.setChecked(false);
                    d.setChecked(false);
                    if (index <= question.length() - 1) {
                        id.setText("Current Question: "+(index + 1 + 1) + "");
                        Algorithm randomRow = getRandomRow();
                        question.setText(randomRow.getQuestion());
                        a.setText(randomRow.getOptiona());
                        b.setText(randomRow.getOptionb());
                        c.setText(randomRow.getOptionc());
                        d.setText(randomRow.getOptiond());

                        ans1 = randomRow.getAnswer();

                    }
                    if (index <= A.length()+1) {
                        index++;
                    }
                    else if (index<=question.length()-1) {
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (index <= A.length()) {
                                    if (a.isChecked()) {

                                        if (answer.get(index).equals(optiona.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (b.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optionb.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (c.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optionc.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (d.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optiond.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                }
                                else if (index <= B.length()) {
                                    if (a.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optiona.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (b.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optionb.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (c.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optionc.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (d.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optiond.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else if (index <= C.length()) {
                                    if (a.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optiona.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (b.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optionb.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (c.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optionc.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (d.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optiond.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else if (index <= D.length()) {
                                    if (a.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optiona.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (b.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optionb.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (c.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optionc.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (d.isChecked()) {
                                        String ans = answer.get(index);
                                        if (answer.get(index).equals(optiond.get(index))) {
                                            Toast.makeText(play.this, "Correct", Toast.LENGTH_SHORT).show();
                                            score++;
                                        } else {
                                            Toast.makeText(play.this, "Wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }

//                        Toast.makeText(Sports.this, "Score is "+score, Toast.LENGTH_SHORT).show();

                                else {
                                    int w = wrong;


                                    String p = String.valueOf(score );
                                    String s = String.valueOf(score);
                                    String wr = String.valueOf(w+1);
                                    String po = String.valueOf(p);
                                    Calendar calendar = Calendar.getInstance();
                                    String currentdate = DateFormat.getDateInstance().format(calendar.getTime());
                                    Intent intent = new Intent(play.this, FinalResultActivity.class);
                                    String play = "play";
                                    intent.putExtra("play", play);
                                    intent.putExtra("score", s);
                                    intent.putExtra("wrong", wr);
                                    intent.putExtra("point", po);
                                    intent.putExtra("question", q);
                                    intent.putExtra("answer", ans1);
                                    intent.putExtra("date", currentdate);
                                    intent.putExtra("username", username1);
                                    intent.putExtra("answer", ans1);


                                     email = getIntent().getStringExtra("email");
                                    intent.putExtra("email",email);
                                    startActivity(intent);

                                    Boolean insert = Db.insert_history(email,play, p, currentdate);
                                    if (insert == true) {
                                        Toast.makeText(com.example.quizapplication.play.this, "insert sucessfull in history", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(com.example.quizapplication.play.this, "Error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });

                    }
                }

            }

        });

    }




    private Algorithm getRandomRow() {
        int index1 = 0;
        Random random = new Random();
        for (int i = tableRows.size() - 1; i > 0; i--) {

            index1 = random.nextInt(i + 1);
            Algorithm temp = (tableRows.get(i));
            tableRows.set(i, tableRows.get(index1));
            tableRows.set(index1,temp);
        }
        return tableRows.get(index1);


    }
}
//package com.example.quizapplication;
//import static java.lang.Integer.getInteger;
//import static java.lang.Integer.parseInt;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.database.Cursor;
//import android.os.Bundle;
//
//import java.text.DateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.view.View;
//import android.widget.Button;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class Sports extends AppCompatActivity {
//    private List<Algorithm> tableRows = new ArrayList<>();
//
//
//    admindbhelper db=new admindbhelper(this);
//
//    String ans1,tanswer;
//
//    String username1;
//    String A;
//    TextView  question,id;
//    String q,user_id;
//
//    RadioButton a,b,c,d;
//    RadioGroup radioGroup;
//    Button next;
//    int index=0,wrong=0;
//
//    int score=0;
//
//
//
//    ArrayList<String> questions;
//    ArrayList<String> optiona;
//    ArrayList<String> optionb;
//
//    ArrayList<String> optionc;
//    ArrayList<String> qid;
//    ArrayList<String> optiond;
//    ArrayList<String> answer1;
//
//    String getquestion;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.sports);
//        question = findViewById(R.id.question);
//        id = findViewById(R.id.qid);
//        a = findViewById(R.id.optionA);
//        b = findViewById(R.id.optionB);
//        c = findViewById(R.id.optionC);
//        d = findViewById(R.id.optionD);
//
//        next = findViewById(R.id.next);
//        radioGroup = findViewById(R.id.radiog);
//        user_id=getIntent().getStringExtra("email");
//
//        questions = new ArrayList<>();
//        optiona = new ArrayList<>();
//        optionb = new ArrayList<>();
//        optionc = new ArrayList<>();
//        optionc = new ArrayList<>();
//        optiond = new ArrayList<>();
//        answer1 = new ArrayList<>();
//        qid= new ArrayList<>() ;
//        username1 = getIntent().getStringExtra("username");
//        Cursor data = db.viewdatasportplay();
//        while (data.moveToNext()) {
//
//            questions.add(data.getString(1));
//            optiona.add(data.getString(2));
//            optionb.add(data.getString(3));
//            optionc.add(data.getString(4));
//            optiond.add(data.getString(5));
//            answer1.add(data.getString(6));
//            tableRows.add(new Algorithm(data.getString(1),data.getString(2),data.getString(3),data.getString(4),data.getString(5),data.getString(6)));
//
//        }
//        id.setText("Current Question: "+(index+1)+"");
//
//
//
//        Algorithm randomRow = getRandomRow();
//        question.setText(randomRow.getQuestion());
//        a.setText( randomRow.getOptiona());
//        b.setText(randomRow.getOptionb());
//        c.setText(randomRow.getOptionc());
//        d.setText( randomRow.getOptiond());
//
//        A = a.getText().toString();
//        getquestion=question.getText().toString();
//
//        ans1=randomRow.getAnswer();
//        next.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceType")
//            @Override
//            public void onClick(View view) {
//
//                if (radioGroup.getCheckedRadioButtonId() == -1) {
//                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (index <= questions.size()) {
//
//                    if (a.isChecked()) {
//                        String oa = a.getText().toString();
//                        tanswer=a.getText().toString();
//                        if (ans1.equals(oa)) {
//                            Toast.makeText(Sports.this, "Correct", Toast.LENGTH_SHORT).show();
//                            score++;
//                        } else {
//                            Toast.makeText(Sports.this, "Wrong", Toast.LENGTH_SHORT).show();
//                            wrong++;
//                        }
//                    }
//                    else if (b.isChecked()) {
//                        String ob = b.getText().toString();
//                        tanswer=b.getText().toString();
//
//                        if (ans1.equals(ob)) {
//                            Toast.makeText(Sports.this, "Correct", Toast.LENGTH_SHORT).show();
//                            score++;
//                        } else {
//                            Toast.makeText(Sports.this, "Wrong", Toast.LENGTH_SHORT).show();
//                            wrong++;
//
//                        }
//                    }
//                    else if (c.isChecked()) {
//                        tanswer=c.getText().toString();
//
//                        String oc = c.getText().toString();
//
//                        if (ans1.equals(oc)) {
//                            Toast.makeText(Sports.this, "Correct", Toast.LENGTH_SHORT).show();
//                            score++;
//                        } else {
//                            Toast.makeText(Sports.this, "Wrong", Toast.LENGTH_SHORT).show();
//                            wrong++;
//
//                        }
//                    }
//                    else if (d.isChecked()) {
//                        String od = d.getText().toString();
//                        tanswer=d.getText().toString();
//
//                        if (ans1.equals(d.getText().toString())) {
//                            Toast.makeText(Sports.this, "Correct", Toast.LENGTH_SHORT).show();
//                            score++;
//                        } else {
//                            Toast.makeText(Sports.this, "Wrong", Toast.LENGTH_SHORT).show();
//                            wrong++;
//
//                        }
//                    }
//                    a.setChecked(false);
//                    b.setChecked(false);
//                    c.setChecked(false);
//                    d.setChecked(false);
//                    if (index <= questions.size() - 1) {
//
//                        id.setText("Current Question: " + (index + 1 + 1) + "");
//                        Algorithm randomRow = getRandomRow();
//                        question.setText(randomRow.getQuestion());
//                        a.setText(randomRow.getOptiona());
//                        b.setText(randomRow.getOptionb());
//                        c.setText(randomRow.getOptionc());
//                        d.setText(randomRow.getOptiond());
//
//                        ans1 = randomRow.getAnswer();
//
//                    }
//
//                    if (index <= A.length() ) {
//                        index++;
//
//                    }
//                    else if (index <= questions.size() - 1) {
//                        next.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                if (a.isChecked()) {
//                                    String oa = a.getText().toString();
//                                    tanswer=a.getText().toString();
//                                    if (ans1.equals(oa)) {
//                                        Toast.makeText(Sports.this, "Correct", Toast.LENGTH_SHORT).show();
//                                        score++;
//                                    } else {
//                                        Toast.makeText(Sports.this, "Wrong", Toast.LENGTH_SHORT).show();
//                                        wrong++;
//                                    }
//                                }
//                                else if (b.isChecked()) {
//                                    String ob = b.getText().toString();
//                                    tanswer=b.getText().toString();
//                                    if (ans1.equals(ob)) {
//                                        Toast.makeText(Sports.this, "Correct", Toast.LENGTH_SHORT).show();
//                                        score++;
//                                    }
//                                    else {
//                                        Toast.makeText(Sports.this, "Wrong", Toast.LENGTH_SHORT).show();
//                                        wrong++;
//                                    }
//                                }
//                                else if (c.isChecked()) {
//                                    String oc = c.getText().toString();
//                                    tanswer=c.getText().toString();
//
//                                    if (ans1.equals(oc)) {
//                                        Toast.makeText(Sports.this, "Correct", Toast.LENGTH_SHORT).show();
//                                        score++;
//                                    } else {
//                                        Toast.makeText(Sports.this, "Wrong", Toast.LENGTH_SHORT).show();
//                                        wrong++;
//                                    }
//                                }
//                                else if (d.isChecked()) {
//                                    String od = d.getText().toString();
//                                    tanswer=d.getText().toString();
//
//                                    if (ans1.equals(od)) {
//                                        Toast.makeText(Sports.this, "Correct", Toast.LENGTH_SHORT).show();
//                                        score++;
//                                    } else {
//                                        Toast.makeText(Sports.this, "Wrong", Toast.LENGTH_SHORT).show();
//                                        wrong++;
//                                    }
//                                }
//
//
//                                int w = wrong;
//
//
//                                String p = String.valueOf(score * 2);
//                                String s = String.valueOf(score);
//                                String wr = String.valueOf(w);
//                                String po = String.valueOf(p);
//                                Calendar calendar = Calendar.getInstance();
//                                String currentdate = DateFormat.getDateInstance().format(calendar.getTime());
//                                Intent intent = new Intent(Sports.this, FinalResultActivity.class);
//                                String play = "Sport";
//                                intent.putExtra("play", play);
//                                intent.putExtra("score", s);
//                                intent.putExtra("wrong", wr);
//                                intent.putExtra("point", po);
//                                intent.putExtra("question", q);
//                                intent.putExtra("answer", ans1);
//                                intent.putExtra("date", currentdate);
//                                intent.putExtra("username", username1);
//                                intent.putExtra("answer", ans1);
//                                intent.putExtra("question", getquestion);
//                                intent.putExtra("tanswer", tanswer);
//                                intent.putExtra("user_id",user_id);
//                                 String email = getIntent().getStringExtra("email");
//                                startActivity(intent);
//
//                                Boolean insert = db.insert_history(email,"Sport", p, currentdate);
//                                if (insert == true) {
//                                    Toast.makeText(Sports.this, "insert sucessfull in history", Toast.LENGTH_SHORT).show();
//                                } else {
//                                    Toast.makeText(Sports.this, "Error", Toast.LENGTH_SHORT).show();
//                                }
//
//                            }
//
//                        });
//                    }
//
//
//                }
//
//            }
//        });
//    }
//
//    private Algorithm getRandomRow() {
//        int index1 = 0;
//        Random random = new Random();
//        for (int i = tableRows.size() - 1; i > 0; i--) {
//
//            index1 = random.nextInt(i + 1);
//            Algorithm temp = (tableRows.get(i));
//            tableRows.set(i, tableRows.get(index1));
//            tableRows.set(index1,temp);
//        }
//        return tableRows.get(index1);
//
//
//    }
//}
//
