package inframachine.trainer.model;
import lombok.Data;


@Data
public class Form {
    
    /** Form method That is equal [SAVE | DELETE] */
    private String method;

    private String primaryLayer;

    private String secondaryLayer;

    private String nextPage;
    
}
