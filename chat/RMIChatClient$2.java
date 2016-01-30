// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 02-02-2015 22:52:10
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RMIChatClient.java

package chat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.util.Hashtable;
import javax.swing.JList;

// Referenced classes of package chat:
//            RMIChatClient, ChatServerInterface

class RMIChatClient$2 extends MouseAdapter
{

    public void mouseClicked(MouseEvent mouseevent)
    {
        if(mouseevent.getClickCount() == 2)
        {
            String s = (String)list.getSelectedValue();
            niWindow niwindow = (niWindow)ht.get(s);
            if(niwindow == null)
                try
                {
                    ChatClientInterface chatclientinterface = csi.giveRef(s);
                    niWindow niwindow1 = new niWindow(RMIChatClient.this, s, chatclientinterface);
                    ht.put(s, niwindow1);
                }
                catch(Exception exception)
                {
                    System.out.println(exception);
                }
        }
    }

    final RMIChatClient this$0;

    RMIChatClient$2()
    {
        this$0 = RMIChatClient.this;
        super();
    }
}
