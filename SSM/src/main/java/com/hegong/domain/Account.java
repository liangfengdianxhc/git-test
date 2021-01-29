package com.hegong.domain;

import java.io.Serializable;

/**
 * @author 14767
 * 账户实体类
 * 因为web服务器通常将那些暂时不活动但未超时的HttpSession对象转移到文件系统或数据库中保存，所以需要序列化
 */
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
