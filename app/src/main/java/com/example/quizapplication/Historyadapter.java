package com.example.quizapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;

public class Historyadapter extends ArrayAdapter<String> {
    Activity context;
    ArrayList<String> id;
    ArrayList<String> txtsubject;
    ArrayList<Integer> txtpoints;
    ArrayList<String> subject;
    ArrayList<String> points;
    ArrayList<String> date;
Context context1;


String    username1 ;
    public Historyadapter(Activity context,ArrayList<String> subject,ArrayList<String> points,ArrayList<String> txtsubject,ArrayList<Integer> txtpoints,ArrayList<String> date) {
//        public questionAdapter(Activity context,ArrayList<myquestion> questions) {
        super(context, R.layout.item_history,subject );
        this.context=context;


        this.subject=subject;
        this.points=points;
        this.date=date;
        this.txtsubject=txtsubject;
        this.txtpoints=txtpoints;



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview=inflater.inflate(R.layout.item_history,null);
        final String currentItem = getItem(position);

Button delete=rowview.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                // Handle delete button click
                admindbhelper admindbhelper=new admindbhelper(context);
                String Ans=subject.get(position);
                String point=points.get(position);

                Boolean checkdelete=admindbhelper.deletedata(point);

 final String currentItem = getItem(position);
                admindbhelper.deletedata(currentItem);
                remove(subject.get(position));
                notifyDataSetChanged();

            }
        });

        TextView s=rowview.findViewById(R.id.textView20);
        TextView p=rowview.findViewById(R.id.textView21);
        TextView d=rowview.findViewById(R.id.textView22);
TextView id=rowview.findViewById(R.id.textView25);
        TextView  txts=rowview.findViewById(R.id.textView23);
        TextView  txtp=rowview.findViewById(R.id.textView24);


s.setText("Subject: ");
p.setText("Points: ");
        txts.setText(subject.get(position));
        txtp.setText(points.get(position));
        d.setText(date.get(position));
        id.setText((position+1)+"");

        return rowview;
    }
}
