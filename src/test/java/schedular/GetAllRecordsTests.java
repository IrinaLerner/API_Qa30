package schedular;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import schedulardto.GetAllRecords;
import schedulardto.GetRecordsRequest;
import schedulardto.RecordDto;

import static com.jayway.restassured.RestAssured.given;

public class GetAllRecordsTests {

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5vYUBnbWFpbC5jb20ifQ.G_wfK7FRQLRTPu9bs2iDi2fcs69FHmW-0dTY4v8o5Eo";

    @BeforeMethod
    public void  precondition() {

        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/ ";
        RestAssured.basePath = "api";

    }
    @Test
    public void getAllRecords(){
        GetRecordsRequest request = GetRecordsRequest.builder()
                .monthFrom(5)
                .monthTo(12)
                .yearFrom(2021)
                .yearTo(2021)
                .build();

        GetAllRecords records = given()
                .header("Autorization",token)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("records")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(GetAllRecords.class);
        System.out.println(records.getList().size());



        /*for(RecordDto record: recordsDto.getList()){
            System.out.println(record.getId());
            System.out.println("**********************");

        }
*/
    }
}
