package com.blueskylinks.spc_main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.provider.Telephony;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static com.blueskylinks.spc_main.MainActivity.phoneNumber;

public class ManualActivity extends AppCompatActivity {
    int pos;
   // String phoneNumber = "9880760642";
    Spinner spinner;
    Spinner spinner1;
    LinearLayout layout;
    Button myButton1;
    Button myButton2;
    LinearLayout mainLayout;
    String selectedItem;
    String SMSBody1;
    TextView text;
    TextView tv;
    TextView tv2;
    ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
       spinner = findViewById(R.id.spinner1);
         myButton1= new Button(this);
         myButton2= new Button(this);
         text=findViewById(R.id.onoff_status_text_1);
         tv=findViewById(R.id.textview1);
         tv2=findViewById(R.id.textView2);
         pbar=findViewById(R.id.pbar);
      spinner1 = new Spinner(this);
       mainLayout = (LinearLayout)findViewById(R.id.spinnerLayout);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // selectedItem = parent.getItemAtPosition(position).toString();
                Log.i("position ", String.valueOf(position));
                switch (position){
                    case 1:
                        mainLayout.removeView(spinner1);
                        setFeedbackCall();
                        break;
                    case 2:
                        mainLayout.removeView(spinner1);
                        setFeedbackSMS();
                        break;
                    case 3:
                        mainLayout.removeView(spinner1);
                        setOverLoad();
                        break;
                    case 4:
                        mainLayout.removeView(spinner1);
                        setDryrun();
                        break;
                    case 5:
                        mainLayout.removeView(spinner1);
                        setRestart();
                        break;
                    case 6:
                        mainLayout.removeView(spinner1);
                        setOverVoltage();
                        break;
                    case 7:
                        mainLayout.removeView(spinner1);
                        setUnderVoltage();
                        break;
                    case 8:
                        mainLayout.removeView(spinner1);
                        setReversePhase();
                        break;
                    case 9:
                        mainLayout.removeView(spinner1);
                        setStolenprotection();
                        break;
                    default:
                        mainLayout.removeView(spinner1);
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
        final IntentFilter MintentFilter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        registerReceiver(manualReceiver, MintentFilter);
        registerReceiver(manualReceiver,MintentFilter);
    }


    public void submit_function(View view){
  if(selectedItem.equals("Feedback call on")){
      String message = "SPC,0,1";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("Feedback call off")){
      String message = "SPC,0,0";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("Feedback SMS on")){
      String message = "SPC,1,1";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("Feedback SMS off")){
      String message = "SPC,1,0";
      SmsManager smsManager = SmsManager.getDefault();
       smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("OverLoad on")){
      String message = "SPC,2,1";
      SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("OverLoad off")){
      String message = "SPC,2,0";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("Dryrun on")){
      String message = "SPC,6,1";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("Dryrun off")){
      String message = "SPC,6,0";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("Restart on")){
      String message = "SPC,10,1";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("Restart off")){
      String message = "SPC,10,0";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("OverVoltage on")){
      String message = "SPC,14,1";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("OverVoltage off")){
      String message = "SPC,14,0";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("underVoltage on")){
      String message = "SPC,12,1";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("underVoltage off")){
      String message = "SPC,12,0";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("ReversePhase on")){
      String message = "SPC,18,1";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("ReversePhase off")){
      String message = "SPC,18,0";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("Stolenprotection on")){
      String message = "SPC,22,1";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}

  else if(selectedItem.equals("StolenProtection off")){
      String message = "SPC,22,0";
      SmsManager smsManager = SmsManager.getDefault();
      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
      Log.i("Test", message);
      pbar.setVisibility(View.VISIBLE);
      text.setText("Command Sent, Please Wait...For 2 minutes");}
}



public void setFeedbackCall(){
    ArrayList<String> Feedback_Call = new ArrayList<String>();
    Feedback_Call.add("Feedback call on");
    Feedback_Call.add("Feedback call off");
    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, Feedback_Call);
    spinner1.setAdapter(spinnerArrayAdapter);
    mainLayout.addView(spinner1);
}
    public void setFeedbackSMS(){
        ArrayList<String> Feedback_SMS = new ArrayList<String>();
        Feedback_SMS.add("Feedback SMS on");
        Feedback_SMS.add("Feedback SMS off");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, Feedback_SMS);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }

    public void setOverLoad(){
        ArrayList<String> OverLoad = new ArrayList<String>();
        OverLoad.add("OverLoad on");
        OverLoad.add("OverLoad off");
        OverLoad.add("OverLoad trip time");
        OverLoad.add("OverLoad trip current");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, OverLoad);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }
    public void setDryrun(){
        ArrayList<String> Dryrun = new ArrayList<String>();
        Dryrun.add("Dryrun on");
        Dryrun.add("Dryrun off");
        Dryrun.add("Dryrun trip current");
        Dryrun.add("Dryrun trip current");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, Dryrun);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }

    public void setRestart(){
        ArrayList<String> Restart = new ArrayList<String>();
        Restart.add("Restart on");
        Restart.add("Restart off");
        Restart.add("Restart time");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, Restart);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }

    public void setOverVoltage(){
        ArrayList<String> Overvoltage = new ArrayList<String>();
        Overvoltage.add("OverVoltage on");
        Overvoltage.add("OverVoltage off");
        Overvoltage.add("OverVoltage setting");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, Overvoltage);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }

    public void setUnderVoltage(){
        ArrayList<String> underVoltage = new ArrayList<String>();
        underVoltage.add("underVoltage on");
        underVoltage.add("underVoltage off");
        underVoltage.add("underVoltage setting");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, underVoltage);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }

    public void setReversePhase(){
        ArrayList<String> Reversephase = new ArrayList<String>();
        Reversephase.add("ReversePhase on");
        Reversephase.add("ReversePhase off");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, Reversephase);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }

    public void setStolenprotection(){
        ArrayList<String> stolenProtection = new ArrayList<String>();
        stolenProtection.add("StoleProtection on");
        stolenProtection.add("StolenProtection off");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, stolenProtection);
        spinner1.setAdapter(spinnerArrayAdapter);
        mainLayout.addView(spinner1);
    }

    public void settings(View view){
        //starting another activity..
        Intent it1 = new Intent(ManualActivity.this, SettingsActivity.class);
        startActivity(it1);
    }

    public void ON_OFF(View view){
        //starting another activity..
        Intent it2 = new Intent(ManualActivity.this, ON_OFFActivity.class);
        startActivity(it2);
    }

    public void Users(View view){
        //starting another activity..
        Intent it3 = new Intent(ManualActivity.this, UsersActivity.class);
        startActivity(it3);
    }

    //Hoome functions
    public void home(View view){
        Intent it = new Intent(ManualActivity.this, Main2Activity.class);
        startActivity(it);
    }

    private final BroadcastReceiver manualReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent9) {
            if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent9.getAction())) {
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent9)) {
                    SMSBody1 = smsMessage.getMessageBody().toString();
                    Log.i("Received sms", SMSBody1);
                    String sms = SMSBody1;
                    Log.i("length", String.valueOf(SMSBody1.length()));
                    String[] lines = SMSBody1.split("\\r?\\n");
                    if(lines[2].toString().contains("on")){
                        tv.setText("ON");
                        tv2.setText(lines[2]);
                        pbar.setVisibility(View.INVISIBLE);
                        text.setText("!!");
                    }
                    else if(lines.toString().contains("off")) {
                        tv.setText("OFF");
                        tv2.setText(lines[2]);
                        pbar.setVisibility(View.INVISIBLE);
                        text.setText("!!");
                    }
                    else return;
                    SMSBody1 = "";
                }
            }
        }
    };

    @Override
    public void onPause(){
        super.onPause();
        unregisterReceiver(manualReceiver);
    }
}
