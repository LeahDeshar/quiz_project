package com.example.quizapplication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapplication.R;
import com.example.quizapplication.admindbhelper;

public class userregister extends AppCompatActivity {
    EditText  address,username, password,cpassword,email,phone;
    TextView gender;
    Button register;
    RadioButton male,female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userregister);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.cpassword);
        address=findViewById(R.id.address);
        email=findViewById(R.id.email);
        gender=findViewById(R.id.gender);
        phone=findViewById(R.id.phonenumber);
        register=findViewById(R.id.register);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        admindbhelper DB=new admindbhelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user,pass,cp,a,e,p,g;

                user= capitalizeFirstLetter( username.getText().toString());
                pass=password.getText().toString();
                cp=cpassword.getText().toString();
                a=address.getText().toString();

                e=email.getText().toString();
                p=phone.getText().toString();
                if (male.isChecked()){
                    g="Male";
                }else {
                    g="Female";
                }

                if(user.equals("")||pass.equals("")||cp.equals("")||a.equals("")||g.equals("")||e.equals("")||p.equals("")){
                    Toast.makeText(userregister.this, "Please enter all field", Toast.LENGTH_SHORT).show();
                    if(p.length()!=10){
                        Toast.makeText(userregister.this, "Phone number must be 10 digits", Toast.LENGTH_SHORT).show();
                    }
                }
                else {

                    if (pass.equals(cp)) {
                        Boolean checkuser = DB.checkuser(e);
                        if (p.length() != 10) {
                            Toast.makeText(userregister.this, "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
                        } else if (!isValidEmail(e)) {
                            Toast.makeText(userregister.this, "PLease enter valid email", Toast.LENGTH_SHORT).show();
                        }
                       else if (isPasswordValid(pass)) {
                            // Password is valid, proceed with your application logic


                            Boolean insert1 = DB.checkusername(user);
                            if (insert1 == false) {
                                if (checkuser == false) {
                                    Boolean insert;
                                    insert = DB.inseruserdata(user, pass, a, e, g, p);
                                    if (insert == true) {
                                        Toast.makeText(userregister.this, "Sucessfully register", Toast.LENGTH_SHORT).show();
                                        address.setText("");
                                        username.setText("");
                                        password.setText("");
                                        cpassword.setText("");
                                        email.setText("");
                                        gender.setText("");
                                        phone.setText("");
                                    } else {
                                        Toast.makeText(userregister.this, "Register Fail!", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(userregister.this, "Already exist!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(userregister.this, "Username Already exist!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{

                            Toast.makeText(userregister.this, "Password must be at least 6 characters and contain at least 1 number.", Toast.LENGTH_SHORT).show();

                        }

                    }

                    else{
                        Toast.makeText(userregister.this, "Confirm passsword should be match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            public  boolean isValidEmail(CharSequence target) {
                return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
            }
            public boolean isPasswordValid(String password) {
                // Check if the password has at least 6 characters
                if (password.length() < 6) {
                    return false;
                }

                // Check if the password contains at least 1 number
                boolean containsNumber = false;
                for (char c : password.toCharArray()) {
                    if (Character.isDigit(c)) {
                        containsNumber = true;
                        break;
                    }
                }

                return containsNumber;
            }
        });
    }
    public String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

}