package klassen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by bart-_000 on 2-3-2017.
 */
//Extract Interface
public interface FileMakerInterface extends Serializable {
    void slaMainOp(HoofdController a) throws IOException;

    HoofdController openMain() throws IOException;
}
