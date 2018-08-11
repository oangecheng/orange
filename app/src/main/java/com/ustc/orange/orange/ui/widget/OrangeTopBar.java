package com.ustc.orange.orange.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ustc.orange.orange.R;
import com.ustc.orange.orange.others.OnTopBarClickAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrangeTopBar extends RelativeLayout {

  @BindView(R.id.top_bar_left_iv)
  ImageView btnLeft;
  @BindView(R.id.top_bar_left_tv)
  TextView tvLeft;
  @BindView(R.id.top_bar_middle_tv)
  TextView tvMiddle;
  @BindView(R.id.top_bar_right_iv)
  ImageView btnRight;
  @BindView(R.id.top_bar_right_tv)
  TextView tvRight;

  private OnTopBarClickAdapter mClickAdapter = new OnTopBarClickAdapter() {};

  public OrangeTopBar(Context context) {
    super(context);
  }

  public OrangeTopBar(Context context, AttributeSet attrs) {
    super(context, attrs);
    View root = View.inflate(context, R.layout.layout_top_bar, this);
    ButterKnife.bind(this, root);
  }

  public OrangeTopBar setMiddle(String title) {
    tvMiddle.setText(title);
    tvMiddle.setOnClickListener(view -> mClickAdapter.onMiddleClick());
    return this;
  }

  public OrangeTopBar setLeft(String left) {
    tvLeft.setText(left);
    tvLeft.setVisibility(VISIBLE);
    tvLeft.setOnClickListener(view -> mClickAdapter.onLeftClick());
    return this;
  }

  public OrangeTopBar setLeft(Drawable drawable) {
    btnLeft.setImageDrawable(drawable);
    btnLeft.setVisibility(VISIBLE);
    btnLeft.setOnClickListener(view -> mClickAdapter.onLeftClick());
    return this;
  }

  public OrangeTopBar setRight(String right) {
    tvRight.setText(right);
    tvRight.setVisibility(VISIBLE);
    tvRight.setOnClickListener(view -> mClickAdapter.onRightClick());
    return this;
  }

  public OrangeTopBar setRight(Drawable drawable) {
    btnRight.setImageDrawable(drawable);
    btnRight.setVisibility(VISIBLE);
    btnRight.setOnClickListener(view -> mClickAdapter.onRightClick());
    return this;
  }

  public OrangeTopBar setClickAdapter(OnTopBarClickAdapter clickAdapter) {
    this.mClickAdapter = clickAdapter;
    return this;
  }

  public interface OnTopBarClickListener {

    void onLeftClick();

    void onMiddleClick();

    void onRightClick();
  }


}
