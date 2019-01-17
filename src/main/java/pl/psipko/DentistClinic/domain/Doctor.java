package pl.psipko.DentistClinic.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name, lastname;
    private String user;
    private String password;
    private boolean enabled;
    private String role;

    public Doctor(String user,String password,String role,boolean enabled)
    {
        this.user=user;
        this.password=password;
        this.role="ADMIN";
        this.enabled=true;
    }

    public Doctor(String name, String lastname, String user, String password,String role,boolean enabled) {
        this.name = name;
        this.lastname = lastname;
        this.user = user;
        this.password = password;
        this.role="DOCTOR";
        this.enabled=true;
    }

    public Doctor() {
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
