package com.ustc.orange.orange.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ustc.orange.orange.R;
import com.ustc.orange.orange.enity.AccountInfo;
import com.ustc.orange.orange.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {

  private Context mContext;
  private List<AccountInfo> mData;

  public AccountAdapter(Context mContext) {
    this.mContext = mContext;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_account, viewGroup, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
    holder.website.setText(mData.get(i).website);
    holder.username.setText("账号:  " + mData.get(i).username);
    holder.password.setText("密码:  " + mData.get(i).password);
    holder.time.setText("更新:  " + CommonUtils.formatTime(mData.get(i).time));
    if (mData.get(i).type == 0) {
      holder.image.setImageDrawable(mContext.getDrawable(R.drawable.account_icon));
    }
  }

  public void setData(List<AccountInfo> data) {
    this.mData = data;
  }

  @Override
  public int getItemCount() {
    return mData.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.account_image)
    ImageView image;
    @BindView(R.id.account_website)
    TextView website;
    @BindView(R.id.account_username)
    TextView username;
    @BindView(R.id.account_pwd)
    TextView password;
    @BindView(R.id.account_time)
    TextView time;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
