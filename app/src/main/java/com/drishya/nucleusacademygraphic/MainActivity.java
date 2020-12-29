package com.drishya.nucleusacademygraphic;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.material.navigation.NavigationView;
import com.onesignal.OneSignal;

import java.io.File;

import github.nisrulz.lantern.Lantern;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, courseAdapter.onCourseListener {
    NavigationView navigationView;
    Toolbar tbar;
    DrawerLayout drawer;
    String st[], st2[];
    private static final String ONESIGNAL_APP_ID = "6fc251c5-a3ad-45df-af93-885b02d6a095";
    Switch aSwitch;
    int img[] = {R.drawable.paint, R.drawable.msword, R.drawable.excel, R.drawable.pnt,
            R.drawable.courses};
    ;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(MainActivity.this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);





        //aboe code for the onesignal
        Lantern lantern = new Lantern(this)
                .checkAndRequestSystemPermission()

                .observeLifecycle(this);

        if (!lantern.initTorch()) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }


/*// Handle the runtime permission
        @Override
        public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions;
        @NonNull int[] grantResults){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            if (requestCode == 0) {
                // Retry initializing the Lantern's torch feature
                if (!lantern.initTorch()) {
                    // Camera Permission Denied! Do something.
                }
            }
        }*/
aSwitch = (Switch) findViewById(R.id.switch1);
      aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
           if(b==true)
           {
               lantern.enableTorchMode(true);
           }
           else if(b==false)
           {
               lantern.enableTorchMode(false);
           }
          }
      });



        //above code to troch on

        navigationView = (NavigationView) findViewById(R.id.nview);




        st = getResources().getStringArray(R.array.course);
        st2 = getResources().getStringArray(R.array.discription);

        //above code is for asign string from string.xml

        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));

        courseAdapter courseAdapter = new courseAdapter(this, st, st2, img, this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        //above code is for recyclerview

        tbar = (Toolbar) findViewById(R.id.tbar);
        setSupportActionBar(tbar);
        navigationView.setNavigationItemSelectedListener(this);
        drawer = (DrawerLayout) findViewById(R.id.drawlayout);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(MainActivity.this,
                drawer, tbar, R.string.open_navigation_menu
                , R.string.close_navigation_menu);
        drawer.addDrawerListener(toogle);
        toogle.syncState();
        //above code is for navigation drawer menu


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.paint) {
            Intent intent = new Intent(MainActivity.this, pdfView.class);
            intent.putExtra("soft", "paint");
            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        } else if (id == R.id.word) {
            Intent intent = new Intent(MainActivity.this, msword.class);
            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);

            startActivity(intent);
        } else if (id == R.id.excel) {
            Intent intent = new Intent(MainActivity.this, pdfView.class);
            intent.putExtra("soft", "Excel");
            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        } else if (id == R.id.pnt) {
            Intent intent = new Intent(MainActivity.this, pdfView.class);
            intent.putExtra("soft", "powerpoint");
            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        } else if (id == R.id.course) {
            Intent intent = new Intent(MainActivity.this, pdfView.class);
            intent.putExtra("soft", "course");
            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        } else if (id == R.id.share) {
            ApplicationInfo api = getApplicationContext().getApplicationInfo();
            String share = api.sourceDir;
            Intent shareintent = new Intent(Intent.ACTION_SEND);
            shareintent.setType("text/plain");
            shareintent.putExtra(shareintent.EXTRA_STREAM, Uri.fromFile(new File(share)));
            startActivity(Intent.createChooser(shareintent, "Share With"));
        } else if (id == R.id.Terms) {
            checkConnectionForNav();

        }

        return true;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkConnectionForNav() {

        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        if (null != activeNetwork) {

            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {

                Intent privacyp = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drishyadipshali.github.io/nucleusacademy/"));
                startActivity(privacyp);
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {

                Intent privacyp = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drishyadipshali.github.io/nucleusacademy/"));
                startActivity(privacyp);
            } else {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("No Internet Connetion")
                        .setMessage("Please Connet With Internet");
                AlertDialog aler = alert.create();
                aler.show();

            }
        }
    }

    @Override
    public void onCourseClick(int position) {
        int i = 1;
        Intent in = new Intent(this, pdfView.class);
        in.putExtra("soft","p"+position);
        in.setFlags(in.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(in);

    }
}