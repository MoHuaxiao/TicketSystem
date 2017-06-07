package com.x7.ssad.ticketsystem.Model;

/**
 * Created by WangYinghao on 5/26/17.
 */

public class Cinema {

    public long cid;
    public String cName;
    public long[] ShowingMovie;
    public long[] ShowingCnt;

    // 电影院数据
    public String cPosition;
    public int cLowestPrice;
    public Cinema() {
    }
    public Cinema(String name, String position, int price) {
        this.cName = name;
        this.cPosition = position;
        this.cLowestPrice = price;
    }
}
