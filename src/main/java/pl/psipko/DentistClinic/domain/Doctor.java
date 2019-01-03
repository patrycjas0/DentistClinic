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
    private String email;
    private String password;
    private boolean enabled;
    private String role;

    public Doctor(String email,String password,String role,boolean enabled)
    {
        this.email=email;
        this.password=password;
        this.role="ADMIN";
        this.enabled=true;
    }

    public Doctor(String name, String lastname, String email, String password,String role,boolean enabled) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role="USER2";
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
        return email;
    }

    public void setUser(String user) {
        this.email = user;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
