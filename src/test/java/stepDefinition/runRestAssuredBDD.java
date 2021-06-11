package stepDefinition;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class runRestAssuredBDD {

    public static void runService(String postNumber){
        given().contentType(ContentType.JSON)
                .when().get(String.format("http://localhost:3000/posts/%s",""))
                        .then().assertThat().body("id",containsInAnyOrder(1,20,21)).statusCode(200);
    }
}
