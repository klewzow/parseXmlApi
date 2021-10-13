package com.gmail.klewzow;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ExchangeRate extends DefaultHandler {
	private Exchangers ex;
	private boolean footer = true;
	private String key = "";
	private String val = "";

	public ExchangeRate() {
		super();
		this.ex = new Exchangers();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		for (int i = 0; i < attributes.getLength(); i++) {
			if (attributes.getLength() < 4) {
				footer = false;
				continue;
			}
			if (footer) {
				footer(attributes, i);
				continue;
			} else {
				setExExchangersMap(attributes, i);
			}
		}
	}

	private void footer(Attributes atr, int value) {
		if (atr.getQName(value).equals("date")) {
			this.ex.setDate(atr.getValue(value));
		}
		else if (atr.getValue(value).equals("PB")) {
			this.ex.setBank("PrivatBank");
		}
		else if (atr.getQName(value).equals("BaseCurrencyLit")) {
			this.ex.setÑurrency(atr.getValue(value));
		}
	}



	private void setExExchangersMap(Attributes attributes, int i) {

		if (attributes.getQName(i).equals("currency")) {
			key = attributes.getValue(i);
		} else if (attributes.getQName(i).equals("saleRateNB")) {
			val = attributes.getValue(i).substring(0, attributes.getValue(i).lastIndexOf('.') + 3);
		} else if (i == 4) {
			this.ex.addEx(key, val);
			val = key = "";
		}
	}
 
	public Exchangers getEx() {
		return ex;
	}

}
