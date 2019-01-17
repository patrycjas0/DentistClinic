package pl.psipko.DentistClinic.domain;

import org.springframework.format.annotation.DateTimeFormat;
import pl.psipko.DentistClinic.annotation.UserUnique;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URL;
import java.time.LocalDate;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String lastname;

    private int phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @OneToOne
    private Adress adress;

    private URL dentalResonancePic;

    private String description;

    @OneToOne
    private Visit visit;

    private URL teethFile;

    private String password;

    @NotNull
    @Size(min=2, max=40,message = "Za krótkie!")
    @Column(unique = true)
    @UserUnique(message = "Taki email już istnieje")
    @NotEmpty(message = "Nie może być puste!")
    private String user; //email

    private String role;

    private boolean enabled;


    public Patient(String name, String lastname, String password, String user, LocalDate birthDate, int phoneNumber,String role, boolean enabled) {
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.user = user;
        this.birthDate=birthDate;
        this.phoneNumber=phoneNumber;
        this.role="USER";
        this.enabled=true;
    }


    public Patient() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public URL getDentalResonancePic() {
        return dentalResonancePic;
    }

    public void setDentalResonancePic(URL dentalResonancePic) {
        this.dentalResonancePic = dentalResonancePic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public URL getTeethFile() {
        return teethFile;
    }

    public void setTeethFile(URL teethFile) {
        this.teethFile = teethFile;
    }
}
