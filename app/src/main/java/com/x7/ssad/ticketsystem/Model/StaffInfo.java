package com.x7.ssad.ticketsystem.Model;

import android.graphics.Bitmap;

/**
 * Created by Mo Haoran on 2017/5/28.
 */

public class StaffInfo {
    public int sphotoId = -1;
    public String sname = null;
    public String sduty = null;

    public StaffInfo (int _sphotoId, String _sname, String _sduty) {
        sphotoId = _sphotoId;
        sname = _sname;
        sduty = _sduty;
    }
}
