package com.example.carwashapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mngClasses.MngBusiness;
import com.example.model.MdlBusiness;
import com.example.model.Services;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    TextView serverResp;
    EditText edRegBusinessTitle, edRegUserName, edRegPassword, edRegConactNo;
    Button btnRegister;
   // String URL_Business = "https://testapi.11sol.com/api/Business/PostBusiness",SuccessMsg = "";
    TelephonyManager tel;
   // PostBusiness pb  ;
    MngBusiness objBus;

    @SuppressLint("ServiceCast")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        objBus = new MngBusiness(getApplicationContext());

        edRegBusinessTitle = (EditText) findViewById(R.id.edRegTitle);
        edRegUserName = (EditText) findViewById(R.id.edRegUserName);
        edRegPassword = (EditText) findViewById(R.id.edRegPassword);
        edRegConactNo = (EditText) findViewById(R.id.edRegConactNo);

        tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        //TODO Buttton
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }//Permission for IMEI

        IMEI  = tel.getDeviceId();
        isActive = false;
        //region REGION-> BUTTON
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MBusiness = new MdlBusiness();
                MBusiness.setBusinessTitle(edRegBusinessTitle.getText().toString());
                MBusiness.setUserName(edRegUserName.getText().toString());
                MBusiness.setPassword(edRegPassword.getText().toString());
                MBusiness.setContactNo(edRegConactNo.getText().toString());
                MBusiness.setImeiNo(IMEI);
               /* MBusiness.setBusinessID(Integer.parseInt( pb.SERVERbusinessID) == Integer.parseInt( pb.SERVERbusinessID) ?  Integer.parseInt( pb.SERVERbusinessID):0 );
                MBusiness.setBusinessUser_ID(Integer.parseInt( pb.SERVERbusinessUserID));*/


                // MBusiness.setActive(isActive);
                if(edRegBusinessTitle.getText().toString().isEmpty() || edRegBusinessTitle.getText().toString() == ""||
                        edRegUserName.getText().toString().isEmpty() ||edRegUserName.getText().toString() == ""||
                        edRegPassword.getText().toString().isEmpty() || edRegPassword.getText().toString() == ""||
                        edRegConactNo.getText().toString().isEmpty() ||edRegConactNo.getText().toString() == ""
                ){
                    Toast.makeText(Registration.this, "Please Fill All Fields !", Toast.LENGTH_SHORT).show();
                }else {

                  //  apiCalling(); //OLD
                    new PostBusiness().execute(); //NEW


                }

            }//onClick
        });//Btn
//endregion
    }//onCreate

  MdlBusiness MBusiness;
    String IMEI;
    boolean isActive;
    /*private void insertInLocalDatabase() {

        if (objBus.insertBusiness(MBusiness,Integer.parseInt(pb.SERVERbusinessID),Integer.parseInt(pb.SERVERbusinessUserID)) == true) {
           // objBus.insertService(mService);
          }
        }*/

       //region   REGION-> OLD CODE...
   /* private void apiCalling() {

        HashMap<String,String> map= new HashMap<>();
        //OLD
        map.put("BusinessTitle",MBusiness.getBusinessTitle());
        map.put("ImeNumber",MBusiness.getImeiNo());
        map.put("UserName",MBusiness.getUserName());
        map.put("Password",MBusiness.getPassword());
        map.put("ContactNo",MBusiness.getContactNo());
        //map.put("Businessid",Integer.toString(9));
        //map.put("BusinessUser_ID",Integer.toString(9));

        //map.get("",)
      //  new Registration.ApiSetting(map).execute();

        //new PostBusiness().execute();
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
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressDialog= new ProgressDialog(Registration.this);
                    progressDialog.setMessage("Please Wait...");
                    progressDialog.show();
                }
            });
        }
       //Post
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();

                    edRegBusinessTitle.setText("");
                    edRegUserName.setText("");
                    edRegPassword.setText("");
                    edRegConactNo.setText("");
                    Toast.makeText(getApplication(), "Registration Successfully !", Toast.LENGTH_SHORT).show();

                }
            });
        }
        @Override
        protected Object doInBackground(Object[] objects) {
            URL url;
            HttpURLConnection httpURLConnection;
            try {
                //  url = new URL("http://localhost:2133/api/Business/PostBusiness"); // App Local
                url = new URL("http://localhost:8080/api/Business/PostBusiness"); //  IIS Local

                //url = new URL("https://testapi.11sol.com/api/Business/PostBusiness"); // Online Server
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
                    return "data found";
                } else {
                    Toast.makeText(Registration.this, "No Data Found !", Toast.LENGTH_SHORT).show();
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
            {
                bol = false;
            }
            else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return sb.toString();
    }//HashMap Settingfor Api*/
//endregion

//region   REGION-> NEW CODE...

    private class PostBusiness extends AsyncTask<Void, Void, String> {

      public  String SERVERbusinessUserID = "", SERVERbusinessID = "";//,status;

        private final ProgressDialog dialog = new ProgressDialog(Registration.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.dialog.setMessage("Data Loading...");
            this.dialog.show();
        }

        @Override
        protected String doInBackground(Void... param) {

            HttpClient httpclient = new DefaultHttpClient();
            String responseStr = "";
            int responseCode = 0;
            HttpPost HttpPost = new HttpPost("http://www.subdom.somee.com/api/Business/PostBusiness");
            try {

                HttpPost.setEntity(new StringEntity(PostBusines(MBusiness.getBusinessTitle(),MBusiness.getImeiNo(),MBusiness.getUserName(),MBusiness.getPassword(),MBusiness.getContactNo()), "UTF-8"));
                HttpPost.setHeader("Content-type", "application/json");
                HttpResponse response = httpclient.execute(HttpPost);
                responseCode = response.getStatusLine().getStatusCode();
                switch (responseCode) {
                    case 200:
                        HttpEntity entity = response.getEntity();
                        if (entity != null) {
                            String responseBody = EntityUtils.toString(entity);
                            responseStr = responseBody;
                        }
                        break;
                }
            } catch (ClientProtocolException e) {
                Log.e("ClientProtocolException", "" + e.getMessage());
                // TODO Auto-generated catch block
            } catch (IOException e) {
                // TODO Auto-generated catch block
                Log.e("IOException", "" + e.getMessage());
            }
            System.out.println("this is response " + responseStr + " response Code" + responseCode);

            return responseStr;
            //return null;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            Log.d("response001", response);
            dialog.dismiss();

            if (response != null)
            {
                JSONObject jsonObject = null;
                try
                {
                    jsonObject = new JSONObject(response);
                    //status = jsonObject.getString("status");
                    //if (status=="1"){
                    SERVERbusinessID = jsonObject.getString("businessID");
                    SERVERbusinessUserID = jsonObject.getString("businessUserID");
                        Log.e("businessID001",""+SERVERbusinessID);
                        Log.e("SERVERbusinessUserID",""+SERVERbusinessUserID);
                    if(Integer.parseInt(SERVERbusinessID)>0)
                    {
                        if(objBus.insertBusiness(MBusiness,Integer.parseInt(SERVERbusinessID),Integer.parseInt(SERVERbusinessUserID)) == true)
                        {
                            Toast.makeText(Registration.this, " Registeration Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Registration.this,ActivitySignIn.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    else
                    {
                        Toast.makeText(Registration.this, " Something went Wrong! Registeration Not Successfully!", Toast.LENGTH_SHORT).show();
                    }
                    /*}else if (status=="0"){
                        Toast.makeText(Registration.this, "Not Registerd", Toast.LENGTH_SHORT).show();
                    }*/
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }




    public static String PostBusines(String BusinessTitle, String ImeNumber,
                                String UserName, String Password,
                                String ContactNo) {
        JSONObject jsonObject = null;

        jsonObject = new JSONObject();
        try {
            jsonObject.put("BusinessTitle", BusinessTitle);
            jsonObject.put("ImeNumber", ImeNumber);
            jsonObject.put("UserName", UserName);
            jsonObject.put("Password", Password);
            jsonObject.put("ContactNo", ContactNo);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("json0012", "" + e.getMessage());
        }
        Log.e("jsonObject", "" + jsonObject);
        return jsonObject.toString();

    }

//endregion

}//Main-Class