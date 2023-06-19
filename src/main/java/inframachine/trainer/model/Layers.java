package inframachine.trainer.model;
import java.io.IOException;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;


@Data
public class Layers {

    private String name;

    private String color;



    public static List<Layers> getFirstLayer() throws IOException, StreamReadException, DatabindException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new ClassPathResource("layers/primaryLayer.json").getFile(), 
                                mapper.getTypeFactory().constructCollectionType(List.class, Layers.class));
    }



    public static List<Layers> getSecondLayer() throws StreamReadException, DatabindException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new ClassPathResource("layers/secondaryLayer.json").getFile(), 
                                mapper.getTypeFactory().constructCollectionType(List.class, Layers.class));
    }

}
