package com.example.carwashapp;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.ServiceReportBy2DatesAdapter;
import com.example.mngClasses.MngServices;
import com.example.model.Services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ListServiceReportBy2Dates extends Fragment implements AdapterView.OnItemSelectedListener {

    ServiceReportBy2DatesAdapter adapter;  //Adpater
    ArrayList<Services> sList;  //List
    MngServices objServices;  //Methods
    RecyclerView recyclerViewID2dates;   //Recycler_ID

    Button btnSreach;
    TextView edStartDate;
    TextView edEndDate;
    Calendar calendar;
    int day ;
    int month ;
    int year ;

    int dateSequence;

    //Fragment Creation
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_list_servicereportby2dates,container, false);
    }

    //Fragment Create Method
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        objServices = new MngServices(getActivity());
        recyclerViewID2dates =(RecyclerView) view.findViewById(R.id.recyclerViewID_ReportBy2Dates);
        recyclerViewID2dates.setHasFixedSize(true);
        recyclerViewID2dates.setLayoutManager(new LinearLayoutManager(getActivity()));
        //StoE_date(view);
        SStoE_date(view);
    }
    String dayUpdate;
    private void SStoE_date(View view) {

        calendar = Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);


        dateSequence = year + month + day;

        edStartDate = (TextView) view.findViewById(R.id.edStartDate);
        edStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DatePicker Dialog

                DatePickerDialog startDP = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker dp, int year, int month, int dayOfMonth) {

                        month = month +1;

                        String fm=""+month;
                        if(month<10){
                            fm ="0"+month;
                        }
                        String fd=""+dayOfMonth;
                        if (dayOfMonth<10){
                            fd="0"+dayOfMonth;
                        }

                       edStartDate.setText( year+ "-" + fm + "-" + fd );
                    }
                },year,month,day);
                startDP.show();
            }
        });

        edEndDate =(TextView)view.findViewById(R.id.edEndDate);
        edEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DatePicker Dialog
                DatePickerDialog endDP = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker dp, int year, int month, int dayOfMonth) {

                        month = month +1;


                        String fm=""+month;
                        if(month<10){
                            fm ="0"+month;
                        }
                        String fd=""+dayOfMonth;
                        if (dayOfMonth<10){
                            fd="0"+dayOfMonth;
                        }

                        edEndDate.setText( year+ "-" + fm + "-" + fd );
                    }
                },year,month,day);
                endDP.show();
            }
        });

        btnSreach=(Button)view.findViewById(R.id.btnSreach);
        btnSreach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _allDataShow();
                Toast.makeText(getActivity(), "Show Me", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void _allDataShow() {
        sList =objServices.getReportBySelect2Dates(edStartDate.getText().toString(),edEndDate.getText().toString());  // Assigning to List From MngServices Class
        adapter = new ServiceReportBy2DatesAdapter(getActivity(),sList);
        recyclerViewID2dates.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}