package com.blueskylinks.spc_main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RealClockTimeActivity extends AppCompatActivity {
    String phoneNumber = "9663261329";
    Spinner spinner;
    Spinner spinner1;
    String selectedItem;
    String SMSBody1;
    TextView text;
    LinearLayout mainLayout;
    TextView tv;
    TextView tv2;
    ProgressBar pbar;
    EditText et1;
    EditText et2;
    String s1;
    String s2;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_clock_time);
        spinner=findViewById(R.id.spinner1);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        tv=findViewById(R.id.textView1);
        text=findViewById(R.id.onoff_status_text_1);
        tv2=findViewById(R.id.textView2);
        pbar=findViewById(R.id.pbar);
        mainLayout=findViewById(R.id.spinnerLayout);
        spinner1 = new Spinner(this);

        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                String added_number = et2.getText().toString();
                if (added_number.length() != 0) {
                    number  = Integer.parseInt(added_number);

                    if (number > 59)
                        Toast.makeText(RealClockTimeActivity.this, "Not more than 59", Toast.LENGTH_SHORT).show();
                      // et2.setError("Enter mins less than 60");
                    et2.setMaxEms(1);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }
            });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // selectedItem = parent.getItemAtPosition(position).toString();
                Log.i("position ", String.valueOf(position));
                switch (position){
                    case 1:
                        mainLayout.removeView(spinner1);
                        et1.setVisibility(View.INVISIBLE);
                        et2.setVisibility(View.INVISIBLE);
                        setRTC();
                        break;
                    case 2:
                        mainLayout.removeView(spinner1);
                        et1.setVisibility(View.VISIBLE);
                        et2.setVisibility(View.VISIBLE);
                        setRTC1();
                        break;
                    case 3:
                        mainLayout.removeView(spinner1);
                        et1.setVisibility(View.VISIBLE);
                        et2.setVisibility(View.VISIBLE);
                        setRTC2();
                        break;
                    case 4:
                        mainLayout.removeView(spinner1);
                        et1.setVisibility(View.VISIBLE);
                        et2.setVisibility(View.VISIBLE);
                        setRTC3();
                         break;
                    default:
                        mainLayout.removeView(spinner1);
                        et1.setVisibility(View.INVISIBLE);
                        et2.setVisibility(View.INVISIBLE);
                        break;
                }
            }
            // to close the onItemSelected
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();
                Log.i("position ", selectedItem);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        SMSBody1="";
        final IntentFilter cintentFilter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        registerReceiver(RealClockReceiver, cintentFilter);
        registerReceiver(RealClockReceiver,cintentFilter);
    }

    public void set_function(View view){
        if(selectedItem.equals("RTC Function on")){
            String message = "SPC,27,1";
            SmsManager smsManager = SmsManager.getDefault();
            //smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Log.i("Test", message);
            pbar.setVisibility(View.VISIBLE);
            text.setText("Command Sent, Please Wait...For 2 minutes");
        }
        else if(selectedItem.equals("RTC Function off")){
            String message = "SPC,27,0";
            SmsManager smsManager = SmsManager.getDefault();
           // smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Log.i("Test", message);
            pbar.setVisibility(View.VISIBLE);
            text.setText("Command Sent, Please Wait...For 2 minutes");
        }
        else if(selectedItem.equals("RTC_1 on")){
            s1=et1.getText().toString();
            s2=et2.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)|| number>59 ){
                if(TextUtils.isEmpty(s1)) et1.setError("please enter time!!");
                else et2.setError("please enter time!!");
            }else{
            String message = "SPC,28,"+s1+","+s2;
            SmsManager smsManager = SmsManager.getDefault();
           // smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Log.i("Test", message);
            pbar.setVisibility(View.VISIBLE);
            text.setText("Command Sent, Please Wait...For 2 minutes");
           }
            et1.getText().clear();
            et2.getText().clear();
        }
        else if(selectedItem.equals("RTC_1 off")){
            s1=et1.getText().toString();
            s2=et2.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2) || number>59){
                if(TextUtils.isEmpty(s1)) et1.setError("please enter time!!");
                else et2.setError("please enter time!!");
            }else{
                String message = "SPC,29,"+s1+","+s2;
                SmsManager smsManager = SmsManager.getDefault();
                // smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Log.i("Test", message);
                pbar.setVisibility(View.VISIBLE);
                text.setText("Command Sent, Please Wait...For 2 minutes");
               } et1.getText().clear();
            et2.getText().clear();
        }
        else if(selectedItem.equals("RTC_2 on")){
            s1=et1.getText().toString();
            s2=et2.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||number>59){
                if(TextUtils.isEmpty(s1)) et1.setError("please enter time!!");
                else et2.setError("please enter time!!");
            }else{
                String message = "SPC,30,"+s1+","+s2;
                SmsManager smsManager = SmsManager.getDefault();
                // smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Log.i("Test", message);
                pbar.setVisibility(View.VISIBLE);
                text.setText("Command Sent, Please Wait...For 2 minutes");
              }  et1.getText().clear();
            et2.getText().clear();
        }
        else if(selectedItem.equals("RTC_2 off")){
            s1=et1.getText().toString();
            s2=et2.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||number>59){
                if(TextUtils.isEmpty(s1)) et1.setError("please enter time!!");
                else et2.setError("please enter time!!");
            }else{
                String message = "SPC,31,"+s1+","+s2;
                SmsManager smsManager = SmsManager.getDefault();
                // smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Log.i("Test", message);
                pbar.setVisibility(View.VISIBLE);
                text.setText("Command Sent, Please Wait...For 2 minutes");
                }et1.getText().clear();
            et2.getText().clear();
        }
        else if(selectedItem.equals("RTC_3 on")){
            s1=et1.getText().toString();
            s2=et2.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||number>59){
                if(TextUtils.isEmpty(s1)) et1.setError("please enter time!!");
                else et2.setError("please enter time!!");
            }else{
                String message = "SPC,32,"+s1+","+s2;
                SmsManager smsManager = SmsManager.getDefault();
                // smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Log.i("Test", message);
                pbar.setVisibility(View.VISIBLE);
                text.setText("Command Sent, Please Wait...For 2 minutes");
                }et1.getText().clear();
            et2.getText().clear();
        }
        else if(selectedItem.equals("RTC_3 off")){
            s1=et1.getText().toString();
            s2=et2.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||number>59){
                if(TextUtils.isEmpty(s1)) et1.setError("please enter time!!");
                else et2.setError("please enter time!!");
            }else{
                String message = "SPC,33,"+s1+","+s2;
                SmsManager smsManager = SmsManager.getDefault();
                // smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Log.i("Test", message);
                pbar.setVisibility(View.VISIBLE);
                text.setText("Command Sent, Please Wait...For 2 minutes");
               } et1.getText().clear();
            et2.getText().clear();
        }
    }

    public void setRTC(){
        ArrayList<String> RTC = new ArrayList<String>();
        RTC.add("RTC function on");
        RTC.add("RTC function off");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,RTC);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }

    public void setRTC1(){
        ArrayList<String> RTC_1 = new ArrayList<String>();
        RTC_1.add("RTC_1 on");
        RTC_1.add("RTC_1 off");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,RTC_1);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }
    public void setRTC2(){
        ArrayList<String> RTC_2 = new ArrayList<String>();
        RTC_2.add("RTC_2 on");
        RTC_2.add("RTC_2 off");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,RTC_2);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }
    public void setRTC3(){
        ArrayList<String> RTC_3 = new ArrayList<String>();
        RTC_3.add("RTC_3 on");
        RTC_3.add("RTC_3 off");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,RTC_3);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }
public void home(View view){
        Intent it=new Intent(RealClockTimeActivity.this,Main2Activity.class);
        startActivity(it);
}

    public void settings(View view){
        //starting another activity..
        Intent it1 = new Intent(RealClockTimeActivity.this, SettingsActivity.class);
        startActivity(it1);
    }

    public void ON_OFF(View view){
        //starting another activity..
        Intent it2 = new Intent(RealClockTimeActivity.this, ON_OFFActivity.class);
        startActivity(it2);
    }

    public void Users(View view){
        //starting another activity..
        Intent it3 = new Intent(RealClockTimeActivity.this, UsersActivity.class);
        startActivity(it3);
    }

    public void manual(View view){
        //starting another activity..
        Intent it4 = new Intent(RealClockTimeActivity.this, ManualActivity.class);
        startActivity(it4);
    }

    private final BroadcastReceiver RealClockReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent8) {
            if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent8.getAction())) {
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent8)) {
                    SMSBody1 = smsMessage.getMessageBody().toString();
                    Log.i("Received sms", SMSBody1);
                    String sms = SMSBody1;
                    Log.i("length", String.valueOf(SMSBody1.length()));
                    String[] lines = SMSBody1.split("\\r?\\n");

                    SMSBody1 = "";
                }
            }
        }
    };

    @Override
    public void onPause(){
        super.onPause();
        unregisterReceiver(RealClockReceiver);
    }

}
