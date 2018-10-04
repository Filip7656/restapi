package com.vps.restapi.utils;

import com.vps.restapi.model.User;

public class UserUtils {
	public static final boolean checkIfEqual(User user1, User user2) {
		if (!user1.getEmail().equals(user2.getEmail())) {
			// dopisac kolejne ify
			return false;
		}
		return true;
	}

}
