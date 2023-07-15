package infralearning.trainer.configuration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import infralearning.trainer.model.Layers;


@Configuration
public class ParameterConfiguration {


    @Bean("layers1")
    public List<Layers> layers1() throws StreamReadException, DatabindException, IOException {
        List<Layers> layers = new ArrayList<Layers>();
        layers.add(new Layers("regulamentacao", "red"));
        layers.add(new Layers("advertencia", "rgb(225, 169, 24)"));
        layers.add(new Layers("indicativa", "green"));
        layers.add(new Layers("servicos", "blue"));
        layers.add(new Layers("educativa", "grey"));
        layers.add(new Layers("turistico", "brown"));
        layers.add(new Layers("temporaria", "brown"));
        layers.add(new Layers("null", "black"));
        return layers;
    }


    @Bean("layers2")
    public List<Layers> layers2() throws StreamReadException, DatabindException, IOException {
        List<Layers> layers = new ArrayList<Layers>();
        layers.add(new Layers("boa", "green"));
        layers.add(new Layers("regular", "orange"));
        layers.add(new Layers("ruim", "red"));
        return layers;
    }

}
