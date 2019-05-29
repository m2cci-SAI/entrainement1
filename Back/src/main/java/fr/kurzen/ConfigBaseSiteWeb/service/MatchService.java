package fr.kurzen.ConfigBaseSiteWeb.service;



import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import fr.kurzen.ConfigBaseSiteWeb.model.Tout;

@Service
public class MatchService
{
	private Tout tout;
	
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
	public Tout homeVsAway(String homeTeam, String awayTeam) throws JsonParseException, JsonMappingException, IOException
	{  
		String str = null;
		try {
			HttpResponse response = (HttpResponse) Unirest.get("https://apifootball.com/api/?action=get_H2H&firstTeam="+ homeTeam + "&secondTeam="+ awayTeam +"&APIkey=472143ff03cfc2a6d7e22499c80e33feee56a32db55389b329233a696a76eca7")
					   .header("Accept", "application/json")
					   .asJson();
			str = response.getBody().toString();
			 
		} catch (UnirestException e) {
			e.printStackTrace();
			
		}
	
		return objectmapper.readValue(str, Tout.class);
	}
}
