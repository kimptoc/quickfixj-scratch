package test;

import quickfix.*;

/**
 * Created by kimptoc on 15/01/2014.
 */
public class FixHandler implements Application {

    @Override
    public void onCreate(SessionID sessionID) {
        Log.debug("onCreate:"+sessionID);
    }

    @Override
    public void onLogon(SessionID sessionID) {
        Log.debug("onLogon:"+sessionID);
    }

    @Override
    public void onLogout(SessionID sessionID) {
        Log.debug("onLogout:"+sessionID);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        Log.debug("toAdmin:"+sessionID);
        Log.debug(message);
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        Log.debug("fromAdmin:"+sessionID);
        Log.debug(message);
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        Log.debug("toApp:"+sessionID);
        Log.debug(message);
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        Log.debug("fromApp:"+sessionID);
        Log.debug(message);
    }
}
