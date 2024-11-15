package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Topic extends AppCompatActivity {
TextView math,sports,gk,it;
String username1,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminpanel);
        math=findViewById(R.id.history);
        sports =findViewById(R.id.sports);
      gk  =findViewById(R.id.gk);
        it=findViewById(R.id.it);
        username1 = getIntent().getStringExtra("username");
       email=getIntent().getStringExtra("email");


        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    Intent i=new Intent(Topic.this,Mathplay.class);
    i.putExtra("username",username1);
                i.putExtra("email",email);
    startActivity(i);
            }
        });
        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Topic.this, "gk is question is not insert", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Topic.this,Gkplay.class);
                i.putExtra("username",username1);
                i.putExtra("email",email);

                startActivity(i);
            }

        });
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Topic.this,IT.class);
                i.putExtra("username",username1);
                i.putExtra("email",email);

                startActivity(i);
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Topic.this, Sportsplay.class);
                i.putExtra("username",username1);
                i.putExtra("email",email);

                startActivity(i);
            }
        });


    }
}