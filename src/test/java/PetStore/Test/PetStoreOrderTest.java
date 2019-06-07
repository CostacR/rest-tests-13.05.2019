package PetStore.Test;
import PetStore.endpoints.OrderEndpoint;
import PetStore.endpoints.PetEndpoint;
import PetStore.models.CategoryModel;
import PetStore.models.PetModel;
import PetStore.models.PetOrder;
import PetStore.models.TagModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class PetStoreOrderTest {
    private OrderEndpoint orderEndpoint = new OrderEndpoint();
    private PetEndpoint petEndpoint = new PetEndpoint();
    private PetModel petModel;
    private PetOrder petOrder;

    @Before
    public void preCondition( ){
        petModel = new PetModel(
                105,
                new CategoryModel(),
                "Zorg-107",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");
        petEndpoint
                .createPet(petModel)
                .statusCode(200);

        petOrder = new PetOrder(
                1,
                105,
                2,
                "placed",
                true);


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
                .body("shipDate", is(petOrder.getStatus()))
                .body("complete", is(petOrder.isCompleteOrder()))
                ;
    }
}
//Делаем заказ. Просмотреть заказ.Указываем аЙдИ. Просмотреть заказ. Удалить созданное (почитсить за собой)
// Включить проверку ResponseBody
