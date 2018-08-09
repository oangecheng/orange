package com.ustc.orange.orange.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {

  public static final String KEY_APP = "orange_app";
  public static final String KEY_USER = "orange_user";

  public static void setFirstStart(Context context, boolean isFirstStart){
    SharedPreferences sp = context.getSharedPreferences(KEY_APP, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sp.edit();
    editor.putBoolean("app_first_start", isFirstStart);
    editor.apply();
  }

  public static boolean isFirstStart(Context context){
    SharedPreferences sp = context.getSharedPreferences(KEY_APP, Context.MODE_PRIVATE);
    return sp.getBoolean("app_first_start", true);
  }
}
