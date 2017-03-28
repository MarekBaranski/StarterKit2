package com.capgemini.chess.service.to;

import java.io.Serializable;
import com.capgemini.chess.enumerated.ResultMatch;

public class MatchTO extends AbstractTo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private ResultMatch result;
	private UserProfileTO user1;
	private UserProfileTO user2;

	public MatchTO() {
		super();
	}

	public MatchTO(long id, ResultMatch result, UserProfileTO user1, UserProfileTO user2) {
		super();
		
		this.result = result;
		this.user1 = user1;
		this.user2 = user2;
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

	public UserProfileTO getUser1() {
		return user1;
	}

	public void setUser1(UserProfileTO user1) {
		this.user1 = user1;
	}

	public UserProfileTO getUser2() {
		return user2;
	}

	public void setUser2(UserProfileTO user2) {
		this.user2 = user2;
	}

}
