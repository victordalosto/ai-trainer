package inframachine.trainer.configuration;
import java.io.IOException;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import inframachine.trainer.model.Layers;


@Configuration
public class ParameterConfiguration {


    @Bean("primaryLayer")
    public List<Layers> primaryLayer() throws StreamReadException, DatabindException, IOException {
        return Layers.getFirstLayer();
    }


    @Bean("secondaryLayer")
    public List<Layers> secondaryLayer() throws StreamReadException, DatabindException, IOException {
        return Layers.getSecondLayer();
    }

}
