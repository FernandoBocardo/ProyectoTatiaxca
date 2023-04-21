/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guis;

import Dominio.ProductoCarrito;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuario
 */
public class frmSabores extends javax.swing.JFrame {

    private List<ProductoCarrito> productosCarrito;
    private ProductoCarrito productoCarrito;
    private frmProductos frmProductos;
    
    /**
     * Creates new form frmProductos
     */
    public frmSabores(List<ProductoCarrito> productosCarrito, ProductoCarrito productoCarrito, frmProductos frmProductos) {
        initComponents();
        this.frmProductos = frmProductos;
        //imagen origen
        Image img = new ImageIcon(getClass().getResource("/imagenes/logo tatiaxca.png")).getImage();
        //escala imagen
        Image newimg = img.getScaledInstance(84, 79, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);
        //asigna a componenente JLabel
        lblLogo.setIcon(imageIcon);
        this.productosCarrito = productosCarrito;
        this.productoCarrito = productoCarrito;
    }

    private frmSabores() {
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
        lblSabores = new javax.swing.JLabel();
        btnAvellana = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnAmaretta = new javax.swing.JButton();
        btnAlmendra = new javax.swing.JButton();
        btnAlgodonDeAzucar = new javax.swing.JButton();
        btnChocoMenta = new javax.swing.JButton();
        btnChicle = new javax.swing.JButton();
        btnCaramelo = new javax.swing.JButton();
        btnCremaIrlandesa = new javax.swing.JButton();
        btnChocolate = new javax.swing.JButton();
        btnChai = new javax.swing.JButton();
        btnCajeta = new javax.swing.JButton();
        btnHorchata = new javax.swing.JButton();
        btnMazapan = new javax.swing.JButton();
        btnMatcha = new javax.swing.JButton();
        btnMoka = new javax.swing.JButton();
        btnNutella = new javax.swing.JButton();
        btnOreo = new javax.swing.JButton();
        btnTaro = new javax.swing.JButton();
        btnRedVelvel = new javax.swing.JButton();
        btnVainilla = new javax.swing.JButton();
        btnCappuccino = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        lblSabores.setFont(new java.awt.Font("Segoe UI Emoji", 0, 70)); // NOI18N
        lblSabores.setForeground(new java.awt.Color(91, 91, 91));
        lblSabores.setText("Sabores");

        btnAvellana.setBackground(new java.awt.Color(193, 232, 213));
        btnAvellana.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnAvellana.setForeground(new java.awt.Color(91, 91, 91));
        btnAvellana.setText("Avellana");
        btnAvellana.setBorder(null);
        btnAvellana.setBorderPainted(false);
        btnAvellana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvellanaActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(91, 91, 91));
        btnVolver.setFont(new java.awt.Font("Segoe UI Emoji", 1, 15)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("volver");
        btnVolver.setBorder(null);
        btnVolver.setBorderPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnAmaretta.setBackground(new java.awt.Color(193, 232, 213));
        btnAmaretta.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnAmaretta.setForeground(new java.awt.Color(91, 91, 91));
        btnAmaretta.setText("Amaretta");
        btnAmaretta.setBorder(null);
        btnAmaretta.setBorderPainted(false);
        btnAmaretta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmarettaActionPerformed(evt);
            }
        });

        btnAlmendra.setBackground(new java.awt.Color(193, 232, 213));
        btnAlmendra.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnAlmendra.setForeground(new java.awt.Color(91, 91, 91));
        btnAlmendra.setText("Almendra");
        btnAlmendra.setBorder(null);
        btnAlmendra.setBorderPainted(false);
        btnAlmendra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlmendraActionPerformed(evt);
            }
        });

        btnAlgodonDeAzucar.setBackground(new java.awt.Color(193, 232, 213));
        btnAlgodonDeAzucar.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        btnAlgodonDeAzucar.setForeground(new java.awt.Color(91, 91, 91));
        btnAlgodonDeAzucar.setText("Algodón de azucar");
        btnAlgodonDeAzucar.setBorder(null);
        btnAlgodonDeAzucar.setBorderPainted(false);
        btnAlgodonDeAzucar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlgodonDeAzucarActionPerformed(evt);
            }
        });

        btnChocoMenta.setBackground(new java.awt.Color(193, 232, 213));
        btnChocoMenta.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnChocoMenta.setForeground(new java.awt.Color(91, 91, 91));
        btnChocoMenta.setText("Choco-menta");
        btnChocoMenta.setBorder(null);
        btnChocoMenta.setBorderPainted(false);
        btnChocoMenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChocoMentaActionPerformed(evt);
            }
        });

        btnChicle.setBackground(new java.awt.Color(193, 232, 213));
        btnChicle.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnChicle.setForeground(new java.awt.Color(91, 91, 91));
        btnChicle.setText("Chicle");
        btnChicle.setBorder(null);
        btnChicle.setBorderPainted(false);
        btnChicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChicleActionPerformed(evt);
            }
        });

        btnCaramelo.setBackground(new java.awt.Color(193, 232, 213));
        btnCaramelo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnCaramelo.setForeground(new java.awt.Color(91, 91, 91));
        btnCaramelo.setText("Caramelo");
        btnCaramelo.setBorder(null);
        btnCaramelo.setBorderPainted(false);
        btnCaramelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarameloActionPerformed(evt);
            }
        });

        btnCremaIrlandesa.setBackground(new java.awt.Color(193, 232, 213));
        btnCremaIrlandesa.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btnCremaIrlandesa.setForeground(new java.awt.Color(91, 91, 91));
        btnCremaIrlandesa.setText("Crema irlandesa");
        btnCremaIrlandesa.setBorder(null);
        btnCremaIrlandesa.setBorderPainted(false);
        btnCremaIrlandesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCremaIrlandesaActionPerformed(evt);
            }
        });

        btnChocolate.setBackground(new java.awt.Color(193, 232, 213));
        btnChocolate.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnChocolate.setForeground(new java.awt.Color(91, 91, 91));
        btnChocolate.setText("Chocolate");
        btnChocolate.setBorder(null);
        btnChocolate.setBorderPainted(false);
        btnChocolate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChocolateActionPerformed(evt);
            }
        });

        btnChai.setBackground(new java.awt.Color(193, 232, 213));
        btnChai.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnChai.setForeground(new java.awt.Color(91, 91, 91));
        btnChai.setText("Chai");
        btnChai.setBorder(null);
        btnChai.setBorderPainted(false);
        btnChai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChaiActionPerformed(evt);
            }
        });

        btnCajeta.setBackground(new java.awt.Color(193, 232, 213));
        btnCajeta.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnCajeta.setForeground(new java.awt.Color(91, 91, 91));
        btnCajeta.setText("Cajeta");
        btnCajeta.setBorder(null);
        btnCajeta.setBorderPainted(false);
        btnCajeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCajetaActionPerformed(evt);
            }
        });

        btnHorchata.setBackground(new java.awt.Color(193, 232, 213));
        btnHorchata.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnHorchata.setForeground(new java.awt.Color(91, 91, 91));
        btnHorchata.setText("Horchata");
        btnHorchata.setBorder(null);
        btnHorchata.setBorderPainted(false);
        btnHorchata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorchataActionPerformed(evt);
            }
        });

        btnMazapan.setBackground(new java.awt.Color(193, 232, 213));
        btnMazapan.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnMazapan.setForeground(new java.awt.Color(91, 91, 91));
        btnMazapan.setText("Mazapan");
        btnMazapan.setBorder(null);
        btnMazapan.setBorderPainted(false);
        btnMazapan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMazapanActionPerformed(evt);
            }
        });

        btnMatcha.setBackground(new java.awt.Color(193, 232, 213));
        btnMatcha.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnMatcha.setForeground(new java.awt.Color(91, 91, 91));
        btnMatcha.setText("Matcha");
        btnMatcha.setBorder(null);
        btnMatcha.setBorderPainted(false);
        btnMatcha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatchaActionPerformed(evt);
            }
        });

        btnMoka.setBackground(new java.awt.Color(193, 232, 213));
        btnMoka.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnMoka.setForeground(new java.awt.Color(91, 91, 91));
        btnMoka.setText("Moka");
        btnMoka.setBorder(null);
        btnMoka.setBorderPainted(false);
        btnMoka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMokaActionPerformed(evt);
            }
        });

        btnNutella.setBackground(new java.awt.Color(193, 232, 213));
        btnNutella.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnNutella.setForeground(new java.awt.Color(91, 91, 91));
        btnNutella.setText("Nutella");
        btnNutella.setBorder(null);
        btnNutella.setBorderPainted(false);
        btnNutella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNutellaActionPerformed(evt);
            }
        });

        btnOreo.setBackground(new java.awt.Color(193, 232, 213));
        btnOreo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnOreo.setForeground(new java.awt.Color(91, 91, 91));
        btnOreo.setText("Oreo");
        btnOreo.setBorder(null);
        btnOreo.setBorderPainted(false);
        btnOreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOreoActionPerformed(evt);
            }
        });

        btnTaro.setBackground(new java.awt.Color(193, 232, 213));
        btnTaro.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnTaro.setForeground(new java.awt.Color(91, 91, 91));
        btnTaro.setText("Taro");
        btnTaro.setBorder(null);
        btnTaro.setBorderPainted(false);
        btnTaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaroActionPerformed(evt);
            }
        });

        btnRedVelvel.setBackground(new java.awt.Color(193, 232, 213));
        btnRedVelvel.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnRedVelvel.setForeground(new java.awt.Color(91, 91, 91));
        btnRedVelvel.setText("Red velvel");
        btnRedVelvel.setBorder(null);
        btnRedVelvel.setBorderPainted(false);
        btnRedVelvel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedVelvelActionPerformed(evt);
            }
        });

        btnVainilla.setBackground(new java.awt.Color(193, 232, 213));
        btnVainilla.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnVainilla.setForeground(new java.awt.Color(91, 91, 91));
        btnVainilla.setText("Vainilla");
        btnVainilla.setBorder(null);
        btnVainilla.setBorderPainted(false);
        btnVainilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVainillaActionPerformed(evt);
            }
        });

        btnCappuccino.setBackground(new java.awt.Color(193, 232, 213));
        btnCappuccino.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        btnCappuccino.setForeground(new java.awt.Color(91, 91, 91));
        btnCappuccino.setText("Cappuccino");
        btnCappuccino.setBorder(null);
        btnCappuccino.setBorderPainted(false);
        btnCappuccino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCappuccinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBodyLayout = new javax.swing.GroupLayout(pnlBody);
        pnlBody.setLayout(pnlBodyLayout);
        pnlBodyLayout.setHorizontalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSabores, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addComponent(btnAvellana, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAmaretta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlmendra, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlgodonDeAzucar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnChocoMenta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnChicle, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCaramelo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBodyLayout.createSequentialGroup()
                                .addComponent(btnMoka, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNutella, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnOreo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTaro, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRedVelvel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnVainilla, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCappuccino, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBodyLayout.createSequentialGroup()
                                .addComponent(btnCremaIrlandesa, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnChocolate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnChai, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCajeta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHorchata, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMazapan, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMatcha, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        pnlBodyLayout.setVerticalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblSabores)
                .addGap(56, 56, 56)
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvellana, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAmaretta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlmendra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlgodonDeAzucar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChocoMenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChicle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaramelo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCremaIrlandesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChocolate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCajeta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHorchata, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMazapan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMatcha, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoka, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNutella, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOreo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRedVelvel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVainilla, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCappuccino, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void continuar()
    {
        new frmDetalles(productosCarrito, productoCarrito, frmProductos).setVisible(true);
        this.dispose();
    }
    
    private void btnAvellanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvellanaActionPerformed
        this.productoCarrito.setSabor("Avellana");
        continuar();
    }//GEN-LAST:event_btnAvellanaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        frmProductos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAmarettaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmarettaActionPerformed
        // TODO add your handling code here:
        this.productoCarrito.setSabor("Ameretto");
        continuar();
    }//GEN-LAST:event_btnAmarettaActionPerformed

    private void btnAlmendraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmendraActionPerformed
        // TODO add your handling code here:
        this.productoCarrito.setSabor("Almendra");
        continuar();
    }//GEN-LAST:event_btnAlmendraActionPerformed

    private void btnAlgodonDeAzucarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlgodonDeAzucarActionPerformed
        // TODO add your handling code here:
        this.productoCarrito.setSabor("Algodon de Azucar");
        continuar();
    }//GEN-LAST:event_btnAlgodonDeAzucarActionPerformed

    private void btnChocoMentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChocoMentaActionPerformed
        // TODO add your handling code here:
        this.productoCarrito.setSabor("Choco Menta");
        continuar();
    }//GEN-LAST:event_btnChocoMentaActionPerformed

    private void btnChicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChicleActionPerformed
        this.productoCarrito.setSabor("Chicle");
        continuar();
    }//GEN-LAST:event_btnChicleActionPerformed

    private void btnCarameloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarameloActionPerformed
        this.productoCarrito.setSabor("Caramelo");
        continuar();
    }//GEN-LAST:event_btnCarameloActionPerformed

    private void btnCremaIrlandesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCremaIrlandesaActionPerformed
        this.productoCarrito.setSabor("Crema Irlandesa");
        continuar();
    }//GEN-LAST:event_btnCremaIrlandesaActionPerformed

    private void btnChocolateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChocolateActionPerformed
        this.productoCarrito.setSabor("Chocolate");
        continuar();
    }//GEN-LAST:event_btnChocolateActionPerformed

    private void btnChaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChaiActionPerformed
        this.productoCarrito.setSabor("Chai");
        continuar();
    }//GEN-LAST:event_btnChaiActionPerformed

    private void btnCajetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajetaActionPerformed
        this.productoCarrito.setSabor("Cajeta");
        continuar();
    }//GEN-LAST:event_btnCajetaActionPerformed

    private void btnHorchataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorchataActionPerformed
        this.productoCarrito.setSabor("Horchata");
        continuar();
    }//GEN-LAST:event_btnHorchataActionPerformed

    private void btnMazapanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMazapanActionPerformed
        this.productoCarrito.setSabor("Mazapan");
        continuar();
    }//GEN-LAST:event_btnMazapanActionPerformed

    private void btnMatchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchaActionPerformed
        this.productoCarrito.setSabor("Matcha");
        continuar();
    }//GEN-LAST:event_btnMatchaActionPerformed

    private void btnMokaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMokaActionPerformed
        this.productoCarrito.setSabor("Moka");
        continuar();
    }//GEN-LAST:event_btnMokaActionPerformed

    private void btnNutellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNutellaActionPerformed
       this.productoCarrito.setSabor("Nutella");
        continuar();
    }//GEN-LAST:event_btnNutellaActionPerformed

    private void btnOreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOreoActionPerformed
        this.productoCarrito.setSabor("Oreo");
        continuar();
    }//GEN-LAST:event_btnOreoActionPerformed

    private void btnTaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaroActionPerformed
        this.productoCarrito.setSabor("Taro");
        continuar();
    }//GEN-LAST:event_btnTaroActionPerformed

    private void btnRedVelvelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedVelvelActionPerformed
        this.productoCarrito.setSabor("Red Velvet");
        continuar();
    }//GEN-LAST:event_btnRedVelvelActionPerformed

    private void btnVainillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVainillaActionPerformed
        this.productoCarrito.setSabor("Vainilla");
        continuar();
    }//GEN-LAST:event_btnVainillaActionPerformed

    private void btnCappuccinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCappuccinoActionPerformed
        this.productoCarrito.setSabor("Cappuccino");
        continuar();
    }//GEN-LAST:event_btnCappuccinoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlgodonDeAzucar;
    private javax.swing.JButton btnAlmendra;
    private javax.swing.JButton btnAmaretta;
    private javax.swing.JButton btnAvellana;
    private javax.swing.JButton btnCajeta;
    private javax.swing.JButton btnCappuccino;
    private javax.swing.JButton btnCaramelo;
    private javax.swing.JButton btnChai;
    private javax.swing.JButton btnChicle;
    private javax.swing.JButton btnChocoMenta;
    private javax.swing.JButton btnChocolate;
    private javax.swing.JButton btnCremaIrlandesa;
    private javax.swing.JButton btnHorchata;
    private javax.swing.JButton btnMatcha;
    private javax.swing.JButton btnMazapan;
    private javax.swing.JButton btnMoka;
    private javax.swing.JButton btnNutella;
    private javax.swing.JButton btnOreo;
    private javax.swing.JButton btnRedVelvel;
    private javax.swing.JButton btnTaro;
    private javax.swing.JButton btnVainilla;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSabores;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    // End of variables declaration//GEN-END:variables
}