package com.example.swc_project;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Im_1 extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4;
    ArrayList<f4_ap_item> list = null;
    f4_ap_item benefit_item = null;
    String data;
    String code;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benefit_test_detail);
        textView1 = (TextView)findViewById(R.id.benefit_test_tv1);
        textView2 = (TextView)findViewById(R.id.benefit_test_tv2);
        textView3 = (TextView)findViewById(R.id.benefit_test_tv3);
        textView4 = (TextView)findViewById(R.id.benefit_test_tv4);
        this.code = getIntent().getStringExtra("codenum");
        new Thread(new Runnable() {
            @Override
            public void run() {
                data = getXmlData(code);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView1.setText(benefit_item.getSvcNm());
                        textView2.setText(benefit_item.getJrsdDptAllNm());
                        textView3.setText(benefit_item.getSvcPpo());
                        textView4.setText(benefit_item.getSvcCts());
                    }
                });
            }
        }).start();
    }
    String getXmlData(String code) {
        String queryUrl = "http://api.korea.go.kr/openapi/svc?serviceKey=qJQdGNCT%2F3GLGiFxm%2F4dl38xVUMfclbVD7wUMriztrFn%2BmE9QyhdhHdwd7uitI%2BzNCrMDIzrrBYfh96LMhpkcQ%3D%3D&format=xml&svcId="+code;

        try {
            boolean insvcNm = false, injrsdDptAllNm = false, insvcPpo = false, insvcCts = false;

            URL url = new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is = url.openStream(); //url위치로 입력스트림 연결
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//xml파싱을 위한
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new InputStreamReader(is, "UTF-8")); //inputstream 으로부터 xml 입력받기

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        list = new ArrayList<f4_ap_item>();
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("svc")) {
                            benefit_item = new f4_ap_item();
                        }
                        if (parser.getName().equals("svcNm")) {
                            insvcNm = true;
                            Log.d("check", "확인 : " + insvcNm);
                        }
                        if (parser.getName().equals("jrsdDptAllNm")) {
                            injrsdDptAllNm = true;
                        }
                        if (parser.getName().equals("svcPpo")) {
                            insvcPpo = true;
                        }
                        if (parser.getName().equals("svcCts")) {
                            insvcCts = true;
                        }
                        break;

                    case XmlPullParser.TEXT:
                        if (insvcNm) {
                            benefit_item.setSvcNm(parser.getText());
                            String abc = parser.getText();
                            Log.d("Bus", abc);
                            insvcNm = false;
                        } else if (injrsdDptAllNm) {
                            benefit_item.setJrsdDptAllNm(parser.getText());
                            injrsdDptAllNm = false;
                        }else if(insvcPpo){
                            benefit_item.setSvcPpo(parser.getText());
                            insvcPpo = false;
                        }else if(insvcCts){
                            benefit_item.setSvcCts(parser.getText());
                            insvcCts = false;
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("svc") && benefit_item != null) {
                            list.add(benefit_item);
                        }
                        break;
                }
                eventType = parser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
