package com.fingerth.customdialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.fingerth.customdialog.utils.Utils;
import com.fingerth.customdialog.view.FCustomDialog;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2016/10/28.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public final class LoadingDiaLogUtils {
    private static LoadingDiaLogUtils instances;

    private LoadingDiaLogUtils() {
    }

    public static LoadingDiaLogUtils getInstances() {
        if (instances == null) {
            synchronized (LoadingDiaLogUtils.class) {
                if (instances == null) {
                    instances = new LoadingDiaLogUtils();
                }
            }
        }
        return instances;
    }

    private String loading = "加载中";
    private FCustomDialog fDialog;


    public LoadingDiaLogUtils showProgress(Context context) {
        return showProgress(context, null);
    }

    public LoadingDiaLogUtils showProgress(Context context, Integer theme) {
        if (context == null || (context instanceof Activity && ((Activity) context).isFinishing())) {
            return instances;
        }
        if (context instanceof Activity) {
            Utils.closeKeyboardHidden((Activity) context);
        }
        if (fDialog == null || context != fDialog.getContext()) {
            if (theme != null) {
                fDialog = new FCustomDialog(context, theme);
            } else {
                fDialog = new FCustomDialog(context);
            }
        }
        if (!fDialog.isShowing()) {
            try {
                fDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        fDialog.setLoadingStr(loading);
        fDialog.setCanceledOnTouchOutside(false);
        return instances;
    }

    public LoadingDiaLogUtils setMessage(String message) {
        if (fDialog != null) {
            fDialog.setLoadingStr(message);
        }
        return instances;
    }

    public LoadingDiaLogUtils setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        if (fDialog != null) {
            fDialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
        }
        return instances;
    }

    public LoadingDiaLogUtils setCancelListener(DialogInterface.OnCancelListener listener) {
        if (fDialog != null) {
            fDialog.setCancelable(true);
            if (listener != null) {
                fDialog.setOnCancelListener(listener);
            }
        }
        return instances;
    }

    public void dismissProgress(Activity activity) {
        if (Utils.isMainThread()) {
            dismissProgress();
        } else {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dismissProgress();
                }
            });
        }
    }

    public void dismissProgress() {
        if (fDialog != null) {
            fDialog.dismiss();
        }
    }


//    private static void showCustomizeLoadingProgressDialog(Context context, boolean canceledOnTouchOutside) {
//        ProgressDialog mCustomizeLoadingProgressDialog = new ProgressDialog(context, ProgressDialog.THEME_HOLO_LIGHT);
//        mCustomizeLoadingProgressDialog.setMessage(LanguageDaoUtils.getStrByFlag(context,AppConstants.loading));
//        mCustomizeLoadingProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        mCustomizeLoadingProgressDialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
//        mCustomizeLoadingProgressDialog.setCancelable(true);
//        mCustomizeLoadingProgressDialog.show();
//        Point size = new Point();
//        mCustomizeLoadingProgressDialog.getWindow().getWindowManager().getDefaultDisplay().getSize(size);
//        //记得用mProgressDialog来得到这个界面的大小，实际上不加就是得到当前监听器匿名类对象的界面宽度</span>
//
//        int width = size.x;//获取界面的宽度像素
//        int height = size.y;
//        WindowManager.LayoutParams params = mCustomizeLoadingProgressDialog.getWindow().getAttributes(); //一定要用mProgressDialog得到当前界面的参数对象，否则就不是设置ProgressDialog的界面了
//        params.alpha = 1.0f;//设置进度条背景透明度
//        params.height = height / 9;//设置进度条的高度
//        params.gravity = Gravity.BOTTOM;//设置ProgressDialog的重心
//        params.width = 2 * width / 3;//设置进度条的宽度
//        params.dimAmount = 0f;//设置半透明背景的灰度，范围0~1，系统默认值是0.5，1表示背景完全是黑色的,0表示背景不变暗，和原来的灰度一样
//        mCustomizeLoadingProgressDialog.getWindow().setAttributes(params);//把参数设置给进度条，注意，一定要先show出来才可以再设置，不然就没效果了，因为只有当界面显示出来后才可以获得它的屏幕尺寸及参数等一些信息
//    }
}
