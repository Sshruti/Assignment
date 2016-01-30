// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 02-02-2015 22:52:53
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RMIChatClient.java

package chat;

import java.awt.Container;
import java.awt.event.*;
import java.io.PrintStream;
import java.util.Hashtable;
import javax.swing.*;

// Referenced classes of package chat:
//            RMIChatClient, ChatClientInterface

public class RMIChatClient$MiniWindow extends JFrame
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

    public RMIChatClient$MiniWindow(String s, ChatClientInterface chatclientinterface)
    {
        this.this$0 = RMIChatClient.this;
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
            final RMIChatClient.MiniWindow this$1;

            
            {
                this$1 = RMIChatClient.MiniWindow.this;
                this$0 = rmichatclient;
                super();
            }
        }
);
        jtf.addActionListener(this);
        jbtn.addActionListener(this);
        jta.setEditable(false);
        setVisible(true);
    }
}
