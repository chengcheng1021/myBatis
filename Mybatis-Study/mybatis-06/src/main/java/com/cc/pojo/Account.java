package com.cc.pojo;

import lombok.Data;

@Data
public class Account {

    private int ID;
    private float MONEY;
    //用户ID
    private User USER;

}
