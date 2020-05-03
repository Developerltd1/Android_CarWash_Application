package com.example.carwashapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Menu;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mngClasses.MngServices;
import com.example.model.Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    MngServices objServices;
    private boolean exit = false;
    public static int keyBusID_Static;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AppBar
         toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Navigation Bar
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        //Burger Button Open,Close
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //Navigation Item Clicking
        navigationView.setNavigationItemSelectedListener(this);
        objServices = new MngServices(this);

       udmEntryFoumOnDASHBoard();

        //get the current intent
        Intent intent = getIntent();
        String keyBusIDStr = intent.getStringExtra("keyBusID");
        keyBusID_Static = Integer.parseInt(keyBusIDStr);

    }

    private void udmEntryFoumOnDASHBoard() {
        Fragment fragment =null;
        // Handle the camera action
        fragment =new ActivityHome();
        if(fragment !=null){

            toolbar.setTitle("New Entry");
            FragmentManager fragmentManager =getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.ScreenArea ,fragment);
            ft.commit();
        }
        DrawerLayout adrawer = findViewById(R.id.drawer_layout);
        adrawer.closeDrawer(GravityCompat.START);
    }

    //Navigation Open/Close
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
           // super.onBackPressed();
             if(exit)
                { finish(); }
                else
                { Toast.makeText(MainActivity.this, "Press again to exit", Toast.LENGTH_SHORT).show(); }
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        exit=false;
                    }
                },2000);
                exit = true;
        }
    }

    //Setting Button Create
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //Setting Button Item Select
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this,ActivitySignIn.class));
            MainActivity.this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Navigation Item Select
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Services s = new Services();

        Fragment fragment =null;

     /*   if (id == R.id.navDashboard) {
            // Handle the camera action
            toolbar.setTitle("Dashboard");}
        else */

            if (id == R.id.navAddTableAdd) {

            fragment =new ActivityHome();
            toolbar.setTitle("New Entry");
        }
        else if (id == R.id.navTableDisplay) {
            // startActivity(new Intent(MainActivity.this,ServicesList.class));
            fragment =new ServicesList();
            toolbar.setTitle("Records");
        }
         else if (id == R.id.navDailyReport) {
            fragment =new ListServiceDailyReport();
            toolbar.setTitle("Today Report" );
        }
        else if (id == R.id.navReportby2Dates) {
            fragment =new ListServiceReportBy2Dates();
            toolbar.setTitle("Report By-Date" );
        }else if (id == R.id.navPartyReport) {
            // startActivity(new Intent(MainActivity.this,PartyReport.class));
            fragment =new PartyReport();
            toolbar.setTitle("Party Information");
        }
        else if (id == R.id.navBackup)
        {
            fragment =new BackupRepport();
            toolbar.setTitle("Back-Up Data");
        }
        else if (id == R.id.nav_send)
        {
        }

        if(fragment !=null){
            FragmentManager fragmentManager =getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
           ft.replace(R.id.ScreenArea ,fragment);
           ft.commit();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
