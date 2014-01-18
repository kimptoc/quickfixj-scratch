package qftest;

import quickfix.*;
import quickfix.field.*;

import java.io.IOException;
import java.util.Date;

/**
 * Created by kimptoc on 15/01/2014.
 */
public class QuickfixOut {
    public static void main(String[] args) throws ConfigError, IOException {
        System.out.println("Starting Initiator!");

        if(args.length != 1) return;
        QuickfixBase qf = new QuickfixBase().invoke(args[0]);
        Initiator initiator = new SocketInitiator
                (qf.getApplication(), qf.getStoreFactory(), qf.getSettings(),
                        qf.getLogFactory(), qf.getMessageFactory());
        initiator.start();
        // while( condition == true ) { do something; }
//        initiator.stop();
        while (true)
        {
            try {
                quickfix.fix44.NewOrderSingle msg = new quickfix.fix44.NewOrderSingle();
                msg.set(new Currency("GBP"));
                msg.set(new Symbol("XS123"));
                msg.set(new Side(Side.BUY));
                msg.set(new OrdType(OrdType.MARKET));
                msg.set(new ClOrdID("xxx"));
                msg.set(new TransactTime(new Date()));
                String sender = qf.getSettings().getString(qf.getSessionId(), SessionSettings.SENDERCOMPID);
                SenderCompID senderField = new SenderCompID(sender);
                msg.getHeader().setField(senderField);
                Session.sendToTarget(msg, qf.getSessionId());
            } catch (Throwable err) {
                err.printStackTrace();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                //ignored
            }
        }
    }

}
