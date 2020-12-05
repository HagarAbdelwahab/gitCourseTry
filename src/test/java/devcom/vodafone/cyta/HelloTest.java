package devcom.vodafone.cyta;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;


//@runwith(dataproviderrunner.class)
@QuarkusTest
public class HelloTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello ds"));
    }
    @Test
    public void TestNumberOfUsers(){
        given().when().get("hello/user").then().log().all().
                assertThat().body(("data.size"),equalTo(6)).
                body("data[0].email",equalTo("michael.lawson@reqres.in"));
    }






}