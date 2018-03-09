package com.fingerth.customdialog.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fingerth.customdialog.R;
import com.fingerth.customdialog.view.progressbar.FAttributes;
import com.fingerth.customdialog.view.progressbar.round.RoundWidthNumberProgressBar;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2017/12/11.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public class FProgressBarCustomDialog extends ProgressDialog {

    private LinearLayout progressLayout;
    private RoundWidthNumberProgressBar roundBar;
    private TextView messageTv;

//    private String success = "成功";
//    private String fail = "失败";
//    private String prompt = "提示";

    public FProgressBarCustomDialog(Context context) {
        super(context, R.style.FingerthCustomDialog);

    }

    public FProgressBarCustomDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setContentView(R.layout.fingerth_progress_bar_custom_dialog_view);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);

        progressLayout = findViewById(R.id.dialog_progress_layout);
        roundBar = findViewById(R.id.round_bar);
        messageTv = findViewById(R.id.message_tv);


    }

    @Override
    public void show() {
        super.show();
    }

    public void setMessage(String msg) {
        messageTv.setText(msg);
    }

    public void setRoundBarProgress(int progress) {
        roundBar.setProgress(progress);
    }

    public int getRoundBarProgress() {
        return roundBar.getProgress();
    }

    public void setRoundBarMax(int max) {
        roundBar.setMax(max);
    }

    public int getRoundBarMax() {
        return roundBar.getMax();
    }

    public void setFAttributes(FAttributes att) {
        if (att != null) {
            roundBar.setFAttributes(att);
        }
    }

}
