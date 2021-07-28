package com.bae.fundamental.project.data;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;
	private String platform;
	private String genre;
	private String playerType;

	public Game(int id, String name, String platform, String genre, String playerType) {
		super();
		this.id = id;
		this.name = name;
		this.platform = platform;
		this.genre = genre;
		this.playerType = playerType;
	}

	public Game(String name, String platform, String genre, String playerType) {
		super();
		this.name = name;
		this.platform = platform;
		this.genre = genre;
		this.playerType = playerType;
	}

	public Game() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(genre, id, name, platform, playerType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Game other = (Game) obj;
		return Objects.equals(genre, other.genre) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(platform, other.platform) && Objects.equals(playerType, other.playerType);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	@Override
	public String toString() {
		return "Game [name=" + name + ", platform=" + platform + ", genre=" + genre + ", playerType=" + playerType
				+ "]";
	}

}
