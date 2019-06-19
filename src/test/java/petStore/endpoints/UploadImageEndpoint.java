package petStore.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;

public class UploadImageEndpoint {

    private RequestSpecification given(){
        SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();
        return SerenityRest.given()
                .baseUri(Config.BASE_URI)
                .accept("application/json")
                .contentType("multipart/form-data");
    }

    public ValidatableResponse uploadImage (int petId, String imageFileName){

        File file = new File("./"+ imageFileName);

        String message = "additionalMetadata: null" +"\n"+"File uploaded to ./"
                +imageFileName+", "+getSizeImage(imageFileName)+" bytes";


        return given()
                .multiPart(file)
                .multiPart("additionalMetadata","null")
                .post(Config.GET_UPLOAD_IMAGE, petId)
                .then()
                .log().all()
                .body("message", is(message))
                .statusCode(200)
                ;
    }

    private long getSizeImage(String imageFileName) {
        return new File("./"+imageFileName).length();
    }

}
