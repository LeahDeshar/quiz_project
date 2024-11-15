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

public class questionAdapter extends ArrayAdapter<String> {
    Activity context;
    ArrayList<String> question;
    ArrayList<String> optionA;
    ArrayList<String> optionB;
    ArrayList<String> optionC;
    ArrayList<String> optionD;
    ArrayList<String> Answer;


    public questionAdapter(Activity context,ArrayList<String> question,ArrayList<String> optionA,ArrayList<String> optionB,ArrayList<String> optionC,ArrayList<String> optionD,ArrayList<String> Answer) {
//        public questionAdapter(Activity context,ArrayList<myquestion> questions) {

  super(context, R.layout.questionlist,question );
        this.context=context;


        this.question=question;
        this.optionA=optionA;
        this.optionB=optionB;
        this.optionC=optionC;
        this.optionD=optionD;
        this.Answer=Answer;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview=inflater.inflate(R.layout.questionlist,null);



        TextView questions=rowview.findViewById(R.id.question);
TextView id=rowview.findViewById(R.id.id);
        RadioButton optiona=rowview.findViewById(R.id.optionA);
        RadioButton optionb=rowview.findViewById(R.id.optionB);
        RadioButton optionc=rowview.findViewById(R.id.optionC);
        RadioButton optiond=rowview.findViewById(R.id.optionD);
        TextView answer=rowview.findViewById(R.id.Answer);


        questions.setText(question.get(position));
        optiona.setText(optionA.get(position));
        optionb.setText(optionB.get(position));
        optionc.setText(optionC.get(position));
        optiond.setText(optionD.get(position));
        answer.setText("Answer: "+Answer.get(position));

id.setText((position+1)+"");

        return rowview;
    }


}
