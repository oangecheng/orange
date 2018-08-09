package com.ustc.orange.orange.utils;

import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.hddata.stegoutil.Algorithm.Interface.IStegoUtil;
import com.hddata.stegoutil.Algorithm.StegoUtil;
import com.hddata.stegoutil.Common.StegoConstant;

public class StegoManager {

  public static void insert(){
    String base = Environment.getExternalStorageDirectory().getAbsolutePath();
    String name = "test.jpg";
    IStegoUtil stegoUtil = StegoUtil.getInstance();
    long handler = stegoUtil.createHandler();
    int state = stegoUtil.embed(handler, StegoConstant.ALGORITHM_JPEG_LARGE, "orange", base+"/"+name, base+"/stego.jpg","orange",1);
    Gson gson = new Gson();


  }

  public static void extract(){
    String base = Environment.getExternalStorageDirectory().getAbsolutePath();
    String name = "test.jpg";
    IStegoUtil stegoUtil = StegoUtil.getInstance();
    long handler = stegoUtil.createHandler();
    String msg = stegoUtil.extract(handler,StegoConstant.ALGORITHM_JPEG_LARGE, base+"/stego.jpg", "orange");
    Log.d("orange_tag", msg);
  }
}
