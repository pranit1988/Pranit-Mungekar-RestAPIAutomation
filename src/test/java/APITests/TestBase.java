package APITests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;


public class TestBase
{
    public static Response response;
    ValidatableResponse validatableResponse;

    public static Faker fake = new Faker();

    public void TestBase(String path)
    {

        baseURI = "https://petstore3.swagger.io/api/v3";
        port = 8080;
        basePath = path;
    }

}
