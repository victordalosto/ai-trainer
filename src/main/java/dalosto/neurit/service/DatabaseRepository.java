package dalosto.neurit.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dalosto.neurit.model.Domain;
import dalosto.neurit.repository.DomainRepository;


@Service
public class DatabaseRepository {

    @Autowired
    private DomainRepository repository;

    private long databaseLength = -1;
    private int totalPages = -1;

    private int paginationSize = 12;


    public long getDatabaseLength() {
        if (databaseLength == -1) {
            databaseLength = repository.count();
        }
        return databaseLength;
    }


    public long getMappedLength() {
        return repository.countByIsMapped(true);
    }


    public Page<Domain> getDomains(int page) {
        page = putPagesInsideLimits(page);
        return repository.findAll(PageRequest.of(page, paginationSize));
    }


    private int putPagesInsideLimits(int page) {
        if (page <= 0) {
            return 0;
        }
        if (totalPages == -1) {
            totalPages = repository.findAll(PageRequest.of(0, paginationSize)).getTotalPages() -1;
        }
        if (page > totalPages) {
            page = totalPages;
        }
        return page;
    }


}
