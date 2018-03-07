package com.fingerth.customdialog;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.fingerth.customdialog.utils.Utils;

/**
 * Created by dongping-yuan on 16/7/13.
 */
public final class ToastUtils {
    public static Toast mToast;

    public static void showToast(final Context context, final String msg) {

        if (Utils.isMainThread()) {
            doToast(context, msg);
        } else {
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        doToast(context, msg);
                    }
                });
            }
        }
    }

    private static void doToast(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }


}
