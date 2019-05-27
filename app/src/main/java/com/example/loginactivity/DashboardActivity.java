package com.example.loginactivity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

//eksplisit
public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    ViewFlipper viewFlipper;
    Animation fadein, fadeout;
    Button btnJenisSampah, btnKunjungi, btnPesan, btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //untuk title judul penggantian nama
        getSupportActionBar().setTitle("Go-Trash");

        //viewflipper
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeout = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();

        //navigationbar
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle= new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);



        //fungsi pemanggilan button pada halaman awal
        btnJenisSampah = (Button) findViewById(R.id.btnJenisSampah);
        btnKunjungi = (Button) findViewById(R.id.btnKunjungi);
        btnPesan = (Button) findViewById(R.id.btnMessage);
        btnMap = (Button) findViewById(R.id.btnLokasi);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MessageActivity.class);
                startActivity(i);
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
            }
        });
        btnJenisSampah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), JenisSampah.class);
                startActivity(i);
            }
        });
        btnKunjungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Kunjungi.class);
                startActivity(i);
            }
        });

    }
    // fungsi menuNavigation
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (item.getItemId() == R.id.home) {
            startActivity(new Intent(this, DashboardActivity.class));
        }else if (item.getItemId() == R.id.pengertian) {
            startActivity(new Intent(this, PengertianActivity.class));
        }else if (item.getItemId() == R.id.profile) {
            startActivity(new Intent(this, ProfileActivity.class));
        }else if (item.getItemId() == R.id.search) {
            startActivity(new Intent(this, Search.class));
        }else if (item.getItemId() == R.id.rating) {
            startActivity(new Intent(this, RatingBarActivity.class));
        }else if (item.getItemId() == R.id.pdf) {
            startActivity(new Intent(this, PDFActivity.class));
        }
        if (id == R.id.log) {
            log();
        }
        return true;
    }

    private void log() {
        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(getBaseContext(), "Logout sukses", Toast.LENGTH_LONG).show();
        finish();
    }
}

