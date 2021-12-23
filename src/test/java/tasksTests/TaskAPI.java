package tasksTests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class TaskAPI {
    private static String pageURL = "https://gorest.co.in";
    @Test
    public void testCreateUser() {
        String token = "9643b39b9476d20790eaae3d889f0d7b85ed9842017b94761a9ecb508d597842";
        String email = "name" + new Random().nextInt(1000) + "@gmail.com";
        String userName = "Name";
        String endpointPostUser = "/public-api/users";
        String endpointGetAndDeleteUser = "/public-api/posts/{userId}";

        Map user = new HashMap();
        user.put("name", userName);
        user.put("email", email);
        user.put("gender", "Female");
        user.put("status", "Active");

        int userID= given().
                auth().
                oauth2(token).
                contentType(ContentType.JSON).
                body(user).
                log().all().
        when().
                post(pageURL+endpointPostUser).
        then().
                assertThat().
                statusCode(200).
                body("data.name", is(userName)).
                log().all().
                extract().
                path("data.id");



        given().
                auth().
                oauth2(token).
                pathParam("userId", userID).
                log().all().
        when().
                delete(pageURL+endpointGetAndDeleteUser).
        then().
                assertThat().
                body("code", is(201)).
                log().all();





        given().
                auth().
                oauth2(token).
                pathParam("userId", userID).
                log().all().
        when().
                get(pageURL+ endpointGetAndDeleteUser).
        then().
                assertThat().
                body("code", is(404)).
                log().all();




    }




}
