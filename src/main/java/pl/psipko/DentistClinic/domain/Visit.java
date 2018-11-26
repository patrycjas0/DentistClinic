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

    private String descripton;

    @OneToOne
    private Doctor doctor;

    private boolean importatnt;

    public Visit(LocalDate date, LocalTime time) {

        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }



    public Visit() {
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
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }
}
