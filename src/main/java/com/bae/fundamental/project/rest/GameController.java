package com.bae.fundamental.project.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.fundamental.project.data.Game;

@RestController
public class GameController {

	private List<Game> games = new ArrayList();

	@PostMapping("/createGame")
	public void createGame(@RequestBody Game game) {
		System.out.println(game);
		this.games.add(game);
	}

	@GetMapping("/getAllGames")
	public List<Game> getAllGames() {
		return this.games;
	}

	@PutMapping("replaceGame/{id}")
	public Game replaceGame(@PathVariable int id, @RequestBody Game newGame) {
		return this.games.set(id, newGame);
	}

	@DeleteMapping("deleteGame/{id}")
	public String deleteGame(@PathVariable int id) {
		this.games.remove(id);
		return "Deleted Game: " + id;
	}
}
