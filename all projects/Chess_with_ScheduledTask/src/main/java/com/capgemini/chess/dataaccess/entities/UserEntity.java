package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

//@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;
	private String name;
	private String surname;
	private String email;
	@Lob
	private String aboutMe;
	@Lob
	private String lifeMotto;

	public UserEntity() {

	}

	public UserEntity(long id, String login, String password, String name, String surname, String email, String aboutMe,
			String lifeMotto) {

		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.aboutMe = aboutMe;
		this.lifeMotto = lifeMotto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (id != other.id)
			return false;
		return true;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
