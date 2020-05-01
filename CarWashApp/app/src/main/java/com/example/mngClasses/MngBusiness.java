package com.example.mngClasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.connection.DbConnect;
import com.example.model.MdlBusiness;
import com.example.model.Services;

public class MngBusiness {

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
    public MngBusiness(Context context) {
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

    //TODO INSERT_Service
    public boolean insertBusiness(MdlBusiness mB,int Bid,int BU_id){

        SQLite.execSQL("INSERT INTO " + DbConnect.TABLE_BUSINESS +
                "(" + DbConnect.COLUMN_BUSINESS_BUSINESSID + ","  + DbConnect.COLUMN_BUSINESS_TITLE +  ","  + DbConnect.COLUMN_BUSINESS_USERNAME + "," + DbConnect.COLUMN_BUSINESS_PASSWORD + "," + DbConnect.COLUMN_BUSINESS_CONTACT + ","  + DbConnect.COLUMN_BUSINESSUSER_ID +
                ")VALUES( '"+Bid+ "','"+ mB.getBusinessTitle()+ "','"+ mB.getUserName()+"','"+mB.getPassword()+"','"+mB.getContactNo()+"','"+BU_id+"' )");

        closeCon();
        if(SQLite.toString() == "-1")
            return false;
        else
            return true;
    }
}
