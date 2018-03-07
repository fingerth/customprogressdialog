package fingerth.com.customprogressdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fingerth.customdialog.ConfirmDialogUtils;
import com.fingerth.customdialog.InputDialogUtils;
import com.fingerth.customdialog.LoadingDiaLogUtils;
import com.fingerth.customdialog.PromptDialogUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                LoadingDiaLogUtils.getInstances().showProgress(MainActivity.this).setCancelListener(null);
                break;
            case R.id.tv2:
                LoadingDiaLogUtils.getInstances().showProgress(MainActivity.this).setMessage("e library for Android. It encapsulates the functions commonly used in Android development which have complete demo and unit test. Using its encapsulated APIs can greatly improve development efficiency. It mainly consists of two modules. One is the main module, utilcode, which includes the utils commonly used in development. The other is subutil which contains the utils is not very common, which is beneficial to simplify the").setCancelListener(null);
                break;
            case R.id.tv3:
                LoadingDiaLogUtils.getInstances().showProgress(MainActivity.this).setCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        Toast.makeText(MainActivity.this, "xxx", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.tv4:
                PromptDialogUtils.getInstances().showError(this);
                break;
            case R.id.tv5:
                InputDialogUtils.getInstances().showInput(this, "标题", "", "", new InputDialogUtils.InputCallBack() {
                    @Override
                    public void cancel() {
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void inputComplete(String str) {
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.tv6:
                ConfirmDialogUtils.getInstances().showConfirm(this, "标题", "具体的详细介绍请看文章", "", "", new ConfirmDialogUtils.CallBack() {
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
        }
    }

}
