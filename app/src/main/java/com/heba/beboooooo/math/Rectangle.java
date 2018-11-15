package com.heba.beboooooo.math;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Rectangle extends AppCompatActivity {

    private EditText rib1_text,rib2_text;
    private RadioButton area,Perimeter;
    private TextView res_txt;
    private Button res_btn,newOp_btn;
    private double result,rib1;
    private final double pie = 3.14;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        Relation();
        Result();
        NewOpp();
        Xtext();
        }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void Relation(){
        rib1_text = (EditText) findViewById(R.id.x_id);
        rib2_text = (EditText) findViewById(R.id.h_id);
        area = (RadioButton) findViewById(R.id.radio_area);
        Perimeter = (RadioButton) findViewById(R.id.radio_perimeter);
        res_txt = (TextView) findViewById(R.id.zero_id);
        res_btn = (Button) findViewById(R.id.result_btn);
        newOp_btn= (Button) findViewById(R.id.NewOperation_btn);

        area.setEnabled(false);
        Perimeter.setEnabled(false);
        newOp_btn .setEnabled(false);;
        newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn2_rc));

        res_btn.setTextColor(Color.parseColor("#000000"));
        newOp_btn.setTextColor(Color.parseColor("#959595"));
    }

    public void Result(){

        res_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                String b1 = rib1_text.getText().toString().trim();
                String b2 = rib2_text.getText().toString().trim();


                if (b1.length()==0) {
                    Toast toast = Toast.makeText(Rectangle.this, "please enter X value", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (b2.length()==0){
                    Toast toast = Toast.makeText(Rectangle.this, "please enter Y value", Toast.LENGTH_SHORT);
                    toast.show();
                }else{

                    if (area.isChecked()) {
                        double b1_int = Double.parseDouble(b1);
                        double b2_int = Double.parseDouble(b2);

                        result = b1_int * b2_int;
                        res_txt.setText(String.valueOf(result));

                        res_btn.setEnabled(false);
                        res_btn.setBackground(getResources().getDrawable(R.drawable.btn2_rc));

                        res_btn.setTextColor(getApplication().getResources().getColor(R.color.gray));
                        newOp_btn.setTextColor(getApplication().getResources().getColor(R.color.black));


                        newOp_btn.setEnabled(true);
                        newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn2));



                    } else if (Perimeter.isChecked()) {

                        double b1_int = Double.parseDouble(b1);
                        double b2_int = Double.parseDouble(b2);

                        result = (b1_int + b2_int) * 2;
                        res_txt.setText(String.valueOf(result));

                        res_btn.setEnabled(false);
                        res_btn.setBackground(getResources().getDrawable(R.drawable.btn2_rc));

                        res_btn.setTextColor(getApplication().getResources().getColor(R.color.gray));
                        newOp_btn.setTextColor(getApplication().getResources().getColor(R.color.black));


                        newOp_btn.setEnabled(true);
                        newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn2));


                    } else {
                        Toast toast1 = Toast.makeText(Rectangle.this, "Please Check First", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                }
            }
        });
    }

    public void NewOpp(){
        newOp_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                rib1_text.setText(String.valueOf(""));
                rib2_text.setText(String.valueOf(""));
                res_txt.setText(String.valueOf(""));
                area.setChecked(false);
                Perimeter.setChecked(false);

                res_btn.setTextColor(getApplication().getResources().getColor(R.color.black));
                newOp_btn.setTextColor(getApplication().getResources().getColor(R.color.gray));


                newOp_btn.setEnabled(false);
                newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn2_rc));

                area.setEnabled(false);
                Perimeter.setEnabled(false);

                res_btn.setEnabled(true);
                res_btn.setBackground(getResources().getDrawable(R.drawable.btn2));

            }
        });

    }


    public void Xtext() {

            rib1_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                area.setEnabled(true);
                Perimeter.setEnabled(true);

            }
        });

        rib2_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                area.setEnabled(true);
                Perimeter.setEnabled(true);

            }
        });

        }


}
