import com.sun.javafx.scene.traversal.Direction;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
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



    @Test
    public void getPetByIdTest(){

        int petId = 102;

        ValidatableResponse response = RestAssured.given()
                .log().uri()
                .get(Config.GET_PET_BY_ID, petId)
                .then()
                .log().all()
                .statusCode(200);
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
        int petId = 102;

        ValidatableResponse response = RestAssured.given()
                .log().uri()
                .delete(Config.DELETE_PET_BY_ID, petId)
                .then()
                .log().all()
                .statusCode(200);
    }

    int petId = 102;
    String petName = "Stinger";
    String status = String.valueOf(Status.AVAILABLE);


//    @Test
//    public void addPetTest(){
//        PetStoreTest obj = new PetStoreTest();
//        System.out.println(obj.petId+obj.petName+obj.status);
////        Object petName = {"id", 102, "name", "Troll"};
//
////        ValidatableResponse response = RestAssured.given()
////                .log().uri()
////                .param("id", petId)
////                .param("name", )
////
////                .then()
////                .log().all()
////                .statusCode(200);
//    }

}
