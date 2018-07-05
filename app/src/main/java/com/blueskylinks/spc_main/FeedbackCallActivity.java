package com.blueskylinks.spc_main;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

public class FeedbackCallActivity extends AppCompatActivity {
        Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_call);


        mySwitch = (Switch) findViewById(R.id.myswitch1);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FeedbackCallActivity.this);
                    alertDialogBuilder.setMessage("Are you sure,want to switch on call feedback function");
                    alertDialogBuilder.setCancelable(false).setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                           return;
                            //smsManager.sendTextMessage(phoneNumber, null, msg, null, null);
                        }
                    });
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    // show it
                    alertDialog.show();
                }
                else {

                }
            }
        });

    }


}
