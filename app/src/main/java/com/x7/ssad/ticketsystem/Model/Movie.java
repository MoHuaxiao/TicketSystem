package com.x7.ssad.ticketsystem.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by WangYinghao on 5/26/17.
 */

public class Movie {

    public int mid;
    public int douid;                 //豆瓣电影id
    public String name;
    public String nameEng;
    public float audience_rating;     //观众评分
    public int audience_num;          //评分人数
    public String movieType;
    public String movieSourceDest;    //电影制作地
    public int movieLength;           //按分钟算
    public int nWantSee;
    public String oneSentence;
    public String movieIntro;

    public int imageid;
    public String smallImageURI;
    public String mediumImageURI;
    public String largeImageURI;

    public List<StaffInfo> staffList;  //主创人员列表
    public int[] movieshotIdList;      //电影剪影列表

    public BoxOffice boxOffice;        //票房

    public List<MovieComment> commentList;    //评论列表

    public boolean onair;

    public Date premiereDate;

}
