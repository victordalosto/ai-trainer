package infralearning.trainer;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class NeuritApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(get("/"))
			   .andExpect(status().isOk())
			   .andExpect(view().name("home"))
			   .andExpect(content().string(containsString("AI Trainer")));
	}

}
