package com.profileproject.utility;

import com.profileproject.dao.ProfileDAO;
import com.profileproject.dao.ProfileDAOInterface;
import com.profileproject.entity.ProfileUser;

public class DAOFactory {



	public static ProfileDAOInterface createDAOMethod() {
		// TODO Auto-generated method stub
		return new ProfileDAO();
	}

	

}
