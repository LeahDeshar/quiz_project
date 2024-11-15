package com.example.quizapplication;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizapplication.login.userlogin;

public class FinalResultActivity extends AppCompatActivity {
TextView subject,txtsubject,txtpoint,txtcorrect,txtwrong,txtdate,point,correct,wrong,date;
String s,d,c,w,p,n;
String getquestion,getselectanswer,correctanswer;
String username1;
TextView done;
    String email;
ImageView image;
    com.google.android.material.button.MaterialButton start,view,no;
        @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalresult);
        subject=findViewById(R.id.subject);
        image=findViewById(R.id.imageViewFinalResultQuiz);
        txtpoint=findViewById(R.id.txtpoint);
        txtsubject=findViewById(R.id.txtsubject);
        txtwrong=findViewById(R.id.txtwrong);
        txtdate =findViewById(R.id.txtdate);

      txtcorrect=findViewById(R.id.txtcorrect);
      correct=findViewById(R.id.correct);
      wrong=findViewById(R.id.wrong);
      date=findViewById(R.id.date);
      point=findViewById(R.id.point);
      no=findViewById(R.id.no);
      start=findViewById(R.id.start);

done=findViewById(R.id.done);

        s=getIntent().getStringExtra("play");
            c=getIntent().getStringExtra("score");
            w=getIntent().getStringExtra("wrong");
            p=getIntent().getStringExtra("point");
            email=getIntent().getStringExtra("email");
getquestion=getIntent().getStringExtra("question");
getselectanswer=getIntent().getStringExtra("tanswer");
correctanswer=getIntent().getStringExtra("answer");
        d=getIntent().getStringExtra("date");
         n=getIntent().getStringExtra("username");
done.setText("Well Done,"+n);

txtcorrect.setText(c);
txtpoint.setText(p);
txtwrong.setText(w);
            txtdate.setText(d);
            username1 = getIntent().getStringExtra("username");


    txtsubject.setText(s);
    String topic=txtsubject.getText().toString();
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(FinalResultActivity.this, userlogin.class);
                    startActivity(i);
                }
            });
if(topic.equals("play")) {
    start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(FinalResultActivity.this, play.class);
            i.putExtra("email",email);
            startActivity(i);
        }
    });


}
else if(topic.equals("Sport")) {
    start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(FinalResultActivity.this, Sportsplay.class);
            i.putExtra("email",email);

            startActivity(i);
        }
    });


}
else if(topic.equals("Gk")) {
    start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(FinalResultActivity.this, Gkplay.class);
            i.putExtra("email",email);

            startActivity(i);
        }
    });


}
else if(topic.equals("Math")) {
    start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(FinalResultActivity.this, Mathplay.class);
            i.putExtra("email",email);

            startActivity(i);
        }
    });


}
else if(topic.equals("IT")) {
    start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(FinalResultActivity.this, IT.class);
            i.putExtra("email",email);

            startActivity(i);
        }
    });


}



        }
}