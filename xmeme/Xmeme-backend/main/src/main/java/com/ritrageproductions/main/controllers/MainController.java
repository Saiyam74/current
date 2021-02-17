package com.ritrageproductions.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ritrageproductions.main.dtos.MemeDTO;
import com.ritrageproductions.main.models.Memes;
import com.ritrageproductions.main.services.MainServices;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MainController {
	
	@Autowired
	private MainServices ms;
	
	@PostMapping("/memes")
	@ResponseBody
	public long SubmitMyMeme(@RequestBody MemeDTO meme) {
		return ms.submitMyMeme(meme);
	}
	
	@GetMapping("/memes")
	public List<Memes> showMeMemes() {
		return ms.showThyMemes();
	}
	
	@GetMapping("/memes/{id}")
	@ResponseBody
	public Memes getMemeById(@PathVariable(value="id") String id) {
		long memeId = Long.parseLong(id);
		try {
			return ms.findMemeById(memeId);
		}
		catch(Exception e) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "image not found"
					);
		}
	}
	
	@PatchMapping("/memes/{id}")
	@ResponseBody
	public ResponseStatusException updateMemeById(@PathVariable(value="id") String id, @RequestBody MemeDTO memedto) {
		long memeId = Long.parseLong(id);
		return ms.updateMeme(memeId, memedto);
	}

}
