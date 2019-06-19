package petStore.endpoints;

import io.restassured.http.ContentType;
import petStore.models.PetModel;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import net.serenitybdd.rest.SerenityRest;

import net.thucydides.core.annotations.Step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PetEndpoint {
//    Logger log = Logger.getLogger(this.getClass().getName());//jUnit логгер
//    Logger log = LoggerFactory.getLogger(PetEndpoint.class);//slf4j логгер #1 vers.
    Logger log = LoggerFactory.getLogger(this.getClass());//slf4j логгер #2 vers.

    public enum Status{
        AVAILABLE,
        PENDING,
        SOLD
    }

    public RequestSpecification given (){
        SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();
        return SerenityRest.given()
                .baseUri(Config.BASE_URI)
                .contentType("application/json")
//                .log().uri()
                ;
    }

    @Step
    public ValidatableResponse getPetById(int petId){
        log.info("getPetId__999_Log");
        return given()
              .get(Config.GET_PET_BY_ID, petId)
              .then()
//              .log().all()
                .statusCode(200)
              ;
    }

    @Step
    public ValidatableResponse createPet (PetModel petModel){
        return given()
                .body(petModel)
                .post(Config.CREATE_PET)
                .then()
//                .log().all()
                ;
    }
    @Step
    public ValidatableResponse updatePet (PetModel petModel){
        return given()
                .body(petModel)
                .put(Config.UPDATE_PET_BY_ID)
                .then()
//                .log().all()
                ;
    }

    @Step
    public ValidatableResponse deletPetById(int petId){
        return given()
                .delete(Config.DELETE_PET_BY_ID, petId)
                .then()
//                .log().all()
                ;
    }

    @Step
    public ValidatableResponse getPetByStatus(Status status){

        return given()
                .param("status", status)
                .get(Config.GET_PET_BY_STATUS)
                .then()
//                .log().all()
                ;
            }

}
