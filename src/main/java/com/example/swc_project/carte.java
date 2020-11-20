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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class carte extends Fragment {
    ViewGroup viewGroup;
    TextView Breakfastmenu1,Breakfastmenu2,Breakfastmenu3,Breakfastmenu4,Breakfastmenu5;
    TextView[] Breakfastmenu = new TextView[5];
    TextView Lunchmenu1,Lunchmenu2,Lunchmenu3,Lunchmenu4,Lunchmenu5;
    TextView Dinnermenu1,Dinnermenu2,Dinnermenu3,Dinnermenu4,Dinnermenu5;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    String test;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);
        View view = inflater.inflate(R.layout.carte,container,false);
        Breakfastmenu[0] = (TextView)view.findViewById(R.id.breakfastmenu1);
        Breakfastmenu[1] = (TextView)view.findViewById(R.id.breakfastmenu2);
        Breakfastmenu[2] = (TextView)view.findViewById(R.id.breakfastmenu3);
        Breakfastmenu[3] = (TextView)view.findViewById(R.id.breakfastmenu4);
        Breakfastmenu[4] = (TextView)view.findViewById(R.id.breakfastmenu5);

        Breakfastmenu1 = (TextView)view.findViewById(R.id.breakfastmenu1);
        Breakfastmenu2 = (TextView)view.findViewById(R.id.breakfastmenu2);
        Breakfastmenu3 = (TextView)view.findViewById(R.id.breakfastmenu3);
        Breakfastmenu4 = (TextView)view.findViewById(R.id.breakfastmenu4);
        Breakfastmenu5 = (TextView)view.findViewById(R.id.breakfastmenu5);

        Lunchmenu1 = (TextView)view.findViewById(R.id.lunchmenu1);
        Lunchmenu2 = (TextView)view.findViewById(R.id.lunchmenu2);
        Lunchmenu3 = (TextView)view.findViewById(R.id.lunchmenu3);
        Lunchmenu4 = (TextView)view.findViewById(R.id.lunchmenu4);
        Lunchmenu5 = (TextView)view.findViewById(R.id.lunchmenu5);

        Dinnermenu1 = (TextView)view.findViewById(R.id.dinnermenu1);
        Dinnermenu2 = (TextView)view.findViewById(R.id.dinnermenu2);
        Dinnermenu3 = (TextView)view.findViewById(R.id.dinnermenu3);
        Dinnermenu4 = (TextView)view.findViewById(R.id.dinnermenu4);
        Dinnermenu5 = (TextView)view.findViewById(R.id.dinnermenu5);

        //if문을 줘서 현재 화면은 날짜로 가되 monday, tuesday 선택하면 차일드 바꿔 끼우는 걸로

        //아침
        databaseReference = database.getInstance().getReference("carte").child("monday").child("breakfastmenu1");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
//                    carteItem Item = snapshot.getValue(carteItem.class);
                    test = snapshot.getValue(String.class);
//                    String text = Item.getMenu1();
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("breakfastmenu2");
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("breakfastmenu3");
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("breakfastmenu4");
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("breakfastmenu5");
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

        //점심
        databaseReference = database.getInstance().getReference("carte").child("monday").child("lunchmenu1");
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("lunchmenu2");
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("lunchmenu3");
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("lunchmenu4");
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("lunchmenu5");
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

        //저녁
        databaseReference = database.getInstance().getReference("carte").child("monday").child("dinnermenu1");
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("dinnermenu2");
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("dinnermenu3");
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("dinnermenu4");
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

        databaseReference = database.getInstance().getReference("carte").child("monday").child("dinnermenu5");
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





        return view;
    }
}
