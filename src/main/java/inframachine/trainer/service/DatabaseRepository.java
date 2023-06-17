package inframachine.trainer.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import inframachine.trainer.model.Domain;
import inframachine.trainer.repository.DomainRepository;
import lombok.Getter;


@Service
public class DatabaseRepository {

    @Autowired
    private DomainRepository repository;

    private int totalOfPages;            // cacheable
    private int totalOfItensInLastPage; // cacheable
    private long databaseLength;   // cacheable

    @Getter
    private int paginationSize = 10;


    public Page<Domain> getDomains(int page) {
        return repository.findAll(PageRequest.of(page, paginationSize, Sort.by("id")));
    }


    public int getTotalOfPages() {
        if (totalOfPages == 0) {
            totalOfPages = repository.findAll(PageRequest.of(0, paginationSize)).getTotalPages();
        }
        return totalOfPages;
    }


    public int getTotalOfItensInLastPage() {
        if (totalOfItensInLastPage == 0) {
            int totalOfPages = getTotalOfPages();
            totalOfItensInLastPage = repository.findAll(PageRequest.of(totalOfPages-1, paginationSize)).getNumberOfElements();
        }
        return totalOfItensInLastPage;
    }


    public long getDatabaseLength() {
        if (databaseLength == 0) {
            databaseLength = repository.count();
        }
        return databaseLength;
    }


    public long getMappedLength() {
        return repository.countByIsMapped(true);
    }

}
