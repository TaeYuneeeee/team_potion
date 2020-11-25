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
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class petition extends Fragment {
    ViewGroup viewGroup;
    private String TAG = "petition";
    ViewPageAdapter viewPageAdapter;
    ViewPager viewPager;
    Fragment2 fragment2;
    TextView Petition_list;
    public static petition newInstance(){
        return new petition();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.petition,container,false);
//        viewGroup = (ViewGroup) inflater.inflate(R.layout.petition,container,false);
        Petition_list = (TextView) view.findViewById(R.id.petition_list);
        fragment2 = new Fragment2();
        Petition_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), petition_list.class);
                startActivity(in);

                //밑에꺼는 fragment로 화면 구성할 때
//                ((beginning)getActivity()).replaceFragment(Fragment2.newInstance());

            }
        });


        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        viewPageAdapter = new ViewPageAdapter(getContext());
        viewPager.setAdapter(viewPageAdapter);

        return view;
    }
}
