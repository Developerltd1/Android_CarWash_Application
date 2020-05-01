package com.example.mngClasses;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.connection.DbConnect;
import com.example.model.MdlBusiness;
import com.example.model.Services;

import java.util.ArrayList;

public class MngSignin {
    private Context context;
    MdlBusiness mBus = new MdlBusiness();  //ModelClass Object
    private DbConnect objConnection; //dbClass Object
    SQLiteDatabase SQLite;  //SQLite-Object

    public void openCon(){
        SQLite = objConnection.getWritableDatabase();
    }
    public void closeCon(){
        objConnection.close();
    }

    //TODO Constructor  {Calling db Name-&-Version THEN Connection-Open}
    public MngSignin(Context context) {
        this.context =context;
        objConnection = new DbConnect(context);
        //open the database
        try{
            openCon(); //conOpen
        }catch (Exception ex){//if conOpen Error!
            Log.e("ConnectionOpenError: ", "SQLException on opening database: "+ ex.getMessage());
            ex.printStackTrace();
        }
    }

    public  String[] getBusinesID_Title_UserName_fromDB(String uname, String pass) {

        String Queryy = String.format(" SELECT BusinessID,BusinessTitle,BusinessUserName,BusinessPassword FROM tblBusiness WHERE BusinessUserName = '"+uname+"' and BusinessPassword = '"+pass+"' ");
        Cursor c = SQLite.rawQuery(Queryy , null);
        String[]  arr = new String[4];
        if (c.moveToFirst()) {

            arr[0] = c.getString(0); //BusID
            arr[1] = c.getString(1); //BusTitle
            arr[2] = c.getString(2); //BusUserName
            arr[3] = c.getString(3); //BusUserName
        }
     //   while (c.moveToNext()) ;
        return arr;
    }
}
