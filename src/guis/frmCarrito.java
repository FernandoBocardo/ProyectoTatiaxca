/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guis;

import Controlador.CtrlProductos;
import Controlador.CtrlVentas;
import Dominio.Producto;
import Dominio.ProductoCarrito;
import Dominio.Venta;
import Dominio.Venta_Producto;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class frmCarrito extends javax.swing.JFrame {

    List<ProductoCarrito> productosCarrito;
    List<JTextField> txtProductos;
    List<JTextField> txtPreciosProductos;
    List<JLabel> lbCantidadesProductos;
    float total;
    float cambio;
    
    /**
     * Creates new form frmProductos
     */
        public frmCarrito(List<ProductoCarrito> productosCarrito) {
            initComponents();
            this.productosCarrito = productosCarrito;
            this.txtProductos = new ArrayList<>();
            this.txtPreciosProductos = new ArrayList<>();
            this.lbCantidadesProductos = new ArrayList<>();
            this.total=0.0f;
            this.cambio=0.0f;

            
            
            //imagen origen
            Image img = new ImageIcon(getClass().getResource("/imagenes/logo tatiaxca.png")).getImage();
            //escala imagen
            Image newimg = img.getScaledInstance(84, 79, java.awt.Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(newimg);
            //asigna a componenente JLabel
            lblLogo.setIcon(imageIcon);

//            PagoEfectivo pe = new PagoEfectivo(this.total);
//            pe.setSize(231, 231);
//            pe.setLocation(0, 0);
//
//            tipoPago.removeAll();
//            tipoPago.add(pe, BorderLayout.CENTER);
//            tipoPago.revalidate();
//            tipoPago.repaint();

            this.txtProductos.add(txtProducto1);
            this.txtProductos.add(txtProducto2);
            this.txtProductos.add(txtProducto3);
            this.txtProductos.add(txtProducto4);
            this.txtProductos.add(txtProducto5);
            this.txtProductos.add(txtProducto6);
            this.txtProductos.add(txtProducto7);
            this.txtProductos.add(txtProducto8);

            this.txtPreciosProductos.add(txtPrecioProducto1);
            this.txtPreciosProductos.add(txtPrecioProducto2);
            this.txtPreciosProductos.add(txtPrecioProducto3);
            this.txtPreciosProductos.add(txtPrecioProducto4);
            this.txtPreciosProductos.add(txtPrecioProducto5);
            this.txtPreciosProductos.add(txtPrecioProducto6);
            this.txtPreciosProductos.add(txtPrecioProducto7);
            this.txtPreciosProductos.add(txtPrecioProducto8);

            this.lbCantidadesProductos.add(lbCantidadProducto1);
            this.lbCantidadesProductos.add(lbCantidadProducto2);
            this.lbCantidadesProductos.add(lbCantidadProducto3);
            this.lbCantidadesProductos.add(lbCantidadProducto4);
            this.lbCantidadesProductos.add(lbCantidadProducto5);
            this.lbCantidadesProductos.add(lbCantidadProducto6);
            this.lbCantidadesProductos.add(lbCantidadProducto7);
            this.lbCantidadesProductos.add(lbCantidadProducto8);

            llenarCarrito();

            this.actualizarNota();

        }

    private frmCarrito() {
    }

    private void actualizarNota() {
        String notaCompleta = "";
        int contador = 1;
        for (ProductoCarrito producto : productosCarrito) {
            String nota = producto.getNota();
            if (nota == null || nota.isEmpty()) {
                nota = "Sin nota";
            } 
            notaCompleta += "Producto " + contador + ": " + nota + "\n";
            contador++;
        }
        this.txtNota.setText(notaCompleta);
    }


    private void llenarCarrito() {
        int i = 0;
        while (i < productosCarrito.size()) {
            ProductoCarrito producto = productosCarrito.get(i);
            String nombre = producto.getNombre();
            String sabor = producto.getSabor();
            String tamaño = producto.getTamaño();
            String unidadMedida = producto.getUnidadMedida();
            if (nombre == null) {
                nombre = "";
            }
            if (sabor == null) {
                sabor = "";
            }
            if (tamaño == null) {
                tamaño = "";
            }
            if (unidadMedida == null) {
                unidadMedida = "";
            }
            this.txtProductos.get(i).setText(nombre + " " + sabor + " " + tamaño + " " + unidadMedida);
            this.lbCantidadesProductos.get(i).setText(String.valueOf(productosCarrito.get(i).getCantidad()));
            String precio = String.valueOf(Integer.parseInt(this.lbCantidadesProductos.get(i).getText()) * productosCarrito.get(i).getPrecio());
            if (precio != null) {
                this.txtPreciosProductos.get(i).setText(precio);
            }
            i++;
        }
        calcularTotal();
    }
    
    private void vaciarCarrito()
    {
        int i = 0;
        while(i < txtProductos.size())
        {
            this.txtProductos.get(i).setText("");
            this.lbCantidadesProductos.get(i).setText("0");
            this.txtPreciosProductos.get(i).setText("");
            i++;
        }
    }
    
    private void calcularTotal()
    {
        int i = 0;
        float subtotal = 0;
        while(i < txtPreciosProductos.size())
        {
            if(!(this.txtPreciosProductos.get(i).getText().equalsIgnoreCase("")))
            {
                subtotal = subtotal + Float.parseFloat(this.txtPreciosProductos.get(i).getText());
            }
            i++;
        }
       
        float total = subtotal ;
        this.total = total;
        txtSubtotal.setText(String.valueOf(subtotal));
        txtTotal.setText(String.valueOf(total));
    }
    
    private void aumentarCantidadProducto(int numeroProducto)
    {
        numeroProducto--;
        int cantidad = Integer.parseInt(this.lbCantidadesProductos.get(numeroProducto).getText());
        cantidad++;
        if(!(this.txtPreciosProductos.get(numeroProducto).getText().equalsIgnoreCase("")))
        {
            this.productosCarrito.get(numeroProducto).setCantidad(cantidad);
            this.lbCantidadesProductos.get(numeroProducto).setText(String.valueOf(cantidad));
            this.txtPreciosProductos.get(numeroProducto).setText(String.valueOf(Integer.parseInt(this.lbCantidadesProductos.get(numeroProducto).getText())*productosCarrito.get(numeroProducto).getPrecio()));
            calcularTotal();
        }
        
    }
    
    private void reducirCantidadProducto(int numeroProducto)
    {
        numeroProducto--;
        int cantidad = Integer.parseInt(this.lbCantidadesProductos.get(numeroProducto).getText());
        cantidad--;
        if(cantidad <= 0 && !(this.txtProductos.get(numeroProducto).getText().equalsIgnoreCase("")))
        {
            this.productosCarrito.remove(numeroProducto);
            this.lbCantidadesProductos.get(numeroProducto).setText("0");
            this.txtPreciosProductos.get(numeroProducto).setText("");
            this.txtProductos.get(numeroProducto).setText("");
            vaciarCarrito();
            llenarCarrito();
        }
        else if(!(this.txtPreciosProductos.get(numeroProducto).getText().equalsIgnoreCase("")))
        {
            this.productosCarrito.get(numeroProducto).setCantidad(cantidad);
            this.lbCantidadesProductos.get(numeroProducto).setText(String.valueOf(cantidad));
            this.txtPreciosProductos.get(numeroProducto).setText(String.valueOf(Integer.parseInt(this.lbCantidadesProductos.get(numeroProducto).getText())*productosCarrito.get(numeroProducto).getPrecio()));
            calcularTotal();
        }
    }
    
    private void eliminarProducto(int numeroProducto) {
        numeroProducto--;

        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que desea eliminar este producto?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            this.productosCarrito.remove(numeroProducto);
            this.lbCantidadesProductos.get(numeroProducto).setText("0");
            this.txtPreciosProductos.get(numeroProducto).setText("");
            this.txtProductos.get(numeroProducto).setText("");
            vaciarCarrito();
            llenarCarrito();
            actualizarNota();
        }
    }
    
    private void editarNota(int numProducto) {
        numProducto--;

        new frmEditarNota(numProducto, productosCarrito).setVisible(true);
        this.dispose();

    }
    
    public JButton getBotonEfectivo(){
        return btnEfectivo;
        
    }
    
    public JButton getBotonTarjeta(){
        return btnTarjeta;
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgLeche = new javax.swing.ButtonGroup();
        bgTamanho = new javax.swing.ButtonGroup();
        pnlHeader = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlBody = new javax.swing.JPanel();
        lblLicuados = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnImprimirTicket = new javax.swing.JButton();
        btnAumentarProducto1 = new javax.swing.JButton();
        lbCantidadProducto1 = new javax.swing.JLabel();
        txtProducto1 = new javax.swing.JTextField();
        txtPrecioProducto1 = new javax.swing.JTextField();
        btnEliminarProducto1 = new javax.swing.JButton();
        btnReducirProducto1 = new javax.swing.JButton();
        btnReducirProducto2 = new javax.swing.JButton();
        btnAumentarProducto2 = new javax.swing.JButton();
        lbCantidadProducto2 = new javax.swing.JLabel();
        txtProducto2 = new javax.swing.JTextField();
        txtPrecioProducto2 = new javax.swing.JTextField();
        btnEliminarProducto2 = new javax.swing.JButton();
        lbCantidadProducto3 = new javax.swing.JLabel();
        btnReducirProducto3 = new javax.swing.JButton();
        btnAumentarProducto3 = new javax.swing.JButton();
        txtPrecioProducto3 = new javax.swing.JTextField();
        txtProducto3 = new javax.swing.JTextField();
        btnEliminarProducto3 = new javax.swing.JButton();
        btnAumentarProducto4 = new javax.swing.JButton();
        txtPrecioProducto4 = new javax.swing.JTextField();
        lbCantidadProducto4 = new javax.swing.JLabel();
        txtProducto4 = new javax.swing.JTextField();
        btnReducirProducto4 = new javax.swing.JButton();
        btnEliminarProducto4 = new javax.swing.JButton();
        btnReducirProducto5 = new javax.swing.JButton();
        btnAumentarProducto5 = new javax.swing.JButton();
        lbCantidadProducto5 = new javax.swing.JLabel();
        txtProducto5 = new javax.swing.JTextField();
        txtPrecioProducto5 = new javax.swing.JTextField();
        btnEliminarProducto5 = new javax.swing.JButton();
        btnAumentarProducto6 = new javax.swing.JButton();
        btnReducirProducto6 = new javax.swing.JButton();
        txtPrecioProducto6 = new javax.swing.JTextField();
        lbCantidadProducto6 = new javax.swing.JLabel();
        btnEliminarProducto6 = new javax.swing.JButton();
        txtProducto6 = new javax.swing.JTextField();
        btnEliminarProducto7 = new javax.swing.JButton();
        txtProducto7 = new javax.swing.JTextField();
        lbCantidadProducto7 = new javax.swing.JLabel();
        btnAumentarProducto7 = new javax.swing.JButton();
        btnReducirProducto7 = new javax.swing.JButton();
        txtPrecioProducto7 = new javax.swing.JTextField();
        btnReducirProducto8 = new javax.swing.JButton();
        btnAumentarProducto8 = new javax.swing.JButton();
        lbCantidadProducto8 = new javax.swing.JLabel();
        txtProducto8 = new javax.swing.JTextField();
        txtPrecioProducto8 = new javax.swing.JTextField();
        btnEliminarProducto8 = new javax.swing.JButton();
        txtSubtotal = new javax.swing.JTextField();
        lblLicuados1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblLicuados3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnEfectivo = new javax.swing.JButton();
        btnTarjeta = new javax.swing.JButton();
        tipoPago = new javax.swing.JPanel();
        lblLicuados4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNota = new javax.swing.JTextArea();
        btnEditarNota1 = new javax.swing.JButton();
        btnEditarNota2 = new javax.swing.JButton();
        btnEditarNota3 = new javax.swing.JButton();
        btnEditarNota4 = new javax.swing.JButton();
        btnEditarNota5 = new javax.swing.JButton();
        btnEditarNota6 = new javax.swing.JButton();
        btnEditarNota7 = new javax.swing.JButton();
        btnEditarNota8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        setForeground(new java.awt.Color(51, 51, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));

        lblLicuados.setFont(new java.awt.Font("Segoe UI Emoji", 0, 70)); // NOI18N
        lblLicuados.setForeground(new java.awt.Color(91, 91, 91));
        lblLicuados.setText("Carrito");

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

        btnImprimirTicket.setBackground(new java.awt.Color(91, 91, 91));
        btnImprimirTicket.setFont(new java.awt.Font("Segoe UI Emoji", 1, 22)); // NOI18N
        btnImprimirTicket.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimirTicket.setText("Imprimir ticket");
        btnImprimirTicket.setBorder(null);
        btnImprimirTicket.setBorderPainted(false);
        btnImprimirTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirTicketActionPerformed(evt);
            }
        });

        btnAumentarProducto1.setBackground(new java.awt.Color(193, 232, 213));
        btnAumentarProducto1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnAumentarProducto1.setForeground(new java.awt.Color(91, 91, 91));
        btnAumentarProducto1.setText("+");
        btnAumentarProducto1.setBorder(null);
        btnAumentarProducto1.setBorderPainted(false);
        btnAumentarProducto1.setPreferredSize(new java.awt.Dimension(19, 19));
        btnAumentarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarProducto1ActionPerformed(evt);
            }
        });

        lbCantidadProducto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantidadProducto1.setText("0");

        txtProducto1.setEditable(false);
        txtProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProducto1ActionPerformed(evt);
            }
        });

        txtPrecioProducto1.setEditable(false);

        btnEliminarProducto1.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarProducto1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEliminarProducto1.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminarProducto1.setText("Eliminar");
        btnEliminarProducto1.setBorder(null);
        btnEliminarProducto1.setBorderPainted(false);
        btnEliminarProducto1.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEliminarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProducto1ActionPerformed(evt);
            }
        });

        btnReducirProducto1.setBackground(new java.awt.Color(193, 232, 213));
        btnReducirProducto1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnReducirProducto1.setForeground(new java.awt.Color(91, 91, 91));
        btnReducirProducto1.setText("-");
        btnReducirProducto1.setBorder(null);
        btnReducirProducto1.setBorderPainted(false);
        btnReducirProducto1.setPreferredSize(new java.awt.Dimension(19, 19));
        btnReducirProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirProducto1ActionPerformed(evt);
            }
        });

        btnReducirProducto2.setBackground(new java.awt.Color(193, 232, 213));
        btnReducirProducto2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnReducirProducto2.setForeground(new java.awt.Color(91, 91, 91));
        btnReducirProducto2.setText("-");
        btnReducirProducto2.setBorder(null);
        btnReducirProducto2.setBorderPainted(false);
        btnReducirProducto2.setPreferredSize(new java.awt.Dimension(19, 19));
        btnReducirProducto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirProducto2ActionPerformed(evt);
            }
        });

        btnAumentarProducto2.setBackground(new java.awt.Color(193, 232, 213));
        btnAumentarProducto2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnAumentarProducto2.setForeground(new java.awt.Color(91, 91, 91));
        btnAumentarProducto2.setText("+");
        btnAumentarProducto2.setBorder(null);
        btnAumentarProducto2.setBorderPainted(false);
        btnAumentarProducto2.setPreferredSize(new java.awt.Dimension(19, 19));
        btnAumentarProducto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarProducto2ActionPerformed(evt);
            }
        });

        lbCantidadProducto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantidadProducto2.setText("0");

        txtProducto2.setEditable(false);

        txtPrecioProducto2.setEditable(false);

        btnEliminarProducto2.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarProducto2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEliminarProducto2.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminarProducto2.setText("Eliminar");
        btnEliminarProducto2.setBorder(null);
        btnEliminarProducto2.setBorderPainted(false);
        btnEliminarProducto2.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEliminarProducto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProducto2ActionPerformed(evt);
            }
        });

        lbCantidadProducto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantidadProducto3.setText("0");

        btnReducirProducto3.setBackground(new java.awt.Color(193, 232, 213));
        btnReducirProducto3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnReducirProducto3.setForeground(new java.awt.Color(91, 91, 91));
        btnReducirProducto3.setText("-");
        btnReducirProducto3.setBorder(null);
        btnReducirProducto3.setBorderPainted(false);
        btnReducirProducto3.setPreferredSize(new java.awt.Dimension(19, 19));
        btnReducirProducto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirProducto3ActionPerformed(evt);
            }
        });

        btnAumentarProducto3.setBackground(new java.awt.Color(193, 232, 213));
        btnAumentarProducto3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnAumentarProducto3.setForeground(new java.awt.Color(91, 91, 91));
        btnAumentarProducto3.setText("+");
        btnAumentarProducto3.setBorder(null);
        btnAumentarProducto3.setBorderPainted(false);
        btnAumentarProducto3.setPreferredSize(new java.awt.Dimension(19, 19));
        btnAumentarProducto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarProducto3ActionPerformed(evt);
            }
        });

        txtPrecioProducto3.setEditable(false);

        txtProducto3.setEditable(false);

        btnEliminarProducto3.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarProducto3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEliminarProducto3.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminarProducto3.setText("Eliminar");
        btnEliminarProducto3.setBorder(null);
        btnEliminarProducto3.setBorderPainted(false);
        btnEliminarProducto3.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEliminarProducto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProducto3ActionPerformed(evt);
            }
        });

        btnAumentarProducto4.setBackground(new java.awt.Color(193, 232, 213));
        btnAumentarProducto4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnAumentarProducto4.setForeground(new java.awt.Color(91, 91, 91));
        btnAumentarProducto4.setText("+");
        btnAumentarProducto4.setBorder(null);
        btnAumentarProducto4.setBorderPainted(false);
        btnAumentarProducto4.setPreferredSize(new java.awt.Dimension(19, 19));
        btnAumentarProducto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarProducto4ActionPerformed(evt);
            }
        });

        txtPrecioProducto4.setEditable(false);

        lbCantidadProducto4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantidadProducto4.setText("0");

        txtProducto4.setEditable(false);

        btnReducirProducto4.setBackground(new java.awt.Color(193, 232, 213));
        btnReducirProducto4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnReducirProducto4.setForeground(new java.awt.Color(91, 91, 91));
        btnReducirProducto4.setText("-");
        btnReducirProducto4.setBorder(null);
        btnReducirProducto4.setBorderPainted(false);
        btnReducirProducto4.setPreferredSize(new java.awt.Dimension(19, 19));
        btnReducirProducto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirProducto4ActionPerformed(evt);
            }
        });

        btnEliminarProducto4.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarProducto4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEliminarProducto4.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminarProducto4.setText("Eliminar");
        btnEliminarProducto4.setBorder(null);
        btnEliminarProducto4.setBorderPainted(false);
        btnEliminarProducto4.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEliminarProducto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProducto4ActionPerformed(evt);
            }
        });

        btnReducirProducto5.setBackground(new java.awt.Color(193, 232, 213));
        btnReducirProducto5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnReducirProducto5.setForeground(new java.awt.Color(91, 91, 91));
        btnReducirProducto5.setText("-");
        btnReducirProducto5.setBorder(null);
        btnReducirProducto5.setBorderPainted(false);
        btnReducirProducto5.setPreferredSize(new java.awt.Dimension(19, 19));
        btnReducirProducto5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirProducto5ActionPerformed(evt);
            }
        });

        btnAumentarProducto5.setBackground(new java.awt.Color(193, 232, 213));
        btnAumentarProducto5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnAumentarProducto5.setForeground(new java.awt.Color(91, 91, 91));
        btnAumentarProducto5.setText("+");
        btnAumentarProducto5.setBorder(null);
        btnAumentarProducto5.setBorderPainted(false);
        btnAumentarProducto5.setPreferredSize(new java.awt.Dimension(19, 19));
        btnAumentarProducto5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarProducto5ActionPerformed(evt);
            }
        });

        lbCantidadProducto5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantidadProducto5.setText("0");

        txtProducto5.setEditable(false);

        txtPrecioProducto5.setEditable(false);

        btnEliminarProducto5.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarProducto5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEliminarProducto5.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminarProducto5.setText("Eliminar");
        btnEliminarProducto5.setBorder(null);
        btnEliminarProducto5.setBorderPainted(false);
        btnEliminarProducto5.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEliminarProducto5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProducto5ActionPerformed(evt);
            }
        });

        btnAumentarProducto6.setBackground(new java.awt.Color(193, 232, 213));
        btnAumentarProducto6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnAumentarProducto6.setForeground(new java.awt.Color(91, 91, 91));
        btnAumentarProducto6.setText("+");
        btnAumentarProducto6.setBorder(null);
        btnAumentarProducto6.setBorderPainted(false);
        btnAumentarProducto6.setPreferredSize(new java.awt.Dimension(19, 19));
        btnAumentarProducto6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarProducto6ActionPerformed(evt);
            }
        });

        btnReducirProducto6.setBackground(new java.awt.Color(193, 232, 213));
        btnReducirProducto6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnReducirProducto6.setForeground(new java.awt.Color(91, 91, 91));
        btnReducirProducto6.setText("-");
        btnReducirProducto6.setBorder(null);
        btnReducirProducto6.setBorderPainted(false);
        btnReducirProducto6.setPreferredSize(new java.awt.Dimension(19, 19));
        btnReducirProducto6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirProducto6ActionPerformed(evt);
            }
        });

        txtPrecioProducto6.setEditable(false);

        lbCantidadProducto6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantidadProducto6.setText("0");

        btnEliminarProducto6.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarProducto6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEliminarProducto6.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminarProducto6.setText("Eliminar");
        btnEliminarProducto6.setBorder(null);
        btnEliminarProducto6.setBorderPainted(false);
        btnEliminarProducto6.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEliminarProducto6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProducto6ActionPerformed(evt);
            }
        });

        txtProducto6.setEditable(false);

        btnEliminarProducto7.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarProducto7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEliminarProducto7.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminarProducto7.setText("Eliminar");
        btnEliminarProducto7.setBorder(null);
        btnEliminarProducto7.setBorderPainted(false);
        btnEliminarProducto7.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEliminarProducto7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProducto7ActionPerformed(evt);
            }
        });

        txtProducto7.setEditable(false);

        lbCantidadProducto7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantidadProducto7.setText("0");

        btnAumentarProducto7.setBackground(new java.awt.Color(193, 232, 213));
        btnAumentarProducto7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnAumentarProducto7.setForeground(new java.awt.Color(91, 91, 91));
        btnAumentarProducto7.setText("+");
        btnAumentarProducto7.setBorder(null);
        btnAumentarProducto7.setBorderPainted(false);
        btnAumentarProducto7.setPreferredSize(new java.awt.Dimension(19, 19));
        btnAumentarProducto7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarProducto7ActionPerformed(evt);
            }
        });

        btnReducirProducto7.setBackground(new java.awt.Color(193, 232, 213));
        btnReducirProducto7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnReducirProducto7.setForeground(new java.awt.Color(91, 91, 91));
        btnReducirProducto7.setText("-");
        btnReducirProducto7.setBorder(null);
        btnReducirProducto7.setBorderPainted(false);
        btnReducirProducto7.setPreferredSize(new java.awt.Dimension(19, 19));
        btnReducirProducto7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirProducto7ActionPerformed(evt);
            }
        });

        txtPrecioProducto7.setEditable(false);

        btnReducirProducto8.setBackground(new java.awt.Color(193, 232, 213));
        btnReducirProducto8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnReducirProducto8.setForeground(new java.awt.Color(91, 91, 91));
        btnReducirProducto8.setText("-");
        btnReducirProducto8.setBorder(null);
        btnReducirProducto8.setBorderPainted(false);
        btnReducirProducto8.setPreferredSize(new java.awt.Dimension(19, 19));
        btnReducirProducto8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirProducto8ActionPerformed(evt);
            }
        });

        btnAumentarProducto8.setBackground(new java.awt.Color(193, 232, 213));
        btnAumentarProducto8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnAumentarProducto8.setForeground(new java.awt.Color(91, 91, 91));
        btnAumentarProducto8.setText("+");
        btnAumentarProducto8.setBorder(null);
        btnAumentarProducto8.setBorderPainted(false);
        btnAumentarProducto8.setPreferredSize(new java.awt.Dimension(19, 19));
        btnAumentarProducto8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarProducto8ActionPerformed(evt);
            }
        });

        lbCantidadProducto8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantidadProducto8.setText("0");

        txtProducto8.setEditable(false);

        txtPrecioProducto8.setEditable(false);

        btnEliminarProducto8.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarProducto8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEliminarProducto8.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminarProducto8.setText("Eliminar");
        btnEliminarProducto8.setBorder(null);
        btnEliminarProducto8.setBorderPainted(false);
        btnEliminarProducto8.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEliminarProducto8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProducto8ActionPerformed(evt);
            }
        });

        txtSubtotal.setEditable(false);
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });

        lblLicuados1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        lblLicuados1.setForeground(new java.awt.Color(91, 91, 91));
        lblLicuados1.setText("Subtotal:");

        lblLicuados3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        lblLicuados3.setForeground(new java.awt.Color(91, 91, 91));
        lblLicuados3.setText("TOTAL:");

        txtTotal.setEditable(false);

        btnEfectivo.setBackground(new java.awt.Color(193, 232, 213));
        btnEfectivo.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEfectivo.setForeground(new java.awt.Color(51, 51, 51));
        btnEfectivo.setText("Efectivo");
        btnEfectivo.setBorder(null);
        btnEfectivo.setBorderPainted(false);
        btnEfectivo.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfectivoActionPerformed(evt);
            }
        });

        btnTarjeta.setBackground(new java.awt.Color(193, 232, 213));
        btnTarjeta.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnTarjeta.setForeground(new java.awt.Color(51, 51, 51));
        btnTarjeta.setText("Tarjeta");
        btnTarjeta.setBorder(null);
        btnTarjeta.setBorderPainted(false);
        btnTarjeta.setPreferredSize(new java.awt.Dimension(19, 19));
        btnTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarjetaActionPerformed(evt);
            }
        });

        tipoPago.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tipoPagoLayout = new javax.swing.GroupLayout(tipoPago);
        tipoPago.setLayout(tipoPagoLayout);
        tipoPagoLayout.setHorizontalGroup(
            tipoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );
        tipoPagoLayout.setVerticalGroup(
            tipoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        lblLicuados4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        lblLicuados4.setForeground(new java.awt.Color(91, 91, 91));
        lblLicuados4.setText("Nota:");

        txtNota.setEditable(false);
        txtNota.setColumns(20);
        txtNota.setRows(5);
        jScrollPane1.setViewportView(txtNota);

        jScrollPane2.setViewportView(jScrollPane1);

        btnEditarNota1.setBackground(new java.awt.Color(0, 153, 255));
        btnEditarNota1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEditarNota1.setForeground(new java.awt.Color(51, 51, 51));
        btnEditarNota1.setText("Nota");
        btnEditarNota1.setBorder(null);
        btnEditarNota1.setBorderPainted(false);
        btnEditarNota1.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEditarNota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNota1ActionPerformed(evt);
            }
        });

        btnEditarNota2.setBackground(new java.awt.Color(0, 153, 255));
        btnEditarNota2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEditarNota2.setForeground(new java.awt.Color(51, 51, 51));
        btnEditarNota2.setText("Nota");
        btnEditarNota2.setBorder(null);
        btnEditarNota2.setBorderPainted(false);
        btnEditarNota2.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEditarNota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNota2ActionPerformed(evt);
            }
        });

        btnEditarNota3.setBackground(new java.awt.Color(0, 153, 255));
        btnEditarNota3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEditarNota3.setForeground(new java.awt.Color(51, 51, 51));
        btnEditarNota3.setText("Nota");
        btnEditarNota3.setBorder(null);
        btnEditarNota3.setBorderPainted(false);
        btnEditarNota3.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEditarNota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNota3ActionPerformed(evt);
            }
        });

        btnEditarNota4.setBackground(new java.awt.Color(0, 153, 255));
        btnEditarNota4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEditarNota4.setForeground(new java.awt.Color(51, 51, 51));
        btnEditarNota4.setText("Nota");
        btnEditarNota4.setBorder(null);
        btnEditarNota4.setBorderPainted(false);
        btnEditarNota4.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEditarNota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNota4ActionPerformed(evt);
            }
        });

        btnEditarNota5.setBackground(new java.awt.Color(0, 153, 255));
        btnEditarNota5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEditarNota5.setForeground(new java.awt.Color(51, 51, 51));
        btnEditarNota5.setText("Nota");
        btnEditarNota5.setBorder(null);
        btnEditarNota5.setBorderPainted(false);
        btnEditarNota5.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEditarNota5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNota5ActionPerformed(evt);
            }
        });

        btnEditarNota6.setBackground(new java.awt.Color(0, 153, 255));
        btnEditarNota6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEditarNota6.setForeground(new java.awt.Color(51, 51, 51));
        btnEditarNota6.setText("Nota");
        btnEditarNota6.setBorder(null);
        btnEditarNota6.setBorderPainted(false);
        btnEditarNota6.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEditarNota6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNota6ActionPerformed(evt);
            }
        });

        btnEditarNota7.setBackground(new java.awt.Color(0, 153, 255));
        btnEditarNota7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEditarNota7.setForeground(new java.awt.Color(51, 51, 51));
        btnEditarNota7.setText("Nota");
        btnEditarNota7.setBorder(null);
        btnEditarNota7.setBorderPainted(false);
        btnEditarNota7.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEditarNota7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNota7ActionPerformed(evt);
            }
        });

        btnEditarNota8.setBackground(new java.awt.Color(0, 153, 255));
        btnEditarNota8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        btnEditarNota8.setForeground(new java.awt.Color(51, 51, 51));
        btnEditarNota8.setText("Nota");
        btnEditarNota8.setBorder(null);
        btnEditarNota8.setBorderPainted(false);
        btnEditarNota8.setPreferredSize(new java.awt.Dimension(19, 19));
        btnEditarNota8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNota8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBodyLayout = new javax.swing.GroupLayout(pnlBody);
        pnlBody.setLayout(pnlBodyLayout);
        pnlBodyLayout.setHorizontalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlBodyLayout.createSequentialGroup()
                                        .addComponent(btnReducirProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAumentarProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbCantidadProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecioProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminarProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlBodyLayout.createSequentialGroup()
                                            .addComponent(btnReducirProducto4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnAumentarProducto4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbCantidadProducto4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtProducto4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtPrecioProducto4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnEliminarProducto4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                                .addComponent(btnReducirProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAumentarProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbCantidadProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecioProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEliminarProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlBodyLayout.createSequentialGroup()
                                                    .addComponent(btnReducirProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnAumentarProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lbCantidadProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtPrecioProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnEliminarProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(pnlBodyLayout.createSequentialGroup()
                                                    .addComponent(btnReducirProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnAumentarProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lbCantidadProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtPrecioProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnEliminarProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEditarNota1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditarNota2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditarNota3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditarNota5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditarNota4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addComponent(btnReducirProducto8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAumentarProducto8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCantidadProducto8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProducto8, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioProducto8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarProducto8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBodyLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBodyLayout.createSequentialGroup()
                                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                                .addGap(118, 118, 118)
                                                .addComponent(lblLicuados4))
                                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEditarNota8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(242, 242, 242))))
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addComponent(btnReducirProducto6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAumentarProducto6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCantidadProducto6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProducto6, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioProducto6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarProducto6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarNota6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addComponent(btnReducirProducto7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAumentarProducto7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCantidadProducto7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProducto7, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioProducto7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarProducto7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarNota7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLicuados, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBodyLayout.createSequentialGroup()
                                .addGap(546, 546, 546)
                                .addComponent(btnImprimirTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBodyLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(728, 728, 728))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBodyLayout.createSequentialGroup()
                                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(pnlBodyLayout.createSequentialGroup()
                                                    .addComponent(lblLicuados1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jSeparator1)
                                                .addGroup(pnlBodyLayout.createSequentialGroup()
                                                    .addComponent(lblLicuados3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41)))
                                .addGap(41, 41, 41)
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlBodyLayout.createSequentialGroup()
                                        .addComponent(btnEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(btnTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        pnlBodyLayout.setVerticalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblLicuados)
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAumentarProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbCantidadProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrecioProducto1)
                                .addComponent(btnReducirProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEliminarProducto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditarNota1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBodyLayout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(btnImprimirTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAumentarProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbCantidadProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrecioProducto2)
                                        .addComponent(btnReducirProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEliminarProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEditarNota2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAumentarProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbCantidadProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrecioProducto3)
                                        .addComponent(btnReducirProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEliminarProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEditarNota3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAumentarProducto4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbCantidadProducto4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtProducto4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrecioProducto4)
                                        .addComponent(btnReducirProducto4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEliminarProducto4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                        .addComponent(btnEditarNota4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBodyLayout.createSequentialGroup()
                                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                                .addComponent(btnTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                                            .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblLicuados1)
                                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(37, 37, 37))
                                    .addGroup(pnlBodyLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLicuados3)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAumentarProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbCantidadProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrecioProducto5)
                                .addComponent(btnReducirProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEliminarProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEditarNota5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAumentarProducto6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbCantidadProducto6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtProducto6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrecioProducto6)
                                        .addComponent(btnReducirProducto6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEliminarProducto6, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                        .addComponent(btnEditarNota6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAumentarProducto7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbCantidadProducto7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtProducto7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrecioProducto7)
                                        .addComponent(btnReducirProducto7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEliminarProducto7, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                        .addComponent(btnEditarNota7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAumentarProducto8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbCantidadProducto8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtProducto8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrecioProducto8)
                                        .addComponent(btnReducirProducto8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEliminarProducto8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEditarNota8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(158, 158, 158))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBodyLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblLicuados4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(52, 52, 52))
        );

        getContentPane().add(pnlBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 91, 1280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAumentarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarProducto1ActionPerformed
        aumentarCantidadProducto(1);
    }//GEN-LAST:event_btnAumentarProducto1ActionPerformed

    private void btnEliminarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProducto1ActionPerformed
        eliminarProducto(1);
    }//GEN-LAST:event_btnEliminarProducto1ActionPerformed

    private void btnImprimirTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirTicketActionPerformed
         List<Producto> productos = new ArrayList<>();
        int i = 0;
        while(i < productosCarrito.size())
        {
            Producto producto = CtrlProductos.getInstance().consultarPorNombre(productosCarrito.get(i).getNombre());
            productos.add(producto);
            i++;
        }
        Venta venta = new Venta();
        venta.setIdCajero(1L);
        venta.setListaProductos(productos);
        venta.setNota(txtNota.getText());
        Calendar fechaCalendar = new GregorianCalendar();
        venta.setFecha(fechaCalendar.getTime());
        List<Venta_Producto> ventas_productos = new ArrayList<>();
        int j = 0;
        while(j < productosCarrito.size())
        {
            Venta_Producto venta_producto = new Venta_Producto();
            venta_producto.setIdProducto(productos.get(j).getIdProducto());
            venta_producto.setPrecioProducto(productos.get(j).getPrecioVenta());
            venta_producto.setCantidadProducto(productosCarrito.get(j).getCantidad());
            venta_producto.setNotaProducto(productosCarrito.get(j).getNota());
            venta_producto.setSaborProducto(productosCarrito.get(j).getSabor());
            ventas_productos.add(venta_producto);
            j++;
        }
        if(CtrlVentas.getInstance().agregar(venta, ventas_productos))
        {
            JOptionPane.showMessageDialog(this, "Se registro correctamente la venta",
                                   "Exito", JOptionPane.INFORMATION_MESSAGE);
            new frmCategorias().setVisible(true);
            new frmTicket(this.txtProductos, txtPreciosProductos, this.total, this.cambio).setVisible(true);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Hubo un error al registrar la venta",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnImprimirTicketActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        new frmCategorias(productosCarrito).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnReducirProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirProducto1ActionPerformed
        reducirCantidadProducto(1);
    }//GEN-LAST:event_btnReducirProducto1ActionPerformed

    private void btnReducirProducto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirProducto2ActionPerformed
        reducirCantidadProducto(2);
    }//GEN-LAST:event_btnReducirProducto2ActionPerformed

    private void btnAumentarProducto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarProducto2ActionPerformed
        aumentarCantidadProducto(2);
    }//GEN-LAST:event_btnAumentarProducto2ActionPerformed

    private void btnEliminarProducto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProducto2ActionPerformed
        eliminarProducto(2);
    }//GEN-LAST:event_btnEliminarProducto2ActionPerformed

    private void btnReducirProducto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirProducto3ActionPerformed
        reducirCantidadProducto(3);
    }//GEN-LAST:event_btnReducirProducto3ActionPerformed

    private void btnAumentarProducto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarProducto3ActionPerformed
        aumentarCantidadProducto(3);
    }//GEN-LAST:event_btnAumentarProducto3ActionPerformed

    private void btnEliminarProducto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProducto3ActionPerformed
        eliminarProducto(3);
    }//GEN-LAST:event_btnEliminarProducto3ActionPerformed

    private void btnAumentarProducto4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarProducto4ActionPerformed
        aumentarCantidadProducto(4);
    }//GEN-LAST:event_btnAumentarProducto4ActionPerformed

    private void btnReducirProducto4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirProducto4ActionPerformed
        reducirCantidadProducto(4);
    }//GEN-LAST:event_btnReducirProducto4ActionPerformed

    private void btnEliminarProducto4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProducto4ActionPerformed
        eliminarProducto(4);
    }//GEN-LAST:event_btnEliminarProducto4ActionPerformed

    private void btnReducirProducto5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirProducto5ActionPerformed
        reducirCantidadProducto(5);
    }//GEN-LAST:event_btnReducirProducto5ActionPerformed

    private void btnAumentarProducto5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarProducto5ActionPerformed
        aumentarCantidadProducto(5);
    }//GEN-LAST:event_btnAumentarProducto5ActionPerformed

    private void btnEliminarProducto5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProducto5ActionPerformed
        eliminarProducto(5);
    }//GEN-LAST:event_btnEliminarProducto5ActionPerformed

    private void btnAumentarProducto6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarProducto6ActionPerformed
        aumentarCantidadProducto(6);
    }//GEN-LAST:event_btnAumentarProducto6ActionPerformed

    private void btnReducirProducto6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirProducto6ActionPerformed
        reducirCantidadProducto(6);
    }//GEN-LAST:event_btnReducirProducto6ActionPerformed

    private void btnEliminarProducto6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProducto6ActionPerformed
        eliminarProducto(6);
    }//GEN-LAST:event_btnEliminarProducto6ActionPerformed

    private void btnEliminarProducto7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProducto7ActionPerformed
        eliminarProducto(7);
    }//GEN-LAST:event_btnEliminarProducto7ActionPerformed

    private void btnAumentarProducto7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarProducto7ActionPerformed
        aumentarCantidadProducto(7);
    }//GEN-LAST:event_btnAumentarProducto7ActionPerformed

    private void btnReducirProducto7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirProducto7ActionPerformed
        reducirCantidadProducto(7);
    }//GEN-LAST:event_btnReducirProducto7ActionPerformed

    private void btnReducirProducto8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirProducto8ActionPerformed
        reducirCantidadProducto(8);
    }//GEN-LAST:event_btnReducirProducto8ActionPerformed

    private void btnAumentarProducto8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarProducto8ActionPerformed
        aumentarCantidadProducto(8);
    }//GEN-LAST:event_btnAumentarProducto8ActionPerformed

    private void btnEliminarProducto8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProducto8ActionPerformed
        eliminarProducto(8);
    }//GEN-LAST:event_btnEliminarProducto8ActionPerformed

    private void btnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectivoActionPerformed
        // TODO add your handling code here:
        PagoEfectivo pe = new PagoEfectivo(this.total, this);
        pe.setSize(231, 231);
        pe.setLocation(0, 0);
        
        
        
        tipoPago.removeAll();
        tipoPago.add(pe, BorderLayout.CENTER);
        tipoPago.revalidate();
        tipoPago.repaint();
    }//GEN-LAST:event_btnEfectivoActionPerformed

    private void btnTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarjetaActionPerformed
        // TODO add your handling code here:
        PagoTarjeta pt = new PagoTarjeta(this.total, this);
        pt.setSize(231, 231);
        pt.setLocation(0, 0);
        
        tipoPago.removeAll();
        tipoPago.add(pt, BorderLayout.CENTER);
        tipoPago.revalidate();
        tipoPago.repaint();
        
        
        
    }//GEN-LAST:event_btnTarjetaActionPerformed

    private void txtProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProducto1ActionPerformed

    private void btnEditarNota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNota1ActionPerformed
        // TODO add your handling code here:
        editarNota(1);
    }//GEN-LAST:event_btnEditarNota1ActionPerformed

    private void btnEditarNota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNota2ActionPerformed
        // TODO add your handling code here:
        editarNota(2);
    }//GEN-LAST:event_btnEditarNota2ActionPerformed

    private void btnEditarNota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNota3ActionPerformed
        // TODO add your handling code here:
        editarNota(3);
    }//GEN-LAST:event_btnEditarNota3ActionPerformed

    private void btnEditarNota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNota4ActionPerformed
        // TODO add your handling code here:
        editarNota(4);
    }//GEN-LAST:event_btnEditarNota4ActionPerformed

    private void btnEditarNota5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNota5ActionPerformed
        // TODO add your handling code here:
        editarNota(5);
    }//GEN-LAST:event_btnEditarNota5ActionPerformed

    private void btnEditarNota6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNota6ActionPerformed
        // TODO add your handling code here:
        editarNota(6);
    }//GEN-LAST:event_btnEditarNota6ActionPerformed

    private void btnEditarNota7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNota7ActionPerformed
        // TODO add your handling code here:
        editarNota(7);
    }//GEN-LAST:event_btnEditarNota7ActionPerformed

    private void btnEditarNota8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNota8ActionPerformed
        // TODO add your handling code here:
        editarNota(8);
    }//GEN-LAST:event_btnEditarNota8ActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

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
            java.util.logging.Logger.getLogger(frmCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCarrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCarrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgLeche;
    private javax.swing.ButtonGroup bgTamanho;
    private javax.swing.JButton btnAumentarProducto1;
    private javax.swing.JButton btnAumentarProducto2;
    private javax.swing.JButton btnAumentarProducto3;
    private javax.swing.JButton btnAumentarProducto4;
    private javax.swing.JButton btnAumentarProducto5;
    private javax.swing.JButton btnAumentarProducto6;
    private javax.swing.JButton btnAumentarProducto7;
    private javax.swing.JButton btnAumentarProducto8;
    private javax.swing.JButton btnEditarNota1;
    private javax.swing.JButton btnEditarNota2;
    private javax.swing.JButton btnEditarNota3;
    private javax.swing.JButton btnEditarNota4;
    private javax.swing.JButton btnEditarNota5;
    private javax.swing.JButton btnEditarNota6;
    private javax.swing.JButton btnEditarNota7;
    private javax.swing.JButton btnEditarNota8;
    private javax.swing.JButton btnEfectivo;
    private javax.swing.JButton btnEliminarProducto1;
    private javax.swing.JButton btnEliminarProducto2;
    private javax.swing.JButton btnEliminarProducto3;
    private javax.swing.JButton btnEliminarProducto4;
    private javax.swing.JButton btnEliminarProducto5;
    private javax.swing.JButton btnEliminarProducto6;
    private javax.swing.JButton btnEliminarProducto7;
    private javax.swing.JButton btnEliminarProducto8;
    private javax.swing.JButton btnImprimirTicket;
    private javax.swing.JButton btnReducirProducto1;
    private javax.swing.JButton btnReducirProducto2;
    private javax.swing.JButton btnReducirProducto3;
    private javax.swing.JButton btnReducirProducto4;
    private javax.swing.JButton btnReducirProducto5;
    private javax.swing.JButton btnReducirProducto6;
    private javax.swing.JButton btnReducirProducto7;
    private javax.swing.JButton btnReducirProducto8;
    private javax.swing.JButton btnTarjeta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCantidadProducto1;
    private javax.swing.JLabel lbCantidadProducto2;
    private javax.swing.JLabel lbCantidadProducto3;
    private javax.swing.JLabel lbCantidadProducto4;
    private javax.swing.JLabel lbCantidadProducto5;
    private javax.swing.JLabel lbCantidadProducto6;
    private javax.swing.JLabel lbCantidadProducto7;
    private javax.swing.JLabel lbCantidadProducto8;
    private javax.swing.JLabel lblLicuados;
    private javax.swing.JLabel lblLicuados1;
    private javax.swing.JLabel lblLicuados3;
    private javax.swing.JLabel lblLicuados4;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel tipoPago;
    private javax.swing.JTextArea txtNota;
    private javax.swing.JTextField txtPrecioProducto1;
    private javax.swing.JTextField txtPrecioProducto2;
    private javax.swing.JTextField txtPrecioProducto3;
    private javax.swing.JTextField txtPrecioProducto4;
    private javax.swing.JTextField txtPrecioProducto5;
    private javax.swing.JTextField txtPrecioProducto6;
    private javax.swing.JTextField txtPrecioProducto7;
    private javax.swing.JTextField txtPrecioProducto8;
    private javax.swing.JTextField txtProducto1;
    private javax.swing.JTextField txtProducto2;
    private javax.swing.JTextField txtProducto3;
    private javax.swing.JTextField txtProducto4;
    private javax.swing.JTextField txtProducto5;
    private javax.swing.JTextField txtProducto6;
    private javax.swing.JTextField txtProducto7;
    private javax.swing.JTextField txtProducto8;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
