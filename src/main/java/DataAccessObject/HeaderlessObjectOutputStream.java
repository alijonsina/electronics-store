package DataAccessObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class HeaderlessObjectOutputStream extends ObjectOutputStream {

    public HeaderlessObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // this is used to not write the header in the file since it
        // is updated each time something changes in the array
        // you can skip this class
    }

}