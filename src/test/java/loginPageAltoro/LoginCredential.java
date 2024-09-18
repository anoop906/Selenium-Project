package loginPageAltoro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginCredential {
	private Properties properties;

	public LoginCredential() throws IOException {
		properties = new Properties();

		File file = new File("AltoroLoginCredential.properties");
		FileInputStream fis = new FileInputStream(file);
		properties.load(fis);
		fis.close();
	}
	
	public String takeData(String key) {
		
		return properties.getProperty(key);
	}



}