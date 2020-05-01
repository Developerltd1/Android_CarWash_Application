package com.example.carwashapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.ServiceDailyReportAdapter;
import com.example.adapter.ServiceReportBy2DatesAdapter;
import com.example.adapter.ServicesAdapter;
import com.example.adapter.ServicesBackupAdapter;
import com.example.interfaceses.AppUtils;
import com.example.mngClasses.MngServices;
import com.example.model.Services;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackupRepport extends Fragment implements AdapterView.OnItemSelectedListener {

    Services modelService; //Model
    MngServices objServices; //Methods
    ArrayList<Services> sList;  //List
    ServicesBackupAdapter adapter; //Adpater
    RecyclerView recyclerViewIDBackUp;   //Recycler_ID

  Button btnUploading;

    //Fregment Creation
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_backreport,container, false);
    }

    //Fregment Create Method
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        objServices = new MngServices(getActivity());
       udmBackupMethod(view);

       btnUploading = view.findViewById(R.id.btnUploading);
       btnUploading.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(AppUtils.isConnected(getActivity())) {

                   apiCalling();
               }else {
                   AppUtils.buildDialog2(getActivity()).show();
               }
           }
       });

    }

    private void udmBackupMethod(View view) {

        recyclerViewIDBackUp =(RecyclerView) view.findViewById(R.id.recyclerViewID_BackUp);
        recyclerViewIDBackUp.setHasFixedSize(true);
        recyclerViewIDBackUp.setLayoutManager(new LinearLayoutManager(getActivity()));

        sList =objServices.getAllServiceForBackup(0);  // Assigning to List From MngServices Class
        adapter = new ServicesBackupAdapter(getActivity(),sList);
        recyclerViewIDBackUp.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    int counter;
    String localSID,SType,VType,VMake,Party,VModel,VReg,CName,Contact,coment,amount,commision,B_ID;
    private void apiCalling() {

        List<Services> dataInList =  sList ;

        if (dataInList != null && !dataInList.isEmpty()) {
            for (counter = 0; counter < dataInList.size(); counter++) {

                localSID = String.valueOf(dataInList.get(counter).getLocalServiceID());
                SType = String.valueOf(dataInList.get(counter).getServiceType());
                VType = String.valueOf(dataInList.get(counter).getVehicleType());
                VMake = String.valueOf(dataInList.get(counter).getVehicleMake());
                Party = String.valueOf(dataInList.get(counter).getParty());
                VModel = String.valueOf(dataInList.get(counter).getVehicleModel());
                VReg = String.valueOf(dataInList.get(counter).getVehicleReg());
                CName = String.valueOf(dataInList.get(counter).getCustomerName());
                Contact = String.valueOf(dataInList.get(counter).getContact());
                coment = String.valueOf(dataInList.get(counter).getComments());
                amount = String.valueOf(dataInList.get(counter).getAmount());
                commision = String.valueOf(dataInList.get(counter).getCommision());
                B_ID =  String.valueOf(dataInList.get(counter).getBusiness_ID());//

                HashMap<String, String> map = new HashMap<>();
                Services s = new Services();
                map.put("LocalServiceID", localSID);
                map.put("ServiceType", SType);
                map.put("VehicleType", VType);
                map.put("VehicleMake", VMake);
                map.put("Party", Party);
                map.put("VehicleModel", VModel);
                map.put("VehicleReg", VReg);
                map.put("CustomerName", CName);
                map.put("Contact", Contact);
                map.put("Comments", coment);
                map.put("Amount", amount);
                map.put("Commision", commision);
                map.put("Business_ID", B_ID);

                new BackupRepport.ApiSetting(map).execute();
                // "Update tblService set IsUpload = 1 where LocalServiceID = localSID"
            }
        }
        else{ Toast.makeText(getActivity(), "No Data for Backup !", Toast.LENGTH_SHORT).show(); }

    }// Method-ApiCalling

    public class ApiSetting extends AsyncTask {
        String result;
        int response;
        HashMap<String, String> postData;

        public ApiSetting(HashMap<String, String> data) {
            postData = new HashMap<String, String>();
            postData = data;
        }
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog= new ProgressDialog(getActivity());
            progressDialog.setMessage("Please Wait...");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            //todo for Realtime show data in Backup
            objServices.updateService(modelService);
            sList= objServices.getAllServiceForBackup(0);
            adapter = new ServicesBackupAdapter(getActivity(),sList);
            recyclerViewIDBackUp.setAdapter(adapter);

            if (progressDialog.isShowing())
                progressDialog.dismiss();
            //Toast.makeText(getActivity(), "Data Backup Successfully " +counter , Toast.LENGTH_SHORT).show();
            //Toast.makeText(getActivity(), "Backup Data Row: " +counter , Toast.LENGTH_SHORT).show();
         }

        @Override
        protected Object doInBackground(Object[] objects) {
            URL url;
            HttpURLConnection httpURLConnection;
            try {
                url = new URL("http://www.subdom.somee.com/api/Service/PostServices");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestMethod("POST");
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os));
                bfw.write(HashMapSettingforAPI(postData));
                bfw.flush();
                bfw.close();
                response = httpURLConnection.getResponseCode();
                if (response == HttpURLConnection.HTTP_OK) {
                  //  Toast.makeText(getActivity(), "doInBackground", Toast.LENGTH_SHORT).show();
                    return "data found";
                } else {
//                    Toast.makeText(getActivity(), "No Data Found !", Toast.LENGTH_SHORT).show();
                    result = "no data found";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }//Inner-Class

    public String HashMapSettingforAPI(HashMap<String, String> hmap) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        Boolean bol = true;
        for (Map.Entry<String, String> entry : hmap.entrySet()) {
            if (bol)
            { bol = false; }
            else
            { sb.append("&"); }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return sb.toString();
    }//HashMap Settingfor Api



}
