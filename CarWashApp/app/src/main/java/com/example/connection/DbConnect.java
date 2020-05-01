package com.example.connection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbConnect extends SQLiteOpenHelper {

    //TODO Global-Initilization
    public static final String DB_NAME = "CarWashDB.db";
    public static final int DB_VERSION = 1;

    //TODO Constructor {DbName-&-Version}
     public DbConnect(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //region ${ Create & Variables }
     //region ${  TABLE-COLUMNS }
    //==========================  TBL-Services ==================================//
    public static final String TABLE_SERVICES = "tblService";
    public static final String COLUMN_SERVICES_VehicleID = "VehicleID";
    public static final String COLUMN_SERVICES_ServiceType = "ServiceType";
    public static final String COLUMN_SERVICES_VehicleType = "VehicleType";
    public static final String COLUMN_SERVICES_VehicleMake = "VehicleMake";
    public static final String COLUMN_SERVICES_Party = "Party";
    public static final String COLUMN_SERVICES_VehicleModel = "VehicleModel";
    public static final String COLUMN_SERVICES_VehicleReg = "VehicleReg";
    public static final String COLUMN_SERVICES_Commision = "Commision";
    public static final String COLUMN_SERVICES_Amount = "Amount";
    public static final String COLUMN_SERVICES_CustomerName = "CustomerName";
    public static final String COLUMN_SERVICES_Contact = "Contact";
    public static final String COLUMN_SERVICES_Comments = "Comments";
    public static final String COLUMN_SERVICES_currentDate = "currentDate";
    public static final String COLUMN_SERVICES_currentTime = "currentTime";
    public static final String COLUMN_SERVICES_BusinessUser_ID = "SERVICESBusinessUser_ID";
    public static final String COLUMN_SERVICES_IsUpload  = "IsUpload";

    //========================== TBL-BUSINESSES ==================================//
    public static final String TABLE_BUSINESS = "tblBusiness";
    public static final String COLUMN_BUSINESS_BUSINESSID = "BusinessID";
    public static final String COLUMN_BUSINESS_TITLE = "BusinessTitle";
    public static final String COLUMN_BUSINESS_USERNAME = "BusinessUserName";
    public static final String COLUMN_BUSINESS_PASSWORD = "BusinessPassword";
    public static final String COLUMN_BUSINESS_CONTACT = "BusinessContact";
    public static final String COLUMN_BUSINESSUSER_ID = "BusinessUser_ID";

    //endregion
     //region ${  TABLE-STRUCTURE }
    //========================== TABLE-Businesses ==================================//
    public static final String SQL_CREATE_TABLE_BUSINESS = "CREATE TABLE " + TABLE_BUSINESS + " ( "
            + COLUMN_BUSINESS_BUSINESSID + " INTEGER,"
            + COLUMN_BUSINESS_TITLE + " TEXT, "
            + COLUMN_BUSINESS_USERNAME + " TEXT, "
            + COLUMN_BUSINESS_PASSWORD + " TEXT, "
            + COLUMN_BUSINESS_CONTACT + " TEXT, "
            + COLUMN_BUSINESSUSER_ID + " TEXT)";
    //========================== TABLE-Services ==================================//
    public static final String SQL_CREATE_TABLE_SERVICES = "CREATE TABLE " + TABLE_SERVICES + " ( "
            + COLUMN_SERVICES_VehicleID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_SERVICES_currentDate + " TEXT, "
            + COLUMN_SERVICES_currentTime + " TEXT, "
            + COLUMN_SERVICES_ServiceType + " TEXT, "
            + COLUMN_SERVICES_VehicleType + " TEXT, "
            + COLUMN_SERVICES_VehicleMake + " TEXT, "
            + COLUMN_SERVICES_Party + " TEXT, "
            + COLUMN_SERVICES_VehicleModel + " TEXT, "
            + COLUMN_SERVICES_VehicleReg + " TEXT, "
            + COLUMN_SERVICES_Commision + " TEXT, "
            + COLUMN_SERVICES_Amount + " TEXT, "
            + COLUMN_SERVICES_CustomerName + " TEXT, "
            + COLUMN_SERVICES_Contact + " TEXT, "
            + COLUMN_SERVICES_Comments + " TEXT, "
            + COLUMN_SERVICES_BusinessUser_ID + " INTEGER NOT NULL, "
            + COLUMN_SERVICES_IsUpload + " INTEGER,"
            +"FOREIGN KEY (SERVICESBusinessUser_ID) REFERENCES " +TABLE_BUSINESS + " (BusinessUser_ID))";
    //endregion

    //TODO onCreate {Create-Table} [STEP-1+2]
    @Override
    public void onCreate(SQLiteDatabase param_db) {
        param_db.execSQL(SQL_CREATE_TABLE_SERVICES);
        param_db.execSQL(SQL_CREATE_TABLE_BUSINESS);

        param_db.execSQL("PRAGMA foreign_keys=ON");
    }

    //TODO onUpgrade {Droping-Table} [STEP-1+3]
    @Override
    public void onUpgrade(SQLiteDatabase param_db, int oldVersion, int newVersion) {

        param_db.execSQL("DROP TABLE IF EXISTS "+TABLE_SERVICES);
        param_db.execSQL("DROP TABLE IF EXISTS "+TABLE_BUSINESS);
        onCreate(param_db);
    }
}
