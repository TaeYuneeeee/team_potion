package com.example.swc_project;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.model.detail_post;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class timetable_edit extends AppCompatActivity {
    private Spinner spn_time,spn_week;
    EditText Te_ed_sub;
    Button Te_bt;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_edit);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        spn_time = (Spinner)findViewById(R.id.spn_time);
        spn_week = (Spinner)findViewById(R.id.spn_week);
        Te_ed_sub = (EditText)findViewById(R.id.te_ed_sub);
        Te_bt = (Button)findViewById(R.id.te_bt);
        final String[] text_time = new String[1];
        final String[] text_week = new String[1];
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userId = user.getUid();

        spn_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text_time[0] = spn_time.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spn_week.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text_week[0] = spn_week.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference().child("TimeTable").child(userId);
        Te_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Subject = Te_ed_sub.getText().toString();
                final String timeweek = text_week[0]+text_time[0];
                Toast.makeText(timetable_edit.this,"입력",Toast.LENGTH_LONG).show();
//                Timetable_DB post = new Timetable_DB(text_time[0],text_week[0],Subject);
//                mDatabase.push().setValue(text_time[0],Subject);
//                mDatabase.push().setValue(text_week[0]);
                writeMemberInfo(userId,timeweek,Subject);
            }
        });
    }
    //수정할 때

    private void writeMemberInfo(String userId,String Timeweek,String Subject) {
        Timetable_DB post = new Timetable_DB(Subject);
        mDatabase.child(Timeweek).setValue(post);
    }




}
