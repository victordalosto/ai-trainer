package inframachine.trainer.configuration;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import inframachine.trainer.model.Parameter;


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
        classifications.add(new Parameter("boa", "green"));
        classifications.add(new Parameter("regular", "orange"));
        classifications.add(new Parameter("ruim", "red"));
        return this.classifications;
    }

}
