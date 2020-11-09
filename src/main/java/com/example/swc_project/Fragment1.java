package com.example.swc_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    ViewGroup viewGroup;
    ViewPageAdapter viewPageAdapter;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,container,false);
//        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment1,container,false);
          viewPager = (ViewPager)view.findViewById(R.id.viewpager);
          viewPageAdapter = new ViewPageAdapter(getContext());
          viewPager.setAdapter(viewPageAdapter);
        return view;
    }
}

