package com.example.swc_project;

public class petition_Item {
    private String uid;
    private String body;
    private String title;
    private String key;
    public String category;
    public String tag1;
    public String tag2;
    public String tag3;
    private int starCount;

    public petition_Item(String uid,String body,String title,String key,String category,String tag1,String tag2,String tag3,int starCount){
        this.uid = uid;
        this.body = body;
        this.title = title;
        this.key = key;
        this.category = category;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
    }
    public petition_Item(){

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }
}
