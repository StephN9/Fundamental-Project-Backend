package com.bae.fundamental.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.fundamental.project.data.Game;
import com.bae.fundamental.project.data.repos.GameRepo;

@Service
public class GameServiceDB implements GameService {

	private GameRepo repo;

	public GameServiceDB(GameRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Game createGame(Game game) {
		return this.repo.save(game);

	}

	@Override
	public List<Game> getAllGames() {
		return this.repo.findAll();

	}

	@Override
	public Game replaceGame(int id, Game newGame) {
		Game found = this.repo.findById(id).get();

		System.out.println("FOUND " + found);

		found.setName(newGame.getName());
		found.setPlatform(newGame.getPlatform());
		found.setGenre(newGame.getGenre());
		found.setPlayerType(newGame.getPlayerType());

		Game updatedGame = this.repo.save(found);
		return updatedGame;

	}

	@Override
	public String deleteGame(int id) {
		this.repo.deleteById(id);

		if (this.repo.existsById(id)) {
			return id + " Not deleted";
		} else {
			return id + "deleted";
		}

	}

	@Override
	public List<Game> getByName(String name) {
		return this.repo.findByNameIgnoreCase(name);
	}

}
