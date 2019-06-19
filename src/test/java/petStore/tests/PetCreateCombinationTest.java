package petStore.tests;

import petStore.endpoints.PetEndpoint;
import petStore.models.CategoryModel;
import petStore.models.PetModel;
import petStore.models.TagModel;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@Concurrent//аннотация для запуска тестов паралельно. По умолчанию в 2 потока.
//@Concurrent(threads="4")//аннотация для запуска тестов в 4 потока
//@Concurrent(threads="4x")//аннотация для запуска тестов в 4 потока на каждый CPU

@RunWith(SerenityParameterizedRunner.class)//объявляем Серенити параметризированую
public class PetCreateCombinationTest {

    @Steps
    private PetEndpoint petEndpoint;

    @TestData//DataProvider
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"ChupaChupa",     200},//данные для dataProvider
//                {"DupaDupa",     200},
        });
    }
    private final String petName;//константы для работы
    private final int statusCode;


    public PetCreateCombinationTest(String petName, int statusCode)//конструктор с константами на входе
    {
        this.petName = petName;
        this.statusCode = statusCode;
    }

    @Test
    public void petCreateNameCombinationsTest(){
        PetModel petModel = new PetModel(
                new CategoryModel(),
                petName,
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");
        petEndpoint
                .createPet(petModel)
                .statusCode(statusCode);
    }

}
