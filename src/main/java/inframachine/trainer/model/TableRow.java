package inframachine.trainer.model;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Simple table row that contains
 * | name | count |
 * |------|-------|
 */
@Data
@NoArgsConstructor
public class TableRow {

    private String name;
    private Long count;


}
