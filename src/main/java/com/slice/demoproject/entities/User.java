package com.slice.demoproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@Table(name = "User")
@Getter
@Setter
@ToString(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {
  private String email;

  private String name;

  private String phoneNumber;

  private String password;
}
