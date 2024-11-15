package com.example.quizapplication;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class viewadapter extends ArrayAdapter<String> {
    Activity context;
String[] question;
    String[] selectanswer;

    String[] Answer;


    public viewadapter(Activity context ,String[] question,String[] selectanswer,String[] Answer) {


        super(context, R.layout.questionlist );
        this.context=context;

this.selectanswer=selectanswer;
        this.question=question;

        this.Answer=Answer;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview=inflater.inflate(R.layout.viewanswer,null);



        TextView questions=rowview.findViewById(R.id.question);
        TextView id=rowview.findViewById(R.id.id);
        TextView optiona=rowview.findViewById(R.id.selectanswer);

        TextView answer=rowview.findViewById(R.id.Answer);


        questions.setText(question[position]);
        optiona.setText("Your answer:"+selectanswer[position]);

        answer.setText("Answer: "+Answer[position]);

        id.setText((position+1)+"");

        return rowview;
    }


}