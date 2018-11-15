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

public class Square extends AppCompatActivity {

    private EditText X_text;
    private RadioButton area,Perimeter;
    private TextView res_txt;
    private Button res_btn,newOp_btn;
    private double result;
    private String x;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
        Relation();
        Result();
        NewOpp();
        Xtext();
    }
    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void Relation(){
        X_text = (EditText) findViewById(R.id.x_id);
        area = (RadioButton) findViewById(R.id.radio_area);
        Perimeter = (RadioButton) findViewById(R.id.radio_perimeter);
        res_txt = (TextView) findViewById(R.id.zero_id);
        res_btn = (Button) findViewById(R.id.result_btn);
        newOp_btn= (Button) findViewById(R.id.NewOperation_btn);

        area.setEnabled(false);
        Perimeter.setEnabled(false);
        newOp_btn .setEnabled(false);;
        newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn_sq));

        res_btn.setTextColor(Color.parseColor("#000000"));
        newOp_btn.setTextColor(Color.parseColor("#959595"));

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
      public void Result(){

        res_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                String x = X_text.getText().toString().trim();

                res_btn.setTextColor(getApplication().getResources().getColor(R.color.gray));
                newOp_btn.setTextColor(getApplication().getResources().getColor(R.color.black));

                if (X_text.length()==0) {

                    Toast toast = Toast.makeText(Square.this, "please enter X value", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                if (area.isChecked()) {
                    double y = Double.parseDouble(x);

                    result = y*y;
                    res_txt.setText(String.valueOf(result));

                    res_btn.setEnabled(false);
                    res_btn.setBackground(getResources().getDrawable(R.drawable.btn_sq));


                    newOp_btn.setEnabled(true);
                    newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn));


                }else if (Perimeter.isChecked()){
                    double y = Double.parseDouble(x);

                    result = 4* y;
                    res_txt.setText(String.valueOf(result));

                    res_btn.setEnabled(false);
                    res_btn.setBackground(getResources().getDrawable(R.drawable.btn_sq));

                    newOp_btn.setEnabled(true);
                    newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn));

                }
                else {
                   Toast toast = Toast.makeText(Square.this,"Please Check First",Toast.LENGTH_SHORT);
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

                X_text.setText(String.valueOf(""));
                res_txt.setText(String.valueOf(""));

                res_btn.setTextColor(getApplication().getResources().getColor(R.color.black));
                newOp_btn.setTextColor(getApplication().getResources().getColor(R.color.gray));

                area.setChecked(false);
                Perimeter.setChecked(false);

                area.setEnabled(false);
                Perimeter.setEnabled(false);

                newOp_btn.setEnabled(false);
                newOp_btn.setBackground(getResources().getDrawable(R.drawable.btn_sq));

                area.setEnabled(false);
                Perimeter.setEnabled(false);

                res_btn.setEnabled(true);
                res_btn.setBackground(getResources().getDrawable(R.drawable.btn));
            }
        });

    }

    public void Xtext() {

        X_text.addTextChangedListener(new TextWatcher() {
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
