package com.example.swc_project;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class beginning extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    petition petition;
    board board;
    benefit benefit;
    timetable timetable;
    carte carte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginning);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        petition = new petition();
        board = new board();
        benefit = new benefit();
        timetable = new timetable();
        carte = new carte();

        getSupportFragmentManager().beginTransaction().replace(R.id.beginning_layout,petition).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.tab1:{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.beginning_layout,petition).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab2:{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.beginning_layout,board).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab3:{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.beginning_layout,benefit).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab4:{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.beginning_layout,timetable).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab5:{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.beginning_layout,carte).commitAllowingStateLoss();
                        return true;
                    }
                    default: return false;
                }
            }
        });


    }
}
