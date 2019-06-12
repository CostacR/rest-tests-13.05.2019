package PetStore.Test;
import PetStore.endpoints.OrderEndpoint;
import PetStore.models.PetOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class PetStoreOrderTest {
    private OrderEndpoint orderEndpoint = new OrderEndpoint();
    private PetOrder petOrder;
    private String shipDate;

    @Before
    public void preCondition( ) {

        String timeEndString = "T00:00:00.000+0000";
        shipDate = "2019-06-12"+timeEndString;

        petOrder = new PetOrder(
                1,
                5,
                2,
                shipDate,
                "placed",
                false);
    }

    @After
    public void postCondition(){
        orderEndpoint
                .deleteOrderById(petOrder.getId())
                .statusCode(200);
    }

    @Test
    public void orderTest(){
        orderEndpoint
                .createOrder(petOrder)
                .statusCode(200);
        orderEndpoint
                .getOrderById(petOrder.getId())
                .statusCode(200)
        .body("petId", is(petOrder.getPetId()))
        .body("quantity", is(petOrder.getQuantity()))
        .body("shipDate", is(petOrder.getShipDate()))
        .body("status", is(petOrder.getStatus()))
        .body("complete", is(petOrder.isCompleteOrder()))
                ;
    }
}
//Делаем заказ. Просмотреть заказ.Указываем аЙдИ. Просмотреть заказ. Удалить созданное (почитсить за собой)
// Включить проверку ResponseBody
