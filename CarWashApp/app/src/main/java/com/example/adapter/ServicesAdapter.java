package com.example.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.carwashapp.R;
import com.example.model.Services;
import java.util.ArrayList;
import java.util.List;

public class ServicesAdapter extends BaseAdapter {

    public Context context;
    public List<Services> lstService ;

    public ServicesAdapter(Context context, List<Services> lstService) {
        this.context = context;
        this.lstService = lstService;
    }

    @Override
    public Object getItem(int position) {
        return lstService.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lstService.get(position).getLocalServiceID();
    }

    @Override
    public int getCount() {
        return lstService.size();
    }

    @Override
    public View getView(int position, View _v, ViewGroup parent) {
        _v = View.inflate(context, R.layout.service_list_row,null);

        TextView VehicleMake  = (TextView)_v.findViewById(R.id.trVehicleMake);
        TextView ServiceType= (TextView)_v.findViewById(R.id.trServiceType);
        TextView VehicleModel = (TextView)_v.findViewById(R.id.trVehicleModel);
        TextView VehicleReg = (TextView)_v.findViewById(R.id.trVehicleReg);
        TextView CustomerName = (TextView)_v.findViewById(R.id.trCustomerName);
        TextView Amount = (TextView)_v.findViewById(R.id.trAmount);

        VehicleMake.setText(lstService.get(position).getVehicleMake());
        Services s = lstService.get(position);
        VehicleModel.setText(s.getVehicleModel());
        VehicleReg.setText(s.getVehicleReg());
        CustomerName.setText(s.getCustomerName());
        ServiceType.setText(s.getServiceType());
        Amount.setText(s.getAmount());

        return _v;
    }
}
