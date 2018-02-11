package com.robin.domain;

import java.io.Serializable;

public class Role implements Serializable {
    private static final long serialVersionUID = 6977402643848374753L;

    private long id;
    private String roleName;
    private String note;

    public void setId(long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getNote() {
        return note;
    }
}
