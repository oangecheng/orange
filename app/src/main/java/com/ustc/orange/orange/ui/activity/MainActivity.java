package com.ustc.orange.orange.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ustc.orange.orange.R;
import com.ustc.orange.orange.app.BaseActivity;
import com.ustc.orange.orange.ui.widget.OrangeTopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
  @BindView(R.id.account_iv) ImageView mAccountImageView;
  @BindView(R.id.orange_top_bar) OrangeTopBar mTopBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    mAccountImageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, AccountActivity.class));
      }
    });

    mTopBar.setClicklistener(new OrangeTopBar.TopBarClickListener() {
      @Override
      public void leftClick() {
        startActivity(new Intent(MainActivity.this, AccountActivity.class));
      }

      @Override
      public void rightClick() {

      }
    });
    }

}
