package com.bae.fundamental.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.fundamental.project.data.Game;

@Service
public class GameServiceList implements GameService {

	private List<Game> games = new ArrayList<>();

	@Override
	public Game createGame(Game game) {
		this.games.add(game);
		System.out.println(game);
		return this.games.get(this.games.size() - 1);
	}

	@Override
	public List<Game> getAllGames() {
		return this.games;
	}

	@Override
	public Game replaceGame(int id, Game newGame) {
		return this.games.set(id, newGame);
	}

	@Override
	public Game getGame(int id) {
		Game found = this.games.get(id);
		return found;
	}

	@Override
	public String deleteGame(int id) {
		this.games.remove(id);
		return "Game at index " + id + " is deleted";
	}

	@Override
	public List<Game> getByName(String name) {
		return null;
	}

	@Override
	public List<Game> getByGenre(String genre) {
		return null;
	}

	@Override
	public List<Game> getByPlayerType(String playerType) {
		return null;
	}

	@Override
	public List<Game> getByPlatform(String platform) {
		return null;
	}

}
