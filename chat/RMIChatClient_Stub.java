// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 02-02-2015 22:53:42
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package chat;

import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import java.rmi.server.*;
import java.util.Vector;

// Referenced classes of package chat:
//            ChatClientInterface

public final class RMIChatClient_Stub extends RemoteStub
    implements ChatClientInterface
{

    public RMIChatClient_Stub(RemoteRef remoteref)
    {
        super(remoteref);
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    public void pm(String s, ChatClientInterface chatclientinterface, String s1)
        throws RemoteException
    {
        try
        {
            super.ref.invoke(this, $method_pm_0, new Object[] {
                s, chatclientinterface, s1
            }, 0x8a6b6f8ac95366feL);
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public void takeClientList(Vector vector)
        throws RemoteException
    {
        try
        {
            super.ref.invoke(this, $method_takeClientList_1, new Object[] {
                vector
            }, 0xbe7d3754413bd193L);
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public void takeMsg(String s)
        throws RemoteException
    {
        try
        {
            super.ref.invoke(this, $method_takeMsg_2, new Object[] {
                s
            }, 0x77d34b1c473c7badL);
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    private static final long serialVersionUID = 2L;
    private static Method $method_pm_0;
    private static Method $method_takeClientList_1;
    private static Method $method_takeMsg_2;

    static 
    {
        try
        {
            $method_pm_0 = (chat.ChatClientInterface.class).getMethod("pm", new Class[] {
                java.lang.String.class, chat.ChatClientInterface.class, java.lang.String.class
            });
            $method_takeClientList_1 = (chat.ChatClientInterface.class).getMethod("takeClientList", new Class[] {
                java.util.Vector.class
            });
            $method_takeMsg_2 = (chat.ChatClientInterface.class).getMethod("takeMsg", new Class[] {
                java.lang.String.class
            });
        }
        catch(NoSuchMethodException _ex)
        {
            throw new NoSuchMethodError("stub class initialization failed");
        }
    }
}
