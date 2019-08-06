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
import android.webkit.WebView;

public class Guide extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME = "dark_theme";

    private WebView webGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(PREF_DARK_THEME, false);

        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark_NoActionBar);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        WebView webGuide = findViewById(R.id.webGuide);
        webGuide.getSettings().setJavaScriptEnabled(true);
        webGuide.getSettings().setUseWideViewPort(true);
        webGuide.getSettings().setLoadWithOverviewMode(true);
        webGuide.loadUrl("https://agatamartinslopes.wixsite.com/piroapp/user-guide");

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
            Intent i_guide= new Intent(Guide.this,Guide.class);
            Guide.this.finish();
            startActivity(i_guide);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){

            case R.id.nav_chat:
                Guide.this.finish();
                break;
            case R.id.nav_mindfulness:
                Intent i_mind= new Intent(Guide.this,Mindfulness.class);
                Guide.this.finish();
                startActivity(i_mind);
                break;
            case R.id.nav_motiv_quotes:
                Intent i_motiv= new Intent(Guide.this,Motivational.class);
                Guide.this.finish();
                startActivity(i_motiv);
                break;
            case R.id.nav_depression_test:
                Intent i_depre= new Intent(Guide.this,Depression.class);
                Guide.this.finish();
                startActivity(i_depre);
                break;
            case R.id.nav_cbtworsheets:
                Intent i_cbt= new Intent(Guide.this,CBTWorksheets.class);
                Guide.this.finish();
                startActivity(i_cbt);
                break;
            case R.id.nav_settings:
                Intent i_set= new Intent(Guide.this,Settings.class);
                Guide.this.finish();
                startActivity(i_set);
                break;
            case R.id.nav_user_guide:
                Intent i_guide= new Intent(Guide.this,Guide.class);
                Guide.this.finish();
                startActivity(i_guide);
                break;
            case R.id.nav_info:
                Intent i_info= new Intent(Guide.this,Information.class);
                Guide.this.finish();
                startActivity(i_info);
                break;
            case R.id.nav_email:
                Intent i_email= new Intent(Guide.this,Email.class);
                Guide.this.finish();
                startActivity(i_email);
                break;
            case R.id.nav_terms:
                Intent i_terms= new Intent(Guide.this,Terms.class);
                Guide.this.finish();
                startActivity(i_terms);
                break;

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
