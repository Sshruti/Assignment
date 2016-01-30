// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 02-02-2015 22:52:39
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RMIChatClient.java

package chat;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

// Referenced classes of package chat:
//            RMIChatClient

class RMIChatClient$MiniWindow$1 extends WindowAdapter
{

    public void windowClosing(WindowEvent windowevent)
    {
        ht.remove(hisName);
    }

    final RMIChatClient val$this$0;
    final RMIChatClient.MiniWindow this$1;

    RMIChatClient$MiniWindow$1()
    {
        this$1 = final_miniwindow;
        val$this$0 = RMIChatClient.this;
        super();
    }
}
