// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 02-02-2015 22:53:16
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RMIChatClient.java

package chat;

import java.awt.Container;
import java.awt.event.*;
import java.io.PrintStream;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import javax.swing.*;

// Referenced classes of package chat:
//            ChatServerInterface, ChatClientInterface

public class RMIChatClient extends JFrame
    implements ChatClientInterface, ActionListener
{
    public class MiniWindow extends JFrame
        implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            String s = jtf.getText();
            s = (new StringBuilder()).append(myName).append(":").append(s).toString();
            try
            {
                hisRef.pm(myName, RMIChatClient.this, s);
            }
            catch(Exception exception)
            {
                System.out.println(exception);
            }
            jta.append((new StringBuilder()).append(s).append("\n").toString());
            jtf.setText("");
        }

        Container c;
        JTextField jtf;
        JButton jbtn;
        JScrollPane jsp1;
        JTextArea jta;
        ChatClientInterface hisRef;
        String hisName;
        final RMIChatClient this$0;

        public MiniWindow(String s, ChatClientInterface chatclientinterface)
        {
            this$0 = RMIChatClient.this;
            super((new StringBuilder()).append("From").append(myName).append("to").append(s).toString());
            hisName = s;
            hisRef = chatclientinterface;
            setResizable(false);
            setSize(340, 280);
            setDefaultCloseOperation(2);
            c = getContentPane();
            c.setLayout(null);
            jta = new JTextArea();
            jsp1 = new JScrollPane(jta);
            jsp1.setBounds(5, 5, 325, 200);
            c.add(jsp1);
            jtf = new JTextField();
            jtf.setBounds(5, 210, 235, 25);
            c.add(jtf);
            jbtn = new JButton("Send");
            jbtn.setBounds(245, 210, 85, 25);
            c.add(jbtn);
            addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent windowevent)
                {
                    ht.remove(hisName);
                }

                final RMIChatClient val$this$0;
                final MiniWindow this$1;


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
            }
);
            jtf.addActionListener(this);
            jbtn.addActionListener(this);
            jta.setEditable(false);
            setVisible(true);
        }
    }


    public RMIChatClient(String s)
    {
        super((new StringBuilder()).append("ChatClient:").append(s).toString());
        key = "rmi://localhost:1099/mikado";
        ht = new Hashtable();
        myName = s;
        setResizable(false);
        setSize(720, 470);
        setDefaultCloseOperation(3);
        c = getContentPane();
        c.setLayout(null);
        jta = new JTextArea();
        jsp1 = new JScrollPane(jta);
        jsp1.setBounds(5, 5, 500, 400);
        c.add(jsp1);
        model = new DefaultListModel();
        list = new JList(model);
        jsp2 = new JScrollPane(list);
        jsp2.setBounds(510, 5, 200, 400);
        c.add(jsp2);
        jtf = new JTextField();
        jtf.setBounds(5, 410, 500, 25);
        c.add(jtf);
        jbtn = new JButton("Send");
        jbtn.setBounds(510, 400, 200, 25);
        c.add(jbtn);
        jtf.addActionListener(this);
        jbtn.addActionListener(this);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                try
                {
                    csi.logOut(myName);
                }
                catch(Exception exception1)
                {
                    System.out.println(exception1);
                }
            }

            final RMIChatClient this$0;

            
            {
                this$0 = RMIChatClient.this;
                super();
            }
        }
);
        list.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent mouseevent)
            {
                if(mouseevent.getClickCount() == 2)
                {
                    String s1 = (String)list.getSelectedValue();
                    MiniWindow miniwindow = (MiniWindow)ht.get(s1);
                    if(miniwindow == null)
                        try
                        {
                            ChatClientInterface chatclientinterface = csi.giveRef(s1);
                            MiniWindow miniwindow1 = new MiniWindow(s1, chatclientinterface);
                            ht.put(s1, miniwindow1);
                        }
                        catch(Exception exception1)
                        {
                            System.out.println(exception1);
                        }
                }
            }

            final RMIChatClient this$0;

            
            {
                this$0 = RMIChatClient.this;
                super();
            }
        }
);
        try
        {
            csi = (ChatServerInterface)Naming.lookup(key);
            UnicastRemoteObject.exportObject(this);
            csi.login(myName, this);
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
        jta.setEditable(false);
        setVisible(true);
    }

    public void pm(String s, ChatClientInterface chatclientinterface, String s1)
    {
        MiniWindow miniwindow = (MiniWindow)ht.get(s);
        if(miniwindow == null)
        {
            miniwindow = new MiniWindow(s, chatclientinterface);
            ht.put(s, miniwindow);
        }
        miniwindow.jta.append((new StringBuilder()).append(s1).append("\n").toString());
    }

    public void takeMsg(String s)
    {
        jta.append((new StringBuilder()).append(s).append("\n").toString());
    }

    public void takeClientList(final Vector clients)
    {
        SwingUtilities.invokeLater(new Runnable() {

            public void run()
            {
                model.removeAllElements();
                String s;
                for(Enumeration enumeration = clients.elements(); enumeration.hasMoreElements(); model.addElement(s))
                    s = (String)enumeration.nextElement();

            }

            final Vector val$clients;
            final RMIChatClient this$0;

            
            {
                this$0 = RMIChatClient.this;
                clients = vector;
                super();
            }
        }
);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        String s = jtf.getText();
        s = (new StringBuilder()).append(myName).append(":").append(s).toString();
        try
        {
            csi.takeMsg(s);
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
        jtf.setText("");
    }

    public static void main(String args[])
    {
        RMIChatClient rmichatclient = new RMIChatClient(args[0]);
    }

    Container c;
    Hashtable ht;
    JTextField jtf;
    JList list;
    JButton jbtn;
    JScrollPane jsp1;
    JScrollPane jsp2;
    DefaultListModel model;
    JTextArea jta;
    String key;
    ChatServerInterface csi;
    String myName;
}
