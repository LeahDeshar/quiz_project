package com.example.quizapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapplication.addquestion.Gkaddquestion;
import com.example.quizapplication.addquestion.ITaddquestion;
import com.example.quizapplication.addquestion.Mathaddquestion;
import com.example.quizapplication.addquestion.sportaddquestion;

import com.example.quizapplication.login.userlogin;

public class Adminpanel extends AppCompatActivity {
TextView sports,GK,IT,History,changepass,logout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminpanel);
        sports=findViewById(R.id.sports);

        GK=findViewById(R.id.gk);
        History=findViewById(R.id.history);
        IT=findViewById(R.id.it);
sports.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(Adminpanel.this, sportaddquestion.class);
        startActivity(i);
    }
});
        GK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Adminpanel.this, Gkaddquestion.class);
                startActivity(i);

//                Cursor records = DB.viewdata();
//                if (records.getCount() == 0) {
//                    Toast.makeText(Adminpanel.this, "No data found", Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
//                    StringBuffer allrecords = new StringBuffer();
//                    while (records.moveToNext()) {
//                       allrecords.append("Question: " + records.getString(0) + "\n");
//                        allrecords.append("OptionA: " + records.getString(1) + "\n");
//                        allrecords.append("OptionB:" + records.getString(2) + "\n");
//                        allrecords.append("OptionC:" + records.getString(3) + "\n");
//                        allrecords.append("OptionD:" + records.getString(4) + "\n");
//                        allrecords.append("Answer:" + records.getString(5) + "\n");}
//                    AlertDialog.Builder builder=new AlertDialog.Builder(Adminpanel.this);
//                    builder.setCancelable(true);
//                    builder.setTitle("View all records");
//
//
//                    builder.setMessage(allrecords.toString());
//                    builder.show();
//                }
            }
        });

        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Adminpanel.this, Mathaddquestion.class);
                startActivity(i);


            }
        });
        IT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Adminpanel.this, ITaddquestion.class);
                startActivity(i);


            }
        });

    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.adminpanel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            AlertDialog.Builder builder=new AlertDialog.Builder(Adminpanel.this);
                builder.setTitle("Quiz Application");
                builder.setMessage("Are you sure want to logout");
                builder.setCancelable(true);
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Adminpanel.this, userlogin.class);
                        Toast.makeText(Adminpanel.this, "Admin login page", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Adminpanel.this, "Cancel logout", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert=builder.create();
                alert.show();

        }
        if (id == R.id.details) {

       Intent intent=new Intent(Adminpanel.this,Totaluser.class);
       startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    }




