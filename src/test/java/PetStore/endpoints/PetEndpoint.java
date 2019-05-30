package PetStore.endpoints;

import PetStore.models.PetModel;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PetEndpoint {

    public enum Status{
        AVAILABLE,
        PENDING,
        SOLD
    }

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

    public ValidatableResponse createPet (PetModel petModel){
        return given()
                .body(petModel)
                .post(Config.CREATE_PET)
                .then()
                .log().all();
    }
    public ValidatableResponse updatePet (PetModel petModel){
        return given()
                .body(petModel)
                .put(Config.UPDATE_PET_BY_ID)
                .then()
                .log().all();
    }

    public ValidatableResponse deletPetById(int petId){
        return given()
                .delete(Config.DELETE_PET_BY_ID, petId)
                .then()
                .log().all();
    }

    public ValidatableResponse getPetByStatus(Status status){

        return given()
                .param("status", status)
                .get(Config.GET_PET_BY_STATUS)
                .then()
                .log().all();
            }

}
