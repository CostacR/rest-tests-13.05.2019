package petStore.endpoints;

import petStore.models.PetOrder;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class OrderEndpoint {
    public enum Status{
        placed,
        transporting,
        closed
    }

    public RequestSpecification given (){
        return RestAssured.given()
                .baseUri(Config.BASE_URI)
                .contentType("application/json")
                .log().uri();
    }
    public ValidatableResponse getOrderById(int orderId){
        return given()
                .get(Config.GET_ORDER_BY_ID, orderId)
                .then()
                .log().all();
    }

    public ValidatableResponse createOrder (PetOrder petOrder){
        return given()
                .body(petOrder)
                .post(Config.CREATE_ORDER)
                .then()
                .log().all();
    }

    public ValidatableResponse deleteOrderById(int orderId){
        return given()
                .delete(Config.GET_DELETE_ORDER_BY_ID, orderId)
                .then()
                .log().all();
    }
}
