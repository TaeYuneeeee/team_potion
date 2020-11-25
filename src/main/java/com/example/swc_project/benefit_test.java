package com.example.swc_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class benefit_test extends Fragment {
    ViewGroup viewGroup;
    ImageButton Imb_1,Imb_2,Imb_3,Imb_4,Imb_5;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);
        View view = inflater.inflate(R.layout.benefit_test,container,false);
        Imb_1 = (ImageButton)view.findViewById(R.id.im_1);
        Imb_2 = (ImageButton)view.findViewById(R.id.im_2);
        Imb_3 = (ImageButton)view.findViewById(R.id.im_3);
        Imb_4 = (ImageButton)view.findViewById(R.id.im_4);
        Imb_5 = (ImageButton)view.findViewById(R.id.im_5);

        Imb_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Im_1.class);
                in.putExtra("codenum","386000000187");
                startActivity(in);
            }
        });
        Imb_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Im_1.class);
                in.putExtra("codenum","405000000524");
                startActivity(in);
            }
        });
        Imb_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Im_1.class);
                in.putExtra("codenum","397000000101");
                startActivity(in);
            }
        });
        Imb_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Im_1.class);
                in.putExtra("codenum","378000000167");
                startActivity(in);
            }
        });
        Imb_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Im_1.class);
                in.putExtra("codenum","383000000538");
                startActivity(in);
            }
        });

        return view;
    }
}
