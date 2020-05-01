package com.example.carwashapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.example.adapter.ServiceDailyReportAdapter;
import com.example.mngClasses.MngServices;
import com.example.model.Services;

import java.util.ArrayList;

public class ListServiceDailyReport extends Fragment implements AdapterView.OnItemSelectedListener {

    ServiceDailyReportAdapter adapter;  //Adpater
    ArrayList<Services> sList;  //List
    MngServices objServices;  //Methods
    RecyclerView recyclerViewID;   //Recycler_ID

    //Fregment Creation
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_list_servicedailyreport,container, false);
    }


    //Fregment Create Method
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        objServices = new MngServices(getActivity());
        allDataShow(view);
    }

    private void allDataShow(View view) {

        recyclerViewID =(RecyclerView) view.findViewById(R.id.recyclerViewID_dailyReport);
        recyclerViewID.setHasFixedSize(true);
        recyclerViewID.setLayoutManager(new LinearLayoutManager(getActivity()));

        sList =objServices.getDailyReport();  // Assigning to List From MngServices Class
        adapter = new ServiceDailyReportAdapter(getActivity(),sList);
        recyclerViewID.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
