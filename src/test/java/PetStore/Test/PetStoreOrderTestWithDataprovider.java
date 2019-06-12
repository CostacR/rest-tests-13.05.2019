package PetStore.Test;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.runner.RunWith;

import PetStore.endpoints.OrderEndpoint;
import PetStore.models.PetOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class PetStoreOrderTestWithDataprovider {
    
    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
            {1, "Zooko"},
            {2, "CoocooRoocoo"}
        });
    }

    private int idPet;
    private String namePet;

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }


    private String shipDate;
    @Steps
    private OrderEndpoint orderEndpoint;
    private PetOrder petOrder;





    @Test
    public void orderTest() {
        orderEndpoint
                .createOrder(petOrder);
    }

    @Before
    public void preCondition() {

        String timeEndString = "T00:00:00.000+0000";
        shipDate = "2019-06-12" + timeEndString;

        petOrder = new PetOrder(
                1,
                idPet,
                2,
                shipDate,
                "placed",
                false);
    }

    @After
    public void postCondition() {
        orderEndpoint
                .deleteOrderById(petOrder.getId())
                .statusCode(200);
    }
}
