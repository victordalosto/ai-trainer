package inframachine.trainer.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import inframachine.trainer.model.Domain;
import inframachine.trainer.model.TableRow;


public interface DomainRepository extends JpaRepository<Domain, Integer> {

    long countByIsMapped(boolean b);

    @Query("""
            SELECT new inframachine.trainer.model.TableRow(p.layer1, COUNT(p.layer1)) 
            FROM placas p 
            WHERE p.isMapped = true 
            GROUP BY p.layer1
            """)
    List<TableRow> getTable();

}
