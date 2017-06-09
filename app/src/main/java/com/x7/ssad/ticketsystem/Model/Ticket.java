package com.x7.ssad.ticketsystem.Model;

/**
 * Created by Administrator on 2017/06/04.
 */

public class Ticket {
    public int mid;  // 每张电影票对应的电影id
    public String startTime;
    public String endTime;
    public String type;
    public int price;
    public Ticket(int mid, String startTime, String endTime, String type, int price) {
        this.mid = mid;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.price = price;
    }
}
