package com.example.quizapplication.addquestion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quizapplication.R;
import com.example.quizapplication.admindbhelper;
import com.example.quizapplication.view.sportquestion;


public class sportaddquestion extends AppCompatActivity {

    Button add, delete, viwe, update;
    Button delete1;

    EditText queston, optiona, optionb, optionc, optiond, ans, did;

    admindbhelper DB = new admindbhelper(sportaddquestion.this);
    Playdb db = new Playdb(sportaddquestion.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addquestion);

        add = findViewById(R.id.btnadd);
        delete = findViewById(R.id.btndelete);
        viwe = findViewById(R.id.btnview);
        update = findViewById(R.id.btnupdate);
        queston = findViewById(R.id.addquestion);
        optiona = findViewById(R.id.OptionA);
        optionb = findViewById(R.id.OptionB);
        optionc = findViewById(R.id.OptionC);
        optiond = findViewById(R.id.OptionD);
        ans = findViewById(R.id.Answer);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = queston.getText().toString();
                String optionA = optiona.getText().toString();
                String optionB = optionb.getText().toString();
                String optionC = optionc.getText().toString();
                String optionD = optiond.getText().toString();
                String Ans = ans.getText().toString();

                if (queston.equals("") || optionA.equals("") || optionB.equals("") || optionC.equals("") || optionD.equals("") || Ans.equals("")) {
                    Toast.makeText(sportaddquestion.this, "Please enter all field", Toast.LENGTH_SHORT).show();
                }
                Boolean checkuser = DB.checksportans(question);
if(checkuser==true){
                        Toast.makeText(sportaddquestion.this, "These question already inserted ", Toast.LENGTH_SHORT).show();

}
                else {
                    if (Ans.equals(optionA) || Ans.equals(optionB) || Ans.equals(optionC) || Ans.equals(optionD)) {
                        Boolean checkinsert = DB.insertsport(question, optionA, optionB, optionC, optionD, Ans);
                        Boolean checkinsert1 = DB.insertplay(question, optionA, optionB, optionC, optionD, Ans);

                        if (checkinsert == true) {
                            if (checkinsert1 == true) {

                                Toast.makeText(sportaddquestion.this, "Insert record Suceddfully", Toast.LENGTH_SHORT).show();

                                queston.setText("");
                                optiona.setText("");
                                optionb.setText("");
                                optionc.setText("");
                                optiond.setText("");
                                ans.setText("");
                            } else {
                                Toast.makeText(sportaddquestion.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(sportaddquestion.this, "Answer should be equal to any one", Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {


                AlertDialog.Builder alertbox = new AlertDialog.Builder(sportaddquestion.this);
                alertbox.setTitle("Delete question");
                alertbox.setCancelable(true);
                LayoutInflater inflater = getLayoutInflater();
                View view1 = inflater.inflate(R.layout.delete, null);
                alertbox.setView(view1);
                AlertDialog alert = alertbox.create();
                did = view1.findViewById(R.id.id);
                delete1 = view1.findViewById(R.id.delete1);
//String n=did.getText().toString();

                delete1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        String Ans=did.getText().toString();

                        Boolean checkdelete=DB.deletedatasport(Ans);
                        if(checkdelete==true){
                            Toast.makeText(sportaddquestion.this, "Delete record  Suceddfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(sportaddquestion.this, "Error", Toast.LENGTH_SHORT).show();
                        }

                        alert.dismiss();

                    }

                });


                alert.show();
                queston.setText("");
                optiona.setText("");
                optionb.setText("");
                optionc.setText("");
                optiond.setText("");
                ans.setText("");
            }

        });
        viwe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queston.setText("");
                optiona.setText("");
                optionb.setText("");
                optionc.setText("");
                optiond.setText("");
                ans.setText("");
                Intent i = new Intent(sportaddquestion.this, sportquestion.class);
                startActivity(i);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queston.setText("");
                optiona.setText("");
                optionb.setText("");
                optionc.setText("");
                optiond.setText("");
                ans.setText("");
                Intent i=new Intent(sportaddquestion.this, Update.class);
                startActivity(i);
            }
        });

    }
}

