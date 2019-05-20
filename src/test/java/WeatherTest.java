import groovy.json.StringEscapeUtils;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class WeatherTest {

    @Test
    public void getWeatherPerCityTest (){
        RestAssured.baseURI = "https://pinformer.sinoptik.ua/search.php"; //URL - запроса

        ValidatableResponse responseCityIndex = RestAssured.given()//команда given это знак вопроса в запросе после которого пишутся параметры запроса
                .param("lang", "ua")
                .param("return id", 1)
                .param("q", "Lviv")
                .log().uri()
                .get()
                .then()
//                .log().all()
                .statusCode(200);//assretCode - проверяет возвращаемый код. Если его изменить на 300, 400 - то тест упадет

        String cityId = responseCityIndex.extract().asString();
        System.out.println(cityId);
        cityId = cityId.substring(cityId.lastIndexOf("|")+1);
        System.out.println(cityId);

        RestAssured.baseURI = "https://pinformer.sinoptik.ua/pinformer4.php";

        ValidatableResponse responseWeatherIndex = RestAssured.given()///команда given это знак вопроса в запросе после которого пишутся параметры запроса
                .param("type", "js")
                .param("lang", "uk")
                .param("id", cityId)
                .log().uri()
                .get()
                .then()
                .log().all()
                .statusCode(200);


    }
}
