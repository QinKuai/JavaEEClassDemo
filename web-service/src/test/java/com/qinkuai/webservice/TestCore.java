package com.qinkuai.webservice;

import com.qinkuai.core.util.ApplicationProperties;

public class TestCore {
	public static void main(String[] args) {
		System.out.println(ApplicationProperties.getInstance().getProperty("static-path"));
	}
}
