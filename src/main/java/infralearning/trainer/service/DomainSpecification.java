package infralearning.trainer.service;
import org.springframework.data.jpa.domain.Specification;
import infralearning.trainer.model.Domain;


public class DomainSpecification {


    public static Specification<Domain> of(String layer1, String layer2) {
        return Specification.where(layer1Is(layer1))
                            .and(layer2Is(layer2));
    }
    
    
    private static Specification<Domain> layer1Is(String layer1) {
        return (root, query, cb) ->  {
            if (layer1 == null || layer1.isBlank()) {
                return cb.conjunction();
            }
            return cb.equal(root.get("layer1"), layer1.toLowerCase());
        };
    }
    

    private static Specification<Domain> layer2Is(String layer2) {
        return (root, query, cb) ->  {
            if (layer2 == null || layer2.isBlank()) {
                return cb.conjunction();
            }
            return cb.equal(root.get("layer2"), layer2.toLowerCase());
        };
    }
    
}
