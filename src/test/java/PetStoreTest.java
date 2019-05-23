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
/*
cjplfnm wbkrk gj енум
тест который удаляет животное
нцвџ
*/

    @Test
    public void getPetByIdTest(){

        int petId = 2;

        ValidatableResponse response = RestAssured.given()
                .log().uri()
                .get(Config.GET_PET_BY_ID, petId)
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void getPetByStatus(){

        ValidatableResponse response = RestAssured.given()
                .log().uri()
                .param("status", Status.AVAILABLE)
                .get(Config.GET_PET_BY_STATUS)
                .then()
                .log().all()
                .statusCode(200);

    }
}
