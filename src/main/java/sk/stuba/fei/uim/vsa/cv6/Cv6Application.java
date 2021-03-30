package sk.stuba.fei.uim.vsa.cv6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.stuba.fei.uim.vsa.cv6.embeddedid.EmbeddedIdZamestnanecService;
import sk.stuba.fei.uim.vsa.cv6.embeddedid.Zamestnanec;
import sk.stuba.fei.uim.vsa.cv6.idclass.IdClassZamestnanecService;

import java.util.Optional;

@SpringBootApplication
public class Cv6Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Cv6Application.class, args);
    }

    @Autowired
    private EmbeddedIdZamestnanecService embeddedIdZamestnanecService;
    @Autowired
    private IdClassZamestnanecService idClassZamestnanecService;

    @Override
    public void run(String... args) throws Exception {
        testEmbeddedId();
        testIdClass();
    }

    void testEmbeddedId() {
        Zamestnanec juraj = embeddedIdZamestnanecService.prijatZamestnanca(1, "Juraj");
        assert juraj != null;
        assert juraj.getPk().getId() == 1;
        assert juraj.getPk().getOd() != null;
        assert "Juraj".equals(juraj.getMeno());

        Optional<Zamestnanec> optional = embeddedIdZamestnanecService.vyhladatZamestnanca(1);
        assert optional.isPresent();
        juraj = optional.get();
        juraj.setPlat(100);
        Zamestnanec novyJuraj = embeddedIdZamestnanecService.aktualizovatZamestnanca(juraj);
        assert novyJuraj.getPlat() == 100;
        assert novyJuraj.getMeno().equals(juraj.getMeno());

        embeddedIdZamestnanecService.prepustitZamestnanca(novyJuraj);
    }

    void testIdClass() {
        sk.stuba.fei.uim.vsa.cv6.idclass.Zamestnanec juraj = idClassZamestnanecService.prijatZamestnanca(1, "Juraj");
        assert juraj != null;
        assert juraj.getId() == 1;
        assert juraj.getOd() != null;
        assert "Juraj".equals(juraj.getMeno());

        Optional<sk.stuba.fei.uim.vsa.cv6.idclass.Zamestnanec> optional = idClassZamestnanecService.vyhladatZamestnanca(1);
        assert optional.isPresent();
        juraj = optional.get();
        juraj.setPlat(100);
        sk.stuba.fei.uim.vsa.cv6.idclass.Zamestnanec novyJuraj = idClassZamestnanecService.aktualizovatZamestnanca(juraj);
        assert novyJuraj.getPlat() == 100;
        assert novyJuraj.getId().equals(juraj.getId());
        assert novyJuraj.getMeno().equals(juraj.getMeno());

        idClassZamestnanecService.prepustitZamestnanca(novyJuraj);
    }
}
