package io.gitlab.leneuma.test;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="teilnehmer")
public class TeilnehmerModel {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modifyDate")
    private Date modifyDate;

    //    private UUID userId .... der jenige der es dann bearbeitet;
//    private UUID bearbeiterId .... der jenige der es dann bearbeitet;

    @Column(name = "vorname")
    private String vorname;

    @Column(name = "nachname")
    private String nachname;

    @Column(name = "uebernachtungen")
    private String uebernachtungen;

    @Column(name = "age")
    private Long age;

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getUebernachtungen() {
        return uebernachtungen;
    }

    public void setUebernachtungen(String uebernachtungen) {
        this.uebernachtungen = uebernachtungen;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Teilnehmer [name=" + vorname
                + ", nachname=" + nachname + "]";
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
