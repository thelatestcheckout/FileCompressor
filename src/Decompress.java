import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompress {

    public static void decompress(File source, File output) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(output);

        byte[] buffer = new byte[1024];
        int read;

        GZIPInputStream gzis = new GZIPInputStream(fis);

        while ((read = gzis.read(buffer)) != -1) {
            fos.write(buffer, 0, read);
        }

        gzis.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) {
        File source = new File("/Users/aisgupta/Desktop/output.txt");
        File output = new File("/Users/aisgupta/Desktop/final.txt");

        try {
            decompress(source,output);
        }catch (IOException io){
            System.out.println(io);
        }
    }
}
