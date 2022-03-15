package com.dio.devweek;


import com.dio.devweek.controller.ControllerRegiao;
import com.dio.devweek.entities.Regiao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DevweekApplicationTests {

	private final String URL = "/api/regioes";

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ControllerRegiao controller;

	//listando objetos
	@Test
	public void getControllerTest() throws Exception {
		mockMvc.perform(get(URL))
				.andExpect(status().isOk());
	}

	@Test
	public void getByIdControllerTest() throws Exception {
		mockMvc.perform(get(URL+"/1"))
				.andExpect(status().isOk());
	}

	// method not allowed
	@Test
	public void addNewRegiaoTest() throws Exception {
		Regiao newRegiao = new Regiao(99L, "Noroeste", 57);
		mockMvc.perform(post(URL+"/novo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newRegiao)))
				.andExpect(status().isOk());
	}

	// method not allowed
	@Test
	public void deleteByIdRegiaoTest() throws Exception {
		mockMvc.perform(delete(URL+"/delete/{id}","1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	private static String asJsonString(final Object obj) {
		try{
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e){
			throw new RuntimeException();
		}
	}
}
