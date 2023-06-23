package inframachine.trainer.filter;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import inframachine.trainer.model.Layers;
import inframachine.trainer.model.Pagination;
import inframachine.trainer.service.DatabaseRepository;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * This class handles the pagination of the trainer.
 * 
 * It is a filter that intercepts the requests and handles the pagination.
 * If they are not valid, it redirects to valid pages.
 */
@Component
public class PaginationConfiguration implements Filter {

    @Autowired
    private DatabaseRepository repository;

    @Autowired
    private List<Layers> layers1;

    @Autowired
    private List<Layers> layers2;



    @Override
    public void doFilter(ServletRequest servletRequest, 
                         ServletResponse servletResponse, 
                         FilterChain filterChain)throws IOException, ServletException 
    {
        if (!isTrainerPage(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        filterOrRedirect(filterChain, 
                         (HttpServletRequest) servletRequest, 
                         (HttpServletResponse) servletResponse);
    }



    private boolean isTrainerPage(ServletRequest request) {
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        String contextPath = ((HttpServletRequest) request).getContextPath();
        return requestURI.equals(contextPath) || requestURI.equals(contextPath + "/");
    }



    private void filterOrRedirect(FilterChain filterChain, 
                                  HttpServletRequest request, 
                                  HttpServletResponse response)
                                  throws IOException, ServletException {
        
        Pagination pagination = new Pagination();

        String layer1Param = request.getParameter("layer1");
        String layer2Param = request.getParameter("layer2");
        String pageParam = request.getParameter("page");
        String itemParam = request.getParameter("item");

        fixLayerParam(pagination, layer1Param, layer2Param);
        fixPageParam(pagination, pageParam);
        fixItemParam(pagination, itemParam);

        System.out.println(pagination);
        if (pagination.isRedirect()) {
            System.out.println("Sending redirect");
            response.sendRedirect(pagination.getRedirectLocation());
        } else {
            System.out.println("Doing chain");
            filterChain.doFilter(request, response);
        }
    }


    private void fixLayerParam(Pagination pagination, String layer1, String layer2) {
        if (layer1 != null && !layer1.isBlank() && !layer1.equals("null")) {
            boolean layer1Found = false;
            for (Layers layer : layers1) {
                if (layer.getName().equalsIgnoreCase(layer1)) {
                    pagination.setLayer1(layer.getName());
                    layer1Found = true; 
                    break;
                }
            }
            if (!layer1Found) {
                pagination.setRedirect(true);
                pagination.setLayer1("");
            }
        }
        if (layer2 != null && !layer2.isBlank() && !layer2.equals("null")) {
            boolean layer2Found = false;
            for (Layers layer : layers2) {
                if (layer.getName().equalsIgnoreCase(layer2)) {
                    pagination.setLayer2(layer.getName());
                    layer2Found = true;
                    break;
                }
            }
            if (!layer2Found) {
                pagination.setRedirect(true);
                pagination.setLayer2("");
            }
        }
    }


    private void fixPageParam(Pagination pagination, String pageParam) {
        if (pageParam != null) {
            try {
                int page = Integer.parseInt(pageParam);
                if (page < 0) {
                    pagination.setRedirect(true);
                    pagination.setPage(0);
                }
                if (page > repository.getTotalOfPages()-1) {
                    pagination.setRedirect(true);
                    pagination.setPage(repository.getTotalOfPages()-1);
                } else {
                    pagination.setPage(Integer.parseInt(pageParam));
                }
            } catch (NumberFormatException e) {
                pagination.setRedirect(true);
                pagination.setPage(0);
            }
        }
    }


    private void fixItemParam(Pagination pagination, String itemParam) {
        if (itemParam != null) {
            try {
                int item = Integer.parseInt(itemParam);
                if (item == 0) {
                    pagination.setItem(0);
                } else {
                    movePage(pagination, item);
                } 
            } catch (NumberFormatException e) {
                pagination.setRedirect(true);
                pagination.setItem(0);
            }
        }
    }



    private void movePage(Pagination pagination, int item) {
        if (item < 0) {
            goBackOnePage(pagination);
        } else if (itemIsInSamePage(pagination, item)) {
            pagination.setItem(item);
        } else {
            goForwardOnePage(pagination, item);
        }
    }



    private void goBackOnePage(Pagination pagination) {
        if (pagination.getPage() > 0) {
            pagination.setRedirect(true);
            pagination.setPage(pagination.getPage() - 1);
            pagination.setItem(repository.getPageSize() - 1);
        } else {
            pagination.setRedirect(true);
            pagination.setPage(0);
            pagination.setItem(0);
        }
    }



    private boolean itemIsInSamePage(Pagination pagination, int item) {
        if (pagination.getPage() == repository.getTotalOfPages() - 1)
            return item < repository.getTotalOfItensInLastPage() - 1;
        return item < repository.getPageSize();
    }



    private void goForwardOnePage(Pagination pagination, int item) {
        int nextPage = pagination.getPage() + 1;
        if (nextPage < repository.getTotalOfPages()-1) {
            pagination.setRedirect(true);
            pagination.setPage(nextPage);
            pagination.setItem(0);
        } else {
            int maxItem = repository.getTotalOfItensInLastPage() - 1;
            if (item > maxItem) {
                pagination.setRedirect(true);
            }
            pagination.setItem(maxItem);
        }
    }
}