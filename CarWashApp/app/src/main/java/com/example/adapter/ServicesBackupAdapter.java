package com.example.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carwashapp.BackupRepport;
import com.example.carwashapp.R;
import com.example.carwashapp.Registration;
import com.example.model.MdlServices;
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
import java.util.Map;

public class ServicesBackupAdapter extends  RecyclerView.Adapter<ServicesBackupAdapter.DataViewHolder>{

    Context context;
    ArrayList<Services> sList;

    public ServicesBackupAdapter(Context context, ArrayList<Services> adata) {
        this.context = context;
        this.sList = adata;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.backup_list_row,viewGroup,false);
        return new ServicesBackupAdapter.DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int position) {

        Services mSer = sList.get(position); //getList Data to Model

        dataViewHolder.trBackup_VehicleID.setText(String.valueOf(mSer.getLocalServiceID()));
        dataViewHolder.trBackup_VehicleType.setText(mSer.getVehicleType());
        dataViewHolder.trBackup_VehicleMake.setText(mSer.getVehicleMake());
        dataViewHolder.trBackup_VehicleModel.setText(mSer.getVehicleModel());
        dataViewHolder.trBackup_Amount.setText(mSer.getAmount());
       // dataViewHolder.trBackup_isUpload.setText(String.valueOf(mSer.getisUpload()));
    }

    @Override
    public int getItemCount() {
        return sList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

    TextView trBackup_VehicleID,trBackup_VehicleType,trBackup_VehicleMake,trBackup_VehicleModel,trBackup_Amount;
        TextView trBackup_isUpload,trBackupBusiness_ID;
    public DataViewHolder(View view)
       {
        super(view);

        trBackup_VehicleID=(TextView) itemView.findViewById(R.id.trbackup_VehicleID);
        trBackup_VehicleType=(TextView) itemView.findViewById(R.id.trbackup_VehicleType);
        trBackup_VehicleMake=(TextView) itemView.findViewById(R.id.trbackup_VehicleMake);
        trBackup_VehicleModel=(TextView) itemView.findViewById(R.id.trbackup_VehicleModel);
        trBackup_Amount=(TextView) itemView.findViewById(R.id.trbackup_Amount);
        trBackupBusiness_ID=(TextView) itemView.findViewById(R.id.trbackupBusiness_ID);

           //trBackup_isUpload=(TextView) itemView.findViewById(R.id.trbackup_isUpload);


       }
    }
}
