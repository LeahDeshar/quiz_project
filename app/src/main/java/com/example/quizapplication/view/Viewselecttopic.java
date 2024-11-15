package com.example.quizapplication.view;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.quizapplication.R;

public class Viewselecttopic extends AppCompatActivity {
    TextView histroy,gk,sport,it,play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecttopic);
        histroy=findViewById(R.id.history);
        gk=findViewById(R.id.gk);
        sport=findViewById(R.id.sports);
        play=findViewById(R.id.play);
        it=findViewById(R.id.it);
        histroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Viewselecttopic.this, Mathquestion.class);
                startActivity(i);
            }
        });
        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent i=new Intent(Viewselecttopic.this, gkquestion.class);
        startActivity(i);

            }
        });
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent i=new Intent(Viewselecttopic.this, Itquestion.class);
startActivity(i);
            }
        });
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Viewselecttopic.this, sportquestion.class);
                startActivity(i);


            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Viewselecttopic.this, Playquestion.class);
                startActivity(i);


            }
        });

    }
}