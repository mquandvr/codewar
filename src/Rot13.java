import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class Rot13 {

    public static void main(String[] args) {
        String message = "2^A3YWSHcxIBC1c1AX32$kkh*v)EavU7vköAh^HIDzfX+yM9z*gAürtEf %Ur";
        rot13(message);
    }



    private static void rot13(String message) {

        var input = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        var output = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm";

        StringBuilder sb = new StringBuilder();
        var result = Objects.requireNonNullElse(message, "").chars().mapToObj(c -> "" + (char) c)
                .map(c -> "" + (char) (c.charAt(0) + (c.matches("(?i)[A-M]") ? 13 : c.matches("(?i)[N-Z]") ? -13 : 0)))
                .collect(joining());
        System.out.println(result);
        System.out.println(sb.toString());
    }
}
