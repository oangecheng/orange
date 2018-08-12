package com.ustc.orange.orange.utils;

import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CommonUtils {

  public static boolean isEmpty(@Nullable CharSequence str) {
    return str == null || str.length() == 0;
  }

  public static String formatTime(long date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd     HH:mm", Locale.US);
    return dateFormat.format(new Date(date));
  }
}
