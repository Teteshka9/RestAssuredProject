package assured;

import domain.AdvancedNote;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class RestAssuredTest extends TestBase {

    private static String id;

    @Test
    @DisplayName("creating a note")
    @Order(1)
    void createNote() {
        AdvancedNote myNote = new AdvancedNote("Shopping list", "buy coffee", LocalDateTime.now().toString(), "PRIVATE");
        Response response = createNote(myNote);

        response.then().statusCode(200);

    }
}
