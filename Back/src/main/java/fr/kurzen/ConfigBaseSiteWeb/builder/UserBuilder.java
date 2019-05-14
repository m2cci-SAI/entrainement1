package fr.kurzen.ConfigBaseSiteWeb.builder;

public class UserBuilder {
	private	String pseudo;
	
	private String password;

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String username) {
		this.pseudo = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserBuilder(String pseudo, String password) {
		super();
		this.pseudo = pseudo;
		this.password = password;
	}

	public UserBuilder() {
		super();
	}

	@Override
	public String toString() {
		return "LoginRequest [pseudo=" + pseudo + ", password=" + password + "]";
	}

	
}
