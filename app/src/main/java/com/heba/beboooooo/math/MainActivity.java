package com.heba.beboooooo.math;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout Currency;
    LinearLayout Time;
    LinearLayout Distance;
    LinearLayout Speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Relathon();
        CUR();
        TIM();
        DIS();
        SP();
    }

    public void Relathon() {
        Currency = (LinearLayout) findViewById(R.id.currency_id);
        Time = (LinearLayout) findViewById(R.id.time_id);
        Distance = (LinearLayout) findViewById(R.id.distance_id);
        Speed = (LinearLayout) findViewById(R.id.speed_id);
    }

    public void CUR() {

        Currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Currency.class);
                startActivity(intent);

            }
        });

    }

    public void TIM() {

        Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Time.class);
                startActivity(intent);
            }
        });

    }

    public void DIS() {

        Distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Distance.class);
                startActivity(intent);
            }
        });

    }
    public void SP() {

        Speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Speed.class);
                startActivity(intent);
            }
        });

    }
}