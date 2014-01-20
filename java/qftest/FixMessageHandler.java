package qftest;

import quickfix.Message;

/**
 * Created by kimptoc on 20/01/2014.
 */
public interface FixMessageHandler {

    public boolean process(Message m);
}
