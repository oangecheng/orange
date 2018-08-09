package com.ustc.orange.orange.app;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ustc.orange.orange.R;
import com.ustc.orange.orange.ui.widget.OrangeTopBar;

public class BaseActivity extends Activity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    getWindow().setStatusBarColor(getResources().getColor(R.color.colorTheme));
  }
}
