package fr.kurzen.ConfigBaseSiteWeb.service;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;

import fr.kurzen.ConfigBaseSiteWeb.model.ClassementChampionchip;
import fr.kurzen.ConfigBaseSiteWeb.model.ClassementEquipe;

@Service
public class ChampionchipService
{
	
	@Autowired
	private ObjectMapper objectmapper;
	
/**
 * Method qui fait l'appel à l'API avec la fonction H_Vs_A
 * @param homeTeam la premiére equipes
 * @param awayTeam la deuxiéme équipes
 * @return  le resultat des matchs
 * @throws IOException 
 * @throws JsonMappingException 
 * @throws JsonParseException 
 */
	public List<ClassementEquipe> championchipClassement() throws JsonParseException, JsonMappingException, IOException
	{  
		String str = null;
		try {
			HttpResponse response = (HttpResponse) Unirest.get("https://apifootball.com/api/?action=get_standings&league_id=63&APIkey=472143ff03cfc2a6d7e22499c80e33feee56a32db55389b329233a696a76eca7")
					   .header("Accept", "application/json")
					   .asJson();
			str = response.getBody().toString();
			 
		} catch (UnirestException e) {
			e.printStackTrace();
			
		}

	
		return objectmapper.readValue(str, new TypeReference<List<ClassementEquipe>>(){});
	}
}
