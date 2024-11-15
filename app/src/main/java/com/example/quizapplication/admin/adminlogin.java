package com.example.quizapplication.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quizapplication.Adminpanel;
import com.example.quizapplication.R;
import com.example.quizapplication.admindbhelper;


public class adminlogin extends AppCompatActivity {
    EditText username, password;
    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminlogin);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);



        admindbhelper Db = new admindbhelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(adminlogin.this, "Please enter all field", Toast.LENGTH_SHORT).show();

                } else {
                    Boolean chechuserpass = Db.checkusernamepassword(user, pass);
                    if (chechuserpass == true) {
                        Toast.makeText(adminlogin.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();
                        username.setText("");
                        password.setText("");
                        Intent i = new Intent(adminlogin.this, Adminpanel.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(adminlogin.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }
}