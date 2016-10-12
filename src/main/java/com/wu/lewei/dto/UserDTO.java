package com.wu.lewei.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by cn40580 on 2016-10-09.
 */
public class UserDTO {
    @Id
    @GeneratedValue
    private String id;
    private String username;
    private Integer age;
    private String preferredLanguage;
    private String currency;

    public UserDTO() {
    }

    public UserDTO(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getCurrency() {
        return currency;
    }
}
