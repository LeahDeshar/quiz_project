package com.example.quizapplication;

public class historydatamodel {
    private String subject;
    private int points;
    private String date;

    public historydatamodel(String subject, int points, String date) {
        this.subject = subject;
        this.points = points;
        this.date = date;
    }

    public  String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public historydatamodel(){

    }

}
