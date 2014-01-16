package test;

import quickfix.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by kimptoc on 15/01/2014.
 */
public class QuickfixIn {
    public static void main(String[] args) throws ConfigError, FileNotFoundException {
        System.out.println("Starting Acceptor!");

        if(args.length != 1) return;
        String fileName = args[0];

        // FooApplication is your class that implements the Application interface
        Application application = new FixHandler();

        SessionSettings settings = new SessionSettings(new FileInputStream(fileName));
//        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        MessageStoreFactory storeFactory = new JdbcStoreFactory(settings);
        LogFactory logFactory = new FileLogFactory(settings);
        MessageFactory messageFactory = new DefaultMessageFactory();
        Acceptor acceptor = new SocketAcceptor
                (application, storeFactory, settings, logFactory, messageFactory);
        acceptor.start();
        // while( condition == true ) { do something; }
//        acceptor.stop();
    }
}
