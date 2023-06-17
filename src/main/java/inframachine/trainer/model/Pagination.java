package inframachine.trainer.model;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Pagination {

    private int page = 0;
    private int item = 0;
    private boolean redirect = false;

}
