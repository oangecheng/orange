package com.ustc.orange.orange.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ustc.orange.orange.R;
import com.ustc.orange.orange.app.BaseActivity;
import com.ustc.orange.orange.utils.FileUtil;
import com.ustc.orange.orange.utils.SPUtil;

public class WelcomeActivity extends BaseActivity {

  private static Handler mHandler = new Handler();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (SPUtil.isFirstStart(this)) {
      FileUtil.initFileSystem();
    } else {
      SPUtil.setFirstStart(this, false);
    }

    mHandler.postDelayed(new Runnable() {
      @Override
      public void run() {
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
      }
    }, 1000);
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_welcome;
  }

  @Override
  protected void initTopBar(Context context) { }
}
