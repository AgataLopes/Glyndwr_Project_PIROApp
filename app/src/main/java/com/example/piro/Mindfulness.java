package com.example.piro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.ScrollView;

import pl.droidsonroids.gif.GifAnimationMetaData;
import pl.droidsonroids.gif.GifImageView;

public class Mindfulness extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME = "dark_theme";

    Button excBtn1;
    Button excBtn2;
    Button excBtn3;
    Button excBtn4;
    Button excBtn5;
    Button excBtn6;
    Button excBtn7;
    Button excBtn8;
    Button excBtn9;
    Button excBtn10;
    GifImageView gifimg;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(PREF_DARK_THEME, false);

        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark_NoActionBar);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfulness);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);

        gifimg = (GifImageView) findViewById(R.id.gifimg);
        gifimg.setBackgroundResource(R.drawable.gif1);

        excBtn1 = (Button) findViewById(R.id.excBtn1);
        excBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifimg = (GifImageView) findViewById(R.id.gifimg);
                gifimg.setBackgroundResource(R.drawable.gif1);
                scrollView.setScrollY(0);
            }
        });

        excBtn2 = (Button) findViewById(R.id.excBtn2);
        excBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifimg = (GifImageView) findViewById(R.id.gifimg);
                gifimg.setBackgroundResource(R.drawable.gif2);
                scrollView.setScrollY(0);
            }
        });

        excBtn3 = (Button) findViewById(R.id.excBtn3);
        excBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifimg = (GifImageView) findViewById(R.id.gifimg);
                gifimg.setBackgroundResource(R.drawable.gif3);
                scrollView.setScrollY(0);
            }
        });

        excBtn4 = (Button) findViewById(R.id.excBtn4);
        excBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifimg = (GifImageView) findViewById(R.id.gifimg);
                gifimg.setBackgroundResource(R.drawable.gif4);
                scrollView.setScrollY(0);
            }
        });

        excBtn5 = (Button) findViewById(R.id.excBtn5);
        excBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifimg = (GifImageView) findViewById(R.id.gifimg);
                gifimg.setBackgroundResource(R.drawable.gif5);
                scrollView.setScrollY(0);
            }
        });

        excBtn6 = (Button) findViewById(R.id.excBtn6);
        excBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifimg = (GifImageView) findViewById(R.id.gifimg);
                gifimg.setBackgroundResource(R.drawable.gif6);
                scrollView.setScrollY(0);
            }
        });

        excBtn7 = (Button) findViewById(R.id.excBtn7);
        excBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifimg = (GifImageView) findViewById(R.id.gifimg);
                gifimg.setBackgroundResource(R.drawable.gif7);
                scrollView.setScrollY(0);
            }
        });

        excBtn8 = (Button) findViewById(R.id.excBtn8);
        excBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifimg = (GifImageView) findViewById(R.id.gifimg);
                gifimg.setBackgroundResource(R.drawable.gif8);
                scrollView.setScrollY(0);
            }
        });

        excBtn9 = (Button) findViewById(R.id.excBtn9);
        excBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifimg = (GifImageView) findViewById(R.id.gifimg);
                gifimg.setBackgroundResource(R.drawable.gif9);
                scrollView.setScrollY(0);
            }
        });

        excBtn10 = (Button) findViewById(R.id.excBtn10);
        excBtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifimg = (GifImageView) findViewById(R.id.gifimg);
                gifimg.setBackgroundResource(R.drawable.gif10);
                scrollView.setScrollY(0);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i_guide= new Intent(Mindfulness.this,Guide.class);
            Mindfulness.this.finish();
            startActivity(i_guide);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){

            case R.id.nav_chat:
                Mindfulness.this.finish();
                break;
            case R.id.nav_mindfulness:
                Intent i_mind= new Intent(Mindfulness.this,Mindfulness.class);
                Mindfulness.this.finish();
                startActivity(i_mind);
                break;
            case R.id.nav_motiv_quotes:
                Intent i_motiv= new Intent(Mindfulness.this,Motivational.class);
                Mindfulness.this.finish();
                startActivity(i_motiv);
                break;
            case R.id.nav_depression_test:
                Intent i_depre= new Intent(Mindfulness.this,Depression.class);
                Mindfulness.this.finish();
                startActivity(i_depre);
                break;
            case R.id.nav_cbtworsheets:
                Intent i_cbt= new Intent(Mindfulness.this,CBTWorksheets.class);
                Mindfulness.this.finish();
                startActivity(i_cbt);
                break;
            case R.id.nav_settings:
                Intent i_set= new Intent(Mindfulness.this,Settings.class);
                Mindfulness.this.finish();
                startActivity(i_set);
                break;
            case R.id.nav_user_guide:
                Intent i_guide= new Intent(Mindfulness.this,Guide.class);
                Mindfulness.this.finish();
                startActivity(i_guide);
                break;
            case R.id.nav_info:
                Intent i_info= new Intent(Mindfulness.this,Information.class);
                Mindfulness.this.finish();
                startActivity(i_info);
                break;
            case R.id.nav_email:
                Intent i_email= new Intent(Mindfulness.this,Email.class);
                Mindfulness.this.finish();
                startActivity(i_email);
                break;
            case R.id.nav_terms:
                Intent i_terms= new Intent(Mindfulness.this,Terms.class);
                Mindfulness.this.finish();
                startActivity(i_terms);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
