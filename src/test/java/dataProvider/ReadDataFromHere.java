package dataProvider;

import org.testng.annotations.DataProvider;

public class ReadDataFromHere {
	@DataProvider(name="LoginCredential")
	public Object[][] DataSourse() {
		Object [][] data = new Object [][] 
					{{"jsmith","demo1234"},
					{"jsmi", "demo1234"},
					{"jsmith","demo12"}};
	return data;
}

}
