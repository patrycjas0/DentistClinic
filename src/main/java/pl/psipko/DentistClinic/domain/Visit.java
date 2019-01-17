package pl.psipko.DentistClinic.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate date;

    private LocalTime time;

    private String description;

    @OneToOne
    private Doctor doctor;

    @OneToOne
    private Patient patient;

    private boolean importatnt;

    public Visit(LocalDate date, LocalTime time,String description,Doctor doctor, Patient patient) {

        this.date = date;
        this.time = time;
        this.description=description;
        this.doctor=doctor;
        this.patient=patient;
    }

    public int getId() {
        return id;
    }



    public Visit() {
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isImportatnt() {
        return importatnt;
    }

    public void setImportatnt(boolean importatnt) {
        this.importatnt = importatnt;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescripton() {
        return description;
    }

    public void setDescripton(String description) {
        this.description = description;
    }
}
