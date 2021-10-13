package com.gmail.klewzow;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		String api = "https://api.privatbank.ua/p24api/exchange_rates?date=";

		ExchangeRate cm = new ExchangeRate();
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		SAXParser sp = spf.newSAXParser();

		XMLReader xmlReader = sp.getXMLReader();
		xmlReader.setContentHandler(cm);
		xmlReader.parse(new InputSource(new StringReader(ApiReader.read(api))));

		System.out.println( cm.getEx().exchangeRates());

	}

}
