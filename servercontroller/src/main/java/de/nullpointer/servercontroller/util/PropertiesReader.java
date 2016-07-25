package de.nullpointer.servercontroller.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.HashMap;

import de.nullpointer.servercontroller.Main;

public class PropertiesReader {
	
	private static HashMap<String, String> propsMap = new HashMap<String, String>();
	
	public static void readProperties() throws URISyntaxException {
		String line, split[];
		File props = null;
		
		// Set defaults
		propsMap.put("port", "25564");
		propsMap.put("serverjar", Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() +
				File.pathSeparator + "craftbukkit.jar");

		props = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() +
				File.pathSeparator + "properties.props");

		
		try (
			InputStream fileInput = new FileInputStream(props);
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
