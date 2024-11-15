package com.example.quizapplication;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DetailsAdapter extends ArrayAdapter<String> {
    Activity context;
    ArrayList<String> username;

    ArrayList<String> email;
    ArrayList<String> address;
    ArrayList<String> gender;
    ArrayList<String> phone;




    public DetailsAdapter(Activity context,ArrayList<String> username,ArrayList<String> email,ArrayList<String> address,ArrayList<String> gender,ArrayList<String> phone) {
//        public questionAdapter(Activity context,ArrayList<myquestion> questions) {

        super(context, R.layout.questionlist,email );
        this.context=context;


        this.username=username;
        this.email=email;
        this.address=address;
        this.gender=gender;
        this.phone =phone;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview=inflater.inflate(R.layout.userdetails,null);


        TextView id=rowview.findViewById(R.id.id);

        TextView u=rowview.findViewById(R.id.username);
        TextView e=rowview.findViewById(R.id.email);
        TextView a=rowview.findViewById(R.id.address);
        TextView g=rowview.findViewById(R.id.gender);
        TextView p=rowview.findViewById(R.id.phone);




        u.setText("UserName: "+username.get(position));
        e.setText("Email: "+email.get(position));
        a.setText("Address: "+address.get(position));
        g.setText("Gender:"+gender.get(position));
        p.setText("PhoneNo:"+phone.get(position));
        id.setText((position+1)+"");


        return rowview;
    }


}

