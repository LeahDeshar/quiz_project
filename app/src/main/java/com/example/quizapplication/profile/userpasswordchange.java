package com.example.quizapplication.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapplication.R;
import com.example.quizapplication.admindbhelper;

public class userpasswordchange extends AppCompatActivity {
TextView uemail;
EditText password,cpassword;
String useremail;
Button change;
admindbhelper db=new admindbhelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.userchangepassword);
uemail=findViewById(R.id.email);
password=findViewById(R.id.password);
cpassword=findViewById(R.id.cpassword);
        useremail = getIntent().getStringExtra("email");
uemail.setText(useremail);
change=findViewById(R.id.change);
change.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String e,p,c;
        e=uemail.getText().toString();
        p=password.getText().toString();
        c=cpassword.getText().toString();
        if(p.equals("")||c.equals("")){
            Toast.makeText(userpasswordchange.this, "Please enter all field", Toast.LENGTH_SHORT).show();
        } else if (p.equals(c)) {
            Boolean result=db.changepassword(e,p);
            if(result==true){
                Toast.makeText(userpasswordchange.this, "Sucessfully change password", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(userpasswordchange.this, "Error", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(userpasswordchange.this, "Confirm password and password should be equal ", Toast.LENGTH_SHORT).show();
        }
    }
});
    }
}