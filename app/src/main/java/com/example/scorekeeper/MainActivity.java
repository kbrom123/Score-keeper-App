package com.example.scorekeeper;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String STATE_SCORE_1="Team 1 Score";
    static final String STATE_SCORE_2="Team 2 score";
    private int score1;
    private int score2;
    private TextView score1_textview;
    private TextView score2_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score1_textview=findViewById(R.id.score1);
        score2_textview=findViewById(R.id.score2);
        if (savedInstanceState!=null){
            score1=savedInstanceState.getInt(STATE_SCORE_1);
            score2=savedInstanceState.getInt(STATE_SCORE_2);
            score1_textview.setText(String.valueOf(score1));
            score2_textview.setText(String.valueOf(score2));
        }
    }

    public void decreaseScore(View view) {
        int viewId=view.getId();
        switch (viewId){
            case R.id.decreaseTeam1:
                score1--;
                score1_textview.setText(String.valueOf(score1));
                break;
            case R.id.decreaseTeam2:
                score2--;
                score2_textview.setText(String.valueOf(score2));
        }
    }

    public void increaseScore(View view) {
        int viewId=view.getId();
        switch (viewId){
            case R.id.increaseTeam1:
                score1++;
                score1_textview.setText(String.valueOf(score1));
                break;
            case R.id.increaseTeam2:
                score2++;
                score2_textview.setText(String.valueOf(score2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        int nightMode=AppCompatDelegate.getDefaultNightMode();
        if (nightMode==AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);

        }
        else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.night_mode){
            int nightMode= AppCompatDelegate.getDefaultNightMode();
            if (nightMode==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();

        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1,score1);
        outState.putInt(STATE_SCORE_2,score2);
        super.onSaveInstanceState(outState);
    }
}