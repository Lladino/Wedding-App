package io.gitlab.leneuma.test;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TeilnehmerRepository extends CrudRepository<TeilnehmerModel, UUID> {
    List<TeilnehmerModel> findAll();
//    List<TeilnehmerModel> findByName(String name);
//    List<TeilnehmerModel> findAll

    List<TeilnehmerModel> findByVornameOrderByVornameAsc(String name);
//    List<TeilnehmerModel> findByBearbeiterIdOrderByVornameAsc(UUID bearbeiterId);
}
