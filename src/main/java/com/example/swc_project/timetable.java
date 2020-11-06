package com.example.swc_project;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class timetable extends Fragment {
    ViewGroup viewGroup;
    TextView tv_title;
    TextView Mon_1, Mon_2,Mon_3,Mon_4,Mon_5,Mon_6,Mon_7,Mon_8,Mon_9,Mon_10;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);
        View view = inflater.inflate(R.layout.timetable,container,false);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userId = user.getUid();

        tv_title = view.findViewById(R.id.timetable_title);
        tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), timetable_edit.class);
                startActivity(in);
            }
        });

        Mon_1 = view.findViewById(R.id.tv_Mon_1);
        Mon_2 = view.findViewById(R.id.tv_Mon_2);
        Mon_3 = view.findViewById(R.id.tv_Mon_3);
        Mon_4 = view.findViewById(R.id.tv_Mon_4);
        Mon_5 = view.findViewById(R.id.tv_Mon_5);
        Mon_6 = view.findViewById(R.id.tv_Mon_6);
        Mon_7 = view.findViewById(R.id.tv_Mon_7);
        Mon_8 = view.findViewById(R.id.tv_Mon_8);
        Mon_9 = view.findViewById(R.id.tv_Mon_9);
        Mon_10 = view.findViewById(R.id.tv_Mon_10);
        //월요일 9시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Mon9");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db.getSubject() != null && db.getSubject().length() != 0) {
                    String Timedb = db.getSubject();
                    Mon_1.setText(Timedb);
                } else {
                    Mon_1.setText("빈 칸");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //월요일 10시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Mon10");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db.getSubject() != null && db.getSubject().length() != 0) {
                    String Timedb = db.getSubject();
                    Mon_2.setText(Timedb);
                } else {
                    Mon_2.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //월요일 11시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Mon11");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db.getSubject() != null && db.getSubject().length() != 0) {
                    String Timedb = db.getSubject();
                    Mon_3.setText(Timedb);
                } else {
                    Mon_3.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //월요일 12시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Mon12");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db.getSubject() != null && db.getSubject().length() != 0) {
                    String Timedb = db.getSubject();
                    Mon_4.setText(Timedb);
                } else {
                    Mon_4.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //월요일 13시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Mon13");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db.getSubject() != null && db.getSubject().length() != 0) {
                    String Timedb = db.getSubject();
                    Mon_5.setText(Timedb);
                } else {
                    Mon_5.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //월요일 14시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Mon14");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db.getSubject() != null && db.getSubject().length() != 0) {
                    String Timedb = db.getSubject();
                    Mon_6.setText(Timedb);
                } else {
                    Mon_6.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //월요일 15시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Mon15");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db.getSubject() != null && db.getSubject().length() != 0) {
                    String Timedb = db.getSubject();
                    Mon_7.setText(Timedb);
                } else {
                    Mon_7.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //월요일 16시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Mon16");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db.getSubject() != null && db.getSubject().length() != 0) {
                    String Timedb = db.getSubject();
                    Mon_8.setText(Timedb);
                } else {
                    Mon_8.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //월요일 17시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Mon17");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db.getSubject() != null && db.getSubject().length() != 0) {
                    String Timedb = db.getSubject();
                    Mon_9.setText(Timedb);
                } else {
                    Mon_9.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //월요일 18시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Mon18");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db.getSubject() != null && db.getSubject().length() != 0) {
                    String Timedb = db.getSubject();
                    Mon_10.setText(Timedb);
                } else {
                    Mon_10.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        return view;
    }
}
