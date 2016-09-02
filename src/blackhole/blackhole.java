/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * blackhole.java
 *
 * Created on 23-apr-2009, 10:38:33
 */

package blackhole;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author be02927
 */
public class blackhole extends javax.swing.JFrame {
    private byte[] data;
    private String tekst;
    private String helptekst;

    /** Creates new form blackhole */
    public blackhole() {
        initComponents();
        add_drag_and_drop();
        load_ini_setting();
    }

    private void add_drag_and_drop() {
        FileDrop fileDrop = new FileDrop( jPanel2, new FileDrop.Listener() {

                                public void filesDropped(File[] files) {

                                                    for (int i = 0; i < files.length; i++) {
                                        File file = files[i];
                                        String filename = file.toString();

                                    // mail_through_outlook(filename);

                                                    }
                                    for (int i = 0; i < files.length; i++) {
                                        File file = files[i];
                                         System.out.println(files[i].toString());
                                          send_the_mail(file);
                                    }
                                }

                                private void pause(int nbr) {
                                    for (int i = 0; i < nbr * 100000; i++) {
                                         // do nothing
                                    }
                                }

                                private void mail_through_outlook(String filen) {

                     //  c:\>"c:\program files\microsoft office\office11\outlook.exe"
                     //           /c ipmnote /m someone@gmail.com /a "c:\logs\logfile.txt"





                                String from = jTextField3.getText();
                                String to = jTextField1.getText();
                                String bodyText = "This mail contains a file sent by the blackhole application";
                                String subject = jTextField4.getText();
                                String filename = filen;
                                String tekst = "";
                                File f = new File ("sendit.bat");

                                                            tekst = "mapisend.exe -i -r ";
                                        tekst = tekst + to + " -s " + '"' + subject + '"' + " -f ";
                                        tekst = tekst + '"' + filename + '"';


                                   try {
                                        FileOutputStream fon = new FileOutputStream (f);
                                                                    OutputStream bfon = new BufferedOutputStream(fon);
                                                                    OutputStreamWriter bfono = new OutputStreamWriter(bfon, "8859_1");
                                                                    bfono.write (tekst);
                                                                    bfono.close ();
                                                            } catch (IOException exc) {
                                                                    String errorString = "IOException: " + filename;
                                                            }


                            try
                            {
                                jTextField2.setText("Mailing...");


                                String[] cmd = new String[3];
                                    cmd[0] = "cmd.exe" ;
                                    cmd[1] = "/C" ;
                                    cmd[2] = "sendit.bat";

                                Runtime rt = Runtime.getRuntime();
                                Process proc = rt.exec(cmd);
                                // any error message?
                                StreamGobbler errorGobbler = new
                                    StreamGobbler(proc.getErrorStream(), "ERROR");

                                // any output?
                                StreamGobbler outputGobbler = new
                                    StreamGobbler(proc.getInputStream(), "OUTPUT");

                                // kick them off
                                errorGobbler.start();
                                outputGobbler.start();

                                // any error???
                                int exitVal = proc.waitFor();
                            } catch (Throwable t)
                              {
                                t.printStackTrace();
                              }



                                jTextField2.setText("File(s) mailed, ready..");


                                }


                                private void send_the_mail(File file) {

                                    
                          //      emailit mail = new emailit();
                                String filename = file.toString();
                                String from = jTextField3.getText();
                               String to = jTextField1.getText();
                                String bodyText = "This mail contains a file sent by the black hole application";
                                String subject = jTextField4.getText();
                                String d_host = jTextField5.getText();
                                String d_port = jTextField6.getText();
                                String userid = jTextField7.getText();
                                String password = jPasswordField1.getPassword().toString();

                        //       mail.sendEmail(from, to, subject, bodyText, filename);
                                MultiPartMail MyMPMailer = new MultiPartMail(from, d_host, d_port, to, subject, subject, userid, userid, filename );
                                jTextField2.setText("File was sent in an email...");

                                }

                            });

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Black Hole");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Auto Email Tool"));

        jLabel1.setText("Email to");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Drop Area", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 255)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setIcon(new javax.swing.ImageIcon("D:\\My Documents\\NetBeansProjects\\blackhole\\hole.gif")); // NOI18N
        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setText("Status");

        jTextField2.setEditable(false);

        jButton1.setText("Save settings");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_settings(evt);
            }
        });

        jLabel2.setText("Email From");

        jLabel4.setText("Mail subject");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Vic");

        jButton2.setText("Help");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_help(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SMTP settings", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel6.setText("SMTP Server");

        jTextField5.setText("smtp.gmail.com");

        jLabel7.setText("Port");

        jTextField6.setText("465");

        jLabel8.setText("Username");

        jTextField7.setText("vicmertens@gmail.com");

        jLabel9.setText("Password");

        jPasswordField1.setText("h4pvt600");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save_settings(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_settings
                File f_ini = new File ("blackhole.ini");
        Properties p = new Properties();
        p.setProperty("EMAILTO",jTextField1.getText());
        p.setProperty("EMAILFROM",jTextField3.getText());
        p.setProperty("EMAILSUBJECT",jTextField4.getText());

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(f_ini);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
          p.store(out, "---Black Hole settings---");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        jTextField2.setText("Defaults saved, ready..");

    }//GEN-LAST:event_save_settings

    private void show_help(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show_help

        // show help page
            JFrame helpframe = new JFrame("BlackHole Help File");
            helpframe.setSize(700, 800);
        JTextArea jTextArea1 = new javax.swing.JTextArea();
            helpframe.add(jTextArea1);
            jTextArea1.setFocusable(Boolean.FALSE);
            // read help file
       File f_help = new File ("help.txt");

       try {
		FileInputStream fin = new FileInputStream (f_help);
		int filesize = (int)f_help.length();
		data = new byte[filesize];
		fin.read (data, 0, filesize);
	} catch (FileNotFoundException exc) {
		String errorString = "File not found: help.txt";
		data = new byte[errorString.length()];
		errorString.getBytes();
     	        jTextField4.setText(errorString);
	} catch (IOException exc) {
		String errorString = "IOException: help.txt";
		data = new byte[errorString.length()];
		errorString.getBytes();
     	        jTextField4.setText(errorString);
	}

            //myTextArea.setText (new String (data, 0));
            tekst = (new String (data));
 	    // tekst = myTextArea.getText();
	    helptekst = tekst;

            // show help file
            jTextArea1.setBackground(Color.lightGray);
            jTextArea1.setText(helptekst);

            helpframe.setVisible(true);




    }//GEN-LAST:event_show_help

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
                new blackhole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables



    private void load_ini_setting() {
        File f_ini = new File ("blackhole.ini");
        FileInputStream fini = null;
        try {
            fini = new FileInputStream(f_ini);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(blackhole.class.getName()).log(Level.SEVERE, null, ex);
        }
              Properties p = new Properties();
        try {
            p.load(fini);
        } catch (IOException ex) {
            Logger.getLogger(blackhole.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fini.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        jTextField1.setText(p.getProperty("EMAILTO"));
        jTextField3.setText(p.getProperty("EMAILFROM"));
        jTextField4.setText(p.getProperty("EMAILSUBJECT"));
        jTextField2.setText("Ready...");


    }

}
