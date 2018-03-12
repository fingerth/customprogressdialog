package com.fingerth.customdialog.att;

import android.graphics.drawable.Drawable;

/**
 * ======================================================
 * Created by Administrator acg_fingerth on 2018/3/9.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public class LoadingAttributes {
    public int textColor = 0XFFF4F4F4;
    private Drawable bgDraw;

    public LoadingAttributes() {
    }

    public LoadingAttributes(int textColor,  Drawable bgDraw) {
        this.textColor = textColor;
        this.bgDraw = bgDraw;
    }



    public Drawable getBgDraw() {
        return bgDraw;
    }

    public void setBgDraw(Drawable bgDraw) {
        this.bgDraw = bgDraw;
    }


}
