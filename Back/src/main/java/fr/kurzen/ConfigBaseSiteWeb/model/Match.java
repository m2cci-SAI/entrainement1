package fr.kurzen.ConfigBaseSiteWeb.model;

public class Match {

	private long match_id;
	private long country_id;
	private String country_name;
	private long league_id;
	private String league_name;
	private String match_date;
	private String match_status;
	private String match_time;
	private String match_hometeam_name;
	private long match_hometeam_score;
	private String match_awayteam_name;
	private long match_awayteam_score;
	private long match_hometeam_halftime_score;
	private long match_awayteam_halftime_score;
	private String match_live;
	
	public Match() {
		super();
	}

	public Match(long match_id, long country_id, String country_name, long league_id, String league_name,
			String match_date, String match_status, String match_time, String match_hometeam_name,
			long match_hometeam_score, String match_awayteam_name, long match_awayteam_score,
			long match_hometeam_halftime_score, long match_awayteam_halftime_score, String match_live) {
		super();
		this.match_id = match_id;
		this.country_id = country_id;
		this.country_name = country_name;
		this.league_id = league_id;
		this.league_name = league_name;
		this.match_date = match_date;
		this.match_status = match_status;
		this.match_time = match_time;
		this.match_hometeam_name = match_hometeam_name;
		this.match_hometeam_score = match_hometeam_score;
		this.match_awayteam_name = match_awayteam_name;
		this.match_awayteam_score = match_awayteam_score;
		this.match_hometeam_halftime_score = match_hometeam_halftime_score;
		this.match_awayteam_halftime_score = match_awayteam_halftime_score;
		this.match_live = match_live;
	}

	public long getMatch_id() {
		return match_id;
	}

	public void setMatch_id(long match_id) {
		this.match_id = match_id;
	}

	public long getCountry_id() {
		return country_id;
	}

	public void setCountry_id(long country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public long getLeague_id() {
		return league_id;
	}

	public void setLeague_id(long league_id) {
		this.league_id = league_id;
	}

	public String getLeague_name() {
		return league_name;
	}

	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}

	public String getMatch_date() {
		return match_date;
	}

	public void setMatch_date(String match_date) {
		this.match_date = match_date;
	}

	public String getMatch_status() {
		return match_status;
	}

	public void setMatch_status(String match_status) {
		this.match_status = match_status;
	}

	public String getMatch_time() {
		return match_time;
	}

	public void setMatch_time(String match_time) {
		this.match_time = match_time;
	}

	public String getMatch_hometeam_name() {
		return match_hometeam_name;
	}

	public void setMatch_hometeam_name(String match_hometeam_name) {
		this.match_hometeam_name = match_hometeam_name;
	}

	public long getMatch_hometeam_score() {
		return match_hometeam_score;
	}

	public void setMatch_hometeam_score(long match_hometeam_score) {
		this.match_hometeam_score = match_hometeam_score;
	}

	public String getMatch_awayteam_name() {
		return match_awayteam_name;
	}

	public void setMatch_awayteam_name(String match_awayteam_name) {
		this.match_awayteam_name = match_awayteam_name;
	}

	public long getMatch_awayteam_score() {
		return match_awayteam_score;
	}

	public void setMatch_awayteam_score(long match_awayteam_score) {
		this.match_awayteam_score = match_awayteam_score;
	}

	public long getMatch_hometeam_halftime_score() {
		return match_hometeam_halftime_score;
	}

	public void setMatch_hometeam_halftime_score(long match_hometeam_halftime_score) {
		this.match_hometeam_halftime_score = match_hometeam_halftime_score;
	}

	public long getMatch_awayteam_halftime_score() {
		return match_awayteam_halftime_score;
	}

	public void setMatch_awayteam_halftime_score(long match_awayteam_halftime_score) {
		this.match_awayteam_halftime_score = match_awayteam_halftime_score;
	}

	public String getMatch_live() {
		return match_live;
	}

	public void setMatch_live(String match_live) {
		this.match_live = match_live;
	}
	
}
