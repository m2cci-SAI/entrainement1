package fr.kurzen.ConfigBaseSiteWeb.controller;

import java.io.IOException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;

import fr.kurzen.ConfigBaseSiteWeb.model.Tout;

import fr.kurzen.ConfigBaseSiteWeb.service.MatchService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/foothvsa")
public class FootHvsAController {
	@Autowired
	private MatchService matchService;
	
	@PostMapping("/")
	public Tout getStatMatch() throws JsonParseException, JsonMappingException, IOException {
		return matchService.homeVsAway("Liverpool","arsenal");
	}
}
