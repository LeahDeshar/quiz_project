package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.quizapplication.login.userlogin;
import com.example.quizapplication.profile.userdatamodal;
import com.example.quizapplication.profile.userprofile;
import com.google.android.material.navigation.NavigationView;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ConstraintLayout logout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    TextView playnow;
    TextView btn,username;
    String username1,user,user_id;
    String n,ui,email,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        btn = findViewById(R.id.topic);
        playnow=findViewById(R.id.play);

username=findViewById(R.id.tvUsernameHome);
logout=findViewById(R.id.lo);
        username1 = getIntent().getStringExtra("key_username");
username.setText(username1);
email=username.getText().toString();
 user=username.getText().toString();
        admindbhelper dbhelper = new admindbhelper(this);
        ArrayList<userdatamodal> al = dbhelper.userdetails(username1);
        userdatamodal datamodel=al.get(0);
        Boolean result=dbhelper.checkemail(user);
        if(result==true){
             name=datamodel.getUsername();
            username.setText("Hello, "+name);


n=username.getText().toString();

        }

        setUpToolbar();
        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())

                {
                    case  R.id.profile:

                        Intent i = new Intent(Home.this, userprofile.class);
                        i.putExtra("username",username1);

                        startActivity(i);
                        break;


                    case  R.id.Logout:

                        Intent intent1 = new Intent(Home.this, userlogin.class);
                        startActivity(intent1);
                        break;


                    case  R.id.History:{

                        Intent intent2 = new Intent(Home.this, History.class);
                        intent2.putExtra("username",username1);
                        intent2.putExtra("email",email);
                        startActivity(intent2);


                    }
                    break;
                }
                return false;
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "Seclect topic to play game", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Home.this , Topic.class);
                i.putExtra("username",name);
                i.putExtra("email",email);


                startActivity(i);
            }
        });
        playnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home.this,play.class);
                i.putExtra("username",name);

                i.putExtra("email",email);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,userlogin.class);
                startActivity(i);
            }
        });
    }
    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }
}