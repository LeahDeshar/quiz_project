package com.example.quizapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.quizapplication.historydatamodel;
import com.example.quizapplication.profile.userdatamodal;

import java.util.ArrayList;

public class admindbhelper extends SQLiteOpenHelper {
    public  long result;
    public admindbhelper(@Nullable Context context) {
        super(context, "quizapp.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {

        String createUserLoginTable = "CREATE TABLE IF NOT EXISTS user_login (" +
                "user_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, " +
                "password TEXT, " +
                "address TEXT, " +
                "email TEXT UNIQUE, " +
                "gender TEXT, " +
                "phone TEXT)";

        // SQL command to create the history table
        String createHistoryTable = "CREATE TABLE IF NOT EXISTS history (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user_id INTEGER, " +
                "subject TEXT, " +
                "points TEXT, " +
                "date TEXT, " +
                "FOREIGN KEY(user_id) REFERENCES user_login(user_id))";


        String createSportTable = "CREATE TABLE IF NOT EXISTS sport (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "question TEXT, " +
                "optiona TEXT, " +
                "optionb TEXT, " +
                "optionc TEXT, " +
                "optiond TEXT, " +
                "answer TEXT)";

        String createGkTable = "CREATE TABLE IF NOT EXISTS gk (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "question TEXT, " +
                "optiona TEXT, " +
                "optionb TEXT, " +
                "optionc TEXT, " +
                "optiond TEXT, " +
                "answer TEXT)";

        String createMathTable = "CREATE TABLE IF NOT EXISTS math (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "question TEXT, " +
                "optiona TEXT, " +
                "optionb TEXT, " +
                "optionc TEXT, " +
                "optiond TEXT, " +
                "answer TEXT)";

        String createItTable = "CREATE TABLE IF NOT EXISTS it (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "question TEXT, " +
                "optiona TEXT, " +
                "optionb TEXT, " +
                "optionc TEXT, " +
                "optiond TEXT, " +
                "answer TEXT)";

        String createPlayTable = "CREATE TABLE IF NOT EXISTS play (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "question TEXT, " +
                "optiona TEXT, " +
                "optionb TEXT, " +
                "optionc TEXT, " +
                "optiond TEXT, " +
                "answer TEXT)";

        // Execute the SQL statements to create the tables
//        myDB.execSQL(createUserLoginTable);
//        myDB.execSQL(createHistoryTable);

        myDB.execSQL(createUserLoginTable);
        myDB.execSQL(createHistoryTable);
        myDB.execSQL(createSportTable);
        myDB.execSQL(createGkTable);
        myDB.execSQL(createMathTable);
        myDB.execSQL(createItTable);
        myDB.execSQL(createPlayTable);


    }
    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("DROP TABLE IF EXISTS user_login");
        myDB.execSQL("DROP TABLE IF EXISTS history");
        myDB.execSQL("DROP TABLE IF EXISTS sport");
        myDB.execSQL("DROP TABLE IF EXISTS gk");
        myDB.execSQL("DROP TABLE IF EXISTS math");
        myDB.execSQL("DROP TABLE IF EXISTS it");
        myDB.execSQL("DROP TABLE IF EXISTS play");
        onCreate(myDB);
    }

    //  Insert into history table.
public Boolean inseruserdata(String username, String password,String address,String email,String gender,String phone) {
    SQLiteDatabase myDB = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("username", username);
    contentValues.put("password", password);
    contentValues.put("address", address);
    contentValues.put("email", email);
    contentValues.put("gender", gender);
    contentValues.put("phone", phone);
    long result;
    result = myDB.insert("user_login", null, contentValues);
    if (result == -1) {
        return false;
    } else {
        return true;
    }

}


    public Boolean insert_history(String user_id,String subject, String points,String date) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_id", user_id);
        contentValues.put("subject", subject);
        contentValues.put("points", points);
        contentValues.put("date", date);


        long result = myDB.insert("history ", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from admin Where username=? and password=?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }
    // user  username and password check.
    public Boolean checkuser(String email){
        SQLiteDatabase myDB=this.getReadableDatabase();
        Cursor cursor=myDB.rawQuery("select * from user_login Where email=?", new String[]{email});

        if(cursor.getCount()>0){return true;}
        else{return  false;
        }


    }
    public Boolean checkusername(String username){
        SQLiteDatabase myDB=this.getReadableDatabase();
        Cursor cursor=myDB.rawQuery("select * from user_login Where username=?", new String[]{username});

        if(cursor.getCount()>0){return true;}
        else{return  false;
        }


    }
    public  Boolean checkusername( String email, String password){
        SQLiteDatabase myDB=this.getReadableDatabase();
        Cursor cursor=myDB.rawQuery("select * from user_login Where email=? and password=?", new String[]{email, password});
        if(cursor.getCount()>0){return  true;}
        else{return  false ;}


    }
    public Cursor viewuser() {


        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor findAllRecords;

        findAllRecords = DB.rawQuery("select *from user_login ", null);


        return findAllRecords ;

    }
// TO display user information in user profile.
    public ArrayList<userdatamodal> userdetails(String email){
        ArrayList<userdatamodal> al=new ArrayList<>();
        SQLiteDatabase myDB=this.getReadableDatabase();
        String query="SELECT *FROM user_login WHERE email='"+email+"'";

        Cursor cursor=myDB.rawQuery(query,null);
        if(cursor.moveToFirst()){
            userdatamodal userdatamodal=new userdatamodal();
            userdatamodal.setUser_id(cursor.getString(0));
            userdatamodal.setUsername(cursor.getString(1));
            userdatamodal.setPassword(cursor.getString(2));
            userdatamodal.setAddress(cursor.getString(3));
            userdatamodal.setGender(cursor.getString(5));
            userdatamodal.setEmail(cursor.getString(4));
            userdatamodal.setPhone(cursor.getString(6));

            al.add(userdatamodal);
        }
        return  al;
    }
//To display history of user.

    public Cursor viewdata(String user_id) {


        SQLiteDatabase myDB=this.getReadableDatabase();
        String query="SELECT * FROM history WHERE user_id='"+user_id+"'";

           Cursor  findAllRecords = myDB.rawQuery(query, null);


            return findAllRecords ;

    }
    //To change user password .
    public  Boolean changepassword( String email,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues data=new ContentValues();

        data.put("email",email);
        data.put("password",password);

        Cursor cursor= DB.rawQuery("Select * from user_login  where email=?",new String[] {email});
        if (cursor.getCount()>0) {

            long result = DB.update("user_login",data, "email=?",new String[]{email});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else{
            return  false;
        }

    }

    public  Boolean checkemail( String email){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues data=new ContentValues();

        data.put("email",email);


        Cursor cursor= DB.rawQuery("Select * from user_login  where email=?",new String[] {email});
        if (cursor.getCount()>0) {

            return true;
        }
            else {
                return true;
            }


    }
    // To delete history
    public Boolean deletedata(String points) {
        // to get database connection


        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = "points = ? ";
        String[] whereArgs = new String[]{String.valueOf(points)};

        db.delete("history", whereClause, whereArgs);
        db.close();


        return null;
    }


    //CRUD of sport
    public Boolean insertsport( String question, String optiona, String optionb, String optionc, String optiond, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put("question", question);
        cv.put("optiona", optiona);
        cv.put("optionb", optionb);
        cv.put("optionc", optionc);
        cv.put("optiond", optiond);
        cv.put("answer", answer);
        long result = db.insert("sport", null, cv);

        if (result == -1) {
            return false;
        }


        else {
            return true;
        }
    }
    public Cursor viewdatasport(){
        // to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findAllRecords=DB.rawQuery("select *from sport    ", null);
        return  findAllRecords;


    }
    public Cursor viewdatasportplay(){
        // to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findAllRecords=DB.rawQuery("select * from sport   ", null);
        return  findAllRecords;


    }
    public Boolean deletedatasport(String answer){
//         to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findRecord=DB.rawQuery("select *from sport Where answer=?", new String[]{answer});
        if(findRecord.getCount()>0){
            int result=DB.delete("sport","answer=?", new String[]{answer});
            if(result== -1){
                return false;
            }
            else{
                return true;
            }
        }else {
            return false;
        }


    }
    public Boolean checksportans(String question){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from sport Where question=?", new String[]{question});

        if(cursor.getCount()>0){return true;}
        else{return  false;
        }


    }
    public  Boolean updatedatasport( String question, String optiona, String optionb, String optionc, String optiond, String answer){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues data=new ContentValues();

        data.put("question",question);
        data.put("optiona",optiona);
        data.put("optionb",optionb);
        data.put("optionc",optionc);
        data.put("optiond",optiond);
        data.put("answer",answer);
        Cursor cursor= DB.rawQuery("Select * from sport  where answer=?",new String[] {answer});
        if (cursor.getCount()>0) {

            long result = DB.update("sport",data, "answer=?",new String[]{answer});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else{
            return  false;
        }

    }
//end for sport crud

    //GK crud start
    public Boolean checkgkans(String question){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from gk Where question=?", new String[]{question});

        if(cursor.getCount()>0){return true;}
        else{return  false;
        }


    }

    public Boolean insertgk( String question, String optiona, String optionb, String optionc, String optiond, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put("question", question);
        cv.put("optiona", optiona);
        cv.put("optionb", optionb);
        cv.put("optionc", optionc);
        cv.put("optiond", optiond);
        cv.put("answer", answer);
        long result = db.insert("gk", null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor viewdatagk(){
        // to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findAllRecords=DB.rawQuery("select *from gk", null);
        return  findAllRecords;


    }
    public Cursor viewdatagkplay(){
        // to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findAllRecords=DB.rawQuery("select * from gk", null);
        return  findAllRecords;


    }
    public Boolean deletedatagk(String answer){
//         to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findRecord=DB.rawQuery("select * from gk Where answer=?", new String[]{answer});
        if(findRecord.getCount()>0){
            int result=DB.delete("gk","answer=?", new String[]{answer});
            if(result== -1){
                return false;
            }
            else{
                return true;
            }
        }else {
            return false;
        }


    }
    public  Boolean updatedatagk( String question, String optiona, String optionb, String optionc, String optiond, String answer){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues data=new ContentValues();

        data.put("question",question);
        data.put("optiona",optiona);
        data.put("optionb",optionb);
        data.put("optionc",optionc);
        data.put("optiond",optiond);
        data.put("answer",answer);
        Cursor cursor= DB.rawQuery("Select * from gk  where answer=?",new String[] {answer});
        if (cursor.getCount()>0) {

            long result = DB.update("gk",data, "answer=?",new String[]{answer});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else{
            return  false;
        }

    }
//end of gk question


    // start of math question
    public Boolean insertmath( String question, String optiona, String optionb, String optionc, String optiond, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("question", question);
        cv.put("optiona", optiona);
        cv.put("optionb", optionb);
        cv.put("optionc", optionc);
        cv.put("optiond", optiond);
        cv.put("answer", answer);
        long result = db.insert("math", null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor viewdatamath(){
        // to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findAllRecords=DB.rawQuery("select * from math ", null);
        return  findAllRecords;


    }
    public Cursor viewdatamathplay(){
        // to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findAllRecords=DB.rawQuery("select * from math", null);
        return  findAllRecords;


    }
    public Boolean checkmathans(String question){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from math Where question=?", new String[]{question});

        if(cursor.getCount()>0){return true;}
        else{return  false;
        }


    }

    public Boolean deletedatamath(String answer){
//         to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findRecord=DB.rawQuery("select * from math Where answer=?", new String[]{answer});
        if(findRecord.getCount()>0){
            int result=DB.delete("math","answer=?", new String[]{answer});
            if(result== -1){
                return false;
            }
            else{
                return true;
            }
        }else {
            return false;
        }


    }
    public  Boolean updatedatamath( String question, String optiona, String optionb, String optionc, String optiond, String answer){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues data=new ContentValues();

        data.put("question",question);
        data.put("optiona",optiona);
        data.put("optionb",optionb);
        data.put("optionc",optionc);
        data.put("optiond",optiond);
        data.put("answer",answer);
        Cursor cursor= DB.rawQuery("Select * from math  where answer=?",new String[] {answer});
        if (cursor.getCount()>0) {

            long result = DB.update("math",data, "answer=?",new String[]{answer});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else{
            return  false;
        }

    }
//end of math question

    // start of it question
    public Boolean checkitans(String question){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select *from it Where question=?", new String[]{question});

        if(cursor.getCount()>0){return true;}
        else{return  false;
        }


    }

    public Boolean insertit( String question, String optiona, String optionb, String optionc, String optiond, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put("question", question);
        cv.put("optiona", optiona);
        cv.put("optionb", optionb);
        cv.put("optionc", optionc);
        cv.put("optiond", optiond);
        cv.put("answer", answer);
        long result = db.insert("it", null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor viewdataitplay(){
        // to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findAllRecords=DB.rawQuery("select * from it  ", null);
        return  findAllRecords;


    }
    public Cursor viewdatait(){
        // to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findAllRecords=DB.rawQuery("select * from it ", null);
        return  findAllRecords;


    }

    public Boolean deletedatait(String answer){
//         to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findRecord=DB.rawQuery("select * from it Where answer=?", new String[]{answer});
        if(findRecord.getCount()>0){
            int result=DB.delete("it","answer=?", new String[]{answer});
            if(result== -1){
                return false;
            }
            else{
                return true;
            }
        }else {
            return false;
        }


    }
    public  Boolean updatedatait( String question, String optiona, String optionb, String optionc, String optiond, String answer){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues data=new ContentValues();

        data.put("question",question);
        data.put("optiona",optiona);
        data.put("optionb",optionb);
        data.put("optionc",optionc);
        data.put("optiond",optiond);
        data.put("answer",answer);
        Cursor cursor= DB.rawQuery("Select * from it  where answer=?",new String[] {answer});
        if (cursor.getCount()>0) {

            long result = DB.update("it",data, "answer=?",new String[]{answer});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else{
            return  false;
        }

    }
//end of math question
    // to inser all question in one table
public Boolean insertplay( String question, String optiona, String optionb, String optionc, String optiond, String answer) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();


    cv.put("question", question);
    cv.put("optiona", optiona);
    cv.put("optionb", optionb);
    cv.put("optionc", optionc);
    cv.put("optiond", optiond);
    cv.put("answer", answer);
    long result = db.insert("play", null, cv);
    if (result == -1) {
        return false;
    } else {
        return true;
    }
}

    public Cursor viewdataplayplay(){
        // to get database connection
        SQLiteDatabase DB=this.getWritableDatabase();
        //user Current Record
        Cursor findAllRecords=DB.rawQuery("select * from play  ", null);
        return  findAllRecords;


    }
}


