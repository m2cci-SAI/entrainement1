package fr.kurzen.ConfigBaseSiteWeb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import fr.kurzen.ConfigBaseSiteWeb.model.ClassementChampionchip;
import fr.kurzen.ConfigBaseSiteWeb.model.ClassementEquipe;
import fr.kurzen.ConfigBaseSiteWeb.model.Tout;
import fr.kurzen.ConfigBaseSiteWeb.service.ChampionchipService;
import fr.kurzen.ConfigBaseSiteWeb.service.MatchService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/foot")
public class FootHvsAController {
	@Autowired
	private ChampionchipService championchipService;
	private MatchService matchService;
	
	@PostMapping("/homevsaway")
	public Tout getStatMatch() throws JsonParseException, JsonMappingException, IOException {
		return matchService.homeVsAway("Liverpool","arsenal");
	}
	
	@PostMapping("/championchip")
	public List<ClassementEquipe> getClassementCampionchip() throws JsonParseException, JsonMappingException, IOException {
		return championchipService.championchipClassement();
	}
}
