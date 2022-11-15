package burgers.testData;

public class GenerateUserData {
    public static String getRandomEmail() {
        return String.format("alex%d", ((int) (Math.random() * (9999 - 1111) + 1111))) + "@gmail.com";
    }
}
