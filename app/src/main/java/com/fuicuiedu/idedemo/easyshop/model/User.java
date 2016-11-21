package com.fuicuiedu.idedemo.easyshop.model;

import com.google.gson.annotations.SerializedName;

/**
 * "name": "ytd70aa402693e4333a6318933226d0276", //环信ID
 "uuid": "939913BF5BEB46A29047BE66399BC1A0",   //用户表中主键
 "username": "android"  //用户名
 */

public class User {
    @SerializedName("name")
    private String hx_Id;
    @SerializedName("uuid")
    private String table_Id;
    @SerializedName("username")
    private String name;

    public void setHx_Id(String hx_Id) {
        this.hx_Id = hx_Id;
    }

    public void setTable_Id(String table_Id) {
        this.table_Id = table_Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHx_Id() {
        return hx_Id;
    }

    public String getTable_Id() {
        return table_Id;
    }

    public String getName() {
        return name;
    }
}
