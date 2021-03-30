package sk.stuba.fei.uim.vsa.cv6.embeddedid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface EmbeddedIdZamestnanecRepository extends JpaRepository<Zamestnanec, ZamestnanecPK> {

    Optional<Zamestnanec> findFirstByPk_IdAndPk_OdBeforeOrderByPk_OdDesc(long id, LocalDateTime od);
}
