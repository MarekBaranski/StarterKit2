package com.capgemini.chess.dataaccess.entities;

public class MatchEntity {

	private long matchId;
	private long winnerId;
	private boolean drawn;
	private long userId;//UserEntity
	private long userId2;

	public MatchEntity() {

	}

	public MatchEntity(long matchId, long winnerId, boolean drawn, long userId, long userId2) {

		this.matchId = matchId;
		this.winnerId = winnerId;
		this.drawn = drawn;
		this.userId = userId;
		this.userId2 = userId2;
	}

	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public long getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(long winnerId) {
		this.winnerId = winnerId;
	}

	public boolean isDrawn() {
		return drawn;
	}

	public void setDrawn(boolean drawn) {
		this.drawn = drawn;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId2() {
		return userId2;
	}

	public void setUserId2(long userId2) {
		this.userId2 = userId2;
	}

}
