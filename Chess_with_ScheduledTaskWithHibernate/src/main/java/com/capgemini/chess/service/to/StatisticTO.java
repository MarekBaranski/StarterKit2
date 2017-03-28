package com.capgemini.chess.service.to;

import java.io.Serializable;

import com.capgemini.chess.dataaccess.entities.UserEntity;

public class StatisticTO extends AbstractTo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long level;
	private long position;
	private long points;
	private UserEntity userEntity;

	public StatisticTO() {
		super();
	}

	public StatisticTO(long level, long position, long points, UserEntity userEntity) {
		super();
		this.level = level;
		this.position = position;
		this.points = points;
		this.userEntity = userEntity;
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

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

}
