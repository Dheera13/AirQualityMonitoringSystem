package com.example.airqualitymonitoringsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;


public class gif extends AppCompatActivity {
    int AQI_Level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gif);
        TextView aqi_level = (TextView)findViewById(R.id.textView);
        Intent parentIntent = getIntent();
        AQI_Level = parentIntent.getIntExtra("AQI",350);
        aqi_level.setText(Integer.toString(AQI_Level));

        Button news = (Button) findViewById(R.id.news);
        Button adv = (Button) findViewById(R.id.adv);

        if(news!=null)
            news.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(gif.this, MainActivity.class);
                    startActivity(i);
                }
            });

        adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(gif.this, advisory.class);
                startActivity(i);
            }
        });


    }

    public void share(View v)
    {

        Intent sendMailIntent = new Intent(Intent.ACTION_SEND);
        sendMailIntent.putExtra(Intent.EXTRA_SUBJECT, "Car Pool");
        sendMailIntent.putExtra(Intent.EXTRA_TEXT, "Do you want to Car Pool?");
        sendMailIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendMailIntent, "Share Using"));
        Log.e("Car Pool: ", "Clicked CP");
    }

    public void adv(View v)
    {
        Intent intent = new Intent(this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("Value", Integer.toString(AQI_Level));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
