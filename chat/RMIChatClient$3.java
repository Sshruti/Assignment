// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 02-02-2015 22:52:27
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RMIChatClient.java

package chat;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.DefaultListModel;

// Referenced classes of package chat:
//            RMIChatClient

class RMIChatClient$3
    implements Runnable
{

    public void run()
    {
        model.removeAllElements();
        String s;
        for(Enumeration enumeration = val$clients.elements(); enumeration.hasMoreElements(); model.addElement(s))
            s = (String)enumeration.nextElement();

    }

    final Vector val$clients;
    final RMIChatClient this$0;

    RMIChatClient$3()
    {
        this$0 = final_rmichatclient;
        val$clients = Vector.this;
        super();
    }
}
