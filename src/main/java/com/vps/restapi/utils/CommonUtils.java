package com.vps.restapi.utils;

import java.util.Random;
import java.util.UUID;

public class CommonUtils {
	private static Random rand = new Random();

	public static int randomInt() {

		return rand.nextInt(999999) + 1;
	}

	public static final String generateUuid() {
		return UUID.randomUUID().toString();
	}

}
