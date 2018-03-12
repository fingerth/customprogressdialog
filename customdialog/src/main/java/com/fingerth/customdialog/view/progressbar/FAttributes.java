package com.fingerth.customdialog.view.progressbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import com.fingerth.customdialog.utils.Utils;

/**
 * ======================================================
 * Created by Administrator acg_fingerth on 2018/3/9.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public class FAttributes {
    public int mTextColor = 0XFFFC00D1;
    public int mReachedBarColor = 0XFFFC00D1;
    public int mUnReachedBarColor = 0xFFd3d6da;


    private Drawable bgDraw;

    public FAttributes() {
    }

    public FAttributes(int mTextColor, int mReachedBarColor, int mUnReachedBarColor, Drawable bgDraw) {
        //getResources().getColor(R.color.color_333333)
        this.mTextColor = mTextColor;
        this.mReachedBarColor = mReachedBarColor;
        this.mUnReachedBarColor = mUnReachedBarColor;
        this.bgDraw = bgDraw;
    }


    public Drawable getBgDraw() {
        return bgDraw;
    }

    public void setBgDraw(Drawable bgDraw) {
        this.bgDraw = bgDraw;
    }


    private GradientDrawable getDefaultBackground(Context context) {
        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setColor(Color.WHITE);
        gd.setCornerRadius(Utils.dp2px(context, 2));//圆角半径
        //gd.setStroke(Utils.dp2px(context, 1), colorInt);//边框寬度、颜色
        return gd;

    }
}
