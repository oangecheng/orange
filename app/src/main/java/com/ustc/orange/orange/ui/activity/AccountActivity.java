package com.ustc.orange.orange.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ustc.orange.orange.R;
import com.ustc.orange.orange.app.BaseActivity;
import com.ustc.orange.orange.enity.AccountInfo;
import com.ustc.orange.orange.others.OnTopBarClickAdapter;
import com.ustc.orange.orange.ui.adapter.AccountAdapter;
import com.ustc.orange.orange.ui.widget.OrangeTopBar;
import com.ustc.orange.orange.utils.AccountManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;

public class AccountActivity extends BaseActivity {

  @BindView(R.id.account_top_bar)
  OrangeTopBar mTopBar;
  @BindView(R.id.account_recycler_view)
  RecyclerView mRecyclerView;

  private AccountManager mAccountManager;
  private List<AccountInfo> mList = new ArrayList<>();
  private AccountAdapter mAccountAdapter;
  private Handler mHandler = new Handler();
  private ExecutorService executor = Executors.newFixedThreadPool(3);


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    initData();
    getTestData();
    initView();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_account;
  }

  @Override
  protected void initTopBar(Context context) {
    mTopBar.setMiddle(getResString(R.string.account_title))
        .setLeft(getResString(R.string.back))
        .setRight(getResDrawable(R.drawable.icon_account_add))
        .setClickAdapter(new OnTopBarClickAdapter() {
          @Override
          public void onLeftClick() {
            Toast.makeText(context, "我是左边", Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onRightClick() {
            finish();
          }
        });
  }

  private void initData() {
    mAccountManager = new AccountManager();
    executor.submit(() -> {
      mList = mAccountManager.getAllDataFromImage();
      mAccountAdapter.setData(mList);
      mHandler.post(() -> mAccountAdapter.notifyDataSetChanged());
    });
  }


  private void initView(){
    GridLayoutManager manager = new GridLayoutManager(this, 1);
    mRecyclerView.setLayoutManager(manager);
    mAccountAdapter = new AccountAdapter(this);
    mAccountAdapter.setData(mList);
    mRecyclerView.setAdapter(mAccountAdapter);
  }

  private void getTestData() {
    mList.add(new AccountInfo().setWebsite("百度").setUsername("281725011@qq.com").setPassword("orange").setTime(System.currentTimeMillis()));
    mList.add(new AccountInfo().setWebsite("谷歌").setUsername("orange910617@gmail.com").setPassword("orange"));
    mList.add(new AccountInfo().setWebsite("QQ").setUsername("281725011").setPassword("orange"));
    mList.add(new AccountInfo().setWebsite("微信").setUsername("cheng2859427").setPassword("orange"));
    mList.add(new AccountInfo().setWebsite("华为").setUsername("18297934996").setPassword("orange"));
  }
}
