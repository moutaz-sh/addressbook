package com.syriatel.bpm.springtest.DTO;

import com.syriatel.bpm.springtest.entity.Contact;
import com.syriatel.bpm.springtest.entity.Role;
import com.syriatel.bpm.springtest.entity.Section;
import com.syriatel.bpm.springtest.entity.Session;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

public class UserDto {
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setSection(Section section) {
        this.section = section;
    }
    private long id;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public Section getSection() {
        return section;
    }

    private String name;
    private String email;
    private String password;
    private Role role;
    private Section section;

    public long getRole_id() {
        return role_id;
    }

    public long getSection_id() {
        return section_id;
    }

    private long role_id;

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public void setSection_id(long section_id) {
        this.section_id = section_id;
    }

    private long section_id;
    private List<Session> sessions;
    private  List<Contact> contacts;
    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
