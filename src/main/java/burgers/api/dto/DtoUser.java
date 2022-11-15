package burgers.api.dto;

public class DtoUser {

    private String email;
    private String password;


    public DtoUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public DtoUser(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
