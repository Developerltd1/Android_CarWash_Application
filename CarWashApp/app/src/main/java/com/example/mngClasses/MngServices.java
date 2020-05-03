package com.example.mngClasses;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.connection.DbConnect;
import com.example.model.Services;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MngServices {

    private Context context;
    Services mServies = new Services();  //ModelClass Object
    private DbConnect objConnection; //dbClass Object
    SQLiteDatabase SQLite;  //SQLite-Object


    public void openCon(){
        SQLite = objConnection.getWritableDatabase();
    }
    public void closeCon(){
        objConnection.close();
    }


    //TODO Constructor  {Calling db Name-&-Version THEN Connection-Open}
    public MngServices(Context context) {
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
    public boolean insertService(Services mS){

        SQLite.execSQL("INSERT INTO " + DbConnect.TABLE_SERVICES +
                "(" + DbConnect.COLUMN_SERVICES_currentDate + "," + DbConnect.COLUMN_SERVICES_currentTime + "," + DbConnect.COLUMN_SERVICES_ServiceType + "," + DbConnect.COLUMN_SERVICES_VehicleType + "," + DbConnect.COLUMN_SERVICES_VehicleMake + "," + DbConnect.COLUMN_SERVICES_Party + "," + DbConnect.COLUMN_SERVICES_IsUpload + "," +
                DbConnect.COLUMN_SERVICES_VehicleModel + "," + DbConnect.COLUMN_SERVICES_VehicleReg + "," + DbConnect.COLUMN_SERVICES_Commision + "," + DbConnect.COLUMN_SERVICES_Amount + "," + DbConnect.COLUMN_SERVICES_CustomerName + "," + DbConnect.COLUMN_SERVICES_Contact + "," + DbConnect.COLUMN_SERVICES_Comments +"," + DbConnect.COLUMN_SERVICES_BusinessUser_ID +
                ")VALUES('"+ mS.getvDate() + "','"+ mS.getvTime()+"','"+mS.getServiceType()+"','"+mS.getVehicleType()+"','"+mS.getVehicleMake()+
                "','"+mS.getParty()+"', '"+mS.getisUpload()+"' ,'"+mS.getVehicleModel()+"','"+mS.getVehicleReg()+"','"+mS.getCommision()+"','"+mS.getAmount()+
                "','"+mS.getCustomerName()+"','"+mS.getContact()+"','"+mS.getComments()+"','"+mS.getSERVICE_UserBusiness_ID()+"' )");

        closeCon();
            if(SQLite.toString() == "-1")
                return false;
            else
                return true;
    }
    //TODO UPDATE_Service
    public boolean updateService(Services mS){
        openCon();
        SQLite.execSQL(" UPDATE tblService SET IsUpload = 1 WHERE IsUpload = 0");
        closeCon();
        if(SQLite.toString() == "-1"){
            return false;
        }
        else
            return true;
    }
    //TODO Display_AllServiceForBackup
    public ArrayList<Services> getAllServiceForBackup(/*int paraBusIDgetfromDB ,*/ int paraIsUpload) {
        //DbConnect.COLUMN_SERVICES_IsUpload = false;
                                 //LocalServiceID
        String Queryy = String.format("SELECT VehicleID,ServiceType,VehicleType,VehicleMake,Party,VehicleModel,VehicleReg,CustomerName,Contact,Comments,Commision,Amount,SERVICESBusinessUser_ID FROM tblService   WHERE IsUpload = '"+paraIsUpload+"' ");
        openCon();
        Cursor c = SQLite.rawQuery(Queryy, null);

        ArrayList<Services>  lstmService = new ArrayList<Services>();
        if (c.moveToFirst()) {
            do{
                Services servies = new Services();
                servies.setLocalServiceID(c.getInt(0));
                servies.setServiceType(c.getString(1));
                servies.setVehicleType(c.getString(2));
                servies.setVehicleMake(c.getString(3));
                servies.setParty(c.getString(4));
                servies.setVehicleModel(c.getString(5));
                servies.setVehicleReg(c.getString(6));
                servies.setCustomerName(c.getString(7));
                servies.setContact(c.getString(8));
                servies.setComments(c.getString(9));
               // servies.setBusiness_ID(c.getInt(10));  ?
                servies.setCommision(c.getString(10));
                servies.setAmount(c.getString(11));
                servies.setSERVICE_UserBusiness_ID(c.getInt(12));

                lstmService.add(servies);
            }while (c.moveToNext());
        }
        c.close();
        closeCon();
        return lstmService;
    }
    //TODO Display_AllService
    public ArrayList<Services> getAllServicebyDailyDate() {

        //Current-Date
        Date dt = new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Services s = new Services();
        String aa =sdf.format(dt);
        s.setvDate(aa);

        String Query4 = String.format("Select VehicleMake,VehicleModel,VehicleReg,ServiceType,Amount,CustomerName from tblService  WHERE " +s.getvDate()+ "=" +s.getvDate());
        Cursor c = SQLite.rawQuery(Query4,null);

        ArrayList<Services>  lstmService = new ArrayList<Services>();
        if (c.moveToFirst()) {
          do{
            Services servies = new Services();
              servies.setVehicleMake(c.getString(0));
              servies.setVehicleModel(c.getString(1));
              servies.setVehicleReg(c.getString(2));
              servies.setServiceType(c.getString(3));
              servies.setAmount(c.getString(4));
              servies.setCustomerName(c.getString(5));
            lstmService.add(servies);
        }while (c.moveToNext());
        }

        c.close();
        return lstmService;
    }
    //TODO Display_DailyReport
    public ArrayList <Services> getDailyReport() {

        //Current-Date
        Date dt = new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Services s = new Services();
        String aa =sdf.format(dt);
        s.setvDate(aa);

        String QueryDailyReport = String.format("Select currentTime,ServiceType,VehicleType,VehicleMake,VehicleReg,Amount,Commision, Amount+Commision from tblService where " +s.getvDate()+ "=" +s.getvDate());

        Cursor c = SQLite.rawQuery(QueryDailyReport , null);
         Log.d("OnlyDateCheck", String.valueOf(c));
        int a = -1;

        ArrayList<Services>  lstService = new ArrayList<Services>();
        if (c.moveToFirst()) {
            do{
                a++;
                Services ser = new Services();
                ser.setvTime(c.getString(0));
                ser.setServiceType(c.getString(1));
                ser.setVehicleType(c.getString(2));
                ser.setVehicleMake(c.getString(3));
                ser.setVehicleReg(c.getString(4));
                ser.setAmount(c.getString(5));
                ser.setCommision(c.getString(6));
                ser.setInitAmount(c.getString(7));

                Log.d("ListError2  ", String.valueOf(a + ": " + mServies.ServiceType + " = " + mServies.VehicleType + " = " + mServies.VehicleMake + " = " + mServies.VehicleReg + " = " + mServies.Amount+ " = " + mServies.Commision+ " = " + mServies.initAmount));
                lstService.add(ser);
            }while (c.moveToNext());
        }

        c.close();
        return lstService;
    }
    //TODO Display_ReportBySelect2Dates
    public ArrayList <Services> getReportBySelect2Dates(String startDate,String endDate) {

        // YYYY-MM-DD HH:MM:SS - YYYY-MM-DD

      /*  startDate.lastIndexOf("0",3);endDate.lastIndexOf("0",3);
          startDate = String.format("'"+startDate+"'");
          endDate = String.format("'"+endDate+"'");
      */

        String Query4 = String.format("Select currentTime,ServiceType,VehicleType,VehicleMake,VehicleReg,Amount,currentDate from tblService  WHERE currentDate BETWEEN date('"+startDate+"') AND date('"+endDate+"') ");

        Cursor c = SQLite.rawQuery(Query4,null);
        Log.d("OnlyDateCheck",""+c + endDate);

        ArrayList<Services>  lstService2 = new ArrayList<Services>();
        if (c.moveToFirst()) {
            do{
                Services ser2 = new Services();
               // ser2.(c.getString(0));
                ser2.setvDate(c.getString(6));
                ser2.setvTime(c.getString(0));
                ser2.setServiceType(c.getString(1));
                ser2.setVehicleType(c.getString(2));
                ser2.setVehicleMake(c.getString(3));
                ser2.setVehicleReg(c.getString(4));
                ser2.setAmount(c.getString(5));

                lstService2.add(ser2);
            }while (c.moveToNext());
        }

        c.close();
        return lstService2;
    }
    //TODO Display_TotalVehicle_AND_Amount
    public int[] getServiceTotalVehicle_AND_Amount() {

        Cursor c = SQLite.rawQuery("Select COUNT(" + DbConnect.COLUMN_SERVICES_VehicleID + "), SUM(" + DbConnect.COLUMN_SERVICES_Amount + ") from " + DbConnect.TABLE_SERVICES, null);
        int[]  arr = new int[2];
        if (c.moveToFirst()) {
            arr[0] = c.getInt(0);
            arr[1] = c.getInt(1);

             c.close();
        }
        while (c.moveToNext()) ;
        return arr;
    }
    //TODO Display_Service_WherePARTYS
    public int[] getService_WherePARTY1() {

        Cursor c = SQLite.rawQuery("Select COUNT("+DbConnect.COLUMN_SERVICES_VehicleID+"), SUM("+DbConnect.COLUMN_SERVICES_Amount+"), SUM("+DbConnect.COLUMN_SERVICES_Commision+"),  (Amount-Commision)  from " + DbConnect.TABLE_SERVICES+ " WHERE "+DbConnect.COLUMN_SERVICES_Party+"= 1" , null);
        int[]  arr = new int[4];
        if (c.moveToFirst()) {

            arr[0] = c.getInt(0);
            arr[1] = c.getInt(1);
            arr[2] = c.getInt(2);
            arr[3] = c.getInt(3);

            c.close();
        }
        while (c.moveToNext()) ;
        return arr;
    }
    public int[] getService_WherePARTY2() {

        Cursor c = SQLite.rawQuery("Select COUNT("+DbConnect.COLUMN_SERVICES_VehicleID+"), SUM("+DbConnect.COLUMN_SERVICES_Amount+"), SUM("+DbConnect.COLUMN_SERVICES_Commision+"),  (Amount-Commision)  from " + DbConnect.TABLE_SERVICES+ " WHERE "+DbConnect.COLUMN_SERVICES_Party+"= 2" , null);
        int[]  arr = new int[4];
        if (c.moveToFirst()) {

            arr[0] = c.getInt(0);
            arr[1] = c.getInt(1);
            arr[2] = c.getInt(2);
            arr[3] = c.getInt(3);

            c.close();
        }
        while (c.moveToNext()) ;
        return arr;
    }
    public int[] getService_WherePARTY3() {

        String Query3 = String.format("Select COUNT(VehicleID),SUM(Amount), SUM(Commision), Amount-Commision from tblService where Party = '3'");
        Cursor c = SQLite.rawQuery( Query3, null);
        int[]  arr = new int[4];
        if (c.moveToFirst()) {

            arr[0] = c.getInt(0);
            arr[1] = c.getInt(1);
            arr[2] = c.getInt(2);
            arr[3] = c.getInt(3);

            c.close();
        }
        while (c.moveToNext()) ;
        return arr;
    }
    public int[] getService_WherePARTY4() {

        String Query4 = String.format("Select COUNT(VehicleID),SUM(Amount), SUM(Commision), Amount-Commision from tblService where Party = '4'");

        Cursor c = SQLite.rawQuery(Query4 , null);
        int[]  arr = new int[4];
        if (c.moveToFirst()) {

            arr[0] = c.getInt(0);
            arr[1] = c.getInt(1);
            arr[2] = c.getInt(2);
            arr[3] = c.getInt(3);

            c.close();
        }
        while (c.moveToNext()) ;
        return arr;
    }
    public int[] getService_WherePARTY5() {

        String Query5 = String.format("Select COUNT(VehicleID),SUM(Amount), SUM(Commision), Amount-Commision from tblService where Party = '5'");

        Cursor c = SQLite.rawQuery(Query5 , null);
        int[]  arr = new int[4];
        if (c.moveToFirst()) {

            arr[0] = c.getInt(0);
            arr[1] = c.getInt(1);
            arr[2] = c.getInt(2);
            arr[3] = c.getInt(3);

            c.close();
        }
        while (c.moveToNext()) ;
        return arr;
    }

}

