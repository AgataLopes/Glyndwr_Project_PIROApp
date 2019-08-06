package com.example.piro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME = "dark_theme";

    TextView level_txt, results_txt;
    Button RetryBtn, backChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(PREF_DARK_THEME, false);

        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark_NoActionBar);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        level_txt = (TextView)findViewById(R.id.level_txt);
        results_txt = (TextView)findViewById(R.id.results_txt);
        RetryBtn = (Button)findViewById(R.id.retry_btn);
        backChat = (Button)findViewById(R.id.backChat);

        Bundle bundle = getIntent().getExtras();
        int scoreTxt = bundle.getInt("finalScore");

        results_txt.setText("You scored " + scoreTxt );

        if (scoreTxt == 0){
            level_txt.setText("You are not depressed.");
        }else if(scoreTxt >= 1 && scoreTxt <= 10){
            level_txt.setText("These ups and downs are considered normal.");
        }else if (scoreTxt >= 11 && scoreTxt <=16){
            level_txt.setText(" Mild mood disturbance.");
        }else if (scoreTxt >= 17 && scoreTxt <=20) {
            level_txt.setText("Borderline clinical depression.");
        }else if (scoreTxt >= 21 && scoreTxt <=30) {
            level_txt.setText("Moderate depression.");
        }else if (scoreTxt >= 31 && scoreTxt <=40) {
            level_txt.setText("Severe depression.");
        }else {
            level_txt.setText("Extreme depression.");
        }

        RetryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_depre= new Intent(ResultsActivity.this,Depression.class);
                ResultsActivity.this.finish();
                startActivity(i_depre);
            }
        });

        backChat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                askGoBack();
            }
        });
    }

    private void askGoBack (){
        AlertDialog.Builder builder = new AlertDialog.Builder(ResultsActivity.this);
        builder.setMessage("Are you sure you want to go back to the chat?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                ResultsActivity.this.finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
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
            Intent i_guide= new Intent(ResultsActivity.this,Guide.class);
            ResultsActivity.this.finish();
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
                ResultsActivity.this.finish();
                break;
            case R.id.nav_mindfulness:
                Intent i_mind= new Intent(ResultsActivity.this,Mindfulness.class);
                ResultsActivity.this.finish();
                startActivity(i_mind);
                break;
            case R.id.nav_motiv_quotes:
                Intent i_motiv= new Intent(ResultsActivity.this,Motivational.class);
                ResultsActivity.this.finish();
                startActivity(i_motiv);
                break;
            case R.id.nav_depression_test:
                Intent i_depre= new Intent(ResultsActivity.this,Depression.class);
                ResultsActivity.this.finish();
                startActivity(i_depre);
                break;
            case R.id.nav_cbtworsheets:
                Intent i_cbt= new Intent(ResultsActivity.this,CBTWorksheets.class);
                ResultsActivity.this.finish();
                startActivity(i_cbt);
                break;
            case R.id.nav_settings:
                Intent i_set= new Intent(ResultsActivity.this,Settings.class);
                ResultsActivity.this.finish();
                startActivity(i_set);
                break;
            case R.id.nav_user_guide:
                Intent i_guide= new Intent(ResultsActivity.this,Guide.class);
                ResultsActivity.this.finish();
                startActivity(i_guide);
                break;
            case R.id.nav_info:
                Intent i_info= new Intent(ResultsActivity.this,Information.class);
                ResultsActivity.this.finish();
                startActivity(i_info);
                break;
            case R.id.nav_email:
                Intent i_email= new Intent(ResultsActivity.this,Email.class);
                ResultsActivity.this.finish();
                startActivity(i_email);
                break;
            case R.id.nav_terms:
                Intent i_terms= new Intent(ResultsActivity.this,Terms.class);
                ResultsActivity.this.finish();
                startActivity(i_terms);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
