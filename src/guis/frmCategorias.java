    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guis;

import Controlador.CtrlCategorias;
import Controlador.CtrlProductos;
import Dominio.Categoria;
import Dominio.Gerente;
import Dominio.Producto;
import Dominio.ProductoCarrito;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Usuario
 */
public class frmCategorias extends javax.swing.JFrame {

    protected List<ProductoCarrito> productosCarrito;
    protected ProductoCarrito productoCarrito;
    private int elementCount;
    
    /**
     * Creates new form frmCategorias
     */
    public frmCategorias() {
        initComponents();
        
        //imagen origen
        Image img = new ImageIcon(getClass().getResource("/imagenes/logo tatiaxca.png")).getImage();
        //escala imagen
        Image newimg = img.getScaledInstance(84, 79, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);
        //asigna a componenente JLabel
        lblLogo.setIcon(imageIcon);
        productosCarrito = new ArrayList<>();
        this.productoCarrito = new ProductoCarrito();
        cargarBotones();
        centerForm();
    }
    
    public frmCategorias(List<ProductoCarrito> productosCarrito) {
        initComponents();
        
        //imagen origen
        Image img = new ImageIcon(getClass().getResource("/imagenes/logo tatiaxca.png")).getImage();
        //escala imagen
        Image newimg = img.getScaledInstance(84, 79, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);
        //asigna a componenente JLabel
        lblLogo.setIcon(imageIcon);
        this.productosCarrito = productosCarrito;
        this.productoCarrito = new ProductoCarrito();
        cargarBotones();
    }
    private void centerForm() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        
        int formWidth = this.getWidth();
        int formHeight = this.getHeight();
        
        int x = (screenWidth - formWidth) / 2;
        int y = (screenHeight - formHeight) / 2;
        
        this.setLocation(x, y);
    }
    
    private void cargarBotones()
    {
        List<Categoria> categoriasRegistradas = CtrlCategorias.getInstance().consultarTodos();
        panelBotones.add(getBotones(categoriasRegistradas, panelBotones));
        panelBotones.updateUI();
    }
    
    public JPanel getBotones(List<Categoria> categoriasRegistradas, JPanel jPanel) {
        // this will become the content pane of the frame
        JPanel elementsPanel = new JPanel(new GridLayout(0,1,2,2));
        elementCount = 0;
        jPanel = new JPanel(new BorderLayout(4,4));
        jPanel.setBorder(new EmptyBorder(4,4,4,4));
        JPanel scrollPanel = new JPanel(new BorderLayout());
        scrollPanel.setBackground(Color.white);
        scrollPanel.add(elementsPanel, BorderLayout.PAGE_START);
        jPanel.add(new JScrollPane(scrollPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER)
        );
        
        List<List<Categoria>> listascategorias = new ArrayList<>();
        int cantidadCategorias = categoriasRegistradas.size();
        int j = 0;
        while(cantidadCategorias > 0)
        {
            int i = 0;
            List<Categoria> renglon = new ArrayList<>();
            while(i < 6)
            {
                if(cantidadCategorias > 0)
                {
                    renglon.add(categoriasRegistradas.get(j));
                    cantidadCategorias--;
                    j++;
                }
                i++;
            }
            listascategorias.add(renglon);
        }
        
        for (List<Categoria> renglonCategorias: listascategorias) 
        {
            elementsPanel.add(getPanelFila(renglonCategorias));
        }
        jPanel.setBackground(Color.white);
        jPanel.updateUI();
        return jPanel;
    }

    private JPanel getPanelFila(List<Categoria> renglonCategorias) {
        JPanel p = new PanelBotonCategoria(this, renglonCategorias);
        elementCount++;
        return p;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlBody = new javax.swing.JPanel();
        lblCategorias = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        panelBotones = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Categorías");
        setBackground(new java.awt.Color(255, 102, 102));
        setForeground(new java.awt.Color(51, 51, 255));

        pnlHeader.setBackground(new java.awt.Color(222, 202, 184));

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 93, 54));
        jLabel1.setText("Café Tatiaxca");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));

        lblCategorias.setFont(new java.awt.Font("Segoe UI Emoji", 0, 70)); // NOI18N
        lblCategorias.setForeground(new java.awt.Color(91, 91, 91));
        lblCategorias.setText("Categorias");

        btnCancelar.setBackground(new java.awt.Color(91, 91, 91));
        btnCancelar.setFont(new java.awt.Font("Segoe UI Emoji", 1, 15)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        panelBotones.setBackground(new java.awt.Color(255, 255, 255));
        panelBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        panelBotones.setForeground(new java.awt.Color(255, 255, 255));
        panelBotones.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnlBodyLayout = new javax.swing.GroupLayout(pnlBody);
        pnlBody.setLayout(pnlBodyLayout);
        pnlBodyLayout.setHorizontalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lblCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 1223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlBodyLayout.setVerticalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblCategorias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Gerente gerente = new Gerente();
        gerente.setIdUsuario(1L);
        new frmMenu(gerente).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(frmCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCategorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCategorias;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    // End of variables declaration//GEN-END:variables
}
