package com.x7.ssad.ticketsystem.Model;

import android.graphics.Bitmap;

/**
 * Created by Mo Haoran on 2017/5/28.
 */

public class StaffInfo {
    public Bitmap sphoto = null;
    public String sname = null;
    public String sduty = null;

    public StaffInfo (Bitmap _sphoto, String _sname, String _sduty) {
        sphoto = _sphoto;
        sname = _sname;
        sduty = _sduty;
    }
}
