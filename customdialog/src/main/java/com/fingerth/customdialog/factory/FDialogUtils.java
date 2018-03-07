package com.fingerth.customdialog.factory;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.fingerth.customdialog.LoadingDiaLogUtils;

/**
 * ======================================================
 * Created by Administrator acg_fingerth on 2018/3/7.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public class FDialogUtils {

    private static FDialogUtils instances;

    private FDialogUtils() {
    }

    public static FDialogUtils getInstances() {
        if (instances == null) {
            synchronized (FDialogUtils.class) {
                if (instances == null) {
                    instances = new FDialogUtils();
                }
            }
        }
        return instances;
    }


}
