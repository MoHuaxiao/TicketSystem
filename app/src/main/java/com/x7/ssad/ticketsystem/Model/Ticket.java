package com.x7.ssad.ticketsystem.Model;

/**
 * Created by Administrator on 2017/06/04.
 */

public class Ticket {
    public String startTime;
    public String endTime;
    public String type;
    public int price;
    public Ticket(String startTime, String endTime, String type, int price) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.price = price;
    }
}
