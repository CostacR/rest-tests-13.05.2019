package PetStore.Test;
import PetStore.endpoints.PetEndpoint;
import PetStore.models.CategoryModel;
import PetStore.models.PetModel;
import PetStore.models.TagModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PetUpdateTest {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private PetModel petModel;

    @Before
    public void preCondition(){
        petModel = new PetModel(
                107,
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
    public void updatePetTest(){

        petModel.setName("Doopy");
        petModel.setStatus("SOLD");

        petEndpoint
                .updatePet(petModel)
                .statusCode(200);

        petEndpoint
                .getPetById(petModel.getId())
                .statusCode(200);

    }
    //создаем животных для заказа.
//Делаем заказ. Просмотреть заказ.Указываем аЙдИ. Просмотреть заказ. Удалить созданное (почитсить за собой)
// Включить проверку ResponseBody
}
