package com.x7.ssad.ticketsystem.Model;

/**
 * Created by John on 2017/6/1.
 */

public class BoxOffice {
    public int boxOfficeRank = -1;
    public int boxOfficeFirstWeek = -1;
    public int boxOfficeTotal = -1;

    public BoxOffice(int _boxOfficeRank, int _boxOfficeFirstWeek, int _boxOfficeTotal) {
        boxOfficeRank = _boxOfficeRank;
        boxOfficeFirstWeek = _boxOfficeFirstWeek;
        boxOfficeTotal = _boxOfficeTotal;
    }
}
