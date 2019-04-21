package com.example.playstorecopycat.datas;

public class app {

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
    private boolean isMine;

    //
    public app(int rank, String title, String companyName, double userRating, int price, boolean isMine) {
        this.rank = rank;
        this.title = title;
        this.companyName = companyName;
        this.userRating = userRating;
        this.price = price;
        this.isMine = isMine;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMine(boolean mine) {
        isMine = mine;
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
