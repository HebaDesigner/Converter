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

public class Speed extends AppCompatActivity {

    private EditText speedEdit;
    public TextView speedCon;

    private Spinner speed1_sp, speed2_sp;

    private double speedVar = 0;
    private String mySpeed;
    private String speed1, speed2;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed );
        speedEdit = (EditText) findViewById(R.id.spEdit_id);
        speedCon = (TextView) findViewById(R.id.spTxt_id);

        speed1_sp = (Spinner) findViewById ( R.id.sp1_id );
        speed2_sp = (Spinner) findViewById ( R.id.sp2_id );

        ArrayAdapter<CharSequence> currAdp = ArrayAdapter.createFromResource (
                this,
                R.array.speed,
                android.R.layout.simple_spinner_dropdown_item );

        currAdp.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        speed1_sp.setAdapter ( currAdp );
        speed2_sp.setAdapter ( currAdp );

        speed1_sp.setOnItemSelectedListener ( new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                speed1 = String.valueOf ( parent.getItemAtPosition ( position ) );

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        } );

        speed2_sp.setOnItemSelectedListener ( new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                speed2 = String.valueOf ( parent.getItemAtPosition ( position ) );

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        speed_Ed();
    }


    public void speed_Ed() {

        speedEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                speedEdit.setEnabled ( true );
                speedCon.setEnabled ( true );
                mySpeed = s.toString ().trim ();

                meter_secondCon ();
                kilometer_hourCon();
                mile_hourCon();

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
    }
    public void m_sTom_s(){

        mySpeed = speedEdit.getText ().toString ().trim ();
        if (mySpeed.length () != 0) {

            speedVar = Double.parseDouble ( mySpeed );
            speedCon.setText ( speedVar + "" );

        } else {

            speedCon.setText ( " " );
            speedCon.setHint("Speed in M/S");
        }
    }

    public void m_sTomil_h(){

        mySpeed = speedEdit.getText ().toString ().trim ();
        if (mySpeed.length () != 0) {

            speedVar = Double.parseDouble ( mySpeed );
            speedCon.setText ( speedVar * 0.44704 + "" );

        } else {

            speedCon.setText ( " " );
            speedCon.setHint("Speed in Mil/H");
        }
    }

    public void m_sTokm_h(){

        mySpeed = speedEdit.getText ().toString ().trim ();
        if (mySpeed.length () != 0) {

            speedVar = Double.parseDouble ( mySpeed );
            speedCon.setText ( speedVar * 0.27777777777778 + "" );

        } else {

            speedCon.setText ( " " );
            speedCon.setHint("Speed in KM/H");
        }
    }

    public void meter_secondCon()
    {
        mySpeed = speedEdit.getText ().toString ().trim ();

        if (speed1.equals ( "M/S" ) && speed2.equals ( "KM/H" )) {
            m_sTokm_h ();
        } else if (speed1.equals ( "M/S" ) && speed2.equals ( "M/S" )) {
            m_sTom_s ();
        } else if (speed1.equals ( "M/S" ) && speed2.equals ( "Mil/H" )) {
            m_sTomil_h ();
        } else if (speed1.equals ( " " ) && speed2.equals ( " " ))

        {

            Toast.makeText ( getApplicationContext (), "please select speed from spinner", Toast.LENGTH_LONG ).show ();
        }
    }

    public void km_hTom_s(){

        mySpeed = speedEdit.getText ().toString ().trim ();
        if (mySpeed.length () != 0) {

            speedVar = Double.parseDouble ( mySpeed );
            speedCon.setText ( speedVar * 0.27777777777778  + "" );

        } else {

            speedCon.setText ( " " );
            speedCon.setHint("speed in m/s");
        }
    }

    public void km_hTokm_h(){

        mySpeed = speedEdit.getText ().toString ().trim ();
        if (mySpeed.length () != 0) {

            speedVar = Double.parseDouble ( mySpeed );
            speedCon.setText ( speedVar  + "" );

        } else {

            speedCon.setText ( " " );
            speedCon.setHint("Speed in KM/H");
        }
    }

    public void km_hTokmil_h(){

        mySpeed = speedEdit.getText ().toString ().trim ();
        if (mySpeed.length () != 0) {

            speedVar = Double.parseDouble ( mySpeed );
            speedCon.setText ( speedVar / 1.609344 + "" );

        } else {

            speedCon.setText ( " " );
            speedCon.setHint("Speed in Mil/H");
        }
    }

    public void kilometer_hourCon()
    {
        mySpeed = speedEdit.getText ().toString ().trim ();

        if (speed1.equals ( "KM/H" ) && speed2.equals ( "M/S" )) {
            km_hTom_s ();
        } else if (speed1.equals ( "KM/H" ) && speed2.equals ( "KM/H" )) {
            km_hTokm_h ();
        } else if (speed1.equals ( "KM/H" ) && speed2.equals ( "Mil/H" )) {
            km_hTokmil_h ();
        } else if (speed1.equals ( " " ) && speed2.equals ( " " ))

        {

            Toast.makeText ( getApplicationContext (), "please select speed from spinner", Toast.LENGTH_LONG ).show ();
        }
    }
    public void mil_hTom_s(){

        mySpeed = speedEdit.getText ().toString ().trim ();
        if (mySpeed.length () != 0) {

            speedVar = Double.parseDouble ( mySpeed );
            speedCon.setText ( speedVar * 0.44704   + "" );

        } else {

            speedCon.setText ( " " );
            speedCon.setHint("speed in m/s");
        }
    }

    public void mil_hTokm_h(){

        mySpeed = speedEdit.getText ().toString ().trim ();
        if (mySpeed.length () != 0) {

            speedVar = Double.parseDouble ( mySpeed );
            speedCon.setText ( speedVar  / 1.609344 + "" );

        } else {

            speedCon.setText ( " " );
            speedCon.setHint("Speed in KM/H");
        }
    }

    public void mil_hTokmil_h(){

        mySpeed = speedEdit.getText ().toString ().trim ();
        if (mySpeed.length () != 0) {

            speedVar = Double.parseDouble ( mySpeed );
            speedCon.setText ( speedVar + "" );

        } else {

            speedCon.setText ( " " );
            speedCon.setHint("Speed in Mil/H");
        }
    }

    public void mile_hourCon()
    {
        mySpeed = speedEdit.getText ().toString ().trim ();

        if (speed1.equals ( "Mil/H" ) && speed2.equals ( "M/S" )) {
            mil_hTom_s ();
        } else if (speed1.equals ( "Mil/H" ) && speed2.equals ( "KM/H" )) {
            mil_hTokm_h ();
        } else if (speed1.equals ( "Mil/H" ) && speed2.equals ( "Mil/H" )) {
            mil_hTokmil_h ();
        } else if (speed1.equals ( " " ) && speed2.equals ( " " ))

        {

            Toast.makeText ( getApplicationContext (), "please select speed from spinner", Toast.LENGTH_LONG ).show ();
        }
    }
    }




