package com.vps.restapi.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CommonUtilsTest {
	@Test
	public void check() {
		List<String> values = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			String unitValue = CommonUtils.generateUuid();
			Assert.assertFalse(values.contains(unitValue));
			values.add(unitValue);
			System.out.println(unitValue);

		}
		Assert.assertEquals(100, values.size());
	}

}
