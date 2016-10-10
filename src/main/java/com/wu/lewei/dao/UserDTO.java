package com.wu.lewei.dao;

import javax.persistence.Id;

/**
 * Created by cn40580 on 2016-10-09.
 */
public class UserDTO {
    @Id
    private Long id;
    private String username;
    private Integer age;
    private String preferredLanguage;
    private String currency;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
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
