package restAssuredTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class restAssuredGetSampleTest {

    @Test
    public void getSampleTestGet(){
        RequestSpecification request = RestAssured.given();
        Response response = request.get("http://localhost:3000/comments?id=1");
        System.out.println("Get response"+response);
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void getSampleTestPost(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-type","application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","90");
        jsonObject.put("title","Learning Webservices");
        jsonObject.put("author","kushb");

        requestSpecification.body(jsonObject.toJSONString());

        Response response= requestSpecification.post("http://localhost:3000/posts");
        Assert.assertEquals(response.getStatusCode(),201);
    }
}
