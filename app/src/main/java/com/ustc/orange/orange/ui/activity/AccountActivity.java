package com.ustc.orange.orange.ui.activity;

import android.os.Bundle;

import com.ustc.orange.orange.R;
import com.ustc.orange.orange.app.BaseActivity;
import com.ustc.orange.orange.ui.widget.OrangeTopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountActivity extends BaseActivity {

  @BindView(R.id.orange_top_bar) OrangeTopBar mTopBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_account);
    ButterKnife.bind(this);

  }
}
