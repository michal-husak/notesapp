package notes.restassured;

import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import notes.testcategories.DeployTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.jayway.restassured.http.ContentType;

@Category(DeployTest.class)
public class RestAssuredTest {

    @Test
    public void test() {
        expect().
        statusCode(200).contentType(ContentType.JSON).body("size()", equalTo(2)).
       /* body(
          "email", equalTo("test@hascode.com"),
          "firstName", equalTo("Tim"),
          "lastName", equalTo("Testerman"),
          "id", equalTo("1")).*/
        when().
        get("http://localhost:8080/rest-service/notes"); 
    }

}
