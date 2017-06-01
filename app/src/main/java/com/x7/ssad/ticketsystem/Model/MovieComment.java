package com.x7.ssad.ticketsystem.Model;
import android.graphics.Bitmap;

/**
 * Created by Mo Haoran on 2017/5/28.
 */

public class MovieComment {
    public int headphotoId = -1;
    public String mname = null;
    public String mcontent = null;
    public String mdate = null;

    public MovieComment (int _headphotoId, String _mname, String _mcontent, String _mdate) {
        headphotoId = _headphotoId;
        mname = _mname;
        mcontent = _mcontent;
        mdate = _mdate;
    }
}
