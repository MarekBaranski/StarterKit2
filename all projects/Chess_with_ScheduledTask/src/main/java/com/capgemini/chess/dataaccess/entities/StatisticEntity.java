package com.capgemini.chess.dataaccess.entities;

public class StatisticEntity {

	private long level;
	private long position;
	private long points;
	private long userId;

	public StatisticEntity() {

	}

	public StatisticEntity(long level, long position, long points, long userId) {

		this.level = level;
		this.position = position;
		this.points = points;
		this.userId = userId;
	}

	public long getLevel() {
		return level;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
