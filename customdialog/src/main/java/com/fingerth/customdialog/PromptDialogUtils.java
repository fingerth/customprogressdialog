package com.fingerth.customdialog;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import com.fingerth.customdialog.utils.Utils;
import com.fingerth.customdialog.view.FCustomDialog;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2016/10/28.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public final class PromptDialogUtils {
    private static PromptDialogUtils instances;

    private PromptDialogUtils() {
    }

    public static PromptDialogUtils getInstances() {
        if (instances == null) {
            synchronized (PromptDialogUtils.class) {
                if (instances == null) {
                    instances = new PromptDialogUtils();
                }
            }
        }
        return instances;
    }

    private FCustomDialog tip;


    private void showProgress(Context context) {
        if (context == null || (context instanceof Activity && ((Activity) context).isFinishing())) {
            return ;
        }
        if (context instanceof Activity) {
            Utils.closeKeyboardHidden((Activity) context);
        }
        if (tip == null || context != tip.getContext()) {
            tip = new FCustomDialog(context);
        }
        if (!tip.isShowing()) {
            try {
                tip.show();
                //2.5秒后
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (tip != null) {
                            tip.dismiss();
                        }
                    }
                }, 2500);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        tip.setCanceledOnTouchOutside(false);
        tip.setCancelable(true);
    }


    public PromptDialogUtils showSuccess(Context context) {
        showProgress(context);
        if (tip != null) {
            tip.setSuccess();
        }
        return instances;
    }

    public PromptDialogUtils showError(Context context) {
        showProgress(context);
        if (tip != null) {
            tip.setError();
        }
        return instances;
    }

    public PromptDialogUtils showInfo(Context context) {
        showProgress(context);
        if (tip != null) {
            tip.setInfo();
        }
        return instances;
    }

    public void setPromptStr(String tipStr) {
        if (tip != null) {
            tip.setPromptStr(tipStr);
        }
    }

}
