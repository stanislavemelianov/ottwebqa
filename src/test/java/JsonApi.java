import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsonApi {
    @Test
    public void testResponse() {
        Response resp = RestAssured.get("https://www.onetwotrip.com/_hotels/api/suggestRequest");
        int code = resp.getStatusCode();
        Assert.assertEquals(code, 200);
        System.out.println("Status code is " + code);
         //проверка что метод доступен//
    }
}
