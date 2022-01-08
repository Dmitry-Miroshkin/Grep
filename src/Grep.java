import java.io.FileInputStream;
import java.io.IOException;

public class Grep {
    public static void main(String[] args) {
        if ((args.length == 0) || (args.length > 2)) {
            System.out.println("Usage: java Grep <example> <file_name>");
            System.exit(0);
        }

        try {
            FileInputStream fis = new FileInputStream(args[1]);
            GrepInputStream gis = new GrepInputStream(fis, args[0]);
            String line;
            do {
                line = gis.readLine();
                if (line != null) System.out.println(line);
            } while (line != null);
            gis.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
