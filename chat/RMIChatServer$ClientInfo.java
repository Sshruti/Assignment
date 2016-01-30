// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 02-02-2015 22:54:51
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RMIChatServer.java

package chat;


// Referenced classes of package chat:
//            RMIChatServer, ChatClientInterface

class RMIChatServer$ClientInfo
{

    public boolean equals(Object obj)
    {
        if(obj instanceof RMIChatServer$ClientInfo)
            return ((RMIChatServer$ClientInfo)obj).name.equals(name);
        else
            return false;
    }

    String name;
    ChatClientInterface ref;
    final RMIChatServer this$0;

    public RMIChatServer$ClientInfo(String s, ChatClientInterface chatclientinterface)
    {
        this$0 = RMIChatServer.this;
        super();
        name = s;
        ref = chatclientinterface;
    }
}
