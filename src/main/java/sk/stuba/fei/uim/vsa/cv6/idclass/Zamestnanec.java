package sk.stuba.fei.uim.vsa.cv6.idclass;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "zamestnanec_idclass")
@Data
@NoArgsConstructor
@IdClass(ZamestnanecPK.class)
public class Zamestnanec {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Id
    private LocalDateTime od;
    private String meno;
    private String zaradenie;
    private float plat;
}
