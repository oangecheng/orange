package com.ustc.orange.orange.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ustc.orange.orange.R;
import com.ustc.orange.orange.app.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
  @BindView(R.id.account_iv)
  ImageView mAccountImageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);
    mAccountImageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, AccountActivity.class));
      }
    });

  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override
  protected void initTopBar(Context context) {

  }
}
