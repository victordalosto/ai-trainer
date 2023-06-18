package inframachine.trainer.configuration;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import inframachine.trainer.model.Layers;


@Configuration
public class ParameterConfiguration {


    @Bean("primaryLayer")
    public List<Layers> primaryLayer() throws StreamReadException, DatabindException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("layers/primaryLayer.json"), 
                                mapper.getTypeFactory().constructCollectionType(List.class, Layers.class));
    }


    @Bean("secondaryLayer")
    public List<Layers> secondaryLayer() throws StreamReadException, DatabindException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("layers/secondaryLayer.json"), 
                                mapper.getTypeFactory().constructCollectionType(List.class, Layers.class));
    }

}
