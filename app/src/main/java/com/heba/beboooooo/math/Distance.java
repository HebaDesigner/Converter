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

public class Distance extends AppCompatActivity {

    private EditText disEdit;
    public TextView disCon;

    private Spinner dist1_sp, dist2_sp;

    private double disVar = 0;
    private String myDis;
    private String dis1, dis2;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance );

        disEdit = (EditText) findViewById(R.id.disEdit_id);
        disCon = (TextView) findViewById(R.id.disTxt_id);

        dist1_sp = (Spinner) findViewById ( R.id.dis1_id );
        dist2_sp = (Spinner) findViewById ( R.id.dis2_id );

        ArrayAdapter<CharSequence> currAdp = ArrayAdapter.createFromResource (
                this,
                R.array.distance,
                android.R.layout.simple_spinner_dropdown_item );

        currAdp.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        dist1_sp.setAdapter ( currAdp );
        dist2_sp.setAdapter ( currAdp );

        dist1_sp.setOnItemSelectedListener ( new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                dis1 = String.valueOf ( parent.getItemAtPosition ( position ) );

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        } );

        dist2_sp.setOnItemSelectedListener ( new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                dis2 = String.valueOf ( parent.getItemAtPosition ( position ) );

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        dis_Ed();
    }


    public void dis_Ed() {

        disEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                disEdit.setEnabled ( true );
                disCon.setEnabled ( true );
                myDis = s.toString ().trim ();

                cmConv ();
                mConv();
                kmConv();

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
    }
    public void cmTom(){

        myDis = disEdit.getText ().toString ().trim ();
        if (myDis.length () != 0) {

            disVar = Double.parseDouble ( myDis );
            disCon.setText ( disVar / 100 + "" );

        } else {

            disCon.setText ( " " );
            disCon.setHint("Distance in Meter");
        }
    }

    public void cmTocm(){

        myDis = disEdit.getText ().toString ().trim ();
        if (myDis.length () != 0) {

            disVar = Double.parseDouble ( myDis );
            disCon.setText ( disVar + "" );

        } else {

            disCon.setText ( " " );
            disCon.setHint("Distance in CenteMeter");
        }
    }
    public void cmTokm(){

        myDis = disEdit.getText ().toString ().trim ();
        if (myDis.length () != 0) {

            disVar = Double.parseDouble ( myDis );
            disCon.setText ( disVar / 100000 + "" );

        } else {

            disCon.setText ( " " );
            disCon.setHint("Distance in Kilo Meter");
        }
    }

    public void cmConv()
    {
        myDis = disEdit.getText ().toString ().trim ();

        if (dis1.equals ( "cm" ) && dis2.equals ( "cm" )) {
            cmTocm ();
        } else if (dis1.equals ( "cm" ) && dis2.equals ( "m" )) {
            cmTom ();
        } else if (dis1.equals ( "cm" ) && dis2.equals ( "km" )) {
            cmTokm ();
        } else if (dis1.equals ( " " ) && dis2.equals ( " " ))

        {
            Toast.makeText ( getApplicationContext (), "please select distance from spinner", Toast.LENGTH_LONG ).show ();
        }
    }

    public void mTocm(){

        myDis = disEdit.getText ().toString ().trim ();
        if (myDis.length () != 0) {

            disVar = Double.parseDouble ( myDis );
            disCon.setText ( disVar * 100 + "" );

        } else {

            disCon.setText ( " " );
            disCon.setHint("Distance in CenteMeter");
        }
    }

    public void mTom(){

        myDis = disEdit.getText ().toString ().trim ();
        if (myDis.length () != 0) {

            disVar = Double.parseDouble ( myDis );
            disCon.setText ( disVar + "" );

        } else {

            disCon.setText ( " " );
            disCon.setHint("Distance in Meter");
        }
    }
    public void mTokm(){

        myDis = disEdit.getText ().toString ().trim ();
        if (myDis.length () != 0) {

            disVar = Double.parseDouble ( myDis );
            disCon.setText ( disVar * 1000 + "" );

        } else {

            disCon.setText ( " " );
            disCon.setHint("Distance in Kilo Meter");
        }
    }

    public void mConv()
    {
        myDis = disEdit.getText ().toString ().trim ();

        if (dis1.equals ( "m" ) && dis2.equals ( "cm" )) {
            mTocm ();
        } else if (dis1.equals ( "m" ) && dis2.equals ( "m" )) {
            mTom ();
        } else if (dis1.equals ( "m" ) && dis2.equals ( "km" )) {
            mTokm();
        } else if (dis1.equals ( " " ) && dis2.equals ( " " ))

        {

            Toast.makeText ( getApplicationContext (), "please select distance from spinner", Toast.LENGTH_LONG ).show ();
        }
    }

    public void kmTocm(){

        myDis = disEdit.getText ().toString ().trim ();
        if (myDis.length () != 0) {

            disVar = Double.parseDouble ( myDis );
            disCon.setText ( disVar * 100000 + "" );

        } else {

            disCon.setText ( " " );
            disCon.setHint("Distance in CenteMeter");
        }
    }

    public void kmTokm(){

        myDis = disEdit.getText ().toString ().trim ();
        if (myDis.length () != 0) {

            disVar = Double.parseDouble ( myDis );
            disCon.setText ( disVar + "" );

        } else {

            disCon.setText ( " " );
            disCon.setHint("Distance in Kilo Meter");
        }
    }
    public void kmTom(){

        myDis = disEdit.getText ().toString ().trim ();
        if (myDis.length () != 0) {

            disVar = Double.parseDouble ( myDis );
            disCon.setText ( disVar *1000 + "" );

        } else {

            disCon.setText ( " " );
            disCon.setHint("Distance in Meter");
        }
    }

    public void kmConv()
    {
        myDis = disEdit.getText ().toString ().trim ();

        if (dis1.equals ( "km" ) && dis2.equals ( "cm" )) {
            kmTocm();
        } else if (dis1.equals ( "km" ) && dis2.equals ( "m" )) {
            kmTom();
        } else if (dis1.equals ( "km" ) && dis2.equals ( "km" )) {
            kmTokm();
        } else if (dis1.equals ( " " ) && dis2.equals ( " " ))

        {
            Toast.makeText ( getApplicationContext (), "please select distance from spinner", Toast.LENGTH_LONG ).show ();
        }
    }

}


