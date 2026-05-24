package com.wyt.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUser {
    private long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Status status;
    private Date createTime;
}
