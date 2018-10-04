package com.artitech.tsalano.tukisha;

/**
 * Created by solly on 2017/08/20.
 */


public class RewardProduct {


    private static final String CHINESE = "GBK";
    private static String balance, agentid;
    TukishaApplication tukishaApplication;
    private final String name;
    private final String points;
    private final int imageResource;



    public RewardProduct(String name, String points, int imageResource) {




        this.name = name;
        this.points = points;
        this.imageResource = imageResource;

    }

    public String getName() {
        return name;
    }

    public String getPoints() {
        return points;
    }

    public int getImageResource() {
        return imageResource;
    }




}