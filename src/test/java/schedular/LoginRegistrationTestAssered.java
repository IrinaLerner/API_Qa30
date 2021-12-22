package schedular;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import schedulardto.AuthRequestDto;
import schedulardto.AuthResponseDto;
import static com.jayway.restassured.RestAssured.given;

public class LoginRegistrationTestAssered {
@BeforeMethod
    public void precondition(){
    RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/ ";
    RestAssured.basePath ="api";
}
 @Test
    public void loginSuccess(){
     AuthRequestDto auth = AuthRequestDto.builder()
             .email("noa@gmail.com")
             .password("Nnoa12345$")
             .build();
     given()
             .body(auth)
             .contentType("application/json")
             .when()
             .post("login")
             .then()
             .assertThat().statusCode(200)l77


