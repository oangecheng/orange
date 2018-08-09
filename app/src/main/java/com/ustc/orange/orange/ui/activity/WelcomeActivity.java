package com.ustc.orange.orange.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ustc.orange.orange.R;
import com.ustc.orange.orange.app.BaseActivity;
import com.ustc.orange.orange.utils.FileUtil;
import com.ustc.orange.orange.utils.SPUtil;

public class WelcomeActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);
    FileUtil.initFileSystem();
  }
}
