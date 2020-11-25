package com.example.swc_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class carte extends Fragment {
    ViewGroup viewGroup;
    carte_mon Carte_mon;
    carte_tue Carte_tue;
    carte_wed Carte_wed;
    carte_thu Carte_thu;
    carte_fri Carte_fri;
    TextView Carte_date;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    String test;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);
        View view = inflater.inflate(R.layout.carte,container,false);
        Carte_mon = new carte_mon();
        Carte_tue = new carte_tue();
        Carte_wed = new carte_wed();
        Carte_thu = new carte_thu();
        Carte_fri = new carte_fri();
        Carte_date = (TextView)view.findViewById(R.id.carte_date);

//        getChildFragmentManager().beginTransaction().add(R.id.carte_fl,new carte()).commit();
        FragmentTransaction mFragmentTransaction = getChildFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.carte_fl,Carte_mon).commitAllowingStateLoss();
        Button button_mon = (Button)view.findViewById(R.id.carte_bt_mon);
        Button button_tue = (Button)view.findViewById(R.id.carte_bt_tue);
        Button button_wed = (Button)view.findViewById(R.id.carte_bt_wed);
        Button button_thu = (Button)view.findViewById(R.id.carte_bt_thu);
        Button button_fri = (Button)view.findViewById(R.id.carte_bt_fri);


        button_mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.carte_fl,Carte_mon).commitAllowingStateLoss();
                databaseReference = database.getInstance().getReference("carte").child("monday").child("day");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                            test = snapshot.getValue(String.class);
                            if (test != null) {
                                Carte_date.setText(test);
                            } else {
                                Carte_date.setText("날 짜");
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // 디비를 가져오던중 에러 발생 시
                        Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
                    }
                });

            }
        });
        button_tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.carte_fl,Carte_tue).commitAllowingStateLoss();
                databaseReference = database.getInstance().getReference("carte").child("tuesday").child("day");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                            test = snapshot.getValue(String.class);
                            if (test != null) {
                                Carte_date.setText(test);
                            } else {
                                Carte_date.setText("날 짜");
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // 디비를 가져오던중 에러 발생 시
                        Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
                    }
                });
            }
        });
        button_wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.carte_fl,Carte_wed).commitAllowingStateLoss();
                databaseReference = database.getInstance().getReference("carte").child("wednesday").child("day");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                            test = snapshot.getValue(String.class);
                            if (test != null) {
                                Carte_date.setText(test);
                            } else {
                                Carte_date.setText("날 짜");
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // 디비를 가져오던중 에러 발생 시
                        Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
                    }
                });
            }
        });
        button_thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.carte_fl,Carte_thu).commitAllowingStateLoss();
                databaseReference = database.getInstance().getReference("carte").child("thursday").child("day");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                            test = snapshot.getValue(String.class);
                            if (test != null) {
                                Carte_date.setText(test);
                            } else {
                                Carte_date.setText("날 짜");
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // 디비를 가져오던중 에러 발생 시
                        Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
                    }
                });
            }
        });
        button_fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.carte_fl,Carte_fri).commitAllowingStateLoss();
                databaseReference = database.getInstance().getReference("carte").child("friday").child("day");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                            test = snapshot.getValue(String.class);
                            if (test != null) {
                                Carte_date.setText(test);
                            } else {
                                Carte_date.setText("날 짜");
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // 디비를 가져오던중 에러 발생 시
                        Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
                    }
                });
            }
        });



        return view;

    }
}
