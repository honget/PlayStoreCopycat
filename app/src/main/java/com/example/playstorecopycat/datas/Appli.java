package com.example.playstorecopycat.datas;

public class Appli {


    //순위
    private int rank;

    //제목
    private String title;
    //w제조사
    private String companyName;

    //랭크
    private double userRating;

    //구매 가격
    private int price;

    //구매 여부
    private boolean isMine = false;


    public Appli(int rank, String title, String companyName, double userRating, int price, boolean isMine) {
        this.rank = rank;
        this.title = title;
        this.companyName = companyName;
        this.userRating = userRating;
        this.price = price;
        this.isMine = isMine;
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getUserRating() {
        return userRating;
    }

    public int getPrice() {
        return price;
    }

    public boolean isMine() {
        return isMine;
    }
}
