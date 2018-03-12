package com.fingerth.customdialog;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.IntDef;

import com.fingerth.customdialog.att.LoadingAttributes;
import com.fingerth.customdialog.att.PromptAttributes;
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

    @IntDef({TYPE_SUCCESS, TYPE_ERROR, TYPE_PROMPT})
    public @interface PromptType {

    }

    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_ERROR = 1;
    public static final int TYPE_PROMPT = 2;

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

    private void showProgress(Context context, boolean backgroundDimEnabled) {
        if (context == null || (context instanceof Activity && ((Activity) context).isFinishing())) {
            return;
        }
        if (context instanceof Activity) {
            Utils.closeKeyboardHidden((Activity) context);
        }
        if (tip == null || context != tip.getContext()) {
            if (backgroundDimEnabled) {
                tip = new FCustomDialog(context, R.style.FTransDialog);
            } else {
                tip = new FCustomDialog(context);
            }
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
                }, 2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        tip.setCanceledOnTouchOutside(false);
        tip.setCancelable(false);
    }

    public PromptDialogUtils show(Context context) {
        show(context, PromptDialogUtils.TYPE_PROMPT, false);
        return instances;
    }

    public PromptDialogUtils show(Context context, @PromptType int type, boolean backgroundDimEnabled) {
        showProgress(context, backgroundDimEnabled);
        if (tip != null) {
            switch (type) {
                case TYPE_SUCCESS:
                    tip.setSuccess();
                    break;
                case TYPE_ERROR:
                    tip.setError();
                    break;
                case TYPE_PROMPT:
                    tip.setInfo();
                    break;
            }
        }
        return instances;
    }

    public PromptDialogUtils setAttributes(PromptAttributes att) {
        if (att != null) {
            tip.setFAttributes(att);
        }
        return instances;
    }

    public void setPromptStr(String promptStr) {
        if (tip != null) {
            tip.setPromptStr(promptStr);
        }
    }


}
