package com.example.thingspeakdata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;

public class MainActivity extends Activity implements View.OnClickListener {


    Button button2;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        txt1 = (TextView) findViewById(R.id.txt1);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, RequestQueue.class);
        startActivity(intent);
        this.finish();
    }


}
