package inframachine.trainer.filter;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import inframachine.trainer.service.DatabaseRepository;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class PaginationConfiguration implements Filter {

    @Autowired
    private DatabaseRepository databaseRepository;


    @Override
    public void doFilter(ServletRequest servletRequest, 
                         ServletResponse servletResponse, 
                         FilterChain filterChain)
                            throws IOException, ServletException 
    {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (!isHomePage(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String pageParam = request.getParameter("page");
        String itemParam = request.getParameter("item");

        boolean redirect = false;

        if (pageParam != null) {
            try {
                if (Integer.parseInt(pageParam) < 0) {
                    throw new NumberFormatException();
                } 
            } catch (NumberFormatException e) {
                redirect = true;
                pageParam = "0";
            }
        } else {
            pageParam = "0";
        }

        if (itemParam != null) {
            try {
                if (Integer.parseInt(itemParam) < 0) {
                    throw new NumberFormatException();
                } else if (Integer.parseInt(itemParam) >= databaseRepository.getPaginationSize()) {
                    itemParam = "0";
                    pageParam = String.valueOf(Integer.parseInt(pageParam) + 1);
                    redirect = true;
                }
            } catch (NumberFormatException e) {
                redirect = true;
                itemParam = "0";
            }

        }

        if (Integer.parseInt(pageParam) > databaseRepository.getTotalOfPages()) {
            redirect = true;
            pageParam = String.valueOf(databaseRepository.getTotalOfPages());
        }

        if (redirect) {
            String location = "/?page=" + pageParam + "&item=" + itemParam;
            response.sendRedirect(location);
            return;
        } else {
            filterChain.doFilter(request, response);
        }
    }


    private boolean isHomePage(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        return requestURI.equals(contextPath) || requestURI.equals(contextPath + "/");
    }



}