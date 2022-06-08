package APITests;

import DataCreation.StoreDataCreation;
import DataModel.UserPojo;
import RequestData.StoreRequestData;

import com.jayway.jsonpath.JsonPath;


import DataCreation.StoreDataCreation;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoreTest extends TestBase
{
    public static StoreRequestData storeRequests = new StoreRequestData();
    public static StoreDataCreation storeDataCreator = new StoreDataCreation();
    public static int createdOrderID;
    public static String createdOrderIDString;

    StoreTest() { super.TestBase("/store"); }

    @Feature("Stores endpoint")
    @Story("Fetching all orders from inventory by given status")
    @Test(priority=0)
    @DisplayName("Fetch the inventory status")
    public void getInventoryStatus()
    {
        response= storeRequests.inventoryStatus();
        response.prettyPrint();

        validatableResponse=
                response
                .then()
                .statusCode(200);
    }

    @Feature("Stores endpoint")
    @Story("Place a new order")
    @Test(priority=1)
    //@Order(1)
    @DisplayName("Place a new order")
    public void placeAnOrder()
    {
        super.TestBase("/store/order");

        response= storeRequests.newOrder(storeDataCreator.NewOrderData());
        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200);

        String responseString = response.asString();

        createdOrderID = JsonPath.read(responseString,"$.id");
        createdOrderIDString = "/"+ String.valueOf(createdOrderID);
    }

    @Feature("Stores endpoint")
    @Story("Fetching the order by given ID")
    @Test(priority=2)
    //@Order(2)
    @DisplayName("Fetch the given order by ID")
    public void getOrderByID()
    {
        super.TestBase("/store/order");

        Response response = storeRequests.orderById(createdOrderIDString);
        response.prettyPrint();

        validatableResponse=
                response
                .then()
                .statusCode(200);
    }

    @Feature("Stores endpoint")
    @Story("Delete the order created as part of previous test")
    @Test(priority=3)
   // @Order(3)
    @DisplayName("Delete an newly created order")
    public void DeleteTheCreatedOrder()
    {
        super.TestBase("/store/order");

        response = storeRequests.deleteOrder(createdOrderIDString);
        response.prettyPrint();

        ValidatableResponse validatableResponse =
                response
                .then()
                .statusCode(200);
    }
}
