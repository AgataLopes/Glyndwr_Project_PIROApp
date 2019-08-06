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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Depression extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME = "dark_theme";

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView ScoreTxt;
    private TextView QuestionTxt;
    private Button Choice1Btn;
    private Button Choice2Btn;
    private Button Choice3Btn;
    private Button Choice4Btn;
    private Button backChat;

    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean useDarkTheme = preferences.getBoolean(PREF_DARK_THEME, false);

        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark_NoActionBar);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depression);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        ScoreTxt = (TextView)findViewById(R.id.scoreTxt);
        QuestionTxt = (TextView)findViewById(R.id.questionTxt);
        Choice1Btn = (Button)findViewById(R.id.choice1);
        Choice2Btn = (Button)findViewById(R.id.choice2);
        Choice3Btn = (Button)findViewById(R.id.choice3);
        Choice4Btn = (Button)findViewById(R.id.choice4);
        backChat = (Button)findViewById(R.id.backChat);

        updateQuestion();

        Choice1Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                mScore = mScore;
                updateScore(mScore);
                //Toast.makeText(Depression.this, "+ 0", Toast.LENGTH_SHORT).show();

                if (mQuestionNumber == 21) {
                    updateScore(mScore);
                    //Toast.makeText(Depression.this, "Quiz Finished!!!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Depression.this, ResultsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);
                    Depression.this.finish();
                    startActivity(i);

                } else {
                    updateQuestion();
                }
            }
        }); //End of Button Listener for Button1

        Choice2Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                mScore = mScore + 1;
                updateScore(mScore);
                //Toast.makeText(Depression.this, "+ 1", Toast.LENGTH_SHORT).show();

                if (mQuestionNumber == 21) {
                    updateScore(mScore);
                    //Toast.makeText(Depression.this, "Quiz Finished!!!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Depression.this, ResultsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);
                    Depression.this.finish();
                    startActivity(i);

                } else {
                    updateQuestion();
                }
            }
        }); //End of Button Listener for Button2

        Choice3Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                mScore = mScore + 2;
                updateScore(mScore);
                //Toast.makeText(Depression.this, "+ 2", Toast.LENGTH_SHORT).show();

                if (mQuestionNumber == 21) {
                    updateScore(mScore);
                    //Toast.makeText(Depression.this, "Quiz Finished!!!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Depression.this, ResultsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);
                    Depression.this.finish();
                    startActivity(i);

                } else {
                    updateQuestion();
                }
            }
        }); //End of Button Listener for Button3

        Choice4Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                mScore = mScore + 3;
                updateScore(mScore);
                //Toast.makeText(Depression.this, "+ 3", Toast.LENGTH_SHORT).show();

                if (mQuestionNumber == 21) {
                    updateScore(mScore);
                    //Toast.makeText(Depression.this, "Quiz Finished!!!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Depression.this, ResultsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);
                    Depression.this.finish();
                    startActivity(i);

                } else {
                    updateQuestion();
                }
            }
        }); //End of Button Listener for Button4

        backChat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                askGoBack();
            }
        }); //End of Button Listener for backChat
    }

    private void updateQuestion(){
        QuestionTxt.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        Choice1Btn.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        Choice2Btn.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        Choice3Btn.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        Choice4Btn.setText(mQuestionLibrary.getChoice4(mQuestionNumber));
        mQuestionNumber++;
    }

    private void updateScore(int point) {
        ScoreTxt.setText("" + mScore);
    }

    private void askGoBack (){
        AlertDialog.Builder builder = new AlertDialog.Builder(Depression.this);
        builder.setMessage("Are you sure you want to go back to the chat?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Depression.this.finish();
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
            Intent i_guide= new Intent(Depression.this,Guide.class);
            Depression.this.finish();
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
                Depression.this.finish();
                break;
            case R.id.nav_mindfulness:
                Intent i_mind= new Intent(Depression.this,Mindfulness.class);
                Depression.this.finish();
                startActivity(i_mind);
                break;
            case R.id.nav_motiv_quotes:
                Intent i_motiv= new Intent(Depression.this,Motivational.class);
                Depression.this.finish();
                startActivity(i_motiv);
                break;
            case R.id.nav_depression_test:
                Intent i_depre= new Intent(Depression.this,Depression.class);
                Depression.this.finish();
                startActivity(i_depre);
                break;
            case R.id.nav_cbtworsheets:
                Intent i_cbt= new Intent(Depression.this,CBTWorksheets.class);
                Depression.this.finish();
                startActivity(i_cbt);
                break;
            case R.id.nav_settings:
                Intent i_set= new Intent(Depression.this,Settings.class);
                Depression.this.finish();
                startActivity(i_set);
                break;
            case R.id.nav_user_guide:
                Intent i_guide= new Intent(Depression.this,Guide.class);
                Depression.this.finish();
                startActivity(i_guide);
                break;
            case R.id.nav_info:
                Intent i_info= new Intent(Depression.this,Information.class);
                Depression.this.finish();
                startActivity(i_info);
                break;
            case R.id.nav_email:
                Intent i_email= new Intent(Depression.this,Email.class);
                Depression.this.finish();
                startActivity(i_email);
                break;
            case R.id.nav_terms:
                Intent i_terms= new Intent(Depression.this,Terms.class);
                Depression.this.finish();
                startActivity(i_terms);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
