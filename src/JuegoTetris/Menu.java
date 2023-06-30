
package JuegoTetris;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
//        reproducirMusica("/Musica/Tetris_Theme_Song.wav");
        this.setLocationRelativeTo(null);
        initComponents();
        rsscalelabel.RSScaleLabel.setScaleLabel(txtLogo, "src/imagenes/tetrislogo.png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtLogo = new javax.swing.JLabel();
        panelcurvas1 = new JuegoTetris.panelcurvas();
        jLabel2 = new javax.swing.JLabel();
        panelcurvas2 = new JuegoTetris.panelcurvas();
        jLabel1 = new javax.swing.JLabel();
        panelcurvas3 = new JuegoTetris.panelcurvas();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 630));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 630));

        jPanel1.setBackground(new java.awt.Color(253, 253, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 200, 200));

        panelcurvas1.setBackground(new java.awt.Color(204, 255, 204));
        panelcurvas1.setRoundBottomLeft(25);
        panelcurvas1.setRoundBottomRight(25);
        panelcurvas1.setRoundTopLeft(25);
        panelcurvas1.setRoundTopRight(25);
        panelcurvas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelcurvas1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Javanese Text", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Jugar hasta el infinito");

        javax.swing.GroupLayout panelcurvas1Layout = new javax.swing.GroupLayout(panelcurvas1);
        panelcurvas1.setLayout(panelcurvas1Layout);
        panelcurvas1Layout.setHorizontalGroup(
            panelcurvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelcurvas1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        panelcurvas1Layout.setVerticalGroup(
            panelcurvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcurvas1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jPanel1.add(panelcurvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 310, 60));

        panelcurvas2.setBackground(new java.awt.Color(153, 255, 255));
        panelcurvas2.setRoundBottomLeft(25);
        panelcurvas2.setRoundBottomRight(25);
        panelcurvas2.setRoundTopLeft(25);
        panelcurvas2.setRoundTopRight(25);
        panelcurvas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelcurvas2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Javanese Text", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Puntajes");

        javax.swing.GroupLayout panelcurvas2Layout = new javax.swing.GroupLayout(panelcurvas2);
        panelcurvas2.setLayout(panelcurvas2Layout);
        panelcurvas2Layout.setHorizontalGroup(
            panelcurvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelcurvas2Layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        panelcurvas2Layout.setVerticalGroup(
            panelcurvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcurvas2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jPanel1.add(panelcurvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 310, -1));

        panelcurvas3.setBackground(new java.awt.Color(255, 153, 153));
        panelcurvas3.setRoundBottomLeft(25);
        panelcurvas3.setRoundBottomRight(25);
        panelcurvas3.setRoundTopLeft(25);
        panelcurvas3.setRoundTopRight(25);
        panelcurvas3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelcurvas3MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Javanese Text", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Salir");

        javax.swing.GroupLayout panelcurvas3Layout = new javax.swing.GroupLayout(panelcurvas3);
        panelcurvas3.setLayout(panelcurvas3Layout);
        panelcurvas3Layout.setHorizontalGroup(
            panelcurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelcurvas3Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        panelcurvas3Layout.setVerticalGroup(
            panelcurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelcurvas3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelcurvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 310, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelcurvas3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelcurvas3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_panelcurvas3MouseClicked

    private void panelcurvas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelcurvas2MouseClicked
        Puntajes puntajes = new Puntajes();
        puntajes.show();
        this.hide();
        
    }//GEN-LAST:event_panelcurvas2MouseClicked

    private void panelcurvas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelcurvas1MouseClicked
        
        Ventana ventana1= new Ventana();
        this.hide();
    }//GEN-LAST:event_panelcurvas1MouseClicked

    public static void main(String args[]) {

            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);

            }
        });
    }
    
     public void reproducirMusica(String archivo) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(archivo));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private JuegoTetris.panelcurvas panelcurvas1;
    private JuegoTetris.panelcurvas panelcurvas2;
    private JuegoTetris.panelcurvas panelcurvas3;
    private javax.swing.JLabel txtLogo;
    // End of variables declaration//GEN-END:variables
}
