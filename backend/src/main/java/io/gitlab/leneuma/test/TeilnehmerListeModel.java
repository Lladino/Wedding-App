package io.gitlab.leneuma.test;

import org.hibernate.annotations.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

public class TeilnehmerListeModel {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    private String uebernachtungen;

    private List<TeilnehmerModel> teilnehmer;

    public List<TeilnehmerModel> getTeilnehmer() {
        return teilnehmer;
    }

    public void setTeilnehmer(List<TeilnehmerModel> teilnehmer) {
        this.teilnehmer = teilnehmer;
    }

    public String getUebernachtungen() {
        return uebernachtungen;
    }

    public void setUebernachtungen(String uebernachtungen) {
        this.uebernachtungen = uebernachtungen;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
