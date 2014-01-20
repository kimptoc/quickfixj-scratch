package qftest;

import quickfix.*;

import java.io.IOException;

/**
 * Created by kimptoc on 15/01/2014.
 */
public class QuickfixIn implements FixMessageHandler {
    public static void main(String[] args) throws ConfigError, IOException {
        System.out.println("Starting Acceptor!");

        if(args.length != 1) return;

        QuickfixIn msgHandler = new QuickfixIn();

        QuickfixBase quickfixBase = new QuickfixBase().invoke(args[0], msgHandler);
        Acceptor acceptor = new SocketAcceptor
                (quickfixBase.getApplication(), quickfixBase.getStoreFactory(), quickfixBase.getSettings(),
                        quickfixBase.getLogFactory(), quickfixBase.getMessageFactory());
        acceptor.start();
        // while( condition == true ) { do something; }
//        acceptor.stop();
    }

    @Override
    public boolean process(Message m) {
        Log.debug("QuickFixIn - got a message:"+m);
        return false;
    }
}
