package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Totaluser extends AppCompatActivity {
GridView list;
    ArrayList<String> username;
    ArrayList<String> email;
    ArrayList<String> address;
    ArrayList<String> gender;
    ArrayList<String> phone;
    int index=0;
    admindbhelper db=new admindbhelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        list=findViewById(R.id.gridview);
        username = new ArrayList<>();
        email = new ArrayList<>();
        address = new ArrayList<>();
        phone = new ArrayList<>();
        gender = new ArrayList<>();

        Cursor data = db.viewuser();

        while (data.moveToNext()) {
            username.add(data.getString(1));
            address.add(data.getString(3));
            gender.add(data.getString(5));
            email.add(data.getString(4));
            phone.add(data.getString(6));

        }
        String name=username.get(index);
        DetailsAdapter adapter=new DetailsAdapter(Totaluser.this,username,email,address,gender,phone);
        list.setAdapter(adapter);



    }
}