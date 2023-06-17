package inframachine.trainer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import inframachine.trainer.model.Domain;


public interface DomainRepository extends JpaRepository<Domain, Integer> {

    long countByIsMapped(boolean b);

}
