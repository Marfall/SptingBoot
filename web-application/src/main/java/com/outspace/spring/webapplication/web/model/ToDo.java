package com.outspace.spring.webapplication.web.model;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

public class ToDo {
    private int id;
    private String user;

    @Size(min=10, message = "Enter at least 10 Characters...")
    private String desc;
    private Date targetDate;
    private boolean isDone;

    public ToDo() {

    }

    public ToDo(int id, String user, String desc, Date targetDate, boolean isDone) {
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", desc='" + desc + '\'' +
                ", targetDate=" + targetDate +
                ", isDone=" + isDone +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
       if (this== obj ) {
           return true;
       }
       if (obj == null) {
           return false;
       }
       if (getClass() != obj.getClass()) {
           return false;
       }
       ToDo other = (ToDo) obj;
       if (id != other.id) {
           return false;
        }
       return true;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
}
