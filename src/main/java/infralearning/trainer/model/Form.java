package infralearning.trainer.model;
import lombok.Data;


@Data
public class Form {
    
    /** Form method That is equal [SAVE | DELETE] */
    private String method;

    private String layer1;

    private String layer2;

    private String nextPage;
    
}
