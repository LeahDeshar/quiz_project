package com.example.quizapplication.profile;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.quizapplication.R;
import com.example.quizapplication.admindbhelper;
import com.example.quizapplication.login.userlogin;

import java.util.ArrayList;

public class userprofile extends AppCompatActivity {

    ImageView image;
    TextView username,address,email,gender,phone,password,id;
    String username1,useremail;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile);

        phone = findViewById(R.id.phonenumber);
        gender = findViewById(R.id.usergender);
        username = findViewById(R.id.username);
        address = findViewById(R.id.useraddress);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);

        image = findViewById(R.id.image);

        username1 = getIntent().getStringExtra("username");

        useremail=email.getText().toString();






        admindbhelper dbhelper = new admindbhelper(this);
        ArrayList<userdatamodal> al = dbhelper.userdetails(username1);
        userdatamodal datamodel=al.get(0);
        username.setText("UserName:- "+datamodel.getUsername());
        password.setText("Password:-"+datamodel.getPassword());
        address.setText("Address:-"+datamodel.getAddress());
        email.setText("Email:-"+datamodel.getEmail());
        gender.setText("Gender:- "+datamodel.getGender());
        phone.setText("Phone no:- "+datamodel.getPhone());
    }
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.profileedit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.cpassword) {
            Intent i=new Intent(userprofile.this, userpasswordchange.class);
            i.putExtra("email",username1);
            startActivity(i);

        }
        if (id==R.id.logout){
Intent i=new Intent(userprofile.this, userlogin.class);
            i.putExtra("email",username1);

        startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }

}


