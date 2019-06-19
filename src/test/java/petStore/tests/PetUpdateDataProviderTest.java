package petStore.tests;
import net.thucydides.junit.annotations.Concurrent;
import petStore.endpoints.PetEndpoint;
import petStore.models.CategoryModel;
import petStore.models.PetModel;
import petStore.models.TagModel;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads = "4")
public class PetUpdateDataProviderTest {


    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {1, "Zooko", 200},
                {2, "CoocooRoocoo", 200},
//                {3, null, 200}

        });
    }

    private int idPet;
    private String namePet;
    private int statusCode;

    public PetUpdateDataProviderTest(int idPet, String namePet, int statusCode)  {
        this.idPet = idPet;
        this.namePet = namePet;
        this.statusCode = statusCode;
    }

//    public PetUpdateDataProviderTest(int idPet, int statusCode)  {
//        this.idPet = idPet;
//        this.statusCode = statusCode;
//    }

    @Steps
    private PetEndpoint petEndpoint;
    private PetModel petModel;

    @Before
    public void preCondition(){
        petModel = new PetModel(
                idPet,
                new CategoryModel(),
                namePet,
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");
        petEndpoint
                .createPet(petModel)
                .statusCode(statusCode);
    }

    @After
    public void postCondition(){
        petEndpoint
                .deletPetById(petModel.getId())
                .statusCode(statusCode);
    }



    @Test
    public void updatePetTest(){

        petModel.setName("Doopy");
        petModel.setStatus("SOLD");

        petEndpoint
                .updatePet(petModel)
                .statusCode(statusCode);

        petEndpoint
                .getPetById(petModel.getId())
                .statusCode(statusCode);

    }

}
