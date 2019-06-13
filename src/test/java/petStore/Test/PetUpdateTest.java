package petStore.Test;
import petStore.endpoints.PetEndpoint;
import petStore.models.CategoryModel;
import petStore.models.PetModel;
import petStore.models.TagModel;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class PetUpdateTest {

    @Steps
    private PetEndpoint petEndpoint;
    private PetModel petModel;

    @Before
    public void preCondition(){
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

}
