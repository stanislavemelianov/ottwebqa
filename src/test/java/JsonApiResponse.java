import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class JsonApiResponse {
    @Test
    public void jsonApiResponse() {
        Response response = RestAssured.get("https://www.onetwotrip.com/_hotels/api/suggestRequest?query=Кёльн");
        JsonPath jsonPath = response.jsonPath();
        ArrayList<Object> result = jsonPath.get("result");
        HashMap<String, Object> q = (HashMap<String, Object>) result.get(0);
        Set<String> e = q.keySet();
        Assert.assertTrue(e.contains("country"));
        Assert.assertTrue(e.contains("timezone"));
        Assert.assertTrue(e.contains("city_id"));
        Assert.assertTrue((q.get("country").equals("Германия")));
        Assert.assertTrue((q.get("timezone").equals("Europe/Berlin")));
        Assert.assertTrue((q.get("city_id").equals(2886242)));
        //проверка что результат поиска город (city_id)
        //проверка что результат поиска в часовом поясе Берлина (timezone)
        //проверка что результат поиска находится в Германии (country)
    }
}
