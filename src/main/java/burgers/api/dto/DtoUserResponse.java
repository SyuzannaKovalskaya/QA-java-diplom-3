package burgers.api.dto;

public class DtoUserResponse {
    private String accessToken;


    public String getToken() {
        return accessToken;
    }

    public void setToken(String token) {
        this.accessToken = token;
    }
}
