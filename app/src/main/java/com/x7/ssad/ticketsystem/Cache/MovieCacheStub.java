package com.x7.ssad.ticketsystem.Cache;

import android.util.Log;

import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by WangYinghao on 5/26/17.
 */

//TODO: implement a real movie cache system
public class MovieCacheStub {

    List<Movie> movie_list;

    public MovieCacheStub() {

        movie_list = new ArrayList<>();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        try {

            //Filling Movies
            Movie A = new Movie();
            A.mid = 1;
            A.name = "加勒比海盗5：死无对证";
            A.onair = true;
            A.one_sentence = "亡灵要复仇，船长要发愁";
            A.audience_rating = 9.0f;
            A.imageid = R.mipmap.poster1;
            A.nWantSee = 0;
            A.premiereDate = ft.parse("2017-05-03");

            Movie B = new Movie();
            B.mid = 2;
            B.name = "荡寇风云";
            B.onair = false;
            B.one_sentence = "战神戚继光，海战谁更强";
            B.audience_rating = -1f;
            B.imageid = R.mipmap.poster2;
            B.nWantSee = 5246;
            B.premiereDate = ft.parse("2017-09-09");

            Movie C = new Movie();
            C.mid = 3;
            C.name = "摔跤吧！爸爸";
            C.onair = true;
            C.one_sentence = "为圆摔跤梦，女儿不心疼";
            C.audience_rating = 9.8f;
            C.imageid = R.mipmap.poster3;
            C.nWantSee = 123432;
            C.premiereDate = ft.parse("2017-05-03");

            Movie D = new Movie();
            D.mid = 4;
            D.name = "\"吃吃\"的爱";
            D.onair = true;
            D.one_sentence = "康永脑洞开，群星浪起来";
            D.audience_rating = -1f;
            D.imageid = R.mipmap.poster4;
            D.nWantSee = 2341;
            D.premiereDate = ft.parse("2017-05-03");

            Movie E = new Movie();
            E.mid = 5;
            E.name = "神奇女侠";
            E.onair = false;
            E.one_sentence = "神力女超人，救世又圈粉";
            E.audience_rating = -1f;
            E.imageid = R.mipmap.poster5;
            E.nWantSee = 91835;
            E.premiereDate = ft.parse("2017-09-09");

            Movie F = new Movie();
            F.mid = 6;
            F.name = "银河护卫队2";
            F.onair = true;
            F.one_sentence = "星爵身世谜，终于见爹地";
            F.audience_rating = 9.1f;
            F.imageid = R.mipmap.poster6;
            F.nWantSee = 229858;
            F.premiereDate = ft.parse("2010-05-03");

            movie_list.add(A);
            movie_list.add(B);
            movie_list.add(C);
            movie_list.add(D);
            movie_list.add(E);
            movie_list.add(F);

        }
        catch (ParseException e) {
            Log.d("MovieCache", "Parse Error");
        }


    }

    public Movie getMovie(int mid) {
        return movie_list.get(mid);
    }

    public List<Movie> getMovieList() {
        return movie_list;
    }
}
