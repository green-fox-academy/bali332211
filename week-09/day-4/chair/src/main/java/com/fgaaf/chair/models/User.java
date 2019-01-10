package com.fgaaf.chair.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String username;
  private String password;

  @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "x_id")
  private List<Chair> chairs;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<Chair> getXcies() {
    return chairs;
  }

  public void setXcies(List<Chair> xcies) {
    this.chairs = xcies;
  }
}
