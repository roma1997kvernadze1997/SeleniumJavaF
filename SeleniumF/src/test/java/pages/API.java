package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API {
	
	WebDriver driver;
	
	public API(WebDriver driver) {
		this.driver = driver;
	}
	
	public void viewBooks() {
		
		Response response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
    	String responseBody = response.getBody().asString();
    	System.out.println("Response Body is =>  " + responseBody);
    	int responseStatusCode = response.getStatusCode();
    	System.out.println("Status Code => " + responseStatusCode);
    	Assert.assertEquals(responseStatusCode, 200);
	}
	
	public String generateToken22() {

	    RestAssured.baseURI = "https://demoqa.com"; 
	    RequestSpecification request = RestAssured.given();
	    JSONObject requestParams = new JSONObject(); 
	    requestParams.put("userName", "roma3");
	    requestParams.put("password", "@Roma1997"); 
	    request.header("Content-Type", "application/json");
	    request.body(requestParams.toJSONString());
	    Response response = request.post("/Account/v1/GenerateToken");
	    int responseStatusCode = response.getStatusCode();
	    String responseBody = response.getBody().asString();
	    System.out.println("Response Body is =>  " + responseBody);    	
	    Assert.assertEquals(responseStatusCode, 200);
    	String token = response.jsonPath().getString("token");
    	System.out.println(token);
    	return token;
	}
	
	public String generateToken() {

	     String baseUrl="https://demoqa.com";
	     RestAssured.baseURI = baseUrl;
		  RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json");
		  
		  //Calling request body
		  Response response = httpRequest.body("{\"userName\": \"roma3\",\"password\": \"@Roma1997\"}")
				  .post("/Account/v1/GenerateToken");
		  
		  //Get Status Code
		  int responseStatusCode = response.getStatusCode();
		  Assert.assertEquals(responseStatusCode, 200);
		  
		  //Get Token
		  String token = response.jsonPath().getString("token");
	      System.out.println(token);
	      return token;
	}
	
	public void addBooks(String token) {

	     String baseUrl="https://demoqa.com";
	     RestAssured.baseURI = baseUrl;
		  RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
	         .header("Content-Type", "application/json");
		  
		  //Calling request body
		  Response res = httpRequest.body("{\"userId\": \"9fe19405-d9c7-456d-a725-43f9ec4537e7\",\"collectionOfIsbns\": [{\"isbn\": \"9781449325862\"}]}")
				  .post("BookStore/v1/Books");
		  
		  //Get status code
		  int responseStatusCode = res.getStatusCode();
		  Assert.assertEquals(responseStatusCode, 201);
	}
	
	//Add Book to users collection group from API
	public void addBookToCollection() {
		String token = generateToken();
		addBooks(token);
	}
    
}
