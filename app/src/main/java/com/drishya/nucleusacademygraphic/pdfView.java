package com.drishya.nucleusacademygraphic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class pdfView extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    PDFView pdf;
    private static final String TAG = "faild to load";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);



        floatingActionButton = (FloatingActionButton) findViewById(R.id.home);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pdfView.this, MainActivity.class);
                intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        //above code is for the floating button
       String s = null;
       s= getIntent().getExtras().getString("soft");
      Integer i = null;
       i = getIntent().getExtras().getInt("soft");

        pdf = (PDFView) findViewById(R.id.pdfview);


       try {
           if (s.matches("paint")) {
               pdf.fromAsset("paint.pdf").load();
           }
           else if(s.matches("Excel"))
           {
               pdf.fromAsset("excel practice.pdf").load();
           }
           else if(s.matches("powerpoint"))
           {
               pdf.fromAsset("powerpnt.pdf").load();
           }
           else if(s.matches("course"))
           {
               pdf.fromAsset("course.pdf").load();
           }
           else if(s.matches("table"))
           {
               pdf.fromAsset("tablepractice.pdf").load();
           }
           else if(s.matches("course"))
           {
               pdf.fromAsset("course.pdf").load();
           }
           else if(s.matches("idcard"))
           {
               pdf.fromAsset("idcard.pdf").load();
           }
           else if(s.matches("certificate"))
           {
               pdf.fromAsset("certificate.pdf").load();
           }
           else if(s.matches("logo"))
           {
               pdf.fromAsset("equation and logo.pdf").load();
           }
           else if(s.matches("p1"))
           {
               pdf.fromAsset("idcard.pdf").load();
           }
           else if(s.matches("p0"))
           {
               pdf.fromAsset("paint.pdf").load();
           }
           else if(s.matches("p2"))
           {
               pdf.fromAsset("excel practice.pdf").load();
           }
           else if(s.matches("p3"))
           {
               pdf.fromAsset("powerpnt.pdf").load();
           }
           else if(s.matches("p4"))
           {
               pdf.fromAsset("course.pdf").load();
           }






       }
       catch (NullPointerException e){
           Log.d(TAG, "onCreate:called ");
       }



    }
}