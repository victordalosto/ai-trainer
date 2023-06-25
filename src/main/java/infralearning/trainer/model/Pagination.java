package infralearning.trainer.model;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Pagination {
    
    private boolean redirect = false;
    
    private int page = 0;
    private int item = 0;
    private String layer1 = null;
    private String layer2 = null;


    public String getRedirectLocation() {
        String location = "/";
        if (!hasParam()){
            return location;
        }
        location += "?";
        if (page > 0) {
            location += "page=" + page + "&";
        }
        if (item > 0) {
            location += "item=" + item + "&";
        }
        if (layer1 != null && !layer1.isBlank()) {
            location += "layer1=" + layer1 + "&";
        }
        if (layer2 != null && !layer2.isBlank()) {
            location += "layer2=" + layer2 + "&";
        }
        return location.replaceAll("&$", "");
    }


    private boolean hasParam() {
        return page > 0 || item > 0 || layer1 != null || layer2 != null || !layer1.isBlank() || !layer2.isBlank();
    }

}
