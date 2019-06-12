package Weather;
import groovy.json.StringEscapeUtils;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

@RunWith(SerenityRunner.class)
public class WeatherTest {

//    @Test
//    public void getDroidNames (){
//        get("https://swapi.co/api/people/1/")
//                .then().statusCode(200)
//                .and()
//                .body("gender", equalTo("n/a"));
//
//        System.out.println();
//    }

@Test
//@Step
    public void getWeatherPerCityTest (){
        String cityName = "LVIV";
        RestAssured.baseURI = "https://pinformer.sinoptik.ua/"; //URL - запроса
      //  RestAssured.basePath = "search.php";//первый вариант передачи BasePath через параметр

        ValidatableResponse responseCityIndex = SerenityRest.given()//команда given это знак вопроса в запросе после которого пишутся параметры запроса
              //  .basePath("search.php") //второй вариант передачи BasePath через параметр
                .param("lang", "ua")
                .param("return id", 1)
                .param("q", cityName)
                .log().uri()
                .get("search.php")//третий вариант передачи BasePath через параметр GET
                //.get()
                .then()
//                .log().all()
                .statusCode(200);//assretCode - проверяет возвращаемый код. Если его изменить на 300, 400 - то тест упадет
//передача статических параметров хорошо при сборке Preconditions
        //есть смысл передавать его в параметрах

        String cityId = responseCityIndex.extract().asString();
        System.out.println(cityId);
        cityId = cityId.substring(cityId.lastIndexOf("|")+1);
//        cityId = cityId.substring(cityId.indexOf(10));
        System.out.println(cityId);

       // RestAssured.basePath = "pinformer4.php";

        ValidatableResponse responseWeatherIndex = SerenityRest.given()///команда given это знак вопроса в запросе после которого пишутся параметры запроса
                .param("type", "js")
                .param("lang", "uk")
                .param("id", cityId)
                .log().uri()
                .get("pinformer4.php")
                .then()
//                .log().all()//print Json on Console
                .statusCode(200)
                .body("any {it.key == '{pcity}'}", is(true))//groovyPath with hamcrest matchers
                .body("'{pcity}'", is(cityId))//JSON path with hamcrast matchers
                .body("'{pcity}'", is(not (1)))
                .log().all()
                ;

        System.out.println(String.valueOf(responseWeatherIndex.extract().path("'{pcity}'")));//строка достаёт из JSON по имени тега данные
        System.out.println(cityId.length());

//groovyPath

//        String weather = responseWeatherIndex.extract().asString();
//        weather =  StringEscapeUtils.unescapeJava(weather);
//        System.out.println(weather);
//        System.out.println();
//        weather =weather.substring(weather.lastIndexOf("pcity")+3);
//        System.out.println(weather);
    }

//    public void getWeatherPerCityTest (){
//        String cityName = "LVIV";
//        RestAssured.baseURI = "https://pinformer.sinoptik.ua/"; //URL - запроса
//        //  RestAssured.basePath = "search.php";//первый вариант передачи BasePath через параметр
//
//        ValidatableResponse responseCityIndex = RestAssured.given()//команда given это знак вопроса в запросе после которого пишутся параметры запроса
//                //  .basePath("search.php") //второй вариант передачи BasePath через параметр
//                .param("lang", "ua")
//                .param("return id", 1)
//                .param("q", cityName)
//                .log().uri()
//                .get("search.php")//третий вариант передачи BasePath через параметр GET
//                //.get()
//                .then()
////                .log().all()
//                .statusCode(200);//assretCode - проверяет возвращаемый код. Если его изменить на 300, 400 - то тест упадет
////передача статических параметров хорошо при сборке Preconditions
//        //есть смысл передавать его в параметрах
//
//        String cityId = responseCityIndex.extract().asString();
//        System.out.println(cityId);
//        cityId = cityId.substring(cityId.lastIndexOf("|")+1);
////        cityId = cityId.substring(cityId.indexOf(10));
//        System.out.println(cityId);
//
//        // RestAssured.basePath = "pinformer4.php";
//
//        ValidatableResponse responseWeatherIndex = RestAssured.given()///команда given это знак вопроса в запросе после которого пишутся параметры запроса
//                .param("type", "js")
//                .param("lang", "uk")
//                .param("id", cityId)
//                .log().uri()
//                .get("pinformer4.php")
//                .then()
////                .log().all()//print Json on Console
//                .statusCode(200)
//                .body("any {it.key == '{pcity}'}", is(true))//groovyPath with hamcrest matchers
//                .body("'{pcity}'", is(cityId))//JSON path with hamcrast matchers
//                .body("'{pcity}'", is(not (1)))
//                .log().all()
//                ;
//
//        System.out.println(responseWeatherIndex.extract().path("'{pcity}'"));//строка достаёт из JSON по имени тега данные
//        System.out.println(cityId.length());
//
////groovyPath
//
////        String weather = responseWeatherIndex.extract().asString();
////        weather =  StringEscapeUtils.unescapeJava(weather);
////        System.out.println(weather);
////        System.out.println();
////        weather =weather.substring(weather.lastIndexOf("pcity")+3);
////        System.out.println(weather);
//    }


}
