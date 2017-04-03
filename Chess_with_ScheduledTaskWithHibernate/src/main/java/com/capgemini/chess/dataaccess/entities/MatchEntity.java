package com.capgemini.chess.dataaccess.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.chess.enumerated.ResultMatch;

@Entity
@Table(name = "matchs")
public class MatchEntity extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = true)
	private ResultMatch result;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntity user1;
	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntity user2;

	public MatchEntity() {
		super();
	}

	public MatchEntity(ResultMatch result, UserEntity userId, UserEntity userId2) {

		this.result = result;
		this.user1 = userId;
		this.user2 = userId2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ResultMatch getResult() {
		return result;
	}

	public void setResult(ResultMatch result) {
		this.result = result;
	}

	public UserEntity getUser1() {
		return user1;
	}

	public void setUser1(UserEntity user1) {
		this.user1 = user1;
	}

	public UserEntity getUser2() {
		return user2;
	}

	public void setUser2(UserEntity user2) {
		this.user2 = user2;
	}

}
