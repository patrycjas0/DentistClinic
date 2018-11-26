package pl.psipko.DentistClinic.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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

    private String email;

    public Patient(String password, String email) {
        this.password = password;
        this.email = email;
    }


    public Patient(String name, String lastname, String password, String email, LocalDate birthDate, int phoneNumber) {
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.birthDate=birthDate;
        this.phoneNumber=phoneNumber;
    }

    public Patient() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
