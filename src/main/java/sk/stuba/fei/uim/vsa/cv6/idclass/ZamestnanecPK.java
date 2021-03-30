package sk.stuba.fei.uim.vsa.cv6.idclass;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ZamestnanecPK implements Serializable {
    private Long id;
    private LocalDateTime od;
}
