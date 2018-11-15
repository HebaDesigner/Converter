package com.heba.beboooooo.math;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout square;
    LinearLayout Circle;
    LinearLayout Rectangle;
    LinearLayout Triangle;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Relathon();
        SQ();
        CR();
        RC();
        TR();
    }

    public void Relathon() {
        square = (LinearLayout) findViewById(R.id.square_id);
        Circle = (LinearLayout) findViewById(R.id.circle_id);
        Rectangle = (LinearLayout) findViewById(R.id.rectangle_id);
        Triangle = (LinearLayout) findViewById(R.id.triangle_id);
    }

    public void SQ() {

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Square.class);
                startActivity(intent);

            }
        });

    }

    public void CR() {

        Circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Circle.class);
                startActivity(intent);
            }
        });

    }

    public void RC() {

        Rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Rectangle.class);
                startActivity(intent);
            }
        });

    }
    public void TR() {

        Triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Triangle.class);
                startActivity(intent);
            }
        });

    }
}