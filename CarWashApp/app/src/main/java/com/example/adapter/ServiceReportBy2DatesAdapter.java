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

public class ServiceReportBy2DatesAdapter  extends RecyclerView.Adapter<ServiceReportBy2DatesAdapter.DataViewHolder>
 {

    Context context;
    ArrayList<Services> ssList;

    public ServiceReportBy2DatesAdapter(Context context, ArrayList<Services> adata) {
        this.context = context;
        this.ssList = adata;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_servicereportby2dates,viewGroup,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int position) {
        Services mSser = ssList.get(position); //getList Data to Model

        dataViewHolder.Date2.setText(mSser.getvDate());
        dataViewHolder.Time2.setText(mSser.getvTime());
        dataViewHolder.ServiceType2.setText(mSser.getServiceType());
        dataViewHolder.VehcicleType2.setText(mSser.getVehicleType());
        dataViewHolder.VehicleMake2.setText(mSser.getVehicleMake());
        dataViewHolder.RegNo2.setText(mSser.getVehicleReg());
        dataViewHolder.Amount2.setText(mSser.getAmount());
    }

    @Override
    public int getItemCount() {
        return ssList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        TextView Date2,Time2,ServiceType2,VehcicleType2,VehicleMake2,RegNo2,Amount2;
        public DataViewHolder(View view) {
            super(view);
            Date2=(TextView) itemView.findViewById(R.id.tvdate2);
            Time2=(TextView) itemView.findViewById(R.id.tvTime2);
            ServiceType2=(TextView) itemView.findViewById(R.id.tvServiceType2);
            VehcicleType2=(TextView) itemView.findViewById(R.id.tvVehicleType2);
            VehicleMake2=(TextView) itemView.findViewById(R.id.tvVehicleMake2);
            RegNo2=(TextView) itemView.findViewById(R.id.tvregNo2);
            Amount2=(TextView) itemView.findViewById(R.id.tvAmount2);
        }
    }
}
