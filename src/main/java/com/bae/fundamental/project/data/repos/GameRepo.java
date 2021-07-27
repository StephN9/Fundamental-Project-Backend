package com.bae.fundamental.project.data.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.fundamental.project.data.Game;

@Repository
public interface GameRepo extends JpaRepository<Game, Integer> {

	List<Game> findByNameIgnoreCase(String name);

	List<Game> findByGenreIgnoreCase(String genre);

	List<Game> findByPlayerTypeIgnoreCase(String playerType);

	List<Game> findByPlatformIgnoreCase(String platform);

}
