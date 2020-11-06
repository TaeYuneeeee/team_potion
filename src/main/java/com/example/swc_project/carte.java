package com.example.swc_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class carte extends Fragment {
    ViewGroup viewGroup;
    TextView Carte_tv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);
        View view = inflater.inflate(R.layout.carte,container,false);
        Carte_tv = view.findViewById(R.id.carte_tv);

        Carte_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(),memberlayout.class);
                startActivity(in);
            }
        });

        return view;
    }
}
