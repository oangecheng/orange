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
import com.ustc.orange.orange.utils.StegoManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AccountActivity extends BaseActivity {

  @BindView(R.id.account_top_bar)
  OrangeTopBar mTopBar;
  @BindView(R.id.account_recycler_view)
  RecyclerView mRecyclerView;

  private StegoManager mStegoManager;
  private List<AccountInfo> mList = new ArrayList<>();
  private AccountAdapter mAccountAdapter;
  private Handler mHandler = new Handler();
  private ExecutorService executor = Executors.newFixedThreadPool(3);


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initData();

    GridLayoutManager manager = new GridLayoutManager(this, 2);
    mRecyclerView.setLayoutManager(manager);
    mAccountAdapter = new AccountAdapter(this);
    mAccountAdapter.setData(mList);
    mRecyclerView.setAdapter(mAccountAdapter);
  }

  private void initData() {
    mStegoManager = new StegoManager();
    executor.submit(() -> {
      mList = mStegoManager.getAllDataFromImage();
      mAccountAdapter.setData(mList);
      mHandler.post(() -> mAccountAdapter.notifyDataSetChanged());
    });
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
            Toast.makeText(context, "我是右边", Toast.LENGTH_SHORT).show();
          }
        });
  }

  private void getTestData() {
    mList.add(new AccountInfo().setWebsite("百度").setUsername("281725011@qq.com").setPassword("orange"));
    mList.add(new AccountInfo().setWebsite("谷歌").setUsername("orange910617@gmail.com").setPassword("orange"));
    mList.add(new AccountInfo().setWebsite("QQ").setUsername("281725011").setPassword("orange"));
    mList.add(new AccountInfo().setWebsite("微信").setUsername("cheng2859427").setPassword("orange"));
    mList.add(new AccountInfo().setWebsite("华为").setUsername("18297934996").setPassword("orange"));
  }
}
