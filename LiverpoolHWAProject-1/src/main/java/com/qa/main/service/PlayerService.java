package com.qa.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.main.domain.Players;
import com.qa.main.repo.PlayerRepo;

@Service
public class PlayerService {
	
	private PlayerRepo repo;

	public PlayerService(PlayerRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Players create( Players player) {
    	return this.repo.saveAndFlush(player);
    }


    public List<Players> getAll() {
    	return this.repo.findAll();
        
  
    }
 
 public Players getByID( Long id) {
	 return repo.findById(id).get();
	 
 }
 
 public  List<Players> getByName(String lastName) {
	return repo.findPlayersByLastName(lastName); 
 };
 
 public List<Players> getByNationality(String nationality) {
	return repo.findPlayersByNationality(nationality); 
 };
 
 public List<Players> getByPosition(String position) {
		return repo.findPlayersByPosition(position); 
	 };


    public Players update( Long Id, Players player) {
        // We get the existing entry
        Players existing = repo.findById(Id).get();
        // Update the existing entry, to match the incoming object
        existing.setFirstName(player.getFirstName());
        existing.setLastName(player.getLastName());
        existing.setDateOfBirth(player.getDateOfBirth());
        existing.setTransferFee(player.getTransferFee());
        existing.setNationality(player.getNationality());
        existing.setPosition(player.getPosition());
         // Save the updated entry back into the DB (Id will stay the same)
        return repo.saveAndFlush(existing);
    }
 


 public boolean delete( Long id) {
	 repo.deleteById(id);
	 return !repo.existsById(id);
 }


}
