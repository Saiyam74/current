package com.ritrageproductions.main.impls;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ritrageproductions.main.dtos.MemeDTO;
import com.ritrageproductions.main.models.Memes;
import com.ritrageproductions.main.repositories.MemeRepository;
import com.ritrageproductions.main.services.MainServices;

@Service
public class MainServiceImpl implements MainServices {
	
	@Autowired
	private MemeRepository mr;

	@Override
	public long submitMyMeme(MemeDTO meme) {
		long id = mr.count()+1;
		Memes memeToSave = new Memes(id,meme.getName(), meme.geturl(), meme.getCaption());
		mr.save(memeToSave);
		return id;
	}

	@Override
	public List<Memes> showThyMemes() {
		Stack<Memes> allmemes = new Stack<>();
		long totMemes = mr.count();
		if(totMemes==0) return allmemes;
		if(totMemes<=100) {
			for(Memes meme: mr.findAll()) {
				allmemes.push(meme);
			}
		}
		else {
			for(Memes meme: mr.findAll()) {
				if(meme.getid()<=totMemes && meme.getid()>(totMemes-100)) allmemes.push(meme);
			}
		}
		List<Memes> reverseList = new ArrayList<>();
		while(!allmemes.isEmpty()) {
			reverseList.add(allmemes.pop());
		}
		return reverseList;
	}

	@Override
	public Memes findMemeById(long memeId) throws Exception {
		if(!mr.existsById(memeId)) throw new Exception();
		for(Memes meme: mr.findAll()) {
			if(meme.getid()==memeId) return meme;
		}
		return null;
	}
	
	@Override
	public ResponseStatusException updateMeme(long id, MemeDTO memedto) {
		if(!mr.existsById(id))
			return new ResponseStatusException(HttpStatus.NOT_FOUND, "meme not found");
		if(memedto.getName()!=null)
			return new ResponseStatusException(HttpStatus.NOT_MODIFIED, "name cannot be changed");
		if(memedto.geturl().equals("") && memedto.getCaption().equals("")) 
			return new ResponseStatusException(HttpStatus.NO_CONTENT, "nothing to change");
		for(Memes meme: mr.findAll()) {
			if(meme.getid()==id) {
				Memes temp = new Memes(id, meme.getName(), memedto.geturl().equals("")?meme.geturl():memedto.geturl(), memedto.getCaption().equals("")?meme.getCaption():memedto.getCaption());
				mr.save(temp);
				return new ResponseStatusException(HttpStatus.OK);
			}
		}
		return new ResponseStatusException(HttpStatus.NOT_FOUND, "meme not found");
	}

}
