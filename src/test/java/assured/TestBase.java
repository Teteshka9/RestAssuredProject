package assured;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import domain.AdvancedNote;
import dto.RequestDTO;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import java.security.Key;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBase {

    protected final String PUB_KEY = System.getProperty("public_api_key");
    protected final String DEV_KKEY = System.getProperty("dev_api_key");

    protected static ObjectMapper objectMapper;
    private static String BASE_URL = "https://reqres.in/api";
    private static RequestSpecification requestSpecification;


    @BeforeAll
    static void init() {

        objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(new ObjectMapperConfig()
                        .jackson2ObjectMapperFactory((type, charset) -> objectMapper));
    }

    @BeforeEach
    void initSpec() {
        String key = System.getProperty("dev_api_key");
        if (key == null) {throw new RuntimeException("YOUR API KEY IS MISSING, CHECK YOU API KEY!!!!");}

        requestSpecification = RestAssured
                .given()
                .baseUri(BASE_URL)
                .header("x-api-key", key)
                .header("X-Reqres-Env", "dev")
                .contentType("application/json")
                .accept(ContentType.JSON);
    }


    protected Response createNote(AdvancedNote myNote) {
        return requestSpecification
                .body(new RequestDTO(myNote))
                .post("/collections/notes/records");
    }
}


