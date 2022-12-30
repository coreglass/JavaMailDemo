package com.yuwen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

  private long id;
  private String account;
  private String password;
  private String username;
  private String address;

}
