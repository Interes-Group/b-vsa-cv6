package sk.stuba.fei.uim.vsa.cv6;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ZamestnanecService<T> {
    /**
     * Vráti aktuálne údaje o zamestnancovi
     */
    Optional<T> vyhladatZamestnanca(long id);

    /**
     * Vvráti údaje o zamestnancovi platné, k danému dátumu
     */
    Optional<T> vyhladatZamestnanca(long id, LocalDateTime datum);

    /**
     * Vytvorí nového zamestnanca
     */
    T prijatZamestnanca(long id, String meno);

    /**
     * Aktualizuje údaje o zamestnancovi
     */
    T aktualizovatZamestnanca(T z);

    /**
     * Prepusti zamestnanca
     */
    void prepustitZamestnanca(T z);
}
