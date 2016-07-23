package de.nullpointer.servercontroller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;

public class PropertiesReader {
	
	private static HashMap<String, String> propsMap = new HashMap<String, String>();
	
	public static void readProperties() {
		String line, split[];
		try (
		    InputStream fileInput = new FileInputStream("the_file_name");
		    InputStreamReader inputReader = new InputStreamReader(fileInput, Charset.forName("UTF-8"));
		    BufferedReader br = new BufferedReader(inputReader);
		) {
		    while ((line = br.readLine()) != null) {
		        split = line.split(": ");
		        propsMap.put(split[0], split[1]);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getString(String key) {
		return String.valueOf(propsMap.get(key));
	}
	
	public static int getInt(String key) {
		return Integer.valueOf(propsMap.get(key));
	}

}
