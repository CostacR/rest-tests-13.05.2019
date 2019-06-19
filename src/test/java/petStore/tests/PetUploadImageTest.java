package petStore.tests;
import net.thucydides.junit.annotations.Concurrent;
import petStore.endpoints.UploadImageEndpoint;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SerenityRunner.class)
@Concurrent(threads="4")
public class PetUploadImageTest {

    @Test
    public void uploadImageTest(){
        UploadImageEndpoint uploadImageEndpoint = new UploadImageEndpoint();

        String imageFileName = "zaec.jpeg";

        uploadImageEndpoint
                .uploadImage(101, imageFileName)
                .body("code", is(200));

    }



}
