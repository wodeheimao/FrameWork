package com.zelin.pojo;


public class User {

  private String uid;
  private String username;
  private String password;
  private String birth;

  private IdCard idCard;
  public User() {

  }

  public User(String uid, String username, String password, String birth) {
    this.uid = uid;
    this.username = username;
    this.password = password;
    this.birth = birth;
  }

  public IdCard getIdCard() {
    return idCard;
  }

  public void setIdCard(IdCard idCard) {
    this.idCard = idCard;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getBirth() {
    return birth;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  @Override
  public String toString() {
    return "User{" +
            "uid='" + uid + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", birth='" + birth + '\'' +
            '}';
  }
}
