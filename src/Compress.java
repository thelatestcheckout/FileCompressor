import java.io.*;
import java.util.zip.*;

public class Compress {

    public static void compress(File source, File output) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(output);

        byte[] buffer = new byte[1024];
        int read;

        GZIPOutputStream gzos = new GZIPOutputStream(fos);

        while ((read = fis.read(buffer)) != -1) {
            gzos.write(buffer, 0, read);
        }

        gzos.finish();
        gzos.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) {
        File source = new File("/Users/aisgupta/Downloads/sample3.txt");
        File output = new File("/Users/aisgupta/Desktop/output.txt");

        try {
            compress(source,output);
        }catch (IOException io){
            System.out.println(io);
        }
    }
}
