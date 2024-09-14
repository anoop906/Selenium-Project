package dataProvider;

import org.testng.annotations.DataProvider;

public class Dataset {

	@DataProvider (name="Credential", parallel = true)
	public Object[][] setOfData() {
		Object[][] dataSupply = new Object[][] 
				{{"jsmith", "demo1234"},
				{"jsmi", "demo1234"},
				{"jsmith", "demo12"},
				{"jsmi","demo12"},
				{"demo1234","jsmith"},
				{"",""}};
		return dataSupply;	
		}
	}

