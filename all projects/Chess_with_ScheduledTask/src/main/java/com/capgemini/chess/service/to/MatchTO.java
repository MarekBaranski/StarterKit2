package com.capgemini.chess.service.to;

public class MatchTO {

	private long matchId;
	private long winnerId;
	private boolean drawn;
	private long userId;
	private long userId2;

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
