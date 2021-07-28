package com.bae.fundamental.project.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.fundamental.project.data.Game;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:game-schema.sql",
		"classpath:game-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class GameControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {

		Game testGame = new Game("Witcher", "PS4", "Fantasy", "Single Player");

		String testGameAsJSON = this.mapper.writeValueAsString(testGame);

		RequestBuilder request = post("/createGame").contentType(MediaType.APPLICATION_JSON).content(testGameAsJSON);
		System.out.println(testGame);
		System.out.println(testGameAsJSON);

		ResultMatcher checkStatus = status().isCreated();

		Game testCreatedGame = new Game("Witcher", "PS4", "Fantasy", "Single Player");
		testCreatedGame.setId(2);
		String testCreatedGameAsJSON = this.mapper.writeValueAsString(testCreatedGame);

		ResultMatcher checkBody = content().json(testCreatedGameAsJSON);

		this.mockMVC.perform(request).andExpect(checkBody).andExpect(checkStatus);

	}

	@Test
	void testGetAllGames() throws Exception {

		RequestBuilder request = get("/getAllGames");

		Game testGame = new Game("Witcher 3", "PS4", "Fantasy", "Single Player");
		testGame.setId(1);

		List<Game> testGames = new ArrayList<Game>();
		testGames.add(testGame);

		System.out.println(testGames);
		String testGamesJSON = this.mapper.writeValueAsString(testGames);

		ResultMatcher checkStatus = status().is(200);
		ResultMatcher checkBody = content().json(testGamesJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testDelete() throws Exception {

		RequestBuilder request = delete("/deleteGame/1");

		ResultMatcher checkStatus = status().is(204);
		ResultMatcher checkBody = content().string("Game at index 1 is deleted");

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testReplaceGame() throws Exception {

		int id = 1;
		Game game = new Game(id, "Witcher", "PS4", "Fantasy", "Single Player");

		String gameAsJSON = this.mapper.writeValueAsString(game);
		System.out.println("Hello");

		RequestBuilder request = put("/replaceGame/" + id).contentType(MediaType.APPLICATION_JSON).content(gameAsJSON);
		System.out.println("Hello");
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(gameAsJSON);
		System.out.println("Hello");
		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void findById() throws Exception {
		RequestBuilder req = get("/getGame/1");

		ResultMatcher checkStatus = status().isOk();

		Game testGame = new Game(1, "Witcher 3", "PS4", "Fantasy", "Single Player");

		String testGameAsJSON = this.mapper.writeValueAsString(testGame);

		ResultMatcher checkBody = content().json(testGameAsJSON);

		this.mockMVC.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testFindByName() throws Exception {
		RequestBuilder request = get("/getByName/Witcher 3");

		ResultMatcher checkStatus = status().isOk();

		List<Game> testGames = List.of(new Game(1, "Witcher 3", "PS4", "Fantasy", "Single Player"));

		String testGameAsJSON = this.mapper.writeValueAsString(testGames);

		ResultMatcher checkBody = content().json(testGameAsJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

}
