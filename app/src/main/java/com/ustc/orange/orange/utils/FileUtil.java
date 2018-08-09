package com.ustc.orange.orange.utils;

import android.os.Environment;

import java.io.File;

public class FileUtil {

  public static final String ACCOUNT_IMAGE_NAME = "account.jpg";
  public static final String ORANGE_BASE_DIR = "orange";
  public static final String ORANGE_ACCOUNT_DIR = "account";

  public static String getBasePath() {
    return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ORANGE_BASE_DIR;
  }

  public static String getAccountPath() {
    return getBasePath() + File.separator + ORANGE_ACCOUNT_DIR;
  }

  public static void initFileSystem() {
    File accountDir = new File(getAccountPath());
    if (!accountDir.exists()) {
      accountDir.mkdirs();
    }
  }
}
