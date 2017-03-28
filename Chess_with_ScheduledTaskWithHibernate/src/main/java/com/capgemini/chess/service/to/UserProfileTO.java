package com.capgemini.chess.service.to;

import java.io.Serializable;

public class UserProfileTO extends AbstractTo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String login;
	private String email;
	private String aboutMe;
	private String lifeMotto;

	public UserProfileTO() {
		super();
	}

	public UserProfileTO(String login, String name, String surname, String email, String aboutMe, String lifeMotto) {
		super();
		this.login = login;
		this.email = email;
		this.aboutMe = aboutMe;
		this.lifeMotto = lifeMotto;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getLifeMotto() {
		return lifeMotto;
	}

	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

}
