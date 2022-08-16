package com.qa.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.domain.Players;
import com.qa.main.service.PlayerService;



@RestController
@RequestMapping("/players")
@CrossOrigin
public class PlayerController {
	
	private PlayerService service;
	
	
	

	public PlayerController(PlayerService service) {
		super();
		this.service = service;
	}

	// Post Request - Create

	@PostMapping("/create")
	public ResponseEntity<Players> create(@RequestBody Players player) {

		return new ResponseEntity<Players>(this.service.create(player), HttpStatus.CREATED);
	}

	// Get Request - Read

	@GetMapping("/getAll")
	public ResponseEntity<List<Players>> getAll() {
		return new ResponseEntity<List<Players>>(this.service.getAll(), HttpStatus.OK);

	}

	@GetMapping("/getByID/{id}")
	public ResponseEntity<Players> getByID(@PathVariable Long id) {
		return new ResponseEntity<Players>(this.service.getByID(id), HttpStatus.OK);
	}

	@GetMapping("/getByName/{lastName}")
	public ResponseEntity<List<Players>> getByName(@PathVariable String lastName) {
		return new ResponseEntity<List<Players>>(this.service.getByName(lastName), HttpStatus.OK);
	}
	
	@GetMapping("/getByNationality/{nationality}")
	public ResponseEntity<List<Players>> getByNationality(@PathVariable String nationality) {
		return new ResponseEntity<List<Players>>(this.service.getByNationality(nationality), HttpStatus.OK);
	}
	
	@GetMapping("/getByPosition/{position}")
	public ResponseEntity<List<Players>> getByPosition(@PathVariable String position) {
		return new ResponseEntity<List<Players>>(this.service.getByPosition(position), HttpStatus.OK);
	}

	// Put Request - Update

	@PutMapping("/update/{id}")
	public ResponseEntity<Players> update(@PathVariable Long id, @RequestBody Players player) {

		return new ResponseEntity<Players>(this.service.update(id, player), HttpStatus.CREATED);
	}

	// Delete Request - Delete
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return this.service.delete(id);
	}

}
