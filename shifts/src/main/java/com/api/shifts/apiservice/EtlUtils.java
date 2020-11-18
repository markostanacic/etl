package com.api.shifts.apiservice;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;

public class EtlUtils {

	public static Integer generateRandomInteger() {
		SecureRandom rn = new SecureRandom();

		return Integer.valueOf(rn.nextInt(Integer.MAX_VALUE));
	}

	public static Float generateRandomFloat() {
		SecureRandom rn = new SecureRandom();

		return rn.nextFloat();
	}
	
	public static int genererateRandomInt(int n) {
		return new Random().nextInt(n);
	}

	public static LocalDate generateRandomDate(LocalDate startInclusive, LocalDate endExclusive) {
		long startEpochDay = startInclusive.toEpochDay();
		long endEpochDay = endExclusive.toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

		return LocalDate.ofEpochDay(randomDay);
	}

	public static Boolean generateRandomBoolean() {
		SecureRandom rn = new SecureRandom();

		return rn.nextBoolean();
	}

	public static String generateRandomString() {

		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;

		return RandomStringUtils.random(length, useLetters, useNumbers);

	}

}
