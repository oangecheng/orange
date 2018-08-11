package com.ustc.orange.orange.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ustc.orange.orange.enity.AccountInfo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonManager<T> {

  public List<T> jsonToList(String json, Class<T> cls) {
    if (CommonUtils.isEmpty(json)) {
      return new ArrayList<>();
    }
    Type listType = new ParameterizedTypeImpl(List.class, new Class[]{cls});
    List<T> list = new Gson().fromJson(json, listType);
    if (list != null) {
      return list;
    } else {
      return new ArrayList<>();
    }
  }

  public String listToJson(List<AccountInfo> list) {
    return new Gson().toJson(list);
  }

  public class ParameterizedTypeImpl implements ParameterizedType {
    private final Class raw;
    private final Type[] args;
    public ParameterizedTypeImpl(Class raw, Type[] args) {
      this.raw = raw;
      this.args = args != null ? args : new Type[0];
    }
    @Override
    public Type[] getActualTypeArguments() {
      return args;
    }
    @Override
    public Type getRawType() {
      return raw;
    }
    @Override
    public Type getOwnerType() {return null;}
  }
}
