package sk.stuba.fei.uim.vsa.cv6.embeddedid;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
public class ZamestnanecPK implements Serializable {
    private Long id;
    private LocalDateTime od;
}
