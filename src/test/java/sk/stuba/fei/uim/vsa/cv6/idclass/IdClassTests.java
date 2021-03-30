package sk.stuba.fei.uim.vsa.cv6.idclass;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class IdClassTests {

    @Autowired
    private IdClassZamestnanecService service;

    @Test
    @Order(1)
    void prijatZamestnanceTest() {
        Zamestnanec juraj = service.prijatZamestnanca(1, "Juraj");
        assert juraj != null;
        assert juraj.getId() == 1;
        assert juraj.getOd() != null;
        assert "Juraj".equals(juraj.getMeno());
        assert juraj.getPlat() == 0;
    }

    @Test
    @Order(2)
    void aktualizovatZamestnancaTest() {
        Optional<Zamestnanec> optional = service.vyhladatZamestnanca(1);
        assert optional.isPresent();
        Zamestnanec juraj = optional.get();
        juraj.setPlat(1000);
        LocalDateTime jurajOd = juraj.getOd();
        Zamestnanec novy = service.aktualizovatZamestnanca(juraj);
        assert novy.getPlat() == 1000;
        assert novy.getId().equals(juraj.getId());
        assert novy.getMeno().equals(juraj.getMeno());
        assert novy.getOd().isAfter(jurajOd);
    }

    @Test
    @Order(3)
    void prepustitZamestnancaTest() {
        Optional<Zamestnanec> optional = service.vyhladatZamestnanca(1);
        assert optional.isPresent();
        Zamestnanec juraj = optional.get();
        service.prepustitZamestnanca(juraj);

        optional = service.vyhladatZamestnanca(1);
        assert optional.isPresent();
        juraj = optional.get();
        assert juraj.getMeno() == null;
        assert juraj.getZaradenie() == null;
        assert juraj.getPlat() == 0;
    }
}
