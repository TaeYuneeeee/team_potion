package com.example.swc_project;

public class carteItem {
    String menu1;
    String menu2;
    String menu3;
    String menu4;
    String menu5;
    String menu;

    public carteItem(){
        // Default constructor required for calls to DataSnapshot.getValue(FirebasePost.class)
    }
    public carteItem(String menu1, String menu2, String menu3, String menu4, String menu5, String menu) {
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;
        this.menu4 = menu4;
        this.menu5 = menu5;
        this.menu = menu;
    }

    public String getMenu1() {
        return menu1;
    }

    public void setMenu1(String menu1) {
        this.menu1 = menu1;
    }

    public String getMenu2() {
        return menu2;
    }

    public void setMenu2(String menu2) {
        this.menu2 = menu2;
    }

    public String getMenu3() {
        return menu3;
    }

    public void setMenu3(String menu3) {
        this.menu3 = menu3;
    }

    public String getMenu4() {
        return menu4;
    }

    public void setMenu4(String menu4) {
        this.menu4 = menu4;
    }

    public String getMenu5() {
        return menu5;
    }

    public void setMenu5(String menu5) {
        this.menu5 = menu5;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

}
