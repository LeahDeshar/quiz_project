package com.example.quizapplication.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapplication.Home;
import com.example.quizapplication.R;
import com.example.quizapplication.admindbhelper;
import com.example.quizapplication.admin.adminlogin;


public class userlogin extends AppCompatActivity {
    EditText email, password;
    Button login;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlogin);
        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        admindbhelper Db = new admindbhelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = email.getText().toString();
                String pass = password.getText().toString();
                String  u=email.getText().toString();

                String a=password.getText().toString();
                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(userlogin.this, "Please enter all field", Toast.LENGTH_SHORT).show();

                } else  if (!isValidEmail(user)) {
                    Toast.makeText(userlogin.this, "PLease enter valid email", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean chechuserpass = Db.checkusername(user, pass);

                    if (chechuserpass == true) {
                        Toast.makeText(userlogin.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(userlogin.this, Home.class);

                        i.putExtra("key_username",u);
                        email.setText("");
                        password.setText("");

                        startActivity(i);
                    } else {
                        Toast.makeText(userlogin.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(userlogin.this, userregister.class);
                Toast.makeText(userlogin.this, "User Register", Toast.LENGTH_SHORT).show();
                startActivity(i);

            }
        });

    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.admin) {
            Intent i = new Intent(userlogin.this, adminlogin.class);
            Toast.makeText(this, "Admin login page", Toast.LENGTH_SHORT).show();
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public  boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}

//    public static class Adminlogin extends AppCompatActivity {
//        EditText username, password,cpassword;
//        Button register,login;
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_adminlogin);
//
//
//        }
//    }
