package com.qa.main.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.Players;
import com.qa.main.repo.PlayerRepo;

@SpringBootTest
public class PlayerServiceUnitTest {
	
	@Autowired
	private PlayerService service;
	
	@MockBean
	private PlayerRepo repo;
	
	@Test
	public void testCreate() {
		// Create and object for saving
		Players entry = new Players("Kya", "edmeade", "31/03/99", 670000, "english", "position");
		
		// Create an object for the result
		Players result = new Players(2L, "Kya", "edmeade", "31/03/99", 670000, "english", "position");
		
		Mockito.when(repo.saveAndFlush(entry)).thenReturn(result);
		
		assertEquals(result, service.create(entry));
	}
	
	@Test
	public void testGetAll() {
		// Create and object for saving
		List<Players> result = new ArrayList<>();
		result.add(new Players(1L,"Kya", "edmeade", "31/03/99", 670000, "english", "position"));

		Mockito.when(repo.findAll()).thenReturn(result);
		
		assertEquals(result, service.getAll());
	}
	
	@Test
	public void testGetById() {
		// Create and object for saving
		Players result = new Players(1L,"Kya", "edmeade", "31/03/99", 670000, "english", "position");
		Optional<Players> result1 = Optional.of(result);

		Mockito.when(repo.findById(1L)).thenReturn(result1);
		
		assertEquals(result, service.getByID(1L));
	}
	
	@Test
	public void testGetByName() {
		// Create and object for saving
		List<Players> result = new ArrayList<>();
		result.add(new Players(1L,"Kya", "edmeade", "31/03/99", 670000, "english", "position"));
		

		Mockito.when(repo.findPlayersByLastName("edmeade")).thenReturn(result);
		
		assertEquals(result, service.getByName("edmeade"));
	}
	
	@Test
	public void testGetByNationality() {
		// Create and object for saving
		List<Players> result = new ArrayList<>();
		result.add(new Players(1L,"Kya", "edmeade", "31/03/99", 670000, "english", "position"));
		

		Mockito.when(repo.findPlayersByNationality("english")).thenReturn(result);
		
		assertEquals(result, service.getByNationality("english"));
	}
	
	@Test
	public void testGetByPosition() {
		// Create and object for saving
		List<Players> result = new ArrayList<>();
		result.add(new Players(1L,"Kya", "edmeade", "31/03/99", 670000, "english", "position"));
		

		Mockito.when(repo.findPlayersByPosition("position")).thenReturn(result);
		
		assertEquals(result, service.getByPosition("position"));
	}
	
	@Test
	public void testUpdate() {
		Optional<Players> original = Optional.of(new Players(1L,"Kya", "edmeade", "31/03/99", 670000, "english", "position"));
		Players player = new Players("Kya", "edmeade", "31/03/99", 670000000, "english", "RW");
		Players updated = new Players(1L,"Kya", "edmeade", "31/03/99", 670000000, "english", "RW");
		
		Mockito.when(repo.findById(1L)).thenReturn(original);
		Mockito.when(repo.saveAndFlush(updated)).thenReturn(updated);
		
		assertEquals(updated, service.update(1L, player));
	}
	
	@Test
	public void testDelete() {
		
		
		Mockito.when(repo.existsById(1L)).thenReturn(false);
		
		assertTrue(service.delete(1L));
	}
}
