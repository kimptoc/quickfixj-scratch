package qftest;

import quickfix.*;

import java.io.IOException;

/**
 * Created by kimptoc on 15/01/2014.
 */
public class QuickfixIn {
    public static void main(String[] args) throws ConfigError, IOException {
        System.out.println("Starting Acceptor!");

        if(args.length != 1) return;
        QuickfixBase quickfixBase = new QuickfixBase().invoke(args[0]);
        Acceptor acceptor = new SocketAcceptor
                (quickfixBase.getApplication(), quickfixBase.getStoreFactory(), quickfixBase.getSettings(),
                        quickfixBase.getLogFactory(), quickfixBase.getMessageFactory());
        acceptor.start();
        // while( condition == true ) { do something; }
//        acceptor.stop();
    }
}
