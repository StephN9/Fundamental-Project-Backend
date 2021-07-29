package com.bae.fundamental.project.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bae.fundamental.project.data.Game;
import com.bae.fundamental.project.data.repos.GameRepo;

@Service
@Primary
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
	public Game getGame(int id) {
		Game found = this.repo.findById(id).get();
		return found;
	}

	@Override
	public Game replaceGame(int id, Game newGame) {

		Game found = this.repo.findById(id).get();

		found.setName(newGame.getName());
		found.setPlatform(newGame.getPlatform());
		found.setGenre(newGame.getGenre());
		found.setPlayerType(newGame.getPlayerType());

		Game updated = this.repo.save(found);
		return updated;

	}

	@Override
	public String deleteGame(int id) {
		this.repo.deleteById(id);

		if (this.repo.existsById(id)) {
			return id + " Not deleted";
		} else {
			return "Game at index " + id + " is deleted";
		}

	}

	@Override
	public List<Game> getByName(String name) {
		return this.repo.findByNameIgnoreCase(name);
	}

	@Override
	public List<Game> getByGenre(String genre) {
		return this.repo.findByGenreIgnoreCase(genre);
	}

	@Override
	public List<Game> getByPlayerType(String playerType) {
		return this.repo.findByPlayerTypeIgnoreCase(playerType);
	}

	@Override
	public List<Game> getByPlatform(String platform) {
		return this.repo.findByPlatformIgnoreCase(platform);
	}

}
