package inframachine.trainer.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity(name = "sinalizacao")
public class Domain {

    @Id
    private Integer id;

    @Column(name = "nome")
    private String parameter;

    @Column(name = "condicao")
    private String classification;

    @Column(name = "is_mapped")
    private boolean isMapped;

    @Column(name = "is_valid")
    private boolean isValid;

    @Column(name = "is_clear")
    private boolean isClear;

}
