import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Login {
    public static void main(String[] args) throws IOException {
        File file = new File("/var/log/auth.log");
        System.out.println("File opened successfully:");
        Files.lines(file.toPath())
                .filter(s -> s.contains("authentication failure"))
                .forEach(e -> {
                            System.out.println("\nIntruder Authentication Failure:");
//                            System.out.println("User: " + e.substring(153));
                            System.out.println("Date: " + e.substring(0, 6));
                            System.out.println("Time: " + e.substring(7, 16));
                            System.out.println("___________________________________________________");
                        }
                );
        Files.lines(file.toPath())
                .filter(s -> s.contains("login keyring"))
                .forEach(e -> {
                            System.out.println("\nSuccessful Login");
//                            System.out.println("User: " + e.substring(153));
                            System.out.println("Date: " + e.substring(0, 6));
                            System.out.println("Time: " + e.substring(7, 16));
                            System.out.println("___________________________________________________");
                        }
                );
    }
}
