package com.ustc.orange.orange.enity;

import com.google.gson.annotations.SerializedName;

public class AccountInfo {

  @SerializedName("id")
  public int id;

  @SerializedName("website")
  public String website;

  @SerializedName("username")
  public String username;

  @SerializedName("password")
  public String password;

  @SerializedName("level")
  public int level;

  @SerializedName("type")
  public int type;

  @SerializedName("description")
  public String description;

  public AccountInfo() {
  }

  public AccountInfo setId(int id) {
    this.id = id;
    return this;
  }

  public AccountInfo setWebsite(String website) {
    this.website = website;
    return this;
  }

  public AccountInfo setUsername(String username) {
    this.username = username;
    return this;
  }

  public AccountInfo setPassword(String password) {
    this.password = password;
    return this;
  }

  public AccountInfo setLevel(int level) {
    this.level = level;
    return this;
  }

  public void setType(int type) {
    this.type = type;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
