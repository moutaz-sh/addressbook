package com.syriatel.bpm.springtest.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Email
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_ids")
    private Role role;
    @ManyToOne
    @JoinColumn
    private Section section;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Session> sessions;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
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
