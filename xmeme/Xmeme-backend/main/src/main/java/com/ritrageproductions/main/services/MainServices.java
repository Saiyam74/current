package com.ritrageproductions.main.services;

import java.util.List;

import org.springframework.web.server.ResponseStatusException;

import com.ritrageproductions.main.dtos.MemeDTO;
import com.ritrageproductions.main.models.Memes;

public interface MainServices {

	public long submitMyMeme(MemeDTO meme);

	public List<Memes> showThyMemes();

	public Memes findMemeById(long memeId) throws Exception;

	public ResponseStatusException updateMeme(long memeId, MemeDTO memedto);

}
