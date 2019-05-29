package PetStore;

import PetStore.models.CategoryModel;
import PetStore.models.PetModel;
import PetStore.models.TagModel;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PetStoreTest {
    private enum Status{
        AVAILABLE,
        PENDING,
        SOLD
    }

    static {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
    int idPet = 104;


    @Test
    public void allTests() throws InterruptedException {
        addPetTest();
        getPetByIdTest();
        deletePetTest();
        addPetTest();
        getPetByIdTest();
        updatePetTest();
        getPetByIdTest();
        System.out.println("All ok");
        Thread.sleep(3000);
        deletePetTest();

    }


    @Test
    public void checkPet(){
        getPetByIdTest();

    }
    @Test
    public void getPetByIdTest(){

        int petId = 105;

        ValidatableResponse response = RestAssured.given()
                .log().uri()
                .get(Config.GET_PET_BY_ID, petId)
                .then()
//                .log().all()
                .statusCode(200);
        System.out.println("pet - "+petId);
    }

    @Test
    public void getPetByStatus(){

        for (Status status : Status.values()) {

            System.out.println(status);
            ValidatableResponse response = RestAssured.given()
                    .log().uri()
                    .param("status", status)
                    .get(Config.GET_PET_BY_STATUS)
                    .then()
                    .log().all()
                    .statusCode(200);
        }


    }
    @Test
    public void deletePetTest(){
        int petId = 105;

        ValidatableResponse response = RestAssured.given()
                .log().uri()
                .delete(Config.DELETE_PET_BY_ID, petId)
                .then()
                .log().all()
                .statusCode(200);
    }

//    int petId = 102;
//    String petName = "Stinger";
//    String status = String.valueOf(Status.AVAILABLE);


    @Test
    public void addPetTest(){

        PetModel petModel = new PetModel(
                105,
                new CategoryModel(),
                "Droppy",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");


        RestAssured.given()
                .log().uri()
//                .header("Content-Type", "application/json") //строки эквивалентны по смыслу
                .contentType("application/json")                 //строки эквивалентны по смыслу
                .body(petModel)
                .post(Config.CREATE_PET)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updatePetTest(){
        PetModel petModel = new PetModel(
                105,
                new CategoryModel(),
                "Mau",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");

        RestAssured.given()
                .log().uri()
                .contentType("application/json")
                .body(petModel)
                .post(Config.CREATE_PET)
                .then()
                .log().all()
                .statusCode(200);

    }

}
