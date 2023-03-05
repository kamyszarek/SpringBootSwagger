package pl.arkadiusz.SpringAndSwagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.arkadiusz.SpringAndSwagger.model.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringAndSwaggerApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;


	@Test
	void shouldGetUser() throws Exception {

		mockMvc.perform(get("/user/1"))
				.andDo(print())
				.andExpect(status().is(200))
				.andExpect(jsonPath("$.name", Matchers.is("Jan")));
	}


	@Test
	void shouldGetUser2() throws Exception {

		MvcResult mvcResult = mockMvc.perform(get("/user/1"))
				.andDo(print())
				.andExpect(status().is(200))
				.andReturn();
		User user = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), User.class);
		assertThat(user).isNotNull();
		assertThat(user.getId()).isEqualTo(1L);
		assertThat(user.getName()).isEqualTo("Jan");
	}



}
