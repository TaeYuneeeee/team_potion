package com.example.swc_project;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class carte_wed extends Fragment {
    TextView Breakfastmenu1,Breakfastmenu2,Breakfastmenu3,Breakfastmenu4,Breakfastmenu5,Breakfastmenu6;
    TextView Lunchmenu1,Lunchmenu2,Lunchmenu3,Lunchmenu4,Lunchmenu5,Lunchmenu6;
    TextView Dinnermenu1,Dinnermenu2,Dinnermenu3,Dinnermenu4,Dinnermenu5,Dinnermenu6;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    String test;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carte_wed,container,false);
        Breakfastmenu1 = (TextView)view.findViewById(R.id.wed_breakfastmenu1);
        Breakfastmenu2 = (TextView)view.findViewById(R.id.wed_breakfastmenu2);
        Breakfastmenu3 = (TextView)view.findViewById(R.id.wed_breakfastmenu3);
        Breakfastmenu4 = (TextView)view.findViewById(R.id.wed_breakfastmenu4);
        Breakfastmenu5 = (TextView)view.findViewById(R.id.wed_breakfastmenu5);
        Breakfastmenu6 = (TextView)view.findViewById(R.id.wed_breakfastmenu6);

        Lunchmenu1 = (TextView)view.findViewById(R.id.wed_lunchmenu1);
        Lunchmenu2 = (TextView)view.findViewById(R.id.wed_lunchmenu2);
        Lunchmenu3 = (TextView)view.findViewById(R.id.wed_lunchmenu3);
        Lunchmenu4 = (TextView)view.findViewById(R.id.wed_lunchmenu4);
        Lunchmenu5 = (TextView)view.findViewById(R.id.wed_lunchmenu5);
        Lunchmenu6 = (TextView)view.findViewById(R.id.wed_lunchmenu6);


        Dinnermenu1 = (TextView)view.findViewById(R.id.wed_dinnermenu1);
        Dinnermenu2 = (TextView)view.findViewById(R.id.wed_dinnermenu2);
        Dinnermenu3 = (TextView)view.findViewById(R.id.wed_dinnermenu3);
        Dinnermenu4 = (TextView)view.findViewById(R.id.wed_dinnermenu4);
        Dinnermenu5 = (TextView)view.findViewById(R.id.wed_dinnermenu5);
        Dinnermenu6 = (TextView)view.findViewById(R.id.wed_dinnermenu6);

        //아침
        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("breakfastmenu1");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Breakfastmenu1.setText(test);
                    } else {
                        Breakfastmenu1.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("breakfastmenu2");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Breakfastmenu2.setText(test);
                    } else {
                        Breakfastmenu2.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("breakfastmenu3");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Breakfastmenu3.setText(test);
                    } else {
                        Breakfastmenu3.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("breakfastmenu4");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Breakfastmenu4.setText(test);
                    } else {
                        Breakfastmenu4.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("breakfastmenu5");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Breakfastmenu5.setText(test);
                    } else {
                        Breakfastmenu5.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("breakfastmenu6");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Breakfastmenu6.setText(test);
                    } else {
                        Breakfastmenu6.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        //점심
        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("lunchmenu1");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Lunchmenu1.setText(test);
                    } else {
                        Lunchmenu1.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("lunchmenu2");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Lunchmenu2.setText(test);
                    } else {
                        Lunchmenu2.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("lunchmenu3");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Lunchmenu3.setText(test);
                    } else {
                        Lunchmenu3.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("lunchmenu4");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Lunchmenu4.setText(test);
                    } else {
                        Lunchmenu4.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("lunchmenu5");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Lunchmenu5.setText(test);
                    } else {
                        Lunchmenu5.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("lunchmenu6");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Lunchmenu6.setText(test);
                    } else {
                        Lunchmenu6.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        //저녁
        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("dinnermenu1");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Dinnermenu1.setText(test);
                    } else {
                        Dinnermenu1.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("dinnermenu2");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Dinnermenu2.setText(test);
                    } else {
                        Dinnermenu2.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("dinnermenu3");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Dinnermenu3.setText(test);
                    } else {
                        Dinnermenu3.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("dinnermenu4");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Dinnermenu4.setText(test);
                    } else {
                        Dinnermenu4.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("dinnermenu5");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Dinnermenu5.setText(test);
                    } else {
                        Dinnermenu5.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference = database.getInstance().getReference("carte").child("wednesday").child("dinnermenu6");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    test = snapshot.getValue(String.class);
                    if (test != null) {
                        Dinnermenu6.setText(test);
                    } else {
                        Dinnermenu6.setText("빈 칸");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("carte", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        return view;
    }
}
