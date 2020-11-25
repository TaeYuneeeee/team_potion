package com.example.swc_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

public class benefit extends Fragment {
    ViewGroup viewGroup;
    String[] service_Id;
    String data;
    RecyclerView recyclerView;
    ArrayList<f4_ap_item> list = null;
    f4_ap_item benefit_item = null;
    Fragment4_Adapter fragment4Adapter;
    RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);
        View view = inflater.inflate(R.layout.benefit,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.benefit_recy);
        recyclerView.setHasFixedSize(true);

        recyclerView.scrollToPosition(0);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        layoutManager = new LinearLayoutManager(inflater.getContext());
        recyclerView.setLayoutManager(layoutManager);

        service_Id = new String[]{"383000000538"};
        new Thread(new Runnable() {
            @Override
            public void run() {
                data = getXmlData();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fragment4Adapter = new Fragment4_Adapter(getContext(), list);
                        recyclerView.setAdapter(fragment4Adapter);
                        fragment4Adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
        return view;
    }
    String getXmlData(){
        String queryUrl="http://api.korea.go.kr/openapi/svc?serviceKey=qJQdGNCT%2F3GLGiFxm%2F4dl38xVUMfclbVD7wUMriztrFn%2BmE9QyhdhHdwd7uitI%2BzNCrMDIzrrBYfh96LMhpkcQ%3D%3D&format=xml&svcId=383000000538";

        try{
            boolean b_locationNo1 = false;
            boolean b_plateNo1 =false;

            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is= url.openStream(); //url위치로 입력스트림 연결
            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();//xml파싱을 위한
            XmlPullParser parser= factory.newPullParser();
            parser.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

            int eventType= parser.getEventType();

            while( eventType != XmlPullParser.END_DOCUMENT ){
                switch( eventType ){
                    case XmlPullParser.START_DOCUMENT:
                        list = new ArrayList<f4_ap_item>();
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if(parser.getName().equals("svc")){
                            benefit_item = new f4_ap_item();
                        }
                        if (parser.getName().equals("svcId")) {
                            b_locationNo1 = true;
                            Log.d("check","확인 : "+b_locationNo1);
                        }
                        if (parser.getName().equals("svcNm")){
                            b_plateNo1 = true;
                        }
                        break;

                    case XmlPullParser.TEXT:
                        if(b_locationNo1){
                            benefit_item.setSvcNm(parser.getText());
                            String abc = parser.getText();
                            Log.d("Bus",abc);
                            b_locationNo1 = false;
                        } else if(b_plateNo1) {
//                            benefit_item.setSvcCts(parser.getText());
                            b_plateNo1 = false;
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("svc") && benefit_item != null) {
                            list.add(benefit_item);
                        }
                        break;
                }
                eventType= parser.next();
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }
}
