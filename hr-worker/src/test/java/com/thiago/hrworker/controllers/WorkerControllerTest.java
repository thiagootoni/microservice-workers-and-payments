package com.thiago.hrworker.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.thiago.hrworker.factory.WorkerFactory;
import com.thiago.hrworker.services.ElementNotFoundException;
import com.thiago.hrworker.services.Interfaces.WorkerService;

@SpringBootTest
@AutoConfigureMockMvc
class WorkerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WorkerService service;
	
	private Long existingId;
	private Long nonExistingId;
	
	@BeforeEach
	void setUp() throws Exception {
		
		existingId = 1L;
		nonExistingId = 1000L;
		
		Mockito.when(this.service.findById(existingId)).thenReturn(WorkerFactory.createWorkerDTO(existingId));
		Mockito.when(this.service.findById(nonExistingId)).thenThrow(new ElementNotFoundException("Elemento não Encontrado"));
	}
	
	@Test
	void findAllShouldReturnStatusOk() throws Exception {
		mockMvc.perform(get("/workers")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	
	}
	
	@Test
	void findByIdShouldReturnStatusOkWhenIdExists() throws Exception {
		mockMvc.perform(get("/workers/{id}", existingId)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	
	}
	
	@Test
	void findByIdShouldReturnElementNotFoundExceptionWhenIdNonExists() throws Exception {
		mockMvc.perform(get("/workers/{id}", nonExistingId)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.message").value("Elemento não Encontrado"));	
	}
	
	

}
