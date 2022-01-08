import java.io.*;

public class GrepInputStream  extends FilterInputStream {
    String substring;
    BufferedReader br;

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected GrepInputStream(InputStream in, String substring) {
        super(in);
        this.br = new BufferedReader(new InputStreamReader(in));
        this.substring = substring;

    }

    public final String readLine() throws IOException {
        String line;
        do {
            line = br.readLine();
        } while ((line != null) && !line.contains(substring));
        return line;
    }
}
