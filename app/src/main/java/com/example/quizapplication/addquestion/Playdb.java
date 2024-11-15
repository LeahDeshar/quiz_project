package com.example.quizapplication.addquestion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quizapplication.Algorithm;

import java.util.ArrayList;

public class Playdb   extends SQLiteOpenHelper
{


    private Context context;


    public Playdb(@Nullable Context context) {
        super(context, "playquestion.bd", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE play(id INTEGER PRIMARY KEY, question TEXT,optionA TEXT,optionB TEXT,optionC TEXT,optionD TEXT,Ans TEXT) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists play");
    }

    public Boolean insert(String question, String optionA, String optionB, String optionC, String optionD, String Ans) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put("Question", question);
        cv.put("OptionA", optionA);
        cv.put("OptionB", optionB);
        cv.put("OptionC", optionC);
        cv.put("OptionD", optionD);
        cv.put("Ans", Ans);

        long result = db.insert("play", null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor viewdata() {
        // to get database connection
        SQLiteDatabase DB = this.getWritableDatabase();

        //user Current Record
        Cursor findAllRecords = DB.rawQuery("select *from play", null);
        return findAllRecords;


    }
//    public ArrayList<Algorithm> userdetails(String question){
//        ArrayList<Algorithm> al=new ArrayList<>();
//        SQLiteDatabase myDB=this.getReadableDatabase();
//        String query="SELECT *FROM user_login WHERE question='"+question+"'";
//
//        Cursor cursor=myDB.rawQuery(query,null);
//        if(cursor.moveToFirst()){
//            Algorithm userdatamodal=new Algorithm(questions, optiona, optionb, optionc, optiond, answer);
//            userdatamodal.setId(cursor.getString(0));
//            userdatamodal.setQuestion(cursor.getString(1));
//            userdatamodal.setOptiona(cursor.getString(2));
//            userdatamodal.setOptionb(cursor.getString(3));
//            userdatamodal.setOptionc(cursor.getString(4));
//            userdatamodal.setOptiond(cursor.getString(5));
//            userdatamodal.setAnswer(cursor.getString(6));
//            al.add(userdatamodal);
//        }
//        return  al;
//    }





    public Boolean deletedata(String Ans) {
        // to get database connection
        SQLiteDatabase DB = this.getWritableDatabase();
        //user Current Record
        Cursor findRecord = DB.rawQuery("select *from play Where Ans=?", new String[]{Ans});
        if (findRecord.getCount() > 0) {
            int result = DB.delete("mydatabase", "Ans=?", new String[]{Ans});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }





}



