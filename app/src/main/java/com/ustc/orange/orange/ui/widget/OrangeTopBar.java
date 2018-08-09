package com.ustc.orange.orange.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ustc.orange.orange.R;

public class OrangeTopBar extends RelativeLayout {
  private Button leftButton, rightButton;
  private TextView tvTitle;


  private int leftTextColor;
  private Drawable leftDrawable;
  private String leftText;

  private float titleTextSize;
  private int titleTextColor;
  private String title;

  private int rightTextColor;
  private Drawable rightDrawable;
  private String rightText;

  private LayoutParams leftLayoutParams, titleLayoutParams, rightLayoutParams;

  private TopBarClickListener clicklistenter;


  public OrangeTopBar(Context context) {
    super(context);
  }

  public OrangeTopBar(Context context, AttributeSet attrs) {
    super(context, attrs);
    TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.orangeTopBar);

    leftTextColor = ta.getColor(R.styleable.orangeTopBar_leftTextColor, 0);
    leftDrawable = ta.getDrawable(R.styleable.orangeTopBar_leftBackGround);
    leftText = ta.getString(R.styleable.orangeTopBar_leftText);

    titleTextSize = ta.getDimension(R.styleable.orangeTopBar_titleTextSize, 0);
    titleTextColor = ta.getColor(R.styleable.orangeTopBar_titleTextColor, 0);
    title = ta.getString(R.styleable.orangeTopBar_title);

    rightTextColor = ta.getColor(R.styleable.orangeTopBar_rightTextColor, 0);
    rightDrawable = ta.getDrawable(R.styleable.orangeTopBar_rightBackGround);
    rightText = ta.getString(R.styleable.orangeTopBar_rightText);

    ta.recycle();

    //组件定义
    leftButton = new Button(context);
    tvTitle = new TextView(context);
    rightButton = new Button(context);

    // 将自定义的属性设置到控件上
    leftButton.setTextColor(leftTextColor);
    leftButton.setBackground(leftDrawable);
    leftButton.setText(leftText);

    tvTitle.setTextColor(titleTextColor);
    tvTitle.setTextSize(titleTextSize);
    tvTitle.setText(title);
    tvTitle.setGravity(Gravity.CENTER);    // 设置文字居中

    rightButton.setTextColor(rightTextColor);
    rightButton.setBackground(rightDrawable);
    rightButton.setText(rightText);

    setBackgroundColor(0xFF1296DB);    // 设置背景颜色

    //将自定义的控件放到Layout中（以LayoutParams的形式）
    leftLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);     //设置左对齐
    addView(leftButton, leftLayoutParams);  //leftButton以leftLayoutParams的形式加入到ViewGroup中

    titleLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    titleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);  //设置居中对齐
    addView(tvTitle, titleLayoutParams);    //tvTitle以titleLayoutParams的形式加入到ViewGroup中

    rightLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    rightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE); //设置右对齐
    addView(rightButton, rightLayoutParams);//rightButton以rightLayoutParams的形式加入到ViewGroup中

    //设置监听事件
    leftButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        clicklistenter.leftClick();
      }
    });

    rightButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        clicklistenter.rightClick();
      }
    });

  }

  //设置左Button是否显示
  public void setLeftVisiblity(boolean flag) {
    if (flag) {
      leftButton.setVisibility(View.VISIBLE);
    } else {
      leftButton.setVisibility(View.GONE);
    }
  }

  // 设置右Button是否显示
  public void setRightVisiblity(boolean flag) {
    if (flag) {
      rightButton.setVisibility(View.VISIBLE);
    } else {
      rightButton.setVisibility(View.GONE);
    }
  }

  public void setClicklistener(TopBarClickListener clicklistenter) {
    this.clicklistenter = clicklistenter;
  }

  public interface TopBarClickListener {

    void leftClick();

    void rightClick();
  }
}
