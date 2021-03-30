package sk.stuba.fei.uim.vsa.cv6.embeddedid;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDateTime;

@Entity(name = "zamestnanec_embeddedid")
@Data
public class Zamestnanec {
    @EmbeddedId
    private ZamestnanecPK pk;
    private String meno;
    private String zaradenie;
    private float plat;

    public Zamestnanec() {
        this.pk = new ZamestnanecPK();
    }
}
