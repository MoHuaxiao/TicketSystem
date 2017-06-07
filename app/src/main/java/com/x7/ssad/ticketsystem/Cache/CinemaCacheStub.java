package com.x7.ssad.ticketsystem.Cache;

import com.x7.ssad.ticketsystem.Model.Cinema;

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

        //Cinema Two
        Cinema B = new Cinema();
        B.cid = 2;
        B.cName = "JinYi Cinema";
        B.ShowingMovie = new long[] {2, 3, 5, 6};
        B.ShowingCnt = new long[] {4, 3, 2 ,5};

        //Cinema Three
        Cinema C = new Cinema();
        C.cid = 3;
        C.cName = "Wanda Cinema";
        C.ShowingMovie = new long[] {1, 2, 3};
        C.ShowingCnt = new long[] {4, 6, 2};

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
