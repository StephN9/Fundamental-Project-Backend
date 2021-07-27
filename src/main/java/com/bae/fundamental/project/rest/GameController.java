package com.bae.fundamental.project.rest;

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
import org.springframework.web.bind.annotation.RestController;

import com.bae.fundamental.project.data.Game;
import com.bae.fundamental.project.service.GameService;

@RestController
@CrossOrigin
public class GameController {

	private GameService service;

	public GameController(GameService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createGame")
	public ResponseEntity<Game> createGame(@RequestBody Game game) {
		Game created = this.service.createGame(game);
		return new ResponseEntity<>(created, HttpStatus.CREATED);

	}

	@GetMapping("/getAllGames")
	public List<Game> getAllGames() {
		return this.service.getAllGames();
	}

	@PutMapping("replaceGame/{id}")
	public ResponseEntity<Game> replaceGame(@PathVariable int id, @RequestBody Game newGame) {
		Game body = this.service.replaceGame(id, newGame);
		return new ResponseEntity<Game>(body, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("deleteGame/{id}")
	public ResponseEntity<String> deleteGame(@PathVariable int id) {
		String body = this.service.deleteGame(id);
		return new ResponseEntity<String>(body, HttpStatus.NO_CONTENT);

	}

	@GetMapping("/getByName/{name}")
	public List<Game> getByName(@PathVariable String name) {
		return this.service.getByName(name);
	}

	@GetMapping("/getByGenre/{genre}")
	public List<Game> getByGenre(@PathVariable String genre) {
		return this.service.getByGenre(genre);
	}

	@GetMapping("/getByPlayerType/{playerType}")
	public List<Game> getByPlayerType(@PathVariable String playerType) {
		return this.service.getByPlayerType(playerType);
	}

	@GetMapping("/getByPlatform/{platform}")
	public List<Game> getByPlatform(@PathVariable String platform) {
		return this.service.getByPlatform(platform);
	}

}
