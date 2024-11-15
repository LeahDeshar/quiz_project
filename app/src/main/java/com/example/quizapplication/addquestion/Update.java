package com.example.quizapplication.addquestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quizapplication.R;

import com.example.quizapplication.admindbhelper;

public class Update extends AppCompatActivity {
EditText id,question,optiona,optionb,optionc,optiond,answer;
Button update;
admindbhelper db=new admindbhelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.update);
        id=findViewById(R.id.id);
        question=findViewById(R.id.addquestion);
        optiona=findViewById(R.id.OptionA);
        optionb=findViewById(R.id.OptionB);
        optionc=findViewById(R.id.OptionC);
        optiond=findViewById(R.id.OptionD);
        answer=findViewById(R.id.Answer);
        update=findViewById(R.id.btnupdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q,a,b,c,d,ans;

                q=question.getText().toString();
                a=optiona.getText().toString();
                b=optionb.getText().toString();
                c=optionc.getText().toString();
                d=optiond.getText().toString();
                ans=answer.getText().toString();
                String uid=id.getText().toString();
                if (q.equals("")||a.equals("")||b.equals("")||c.equals("")||d.equals("")){
                    Toast.makeText(Update.this, "please enter all field", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean check = db.updatedatasport(q, a, b, c, d, ans);
                    Boolean check1=db.updatedatait(q,a,b,c,d,ans);
                    Boolean check2=db.updatedatagk(q,a,b,c,d,ans);
                    Boolean check3=db.updatedatamath(q,a,b,c,d,ans);


                    if (check == true) {
                        Toast.makeText(Update.this, "sucessfully update", Toast.LENGTH_SHORT).show();
                    question.setText("");
                    optionc.setText("");
optionb.setText("");
                    optiona.setText("");
                    optiond.setText("");
                    answer.setText("");
                    }
                   else if (check1 == true) {
                        Toast.makeText(Update.this, "sucessfully update", Toast.LENGTH_SHORT).show();
                        question.setText("");
                        optionc.setText("");
                        optionb.setText("");
                        optiona.setText("");
                        optiond.setText("");
                        answer.setText("");}
                   else if (check2== true) {
                        Toast.makeText(Update.this, "sucessfully update", Toast.LENGTH_SHORT).show();
                        question.setText("");
                        optionc.setText("");
                        optionb.setText("");
                        optiona.setText("");
                        optiond.setText("");
                        answer.setText(""); }
                    else if (check3 == true) {
                        Toast.makeText(Update.this, "sucessfully update", Toast.LENGTH_SHORT).show();
                        question.setText("");
                        optionc.setText("");
                        optionb.setText("");
                        optiona.setText("");
                        optiond.setText("");
                        answer.setText("");}

                    else {
                        Toast.makeText(Update.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}