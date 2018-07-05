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
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import static com.blueskylinks.spc_main.MainActivity.phoneNumber;

public class SettingsActivity extends AppCompatActivity {
    Switch s1;
    Switch s2;
    Switch s3;
    Switch s4;
    Switch s5;
    Switch s6;
    Switch s7;
   // String phoneNumber = "9880760642";
    TextView text;
    TextView tv;
    String SMSBody1;
    boolean val1 = false;
    boolean val2 = false;
    boolean val3 = false;
    boolean val4 = false;
    boolean val5 = false;
    Boolean val6=false;
    Boolean val7=false;
    SharedPreferences Preferences1;
    SharedPreferences Preferences2;
    SharedPreferences Preferences3;
    SharedPreferences Preferences4;
    SharedPreferences Preferences5;
    SharedPreferences Preferences6;
    SharedPreferences Preferences7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        s1=findViewById(R.id.switch1);
        s2=findViewById(R.id.switch2);
        s3=findViewById(R.id.switch3);
        s4=findViewById(R.id.switch4);
        s5=findViewById(R.id.switch5);
        s6=findViewById(R.id.switch6);
        s7=findViewById(R.id.switchp2);
     //   tv=findViewById(R.id.textView1);
       // text=findViewById(R.id.onoff_status_text_1);

        Preferences1 = getSharedPreferences("Checked1", 0);
        val1 = Preferences1.getBoolean("Checked1", val1); // retrieve the value of your key
       s1.setChecked(val1);

        Preferences2 = getSharedPreferences("Checked2", 0);
        val2 = Preferences2.getBoolean("Checked2", val2); // retrieve the value of your key
        s2.setChecked(val2);

        Preferences3 = getSharedPreferences("Checked3", 0);
        val3 = Preferences3.getBoolean("Checked3", val3); // retrieve the value of your key
        s3.setChecked(val3);

        Preferences4 = getSharedPreferences("Checked4", 0);
        val4 = Preferences4.getBoolean("Checked4", val4); // retrieve the value of your key
        s4.setChecked(val4);

        Preferences5 = getSharedPreferences("Checked5", 0);
        val5 = Preferences5.getBoolean("Checked5", val5); // retrieve the value of your key
        s5.setChecked(val5);

        Preferences6 = getSharedPreferences("Checked6", 0);
        val6 = Preferences6.getBoolean("Checked6", val6); // retrieve the value of your key
        s6.setChecked(val6);

        Preferences7 = getSharedPreferences("Checked7", 0);
        val7 = Preferences7.getBoolean("Checked7", val7); // retrieve the value of your key
        s7.setChecked(val7);
    }

    @Override
    public void onResume(){
        super.onResume();
        SMSBody1="";
       /* final IntentFilter SintentFilter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        registerReceiver(settingfunconoroffReceiver, SintentFilter);
        registerReceiver(settingfunconoroffReceiver,SintentFilter);*/
    }

public void submit_func(View view){
        switch(view.getId()){
            case R.id.switch1:
                if(s1.isChecked()){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch on!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    String message = "SPC,36,1";
                                    SmsManager smsManager = SmsManager.getDefault();
                                    //   smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                                    Log.i("Test", message);
                                    Preferences1.edit().putBoolean("Checked1",true).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s1.setChecked(false);
                                    Preferences1.edit().putBoolean("Checked1",false).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch off!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                    String message = "SPC,36,0";
                    SmsManager smsManager = SmsManager.getDefault();
                    //   smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", message);
                    Preferences1.edit().putBoolean("Checked1",false).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s1.setChecked(true);
                                    Preferences1.edit().putBoolean("Checked1",true).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                break;
            case R.id.switch2:
                if(s2.isChecked()){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch on!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                    String message = "SPC,42,1";
                    SmsManager smsManager = SmsManager.getDefault();
                    //   smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", message);
                                    Preferences2.edit().putBoolean("Checked2",true).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s2.setChecked(false);
                                    Preferences2.edit().putBoolean("Checked2",false).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch off!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                    String message = "SPC,42,0";
                    SmsManager smsManager = SmsManager.getDefault();
                    //   smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", message);
                                    Preferences2.edit().putBoolean("Checked2",false).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s2.setChecked(true);
                                    Preferences2.edit().putBoolean("Checked2",true).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                break;
            case R.id.switch3:
                if(s3.isChecked()){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch on!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                    String message = "SPC,17,1";
                    SmsManager smsManager = SmsManager.getDefault();
                      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", message);
                                    Preferences3.edit().putBoolean("Checked3",true).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s3.setChecked(false);
                                    Preferences2.edit().putBoolean("Checked3",false).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch off!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                    String message = "SPC,17,0";
                    SmsManager smsManager = SmsManager.getDefault();
                       smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", message);
                    Preferences3.edit().putBoolean("Checked3",false).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s3.setChecked(true);
                                    Preferences3.edit().putBoolean("Checked3",true).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                break;
            case R.id.switch4:
                if(s4.isChecked()){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch on!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                    String message = "SPC,18,1";
                    SmsManager smsManager = SmsManager.getDefault();
                     smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", message);
                    Preferences4.edit().putBoolean("Checked4",true).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s4.setChecked(false);
                                    Preferences4.edit().putBoolean("Checked4",false).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch off!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                    String message = "SPC,18,0";
                    SmsManager smsManager = SmsManager.getDefault();
                      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", message);
                                    Preferences4.edit().putBoolean("Checked4",false).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s4.setChecked(true);
                                    Preferences4.edit().putBoolean("Checked4",true).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                break;
            case R.id.switch5:
                if(s5.isChecked()){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch on!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                    String message = "SPC,1,1";
                    SmsManager smsManager = SmsManager.getDefault();
                     smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", message);
                    Preferences5.edit().putBoolean("Checked5",true).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s5.setChecked(false);
                                    Preferences5.edit().putBoolean("Checked5",false).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                else{  AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch off!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                    String message = "SPC,1,0";
                    SmsManager smsManager = SmsManager.getDefault();
                      smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", message);
                    Preferences5.edit().putBoolean("Checked5",false).apply();
                   }
                });
                 builder1.setNegativeButton(
                          "No",
                      new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface dialog, int id) {
                        s5.setChecked(true);
                          Preferences5.edit().putBoolean("Checked5",true).apply();
                          dialog.cancel();
                     }
               });
                 AlertDialog alert11 = builder1.create();
                 alert11.show();
                }
            case R.id.switch6:
                if(s6.isChecked()){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch on!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    String message = "SPC,0,1";
                                    SmsManager smsManager = SmsManager.getDefault();
                                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                                    Log.i("Test", message);
                                    Log.i("Test", message);
                                    Preferences6.edit().putBoolean("Checked6",true).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s6.setChecked(false);
                                    Preferences6.edit().putBoolean("Checked6",false).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch off!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    String message = "SPC,0,0";
                                    SmsManager smsManager = SmsManager.getDefault();
                                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                                    Log.i("Test", message);
                                    Log.i("Test", message);
                                    Preferences6.edit().putBoolean("Checked6",false).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s6.setChecked(true);
                                    Preferences6.edit().putBoolean("Checked6",true).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                break;
            case R.id.switchp2:
                if(s7.isChecked()){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch on!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    String message = "SPC,46,1";
                                    SmsManager smsManager = SmsManager.getDefault();
                                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                                    Log.i("Test", message);
                                    Log.i("Test", message);
                                    Preferences7.edit().putBoolean("Checked7",true).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s7.setChecked(false);
                                    Preferences7.edit().putBoolean("Checked7",false).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Are you sure want to switch off!.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    String message = "SPC,46,0";
                                    SmsManager smsManager = SmsManager.getDefault();
                                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                                    Log.i("Test", message);
                                    Log.i("Test", message);
                                    Preferences7.edit().putBoolean("Checked7",false).apply();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    s7.setChecked(true);
                                    Preferences7.edit().putBoolean("Checked7",true).apply();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                break;

        }
    }

    public void overLoad(View view){
        Intent in1 = new Intent(SettingsActivity.this, OverLoadActivity.class);
        startActivity(in1);
    }

    public void overVoltage(View view){
        Intent in2 = new Intent(SettingsActivity.this, Over_voltage_funtion.class);
        startActivity(in2);
    }

    public void NoLoad(View view){
        Intent in3 = new Intent(SettingsActivity.this, No_load_activity.class);
        startActivity(in3);
    }

    public void Restart(View view){
        Intent in3 = new Intent(SettingsActivity.this, RestartDryrunActivity.class);
        startActivity(in3);
    }

    public void underVoltage(View view){
        Intent in2 = new Intent(SettingsActivity.this, UnderVoltageActivity.class);
        startActivity(in2);
    }

    //Hoome functions
    public void home(View view){
        Intent it1 = new Intent(SettingsActivity.this, Main2Activity.class);
        startActivity(it1);
    }

    public void ON_OFF(View view){
        //starting another activity..
        Intent it2 = new Intent(SettingsActivity.this, ON_OFFActivity.class);
        startActivity(it2);
    }

    public void Users(View view){
        //starting another activity..
        Intent it3 = new Intent(SettingsActivity.this, UsersActivity.class);
        startActivity(it3);
    }

    public void manual(View view) {
        //starting another activity..
        Intent it4 = new Intent(SettingsActivity.this, ManualActivity.class);
        startActivity(it4);
    }

  /*  private final BroadcastReceiver settingfunconoroffReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent7) {
            if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent7.getAction())) {
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent7)) {
                    SMSBody1 = smsMessage.getMessageBody().toString();
                    Log.i("Received sms", SMSBody1);
                    String sms = SMSBody1;
                    Log.i("length", String.valueOf(SMSBody1.length()));
                    String[] lines = SMSBody1.split("\\r?\\n");
                    if(lines[2].toString().contains("on")){
                        tv.setText("ON");
                    }
                    else if(lines[2].toString().contains("off")){
                        tv.setText("OFF");
                        text.setText(lines[2]);
                    }
                    else return;
                    SMSBody1 = "";
                }
            }
        }
    };*/

    @Override
    public void onPause(){
        super.onPause();
       // unregisterReceiver(settingfunconoroffReceiver);
    }
}


