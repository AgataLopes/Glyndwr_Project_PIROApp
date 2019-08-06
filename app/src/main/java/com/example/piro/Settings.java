package com.example.piro;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.CompoundButton;
import android.widget.Switch;

public class Settings extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME = "dark_theme";

    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(PREF_DARK_THEME, false);

        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark_NoActionBar);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setChecked(useDarkTheme);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Settings.this);
                builder.setMessage("Are you sure you want to change theme? Once you do this your chat with Piro will restart.");
                builder.setCancelable(true);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        chosenTheme(isChecked);
                        Intent i_chat= new Intent(Settings.this,Chat.class);
                        Settings.this.finish();
                        startActivity(i_chat);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i_set= new Intent(Settings.this,Settings.class);
                        Settings.this.finish();
                        startActivity(i_set);
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    private void chosenTheme(boolean darkTheme) {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putBoolean(PREF_DARK_THEME, darkTheme);
        editor.apply();

        Intent intent = getIntent();
        finish();

        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else {
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
            Intent i_guide= new Intent(Settings.this,Guide.class);
            Settings.this.finish();
            startActivity(i_guide);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Switch switch1 = (Switch) findViewById(R.id.switch1);

        int id = item.getItemId();
        switch (id){

            case R.id.nav_chat:
                Settings.this.finish();
                break;
            case R.id.nav_mindfulness:
                Intent i_mind= new Intent(Settings.this,Mindfulness.class);
                Settings.this.finish();
                startActivity(i_mind);
                break;
            case R.id.nav_motiv_quotes:
                Intent i_motiv= new Intent(Settings.this,Motivational.class);
                Settings.this.finish();
                startActivity(i_motiv);
                break;
            case R.id.nav_depression_test:
                Intent i_depre= new Intent(Settings.this,Depression.class);
                Settings.this.finish();
                startActivity(i_depre);
                break;
            case R.id.nav_cbtworsheets:
                Intent i_cbt= new Intent(Settings.this,CBTWorksheets.class);
                Settings.this.finish();
                startActivity(i_cbt);
                break;
            case R.id.nav_settings:
                Intent i_set= new Intent(Settings.this,Settings.class);
                Settings.this.finish();
                startActivity(i_set);
                break;
            case R.id.nav_user_guide:
                Intent i_guide= new Intent(Settings.this,Guide.class);
                Settings.this.finish();
                startActivity(i_guide);
                break;
            case R.id.nav_info:
                Intent i_info= new Intent(Settings.this,Information.class);
                Settings.this.finish();
                startActivity(i_info);
                break;
            case R.id.nav_email:
                Intent i_email= new Intent(Settings.this,Email.class);
                Settings.this.finish();
                startActivity(i_email);
                break;
            case R.id.nav_terms:
                Intent i_terms= new Intent(Settings.this,Terms.class);
                Settings.this.finish();
                startActivity(i_terms);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
