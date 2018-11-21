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

public class Currency extends AppCompatActivity {

    private EditText currency_text;
    private TextView converted_curr;
    private Spinner curr_sp, conCurr_sp;
    private double currency = 0;
    private String myCurrency;
    private String curr1, curr2;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_currency );

        currency_text = (EditText) findViewById ( R.id.crrEdit_id );
        converted_curr = (TextView) findViewById ( R.id.crrTxt_id );
        curr_sp = (Spinner) findViewById ( R.id.curr1_id );
        conCurr_sp = (Spinner) findViewById ( R.id.curr2_id );


        ArrayAdapter<CharSequence> currAdp = ArrayAdapter.createFromResource (
                this,
                R.array.currency,
                android.R.layout.simple_spinner_dropdown_item );

        currAdp.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        curr_sp.setAdapter ( currAdp );
        conCurr_sp.setAdapter ( currAdp );


        curr_sp.setOnItemSelectedListener ( new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                curr1 = String.valueOf ( parent.getItemAtPosition ( position ) );

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        conCurr_sp.setOnItemSelectedListener ( new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                curr2 = String.valueOf ( parent.getItemAtPosition ( position ) );

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        currencyText();
    }

        public void currencyText(){
            currency_text.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged (CharSequence s,int start, int count, int after){

                }

                @Override
                public void onTextChanged (CharSequence s,int start, int before, int count){

                    myCurrency = s.toString().trim ();

                    EGPconv ();
                    USDconv ();
                    UROconv ();
                    GBPconv ();
                    AUDconv ();
                    CHFconv ();
                    CADconv ();
                }

                @Override
                public void afterTextChanged (Editable s){

                }
            } );
        }

    public void EGPtoEGP (){

        myCurrency = currency_text.getText ().toString ().trim ();
        if (myCurrency.length () != 0) {

            currency = Double.parseDouble ( myCurrency );
            converted_curr.setText ( currency  + "" );

        } else {

            converted_curr.setText ( "" );
            converted_curr.setHint("Currency in EGP");
        }
    }

    public void EGPtoUSD (){

        myCurrency = currency_text.getText ().toString ().trim ();
        if (myCurrency.length () != 0) {

            currency = Double.parseDouble ( myCurrency );
            converted_curr.setText ( currency * 17.9100 + "" );

        } else {

            converted_curr.setText ( "" );
            converted_curr.setHint("Currency in USD");
        }

    }

    public void EGPtoURO (){

        myCurrency = currency_text.getText ().toString ().trim ();
        if (myCurrency.length () != 0) {

            currency = Double.parseDouble ( myCurrency );
            converted_curr.setText ( currency * 20.3672 + "" );

        } else {

            converted_curr.setText ( "" );
            converted_curr.setHint("Currency in URO");
        }
    }

    public void EGPtoGBP (){

        myCurrency = currency_text.getText ().toString ().trim ();
        if (myCurrency.length () != 0) {

            currency = Double.parseDouble ( myCurrency );
            converted_curr.setText ( currency * 22.9018+ "" );

        } else {

            converted_curr.setText ( "" );
            converted_curr.setHint("Currency in GBP");
        }
    }

    public void EGPtoCHF (){

        myCurrency = currency_text.getText ().toString ().trim ();
        if (myCurrency.length () != 0) {

            currency = Double.parseDouble ( myCurrency );
            converted_curr.setText ( currency * 17.9976 + "" );

        } else {

            converted_curr.setText ( "" );
            converted_curr.setHint("Currency in CHF");
        }

    }

    public void EGPtoCAD(){

        myCurrency = currency_text.getText ().toString ().trim ();
        if (myCurrency.length () != 0) {

            currency = Double.parseDouble ( myCurrency );
            converted_curr.setText ( currency * 13.4573 + "" );

        } else {

            converted_curr.setText ( "" );
            converted_curr.setHint("Currency in CAD");
        }
    }

    public void EGPtoAUD (){

        myCurrency = currency_text.getText ().toString ().trim ();
        if (myCurrency.length () != 0) {

            currency = Double.parseDouble ( myCurrency );
            converted_curr.setText ( currency * 12.9149 + "" );

        } else {

            converted_curr.setText ( "" );
            converted_curr.setHint("Currency in AUD");
        }
    }

    public void EGPconv ()
    {
        myCurrency = currency_text.getText ().toString ().trim ();

        if (curr1.equals ( "EGP" ) && curr2.equals ( "EGP" )) {
            EGPtoEGP ();
        } else if (curr1.equals ( "EGP" ) && curr2.equals ( "USD" )) {
            EGPtoUSD ();
        } else if (curr1.equals ( "EGP" ) && curr2.equals ( "URO" )) {
            EGPtoURO ();
        } else if (curr1.equals ( "EGP" ) && curr2.equals ( "GBP" )) {
            EGPtoGBP ();
        } else if (curr1.equals ( "EGP" ) && curr2.equals ( "AUD" )) {
            EGPtoAUD ();
        } else if (curr1.equals ( "EGP" ) && curr2.equals ( "CHF" )) {
            EGPtoCHF ();
        } else if (curr1.equals ( "EGP" ) && curr2.equals ( "CAD" )) {
            EGPtoCAD ();
        } else if (curr1.equals ( " " ) && curr2.equals ( " " ))

        {
            Toast.makeText ( getApplicationContext (), "please select currency from spinner", Toast.LENGTH_SHORT ).show ();
        }
    }

    public void USDtoUSD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in USD");
            }
        }

        public void USDtoEGP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 17.05582 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in EGP");
            }
        }

        public void USDtoURO (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.14186 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in URO");
            }
        }

        public void USDtoGBP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.28423 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in GBP");
            }
        }

        public void USDtoCHF (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.00821 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CHF");
            }
        }

        public void USDtoCAD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.75789 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CAD");
            }
        }

        public void USDtoAUD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.72648 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in AUD");
            }
        }

    public void USDconv ()
    {
        myCurrency = currency_text.getText ().toString ().trim ();

        if (curr1.equals ( "USD" ) && curr2.equals ( "EGP" )) {
            USDtoEGP ();
        } else if (curr1.equals ( "USD" ) && curr2.equals ( "USD" )) {
            USDtoUSD ( );
        } else if (curr1.equals ( "USD" ) && curr2.equals ( "URO" )) {
            USDtoURO (  );
        } else if (curr1.equals ( "USD" ) && curr2.equals ( "GBP" )) {
            USDtoGBP (  );
        } else if (curr1.equals ( "USD" ) && curr2.equals ( "AUD" )) {
            USDtoAUD (  );
        } else if (curr1.equals ( "USD" ) && curr2.equals ( "CHF" )) {
            USDtoCHF (  );
        } else if (curr1.equals ( "USD" ) && curr2.equals ( "CAD" )) {
            USDtoCAD (  );
        } else if (curr1.equals ( " " ) && curr2.equals ( " " ))

        {
            Toast.makeText ( getApplicationContext (), "please select currency from spinner", Toast.LENGTH_SHORT ).show ();
        }
    }

    public void GBPtoEGP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.04350 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in EGP");
            }
        }

        public void GBPtoUSD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.77896 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in USD");
            }
        }

        public void GBPtoURO (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.88940 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in URO");
            }
        }

        public void GBPtoGBP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in GBP");
            }
        }

        public void GBPtoCHF (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.78537 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CHF");
            }
        }

        public void GBPtoCAD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.59018 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CAD");
            }
        }

        public void GBPtoAUD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.56617 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in AUD");
            }
        }

    public void GBPconv ()
    {
        myCurrency = currency_text.getText ().toString ().trim ();

        if (curr1.equals ( "GBP" ) && curr2.equals ( "EGP" )) {
            GBPtoEGP (  );
        } else if (curr1.equals ( "GBP" ) && curr2.equals ( "USD" )) {
            GBPtoUSD (  );
        } else if (curr1.equals ( "GBP" ) && curr2.equals ( "URO" )) {
            GBPtoURO (  );
        } else if (curr1.equals ( "GBP" ) && curr2.equals ( "GBP" )) {
            GBPtoGBP (  );
        } else if (curr1.equals ( "GBP" ) && curr2.equals ( "AUD" )) {
            GBPtoAUD (  );
        } else if (curr1.equals ( "GBP" ) && curr2.equals ( "CHF" )) {
            GBPtoCHF (  );
        } else if (curr1.equals ( "GBP" ) && curr2.equals ( "CAD" )) {
            GBPtoCAD (  );
        } else if (curr1.equals ( " " ) && curr2.equals ( " " ))

        {
            Toast.makeText ( getApplicationContext (), "please select currency from spinner", Toast.LENGTH_SHORT ).show ();
        }
    }

    public void CHFtoUSD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.99184 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in USD");
            }
        }

        public void CHFtoEGP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.05540 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in EGP");
            }
        }

        public void CHFtoURO (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.13269 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in URO");
            }
        }

        public void CHFtoGBP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.27335 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in GBP");
            }
        }

        public void CHFtoCHF (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CHF");
            }
        }

        public void CHFtoCAD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.75156 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CAD");
            }
        }

        public void CHFtoAUD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.72087 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in AUD");

            }
        }

    public void CHFconv (){
        myCurrency = currency_text.getText ().toString ().trim ();

        if (curr1.equals ( "CHF" ) && curr2.equals ( "EGP" )) {
            CHFtoEGP ();
        } else if (curr1.equals ( "CHF" ) && curr2.equals ( "USD" )) {
            CHFtoUSD ();
        } else if (curr1.equals ( "CHF" ) && curr2.equals ( "URO" )) {
            CHFtoURO ();
        } else if (curr1.equals ( "CHF" ) && curr2.equals ( "GBP" )) {
            CHFtoGBP ();
        } else if (curr1.equals ( "CHF" ) && curr2.equals ( "AUD" )) {
            CHFtoAUD ();
        } else if (curr1.equals ( "CHF" ) && curr2.equals ( "CHF" )) {
            CHFtoCHF ();
        } else if (curr1.equals ( "CHF" ) && curr2.equals ( "CAD" )) {
            CHFtoCAD ();
        } else if (curr1.equals ( " " ) && curr2.equals ( " " ))

        {
            Toast.makeText ( getApplicationContext (), "please select currency from spinner", Toast.LENGTH_SHORT ).show ();
        }
    }

        public void CADtoEGP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.07371 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in EGP");
            }
        }

        public void CADtoUSD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.31972 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in USD");
            }
        }

        public void CADtoURO (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.50718 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in URO");
            }
        }

        public void CADtoGBP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.69462 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in GBP");
            }
        }

        public void CADtoCHF (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.33043 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CHF");
            }
        }

        public void CADtoCAD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CAD");
            }
        }

        public void CADtoAUD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.95921 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in AUD");
            }
        }

    public void CADconv (){
        myCurrency = currency_text.getText ().toString ().trim ();

        if (curr1.equals ( "CAD" ) && curr2.equals ( "EGP" )) {
            CADtoEGP ();
        } else if (curr1.equals ( "CAD" ) && curr2.equals ( "USD" )) {
            CADtoUSD ();
        } else if (curr1.equals ( "CAD" ) && curr2.equals ( "URO" )) {
            CADtoURO ();
        } else if (curr1.equals ( "CAD" ) && curr2.equals ( "GBP" )) {
            CADtoGBP ();
        } else if (curr1.equals ( "CAD" ) && curr2.equals ( "AUD" )) {
            CADtoAUD ();
        } else if (curr1.equals ( "CAD" ) && curr2.equals ( "CHF" )) {
            CADtoCHF ();
        } else if (curr1.equals ( "CAD" ) && curr2.equals ( "CAD" )) {
            CADtoCAD ();
        } else if (curr1.equals ( " " ) && curr2.equals ( " " ))

        {
            Toast.makeText ( getApplicationContext (), "please select currency from spinner", Toast.LENGTH_SHORT ).show ();
        }
    }
        public void AUDtoUSD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.37557 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in USD");
            }
        }

        public void AUDtoEGP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.07685 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in EGP");
            }
        }

        public void AUDtoURO (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.57137 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in URO");
            }
        }

        public void AUDtoGBP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.76733 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in GBP");
            }
        }

        public void AUDtoCHF (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.38778 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CHF");
            }
        }

        public void AUDtoCAD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.04320 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CAD");
            }
        }

        public void AUDtoAUD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in AUD");
            }
        }

    public void AUDconv (){

        myCurrency = currency_text.getText ().toString ().trim ();

        if (curr1.equals ( "AUD" ) && curr2.equals ( "EGP" )) {
            AUDtoEGP (  );
        } else if (curr1.equals ( "AUD" ) && curr2.equals ( "USD" )) {
            AUDtoUSD (  );
        } else if (curr1.equals ( "AUD" ) && curr2.equals ( "URO" )) {
            AUDtoURO (  );
        } else if (curr1.equals ( "AUD" ) && curr2.equals ( "GBP" )) {
            AUDtoGBP (  );
        } else if (curr1.equals ( "AUD" ) && curr2.equals ( "AUD" )) {
            AUDtoAUD (  );
        } else if (curr1.equals ( "AUD" ) && curr2.equals ( "CHF" )) {
            AUDtoCHF (  );
        } else if (curr1.equals ( "AUD" ) && curr2.equals ( "CAD" )) {
            AUDtoCAD (  );
        } else if (curr1.equals ( " " ) && curr2.equals ( " " ))

        {
            Toast.makeText ( getApplicationContext (), "please select currency from spinner", Toast.LENGTH_SHORT ).show ();
        }
    }

    public void UROtoUSD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.87614 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in USD");
            }
        }

        public void UROtoEGP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.04892 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in EGP");
            }
        }

        public void UROtoURO (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in URO");
            }
        }

        public void UROtoGBP (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 1.12457 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in GBP");
            }
        }

        public void UROtoCHF (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.88302 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CHF");
            }
        }

        public void UROtoCAD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.66386 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in CAD");
            }
        }

        public void UROtoAUD (){

            myCurrency = currency_text.getText ().toString ().trim ();
            if (myCurrency.length () != 0) {

                currency = Double.parseDouble ( myCurrency );
                converted_curr.setText ( currency * 0.63680 + "" );

            } else {

                converted_curr.setText ( "" );
                converted_curr.setHint("Currency in AUD");
            }
        }
    public void UROconv ()
    {
        myCurrency = currency_text.getText ().toString ().trim ();

        if (curr1.equals ( "URO" ) && curr2.equals ( "EGP" )) {
            UROtoEGP();
        } else if (curr1.equals ( "URO" ) && curr2.equals ( "USD" )) {
            UROtoUSD();
        } else if (curr1.equals ( "URO" ) && curr2.equals ( "URO" )) {
            UROtoURO();
        } else if (curr1.equals ( "URO" ) && curr2.equals ( "GBP" )) {
            UROtoGBP();
        } else if (curr1.equals ( "URO" ) && curr2.equals ( "AUD" )) {
            UROtoAUD();
        } else if (curr1.equals ( "URO" ) && curr2.equals ( "CHF" )) {
            UROtoCHF();
        } else if (curr1.equals ( "URO" ) && curr2.equals ( "CAD" )) {
            UROtoCAD();
        } else if (curr1.equals ( " " ) && curr2.equals ( " " ))

        {
            Toast.makeText ( getApplicationContext (), "please select currency from spinner", Toast.LENGTH_SHORT ).show ();
        }
    }

    }

