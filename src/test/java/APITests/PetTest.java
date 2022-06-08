package APITests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

//import DataCreationFromModel.PetDataCreator;
import DataModel.PetPojo;
import RequestData.PetRequestData;

import com.jayway.jsonpath.JsonPath;

import DataCreation.PetDataCreation;
//import com.petstore.requestFactory.PetRequests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTest extends TestBase
{
    PetTest()
    {
        super.TestBase("/pet");
    }

    public static PetPojo pet = new PetPojo();
//    public static PetRequestData petRequest = new PetRequestData();
    private PetRequestData petRequest;
    public static int createdPetID;
    public static String createdPetIDString;

//    public static PetDataCreation petDataCreator = new PetDataCreation();
    private PetDataCreation petDataCreator;
    
    @BeforeMethod
    public void setUp() {
    	petRequest = new PetRequestData();
    	petDataCreator = new PetDataCreation();
    }

    @AfterMethod
    public void tearDown() {
    	petRequest = null;
    	petDataCreator = null;
    }
    
    @Story("Fetching all pets by given status")
    @Feature("Pet endpoint")
    @Test(priority=0)
    @DisplayName("Fetch all pets by statuses")
    public void getPetsByStatus()
    {
        response = petRequest.getPetByStatus("available");
        validatableResponse =
                response
                .then()
                .statusCode(200);
    }

    @Story("Creating new pet")
    @Feature("Pet endpoint")
    @Test(priority=1)
    @Order(1)
    @DisplayName("Create a new pet")
    public void createPet()
    {
        response = petRequest.petCreation(petDataCreator.petCreationData());

        validatableResponse =
                response
                .then()
                .statusCode(200);

        String responseString = response.asString();

       createdPetID = JsonPath.read(responseString,"$.id");
       createdPetIDString = "/"+ String.valueOf(createdPetID);
       pet=null;
    }

    @Story("Pet-Finding by given id")
    @Feature("Pet endpoint")
    @Test(priority=2)
    @DisplayName("Finding pet by given id")
    public void findPetByID()
    {
        response = petRequest.petById(createdPetIDString);

        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200);
    }

    @Story("Pet-update pet by given id")
    @Feature("Pet endpoint")
    @Test(priority=2)
    @DisplayName("updating pet by given id")
    public void updateExistingPet()
    {
        response = petRequest.updateGivenPet(petDataCreator.existingPetUpdateData(createdPetID));

        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200);
        pet=null;
    }

    @Story("Update pet in store with form data")
    @Feature("Pet endpoint")
    @Test(priority=3)
    @DisplayName("updating pet by form data")
    public void updateExistingPetWithFormData()
    {
        response = petRequest.updatePetWithFormData(petDataCreator.petDataforUpdate(createdPetID));

        validatableResponse =
                response
                .then()
                .statusCode(200);

        response.prettyPrint();
    }
    

}
