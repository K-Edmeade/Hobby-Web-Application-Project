package com.qa.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Players;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testschema.sql",
		"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PlayersIntergrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception{
		Players entry = new Players("Kya", "edmeade", "31/03/99", 670000, "english", "position");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Players result = new Players(2L, "Kya", "edmeade", "31/03/99", 670000, "english", "position");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(post("/players/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}
	@Test
	public void readAllTest() throws Exception{
		
		List<Players> result = new ArrayList<>();
		result.add(new Players(1L, "Alisson", "Becker", "02/10/92", 66800000, "Brazil", "GK"));
		
String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/players/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void readById() throws Exception{
		
		Players result = new Players(1L,"Alisson", "Becker", "02/10/92", 66800000, "Brazil", "GK");
		
		
		
		String resultAsJSON = mapper.writeValueAsString(result);
		mvc.perform(get("/players/getByID/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	@Test
	public void readByName() throws Exception{
		List<Players> result = new ArrayList<>();
		result.add( new Players(1L,"Alisson", "Becker", "02/10/92", 66800000, "Brazil", "GK"));
		
		
		
		String resultAsJSON = mapper.writeValueAsString(result);
		mvc.perform(get("/players/getByName/Becker")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	@Test
	public void readByPosition() throws Exception{
		List<Players> result = new ArrayList<>();
		result.add( new Players(1L,"Alisson", "Becker", "02/10/92", 66800000, "Brazil", "GK"));
		
		
		
		String resultAsJSON = mapper.writeValueAsString(result);
		mvc.perform(get("/players/getByPosition/GK")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void readByNationality() throws Exception{
		List<Players> result = new ArrayList<>();
		result.add( new Players(1L,"Alisson", "Becker", "02/10/92", 66800000, "Brazil", "GK"));
		
		
		
		String resultAsJSON = mapper.writeValueAsString(result);
		mvc.perform(get("/players/getByNationality/Brazil")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	

	@Test
	public void updateTest() throws Exception{
		Players entry = new Players("Alisson", "Becker", "02/10/92", 66800000, "Brazil", "GK");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Players result = new Players(1L,"Alisson", "Becker", "02/10/92", 66800000, "Brazil", "GK");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(put("/players/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));}
	
	
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/players/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
