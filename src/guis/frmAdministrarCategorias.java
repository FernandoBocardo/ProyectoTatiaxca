/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guis;

import Controlador.CtrlCategorias;
import Controlador.CtrlProductos;
import Dominio.Categoria;
import Dominio.Usuario;
import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A515-52
 */
public class frmAdministrarCategorias extends javax.swing.JFrame {

    private Long idCategoriaSeleccionada = 0L;
    private Usuario gerente;
    private Color color = Color.decode("#3C3F41");

    public frmAdministrarCategorias(Usuario gerente) {
        initComponents();
        Image img = new ImageIcon(getClass().getResource("/imagenes/logo tatiaxca.png")).getImage();
        //escala imagen
        Image newimg = img.getScaledInstance(84, 79, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);
        //asigna a componenente JLabel
        lblLogo.setIcon(imageIcon);
        this.txtIdCategoria.setEnabled(false);
        this.gerente = gerente;
        llenarTabla();
        centerForm();
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
    private frmAdministrarCategorias() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void llenarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCategorias.getModel();
        modeloTabla.setRowCount(0);
        List<Categoria> listaCategorias = CtrlCategorias.getInstance().consultarTodos();
        listaCategorias.forEach(categoria -> {
            Object[] fila = new Object[3];
            fila[0] = categoria.getIdCategoria();
            fila[1] = categoria.getNombre();
            fila[2] = categoria.getDescripcion();
            modeloTabla.addRow(fila);
        });
    }

    private Categoria construirCategoria() {
        Categoria categoriaContruida = new Categoria();
        categoriaContruida.setDescripcion(this.txtDescripcion.getText());
        categoriaContruida.setNombre(this.txtNombreCategoria.getText());
        categoriaContruida.setIdGerente(gerente.getIdUsuario());
        return categoriaContruida;
    }

    public void limpiarCampos() {
        this.txtIdCategoria.setText("");
        this.txtNombreCategoria.setText("");
        this.txtDescripcion.setText("");
        this.txtNombreCategoria.setEditable(true);
        this.txtDescripcion.setEditable(true);
    }

    private void accion() {
        if (this.txtNombreCategoria.getText().equals("") || this.txtDescripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debes llenar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            
        }

        String accion = btnAccion.getText();
        switch (accion) {
            case "Registrar": {
                int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Estás seguro de registrar la categoria?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcionSeleccionada == JOptionPane.YES_OPTION) {
                    Categoria categoriaRegistrar = construirCategoria();
                    if (CtrlCategorias.getInstance().agregar(categoriaRegistrar)) {
                        JOptionPane.showMessageDialog(this, "Se registró la categoria correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                        lblNom.setText("Nombre:");
                        lblDes.setText("Descripción:");
                        lblNom.setForeground(color);
                        lblDes.setForeground(color);
                        limpiarCampos();
                        this.llenarTabla();
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al intentar registrar la categoria", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            }
            case "Actualizar": {
                int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Estás seguro de actualizar la categoria?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcionSeleccionada == JOptionPane.YES_OPTION) {
                    Categoria productoActualizar = construirCategoria();
                    if (CtrlCategorias.getInstance().actualizar(Long.parseLong(this.txtIdCategoria.getText()), productoActualizar)) {
                        JOptionPane.showMessageDialog(this, "Se actualizó la categoria correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                        this.llenarTabla();
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al intentar actualizar la categoria", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;
            }
        }
    }

    private void cargarDatosCategoria() {
        Categoria categoriaSeleccionada = getCategoriaSeleccionada();
        if (categoriaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una categoria", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.txtIdCategoria.setText(String.valueOf(categoriaSeleccionada.getIdCategoria()));
        this.txtDescripcion.setText(categoriaSeleccionada.getDescripcion());
        this.txtNombreCategoria.setText(categoriaSeleccionada.getNombre());
    }

    private Categoria getCategoriaSeleccionada() {
        final int columnaId = 0;
        int filaSeleccionada = tblCategorias.getSelectedRow();
        if (filaSeleccionada == -1) {
            return null;
        }
        idCategoriaSeleccionada = (Long) tblCategorias.getValueAt(filaSeleccionada, columnaId);
        Categoria categoriaSeleccionada = CtrlCategorias.getInstance().consultarPorId(idCategoriaSeleccionada);
        return categoriaSeleccionada;
    }

    private void buscarPorNombre() {
        Categoria categoriaBuscada = CtrlCategorias.getInstance().consultarPorNombre(this.txtBuscarNombre.getText());
        List<Categoria> listaCategorias = new ArrayList<>();
        listaCategorias.add(categoriaBuscada);
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCategorias.getModel();
        modeloTabla.setRowCount(0);
        if (listaCategorias.isEmpty() || categoriaBuscada == null) {
            return;
        }
        listaCategorias.forEach(categoria -> {
            Object[] fila = new Object[3];
            fila[0] = categoria.getIdCategoria();
            fila[1] = categoria.getNombre();
            fila[2] = categoria.getDescripcion();
            modeloTabla.addRow(fila);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        panelBotones1 = new javax.swing.JPanel();
        lblCategorias = new javax.swing.JLabel();
        pnlHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblCategorias1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblIdCategoria = new javax.swing.JLabel();
        txtIdCategoria = new javax.swing.JTextField();
        lblNom = new javax.swing.JLabel();
        txtNombreCategoria = new javax.swing.JTextField();
        lblDes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnAccion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();
        btnVer = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAgregarNueva = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();

        panelBotones.setBackground(new java.awt.Color(255, 255, 255));
        panelBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        panelBotones.setForeground(new java.awt.Color(255, 255, 255));
        panelBotones.setLayout(new java.awt.BorderLayout());

        panelBotones1.setBackground(new java.awt.Color(255, 255, 255));
        panelBotones1.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        panelBotones1.setForeground(new java.awt.Color(255, 255, 255));
        panelBotones1.setLayout(new java.awt.BorderLayout());

        lblCategorias.setFont(new java.awt.Font("Segoe UI Emoji", 0, 70)); // NOI18N
        lblCategorias.setForeground(new java.awt.Color(91, 91, 91));
        lblCategorias.setText("Categorias de Producto");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrar Categorías");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(1084, 634));

        pnlHeader.setBackground(new java.awt.Color(222, 202, 184));

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 93, 54));
        jLabel1.setText("Café Tatiaxca");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(15, 15, 15))
        );

        lblCategorias1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 30)); // NOI18N
        lblCategorias1.setForeground(new java.awt.Color(91, 91, 91));
        lblCategorias1.setText("Administrar | Categorías");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));

        lblIdCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIdCategoria.setText("ID Categoría:");

        lblNom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNom.setText("Nombre:");

        lblDes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDes.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAccion.setBackground(new java.awt.Color(193, 232, 213));
        btnAccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAccion.setText("Registrar");
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNom)
                            .addComponent(lblIdCategoria)
                            .addComponent(lblDes))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(txtNombreCategoria)
                            .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdCategoria)
                    .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom)
                    .addComponent(txtNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDes)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Buscar por nombre:");

        txtBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarNombreActionPerformed(evt);
            }
        });

        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Categoría", "Nombre", "Descripción"
            }
        ));
        jScrollPane2.setViewportView(tblCategorias);

        btnVer.setBackground(new java.awt.Color(193, 232, 213));
        btnVer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(193, 232, 213));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(193, 232, 213));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAgregarNueva.setBackground(new java.awt.Color(119, 199, 245));
        btnAgregarNueva.setText("Agregar Nueva");
        btnAgregarNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNuevaActionPerformed(evt);
            }
        });

        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblCategorias1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRestaurar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(lblCategorias1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarNueva)
                            .addComponent(btnRestaurar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVer)
                            .addComponent(btnEliminar))
                        .addGap(98, 98, 98))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed

        this.accion();
    }//GEN-LAST:event_btnAccionActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        if (txtBuscarNombre.getText().equals("")) {
            this.llenarTabla();
        } else {
            this.buscarPorNombre();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        lblNom.setText("Nombre:");
        lblDes.setText("Descripción:");
        lblNom.setForeground(color);
        lblDes.setForeground(color);
        Categoria categoriaSeleccionada = getCategoriaSeleccionada();
        if (categoriaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una categoria", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!(CtrlProductos.getInstance().consultarPorCategoria(categoriaSeleccionada.getIdCategoria()).isEmpty()))
        {
            JOptionPane.showMessageDialog(this, "No se puede eliminar una categoria con productos registrados", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar la categoria?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcionSeleccionada == JOptionPane.YES_OPTION) {
            if (CtrlCategorias.getInstance().eliminar(getCategoriaSeleccionada().getIdCategoria())) {
                JOptionPane.showMessageDialog(this, "Se eliminó la categoria correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.llenarTabla();
                this.limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al intentar eliminar la categoria", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        lblNom.setText("Nombre:");
        lblDes.setText("Descripción:");
        lblNom.setForeground(color);
        lblDes.setForeground(color);
        this.cargarDatosCategoria();
        this.btnAccion.setEnabled(false);
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        lblNom.setText("Nombre:");
        lblDes.setText("Descripción:");
        lblNom.setForeground(color);
        lblDes.setForeground(color);
        this.cargarDatosCategoria();
        this.btnAccion.setText("Actualizar");
        this.btnAccion.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNuevaActionPerformed
        this.limpiarCampos();
        lblNom.setForeground(Color.RED);
        lblNom.setText("Nombre*:");
        lblDes.setForeground(Color.RED);
        lblDes.setText("Descripción*:");
        this.btnAccion.setText("Registrar");
        this.btnAccion.setEnabled(true);
    }//GEN-LAST:event_btnAgregarNuevaActionPerformed

    private void txtBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        new frmMenu(gerente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
        if(txtDescripcion.getText().length()>=100){
            JOptionPane.showMessageDialog(null, "Has superado el límite de caracteres permitidos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        // TODO add your handling code here:
        llenarTabla();
        txtBuscarNombre.setText("");
    }//GEN-LAST:event_btnRestaurarActionPerformed

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
            java.util.logging.Logger.getLogger(frmAdministrarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdministrarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdministrarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdministrarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdministrarCategorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccion;
    private javax.swing.JButton btnAgregarNueva;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCategorias;
    private javax.swing.JLabel lblCategorias1;
    private javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblIdCategoria;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNom;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotones1;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdCategoria;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables
}
