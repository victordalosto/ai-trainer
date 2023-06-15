package dalosto.neurit.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import dalosto.neurit.model.Domain;


public interface DomainRepository extends JpaRepository<Domain, Integer> {

    long countByIsMapped(boolean b);

}
