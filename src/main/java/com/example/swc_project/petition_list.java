package com.example.swc_project;

import android.content.Context;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class petition_list extends AppCompatActivity {
    ViewGroup viewGroup;
    private String TAG = "petition";

    private RecyclerView recyclerView;
    private Adapter_petition adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<petition_Item> data;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReference1;
    TextView petition_tv;

    FloatingActionButton FAB_newPost;

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petition_list);
//        viewGroup = (ViewGroup) inflater.inflate(R.layout.petition,container,false);
        recyclerView = (RecyclerView)findViewById(R.id.petition_recy);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.scrollToPosition(0);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        petition_tv = (TextView) findViewById(R.id.petition_tv);
        adapter = new Adapter_petition(data);
        data = new ArrayList<>();
        FAB_newPost = (FloatingActionButton)findViewById(R.id.Post_petition_edit);

        FAB_newPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(petition_list.this, petition_newPost.class);
                startActivity(in);
            }
        });

        databaseReference1 = FirebaseDatabase.getInstance().getReference().child("petition");

        databaseReference = database.getInstance().getReference("petition"); // DB 테이블 연결
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                data.clear(); // 기존 배열리스트가 존재하지않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    petition_Item Item = snapshot.getValue(petition_Item.class);
                    data.add(Item); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                    String test = Item.getTitle();
                    Log.d("petition_list","getTitile : "+test);
                }
                adapter.notifyDataSetChanged();; // 리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("petition", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        recyclerView.setAdapter(adapter);


    }
}
