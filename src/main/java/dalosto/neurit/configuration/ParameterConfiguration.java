package dalosto.neurit.configuration;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dalosto.neurit.model.Parameter;


@Configuration
public class ParameterConfiguration {

    private List<Parameter> parameters = new ArrayList<>();
    private List<Parameter> classifications = new ArrayList<>();


    @Bean("parameters")
    public List<Parameter> parameters() {
        parameters.add(new Parameter("Regulamentacao", "red"));
        parameters.add(new Parameter("Advertencia", "rgb(225, 169, 24)"));
        parameters.add(new Parameter("Indicativa", "green"));
        parameters.add(new Parameter("Servicos", "blue"));
        parameters.add(new Parameter("Educativa", "grey"));
        parameters.add(new Parameter("Turistico", "brown"));
        parameters.add(new Parameter("Null", "black"));
        return this.parameters;
    }


    @Bean("classifications")
    public List<Parameter> classifications() {
        classifications.add(new Parameter("Boa", "Green"));
        classifications.add(new Parameter("Regular", "Orange"));
        classifications.add(new Parameter("Ruim", "Red"));
        return this.classifications;
    }

}
