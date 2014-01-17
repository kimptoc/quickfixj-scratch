package qftest;

import quickfix.*;

import java.io.IOException;

/**
 * Created by kimptoc on 15/01/2014.
 */
public class QuickfixOut {
    public static void main(String[] args) throws ConfigError, IOException {
        System.out.println("Starting Initiator!");

        if(args.length != 1) return;
        QuickfixBase quickfixBase = new QuickfixBase().invoke(args[0]);
        Initiator initiator = new SocketInitiator
                (quickfixBase.getApplication(), quickfixBase.getStoreFactory(), quickfixBase.getSettings(),
                        quickfixBase.getLogFactory(), quickfixBase.getMessageFactory());
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
