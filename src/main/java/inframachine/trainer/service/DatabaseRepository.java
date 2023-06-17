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
    private int pageSize = 10;


    public Page<Domain> getDomains(int page) {
        return repository.findAll(PageRequest.of(page, pageSize, Sort.by("id")));
    }


    public int getTotalOfPages() {
        if (totalOfPages == 0) {
            totalOfPages = repository.findAll(PageRequest.of(0, pageSize)).getTotalPages();
        }
        return totalOfPages;
    }


    public int getTotalOfItensInLastPage() {
        if (totalOfItensInLastPage == 0) {
            int totalOfPages = getTotalOfPages();
            totalOfItensInLastPage = repository.findAll(PageRequest.of(totalOfPages-1, pageSize)).getNumberOfElements();
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


    public void save(String method, String id) {
        Domain domain = repository.findById(Integer.valueOf(id)).get();
        if (method.equals("SAVE")) {
            domain.setValid(true);
            domain.setMapped(true);
            repository.save(domain);
        } else if (method.equals("DELETE")) {
            domain.setValid(false);
            domain.setMapped(false);
            repository.save(domain);
        }
    }

}
