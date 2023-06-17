package inframachine.trainer.model;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Pagination {

    private int page = 0;
    private int item = 0;
    private boolean redirect = false;


    public String getRedirectLocation() {
        String location = "/";
        if (page > 0) {
            location += "?page=" + page;
            if (item > 0) {
                location += "&item=" + item;
            }
        } else if (item > 0) {
            location += "?item=" + item;
        }
        return location;
    }

}
