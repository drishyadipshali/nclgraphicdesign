package com.drishya.nucleusacademygraphic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class msword extends AppCompatActivity {
    TextView table, idcard, certificate, equation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msword);
        table = findViewById(R.id.table);
        idcard = findViewById(R.id.idcard);
        certificate = findViewById(R.id.certificate);
        equation = findViewById(R.id.equation);

        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(msword.this, pdfView.class);
                i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                i.putExtra("soft", "id");
                startActivity(i);
            }
        });

        // above for table

        idcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(msword.this, pdfView.class);
                i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                i.putExtra("soft", "certificate");
                startActivity(i);
            }
        });
        //above for idcard
        certificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(msword.this, pdfView.class);
                i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                i.putExtra("soft", "certificate");
                startActivity(i);
            }
        });
        //above for certificate
        equation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(msword.this, pdfView.class);
                i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                i.putExtra("soft", "poster");
                startActivity(i);
            }
        });

        //above for logo

    }
}