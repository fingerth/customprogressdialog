package com.fingerth.customdialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.fingerth.customdialog.att.ConfirmAttributes;
import com.fingerth.customdialog.utils.Utils;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2018/1/8.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public final class ConfirmDialogUtils {
    private static ConfirmDialogUtils instances;
    private AlertDialog dialogConfirm;

    private ConfirmDialogUtils() {
    }

    public static ConfirmDialogUtils getInstances() {
        if (instances == null) {
            synchronized (ConfirmDialogUtils.class) {
                if (instances == null) {
                    instances = new ConfirmDialogUtils();
                }
            }
        }
        return instances;
    }

    public void show(Activity activity, String titleStr, String msgStr, String cancelStr, String sureStr) {
        show(activity, titleStr, msgStr, cancelStr, sureStr, null, null);
    }

    public void show(Activity activity, String titleStr, String msgStr, String cancelStr, String sureStr, CallBack callBack) {
        show(activity, titleStr, msgStr, cancelStr, sureStr, null, callBack);
    }

    public void show(final Activity activity, String titleStr, String msgStr, String cancelStr, String sureStr, ConfirmAttributes att, final CallBack callBack) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View dialogView = View.inflate(activity, R.layout.dialog_confirm_view, null);
        TextView message = dialogView.findViewById(R.id.message);
        TextView title = dialogView.findViewById(R.id.title);
        TextView cancel = dialogView.findViewById(R.id.cancel);
        TextView sure = dialogView.findViewById(R.id.sure);
        if (TextUtils.isEmpty(titleStr)) {
            title.setVisibility(View.GONE);
        } else {
            title.setVisibility(View.VISIBLE);
            title.setText(titleStr);
        }
        if (TextUtils.isEmpty(cancelStr)) {
            String defaultCancelStr = "取消";
            cancel.setText(defaultCancelStr);
        } else {
            cancel.setText(cancelStr);
        }
        if (TextUtils.isEmpty(sureStr)) {
            String defaultConfirmStr = "确定";
            sure.setText(defaultConfirmStr);
        } else {
            sure.setText(sureStr);
        }

        message.setText(msgStr);

        if (att != null) {
            title.setTextColor(att.titleColor);
            message.setTextColor(att.msgColor);
            cancel.setTextColor(att.cancelColor);
            sure.setTextColor(att.sureColor);
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialogConfirm != null) {
                    dialogConfirm.dismiss();
                }
                if (callBack != null) {
                    callBack.cancel();
                }

            }
        });
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialogConfirm != null) {
                    dialogConfirm.dismiss();
                }
                if (callBack != null) {
                    callBack.sure();
                }
            }
        });

        builder.setView(dialogView);
        dialogConfirm = builder.create();
        dialogConfirm.setCanceledOnTouchOutside(false);
        dialogConfirm.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                if (callBack != null) {
                    callBack.cancel();
                }
            }
        });
        dialogConfirm.show();

        WindowManager.LayoutParams params = dialogConfirm.getWindow().getAttributes();
        int w1 = Utils.dp2px(activity, 400);
        int w2 = Utils.getSysWidth(activity) * 9 / 10;
        params.width = w1 > w2 ? w2 : w1;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogConfirm.getWindow().setAttributes(params);
    }


    public interface CallBack {
        void cancel();

        void sure();
    }
}
