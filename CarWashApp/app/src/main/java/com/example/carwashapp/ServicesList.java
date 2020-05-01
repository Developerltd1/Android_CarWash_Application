package com.example.carwashapp;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.ServicesAdapter;
import com.example.mngClasses.MngServices;
import com.example.model.Services;

import java.util.ArrayList;

public class ServicesList extends Fragment implements AdapterView.OnItemSelectedListener  {

    ServicesAdapter adapter;
    ArrayList<Services> sList;
    MngServices objServices;
    ListView lvListID; //Header-List_ID

    //Fregment Creation
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_services_list,container, false);
    }


    //Fregment Create Method
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        objServices = new MngServices(getActivity());
        tableRows(view);
        tableTotalRow(view);
    }


    private void tableTotalRow(View vv) {
        TextView strAm = (TextView) vv.findViewById(R.id.totalAmount);
        TextView strVh = (TextView) vv.findViewById(R.id.totalVehicle);
        int[] a = new int[2];
        a= objServices.getServiceTotalVehicle_AND_Amount();
        strVh.setText(String.valueOf(a[0]));
        strAm.setText(String.valueOf(a[1]));
    }

    private void tableRows(View vv) {
        lvListID =(ListView) vv.findViewById(R.id.ServicesList);
        sList =objServices.getAllServicebyDailyDate();  // Assigning to List From MngServices Class
        adapter = new ServicesAdapter( getActivity(),sList);
        lvListID.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
