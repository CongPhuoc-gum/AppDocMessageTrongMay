package com.phancongcoc.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String Name;
    private String Phone;

    public Contact(String phone, String name) {
        Phone = phone;
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Ten: " +Name+ "\nPhone: " +this.Phone;
    }
}
