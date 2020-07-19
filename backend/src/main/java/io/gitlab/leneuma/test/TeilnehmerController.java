package io.gitlab.leneuma.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/api")
public class TeilnehmerController {

    @Autowired
    TeilnehmerRepository teilnehmerRepository;

    @GetMapping("/teilnehmer/list")
    public List<TeilnehmerModel> hinzufuegen() {
        return teilnehmerRepository.findAll();
    }

    @PostMapping("/teilnehmer/save")
    @ResponseBody
    public TeilnehmerModel postTeilnehmer(@RequestBody TeilnehmerModel teilnehmer) {
        TeilnehmerModel save = teilnehmerRepository.save(teilnehmer);
        return save;
    }

    @PostMapping("/teilnehmer/delete")
    public void delete(@RequestBody TeilnehmerDeleteRequest request) {
        teilnehmerRepository.deleteById(request.getId());
    }

    @PostMapping("/teilnehmer/add")
    @ResponseBody
    public void addTeilnehmer(@RequestBody List<TeilnehmerModel> teilnehmer) {
        teilnehmerRepository.saveAll(teilnehmer);
    }

}
