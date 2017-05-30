package com.x7.ssad.ticketsystem.Model;
import android.graphics.Bitmap;

/**
 * Created by Mo Haoran on 2017/5/28.
 */

public class MovieComment {
    public Bitmap headphoto = null;
    public String mname = null;
    public String mcontent = null;
    public String mdate = null;

    public MovieComment (Bitmap _headphoto, String _mname, String _mcontent, String _mdate) {
        headphoto = _headphoto;
        mname = _mname;
        mcontent = _mcontent;
        mdate = _mdate;
    }
}
