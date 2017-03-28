package com.capgemini.chess.dataaccess.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "statistic")
public class StatisticEntity extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	private long level;
	private long position;
	private long points;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private UserEntity userEntity;

	public StatisticEntity() {

	}

	public StatisticEntity(long id, long level, long position, long points, UserEntity userEntity) {
		super();
		this.id = id;
		this.level = level;
		this.position = position;
		this.points = points;
		this.userEntity = userEntity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
