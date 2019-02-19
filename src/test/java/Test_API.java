import org.junit.Test;
import static com.jayway.restassured.RestAssured .*;
import static org.hamcrest.Matchers .*;
import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;


public class Test_API {

    public static String user;
    public static String apiKey;
    public static String format;
    public static RequestSpecification spec;


    @BeforeClass
    public static void SetUp() {
        RestAssured.baseURI = "http://ws.audioscrobbler.com/2.0/";
        user = "daria_malakhova";
        apiKey = "a7d3f11f71514e13274e7c9b8ac548e2";
        format = "json";
        spec = new RequestSpecBuilder().addParam("limit", 1).addParam("api_key", apiKey).addParam("format", format).build();

    }

    @Test
    public void auth(){
        given()
                .when()
                .get("http://www.last.fm/api/auth/?api_key=a7d3f11f71514e13274e7c9b8ac548e2")
                .then()
                .statusCode(200);
    }

    @Test
    public void artistSearch() {
        given()
                .params("artist", "Tesseract")
                .spec(spec)
                .when()
                .get("?method=artist.search")
                .then()
                .body("results.artistmatches.artist.name", contains("TesseracT"));
    }

    @Test
    public void albumSearch() {
        given()
                .params("album", "Altered State")
                .spec(spec)
                .when()
                .get("?method=album.search")
                .then()
                .body("results.albummatches.album.name", contains("Altered State"));
    }


}
