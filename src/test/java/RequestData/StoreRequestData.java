package RequestData;

import DataModel.StorePojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class StoreRequestData {

	 public Response inventoryStatus()
	    {
	        return given()
	               .when()
	               .get("/inventory");
	    }

	    public Response newOrder(StorePojo store)
	    {
	        return  given()
	                .when()
	                .contentType(ContentType.JSON)
	                .when()
	                .body(store)
	                .post();
	    }

	    public Response orderById(String queryParam)
	    {
	        return given()
	                .when()
	                .get(queryParam);
	    }

	    public Response deleteOrder(String orderId)
	    {
	    	
	        return given()
	                .when()
	                .delete(orderId)
	                .then()
	                .statusCode(200).log().body().extract().response();
	    }

}
