package com.example.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class petition_post {
    public String uid;
    //    public String author;
    public String title;
    public String body;
    public String key;
    public int starCount = 0;
    public String category;
    public String tag1;
    public String tag2;
    public String tag3;

    public Map<String, Boolean> stars = new HashMap<>();

    public petition_post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public petition_post(String uid, String title, String body, String key,String category, String tag1, String tag2, String tag3 ) {
        this.uid = uid;
//        this.author = author;
        this.title = title;
        this.body = body;
        this.key = key;
        this.category = category;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
    }

    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
//        result.put("author", author);
        result.put("title", title);
        result.put("body", body);
        result.put("key", key);
        result.put("starCount", starCount);
        result.put("stars", stars);
        result.put("category", category);
        result.put("tag1", tag1);
        result.put("tag2", tag2);
        result.put("tag3", tag3);

        return result;
    }

    // [END post_to_map]
}
