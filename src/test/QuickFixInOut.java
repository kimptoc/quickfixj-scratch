package test;

import quickfix.ConfigError;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by kimptoc on 16/01/2014.
 */
public class QuickFixInOut {

    public static void main(String[] args) throws IOException, ConfigError {
        QuickfixIn.main(new String[]{args[0]});
        QuickfixOut.main(new String[]{args[1]});
    }
}
