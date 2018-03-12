# customprogressdialog
a custom dialog。

> Android自定义Dialog

 - 使用方法
 - Step 1. Add the JitPack repository to your build file
 - Add it in your root build.gradle at the end of repositories:
```
allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```
 - Step 2. Add the dependency
```
dependencies {
            compile 'com.github.fingerth:customprogressdialog:1.1.0'
    }
```
### 1.加載框

> 使用方法

- show：LoadingDiaLogUtils.getInstances().show(this);
- dismiss：LoadingDiaLogUtils.getInstances().dismiss();

> 方法

```
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

```
> 代碼示例


```
    GradientDrawable g1 = new GradientDrawable();//创建drawable
    g1.setShape(GradientDrawable.RECTANGLE);
    g1.setColor(Color.WHITE);
    g1.setCornerRadius(Utils.dp2px(this, 5));//圆角半径
    LoadingAttributes lAtt = new LoadingAttributes(Color.BLACK, g1);
    LoadingDiaLogUtils.getInstances().show(this, true, lAtt).setMessage("加載中..").setCancelListener(null);
```
> 效果图

![loading](https://github.com/fingerth/customprogressdialog/blob/master/pic/loading.png)

### 2.提示框
> 使用方法

- show：PromptDialogUtils.getInstances().show(this);

> 方法

```
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
```
> 代碼示例

```
    GradientDrawable g2 = new GradientDrawable();//创建drawable
    g2.setShape(GradientDrawable.RECTANGLE);
    g2.setColor(Color.BLACK);
    g2.setCornerRadius(Utils.dp2px(this, 5));//圆角半径
    PromptAttributes p = new PromptAttributes(Color.WHITE, getResources().getDrawable(R.drawable.fail), g2);
    PromptDialogUtils.getInstances()
            .show(this, PromptDialogUtils.TYPE_SUCCESS, true)
            .setAttributes(p)
            .setPromptStr("Prompt");
```
> 效果图

![prompt](https://github.com/fingerth/customprogressdialog/blob/master/pic/prompt.png)

### 3.确认框
> 方法

```
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
```

> 代碼示例

```
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
```
> 效果图

![Comfirm](https://github.com/fingerth/customprogressdialog/blob/master/pic/confirm.png)

### 4.输入框
> 方法

```
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
```

> 代碼示例

```
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
```
> 效果图

![Input](https://github.com/fingerth/customprogressdialog/blob/master/pic/input.png)

### 5.进度条

> 使用方法

- show：ProgressBarDialogUtils.getInstances().show(this);
- dismiss：ProgressBarDialogUtils.getInstances().dismiss();

> 方法

```
    /**
     * method: show();
     * @param context              context
     * @param backgroundDimEnabled 背景昏暗启用       默認false（<1>背景透明）
     * @param att                  屬性 文字、背景    默認（<1>對話框白色圓角背景;<2>文字顏色0XFFFC00D1;<3>進度條完成顏色0XFFFC00D1;<4>進度條未完成顏色0xFFD3D6DA）
     *
     *method: setMessage();
     *@param  msg  標題
     *
     *method: setCancelListener(); 點擊返回消失，listener可以null
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
```
> 代碼示例

```
    public void show(){
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
    }
    
    AsyncTaskProgress async = new AsyncTaskProgress();
    async.execute("");
                
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
```
> 效果图

![ProgressBar](https://github.com/fingerth/customprogressdialog/blob/master/pic/progressbar.png)

### END

