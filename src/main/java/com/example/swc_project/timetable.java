package com.example.swc_project;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SlidingDrawer;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView Tue_1, Tue_2,Tue_3,Tue_4,Tue_5,Tue_6,Tue_7,Tue_8,Tue_9,Tue_10;
    TextView Wed_1, Wed_2,Wed_3,Wed_4,Wed_5,Wed_6,Wed_7,Wed_8,Wed_9,Wed_10;
    TextView Thu_1, Thu_2,Thu_3,Thu_4,Thu_5,Thu_6,Thu_7,Thu_8,Thu_9,Thu_10;
    TextView Fri_1, Fri_2,Fri_3,Fri_4,Fri_5,Fri_6,Fri_7,Fri_8,Fri_9,Fri_10;

    private Spinner spn_time,spn_week;
    EditText Te_ed_sub;
    Button Te_bt;
    private DatabaseReference mDatabase1;

    Button btnClose;
    private DatabaseReference databaseReference;
    private DatabaseReference mDatabase;
    private FirebaseDatabase database;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);
        View view = inflater.inflate(R.layout.timetable,container,false);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userId = user.getUid();
        mDatabase1 = FirebaseDatabase.getInstance().getReference();
        spn_time = (Spinner)view.findViewById(R.id.spn_time);
        spn_week = (Spinner)view.findViewById(R.id.spn_week);
        Te_ed_sub = (EditText)view.findViewById(R.id.te_ed_sub);
        Te_bt = (Button)view.findViewById(R.id.te_bt);
        final String[] text_time = new String[1];
        final String[] text_week = new String[1];
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

        Tue_1 = view.findViewById(R.id.tv_Tue_1);
        Tue_2 = view.findViewById(R.id.tv_Tue_2);
        Tue_3 = view.findViewById(R.id.tv_Tue_3);
        Tue_4 = view.findViewById(R.id.tv_Tue_4);
        Tue_5 = view.findViewById(R.id.tv_Tue_5);
        Tue_6 = view.findViewById(R.id.tv_Tue_6);
        Tue_7 = view.findViewById(R.id.tv_Tue_7);
        Tue_8 = view.findViewById(R.id.tv_Tue_8);
        Tue_9 = view.findViewById(R.id.tv_Tue_9);
        Tue_10 = view.findViewById(R.id.tv_Tue_10);

        Wed_1 = view.findViewById(R.id.tv_Wed_1);
        Wed_2 = view.findViewById(R.id.tv_Wed_2);
        Wed_3 = view.findViewById(R.id.tv_Wed_3);
        Wed_4 = view.findViewById(R.id.tv_Wed_4);
        Wed_5 = view.findViewById(R.id.tv_Wed_5);
        Wed_6 = view.findViewById(R.id.tv_Wed_6);
        Wed_7 = view.findViewById(R.id.tv_Wed_7);
        Wed_8 = view.findViewById(R.id.tv_Wed_8);
        Wed_9 = view.findViewById(R.id.tv_Wed_9);
        Wed_10 = view.findViewById(R.id.tv_Wed_10);

        Thu_1 = view.findViewById(R.id.tv_Thu_1);
        Thu_2 = view.findViewById(R.id.tv_Thu_2);
        Thu_3 = view.findViewById(R.id.tv_Thu_3);
        Thu_4 = view.findViewById(R.id.tv_Thu_4);
        Thu_5 = view.findViewById(R.id.tv_Thu_5);
        Thu_6 = view.findViewById(R.id.tv_Thu_6);
        Thu_7 = view.findViewById(R.id.tv_Thu_7);
        Thu_8 = view.findViewById(R.id.tv_Thu_8);
        Thu_9 = view.findViewById(R.id.tv_Thu_9);
        Thu_10 = view.findViewById(R.id.tv_Thu_10);

        Fri_1 = view.findViewById(R.id.tv_Fri_1);
        Fri_2 = view.findViewById(R.id.tv_Fri_2);
        Fri_3 = view.findViewById(R.id.tv_Fri_3);
        Fri_4 = view.findViewById(R.id.tv_Fri_4);
        Fri_5 = view.findViewById(R.id.tv_Fri_5);
        Fri_6 = view.findViewById(R.id.tv_Fri_6);
        Fri_7 = view.findViewById(R.id.tv_Fri_7);
        Fri_8 = view.findViewById(R.id.tv_Fri_8);
        Fri_9 = view.findViewById(R.id.tv_Fri_9);
        Fri_10 = view.findViewById(R.id.tv_Fri_10);


        //오류 잡기용 db입력 미리 시켜놓기

        //월요일 9시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Mon9");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
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
                if (db != null) {
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
                if (db != null) {
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
                if (db != null) {
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
                if (db != null) {
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
                if (db != null) {
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
                if (db != null) {
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
                if (db != null) {
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
                if (db != null) {
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
                if (db != null) {
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


        //화요일 9시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Tue9");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Tue_1.setText(Timedb);
                } else {
                    Tue_1.setText("빈 칸");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //화요일 10시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Tue10");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Tue_2.setText(Timedb);
                } else {
                    Tue_2.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //화요일 11시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Tue11");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Tue_3.setText(Timedb);
                } else {
                    Tue_3.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //화요일 12시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Tue12");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Tue_4.setText(Timedb);
                } else {
                    Tue_4.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //화요일 13시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Tue13");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Tue_5.setText(Timedb);
                } else {
                    Tue_5.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //화요일 14시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Tue14");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Tue_6.setText(Timedb);
                } else {
                    Tue_6.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //화요일 15시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Tue15");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Tue_7.setText(Timedb);
                } else {
                    Tue_7.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //화요일 16시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Tue16");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Tue_8.setText(Timedb);
                } else {
                    Tue_8.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //화요일 17시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Tue17");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Tue_9.setText(Timedb);
                } else {
                    Tue_9.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //화요일 18시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Tue18");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Tue_10.setText(Timedb);
                } else {
                    Tue_10.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });


        //수요일 9시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Wed9");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Wed_1.setText(Timedb);
                } else {
                    Wed_1.setText("빈 칸");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //수요일 10시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Wed10");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Wed_2.setText(Timedb);
                } else {
                    Wed_2.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //수요일 11시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Wed11");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Wed_3.setText(Timedb);
                } else {
                    Wed_3.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //수요일 12시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Wed12");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Wed_4.setText(Timedb);
                } else {
                    Wed_4.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //수요일 13시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Wed13");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Wed_5.setText(Timedb);
                } else {
                    Wed_5.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //수요일 14시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Wed14");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Wed_6.setText(Timedb);
                } else {
                    Wed_6.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //수요일 15시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Wed15");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Wed_7.setText(Timedb);
                } else {
                    Wed_7.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //수요일 16시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Wed16");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Wed_8.setText(Timedb);
                } else {
                    Wed_8.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //수요일 17시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Wed17");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Wed_9.setText(Timedb);
                } else {
                    Wed_9.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //수요일 18시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Wed18");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Wed_10.setText(Timedb);
                } else {
                    Wed_10.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });


        //목요일 9시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Thu9");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Thu_1.setText(Timedb);
                } else {
                    Thu_1.setText("빈 칸");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //목요일 10시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Thu10");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Thu_2.setText(Timedb);
                } else {
                    Thu_2.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //목요일 11시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Thu11");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Thu_3.setText(Timedb);
                } else {
                    Thu_3.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //목요일 12시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Thu12");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Thu_4.setText(Timedb);
                } else {
                    Thu_4.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //목요일 13시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Thu13");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Thu_5.setText(Timedb);
                } else {
                    Thu_5.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //목요일 14시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Thu14");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Thu_6.setText(Timedb);
                } else {
                    Thu_6.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //목요일 15시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Thu15");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Thu_7.setText(Timedb);
                } else {
                    Thu_7.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //목요일 16시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Thu16");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Thu_8.setText(Timedb);
                } else {
                    Thu_8.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //목요일 17시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Thu17");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Thu_9.setText(Timedb);
                } else {
                    Thu_9.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //목요일 18시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Thu18");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Thu_10.setText(Timedb);
                } else {
                    Thu_10.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });


        //금요일 9시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Fri9");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Fri_1.setText(Timedb);
                } else {
                    Fri_1.setText("빈 칸");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //금요일 10시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Fri10");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Fri_2.setText(Timedb);
                } else {
                    Fri_2.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //금요일 11시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Fri11");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Fri_3.setText(Timedb);
                } else {
                    Fri_3.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //금요일 12시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Fri12");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Fri_4.setText(Timedb);
                } else {
                    Fri_4.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //금요일 13시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Fri13");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Fri_5.setText(Timedb);
                } else {
                    Fri_5.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //금요일 14시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Fri14");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Fri_6.setText(Timedb);
                } else {
                    Fri_6.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //금요일 15시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Fri15");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Fri_7.setText(Timedb);
                } else {
                    Fri_7.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //금요일 16시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Fri16");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Fri_8.setText(Timedb);
                } else {
                    Fri_8.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //금요일 17시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Fri17");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Fri_9.setText(Timedb);
                } else {
                    Fri_9.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        //금요일 18시
        databaseReference = database.getInstance().getReference("TimeTable").child(userId).child("Fri18");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Timetable_DB db = dataSnapshot.getValue(Timetable_DB.class);
                if (db != null) {
                    String Timedb = db.getSubject();
                    Fri_10.setText(Timedb);
                } else {
                    Fri_10.setText("빈 칸");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("timetable", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        SlidingDrawer drawer = (SlidingDrawer)view.findViewById(R.id.slide);
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
                Toast.makeText(getActivity(),"입력",Toast.LENGTH_LONG).show();
//                Timetable_DB post = new Timetable_DB(text_time[0],text_week[0],Subject);
//                mDatabase.push().setValue(text_time[0],Subject);
//                mDatabase.push().setValue(text_week[0]);
                writetimetable(userId,timeweek,Subject);
            }
        });
//        btnClose = (Button)view.findViewById(R.id.btnclose);
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SlidingDrawer drawer = (SlidingDrawer)view.findViewById(R.id.slide);
//                drawer.animateClose();
//            }
//        });
        return view;
    }
    private void writeMemberInfo(String userId,String Timeweek) {
        mDatabase.child(Timeweek).setValue("0");
    }
    private void writetimetable(String userId,String Timeweek,String Subject) {
        Timetable_DB post = new Timetable_DB(Subject);
        mDatabase.child(Timeweek).setValue(post);
    }
}
