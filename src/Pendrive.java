import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;

public class Pendrive {
    public static void main(String[] args) throws IOException {
        File file = new File("/var/log/syslog");
        System.out.println("File opened successfully:");
        Iterator<String> stringIterator = Files.readAllLines(file.toPath()).iterator();
        while (stringIterator.hasNext()) {
            if (stringIterator.next().contains("New USB device found")) {
                String s = stringIterator.next();
                System.out.println("\nUSB Plugged in:");
                System.out.println("Date: " + s.substring(0, 6));
                System.out.println("Time: " + s.substring(7, 16));
                System.out.println(stringIterator.next().substring(61));
                System.out.println(stringIterator.next().substring(61));
                System.out.println(stringIterator.next().substring(61));
                System.out.println("___________________________________________________");
            }
        }
    }
}
