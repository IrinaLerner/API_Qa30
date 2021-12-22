package schedular;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import schedulardto.AuthRequestDto;
import schedulardto.AuthResponseDto;
import schedulardto.ErrorDto;
import static org.hamcrest.Matchers.containsString;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginRegistrationTestAssered {
    @BeforeMethod
    public void precondition() {
        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/ ";
        RestAssured.basePath = "api";
    }

    @Test
    public void loginSuccess() {
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
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);

        System.out.println();
    }
    @Test
    public void wrongPasswordTest(){
        AuthRequestDto auth = AuthRequestDto.builder()
                .email("noa@gmail.com")
                .password("Nnoa12345$")
                .build();

        ErrorDto errorDto = given().body(auth).contentType("application/json")
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.toString());
        Assert.assertEquals(errorDto.getMessage(),"Wrong email or password");

    }

    @Test
    public void wrongPasswordTest2(){
        AuthRequestDto auth = AuthRequestDto.builder()
                .email("noa@gmail.com")
                .password("Nnoa12345")
                .build();

        ErrorDto errorDto = given().body(auth).contentType("application/json")
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.toString());
        Assert.assertEquals(errorDto.getMessage(),"Wrong email or password");

    }

    @Test
    public void registrationTest(){
        AuthRequestDto auth = AuthRequestDto.builder()
                .email("agf@gmail.com")
                .password("Nnoa12345$")
                .build();
        given().contentType(ContentType.JSON).body(auth)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("status",containsString("Registration success"))
                .assertThat().body("registration",equalTo(true))
                .extract().path("token");
       // System.out.println(token);


    }
}


