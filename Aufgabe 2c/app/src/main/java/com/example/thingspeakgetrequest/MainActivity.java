package com.example.thingspeakgetrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private Button btnSendRequest;
    private TextView txtGeschwindigkeit, txtDrehzahl;
    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;
    private String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Geschwindigkeit-Feld initialisieren
        txtGeschwindigkeit = (TextView) findViewById(R.id.txtGeschwindigkeit);

        // Drehzahl-Feld initialisieren
        txtDrehzahl = (TextView) findViewById(R.id.txtDrehzahl);

        // Button initialisieren
        btnSendRequest = (Button) findViewById(R.id.btnSendRequest);

        // Button Listener
        btnSendRequest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // 1. URL bilden
                processREST_GET();

                // 2. Request senden
                sendRequestAndPrintResponse();

                // 3. Felder leeren
                emptyFields();
            }

        });
    }

    private void processREST_GET() {
        String strGeschwindikeit = txtGeschwindigkeit.getText().toString();
        String strDrehzahl = txtDrehzahl.getText().toString();

        String api_key = "QYDW98AVOJ7GT8GM";
        this.url = "https://api.thingspeak.com/update?api_key=" + api_key + "&field1=" + strGeschwindikeit + "&field2=" + strDrehzahl;
    }

    private void sendRequestAndPrintResponse() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, this.url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Result handling
                        System.out.println("Response erhalten.");

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();
            }
        });

        // Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);

    }

    private void emptyFields(){
        this.txtDrehzahl.setText("");
        this.txtGeschwindigkeit.setText("");
    }
}
