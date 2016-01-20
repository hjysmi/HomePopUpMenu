package com.dkhs.homepopupmenu;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by xuetong on 2016/1/20.
 */
public class ViewUtils {
    public static int getScreenWidthPixels(Context paramContext) {
        int screenWidthPixels;
        DisplayMetrics dm = new DisplayMetrics();
        dm = paramContext.getResources().getDisplayMetrics();
        screenWidthPixels = dm.widthPixels;
        return screenWidthPixels;
    }
}
