package com.chris.ch1.entity.logicbean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class WorkInfoForm {

    public interface Update{}
    public interface Add{}

    @NotNull(groups={Update.class})
    @Null(groups={Add.class})
    private Long id;

    @Size(min=3, max=20)
    private String name;

    @Email(groups={Add.class})
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
