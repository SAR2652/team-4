package com.example.jay.jeevika;

public class Fish {
    private String sellerNameText;
    private String sellerNumberText;
    private String sellerPriceText;

    public Fish(String sellerNameText, String sellerNumberText, String sellerPriceText, String sellerStarRatingText, String sellerDistanceText) {
        this.sellerNameText = sellerNameText;
        this.sellerNumberText = sellerNumberText;
        this.sellerPriceText = sellerPriceText;
        this.sellerStarRatingText = sellerStarRatingText;
        this.sellerDistanceText = sellerDistanceText;
    }

    private String sellerStarRatingText;
    private String sellerDistanceText;


    public String getSellerNameText() {
        return sellerNameText;
    }

    public void setSellerNameText(String sellerNameText) {
        this.sellerNameText = sellerNameText;
    }

    public String getSellerNumberText() {
        return sellerNumberText;
    }

    public void setSellerNumberText(String sellerNumberText) {
        this.sellerNumberText = sellerNumberText;
    }

    public String getSellerPriceText() {
        return sellerPriceText;
    }

    public void setSellerPriceText(String sellerPriceText) {
        this.sellerPriceText = sellerPriceText;
    }

    public String getSellerStarRatingText() {
        return sellerStarRatingText;
    }

    public void setSellerStarRatingText(String sellerStarRatingText) {
        this.sellerStarRatingText = sellerStarRatingText;
    }

    public String getSellerDistanceText() {
        return sellerDistanceText;
    }

    public void setSellerDistanceText(String sellerDistanceText) {
        this.sellerDistanceText = sellerDistanceText;
    }




}
