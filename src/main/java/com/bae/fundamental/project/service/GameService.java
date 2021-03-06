package com.bae.fundamental.project.service;

import java.util.List;

import com.bae.fundamental.project.data.Game;

public interface GameService {

	public Game createGame(Game game);

	public List<Game> getAllGames();

	public Game getGame(int id);

	public Game replaceGame(int id, Game newGame);

	public String deleteGame(int id);

	List<Game> getByName(String name);

	List<Game> getByGenre(String genre);

	List<Game> getByPlayerType(String playerType);

	List<Game> getByPlatform(String platform);

}
