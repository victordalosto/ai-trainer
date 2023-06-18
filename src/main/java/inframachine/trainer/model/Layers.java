package inframachine.trainer.model;
import java.io.File;
import java.io.IOException;
import java.util.List;
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
        return mapper.readValue(new File("layers/primaryLayer.json"), 
                                mapper.getTypeFactory().constructCollectionType(List.class, Layers.class));
    }



    public static List<Layers> getSecondLayer() throws StreamReadException, DatabindException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("layers/secondaryLayer.json"), 
                                mapper.getTypeFactory().constructCollectionType(List.class, Layers.class));
    }

}
