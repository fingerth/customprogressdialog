package fingerth.com.customprogressdialog;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fingerth.customdialog.ConfirmDialogUtils;
import com.fingerth.customdialog.InputDialogUtils;
import com.fingerth.customdialog.LoadingDiaLogUtils;
import com.fingerth.customdialog.ProgressBarDialogUtils;
import com.fingerth.customdialog.PromptDialogUtils;
import com.fingerth.customdialog.ToastUtils;
import com.fingerth.customdialog.att.LoadingAttributes;
import com.fingerth.customdialog.att.PromptAttributes;
import com.fingerth.customdialog.utils.Utils;
import com.fingerth.customdialog.view.progressbar.FAttributes;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv1:
//                LoadingDiaLogUtils.getInstances().show(this);
//                LoadingDiaLogUtils.getInstances().dismiss();
                /**
                 * method: show();
                 * @param context              context
                 * @param backgroundDimEnabled 背景昏暗启用       默認false（<1>背景透明）
                 * @param att                  屬性 文字、背景    默認（<1>對話框黑色半透明圓角背景;<2>文字顏色0XFFF4F4F4;<3>ProgressBar顏色取自Theme的colorAccent）
                 *
                 *method: setMessage();
                 *@param  msg  msg
                 *
                 **method: setCancelListener(); 點擊返回消失，listener可以null
                 *@param  listener    返回監聽
                 *
                 *method: setCanceledOnTouchOutside();
                 *method: dismiss();
                 *method: dismiss(Activity activity); 注：如果不在UI線程，調用此方法
                 *
                 *LoadingAttributes{
                 *  textColor ； 文字顏色
                 *  bgDraw ； Dialog背景Drawable
                 *}
                 *默認（<1>對話框黑色半透明圓角背景;<2>文字顏色0XFFF4F4F4;<3>ProgressBar顏色取自Theme的colorAccent）
                 *
                 */
                GradientDrawable g1 = new GradientDrawable();//创建drawable
                g1.setShape(GradientDrawable.RECTANGLE);
                g1.setColor(Color.WHITE);
                g1.setCornerRadius(Utils.dp2px(this, 5));//圆角半径
                LoadingAttributes lAtt = new LoadingAttributes(Color.BLACK, g1);
                LoadingDiaLogUtils.getInstances().show(this, true, lAtt).setMessage("加載中..").setCancelListener(null);
                break;
            case R.id.tv2:
                //PromptDialogUtils.getInstances().show(this);
                /**
                 * method: show();
                 * @param context              context
                 * @param type                TYPE_PROMPT（提示，默認） TYPE_SUCCESS(成功)  TYPE_ERROR（失敗）
                 * @param backgroundDimEnabled 背景昏暗启用       默認false（<1>背景透明）
                 *
                 **method: setPromptStr();
                 *@param  promptStr    提示msg
                 *
                 *method: setAttributes();
                 *@param  att  PromptAttributes
                 *
                 *PromptAttributes{
                 *  textColor ； 文字顏色
                 *  iconDraw ； 提示圖片Drawable
                 *  bgDraw ； Dialog背景Drawable
                 *}
                 *默認（<1>對話框黑色半透明圓角背景;<2>文字顏色0XFFF4F4F4;）
                 *
                 */

                GradientDrawable g2 = new GradientDrawable();//创建drawable
                g2.setShape(GradientDrawable.RECTANGLE);
                g2.setColor(Color.BLACK);
                g2.setCornerRadius(Utils.dp2px(this, 5));//圆角半径
                PromptAttributes p = new PromptAttributes(Color.WHITE, getResources().getDrawable(R.drawable.fail), g2);//getResources().getDrawable(R.drawable.fail),
                PromptDialogUtils.getInstances()
                        .show(this, PromptDialogUtils.TYPE_SUCCESS, true)
                        .setAttributes(p)
                        .setPromptStr("Prompt");
                break;
            case R.id.tv3:
                /**
                 * method: show();
                 * @param activity             activity
                 * @param titleStr             title
                 * @param msgStr               msg
                 * @param cancelStr            cancel
                 * @param sureStr              sure
                 * @param att                  ConfirmAttributes 字體顏色
                 * @param callBack             按返回監聽
                 *
                 *
                 *ConfirmAttributes{
                 *  titleColor ；  title文字顏色
                 *  msgColor ；    msg文字顏色
                 *  cancelColor ； cancel文字顏色
                 *  sureColor ；   sure文字顏色
                 *}
                 *
                 */

                ConfirmDialogUtils.getInstances().show(this, "标题", "具体的详细介绍请看文章", "", "", new ConfirmDialogUtils.CallBack() {
                    @Override
                    public void cancel() {
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void sure() {
                        Toast.makeText(MainActivity.this, "sure", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.tv4:
                /**
                 * method: show();
                 * @param activity             activity
                 * @param titleStr             title
                 * @param cancelStr            cancel
                 * @param sureStr              sure
                 * @param att                  InputAttributes 字體顏色
                 * @param callBack             按返回監聽
                 *
                 *
                 *InputAttributes{
                 *  titleColor ；    title文字顏色
                 *  inputColor ；    EditText文字顏色
                 *  cancelColor ；   cancel文字顏色
                 *  sureColorCanClick ；   EditText文字長度大於0，可以點擊 sure文字顏色
                 *  sureColorNoClick ；   EditText文字長度等於0，不可以點擊 sure文字顏色
                 *}
                 *
                 */

                InputDialogUtils.getInstances().show(this, "标题", "", "", new InputDialogUtils.InputCallBack() {
                    @Override
                    public void cancel() {
                        ToastUtils.showToast(MainActivity.this, "cancel");
                    }

                    @Override
                    public void inputComplete(String str) {
                        ToastUtils.showToast(MainActivity.this, str);
                    }
                });
                break;
            case R.id.tv5:
                //1.默認樣式 (<1>背景透明;<2>對話框白色圓角背景;<3>文字顏色0XFFFC00D1;<4>進度條完成顏色0XFFFC00D1;<5>進度條未完成顏色0xFFD3D6DA)
                //ProgressBarDialogUtils.getInstances().show(this);
                /**
                 * method: show();
                 * @param context              context
                 * @param backgroundDimEnabled 背景昏暗启用       默認false（<1>背景透明）
                 * @param att                  屬性 文字、背景    默認（<1>對話框白色圓角背景;<2>文字顏色0XFFFC00D1;<3>進度條完成顏色0XFFFC00D1;<4>進度條未完成顏色0xFFD3D6DA）
                 *
                 *method: setMessage();
                 *@param  msg  標題
                 *
                 **method: setCancelListener(); 點擊返回消失，listener可以null
                 *@param  listener    返回監聽
                 *
                 *method: setProgress();
                 *method: getProgress();
                 *method: setMax();
                 *method: getMax();
                 *method: dismiss();
                 *method: dismiss(Activity activity); 注：如果不在UI線程，調用此方法
                 *
                 *FAttributes{
                 *  mTextColor ； 文字顏色
                 *  mReachedBarColor ； bar已完成顏色
                 *  mUnReachedBarColor ； bar未完成顏色
                 *  bgDraw ； Dialog背景Drawable
                 *}
                 *默認（<1>對話框白色圓角背景;<2>文字顏色0XFFFC00D1;<3>進度條完成顏色0XFFFC00D1;<4>進度條未完成顏色0xFFD3D6DA）
                 *
                 */

                GradientDrawable gd = new GradientDrawable();//创建drawable
                gd.setShape(GradientDrawable.RECTANGLE);
                gd.setColor(Color.WHITE);
                gd.setCornerRadius(Utils.dp2px(this, 5));//圆角半径
                //gd.setStroke(Utils.dp2px(context, 1), colorInt);//边框寬度、颜色
                FAttributes att = new FAttributes(Color.BLACK, Color.BLACK, getResources().getColor(R.color.white_dd), gd);
                ProgressBarDialogUtils.getInstances()
                        .show(this, true, att)
                        .setMessage("正在下載")
                        .setProgress(0);

                AsyncTaskProgress async = new AsyncTaskProgress();
                async.execute("");
                break;
        }
    }

    private class AsyncTaskProgress extends AsyncTask<String, Integer, Object> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(String... params) {
            for (int i = 0; i < 100; i++) {
                SystemClock.sleep(50);
                publishProgress(i + 1);
            }
            return params;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //horizontal_bar.setProgress(values[0] % 100);
            ProgressBarDialogUtils.getInstances().setProgress(values[0] % 100);
            if (values[0] == 100) {
                ProgressBarDialogUtils.getInstances().dismiss();
                ToastUtils.showToast(MainActivity.this, "完成！");
            }
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }
    }

}
