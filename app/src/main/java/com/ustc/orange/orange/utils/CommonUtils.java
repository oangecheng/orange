package com.ustc.orange.orange.utils;

import android.support.annotation.Nullable;

public class CommonUtils {

  public static boolean isEmpty(@Nullable CharSequence str) {
    return str == null || str.length() == 0;
  }
}
