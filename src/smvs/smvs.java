/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.lang.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author KIIT
 */
public class smvs {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        JFrame f= new JFrame("SYSTEM-Welcome!");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.getContentPane().setBackground(Color.CYAN);
        Label l= new Label("SUPERMART \nLOGIN");
        l.setForeground(Color.GREEN);
        l.setFont(new Font("",Font.BOLD,80));
        Label lp= new Label("Enter SYSTEM Password:");
        lp.setFont(new Font("",Font.PLAIN,30));lp.setForeground(Color.GRAY);
        JPasswordField p= new JPasswordField();p.setFont(new Font("",Font.BOLD,25));
        JButton b= new JButton("LOG IN");
        JButton ex= new JButton("EXIT");
        Label m= new Label("");m.setFont(new Font("",Font.PLAIN,20));
        m.setForeground(Color.RED);
        f.add(lp);f.add(l);f.add(p);f.add(b);f.add(ex);f.add(m);
        f.setSize(1920,1020);
        f.setVisible(true);f.setLayout(null);
        l.setBounds(530,50, 800, 100);
        m.setBounds(1030,370,180,50);
        lp.setBounds(590, 300, 400, 60);
        p.setBounds(1000,300,230,60);
        b.setBounds(720, 700, 120, 50);b.setFont(new Font("",Font.CENTER_BASELINE,21));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ex.setBounds(990, 700, 100, 50);ex.setFont(new Font("",Font.CENTER_BASELINE,21));
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","<password>");
        Statement stmt=con.createStatement(); 
        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    String pwd=p.getText();
                    ResultSet rs=stmt.executeQuery("select * from password where(PD='"+pwd+"')");
                    if(rs.next())
                    { 
                        m.setText("Ascess Granted!");
                         con.close(); 
                         rs.close();
                         stmt.close();
                         f.dispose();
                        try {
                            login2();
                        } catch (ClassNotFoundException ex1) {
                            Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                else
                    m.setText("Wrong Password!");
                } catch (SQLException ex1) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
            }
        });
         ex.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                System.exit(0);
            }
        });
        
     
    }
    
    public static void login2() throws ClassNotFoundException, SQLException
    {
        InputStreamReader read= new InputStreamReader(System.in);
        BufferedReader in= new BufferedReader(read);
      JFrame f2= new JFrame("SYSTEM-Login");
      f2.setSize(1920,1020);
      f2.setVisible(true);f2.setLayout(null);
      f2.setExtendedState(JFrame.MAXIMIZED_BOTH);
      f2.getContentPane().setBackground(Color.CYAN);
      f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JLabel h1= new JLabel("STAFF");
      JLabel h2= new JLabel("MANAGER");
      JLabel m1= new JLabel("");
      JLabel m2= new JLabel("");
      Label u1= new Label("USER NAME:");
      JLabel p1= new JLabel("PASSWORD:");
      JLabel u2= new JLabel("USER NAME:");
      JLabel p2= new JLabel("PASSWORD:");
      JTextField uu1= new JTextField();
      JTextField uu2= new JTextField();
      JPasswordField pw1= new JPasswordField();
      JPasswordField pw2= new JPasswordField();
      JButton b1= new JButton("LOG IN");
      JButton b2= new JButton("LOG IN");
      JButton ex= new JButton("EXIT");
      //JPanel j1= new JPanel();
      //JPanel j2= new JPanel();
      f2.add(h1);f2.add(h2);f2.add(ex);f2.add(m1);f2.add(m2);
      f2.add(u1);f2.add(uu1);f2.add(p1);f2.add(pw1);f2.add(u2);f2.add(p2);f2.add(uu2);f2.add(pw2);f2.add(b2);f2.add(b1);
      h1.setBounds(400,100,200,100);h1.setFont(new Font("",Font.BOLD,50));
      h2.setBounds(1310,100,320,100);h2.setFont(new Font("",Font.BOLD,50));
      //j1.setBounds(180, 210,600 , 700);j1.setBackground(Color.yellow);
      u1.setBounds(300, 250, 160, 50);u1.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      uu1.setBounds(470, 250, 200, 40);uu1.setFont(new Font("",Font.PLAIN,22));
      p1.setBounds(300, 360, 160, 50);p1.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      pw1.setBounds(470, 360, 200, 40);pw1.setFont(new Font("",Font.PLAIN,22));
      m1.setBounds(400,440,180,50);m1.setFont(new Font("",Font.PLAIN,20));
      m1.setForeground(Color.RED);
      b1.setBounds(410, 500, 140, 50);b1.setFont(new Font("",Font.CENTER_BASELINE,21));
      u2.setBounds(1250,250,160,50);u2.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      uu2.setBounds(1420,250,200,40);uu2.setFont(new Font("",Font.PLAIN,22));
      p2.setBounds(1250,360 , 160, 50);p2.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      pw2.setBounds(1420, 360, 200, 40);pw2.setFont(new Font("",Font.PLAIN,22));
      m2.setBounds(1350,440,180,50);m2.setFont(new Font("",Font.PLAIN,20));
      m2.setForeground(Color.RED);
      b2.setBounds(1360, 500, 140, 50);b2.setFont(new Font("",Font.CENTER_BASELINE,21));
      ex.setBounds(900,750,150,50);ex.setFont(new Font("",Font.CENTER_BASELINE,21));
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","<password>");
      Statement stmt=con.createStatement();   
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
              String un,pwd,s1,s2;
              un=uu1.getText(); 
                try {
                    ResultSet rs=stmt.executeQuery("select * from staff where(name='"+un+"')");
                    pwd= pw1.getText().toLowerCase().trim();
                    if(rs.next())
                    {
                       s1= rs.getString(1);s2= rs.getString(2).toLowerCase().trim();
                       if(s2.contentEquals(pwd))
                       {
                           m1.setText("Welcome");
                             con.close(); 
                             rs.close();
                             stmt.close();
                             f2.dispose();
                             staff_menu();
                       }
                       else
                       {m1.setText("Invalid Password!");}
                    }
                    else
                        m1.setText("Invalid Username!");
                } catch (SQLException ex1) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        });
         b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
               String un,pwd,s1,s2;
              un=uu2.getText(); 
                try {
                    ResultSet rs=stmt.executeQuery("select * from manager where(name='"+un+"')");
                    pwd= pw2.getText().toLowerCase().trim();
                    if(rs.next())
                    {
                       s1= rs.getString(1);s2= rs.getString(2).toLowerCase().trim();
                       if(s2.contentEquals(pwd))
                       {
                           m2.setText("Welcome");
                             con.close(); 
                             rs.close();
                             stmt.close();
                             f2.dispose();
                             manager_menu();
                       }
                       else
                       {m2.setText("Invalid Password!");}
                    }
                    else
                        m2.setText("Invalid Username!");
                } catch (SQLException ex1) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                } 
            }
        });
        ex.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                System.exit(0);
            }
        }); 
    }
    public static void staff_menu()
    {
      JFrame fs= new JFrame("SYSTEM-STAFF");
      fs.setSize(1920,1020);
      
      fs.setExtendedState(JFrame.MAXIMIZED_BOTH);
      fs.getContentPane().setBackground(Color.CYAN);
      fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      String na[]={"SELL","ADD","STORE","HISTORY"};
      JButton bs[]=new JButton[4];
        for(int i=0;i<4;i++)
        {
          bs[i]= new JButton(na[i]);
          bs[i].setFont(new Font("",Font.BOLD,50));
          
          fs.add(bs[i]);
        }
        bs[0].setBackground(Color.YELLOW);
        bs[0].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    sell();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                }
                fs.dispose();
            }
        }); 
        bs[1].setBackground(Color.lightGray);
        bs[1].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    add();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                }
                fs.dispose();
            }
        }); 
        bs[2].setBackground(Color.magenta);
        bs[2].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    store();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                }
                fs.dispose();
            }
        }); 
        bs[3].setBackground(Color.ORANGE);
        bs[3].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    hist();
                    fs.dispose();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
      fs.setVisible(true);fs.setLayout(new GridLayout(2,2)); 
        
    }
    
    public static void manager_menu()
    {
      JFrame fs= new JFrame("SYSTEM-MANAGER");
      fs.setSize(1920,1020);
      
      fs.setExtendedState(JFrame.MAXIMIZED_BOTH);
      fs.getContentPane().setBackground(Color.CYAN);
      fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      String na[]={"HISTORY","EARNED","STAFF RECORD","CHANGE PASSWORD"};
      JButton bs[]=new JButton[4];
        for(int i=0;i<4;i++)
        {
          bs[i]= new JButton(na[i]);
          bs[i].setFont(new Font("",Font.BOLD,50));
          
          fs.add(bs[i]);
        }
        bs[0].setBackground(Color.ORANGE);
        bs[0].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    hist();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                }
                fs.dispose();
            }
        }); 
        bs[1].setBackground(Color.magenta);
        bs[1].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    earn();
                } catch (SQLException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                }
                fs.dispose();
            }
        }); 
        bs[2].setBackground(Color.lightGray);
        bs[2].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    staff_record();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                }
                fs.dispose();
            }
        }); 
        bs[3].setBackground(Color.YELLOW);
        bs[3].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    change_pd();
                    fs.dispose();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
      fs.setVisible(true);fs.setLayout(new GridLayout(2,2));
        
    }
    static int y=0;
    public static int ad(int x)
    {
         y=y+x;
        return y;
    }
    
    public static void sell() throws ClassNotFoundException, SQLException
    {
      JFrame js= new JFrame("SYSTEM-SELL");
      js.setSize(1920,1020);
      js.setVisible(true);
      js.setExtendedState(JFrame.MAXIMIZED_BOTH);
      js.getContentPane().setBackground(Color.CYAN);
      js.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JLabel st= new JLabel("");
      JLabel ts= new JLabel("TOTAL PRICE:");
      JLabel ct= new JLabel("0");
      JLabel cn= new JLabel("CUSTOMER ID:");
      JLabel in= new JLabel("ITEM NAME:");
      JLabel iq= new JLabel("QUANTITY:");
      JTextField ci1= new JTextField();
      JTextField cn1= new JTextField();
      JTextField in1= new JTextField();
      SpinnerModel ob= new SpinnerNumberModel(1,0,100,1);
      JSpinner iq1= new JSpinner(ob);
      JButton bn= new JButton("NEXT ITEM");
      JButton ex= new JButton("EXIT");
      JButton pa= new JButton("PAID");
      JTable t= new JTable();
      t.setBounds(210,10,750,800);
      JScrollPane pane = new JScrollPane(t);
      pane.setBounds(900, 10, 980, 800);
      js.setLayout(null);
      js.add(pane);
      Object[] clm= {"NAME","QUANTITY","PRICE"};
      //Object[] row = {"11","22"};
      DefaultTableModel m= new DefaultTableModel();
      m.setColumnIdentifiers(clm);
      t.setModel(m);//m.addRow(row);
      t.setRowHeight(35);t.setGridColor(Color.LIGHT_GRAY);
      t.setFont(new Font("",Font.PLAIN,20));
      js.add(cn);js.add(cn1);js.add(in);js.add(in1);js.add(iq);js.add(iq1);js.add(bn);
      js.add(ex);js.add(pa);js.add(ct);js.add(st);js.add(ts);
      cn.setBounds(30,80,250,50);cn.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      cn1.setBounds(290,80,460,50);cn1.setFont(new Font("",Font.PLAIN,22));
      in.setBounds(30,200,180,50);in.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      in1.setBounds(230,200,520,50);in1.setFont(new Font("",Font.PLAIN,22));
      iq.setBounds(30,270,150,50);iq.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      iq1.setBounds(230,270,100,50);iq1.setFont(new Font("",Font.PLAIN,22));
      bn.setBounds(230,500, 520, 50);bn.setFont(new Font("",Font.BOLD,28));
      bn.setBackground(Color.YELLOW);
      pa.setBounds(280,610,400,50);pa.setFont(new Font("",Font.BOLD,24));
      pa.setBackground(Color.GREEN);
      ex.setBounds(30,850,140,50);ex.setFont(new Font("",Font.BOLD,24));
      ex.setBackground(Color.RED);
      ct.setBounds(1210,850,300,60);ct.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      ct.setForeground(Color.DARK_GRAY);
      ts.setBounds(900,850,300,60);ts.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      ts.setForeground(Color.DARK_GRAY);
      st.setBounds(350,270,380,50);st.setFont(new Font("",Font.BOLD,20));
      st.setBackground(Color.RED);
      //final String tp1;
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","<password>");
      Statement stmt=con.createStatement();
      ResultSet rs4=stmt.executeQuery("select * from hist");int id=0;
      while(rs4.next())
        {
             id=rs4.getInt(1);
        }
         id= id+1;cn1.setText(Integer.toString(id));
      bn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                st.setText("");
              String itn= in1.getText(),qcs,qps;
              int q= (int) iq1.getValue(),qc,qp,cp;
                try {
                    
                    ResultSet rs=stmt.executeQuery("select * from store where(name='"+itn+"')");
                    if(rs.next())
                    {
                        qc=rs.getInt(2);qcs= Integer.toString(qc);
                        qp=rs.getInt(3);
                        qps= Integer.toString((qp*q));
                        cp=rs.getInt(4);
                        if(qc<q)
                        {
                            st.setText("Item not in store!!");
                        }
                        else
                        {
                            Object[] row = {itn,q,qps};
                            m.addRow(row);
                            int r= Integer.parseInt(ct.getText());//takes previos price from label ct
                            int rr= r+(qp*q);
                            String sr= Integer.toString(r+(qp*q));//finds & converts total in ct to string
                            ct.setText(sr);//updates total in ct
                            ResultSet rsu=stmt.executeQuery("update store set quantity='"+(qc-q)+"' where(name='"+itn+"')");
                            in1.setText("");//final String tp1= sr;
                            int tcp=ad(cp*q);//String sr= Integer.toString(tcp);ct.setText(sr);
                            int k= Integer.parseInt((cn1.getText()));
                            ResultSet rs5=stmt.executeQuery("insert into hist(id,item,quantity,total)values('"+k+"','"+itn+"','"+q+"','"+rr+"')");
                        }
                        
                    }
                    else
                    st.setText("Item not in store!!");    
                } catch (SQLException ex1) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                }
                                         
            }
        });
      pa.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    m.setRowCount(0);
                    int ea=ad(0),ea1= Integer.parseInt(ct.getText());
                    //System.out.println(ea1-ea);//earned
                    y=0;
                    ct.setText("0");
                    int e1=0,e2,i1;
                    ResultSet rs2=stmt.executeQuery("select * from earned where(name='profit')");
                    if(rs2.next())
                    e1= rs2.getInt(2);
                    e2= e1+ea1-ea;//earned + previous earned
                    ResultSet rs1=stmt.executeQuery("update earned set EARN= '"+e2+"' where (NAME= 'profit') ");
                    i1= Integer.parseInt(cn1.getText())+1;
                    ResultSet rs6=stmt.executeQuery("insert into hist(id,item,quantity,total)values('"+i1+"',' ',0,0)");
                     ResultSet rs4=stmt.executeQuery("select * from hist");int id=0;
                     while(rs4.next())
                      {
                        id=rs4.getInt(1);
                      }
                     id= id+1;cn1.setText(Integer.toString(id));
                } catch (SQLException ex1) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        });
      ex.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    con.close();
                    rs4.close();
                    stmt.close();
                    System.exit(0);
                } catch (SQLException ex1) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }); 

       }
    
    public static void hist() throws ClassNotFoundException, SQLException
    {
      JFrame js= new JFrame("SYSTEM-CONSUMER PURCHASE HISTORY");
      js.setSize(1920,1020);
      js.setExtendedState(JFrame.MAXIMIZED_BOTH);
      js.setVisible(true);js.setVisible(true);js.setLayout(null);
      js.getContentPane().setBackground(Color.CYAN);
      js.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Label lp= new Label("Enter CUSTOMMER ID:");
       Label l= new Label("CONSUMER HISTORY");
        l.setForeground(Color.YELLOW);
        l.setFont(new Font("",Font.BOLD,50));
        lp.setFont(new Font("",Font.PLAIN,24));lp.setForeground(Color.GRAY);
        JTextField p= new JTextField();p.setFont(new Font("",Font.BOLD,20));
        JButton b= new JButton("SUBMIT");
        JButton ex= new JButton("EXIT");
        Label mt= new Label("TOTAL:");mt.setFont(new Font("",Font.PLAIN,20));
        mt.setForeground(Color.RED);
        JTable t= new JTable();
        t.setBounds(210,10,750,940);
        JScrollPane pane = new JScrollPane(t);
        pane.setBounds(900, 10, 980, 950);
        js.setLayout(null);
        js.add(pane);
        Object[] clm= {"ITEM","QUANTITY"};
        //Object[] row = {"11","22"};
        DefaultTableModel m= new DefaultTableModel();
        m.setColumnIdentifiers(clm);
        t.setModel(m);//m.addRow(row);
        t.setRowHeight(35);t.setGridColor(Color.LIGHT_GRAY);
        t.setFont(new Font("",Font.PLAIN,20));
        js.add(lp);js.add(p);js.add(b);js.add(ex);js.add(l);js.add(mt);
        l.setBounds(100,50, 800, 100);
        mt.setBounds(250,700,180,50);
        lp.setBounds(100, 300, 290, 60);
        p.setBounds(400,300,230,60);
        b.setBounds(140, 500, 120, 50);b.setFont(new Font("",Font.CENTER_BASELINE,21));
        ex.setBounds(380, 500, 100, 50);ex.setFont(new Font("",Font.CENTER_BASELINE,21));
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","<password>");
        Statement stmt=con.createStatement();
        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    int i=Integer.parseInt(p.getText());    
                    ResultSet rs=stmt.executeQuery("select * from hist where (ID='"+i+"')");
                    if(rs.next())
                    {
                        //System.out.println("found");
                        ResultSet rs1=stmt.executeQuery("select * from hist where (ID='"+i+"')");
                        while(rs1.next())
                        {
                            String itn= rs1.getString(2);
                            int q= rs1.getInt(3);
                            Object[] row = {itn,q};
                            if(q!=0)
                            {m.addRow(row);
                            mt.setText("TOTAL: "+Integer.toString(rs1.getInt(4)));}
                        }    
                        
                    }
                    else
                    mt.setText("NO DATA!");
                } catch (SQLException ex1) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        });
        ex.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {            
                    System.exit(0);
            }
        }); 
    }
    public static void add() throws ClassNotFoundException, SQLException
    {
      JFrame js= new JFrame("SYSTEM-SELL");
      js.setSize(1920,1020);
      js.setExtendedState(JFrame.MAXIMIZED_BOTH);
      js.setVisible(true);js.setVisible(true);js.setLayout(null);
      js.getContentPane().setBackground(Color.CYAN);
      js.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Label h= new Label("STORE/GODOWN RECORD");
      JLabel n= new JLabel("Enter Item:");
      JLabel q= new JLabel("Enter quantity:");
      JLabel c= new JLabel("Enter Cost Price:");
      JLabel s= new JLabel("Enter Selling Price:");
      JTextField n1= new JTextField();
      JTextField q1= new JTextField();
      JTextField c1= new JTextField();
      JTextField s1= new JTextField();
      js.add(h);js.add(n);js.add(q);js.add(c);js.add(s);
      js.add(n1);js.add(q1);js.add(c1);js.add(s1);
      h.setBounds(420,50, 1100, 100);
      h.setForeground(Color.DARK_GRAY);
      h.setFont(new Font("",Font.BOLD,80));
      n.setBounds(230,200,180,50);n.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      n1.setBounds(430,200,520,50);n1.setFont(new Font("",Font.PLAIN,22));n1.setBackground(Color.LIGHT_GRAY);
      q.setBounds(230,350,180,50);q.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      q1.setBounds(430,350,520,50);q1.setFont(new Font("",Font.PLAIN,22));q1.setBackground(Color.LIGHT_GRAY);
      c.setBounds(230,500,180,50);c.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      c1.setBounds(430,500,520,50);c1.setFont(new Font("",Font.PLAIN,22));c1.setBackground(Color.LIGHT_GRAY);
      s.setBounds(230,650,180,50);s.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      s1.setBounds(430,650,520,50);s1.setFont(new Font("",Font.PLAIN,22));s1.setBackground(Color.LIGHT_GRAY);
      JButton b= new JButton("ADD");
      JButton ex= new JButton("EXIT");
      js.add(b);js.add(ex);
      b.setBounds(1100,420,460,80);b.setFont(new Font("",Font.BOLD,18));b.setBackground(Color.GREEN);
      ex.setBounds(1230,800,230,80);ex.setFont(new Font("",Font.BOLD,18));
      ex.setBackground(Color.RED);
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","<password>");
      Statement stmt=con.createStatement();
      b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                String na;int qt,sp,cp;
                na= n1.getText();
                qt=  Integer.parseInt(q1.getText());
                sp=  Integer.parseInt(s1.getText());
                cp=  Integer.parseInt(c1.getText());
                try {
                    ResultSet rs=stmt.executeQuery("INSERT INTO store(name,quantity,sp,cp)VALUES('"+na+"','"+qt+"','"+sp+"','"+cp+"')");
                } catch (SQLException ex1) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                }
                n1.setText("");
                q1.setText("");
                s1.setText("");
                c1.setText("");
            }
        });
      ex.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try {
                    con.close();
                    stmt.close();
                    System.exit(0);
                } catch (SQLException ex1) {
                    Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        });
      
    }
    public static void store() throws ClassNotFoundException, SQLException
    {
      JFrame js= new JFrame("SYSTEM-SELL");
      js.setSize(1920,1020);
      js.setExtendedState(JFrame.MAXIMIZED_BOTH);
      js.setVisible(true);js.setVisible(true);js.setLayout(null);
      js.getContentPane().setBackground(Color.CYAN);
      js.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JTable t= new JTable();
      t.setBounds(210,10,750,800);
      JScrollPane pane = new JScrollPane(t);
      pane.setBounds(100, 10, 1700, 800);
      js.setLayout(null);
      js.add(pane);
      Object[] clm= {"NAME","QUANTITY","COST PRICE","SELLING PRICE"};
      //Object[] row = {"11","22"};
      DefaultTableModel m= new DefaultTableModel();
      m.setColumnIdentifiers(clm);
      t.setModel(m);//m.addRow(row);
      t.setRowHeight(35);t.setGridColor(Color.LIGHT_GRAY);
      t.setFont(new Font("",Font.PLAIN,20));
      Button b= new Button("EXIT");js.add(b);
      b.setBounds(800,850,300,60);b.setFont(new Font("",Font.BOLD,18));
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","<password>");
      Statement stmt=con.createStatement();
      ResultSet rs=stmt.executeQuery("select * from store");
      while(rs.next())
      {
          String c1,c2,c3,c4;
          c1= rs.getString(1);
          c2= Integer.toString(rs.getInt(2));
          c3= Integer.toString(rs.getInt(3));
          c4= Integer.toString(rs.getInt(4));
          Object[] row = {c1,c2,c3,c4};
          m.addRow(row);
          
      }
      rs.close();
      con.close();
      stmt.close();
      b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                System.exit(0);
            }
        }); 
      
      
    }
    public static void earn() throws SQLException
    {
        try {
            JFrame js= new JFrame("SYSTEM-ACCOUNT");
            js.setSize(1920,1020);
            js.setExtendedState(JFrame.MAXIMIZED_BOTH);
            js.setVisible(true);js.setVisible(true);js.setLayout(null);
            js.getContentPane().setBackground(Color.CYAN);
            js.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel l= new JLabel("COUNT: ");
            JButton b= new JButton("BACK");
            JButton ex= new JButton("EXIT");
            l.setBackground(Color.yellow);
            js.add(l);js.add(b);js.add(ex);
            l.setBounds(750,140,900,600);
            l.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,60));
            b.setBounds(650,800,140,60);
            ex.setBounds(1250,800,140,60);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","<password>");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from earned");
            while(rs.next())
            {
                String s=Integer.toString(rs.getInt(2));
                l.setText("EARNED: Rs"+s+"/-");
            }
            
             ex.addActionListener(new ActionListener()
             {
                  @Override
                public void actionPerformed (ActionEvent e)
                {
                    System.exit(0);
                }
             }); 
             
             b.addActionListener(new ActionListener()
             {
                  @Override
                public void actionPerformed (ActionEvent e)
                {
                    js.dispose();
                    manager_menu();
                }
             });
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public static void staff_record() throws ClassNotFoundException, SQLException
    {
      JFrame js= new JFrame("SYSTEM-STAFF");
      js.setSize(1920,1020);
      js.setExtendedState(JFrame.MAXIMIZED_BOTH);
      js.setVisible(true);js.setVisible(true);js.setLayout(null);
      js.getContentPane().setBackground(Color.CYAN);
      js.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JTable t= new JTable();
      t.setBounds(1310,30,350,800);
      JScrollPane pane = new JScrollPane(t);
      pane.setBounds(1300, 30, 400, 800);
      js.setLayout(null);
      js.add(pane);
      Object[] clm= {"NAME"};
      //Object[] row = {"11"};
      DefaultTableModel m= new DefaultTableModel();
      m.setColumnIdentifiers(clm);
      t.setModel(m);//m.addRow(row);
      t.setRowHeight(35);t.setGridColor(Color.LIGHT_GRAY);
      t.setFont(new Font("",Font.PLAIN,20));
      JLabel n= new JLabel("NEW STAFF:");
      JLabel p= new JLabel("ENTER PASSWORD:");
      JLabel cp= new JLabel("CONFIRM PASSWORD:");
      JLabel d= new JLabel("ENTER STAFF TO DELETE:");
      JTextField ni= new JTextField();
      JTextField pi= new JTextField();
      JTextField cpi= new JTextField();
      JTextField di= new JTextField();
      JButton b= new JButton("ENTER");
      JButton o= new JButton("OK");
      JButton ex= new JButton("EXIT");
      js.add(n);js.add(p);js.add(cp);js.add(cp);js.add(d);js.add(ni);
      js.add(pi);js.add(cpi);js.add(di);js.add(b);js.add(o);js.add(ex);
      n.setBounds(120,100,230,50);n.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      ni.setBounds(380,100,520,50);ni.setFont(new Font("",Font.PLAIN,22));ni.setBackground(Color.LIGHT_GRAY);
      p.setBounds(120,180,230,50);p.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      di.setBounds(380,180,520,50);di.setFont(new Font("",Font.PLAIN,22));di.setBackground(Color.LIGHT_GRAY);
      cp.setBounds(120,260,230,50);cp.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      pi.setBounds(380,260,520,50);pi.setFont(new Font("",Font.PLAIN,22));pi.setBackground(Color.LIGHT_GRAY);
      d.setBounds(120,700,280,50);d.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      cpi.setBounds(120,770,520,50);cpi.setFont(new Font("",Font.PLAIN,22));cpi.setBackground(Color.LIGHT_GRAY);
      b.setBounds(540,340,180,50);
      o.setBounds(150,860,140,50);
      ex.setBounds(1400,860,140,50);
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","<password>");
      Statement stmt=con.createStatement();
      ResultSet rs=stmt.executeQuery("select * from staff");
                    while(rs.next())
                    {                    
                     String c1= rs.getString(1);                
                     Object[] ro = {c1};
                     m.addRow(ro);        
                    }
      b.addActionListener(new ActionListener()
             {
                  @Override
                public void actionPerformed (ActionEvent e)
                {
                    String c1,c2,c3,c4;                  
                    c2= ni.getText();
                    c3= di.getText();
                    c4= pi.getText();
                    if(c4.equals(c3))
                    {
                     
                        try {
                            ResultSet rs1=stmt.executeQuery("insert into staff(NAME,PD)values('"+c2+"','"+c3+"')");
                            Object[] ro = {c2};
                            m.addRow(ro);       
                            ni.setText("");
                            di.setText("");
                            pi.setText("");
                             DefaultTableModel m= new DefaultTableModel();
                          m.setColumnIdentifiers(clm);
                          t.setModel(m);
                          ResultSet rs5=stmt.executeQuery("select * from staff");
                          while(rs5.next())
                        {                    
                          c1= rs5.getString(1);                
                          Object[] rot = {c1};
                          m.addRow(rot);        
                        }
                        } catch (SQLException ex1) {
                            Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    } 
                }
             });
       o.addActionListener(new ActionListener()
             {
                  @Override
                public void actionPerformed (ActionEvent e)
                {
                 
                      try {
                          String c1= cpi.getText();
                          ResultSet rs2=stmt.executeQuery("delete from staff where (NAME='"+c1+"')");
                          cpi.setText("");
                          DefaultTableModel m= new DefaultTableModel();
                          m.setColumnIdentifiers(clm);
                          t.setModel(m);
                          ResultSet rs=stmt.executeQuery("select * from staff");
                          while(rs.next())
                        {                    
                          c1= rs.getString(1);                
                          Object[] ro = {c1};
                          m.addRow(ro);        
                        }
                          
                          
                      } catch (SQLException ex1) {
                          Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                      }
                    
                }
    });
            //con.close();
            //stmt.close();
            ex.addActionListener(new ActionListener()
             {
                  @Override
                public void actionPerformed (ActionEvent e)
                {
                    System.exit(0);
                }
             }); 
            
}
    public static void change_pd() throws ClassNotFoundException, SQLException
    {
      JFrame js= new JFrame("SYSTEM-ADMIN-CHANGE PASSWORD--");
      js.setSize(1920,1020);
      js.setExtendedState(JFrame.MAXIMIZED_BOTH);
      js.setVisible(true);js.setVisible(true);js.setLayout(null);
      js.getContentPane().setBackground(Color.CYAN);
      js.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JTable t= new JTable();
      t.setBounds(1010,30,200,800);
      JScrollPane pane = new JScrollPane(t);
      pane.setBounds(1200, 30, 220, 800);
      js.setLayout(null);
      js.add(pane);
      Object[] clm= {"MANAGER"};
      //Object[] row = {"11"};
      DefaultTableModel m= new DefaultTableModel();
      m.setColumnIdentifiers(clm);
      t.setModel(m);//m.addRow(row);
      t.setRowHeight(35);t.setGridColor(Color.LIGHT_GRAY);
      t.setFont(new Font("",Font.PLAIN,20));
      
      JTable t1= new JTable();
      t1.setBounds(1480,30,350,800);
      JScrollPane pane1 = new JScrollPane(t1);
      pane1.setBounds(1470, 30, 400, 800);
      js.setLayout(null);
      js.add(pane1);
      Object[] clm1= {"STAFF"};
      //Object[] row = {"11"};
      DefaultTableModel m1= new DefaultTableModel();
      m1.setColumnIdentifiers(clm1);
      t1.setModel(m1);//m.addRow(row);
      t1.setRowHeight(35);t1.setGridColor(Color.LIGHT_GRAY);
      t1.setFont(new Font("",Font.PLAIN,20));
      JLabel s= new JLabel("SYSTEM NEW PASSWORD:");
      JLabel sn= new JLabel("STAFF NAME:");
      JLabel sp= new JLabel("NEW PASSWORD:");
      JLabel mp= new JLabel("MANAGER NEW PASSWORD:");
      JTextField s1= new JTextField();
      JTextField sn1= new JTextField();
      JTextField sp1= new JTextField();
      JTextField mp1= new JTextField();
      js.add(s);js.add(sn);js.add(sn1);js.add(sp);js.add(s1);js.add(mp);
      js.add(sp1);js.add(mp1);
      s.setBounds(150,100,320,50);s.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      s1.setBounds(150,180,200,50);s1.setFont(new Font("",Font.PLAIN,22));
      sn.setBounds(150,400,180,50);sn.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      sn1.setBounds(350,400,180,50);sn1.setFont(new Font("",Font.PLAIN,22));
      sp.setBounds(150,480,180,50);sp.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      sp1.setBounds(350,480,200,50);sp1.setFont(new Font("",Font.PLAIN,22));
      mp.setBounds(150,700,320,50);mp.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
      mp1.setBounds(150,770,200,50);mp1.setFont(new Font("",Font.PLAIN,22));
      JButton b1= new JButton("CHANGE");b1.setBackground(Color.RED);
      JButton b2= new JButton("CHANGE");b2.setBackground(Color.RED);
      JButton ex= new JButton("EXIT");ex.setBackground(Color.RED);
      JButton b3= new JButton("CHANGE");b3.setBackground(Color.RED);
      js.add(b1);js.add(b2);js.add(b3);js.add(ex);
      b1.setBounds(900,180,100,40);
      b2.setBounds(900,420,100,40);
      b3.setBounds(900,770,100,40);
      ex.setBounds(200,900,140,40);
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","<password>");
      Statement stmt=con.createStatement();
      ResultSet rs=stmt.executeQuery("select * from staff");
      while(rs.next())
          {                    
          String c1= rs.getString(1);                
          Object[] ro = {c1};
          m1.addRow(ro);        
          }
      ResultSet rs1=stmt.executeQuery("select * from manager");
      while(rs1.next())
          {                    
          String c2= rs1.getString(1);                
          Object[] row = {c2};
          m.addRow(row);        
          }
       b1.addActionListener(new ActionListener()
             {
                  @Override
                public void actionPerformed (ActionEvent e)
                {
                    String a= s1.getText();
                      try { 
                          ResultSet rs2=stmt.executeQuery("update password set PD= '"+a+"' ");
                          s1.setText("**DONE**");
                      } catch (SQLException ex1) {
                          Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                      }
                }
             }); 
       b2.addActionListener(new ActionListener()
             {
                  @Override
                public void actionPerformed (ActionEvent e)
                {
                      try {
                          String b,a= sn1.getText();
                          b=sp1.getText();
                          ResultSet rs2=stmt.executeQuery("update staff set PD= '"+b+"' where (NAME= '"+a+"')"); 
                          if(rs2.next())
                          {
                              sn1.setText("**DONE**");
                              sp1.setText("**DONE**");
                          }
                          else
                          {
                              sn1.setText("**ERROR**");
                              sp1.setText("**ERROR**");
                          }
                      } catch (SQLException ex1) {
                          Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                      }
                         
                              
                          
                      }
                });
              b3.addActionListener(new ActionListener()
             {
                  @Override
                public void actionPerformed (ActionEvent e)
                {
                      try {
                          String b,a= mp1.getText();
                          //b=sp1.getText();
                          ResultSet rs3=stmt.executeQuery("update manager set PD= '"+a+"'"); 
                          if(rs3.next())
                          {
                              mp1.setText("**DONE**");
                              //sp1.setText("**PASSWORD CHANGED**");
                          }
                          else
                          {
                              mp1.setText("**ERROR**");
                              //sp1.setText("**ERROR**");
                          }
                      } catch (SQLException ex1) {
                          Logger.getLogger(smvs.class.getName()).log(Level.SEVERE, null, ex1);
                      }
                         
                              
                          
                      }
                });
               
            ex.addActionListener(new ActionListener()
             {
                  @Override
                public void actionPerformed (ActionEvent e)
                {
                    System.exit(0);
                }
             }); 
             }
    }
//*****************************************************************\\
    
            

