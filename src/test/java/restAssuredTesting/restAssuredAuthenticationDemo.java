package restAssuredTesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;



public class restAssuredAuthenticationDemo {

    //Basic authentication
    @Test
    public void basicAuthenticationTest(){

        int response = RestAssured.given().auth().preemptive().basic("username","password").when().get("").getStatusCode();
        Assert.assertEquals(response , 200);
    }

    // OAuth1 Authorisation
    @Test
    public void OAuth1Authorisation(){
        RequestSpecification requestSpecification = RestAssured.given().auth().oauth("consumerkey","consumersecret","accesstoken","secrettoken");
        JsonPath jsonPath = requestSpecification.post("").getBody().jsonPath();
        System.out.println("Response body"+jsonPath.prettify());
        String statusCode = jsonPath.get("id");
        Assert.assertEquals(statusCode,"");
    }

    //OAuth 2 Authorisation
    @Test
    public void OAuth2Authorisation(){
        Response response = RestAssured.given().
                formParam("clientID","")
                .formParam( "client_secret","" )
                .formParam("granttype","client_credential")
                .post("");

        System.out.println(response.jsonPath().prettify());
        String access_token =  response.jsonPath().get("access_token");
    }
}
