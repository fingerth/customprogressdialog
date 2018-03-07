package com.fingerth.customdialog.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public final class Utils {


    public static final String TAG = "Utils";

    private static int sysWidth = 0;
    private static int sysHeight = 0;


    /**
     * 获取手机的分比率，高和宽
     */
    public static void getScreen(Activity activity) {
        if (Utils.sysWidth <= 0 || Utils.sysHeight <= 0) {
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            Utils.sysWidth = dm.widthPixels;
            Utils.sysHeight = dm.heightPixels;
        }
    }

    public static int getSysWidth(Activity activity) {
        if (Utils.sysWidth <= 0) {
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            Utils.sysWidth = dm.widthPixels;
        }
        return Utils.sysWidth;
    }

    public static int getSysHeight(Activity activity) {
        if (Utils.sysHeight <= 0) {
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            Utils.sysHeight = dm.heightPixels;
        }
        return Utils.sysHeight;
    }

    public static int getStatusBarHeight(Context c) {
        int result = 0;
        int resourceId = c.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = c.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());

    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /**
     * 隐藏软键盘
     **/
    public static void closeKeyboardHidden(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view == null) view = new View(activity);
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * 关闭输入软键盘  然而没有什么卵用  TODO
     */
    public static void closeSoftInput(Activity activity, EditText editText) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (editText != null) {
            if (imm != null) {
                try {
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            View view = activity.getWindow().peekDecorView();
            if (view != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }

    }
}
