package inframachine.trainer.model;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * Simple table row that contains
 * | name | count |
 * |------|-------|
 */
@Data
@AllArgsConstructor
public class TableRow {

    private String name;
    private Long count;


}
