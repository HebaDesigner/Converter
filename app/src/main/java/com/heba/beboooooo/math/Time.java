package com.heba.beboooooo.math;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Time extends AppCompatActivity {

    private EditText timeEdit;
    public TextView conTime;

    private Spinner tm1_sp, tm2_sp;

    private double tmVar = 0;
    private String myTime;
    private String time1, time2;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time );

        timeEdit = (EditText) findViewById(R.id.tmEdit_id);
        conTime = (TextView) findViewById(R.id.tmTxt_id);

        tm1_sp = (Spinner) findViewById ( R.id.tmSp1_id );
        tm2_sp = (Spinner) findViewById ( R.id.tmSp2_id );

        ArrayAdapter<CharSequence> currAdp = ArrayAdapter.createFromResource (
                this,
                R.array.time,
                android.R.layout.simple_spinner_dropdown_item );

        currAdp.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        tm1_sp.setAdapter ( currAdp );
        tm2_sp.setAdapter ( currAdp );

        tm1_sp.setOnItemSelectedListener ( new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                time1 = String.valueOf ( parent.getItemAtPosition ( position ) );

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        } );

        tm2_sp.setOnItemSelectedListener ( new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                time2 = String.valueOf ( parent.getItemAtPosition ( position ) );

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        time_Ed();
    }


    public void time_Ed() {

        timeEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                timeEdit.setEnabled ( true );
                conTime.setEnabled ( true );
                myTime = s.toString ().trim ();

                MinConv ();
                HourConv();
                SecConv();

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
    }
        public void MintoHor(){

            myTime = timeEdit.getText ().toString ().trim ();
            if (myTime.length () != 0) {

                tmVar = Double.parseDouble ( myTime );
                conTime.setText ( tmVar / 60 + "" );

            } else {

                conTime.setText ( " " );
                conTime.setHint("Time in Hours");
            }
        }

        public void MintoMin(){

            myTime = timeEdit.getText ().toString ().trim ();
            if (myTime.length () != 0) {

                tmVar = Double.parseDouble ( myTime );
                conTime.setText ( tmVar  + "" );

            } else {

                conTime.setText ( " " );
                conTime.setHint("Time in Minutes");
            }
        }

        public void MintoSec(){

            myTime = timeEdit.getText ().toString ().trim ();
            if (myTime.length () != 0) {

                tmVar = Double.parseDouble ( myTime );
                conTime.setText ( tmVar * 60 + "" );

            } else {

                conTime.setText ( " " );
                conTime.setHint("Time in Second");
            }
        }

        public void MinConv ()
        {
            myTime = timeEdit.getText ().toString ().trim ();

            if (time1.equals ( "M" ) && time2.equals ( "H" )) {
                MintoHor();
            } else if (time1.equals ( "M" ) && time2.equals ( "M" )) {
                MintoMin();
            } else if (time1.equals ( "M" ) && time2.equals ( "S" )) {
                MintoSec();
            } else if (time1.equals ( " " ) && time2.equals ( " " ))

            {

                Toast.makeText ( getApplicationContext (), "please select time from spinner", Toast.LENGTH_LONG ).show ();
            }
        }

    public void HortoMin(){

        myTime = timeEdit.getText ().toString ().trim ();
        if (myTime.length () != 0) {

            tmVar = Double.parseDouble ( myTime );
            conTime.setText ( tmVar * 60 + "" );

        } else {

            conTime.setText ( " " );
            conTime.setHint("Time in Minuts");
        }
    }

    public void HortoHor(){

        myTime = timeEdit.getText ().toString ().trim ();
        if (myTime.length () != 0) {

            tmVar = Double.parseDouble ( myTime );
            conTime.setText ( tmVar  + "" );

        } else {

            conTime.setText ( " " );
            conTime.setHint("Time in Hours");
        }
    }

    public void HortoSec(){

        myTime = timeEdit.getText ().toString ().trim ();
        if (myTime.length () != 0) {

            tmVar = Double.parseDouble ( myTime );
            conTime.setText ( tmVar * 60 * 60 + "" );

        } else {

            conTime.setText ( " " );
            conTime.setHint("Time in Second");
        }
    }

    public void HourConv()
    {
        myTime = timeEdit.getText ().toString ().trim ();

        if (time1.equals ( "H" ) && time2.equals ( "H" )) {
            HortoHor ();
        } else if (time1.equals ( "H" ) && time2.equals ( "M" )) {
            HortoMin ();
        } else if (time1.equals ( "H" ) && time2.equals ( "S" )) {
            HortoSec ();
        } else if (time1.equals ( " " ) && time2.equals ( " " ))

        {

            Toast.makeText ( getApplicationContext (), "please select time from spinner", Toast.LENGTH_LONG ).show ();
        }
    }

    public void SectoMin(){

        myTime = timeEdit.getText ().toString ().trim ();
        if (myTime.length () != 0) {

            tmVar = Double.parseDouble ( myTime );
            conTime.setText ( tmVar / 60 + "" );

        } else {

            conTime.setText ( "" );
            conTime.setHint("Time in Minutes");
        }
    }

    public void SectoSec(){

        myTime = timeEdit.getText ().toString ().trim ();
        if (myTime.length () != 0) {

            tmVar = Double.parseDouble ( myTime );
            conTime.setText ( tmVar  + "" );

        } else {

            conTime.setText ( " " );
            conTime.setHint("Time in Second");
        }
    }

    public void SectoHor(){

        myTime = timeEdit.getText ().toString ().trim ();
        if (myTime.length () != 0) {

            tmVar = Double.parseDouble ( myTime );
            conTime.setText ( (tmVar / 60) / 60 + "" );

        } else {

            conTime.setText ( "" );
            conTime.setHint("Time in Hours");
        }
    }

    public void SecConv()
    {
        myTime = timeEdit.getText ().toString ().trim ();

        if (time1.equals ( "S" ) && time2.equals ( "H" )) {
            SectoHor ();
        } else if (time1.equals ( "S" ) && time2.equals ( "M" )) {
            SectoMin ();
        } else if (time1.equals ( "S" ) && time2.equals ( "S" )) {
            SectoSec ();
        } else if (time1.equals ( " " ) && time2.equals ( " " ))

        {
           Toast.makeText ( getApplicationContext (), "please select time from spinner", Toast.LENGTH_SHORT ).show ();
        }
    }


}


