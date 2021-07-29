package com.bae.fundamental.project.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.bae.fundamental.project.data.Game;
import com.bae.fundamental.project.data.repos.GameRepo;

@SpringBootTest
@ActiveProfiles("test")
public class GameServiceDBUnitTest {

	@Autowired
	private GameServiceDB service;

	@MockBean
	private GameRepo repo;

	@Test
	void testCreate() {
		Game newGame = new Game("Witcher", "PS4", "Fantasy", "Singleplayer");

		Game savedGame = new Game(1, "Witcher", "PS4", "Fantasy", "Singleplayer");

		Mockito.when(this.repo.save(newGame)).thenReturn(savedGame);

		assertThat(this.service.createGame(newGame)).isEqualTo(savedGame);

		Mockito.verify(this.repo, Mockito.times(1)).save(newGame);
		Mockito.verifyNoMoreInteractions(this.repo);

	}

	@Test
	void testUpdate() {
		int id = 1;

		Game testGame = new Game(id, "Stardew Valley", "PC", "Farming", "Both");
		Game testNewGame = new Game(id, "Witcher 3", "PS4", "Fantasy", "Singleplayer");

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(testGame));
		Mockito.when(this.repo.save(new Game(id, "Witcher 3", "PS4", "Fantasy", "Singleplayer")))
				.thenReturn(testNewGame);

		Game actual = this.service.replaceGame(id, testNewGame);

		assertThat(actual).isEqualTo(testNewGame);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(new Game(id, "Witcher 3", "PS4", "Fantasy", "Singleplayer"));
		Mockito.verifyNoMoreInteractions(this.repo);
	}

	@Test
	void testGetAll() {
		List<Game> testGames = List.of(new Game(1, "Witcher 3", "PS4", "Fantasy", "Singleplayer"));
		Mockito.when(this.repo.findAll()).thenReturn(testGames);

		assertThat(this.service.getAllGames()).isEqualTo(testGames);

		assertThat(testGames.size()).isEqualTo(1);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		Mockito.verifyNoMoreInteractions(this.repo);
		;
	}

	@Test
	void testDeleteWorks() {
		int id = 1;
		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.deleteGame(id)).isEqualTo("Game at index " + id + " is deleted");
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);

	}

	@Test
	void testDeleteFails() {
		int id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(true);

		assertThat(this.service.deleteGame(id)).isEqualTo(id + " Not deleted");
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);

	}

	@Test
	void testGetAllByName() {
		List<Game> testGames = List.of(new Game(1, "Witcher", "PS4", "Fantasy", "Singleplayer"));

		String search = "witcher";
		Mockito.when(this.repo.findByNameIgnoreCase(search)).thenReturn(testGames);
		assertThat(this.service.getByName(search)).isEqualTo(testGames);
		assertThat(testGames.size()).isEqualTo(1);

		Mockito.verify(this.repo, Mockito.times(1)).findByNameIgnoreCase(search);
		Mockito.verifyNoMoreInteractions(this.repo);
	}

	@Test
	void testGetAllByPlatform() {
		List<Game> testGames = List.of(new Game(1, "Ark", "PC", "Open-world", "Singleplayer"));

		String search = "PC";
		Mockito.when(this.repo.findByPlatformIgnoreCase(search)).thenReturn(testGames);
		assertThat(this.service.getByPlatform(search)).isEqualTo(testGames);
		assertThat(testGames.size()).isEqualTo(1);

		Mockito.verify(this.repo, Mockito.times(1)).findByPlatformIgnoreCase(search);
		Mockito.verifyNoMoreInteractions(this.repo);
	}

	@Test
	void testGameByGenre() {
		List<Game> testGames = List.of(new Game(1, "Stardew Valley", "PC", "Farming", "Both"));

		String search = "Farming";
		Mockito.when(this.repo.findByPlatformIgnoreCase(search)).thenReturn(testGames);
		assertThat(this.service.getByPlatform(search)).isEqualTo(testGames);
		assertThat(testGames.size()).isEqualTo(1);

		Mockito.verify(this.repo, Mockito.times(1)).findByPlatformIgnoreCase(search);
		Mockito.verifyNoMoreInteractions(this.repo);
	}

	@Test
	void testGameByPlayerType() {
		List<Game> testGames = List.of(new Game(1, "Stardew Valley", "PC", "Farming", "Both"));

		String search = "Both";
		Mockito.when(this.repo.findByPlatformIgnoreCase(search)).thenReturn(testGames);
		assertThat(this.service.getByPlatform(search)).isEqualTo(testGames);
		assertThat(testGames.size()).isEqualTo(1);

		Mockito.verify(this.repo, Mockito.times(1)).findByPlatformIgnoreCase(search);
		Mockito.verifyNoMoreInteractions(this.repo);
	}

	@Test
	void testGetByIdSuccess() throws Exception {
		Game game = new Game(1, "Stardew Valley", "PC", "Farming", "Both");

		Mockito.when(this.repo.findById(1)).thenReturn(Optional.of(game));
		assertThat(this.service.getGame(1)).isEqualTo(game);

		Mockito.verify(this.repo, Mockito.times(1)).findById(1);
		Mockito.verifyNoMoreInteractions(this.repo);
	}

}
