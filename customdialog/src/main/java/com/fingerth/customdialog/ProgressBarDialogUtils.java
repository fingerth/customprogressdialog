package com.fingerth.customdialog;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.fingerth.customdialog.utils.Utils;
import com.fingerth.customdialog.view.FProgressBarCustomDialog;
import com.fingerth.customdialog.view.progressbar.FAttributes;

/**
 * ======================================================
 * Created by Administrator acg_fingerth on 2018/3/9.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public final class ProgressBarDialogUtils {
    private static ProgressBarDialogUtils instances;

    private ProgressBarDialogUtils() {
    }

    public static ProgressBarDialogUtils getInstances() {
        if (instances == null) {
            synchronized (ProgressBarDialogUtils.class) {
                if (instances == null) {
                    instances = new ProgressBarDialogUtils();
                }
            }
        }
        return instances;
    }

    private FProgressBarCustomDialog fDialog;

    public ProgressBarDialogUtils show(Context context) {
        return show(context, null);
    }

    public ProgressBarDialogUtils show(Context context, Integer theme) {
        return show(context, theme, null);
    }

    public ProgressBarDialogUtils show(Context context, Integer theme, FAttributes att) {
        if (context == null || (context instanceof Activity && ((Activity) context).isFinishing())) {
            return instances;
        }
        if (context instanceof Activity) {
            Utils.closeKeyboardHidden((Activity) context);
        }
        if (fDialog == null || context != fDialog.getContext()) {
            if (theme != null) {
                fDialog = new FProgressBarCustomDialog(context, theme);
            } else {
                fDialog = new FProgressBarCustomDialog(context);
            }
        }
        if (!fDialog.isShowing()) {
            try {
                fDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        fDialog.setCanceledOnTouchOutside(false);
        if (att != null) {
            fDialog.setFAttributes(att);
        }
        return instances;
    }

    public ProgressBarDialogUtils setMessage(String msg) {
        if (fDialog != null) {
            fDialog.setMessage(msg);
        }
        return instances;
    }

    public ProgressBarDialogUtils setProgress(int progress) {
        if (fDialog != null) {
            fDialog.setRoundBarProgress(progress);
        }
        return instances;
    }

    public ProgressBarDialogUtils setMax(int max) {
        if (fDialog != null) {
            fDialog.setRoundBarMax(max);
        }
        return instances;
    }

    public int getProgress() {
        if (fDialog != null) {
            return fDialog.getProgress();
        }
        return 0;
    }

    public int getMax() {
        if (fDialog != null) {
            return fDialog.getMax();
        }
        return 0;
    }

    public void dismiss(Activity activity) {
        if (Utils.isMainThread()) {
            dismiss();
        } else {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dismiss();
                }
            });
        }
    }

    public void dismiss() {
        if (fDialog != null) {
            fDialog.dismiss();
        }
    }

}
