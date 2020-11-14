package com.example.swc_project;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.model.Post;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class petition_newPost extends BaseActivity {
    private static final String TAG = "petition_newPost";
    private ArrayList<RecyItem> mMyData;
    private DatabaseReference mDatabase;
    FloatingActionButton fab_check;
    EditText petitionTitle;
    EditText petitionBody;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_petition);
        mMyData = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        fab_check = (FloatingActionButton)findViewById(R.id.petitionPost);
        petitionBody = (EditText)findViewById(R.id.petitionTitle);
        petitionTitle = (EditText)findViewById(R.id.petitionTitle);

        fab_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String title = petitionTitle.getText().toString();
                final String body = petitionTitle.getText().toString();
                submitPost(title,body);
                finish();
            }
        });
    }
    private void submitPost(String title1, String body1){

        final String title = title1;
        final String body = body1;
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
                        writeNewPost(userId, title, body);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });


    }
    private void writeNewPost(String userId, String title, String body) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        String key = mDatabase.child("posts").push().getKey();
        Post post = new Post(userId, title, body, key);
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/petition/" + key, postValues);
        childUpdates.put("/user-posts/" + userId + "/petition/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }

}
