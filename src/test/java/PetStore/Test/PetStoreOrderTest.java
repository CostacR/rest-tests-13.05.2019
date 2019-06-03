package PetStore.Test;
import PetStore.endpoints.PetEndpoint;
import PetStore.models.CategoryModel;
import PetStore.models.PetModel;
import PetStore.models.PetOrder;
import PetStore.models.TagModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PetStoreOrderTest {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private PetModel petModel;
    private PetOrder petOrder;
    int idPetModel1 = 107;

    @Before
    public void preCondition(int idPetModel){
        petModel = new PetModel(
                idPetModel,
                new CategoryModel(),
                "Zorg-107",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");
        petEndpoint
                .createPet(petModel)
                .statusCode(200);
    }

    @After
    public void postCondition(){
        petEndpoint
                .deletPetById(petModel.getId())
                .statusCode(200);
    }

    @Test
    public void orderTest(int idPetModel1){
        petOrder = new PetOrder();


    }
}
//Делаем заказ. Просмотреть заказ.Указываем аЙдИ. Просмотреть заказ. Удалить созданное (почитсить за собой)
// Включить проверку ResponseBody
