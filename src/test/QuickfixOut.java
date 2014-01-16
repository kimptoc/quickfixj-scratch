package test;

import quickfix.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by kimptoc on 15/01/2014.
 */
public class QuickfixOut {
    public static void main(String[] args) throws ConfigError, IOException {
        System.out.println("Starting Initiator!");

        if(args.length != 1) return;
        String fileName = args[0];

        // FooApplication is your class that implements the Application interface
        Application application = new FixHandler();

        Properties props = new Properties();
        props.load(new FileInputStream(fileName));
//        SessionSettings settings = new SessionSettings(new FileInputStream(fileName));
        SessionSettings settings = new SessionSettings();
        settings.set(props);
//        settings.setVariableValues(props);
//        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        MessageStoreFactory storeFactory = new JdbcStoreFactory(settings);
        LogFactory logFactory = new FileLogFactory(settings);
        MessageFactory messageFactory = new DefaultMessageFactory();
        Initiator initiator = new SocketInitiator
                (application, storeFactory, settings, logFactory, messageFactory);
        initiator.start();
        // while( condition == true ) { do something; }
//        initiator.stop();
        while (true)
        {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                //ignored
            }
        }
    }
}
