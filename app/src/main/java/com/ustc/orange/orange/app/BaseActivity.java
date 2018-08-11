package com.ustc.orange.orange.app;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ustc.orange.orange.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends Activity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    ButterKnife.bind(this);

    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    getWindow().setStatusBarColor(getResources().getColor(R.color.base));

    initTopBar(this);
  }

  protected String getResString(int stringId) {
    return getResources().getString(stringId);
  }

  protected Drawable getResDrawable(int drawableId) {
    return getResources().getDrawable(drawableId);
  }

  protected abstract int getLayoutId();

  protected abstract void initTopBar(Context context);
}
