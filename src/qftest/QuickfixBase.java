package qftest;

import quickfix.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
* Created by kimptoc on 16/01/2014.
*/
public class QuickfixBase {
    private Application application;
    private SessionSettings settings;
    private MessageStoreFactory storeFactory;
    private LogFactory logFactory;
    private MessageFactory messageFactory;

    public Application getApplication() {
        return application;
    }

    public SessionSettings getSettings() {
        return settings;
    }

    public MessageStoreFactory getStoreFactory() {
        return storeFactory;
    }

    public LogFactory getLogFactory() {
        return logFactory;
    }

    public MessageFactory getMessageFactory() {
        return messageFactory;
    }

    public QuickfixBase invoke(String fileName) throws IOException {

        // FooApplication is your class that implements the Application interface
        application = new FixHandler();

        Properties props = new Properties();
        props.load(new FileInputStream(fileName));
//        SessionSettings settings = new SessionSettings(new FileInputStream(fileName));
        settings = new SessionSettings();
        String beginStr = props.getProperty("BeginString");
        String senderComp = props.getProperty("SenderCompID");
        String targetComp = props.getProperty("TargetCompID");
        SessionID sessionId = new SessionID(beginStr, senderComp, targetComp);
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            settings.setString(sessionId, entry.getKey().toString(), entry.getValue().toString());
        }
//        settings.set(props);
//        settings.setVariableValues(props);
//        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        storeFactory = new JdbcStoreFactory(settings);
//        logFactory = new FileLogFactory(settings);
        logFactory = new JdbcLogFactory(settings);
        messageFactory = new DefaultMessageFactory();
        return this;
    }
}
