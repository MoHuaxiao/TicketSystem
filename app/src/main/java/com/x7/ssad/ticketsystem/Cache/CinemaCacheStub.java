package com.x7.ssad.ticketsystem.Cache;

import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.Model.Ticket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * Created by WangYinghao on 5/26/17.
 */

//TODO: Connect With Backend Com
public class CinemaCacheStub {

    List<Cinema> cinemaList;

    public CinemaCacheStub() {

        cinemaList = new ArrayList<>();

        //Cinema One
        Cinema A = new Cinema();
        A.cid = 1;
        A.cName = "DaDi Cinema";
        A.ShowingMovie = new long[] {1, 2, 3, 4, 5};
        A.ShowingCnt = new long[] {6, 3, 5, 6, 2};
        A.cScore = 8;
        A.cPosition = "小谷围 中山大道";

        List<Ticket> ticketList1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ticketList1.add(new Ticket(1, "17:05", "20:30", "原版3D", 30));
            ticketList1.add(new Ticket(2, "17:05", "20:30", "原版3D", 31));
            ticketList1.add(new Ticket(3, "17:05", "20:30", "原版3D", 32));
            ticketList1.add(new Ticket(4, "17:05", "20:30", "原版3D", 33));
            ticketList1.add(new Ticket(5, "17:05", "20:30", "原版3D", 34));
        }
        A.cTicketList = ticketList1;


        //Cinema Two
        Cinema B = new Cinema();
        B.cid = 2;
        B.cName = "JinYi Cinema";
        B.ShowingMovie = new long[] {2, 3, 5, 6};
        B.ShowingCnt = new long[] {4, 3, 2 ,5};
        B.cScore = 2;
        B.cPosition = "广州塔 旁边的街道";

        List<Ticket> ticketList2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ticketList2.add(new Ticket(2, "17:05", "20:30", "原版3D", 41));
            ticketList2.add(new Ticket(3, "17:05", "20:30", "原版3D", 42));
            ticketList2.add(new Ticket(5, "17:05", "20:30", "原版3D", 44));
            ticketList2.add(new Ticket(6, "17:05", "20:30", "原版3D", 45));
        }
        B.cTicketList = ticketList2;

        //Cinema Three
        Cinema C = new Cinema();
        C.cid = 3;
        C.cName = "Wanda Cinema";
        C.ShowingMovie = new long[] {1, 2, 3};
        C.ShowingCnt = new long[] {4, 6, 2};
        C.cPosition = "番禺区 万胜围";
        C.cScore = 9;

        List<Ticket> ticketList3 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ticketList3.add(new Ticket(1, "17:05", "20:30", "原版3D", 50));
            ticketList3.add(new Ticket(2, "17:05", "20:30", "原版3D", 51));
            ticketList3.add(new Ticket(3, "17:05", "20:30", "原版3D", 52));
        }
        C.cTicketList = ticketList3;


        cinemaList.add(A);
        cinemaList.add(B);
        cinemaList.add(C);
    }
    public void addCinema(Cinema c) {
        cinemaList.add(c);
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public List<Long> getShowingCinemas(int mid) {
        List<Long> showingCinemas = new ArrayList<>();
        for (Cinema c:cinemaList) {
            for (int i = 0; i < c.ShowingMovie.length; i++) {
                if (mid == c.ShowingMovie[i]) {
                    showingCinemas.add(c.cid);
                }
            }
        }

        return showingCinemas;
    }

    public int getShowCount(List<Long> showingCinemas, int mid) {
        int count = 0;
        for (int i = 0; i < showingCinemas.size(); i++) {

            int id = new BigDecimal(showingCinemas.get(i)).intValueExact();
            Cinema c = cinemaList.get(id);
            for (int j = 0; j < c.ShowingMovie.length; j++) {
                count += c.ShowingCnt[j];
            }
        }
        return count;
    }

    public int getShowCount(int mid) {
        int count = 0;
        for (Cinema c:cinemaList
             ) {
            for (int i = 0 ; i < c.ShowingMovie.length; i++) {
                if (mid == c.ShowingMovie[i]) {
                    count += c.ShowingCnt[i];
                }
            }
        }
        return count;
    }

    public Cinema getCinemaByID(Long cid) {
        for (int i = 0; i < cinemaList.size(); i++) {
            if (cinemaList.get(i).cid == cid) {
                return cinemaList.get(i);
            }
        }
        return null;
    }

}
