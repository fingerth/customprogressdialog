package com.fingerth.customdialog.att;

import android.graphics.drawable.Drawable;

/**
 * ======================================================
 * Created by Administrator acg_fingerth on 2018/3/9.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public class PromptAttributes {
    public int textColor = 0XFFF4F4F4;
    private Drawable iconDraw;
    private Drawable bgDraw;


    public PromptAttributes() {
    }

    public PromptAttributes(int textColor, Drawable bgDraw) {
        this.textColor = textColor;
        this.bgDraw = bgDraw;
    }

    public PromptAttributes(int textColor, Drawable iconDraw, Drawable bgDraw) {
        this.textColor = textColor;
        this.iconDraw = iconDraw;
        this.bgDraw = bgDraw;
    }

    public Drawable getIconDraw() {
        return iconDraw;
    }

    public void setIconDraw(Drawable iconDraw) {
        this.iconDraw = iconDraw;
    }

    public Drawable getBgDraw() {
        return bgDraw;
    }

    public void setBgDraw(Drawable bgDraw) {
        this.bgDraw = bgDraw;
    }


}
