// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 02-02-2015 22:51:47
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ChatServerInterface.java

package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Referenced classes of package chat:
//            ChatClientInterface

public interface ChatServerInterface
    extends Remote
{

    public abstract void login(String s, ChatClientInterface chatclientinterface)
        throws RemoteException;

    public abstract void takeMsg(String s)
        throws RemoteException;

    public abstract void logOut(String s)
        throws RemoteException;

    public abstract ChatClientInterface giveRef(String s)
        throws RemoteException;
}
