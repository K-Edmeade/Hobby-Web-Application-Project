package com.qa.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.main.domain.Players;

@Repository
public interface PlayerRepo extends JpaRepository<Players, Long> {

	List<Players> findPlayersByLastName(String lastName);

	List<Players> findPlayersByNationality(String nationality);

	List<Players> findPlayersByPosition(String position);

}
