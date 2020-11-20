package com.example.swc_project;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

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
    FloatingActionButton FAB_newPost_edit;
    EditText petitionTitle;
    EditText petitionBody;
    private Spinner sp_category;
    EditText tag1, tag2, tag3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_petition);
        mMyData = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FAB_newPost_edit = (FloatingActionButton)findViewById(R.id.petitionPost);
        petitionBody = (EditText)findViewById(R.id.petitionTitle);
        petitionTitle = (EditText)findViewById(R.id.petitionTitle);
        sp_category = (Spinner)findViewById(R.id.spn_category);
        tag1 = (EditText)findViewById(R.id.petition_tag1);
        tag2 = (EditText)findViewById(R.id.petition_tag2);
        tag3 = (EditText)findViewById(R.id.petition_tag3);
        final String[] text_category = new String[1];
        sp_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text_category[0] = sp_category.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        FAB_newPost_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String title = petitionTitle.getText().toString();
                final String body = petitionBody.getText().toString();
                final String text_tag1 = tag1.getText().toString();
                final String text_tag2 = tag2.getText().toString();
                final String text_tag3 = tag3.getText().toString();

                Intent in = new Intent(petition_newPost.this, petition_warning.class);
                in.putExtra("title",title);
                in.putExtra("body",body);
                in.putExtra("category",text_category[0]);
                in.putExtra("tag1",text_tag1);
                in.putExtra("tag2",text_tag2);
                in.putExtra("tag3",text_tag3);
                startActivity(in);
//                submitPost(title,body);
//                finish();

            }
        });
    }
    /*private void submitPost(String title1, String body1){

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
    */
}
