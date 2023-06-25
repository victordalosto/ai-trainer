package infralearning.trainer.repository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import infralearning.trainer.model.Domain;
import infralearning.trainer.model.TableRow;


public interface DomainRepository extends JpaRepository<Domain, Integer>,
                                          JpaSpecificationExecutor<Domain> {

    @Query("SELECT COUNT(d) FROM placas d WHERE d.isMapped = :isMapped AND d.layer1 <> 'null'")
    long countByIsMappedAndLayer1NotNull(boolean isMapped);

    @Query("""
            SELECT new infralearning.trainer.model.TableRow(p.layer1, COUNT(p.layer1)) 
            FROM placas p 
            WHERE p.isMapped = true 
            GROUP BY p.layer1
            """)
    List<TableRow> getTable();


    Page<Domain> findAll(Specification<Domain> specification, Pageable pageable);


}
