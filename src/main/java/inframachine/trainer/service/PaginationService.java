package inframachine.trainer.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import inframachine.trainer.model.Pagination;


@Service
public class PaginationService {

    @Autowired
    private DatabaseRepository databaseRepository;


    public void fixPagination(Pagination pagination) {
        if (pagination.getItem() < 0) {
            pagination.setItem(0);
        }
        
        if (pagination.getItem() >= databaseRepository.getPaginationSize()) {
            pagination.setItem(0);
            pagination.setPage(pagination.getPage() + 1);
        }
        
    }

}
