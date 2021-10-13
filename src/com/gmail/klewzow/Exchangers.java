package com.gmail.klewzow;

import java.util.HashMap;
import java.util.Map;

public class Exchangers {

	private String date;
	private String bank;
	private String Òurrency;
	private Map<String, String> ex = new HashMap<>();

	public Exchangers() {
		super();
	}

	public String exchangeRates() {
		StringBuilder sb = new StringBuilder();
		sb.append("Date : " + this.date + ", " + "Bank : " + this.bank + ", " + "Curensy : " + this.Òurrency + "\n");
		for (String element : this.ex.keySet()) {
			sb.append(element + " => " + ex.get(element) + " " + this.Òurrency + "\n");
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

	public String get—urrency() {
		return Òurrency;
	}

	public void set—urrency(String Òurrency) {
		this.Òurrency = Òurrency;
	}

	@Override
	public String toString() {
		return "Exchangers [date=" + date + ", bank=" + bank + ", Òurrency=" + Òurrency + ", ex=" + ex + "]";
	}

}
