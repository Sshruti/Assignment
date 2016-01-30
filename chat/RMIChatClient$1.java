// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 02-02-2015 22:51:57
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RMIChatClient.java

package chat;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;

// Referenced classes of package chat:
//            RMIChatClient, ChatServerInterface

class RMIChatClient$1 extends WindowAdapter
{

    public void windowClosing(WindowEvent windowevent)
    {
        try
        {
            csi.logOut(myName);
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    final RMIChatClient this$0;

    RMIChatClient$1()
    {
        this$0 = RMIChatClient.this;
        super();
    }
}
