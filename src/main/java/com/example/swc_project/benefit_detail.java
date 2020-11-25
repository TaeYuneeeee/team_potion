package com.example.swc_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;

public class benefit_detail extends AppCompatActivity {
    TextView text1,text2,text3,text4;
    XmlPullParser xpp;
    String data;
    String tx1,tx2,tx3,tx4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.benefit_detail);
            text1 = (TextView)findViewById(R.id.fragment4_detail_ht1);
            text2 = (TextView)findViewById(R.id.fragment4_detail_ht2);
            text3 = (TextView)findViewById(R.id.fragment4_detail_ht3);
            text4 = (TextView)findViewById(R.id.fragment4_detail_ht4);

            this.tx1 = getIntent().getStringExtra("SvcCts");
            this.tx2 = getIntent().getStringExtra("JrsdDptAllNm");
            this.tx3 = getIntent().getStringExtra("SportTgl");
//            this.tx4 = getIntent().getStringExtra("SvcCts");

            text1.setText(tx1);
            text2.setText(tx2);
            text3.setText(tx4);
//            text4.setText(tx3);



    }
}
