package com.gmail.klewzow;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiReader {

	public static String read(String api) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
		StringBuilder sb = new StringBuilder();
		api = api + sdf.format(new Date());
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(api).openStream()))) {
			String str = "";
			for (; (str = br.readLine()) != null;) {
				sb.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
