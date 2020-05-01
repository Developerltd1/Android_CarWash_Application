package com.example.carwashapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mngClasses.MngServices;
import com.example.model.Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class ActivityHome extends Fragment  implements AdapterView.OnItemSelectedListener  {

    Spinner spMake, spService,spParty, spVehicleType;
    ArrayAdapter<CharSequence> arrayAdapter;
    TextView tvDate,tvTime;
    EditText edtvehicleModel, edtVreg, edtCustomerName, edtContact,edtCommision,edtAmount, edtComment;
    Button btnSave;
    Services mService = new Services();

    //Fregment Creation
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_home,container, false);
    }

    //Fregment Create Method
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initilize(view);
        spService.setOnItemSelectedListener(this);
        AddData();
    }

    public void initilize(View view){

        // -----------Components--------------- //
        //Spinner
        spMake =  view.findViewById(R.id.spVehicleMake);
        spService = view.findViewById(R.id.spService);
        spParty = view.findViewById(R.id.spParty);
        spVehicleType = view.findViewById(R.id.spVehicleType);
        //TextView
        tvDate = view.findViewById(R.id.tvDate);
        tvTime = view.findViewById(R.id.tvTime);
        //EditText
        edtvehicleModel = view.findViewById(R.id.edtVModel);
        edtVreg = view.findViewById(R.id.edtVRegNo);
        edtCommision = view.findViewById(R.id.edtCommision);
        edtAmount = view.findViewById(R.id.edtPrice);
        edtCustomerName = view.findViewById(R.id.edtCustomerName);
        edtContact = view.findViewById(R.id.edtContact);
        edtComment = view.findViewById(R.id.edtComments);

        //Buttons
        btnSave = view.findViewById(R.id.btnSave);

        //ComboBox 1
        // String [] cbvehicleMake =new String[]{"Toyota1","Honda","Suzuki","BMW","Faw"};

        arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array._VehicleType,R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spVehicleType.setAdapter(arrayAdapter);

                arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array._Party,R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spParty.setAdapter(arrayAdapter);

        arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array._vehicleMake,R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spMake.setAdapter(arrayAdapter);
        //ComboBox 2
        spMake.setOnItemSelectedListener(this);
        arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array._serviceType,R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spService.setAdapter(arrayAdapter);


    }
    public void AddData(){

       //----------------Date 1----------------------//
        //Current-Date & Time
        Calendar calendar = Calendar.getInstance();

        //Current-Time
        SimpleDateFormat Ttime = new SimpleDateFormat("h:mm a");
        tvTime.setText(Ttime.format(calendar.getTime()));

        //-----------------Date 2---------------------//
        Date dt = new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
       // SimpleDateFormat sdf =new SimpleDateFormat("YYYY-MM-DD");
        String currentDate2 = sdf.format(dt);
        tvDate.setText(currentDate2);

        //TODO Insert
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        try {
          MngServices objService = new MngServices(getActivity());
          //if(_spMake.length() != 0 || _spService.length() != 0 || _edtvehicleModel.length() != 0 || _edtVreg.length() != 0 || _edtCustomerName.length() != 0 || _edtContact.length() != 0 || _edtAmount.length() != 0 || _edtParty.length() != 0) {
         //_edtComment = edtComment.getText().toString();

          mService.setvDate(tvDate.getText().toString());
          mService.setvTime(tvTime.getText().toString());
           mService.setServiceType(spService.getSelectedItem().toString());
           mService.setVehicleType(spVehicleType.getSelectedItem().toString());
           mService.setVehicleMake(spMake.getSelectedItem().toString());
           mService.setParty(spParty.getSelectedItem().toString());
              mService.setVehicleModel(edtvehicleModel.getText().toString());
              mService.setVehicleReg(edtVreg.getText().toString());
              mService.setCommision(edtCommision.getText().toString());
              mService.setAmount(edtAmount.getText().toString());
              mService.setCustomerName(edtCustomerName.getText().toString());
              mService.setContact(edtContact.getText().toString());
              mService.setComments(edtComment.getText().toString());
              mService.setisUpload(0);

        if (
            edtAmount.getText().toString().trim().isEmpty() || edtAmount.getText().toString().trim() == null ||
            edtvehicleModel.getText().toString().trim().isEmpty() || edtvehicleModel.getText().toString().trim() == null ||
            edtVreg.getText().toString().trim().isEmpty() || edtVreg.getText().toString().trim() == null ||
            edtCommision.getText().toString().trim().isEmpty() || edtCommision.getText().toString().trim() == null ||
            edtCustomerName.getText().toString().trim().isEmpty() || edtCustomerName.getText().toString().trim() == null ||
            edtContact.getText().toString().trim().isEmpty() || edtContact.getText().toString().trim() == null
           ){
                Toast.makeText(getActivity(), "Enter complete details", Toast.LENGTH_SHORT).show();
            }

            else if (objService.insertService(mService) == true) {
          //  objService.insertService(mService);
         Toast.makeText(getActivity(), "Data Saved Successfully ! ", Toast.LENGTH_SHORT).show();

        spService.setSelection(0);spVehicleType.setSelection(0);spMake.setSelection(0);spParty.setSelection(0);
        edtvehicleModel.setText("");edtVreg.setText("");edtCommision.setText("");edtAmount.setText("");
        edtCustomerName.setText("");edtContact.setText("");edtComment.setText("");
    }
            else {
                 Toast.makeText(getActivity(), "Data Save Error", Toast.LENGTH_SHORT).show();
    }
 //}else {
   //  Toast.makeText(ActivityHome.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();}

}catch(Exception e){
    Toast.makeText(getActivity(), "Error: "+e, Toast.LENGTH_SHORT).show();
}
            }
        });
    }

    //Empty
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }
    //Empty
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
