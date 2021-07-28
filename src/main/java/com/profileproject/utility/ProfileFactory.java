package com.profileproject.utility;

import com.profileproject.controller.ProfileController;
import com.profileproject.controller.ProfileControllerInterface;


public class ProfileFactory {

	public static ProfileControllerInterface createObject() {
		// TODO Auto-generated method stub
		return new ProfileController();
	}

}
