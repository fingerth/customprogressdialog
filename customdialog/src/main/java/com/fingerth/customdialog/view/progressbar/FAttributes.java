package com.fingerth.customdialog.view.progressbar;

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

    public FAttributes() {
    }

    public FAttributes(int mTextColor, int mReachedBarColor, int mUnReachedBarColor) {
        //getResources().getColor(R.color.color_333333)
        this.mTextColor = mTextColor;
        this.mReachedBarColor = mReachedBarColor;
        this.mUnReachedBarColor = mUnReachedBarColor;
    }
}
