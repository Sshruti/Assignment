// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 02-02-2015 22:51:32
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ChatClientInterface.java

package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface ChatClientInterface
    extends Remote
{

    public abstract void takeMsg(String s)
        throws RemoteException;

    public abstract void takeClientList(Vector vector)
        throws RemoteException;

    public abstract void pm(String s, ChatClientInterface chatclientinterface, String s1)
        throws RemoteException;
}
