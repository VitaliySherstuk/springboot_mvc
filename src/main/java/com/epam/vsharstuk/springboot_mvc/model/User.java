package com.epam.vsharstuk.springboot_mvc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private Integer id;
    //@NotBlank
    //@Email(message = "type right email")
    private String name;
    //@NotBlank
    private String password;
    private String roles;
    //@NotBlank
    //@Size(min = 13, max = 13, message = "Phone number should have 13 symbols and start '+'")
    //@Pattern(regexp = "[+]([0-9])*.", message = "Example: +375297772548")
    private String phone;

    public User() {
    }

    public User(Integer id, String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, String roles, String phone) {
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<Role> getRolesList() {

        List<Role> list = new ArrayList<>();

        String[] roles = this.roles.split(",");
            if (roles.length == 0) {
                return Collections.singletonList(Role.valueOf(this.roles));
            }
            for (String role : roles) {
                list.add(Role.valueOf(role));
            }
            return list;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }
}
