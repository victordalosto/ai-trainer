package dalosto.neurit.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dalosto.neurit.repository.DomainRepository;


@Service
public class DatabaseRepository {

    @Autowired
    private DomainRepository repository;

    private long databaseLength = -1;


    public long getDatabaseLength() {
        if (databaseLength == -1) {
            databaseLength = repository.count();
        }
        return databaseLength;
    }

    public long getMappedLength() {
        return repository.countByIsMapped(true);
    }


}
