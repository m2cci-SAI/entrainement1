package fr.kurzen.ConfigBaseSiteWeb.model;

import java.util.List;

public class ClassementChampionchip {

	private List<ClassementEquipe> equipe_liste;

	public ClassementChampionchip() {
		super();
	}

	public ClassementChampionchip(List<ClassementEquipe> equipe_liste) {
		super();
		this.equipe_liste = equipe_liste;
	}

	public List<ClassementEquipe> getEquipe_liste() {
		return equipe_liste;
	}

	public void setEquipe_liste(List<ClassementEquipe> equipe_liste) {
		this.equipe_liste = equipe_liste;
	}

	
	
}
