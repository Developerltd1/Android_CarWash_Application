package com.example.carwashapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.mngClasses.MngServices;

public class PartyReport extends Fragment implements AdapterView.OnItemSelectedListener   {


    MngServices objServices;

//Fregment Creation
@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_party_report,container, false);
    }

    //Fregment Create Method
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        objServices = new MngServices(getActivity());
        dashboardComponents(view);
    }


    public void dashboardComponents(View vv) {

        //------PARTY 01------------//
        TextView party1Veh = (TextView) vv.findViewById(R.id.party1Vehicle);
        TextView party1Amount = (TextView) vv.findViewById(R.id.party1_Amount);
        TextView party1commision = (TextView) vv.findViewById(R.id.party1_commision);
        TextView party1InitialAmount = (TextView) vv.findViewById(R.id.party1_InitialAmount);
        int[] a = new int[4];
        a= objServices.getService_WherePARTY1();
        party1Veh.setText(String.valueOf(a[0]));
        party1Amount.setText(String.valueOf(a[1]));
        party1commision.setText(String.valueOf(a[2]));
        party1InitialAmount.setText(String.valueOf(a[3]));

        //------PARTY 02------------//
        TextView party2Veh = (TextView) vv.findViewById(R.id.party2Vehicle);
        TextView party2Amount = (TextView) vv.findViewById(R.id.party2Amount);
        TextView party2commision = (TextView) vv.findViewById(R.id.party2_commision);
        TextView party2InitialAmount = (TextView) vv.findViewById(R.id.party2_InitialAmount);
        int[] b = new int[4];
        b= objServices.getService_WherePARTY2();
        party2Veh.setText(String.valueOf(b[0]));
        party2Amount.setText(String.valueOf(b[1]));
        party2commision.setText(String.valueOf(b[2]));
        party2InitialAmount.setText(String.valueOf(b[3]));

        //------PARTY 03------------//
        TextView party3Veh = (TextView) vv.findViewById(R.id.party3Vehicle);
        TextView party3Amount = (TextView) vv.findViewById(R.id.party3_Amount);
        TextView party3commision = (TextView) vv.findViewById(R.id.party3_commision);
        TextView party3InitialAmount = (TextView) vv.findViewById(R.id.party3_InitialAmount);
        int[] c = new int[4];
        c= objServices.getService_WherePARTY3();
        party3Veh.setText(String.valueOf(c[0]));
        party3Amount.setText(String.valueOf(c[1]));
        party3commision.setText(String.valueOf(c[2]));
        party3InitialAmount.setText(String.valueOf(c[3]));

        //------PARTY 04------------//
        TextView party4Veh = (TextView) vv.findViewById(R.id.party4Vehicle);
        TextView party4Amount = (TextView) vv.findViewById(R.id.party4Amount);
        TextView party4commision = (TextView) vv.findViewById(R.id.party4_commision);
        TextView party4InitialAmount = (TextView) vv.findViewById(R.id.party4_InitialAmount);
        int[] d = new int[4];
        d= objServices.getService_WherePARTY4();
        party4Veh.setText(String.valueOf(d[0]));
        party4Amount.setText(String.valueOf(d[1]));
        party4commision.setText(String.valueOf(d[2]));
        party4InitialAmount.setText(String.valueOf(d[3]));

        //------PARTY 05------------//
        TextView party5Veh = (TextView) vv.findViewById(R.id.party5Vehicle);
        TextView party5Amount = (TextView) vv.findViewById(R.id.party5_Amount);
        TextView party5commision = (TextView) vv.findViewById(R.id.party5_commision);
        TextView party5InitialAmount = (TextView) vv.findViewById(R.id.party5_InitialAmount);
        int[] e = new int[4];
        e= objServices.getService_WherePARTY5();
        party5Veh.setText(String.valueOf(e[0]));
        party5Amount.setText(String.valueOf(e[1]));
        party5commision.setText(String.valueOf(e[2]));
        party5InitialAmount.setText(String.valueOf(e[3]));


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
