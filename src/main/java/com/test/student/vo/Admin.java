package com.test.student.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangjian on 2017/11/6.
 */
public class Admin implements Serializable {
    private String email;
    private String password;
    private Date lastdate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }
}
