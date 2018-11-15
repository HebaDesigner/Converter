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

public class Triangle extends AppCompatActivity {

    private EditText rib1_text,rib2_text,rib3_text,height_text,base_text;
    private RadioButton area,Perimeter;
    private TextView res_txt;
    private Button res_btn,newOp_btn;
    private double result;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        Relation();
        Result();
        NewOpp();
        Xtext();
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void Relation(){
        rib1_text = (EditText) findViewById(R.id.rib1_id);
        rib2_text = (EditText) findViewById(R.id.rib2_id);
        rib3_text = (EditText) findViewById(R.id.rib3_id);
        height_text = (EditText) findViewById(R.id.height_id);
        base_text = (EditText) findViewById(R.id.base_id);
        area = (RadioButton) findViewById(R.id.radio_area);
        Perimeter = (RadioButton) findViewById(R.id.radio_perimeter);
        res_txt = (TextView) findViewById(R.id.zero_id);
        res_btn = (Button) findViewById(R.id.result_btn);
        newOp_btn= (Button) findViewById(R.id.NewOperation_btn);

        area.setEnabled(false);
        Perimeter.setEnabled(false);
        newOp_btn .setEnabled(false);;
        newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn3_tr));

        res_btn.setTextColor(Color.parseColor("#000000"));
        newOp_btn.setTextColor(Color.parseColor("#959595"));
    }

    public void Result(){
        res_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                String b1 = rib1_text.getText().toString().trim();
                String b2 = rib2_text.getText().toString().trim();
                String b3 = rib3_text.getText().toString().trim();
                String hi = height_text.getText().toString().trim();
                String base = base_text.getText().toString().trim();


                    if (b1.length()==0 || b2.length()==0 || b3.length()==0) {
                        Toast toast = Toast.makeText(Triangle.this, "please enter All ribs values", Toast.LENGTH_SHORT);
                        toast.show();
                    } else if (hi.length()==0 || base.length()==0) {
                        Toast toast = Toast.makeText(Triangle.this, "please enter Height & Base values", Toast.LENGTH_SHORT);
                        toast.show();
                    }else {

                    if (area.isChecked()) {

                        double hi_int = Double.parseDouble(hi);
                        double base_int = Double.parseDouble(base);

                        result = (base_int / 2) * hi_int;
                        res_txt.setText(String.valueOf(result));

                        res_btn.setEnabled(false);
                        res_btn.setBackground(getResources().getDrawable(R.drawable.btn3_tr));

                        res_btn.setTextColor(getApplication().getResources().getColor(R.color.gray));
                        newOp_btn.setTextColor(getApplication().getResources().getColor(R.color.black));

                        newOp_btn.setEnabled(true);
                        newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn3));


                    } else if (Perimeter.isChecked()) {
                        double b1_int = Double.parseDouble(b1);
                        double b2_int = Double.parseDouble(b2);
                        double b3_int = Double.parseDouble(b3);

                        result = b1_int + b2_int + b3_int;
                        res_txt.setText(String.valueOf(result));

                        res_btn.setEnabled(false);
                        res_btn.setBackground(getResources().getDrawable(R.drawable.btn3_tr));

                        res_btn.setTextColor(getApplication().getResources().getColor(R.color.gray));
                        newOp_btn.setTextColor(getApplication().getResources().getColor(R.color.black));

                        newOp_btn.setEnabled(true);
                        newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn3));


                    } else {
                        Toast toast = Toast.makeText(Triangle.this, "Please Check First", Toast.LENGTH_SHORT);
                        toast.show();
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
                rib3_text.setText(String.valueOf(""));
                height_text.setText(String.valueOf(""));
                base_text.setText(String.valueOf(""));
                res_txt.setText(String.valueOf(""));
                area.setChecked(false);
                Perimeter.setChecked(false);

                res_btn.setTextColor(getApplication().getResources().getColor(R.color.black));
                newOp_btn.setTextColor(getApplication().getResources().getColor(R.color.gray));


                area.setEnabled(false);
                Perimeter.setEnabled(false);

                newOp_btn.setEnabled(false);
                newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn3_tr));


                res_btn.setEnabled(true);
                res_btn.setBackground(getResources().getDrawable(R.drawable.btn3));
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


        rib3_text.addTextChangedListener(new TextWatcher() {
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

        height_text.addTextChangedListener(new TextWatcher() {
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


        base_text.addTextChangedListener(new TextWatcher() {
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
