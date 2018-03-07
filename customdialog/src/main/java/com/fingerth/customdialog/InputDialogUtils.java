package com.fingerth.customdialog;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.fingerth.customdialog.utils.Utils;

/**
 * ======================================================
 * Created by Administrator acg_fingerth on 2018/3/6.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public final class InputDialogUtils {
    private static InputDialogUtils instances;

    private InputDialogUtils() {
    }

    public static InputDialogUtils getInstances() {
        if (instances == null) {
            synchronized (InputDialogUtils.class) {
                if (instances == null) {
                    instances = new InputDialogUtils();
                }
            }
        }
        return instances;
    }

    private AlertDialog dialogConfirm;

    private String defaultCancelStr = "取消";
    private String defaultConfirmStr = "确定";

    /**
     * 輸入框：1.自定義貨幣顯示Str
     *
     * @param activity
     */
    public void showInput(final Activity activity, String titleStr, String cancelStr, String sureStr, final InputCallBack callBack) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        View dialogView = View.inflate(activity, R.layout.dialog_input_view, null);
        final EditText input_et = dialogView.findViewById(R.id.input_et);
        TextView title = dialogView.findViewById(R.id.title);
        TextView cancel = dialogView.findViewById(R.id.cancel);
        final TextView sure = dialogView.findViewById(R.id.sure);

        if (TextUtils.isEmpty(titleStr)) {
            title.setVisibility(View.GONE);
        } else {
            title.setVisibility(View.VISIBLE);
            title.setText(titleStr);
        }
        if (TextUtils.isEmpty(cancelStr)) {
            cancel.setText(defaultCancelStr);
        } else {
            cancel.setText(cancelStr);
        }
        if (TextUtils.isEmpty(sureStr)) {
            sure.setText(defaultConfirmStr);
        } else {
            sure.setText(sureStr);
        }

        if (input_et.getText().length() > 0) {
            sure.setTextColor(activity.getResources().getColor(R.color.text_color1));
        } else {
            sure.setTextColor(activity.getResources().getColor(R.color.white_dd));
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialogConfirm != null) {
                    Utils.closeSoftInput(activity, input_et);
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
                if (dialogConfirm == null || input_et.getText().length() < 1) return;
                Utils.closeSoftInput(activity, input_et);
                dialogConfirm.dismiss();

                if (callBack != null) {
                    callBack.inputComplete(input_et.getText().toString());
                }
            }
        });
        input_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    sure.setTextColor(activity.getResources().getColor(R.color.text_color1));
                } else {
                    sure.setTextColor(activity.getResources().getColor(R.color.white_dd));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        builder.setView(dialogView);
        dialogConfirm = builder.create();
        dialogConfirm.setCanceledOnTouchOutside(false);
        dialogConfirm.show();
    }

    public interface InputCallBack {
        void cancel();

        void inputComplete(String str);
    }
}
