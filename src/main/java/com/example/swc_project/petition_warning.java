package com.example.swc_project;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.model.Post;
import com.example.model.petition_post;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class petition_warning extends BaseActivity {
    private static final String TAG = "petition_warning";
    private DatabaseReference mDatabase;
    String text_tag1,text_tag2,text_tag3,text_catagory,text_title,text_body;
    FloatingActionButton fab_petition;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petition_warning);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        fab_petition = (FloatingActionButton)findViewById(R.id.petition_edit_finish);

        this.text_tag1 = getIntent().getStringExtra("tag1");
        this.text_tag2 = getIntent().getStringExtra("tag2");
        this.text_tag3 = getIntent().getStringExtra("tag3");
        this.text_catagory = getIntent().getStringExtra("category");
        this.text_title = getIntent().getStringExtra("title");
        this.text_body = getIntent().getStringExtra("body");

        fab_petition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitPost(text_title,text_body,text_catagory,text_tag1,text_tag2,text_tag3);
                finish();
            }
        });


    }
    private void submitPost(String title1, String body1, String catagory1, final String tag1, String tag2 , String tag3){

        final String title = title1;
        final String body = body1;
        final String catagory = catagory1;
        final String Tag1 = tag1;
        final String Tag2 = tag2;
        final String Tag3 = tag3;

        if(TextUtils.isEmpty(title)){
            Log.d(TAG,"title empty");
            return ;
        }
        if(TextUtils.isEmpty(body)){
            Log.d(TAG,"body empty");
            return ;
        }
        final String userId = getUid();
        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        writeNewPost(userId, title, body,catagory,Tag1,Tag2,Tag3);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });


    }
    private void writeNewPost(String userId, String title, String body,String catagory, String tag1, String tag2, String tag3) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        String key = mDatabase.child("posts").push().getKey();
        petition_post post = new petition_post(userId, title, body, key, catagory, tag1, tag2, tag3);
        Map<String, Object> postValues = post.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/petition/" + key, postValues);
        childUpdates.put("/user-posts/" + userId + "/petition/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }

}
