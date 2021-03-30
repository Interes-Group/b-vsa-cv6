package sk.stuba.fei.uim.vsa.cv6.idclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.vsa.cv6.ZamestnanecService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class IdClassZamestnanecService implements ZamestnanecService<Zamestnanec> {

    @Autowired
    private IdClassZamestnanecRepository repository;

    /**
     * Vráti aktuálne údaje o zamestnancovi
     */
    public Optional<Zamestnanec> vyhladatZamestnanca(long id) {
        return vyhladatZamestnanca(id, LocalDateTime.now());
    }

    /**
     * Vvráti údaje o zamestnancovi platné, k danému dátumu
     */
    public Optional<Zamestnanec> vyhladatZamestnanca(long id, LocalDateTime datum) {
        return repository.findFirstByIdAndOdBeforeOrderByOdDesc(id, datum);
    }

    /**
     * Vytvorí nového zamestnanca
     */
    public Zamestnanec prijatZamestnanca(long id, String meno) {
        Zamestnanec novyZamestnanec = new Zamestnanec();
        novyZamestnanec.setId(id);
        novyZamestnanec.setOd(LocalDateTime.now());
        novyZamestnanec.setMeno(meno);
        return repository.save(novyZamestnanec);
    }

    /**
     * Aktualizuje údaje o zamestnancovi
     */
    public Zamestnanec aktualizovatZamestnanca(Zamestnanec z) {
        z.setOd(LocalDateTime.now());
        return repository.save(z);
    }

    /**
     * Prepusti zamestnanca
     */
    public void prepustitZamestnanca(Zamestnanec z) {
        z.setMeno(null);
        z.setZaradenie(null);
        z.setPlat(0);
        aktualizovatZamestnanca(z);
    }
}
