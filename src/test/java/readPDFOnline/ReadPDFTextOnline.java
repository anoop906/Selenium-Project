package readPDFOnline;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPDFTextOnline {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String link = "https://tourism.gov.in/sites/default/files/2019-04/dummy-pdf_2.pdf";
		driver.get(link);
		// convert link to the url 
		URL pdfurl = new URL(link);
		
		// open url online
		InputStream is = pdfurl.openStream();
		
		// load pdf doc
		PDDocument pdfDoc = PDDocument.load(is);
		
		PDFTextStripper pdftext = new PDFTextStripper();
		String pdf = pdftext.getText(pdfDoc);
		System.out.println(pdf);
		driver.close();

	}

}
