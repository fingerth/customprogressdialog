package com.fingerth.customdialog.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fingerth.customdialog.R;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2017/12/11.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public class FCustomDialog extends ProgressDialog {

    private TextView loading_tv;
    private ImageView icon;
    private ProgressBar bar;

    private String success = "成功";
    private String fail = "失败";
    private String prompt = "提示";

    public FCustomDialog(Context context) {
        super(context, R.style.FingerthCustomDialog);

    }

    public FCustomDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        //设置不可取消，点击其他区域不能取消，实际中可以抽出去封装供外包设置
//        setCancelable(false);
//        setCanceledOnTouchOutside(false);
        setContentView(R.layout.fingerth_custom_dialog_view);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
        loading_tv = findViewById(R.id.tv_load_dialog);

        bar = findViewById(R.id.pb_load);
        icon = findViewById(R.id.icon);

    }

    @Override
    public void show() {
        super.show();
    }

    public void setLoadingStr(String loadingStr) {
        bar.setVisibility(View.VISIBLE);
        icon.setVisibility(View.GONE);
        loading_tv.setText(loadingStr);
    }

    public void setSuccess() {
        icon.setVisibility(View.VISIBLE);
        bar.setVisibility(View.GONE);

        icon.setImageResource(R.drawable.success);
        loading_tv.setText(success);
    }

    public void setError() {
        icon.setVisibility(View.VISIBLE);
        bar.setVisibility(View.GONE);
        icon.setImageResource(R.drawable.fail);
        loading_tv.setText(fail);
    }

    public void setInfo() {
        icon.setVisibility(View.VISIBLE);
        bar.setVisibility(View.GONE);
        icon.setImageResource(R.drawable.info);
        loading_tv.setText(prompt);
    }

    public void setPromptStr(String promptStr) {
        loading_tv.setText(promptStr);
    }
}
