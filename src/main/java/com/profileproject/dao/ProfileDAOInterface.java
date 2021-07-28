package com.profileproject.dao;

import com.profileproject.entity.ProfileUser;

public interface ProfileDAOInterface {

	int createDAOProfile(ProfileUser p);

	boolean loginDAOProfile(ProfileUser pu);

	ProfileUser viewEditAttribute(ProfileUser pu);

	int editDAOProfile(ProfileUser p1);

	int deleteDAOProfile(ProfileUser pu);

	ProfileUser viewDAOProfile(ProfileUser pu);

}
