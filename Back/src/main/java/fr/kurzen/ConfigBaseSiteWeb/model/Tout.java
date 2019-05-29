package fr.kurzen.ConfigBaseSiteWeb.model;

import java.util.List;

public class Tout {

	private List<Match> firstTeam_VS_secondTeam;
	private List<Match> firstTeam_lastResults;
	private List<Match> secondTeam_lastResults;
	
	public Tout() {
		super();
	}

	public Tout(List<Match> firstTeam_VS_secondTeam, List<Match> firstTeam_lastResults,
			List<Match> secondTeam_lastResults) {
		super();
		this.firstTeam_VS_secondTeam = firstTeam_VS_secondTeam;
		this.firstTeam_lastResults = firstTeam_lastResults;
		this.secondTeam_lastResults = secondTeam_lastResults;
	}

	public List<Match> getFirstTeam_VS_secondTeam() {
		return firstTeam_VS_secondTeam;
	}

	public void setFirstTeam_VS_secondTeam(List<Match> firstTeam_VS_secondTeam) {
		this.firstTeam_VS_secondTeam = firstTeam_VS_secondTeam;
	}

	public List<Match> getFirstTeam_lastResults() {
		return firstTeam_lastResults;
	}

	public void setFirstTeam_lastResults(List<Match> firstTeam_lastResults) {
		this.firstTeam_lastResults = firstTeam_lastResults;
	}

	public List<Match> getSecondTeam_lastResults() {
		return secondTeam_lastResults;
	}

	public void setSecondTeam_lastResults(List<Match> secondTeam_lastResults) {
		this.secondTeam_lastResults = secondTeam_lastResults;
	}
	
	
}
