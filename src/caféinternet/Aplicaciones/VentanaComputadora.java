package caféinternet.Aplicaciones;



import java.net.*;
import java.io.*;
import java.util.*;
import caféinternet.vistas.principales.Bloqueo;
import javax.swing.JFrame;

public class VentanaComputadora extends javax.swing.JFrame {

    private String NombUsuario, Direccion = "localhost";
    private ArrayList<String> Usuarios = new ArrayList();
    private int puerto = 2222;
    private Boolean EnLinea = false;
    private Bloqueo blo;
    private Socket sock;
    private BufferedReader reader;
    private PrintWriter writer;

    public void ListenThread() {
        Thread IncomingReader = new Thread(new IncomingReader());
        IncomingReader.start();
    }

    public void userAdd(String data) {
        Usuarios.add(data);
    }

    public void userRemove(String data) {
        Chat_Cliente.append(data + " is now offline.\n");
    }
    
    public void userBloqueo()
    {
        blo=new Bloqueo();
        blo.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        blo.setVisible(true);    
    }

    public void writeUsers() {
        String[] tempList = new String[(Usuarios.size())];
        Usuarios.toArray(tempList);
        for (String token : tempList) {
            //users.append(token + "\n");
        }
    }

    public void sendDisconnect() {
        String bye = (NombUsuario + ": :Desconectado");
        try {
            writer.println(bye);
            writer.flush();
        } catch (Exception e) {
            Chat_Cliente.append("no se ha podido enviar desconectar.\n");
        }
    }

    public void Disconnect() {
        try {
            Chat_Cliente.append("Desconectado.\n");
            sock.close();
            reader.close();
            writer.close();
        } catch (Exception ex) {
            Chat_Cliente.append("fallo al Desconectar. \n");
        }
        EnLinea = false;
        txtNombreUsuario.setEditable(true);

    }

    public class IncomingReader implements Runnable {

        @Override
        public void run() {
            String[] data;
            String stream, done = "Done", conectado = "Conectado", 
                    desconectado = "Desconectado", chat = "Chat", Bloquear="Bloquear",desbloquear ="Desbloqueese";
                    
           

            try {
                while ((stream = reader.readLine()) != null) {
                   data = stream.split(":");
                    if (data[0].equals(chat)) 
                     {
                        Chat_Cliente.append(data[0] + ": " + data[1] + "\n");
                        Chat_Cliente.setCaretPosition(Chat_Cliente.getDocument().getLength());
                     } 
                    else if (data[0].equals(conectado))
                    {
                        Chat_Cliente.removeAll();
                        userAdd(data[0]);
                    }
                    else if (data[0].equals(desconectado)) 
                     {
                         userRemove(data[0]);
                     } 
                     else if (data[0].equals(done)) 
                     {
                        //users.setText("");
                        writeUsers();
                        Usuarios.clear();
                     }
                     
                    else
                   if (data[0].equals(Bloquear))
                     {
                         userBloqueo();
                     }
                   else if(data[0].equals(desbloquear))
                     {
                         if(blo==null || !blo.isActive())
                         {
                            writer.println("Ya esta desbloqueado");
                            writer.flush();
                         }
                         else
                         {
                             blo.dispose();
                              
                         }
                     }
                    //********************************************
                    //Aqui se reciben los mensajes del servidor
                    //aca se debe de codificar lo que se desea hacer
                    //********************************************
                    
                
                    Chat_Cliente.append(stream);
                    
                }
            } catch (Exception ex) {
            }
        }
    }

    public VentanaComputadora() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDireccionIP = new javax.swing.JLabel();
        txtDireccionIP = new javax.swing.JTextField();
        lbPuerto = new javax.swing.JLabel();
        txtPuerto = new javax.swing.JTextField();
        lbNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        btConectar = new javax.swing.JButton();
        btDesconectar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Chat_Cliente = new javax.swing.JTextArea();
        txtMensajeEnviar = new javax.swing.JTextField();
        btEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chat_Cliente");
        setMinimumSize(new java.awt.Dimension(462, 350));
        setResizable(false);

        lbDireccionIP.setText("Dirección IP:");

        lbPuerto.setText("Puerto:");

        lbNombreUsuario.setText("Nombre Usuario:");

        btConectar.setText("Conectar");
        btConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectarActionPerformed(evt);
            }
        });

        btDesconectar.setText("Desconectar");
        btDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesconectarActionPerformed(evt);
            }
        });

        Chat_Cliente.setEditable(false);
        Chat_Cliente.setColumns(20);
        Chat_Cliente.setRows(5);
        jScrollPane1.setViewportView(Chat_Cliente);

        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMensajeEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbNombreUsuario)
                                .addComponent(lbDireccionIP)
                                .addComponent(lbPuerto))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPuerto)
                                .addComponent(txtDireccionIP)
                                .addComponent(txtNombreUsuario))
                            .addGap(43, 43, 43)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDireccionIP)
                    .addComponent(txtDireccionIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConectar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPuerto)
                    .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btDesconectar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombreUsuario)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensajeEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnviar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConectarActionPerformed
        if (EnLinea == false) {
            NombUsuario = txtNombreUsuario.getText();
            txtNombreUsuario.setEditable(false);

            try {
                //Se crea el sokect
                sock = new Socket(Direccion, puerto);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                
                //se envia un mensaje al servidor codificando que se 
                //conecto un nuevo cliente indicando al inicio del mensaje
                //"N:" lo que indica Nuevo usuario, despues va el nombre del usuario
                writer = new PrintWriter(sock.getOutputStream());
                writer.println("N:"+NombUsuario + ":te has conectado.:Conectado");
                writer.flush();
                
                
                EnLinea = true;
            } catch (Exception ex) {
                Chat_Cliente.append("no se a podido conectar puebe nuevamente \n");
                txtNombreUsuario.setEditable(true);
            }

            ListenThread();

        } else if (EnLinea == true) {
            Chat_Cliente.append("Ya esta conectado. \n");
        }

    }//GEN-LAST:event_btConectarActionPerformed

    private void btDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesconectarActionPerformed
        sendDisconnect();
        Disconnect();

    }//GEN-LAST:event_btDesconectarActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        String nothing = "";
        if ((txtMensajeEnviar.getText()).equals(nothing)) {
            txtMensajeEnviar.setText("");
            txtMensajeEnviar.requestFocus();
        } else {
            try {
                writer.println(NombUsuario + ":" + txtMensajeEnviar.getText() + ":" + "Chat");
                writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                Chat_Cliente.append("No se a enviado el mensaje\n");
            }
            txtMensajeEnviar.setText("");
            txtMensajeEnviar.requestFocus();
        }

        txtMensajeEnviar.setText("");
        txtMensajeEnviar.requestFocus();


    }//GEN-LAST:event_btEnviarActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaComputadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Chat_Cliente;
    private javax.swing.JButton btConectar;
    private javax.swing.JButton btDesconectar;
    private javax.swing.JButton btEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDireccionIP;
    private javax.swing.JLabel lbNombreUsuario;
    private javax.swing.JLabel lbPuerto;
    private javax.swing.JTextField txtDireccionIP;
    private javax.swing.JTextField txtMensajeEnviar;
    public javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPuerto;
    // End of variables declaration//GEN-END:variables
}
