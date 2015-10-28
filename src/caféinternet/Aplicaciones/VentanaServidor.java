package caféinternet.Aplicaciones;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class VentanaServidor extends javax.swing.JFrame {
private ServerSocket serverSock;

    public ServerSocket getServerSock() {
        return serverSock;
    }

    public void setServerSock(ServerSocket serverSock) {
        this.serverSock = serverSock;
    }
    
    public VentanaServidor() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Chat_Servidor = new javax.swing.JTextArea();
        btIniciarServidor = new javax.swing.JButton();
        btDetenerServidor = new javax.swing.JButton();
        btUsuariosEnLinea = new javax.swing.JButton();
        btLimpiarPantalla = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTPC = new javax.swing.JTable();
        btDesbloquear = new javax.swing.JButton();
        btBloquear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana_Servidor");
        setMinimumSize(new java.awt.Dimension(406, 401));
        setResizable(false);

        Chat_Servidor.setColumns(20);
        Chat_Servidor.setRows(5);
        jScrollPane1.setViewportView(Chat_Servidor);

        btIniciarServidor.setText("Iniciar Servidor");
        btIniciarServidor.setPreferredSize(new java.awt.Dimension(115, 23));
        btIniciarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarServidorActionPerformed(evt);
            }
        });

        btDetenerServidor.setText("Detener Servidor");
        btDetenerServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDetenerServidorActionPerformed(evt);
            }
        });

        btUsuariosEnLinea.setText("Usuarios en linea");
        btUsuariosEnLinea.setPreferredSize(new java.awt.Dimension(115, 23));
        btUsuariosEnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuariosEnLineaActionPerformed(evt);
            }
        });

        btLimpiarPantalla.setText("Limpiar pantalla");
        btLimpiarPantalla.setPreferredSize(new java.awt.Dimension(115, 23));
        btLimpiarPantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarPantallaActionPerformed(evt);
            }
        });

        jTPC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "IP", "Estado", "Hora Inicio", "Hora Fin"
            }
        ));
        jScrollPane2.setViewportView(jTPC);
        if (jTPC.getColumnModel().getColumnCount() > 0) {
            jTPC.getColumnModel().getColumn(2).setPreferredWidth(130);
        }

        btDesbloquear.setText("Desbloquear");
        btDesbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesbloquearActionPerformed(evt);
            }
        });

        btBloquear.setText("Bloquear");
        btBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBloquearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btIniciarServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(btDetenerServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btDesbloquear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(174, 174, 174)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btLimpiarPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(btBloquear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btUsuariosEnLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btIniciarServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDetenerServidor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btUsuariosEnLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btLimpiarPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBloquear)
                    .addComponent(btDesbloquear))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLimpiarPantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarPantallaActionPerformed
        Chat_Servidor.setText("");
    }//GEN-LAST:event_btLimpiarPantallaActionPerformed

    private void btUsuariosEnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuariosEnLineaActionPerformed
        if(serverSock==null){
        this.Chat_Servidor.append("No se ha iniciado el servidor\n");
        }
        else{
         if(listaClientes.isEmpty()){
             this.Chat_Servidor.append("No hay Clientes Ativos\n"); 
             ;}
         else{for (ClienteHilo cliente : listaClientes) {
            if (cliente.getEstadoActivo()) { 
                System.out.println("Cliente PC nombre:" + cliente.getNombrePC()+"\n"); 
            }
        }
         }
    }//GEN-LAST:event_btUsuariosEnLineaActionPerformed
    }
    private void btIniciarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarServidorActionPerformed
        Thread starter = new Thread(new ServerStart());
        starter.start();
        Chat_Servidor.append("Servidor Iniciado...\n");
    }//GEN-LAST:event_btIniciarServidorActionPerformed

    private void btDetenerServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDetenerServidorActionPerformed
        try {
            Thread.sleep(2000);                 //2000 milliseconds is five second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        tellEveryone("Server:el servidor ha sido detenido y los usuarios se han desconectados.\n:Chat");
        Chat_Servidor.append("Servidor Detenido... \n");
        Chat_Servidor.setText("");
    }//GEN-LAST:event_btDetenerServidorActionPerformed

    private void btDesbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesbloquearActionPerformed

        try {
            int fila = jTPC.getSelectedRow();
            String ipSeleccionada = jTPC.getValueAt(fila, 1).toString();
            String nombrePCSeleccionado = jTPC.getValueAt(fila, 0).toString();
            
            //*****************************************************
            //se recorre la lista de clientes y se verifica a cual
            //sokect se le quiere enviar el mensaja (el seleccionado 
            //en la tabla)
            //*****************************************************
            for (ClienteHilo cliente : listaClientes) {
                //se optiene la IP del sokect para compararla con la seleccionada
                String ipCliente = cliente.getSock().getInetAddress().toString();
                if (ipCliente.equals(ipSeleccionada) && cliente.getNombrePC().endsWith(nombrePCSeleccionado)) {
                    //si el sokect es la tiene la ip seleccionada
                    //se le envia un mensaje
                    PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                    writer.println("Desbloqueese");
                    writer.flush();
                }
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btDesbloquearActionPerformed

    private void btBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBloquearActionPerformed

        
        try {
            int fila = jTPC.getSelectedRow();
            String ipSeleccionada = jTPC.getValueAt(fila, 1).toString();
            String nombrePCSeleccionado = jTPC.getValueAt(fila, 0).toString();
            
            //*****************************************************
            //se recorre la lista de clientes y se verifica a cual
            //sokect se le quiere enviar el mensaja (el seleccionado 
            //en la tabla)
            //*****************************************************
            for (ClienteHilo cliente : listaClientes) {
                //se optiene la IP del sokect para compararla con la seleccionada
                String ipCliente = cliente.getSock().getInetAddress().toString();
                if (ipCliente.equals(ipSeleccionada) && cliente.getNombrePC().endsWith(nombrePCSeleccionado)) {
                    //si el sokect es la tiene la ip seleccionada
                    //se le envia un mensaje
                    PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                    writer.println("Bloquear");
                    writer.flush();
                    
                 
                    
                }
            }
        } catch (Exception e) {

        }
// TODO add your handling code here:
    }//GEN-LAST:event_btBloquearActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VentanaServidor().setVisible(true);
            }
        });
    }

    //*****************************************************
    //*****************************************************
    //se inicia el hilo principal, es el encargado de 
    //recibir los sockets, e insertarlos a la lista de hilos
    //de sokects
    //*****************************************************
    //*****************************************************
    
    public class ServerStart implements Runnable {
        @Override
        public void run() {
            listaClientes = new ArrayList();
            
            try {
                serverSock = new ServerSocket(2222);
                while (true) {
                    //Cada ves que se acepta una conexion por socket
                    Socket clientSock = serverSock.accept();
                    //se crea un nuevo cliente
                    PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                    ClienteHilo cliente = new ClienteHilo(clientSock, writer);
                    listaClientes.add(cliente);
                    
                    //se crea un nuevo hilo para el nuevo socket creado, 
                    //independiente en otro hilo 
                    Thread listener = new Thread(cliente);
                    listener.start();
                    
                    //se llena la tabla con los clientes conectados
                    llenarTabla();
                    Chat_Servidor.append("tienes una conexion \n" + clientSock.getInetAddress());
                }
            } catch (Exception ex) {
                Chat_Servidor.append("Error al realizar la conexión. \n");
            }
        }
    }

    public void tellEveryone(String message) {
        
        //*******************************************************
        //Se recorren todos los hilos y se le envia
        //un mensaje a cada uno
        //*******************************************************
        for (ClienteHilo cliente : listaClientes) {

            try {
                //Se toma el printWriter del sokect el cual es el que
                //permite el envio de mensajes
                PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                writer.println(message);
                writer.flush();
                
                //Se muestra el mensaje en el texto
                Chat_Servidor.append("enviando: " + message + "\n");
                Chat_Servidor.setCaretPosition(Chat_Servidor.getDocument().getLength());

            } catch (Exception ex) {
                Chat_Servidor.append("Error al enviar mensaje a todos. \n");
            }
        }
    }

    public void llenarTabla() {

        DefaultTableModel modeloTabla = new DefaultTableModel();
        jTPC.setModel(modeloTabla);
        String fila[] = new String[5];

        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("IP");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Hora Inicio");
        modeloTabla.addColumn("Hora Fin");
        TableColumnModel columnModel = jTPC.getColumnModel();
        columnModel.getColumn(2).setPreferredWidth(80);
        
        try {
            //*************************************************
            //*************************************************
            //se recorre la lista de hilos para obtener la
            //información de los clientes conectados
            //*************************************************
            //*************************************************
            for (ClienteHilo cliente : listaClientes) {

                fila[0] = cliente.getNombrePC();
                fila[1] = cliente.getSock().getInetAddress().toString();
                fila[4] = cliente.getEstadoActivo().toString();

                modeloTabla.addRow(fila);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Chat_Servidor;
    public javax.swing.JButton btBloquear;
    private javax.swing.JButton btDesbloquear;
    private javax.swing.JButton btDetenerServidor;
    private javax.swing.JButton btIniciarServidor;
    private javax.swing.JButton btLimpiarPantalla;
    private javax.swing.JButton btUsuariosEnLinea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTPC;
    // End of variables declaration//GEN-END:variables

    
    //*****************************************************
    //*****************************************************
    //Lista de clientes, cada cliente que se conecte va a 
    //ser un hilo
    //*****************************************************
    //*****************************************************
    
    ArrayList<ClienteHilo> listaClientes;

    public class ClienteHilo implements Runnable {

        private BufferedReader reader;
        private Socket sock;
        private PrintWriter printWriter;
        private String hoInicio = "";
        private String hoFin = "";
        private Calendar calendario = Calendar.getInstance();
        private Boolean estadoActivo;
        private String nombrePC;

        public ClienteHilo(Socket clientSocket, PrintWriter printWriter) {
            this.printWriter = printWriter;
            this.estadoActivo = true;
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (Exception ex) {
                Chat_Servidor.append("inesperado error... \n");
            }

        }

        //*****************************************************
        //*****************************************************
        //Cuando el hilo de ejecuta, se inicia la comunicacion
        //por socket, ves que se lee un mensaje es donde se
        //decide que hacer
        //*****************************************************
        //*****************************************************
        @Override
        public void run() {
            String[] data;
                    String message , connect = "Conectado", disconnect = "Desconectado", chat = "Chat" ;
                
            try {
                while ((message = reader.readLine()) != null) {
                    
//*****************************************************
                    //El mensaje se muestra en el Texto de mensajes
                    //aca se deberia codificar que se quiere hacer
                   
                    //***************************************************** 
               
                    Chat_Servidor.append("Received: " + message + "\n");
                    data = message.split(":");
                    
                    //for (String token:data) 
                    //{
                    //    Chat_Servidor.append(token + "\n");
                    //}

                    if (data[0].equals(connect)) 
                    {
                        tellEveryone((data[0] + ":" + data[1] + ":" + chat));
                
                    } 
                    else{ if (data[0].equals(disconnect)||data[1].equals(disconnect)||data[2].equals(disconnect)) 
                    {
                        tellEveryone((data[0] + ":has disconnected." + ":" + chat));
                        //userRemove(data[0]);
                        this.clearTable(jTPC); 
                        llenarTabla(); 
                      
                    } 
                    else{ if (data[0].equals(chat)) 
                    {
                        tellEveryone(message);
                    } 
                    else 
                    {
                        Chat_Servidor.append("No Conditions were met. \n");
                    }
                 
                    }
                    }
                    
                    Chat_Servidor.append("Recibido: " + message + "\n");
                    
                    //Se decodifica el mensaje
                    String mensajeEnPartes[] = message.split(":");
                    if (mensajeEnPartes[0].equals("N")) {//nuevo usuario
                        this.nombrePC = mensajeEnPartes[1];
                        llenarTabla();// se llena la tabla de clientes
                    }
                }
            } catch (Exception ex) {
                Chat_Servidor.append("conexion perdida. \n");
                ex.printStackTrace();
            }
        }
        
        public BufferedReader getReader() {
            return reader;
        }
        
        /*
        public void userRemove (String data) 
    {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        listaClientes.remove(name);
        String[] tempList = new String[(.size())];
        listaClientes.toArray(tempList);

        for (String token:tempList) 
        {
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }
        */
         public void clearTable(JTable Tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
    }

        public void setReader(BufferedReader reader) {
            this.reader = reader;
        }

        public Socket getSock() {
            return sock;
        }

        public void setSock(Socket sock) {
            this.sock = sock;
        }

        public PrintWriter getPrintWriter() {
            return printWriter;
        }

        public void setPrintWriter(PrintWriter printWriter) {
            this.printWriter = printWriter;
        }

        public String getHoInicio() {
            return hoInicio;
        }

        public void setHoInicio(String hoInicio) {
            this.hoInicio = hoInicio;
        }

        public String getHoFin() {
            return hoFin;
        }

        public void setHoFin(String hoFin) {
            this.hoFin = hoFin;
        }

        public Calendar getCalendario() {
            return calendario;
        }

        public void setCalendario(Calendar calendario) {
            this.calendario = calendario;
        }

        public Boolean getEstadoActivo() {
            return estadoActivo;
        }

        public void setEstadoActivo(Boolean estadoActivo) {
            this.estadoActivo = estadoActivo;
        }

        public String getNombrePC() {
            return nombrePC;
        }

        public void setNombrePC(String nombrePC) {
            this.nombrePC = nombrePC;
        }
        
    }

}
