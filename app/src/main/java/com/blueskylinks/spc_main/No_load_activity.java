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
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import static com.blueskylinks.spc_main.MainActivity.phoneNumber;

public class No_load_activity extends AppCompatActivity {
    RadioButton rbutton1;
    RadioButton rbutyon2;
    //String phoneNumber = "9880760642";
    ProgressBar pbar;
    ProgressBar pbar1;
    ProgressBar pbar2;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView tv;
    TextView tv1;
    TextView tv2;
    EditText et1;
    EditText et2;
    String SMSBody1;
    EditText et3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_load_activity);
        rbutton1=findViewById(R.id.radioButton);
        rbutyon2=findViewById(R.id.radioButton2);
        pbar=findViewById(R.id.onoff_pgbar1);
        tv=findViewById(R.id.mot_st);
        pbar1=findViewById(R.id.set1);
        pbar2=findViewById(R.id.set2);
        tv1=findViewById(R.id.dryrun1);
        tv2=findViewById(R.id.dryrun2);
        textView1=findViewById(R.id.onoff_status_text1);
        textView2=findViewById(R.id.onoff_status_text2);
        textView3=findViewById(R.id.onoff_status_text3);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
    }

    @Override
    public void onResume() {
        super.onResume();
        SMSBody1 = "";

        final IntentFilter nIntentFilter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        registerReceiver(NoloadReceiver, nIntentFilter);
        registerReceiver(NoloadReceiver, nIntentFilter);
    }

    public void turnsOn(View view) {
        String message = "";
        if (rbutton1.isChecked()) {
            message = "SPC,6,1";
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Log.i("message", message);
            Log.i("Test", "SMS sent!");
            pbar.setVisibility(View.VISIBLE);
            textView1.setText("Command Sent, Please Wait...For 2 minutes");
        }
        else if (rbutyon2.isChecked()) {
            message = "SPC,6,0";
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Log.i("message", message);
            Log.i("Test", "SMS sent!");
            pbar.setVisibility(View.VISIBLE);
            textView1.setText("Command Sent, Please Wait...For 2 minutes");
        } else return;

    }

    public void set_tripTime(View view) {
        Log.i("..", "trip time event");
        String text = et1.getText().toString();
        if (TextUtils.isEmpty(text)) et1.setError("please enter trip time!..");
        else {
            Log.i("..", text);
            String message = "SPC,7," + text;
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            pbar1.setVisibility(View.VISIBLE);
            Log.i("message", message);
            Log.i("Test", "SMS sent!");
            textView2.setText("Command Sent, Please Wait...For 2 minutes");

            et1.getText().clear();
        }
    }

    public void set_tripCurrent(View view) {

        String text = et2.getText().toString();
        Log.i("..", text);

        String text2 = et3.getText().toString();
        Log.i("..", text2);
        String message = " ";
        if (TextUtils.isEmpty(text) || TextUtils.isEmpty(text2)) {
            if (TextUtils.isEmpty(text)) et2.setError("please provide 3phase trip current!..");
            else et3.setError("please provide 2phase trip current!..");
        }
        else {
            message = "SPC,8" + "," + text + "," + text2;
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            pbar2.setVisibility(View.VISIBLE);
            Log.i("message", message);
            Log.i("Test", "SMS sent!");
            textView3.setText("Command Sent, Please Wait...For 2 minutes");

            et2.getText().clear();
            et3.getText().clear();
        }
    }

    public void settings(View view) {
        //starting another activity..
        Intent it1 = new Intent(No_load_activity.this, SettingsActivity.class);
        startActivity(it1);
    }

    public void ON_OFF(View view) {
        //starting another activity..
        Intent it2 = new Intent(No_load_activity.this, ON_OFFActivity.class);
        startActivity(it2);
    }

    public void Users(View view) {
        //starting another activity..
        Intent it3 = new Intent(No_load_activity.this, UsersActivity.class);
        startActivity(it3);
    }

    public void manual(View view) {
        //starting another activity..
        Intent it4 = new Intent(No_load_activity.this, ManualActivity.class);
        startActivity(it4);
    }

    public void home(View view) {
        Intent it5 = new Intent(No_load_activity.this, Main2Activity.class);
        startActivity(it5);
    }

    private final BroadcastReceiver NoloadReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent5) {
            if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent5.getAction())) {
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent5)) {
                    String senderNum = smsMessage.getDisplayOriginatingAddress();
                    SMSBody1 += smsMessage.getMessageBody().toString();
                    Log.i("length", String.valueOf(SMSBody1.length()));
                    Log.i("Received SMS:", SMSBody1);
                    String[] lines = SMSBody1.split("\\r?\\n");
                    Log.i("sms",lines[3]);
                    if(lines[2].toString().contains("function is on")){
                        tv.setText("ON");
                        pbar.setVisibility(View.INVISIBLE);
                    }
                    else if(lines[2].toString().contains("function is off")){
                        tv.setText("OFF");
                        pbar.setVisibility(View.INVISIBLE);
                    }
                    else if(lines[2].toString().contains("trip time")){
                        tv1.setText(lines[2]);
                        pbar1.setVisibility(View.INVISIBLE);
                    }
                    else if(lines[2].toString().contains("Dryrunn amps")){
                        tv2.setText(lines[2]);
                        pbar2.setVisibility(View.INVISIBLE);
                    }
                    else return;
                }
                SMSBody1="";
            }
        }
    };


    @Override
   public void onPause(){
        super.onPause();
        unregisterReceiver(NoloadReceiver);
    }
}
