package sk.stuba.fei.uim.vsa.cv6.idclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface IdClassZamestnanecRepository extends JpaRepository<Zamestnanec, ZamestnanecPK> {

    Optional<Zamestnanec> findFirstByIdAndOdBeforeOrderByOdDesc(long id, LocalDateTime od);
}
