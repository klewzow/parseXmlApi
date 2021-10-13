package com.gmail.klewzow;

import java.util.HashMap;
import java.util.Map;

public class Exchangers {

	private String date;
	private String bank;
	private String �urrency;
	private Map<String, String> ex = new HashMap<>();

	public Exchangers() {
		super();
	}

	public String exchangeRates() {
		StringBuilder sb = new StringBuilder();
		sb.append("Date : " + this.date + ", " + "Bank : " + this.bank + ", " + "Curensy : " + this.�urrency + "\n");
		for (String element : this.ex.keySet()) {
			sb.append(element + " => " + ex.get(element) + " " + this.�urrency + "\n");
		}

		return sb.toString();
	}

	public void addEx(String key, String value) {
		this.ex.put(key, value);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String get�urrency() {
		return �urrency;
	}

	public void set�urrency(String �urrency) {
		this.�urrency = �urrency;
	}

	@Override
	public String toString() {
		return "Exchangers [date=" + date + ", bank=" + bank + ", �urrency=" + �urrency + ", ex=" + ex + "]";
	}

}
