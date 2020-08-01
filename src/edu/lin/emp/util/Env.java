package edu.lin.emp.util;

import java.io.InputStream;
import java.util.Properties;


@SuppressWarnings("serial")
public final class Env extends Properties {

	private static Env instance;


	public static Env getInstance() {
		if (instance != null) {
			return instance;
		} else {
			makeInstance();
			return instance;
		}
	}


	private static synchronized void makeInstance() {
		if (instance == null) {
			instance = new Env();
		}
	}


	private Env() {
		InputStream is = getClass().getResourceAsStream("/pager.properties");
		try {
			load(is);
		} catch (Exception e) {
			System.err.println("错误");
			return;
		}
	}
}
