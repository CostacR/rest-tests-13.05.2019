package PetStore;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PetEndpoint {

    public RequestSpecification given (){
        return RestAssured.given()
                .baseUri(Config.BASE_URI)
                .contentType("application/json")
                .log().uri();
    }

    public ValidatableResponse getPetById(int petId){
        return given()
              .get(Config.GET_PET_BY_ID, petId)
              .then()
              .log().all();
    }
}
