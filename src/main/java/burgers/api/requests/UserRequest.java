package burgers.api.requests;

import burgers.api.dto.DtoUser;
import burgers.api.dto.DtoUserResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserRequest {
    public static DtoUserResponse loginUser(DtoUser user) {
        Response response = given().log().all()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/login");
        return response.as(DtoUserResponse.class);
    }

    public static void deleteUser(DtoUserResponse dtoUserResponse) {
        given().log().all()
                .header("Content-type", "application/json")
                .header("authorization", dtoUserResponse.getToken())
                .when()
                .delete("/api/auth/user")
                .then()
                .statusCode(202);

    }
}
