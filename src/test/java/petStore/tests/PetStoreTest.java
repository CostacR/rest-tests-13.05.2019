package petStore.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.runner.RunWith;
import petStore.endpoints.PetEndpoint;
import petStore.models.CategoryModel;
                import petStore.models.PetModel;
                import petStore.models.TagModel;
                import io.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
@Concurrent(threads = "4")
public class PetStoreTest {
    private PetEndpoint petEndpoint = new PetEndpoint();


                    static {
                        RestAssured.baseURI = "https://petstore.swagger.io/v2";
                    }
                    private int idPet = 105;

//                    @tests
//                    public void allTests()  {
////                        addPetTest();
////                        getPetByIdTest();
////                        deletePetTest();
//                        addPetTest();
//                        getPetByIdTest();
//                        updatePetTest();
//                        getPetByIdTest();
//                        checkPet();
//                        deletePetTest();
//                    }


//                    @tests
//                    public void checkPet(){
//                        System.out.println("check pet");
//                        RestAssured.given()
//                                .log().uri()
//                                .get(Config.GET_PET_BY_ID,idPet)
//                                .then()
//                                .assertThat()
//                                .statusCode(200)
//                                .body("id", is(idPet))
//                                .body("name", is("Mau"))
//                        ;
//    }


//    @tests
//    public void getPetByIdTest(){
//        System.out.println("get id");
//        int petId = 105;
//        petEndpoint.getPetById(petId);
//
//        ValidatableResponse response = RestAssured.given()
//                .log().uri()
//                .get(Config.GET_PET_BY_ID, petId)
//                .then()
////                .log().all()
//                .statusCode(200);
//        System.out.println("pet - "+petId);
//    }

//    @tests
//    public void getPetByStatus() {
//        for (Status status : Status.values()) {
//            petEndpoint
//                    .getPetByStatus(status)
//                    .statusCode(200);
//        }
//    }

//    @tests
//    public void deletePetTest(){
//        System.out.println("delete pet");
//        int petId = 105;
//
//        ValidatableResponse response = RestAssured.given()
//                .log().uri()
//                .delete(Config.DELETE_PET_BY_ID, petId)
//                .then()
//                .log().all()
//                .statusCode(200);
//    }

//    int petId = 102;
//    String petName = "Stinger";
//    String status = String.valueOf(Status.AVAILABLE);
    @Test
    public void addPetTest(){
         PetModel petModel = new PetModel(
                105,
                new CategoryModel(),
                "Flaffy",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");

         petEndpoint
                 .createPet(petModel)
                 .statusCode(200);
         }

//    @Test
//    public void getPetByIdTest(){
//        System.out.println("get id");
//        int petId = 105;
//
//        petEndpoint
//                .getPetById(petId)
//                .statusCode(200);
//    }
    @Test
    public void updatePetTest(){
        System.out.println("update pet");
        PetModel petModel = new PetModel(
                105,
                new CategoryModel(),
                "Mau",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");

        petEndpoint
                .updatePet(petModel)
                .statusCode(200);


    }
//        for (Status status : Status.values()) {
//
//            System.out.println(status);
//            ValidatableResponse response = RestAssured.given()
//                    .log().uri()
//                    .param("status", status)
//                    .get(Config.GET_PET_BY_STATUS)
//                    .then()
//                    .log().all()
//                    .statusCode(200);
//        }
}
