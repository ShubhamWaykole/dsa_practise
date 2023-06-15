

import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChangeText {

    public static final String SRC = "D:/Office/90015954_SL.PDF";
    public static final String DEST = "D:/Office/90016125_SL.PDF";

    public static void main(String[] args) throws Exception
    {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ChangeText().manipulatePdf(SRC, DEST);
    }

    public static void manipulatePdf(String src, String dest) throws Exception{
        PdfReader reader = new PdfReader(src);
        int pNumbers = reader.getNumberOfPages();
        PRStream stream;
        for (int i= 1 ; i <= pNumbers;i++){
            PdfDictionary  dict = reader.getPageN(i);
            PdfObject  object = dict.getDirectObject(PdfName.CONTENTS);
            if (object instanceof PRStream) {
                stream = (PRStream) object;
                byte[] data = PdfReader.getStreamBytes(stream);
                String dd = new String(data);
                dd = dd.replaceAll("MOHIT", "SHUBHAM");
                stream.setData(dd.getBytes());
            }
        }

        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.close();
        reader.close();
    }

}
