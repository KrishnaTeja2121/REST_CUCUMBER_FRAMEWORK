package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	RequestSpecification req;
	
	
	public RequestSpecification requestSpecification() throws IOException {
		
		 req =new RequestSpecBuilder().setBaseUri(getPropValue("baseURI")).addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();
		 return req;
	}
	
	public static String getPropValue(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\krish\\eclipse-workspace\\REST_CUCUMBER_FRAMEWORK\\zvd\\src\\test\\java\\resources\\"
				+ "global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
}
