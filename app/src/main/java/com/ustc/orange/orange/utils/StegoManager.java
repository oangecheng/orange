package com.ustc.orange.orange.utils;

import android.os.Environment;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.hddata.stegoutil.Algorithm.Interface.IStegoUtil;
import com.hddata.stegoutil.Algorithm.StegoUtil;
import com.hddata.stegoutil.Common.StegoConstant;
import com.ustc.orange.orange.enity.AccountInfo;

import java.io.File;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class StegoManager {

  public static final String AES_KEY = "73B1CEB582F4FE6E";

  private static final String STEGO_KEY = "orange";
  private static final String algorithm = "AES";
  private static final String IV_STRING = "^@01HkG_+1%01!]l";
  private static final String mode = "AES/CBC/PKCS5Padding";
  private static final int offset = 16;
  private static final String TAG = StegoManager.class.getSimpleName();

  private JsonManager<AccountInfo> mJsonManager;
  private String mPath;

  public StegoManager() {
    mJsonManager = new JsonManager<>();
    mPath = FileUtil.getAccountPath() + File.separator + FileUtil.ACCOUNT_IMAGE_NAME;
  }

  public int insert(AccountInfo account) {
    List<AccountInfo> accountList = getAllDataFromImage();
    accountList.add(account);
    String msg = mJsonManager.listToJson(accountList);
    int status = embed(msg, mPath, mPath, STEGO_KEY);
    Log.d(TAG, status + "");
    return embed(msg, mPath, mPath, STEGO_KEY);
  }

  public List<AccountInfo> getAllDataFromImage() {
    String msg = extract(mPath, STEGO_KEY);
    return mJsonManager.jsonToList(msg, AccountInfo.class);
  }

  public void delete(int accountId) {
    IStegoUtil stegoUtil = StegoUtil.getInstance();
    long handler = stegoUtil.createHandler();
  }

  public int clear(){
    int status = embed("", mPath, mPath, STEGO_KEY);
    Log.d(TAG, status + "");
    return status;
  }


  public String encrypt(String key, String content) throws Exception {
    SecretKeySpec skey = new SecretKeySpec(key.getBytes(), algorithm);
    IvParameterSpec iv = new IvParameterSpec(IV_STRING.getBytes(), 0, offset);
    Cipher cipher = Cipher.getInstance(mode);
    cipher.init(Cipher.ENCRYPT_MODE, skey, iv);
    byte[] result = cipher.doFinal(content.getBytes("UTF-8"));
    return Base64.encodeToString(result, Base64.DEFAULT);
  }

  public String decrypt(String key, String content) throws Exception {
    SecretKeySpec skey = new SecretKeySpec(key.getBytes(), algorithm);
    IvParameterSpec iv = new IvParameterSpec(IV_STRING.getBytes(), 0, offset);
    Cipher cipher = Cipher.getInstance(mode);
    cipher.init(Cipher.DECRYPT_MODE, skey, iv);
    byte[] result = cipher.doFinal(Base64.decode(content, Base64.DEFAULT));
    return new String(result);
  }

  private int embed(String msg, String sourcePath, String stegoPath, String stegoKey) {
    try {
      msg = encrypt(AES_KEY, msg);
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }
    IStegoUtil stegoUtil = StegoUtil.getInstance();
    long handler = stegoUtil.createHandler();
    int state = stegoUtil.embed(handler, StegoConstant.ALGORITHM_JPEG_LARGE, msg, sourcePath, stegoPath, stegoKey, 1);
    stegoUtil.releaseHandler(handler);
    return state;
  }

  private String extract(String stegoPath, String stegoKey) {
    IStegoUtil stegoUtil = StegoUtil.getInstance();
    long handler = stegoUtil.createHandler();
    String ret = stegoUtil.extract(handler, StegoConstant.ALGORITHM_JPEG_LARGE, stegoPath, stegoKey);
    stegoUtil.releaseHandler(handler);
    try {
      ret = decrypt(AES_KEY, ret);
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
    return ret;
  }
}
