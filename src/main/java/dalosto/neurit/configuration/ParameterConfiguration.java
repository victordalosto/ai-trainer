package dalosto.neurit.configuration;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dalosto.neurit.model.Parameter;


@Configuration
public class ParameterConfiguration {

    private List<Parameter> marcacoes = new ArrayList<>();


    @Bean
    public List<Parameter> marcacoes() {
        marcacoes.add(new Parameter("Regulamentacao", "red"));
        marcacoes.add(new Parameter("Advertencia", "rgb(225, 169, 24)"));
        marcacoes.add(new Parameter("Indicativa", "green"));
        marcacoes.add(new Parameter("Servicos", "blue"));
        marcacoes.add(new Parameter("Educativa", "grey"));
        marcacoes.add(new Parameter("Turistico", "brown"));
        marcacoes.add(new Parameter("Null", "black"));
        return this.marcacoes;
    }

}
