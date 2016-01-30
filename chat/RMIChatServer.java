// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 02-02-2015 22:49:26
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RMIChatServer.java

package chat;

import java.io.PrintStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package chat:
//            ChatServerInterface, ChatClientInterface

public class RMIChatServer extends UnicastRemoteObject
    implements ChatServerInterface
{
    class ClientInfo
    {

        public boolean equals(Object obj)
        {
            if(obj instanceof ClientInfo)
                return ((ClientInfo)obj).name.equals(name);
            else
                return false;
        }

        String name;
        ChatClientInterface ref;
        final RMIChatServer this$0;

        public ClientInfo(String s, ChatClientInterface chatclientinterface)
        {
            this$0 = RMIChatServer.this;
            super();
            name = s;
            ref = chatclientinterface;
        }
    }


    public RMIChatServer()
        throws RemoteException
    {
        identity = "mikado";
        v = new Vector();
        try
        {
            LocateRegistry.createRegistry(1099);
            Naming.rebind(identity, this);
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    public void login(String s, ChatClientInterface chatclientinterface)
    {
        ClientInfo clientinfo = new ClientInfo(s, chatclientinterface);
        v.add(clientinfo);
        broadcastMsg((new StringBuilder()).append(s).append(" ").append("logged In").toString());
        broadcastList();
    }

    public void takeMsg(String s)
    {
        broadcastMsg(s);
    }

    public void logOut(String s)
    {
        v.remove(new ClientInfo(s, null));
        broadcastMsg((new StringBuilder()).append(s).append("has logged out").toString());
        broadcastList();
    }

    public void broadcastMsg(String s)
    {
        for(Enumeration enumeration = v.elements(); enumeration.hasMoreElements();)
        {
            ClientInfo clientinfo = (ClientInfo)enumeration.nextElement();
            try
            {
                clientinfo.ref.takeMsg(s);
            }
            catch(Exception exception)
            {
                System.out.println(exception);
            }
        }

    }

    public void broadcastList()
    {
        Vector vector = new Vector();
        ClientInfo clientinfo;
        for(Enumeration enumeration = v.elements(); enumeration.hasMoreElements(); vector.add(clientinfo.name))
            clientinfo = (ClientInfo)enumeration.nextElement();

        for(Enumeration enumeration1 = v.elements(); enumeration1.hasMoreElements();)
        {
            ClientInfo clientinfo1 = (ClientInfo)enumeration1.nextElement();
            try
            {
                clientinfo1.ref.takeClientList(vector);
            }
            catch(Exception exception)
            {
                System.out.println(exception);
            }
        }

    }

    public ChatClientInterface giveRef(String s)
    {
        ClientInfo clientinfo = new ClientInfo(s, null);
        if(v.contains(clientinfo))
        {
            int i = v.indexOf(clientinfo);
            clientinfo = (ClientInfo)v.get(i);
        }
        return clientinfo.ref;
    }

    public static void main(String args[])
    {
        try
        {
            new RMIChatServer();
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Vector v;
    String identity;
}
