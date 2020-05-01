package com.example.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carwashapp.R;
import com.example.model.Services;

import java.util.ArrayList;

public class ServiceDailyReportAdapter extends RecyclerView.Adapter<ServiceDailyReportAdapter.DataViewHolder>  {

    Context context;
    ArrayList<Services> sList;

    public ServiceDailyReportAdapter(Context context, ArrayList<Services> adata) {
        this.context = context;
        this.sList = adata;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_servicedailyreport,viewGroup,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int position) {

        Services mSer = sList.get(position); //getList Data to Model

        dataViewHolder.Time.setText(mSer.getvTime());
        dataViewHolder.ServiceType.setText(mSer.getServiceType());
        dataViewHolder.VehcicleType.setText(mSer.getVehicleType());
        dataViewHolder.VehicleMake.setText(mSer.getVehicleMake());
        dataViewHolder.RegNo.setText(mSer.getVehicleReg());
        dataViewHolder.Amount.setText(mSer.getAmount());
        dataViewHolder.commision.setText(mSer.getCommision());
        dataViewHolder.initAmount.setText(mSer.getInitAmount());
    }

    @Override
    public int getItemCount() {
        return sList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        TextView Time,ServiceType,VehcicleType,VehicleMake,RegNo,Amount,commision,initAmount;
        public DataViewHolder(View view) {
            super(view);

            Time=(TextView) itemView.findViewById(R.id.tvTime);
            ServiceType=(TextView) itemView.findViewById(R.id.tvServiceType);
            VehcicleType=(TextView) itemView.findViewById(R.id.tvVehicleType);
            VehicleMake=(TextView) itemView.findViewById(R.id.tvVehicleMake);
            RegNo=(TextView) itemView.findViewById(R.id.tvregNo);
            Amount=(TextView) itemView.findViewById(R.id.tvAmount);
            commision=(TextView) itemView.findViewById(R.id.tvCommision);
            initAmount=(TextView) itemView.findViewById(R.id.tvInitialAmount);
        }
    }
}
