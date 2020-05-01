package com.example.carwashapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interfaceses.AppUtils;
import com.example.mngClasses.MngServices;
import com.example.mngClasses.MngSignin;
import com.example.model.MdlBusiness;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ActivitySignIn extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final int ADD_RECORD = 1;
    EditText user,pass;
    Button btnSignIn,btnTryAgain;
   TextView txtRegistration;
ImageView mv;

   // String uName = "Admin",uPass = "12345";
    MngSignin objSignin;

    private boolean exit = false;
    //------------------------------------------//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO layout-name
        setContentView(R.layout.activity_sign_in);
        //------------------------------------------//
        objSignin = new MngSignin(ActivitySignIn.this);

        //TODO Initiliazation
        txtRegistration = (TextView)findViewById(R.id.txtRegistration);
        user = (EditText)findViewById(R.id.etUser);
        pass = findViewById(R.id.etPass);

        btnSignIn = findViewById(R.id.btnSignIn);
        udm_btnClick();

    }


    private void udm_btnClick() {



        //TODO Sign-in btn
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                //region    //-- REGION-> Expiry Date --//
               /* Date cdate = null;
                Date edate = null;
                try {
                    SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
                    Calendar today = Calendar.getInstance();
                    cdate = today.getTime();
                    edate = sdf.parse("15-12-2019");

                if(cdate.compareTo(edate)<0)
                        {
                        CODE HERE...
                        //  user.setText("");pass.setText("");
                        }
                        else if(cdate.compareTo(edate)>0) {
                            Toast.makeText(ActivitySignIn.this, "Software Date Expired!", Toast.LENGTH_SHORT).show();
                        }*/
                //endregion

                String[] arr = new String[4];
                arr =  objSignin.getBusinesID_Title_UserName_fromDB(user.getText().toString(),pass.getText().toString());
                    if(user.getText().toString().equals(arr[2]) && pass.getText().toString().equals(arr[3])){
                     //To DashBoard
                        int valueBusID = Integer.parseInt(arr[0]);
                        String valueBusTitle = arr[1];
                        String valueBusName = arr[2];

                            Intent intent = new Intent(ActivitySignIn.this,MainActivity.class);
                            intent.putExtra("keyBusID",valueBusID);
                            intent.putExtra("keyBusTitle",valueBusTitle);
                            intent.putExtra("keyBusName",valueBusName);
                            startActivity(intent);
                            finish();
                    }
                    else {
                        Toast.makeText(ActivitySignIn.this, "Username/Password is Not Valid! Try Again.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ActivitySignIn.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    //region REGION-> Fragment
            /*    Fragment fragment =null;
                ActivityHome AH =new ActivityHome();
                fragment = AH;
                if(fragment !=null){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.ScreenArea , fragment);
                    ft.commit();
                }*/
                    //DrawerLayout drawer = findViewById(R.id.drawer_layout);
                    //drawer.closeDrawer(GravityCompat.START);

                   /* getSupportFragmentManager().beginTransaction()
                            .add(android.R.id.content, new ActivityHome()).commit();*/

                    // ActivityHome  home = new ActivityHome();
                    //  FragmentManager fragmentManager = getSupportFragmentManager();
                    //  fragmentManager.beginTransaction()
                    //   .replace(R.id.ScreenArea, home).commit();

               /* } catch (ParseException e) {
                    e.printStackTrace();
                }*/
               //endregion

            }
        });

        //TODO Registration txtView Click
        txtRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(AppUtils.isConnected(ActivitySignIn.this)) {
                    //To DashBoard
                    Intent intent = new Intent(ActivitySignIn.this, Registration.class);
                    startActivity(intent);
                }else {
                  AppUtils.buildDialog2(ActivitySignIn.this).show();
              }
            }
        });
    }

    @Override
    public void onBackPressed(){
        if(exit)
        {  finish(); }
        else
        { Toast.makeText(ActivitySignIn.this, "Press again to exit", Toast.LENGTH_SHORT).show(); }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                exit=false;
            }
        },2000);

        exit = true;
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
