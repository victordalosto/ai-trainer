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
        parameters.add(new Parameter("regulamentacao", "red"));
        parameters.add(new Parameter("advertencia", "rgb(225, 169, 24)"));
        parameters.add(new Parameter("indicativa", "green"));
        parameters.add(new Parameter("servicos", "blue"));
        parameters.add(new Parameter("educativa", "grey"));
        parameters.add(new Parameter("turistico", "brown"));
        parameters.add(new Parameter("temporaria", "brown"));
        parameters.add(new Parameter("null", "black"));
        return this.parameters;
    }


    @Bean("classifications")
    public List<Parameter> classifications() {
        classifications.add(new Parameter("boa", "Green"));
        classifications.add(new Parameter("regular", "Orange"));
        classifications.add(new Parameter("ruim", "Red"));
        return this.classifications;
    }

}
