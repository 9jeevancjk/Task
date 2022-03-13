package com.cjk.task;

public class FeedsNote {
    String date;
    String s;

    public FeedsNote(String s, String date) {
        this.date = date;
        this.s = s;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public FeedsNote(String date){
        this.date = date;
    }
}
