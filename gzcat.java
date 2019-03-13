import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class gzcat{
    public static void main(final String[] args) 
    throws IOException {
        try {
            for(int i=0;i<args.length;i++){
                process(new File(args[i]));
            }
        } catch (IOException e) {
            System.out.println("gzipファイル読込中に"+
                "例外が発生しました。処理中断します:" + 
                 e.toString());
        }
    }
     public static void process(final File file) throws IOException {
        final GZIPInputStream gzipInStream = new GZIPInputStream(
            new BufferedInputStream(new FileInputStream(file)));
        try {
            for (;;) {
                int iRead = gzipInStream.read();
                if (iRead < 0) break;
                System.out.write(iRead);
            }
        } finally {
            gzipInStream.close();
        }
    }
} 