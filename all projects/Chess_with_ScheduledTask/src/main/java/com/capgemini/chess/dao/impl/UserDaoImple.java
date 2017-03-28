package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.UsersDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;

@Repository
public class UserDaoImple implements UsersDao {

	private static List<UserEntity> user = new ArrayList<>();

	public UserDaoImple() {

		addUser();
	}

	private void addUser() {

		user.add(new UserEntity(1, "jeden", "a1", "UserJeden", "Pierwszy", "jeden@wp.pl", "lubie szachy",
				"Gram całe zycie, bo lubie"));
		user.add(new UserEntity(2, "dwa", "b2", "UserDwa", "Drugi", "dwa@wp.pl", "lubie bardzo szachy",
				"Gram od urodzenia"));
		user.add(new UserEntity(3, "trzy", "c3", "UserTrzy", "trzeci", "trzy@wp.pl", "lubie super szachy",
				"Gram bo chę"));
		user.add(new UserEntity(4, "cztery", "d4", "UserCztery", "Czwarty", "cztery@wp.pl", "lubie trochę szachy",
				"Gram czasami"));
		user.add(new UserEntity(5, "pięć", "e5", "UserPiec", "Piaty", "piec@wp.pl", "nie lubie grac w szachy",
				"Gram bo moj brat gra"));
		user.add(new UserEntity(6, "szesc", "f6", "UserSzesc", "Szosty", "szesc@wp.pl", "lubie isc do kina",
				"Dzien bez kina dniem straconym"));
		user.add(new UserEntity(7, "siedem", "g7", "UserSiedem", "Siodmy", "siedem@wp.pl", "lubie pić kawę",
				"chwytaj dzien"));
		user.add(new UserEntity(8, "osiem", "h8", "UserOsiem", "Osmy", "osiem@wp.pl", "Lubie wakacje",
				"Zawsze jezdze w gory"));
		user.add(new UserEntity(9, "dziewiec", "i9", "UserDziewiec", "Dziewiaty", "Dziewiec@wp.pl", "Nic nie lubie",
				"Nic nie lubie i zyje"));
		user.add(new UserEntity(10, "dziesiec", "j10", "UserDziesiec", "Dziesiaty", "Dziesiec@wp.pl", "gram w gry",
				"Gram NFS II"));

	}

	@Override
	public UserProfileTO getProfileById(long id) {
		for (UserEntity readUser : user) {
			if (readUser.getId() == id) {
				return UserProfileMapper.map(readUser);
			}
		}
		return null;
	}

	@Override
	public void editUser(UserProfileTO userNew) {

		for (UserEntity editProfile : user) {
			if (editProfile.getId() == userNew.getId()) {
				// UserProfileMapper.update(editProfile, userNew);

				editProfile.setLogin(userNew.getLogin());
				editProfile.setAboutMe(userNew.getAboutMe());
				editProfile.setEmail(userNew.getEmail());
				editProfile.setLifeMotto(userNew.getLifeMotto());
				editProfile.setName(userNew.getName());
				editProfile.setSurname(userNew.getSurname());
				editProfile.setPassword(userNew.getPassword());

			}
		}
	}

	@Override
	public UserProfileTO changePassword(long id, String password) {
		UserProfileTO user = getProfileById(id);
		user.setPassword(password);

		editUser(user);

		return user;
	}


	@Override
	public void deleteUserById(long id) {
		user.remove(UserProfileMapper.map(getProfileById(id)));

		}

	}

