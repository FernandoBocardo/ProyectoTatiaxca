/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import Controlador.CtrlCategorias;
import Controlador.CtrlProductos;
import Dominio.Categoria;
import Dominio.Producto;
import Dominio.Proveedor;
import Dominio.Usuario;
import Persistencia.ProductosDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author PC OSCAR
 */
public class frmAdministrarProductos extends javax.swing.JFrame {

    private Long idProductoSeleccionado = 0L;
    private Usuario gerente;
    
    /**
     * Creates new form ClientesForm
     */
    public frmAdministrarProductos(Usuario gerente) {
        initComponents();
        Image img = new ImageIcon(getClass().getResource("/imagenes/logo tatiaxca.png")).getImage();
        //escala imagen
        Image newimg = img.getScaledInstance(84, 79, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);
        //asigna a componenente JLabel
        lblLogo.setIcon(imageIcon);
        setTitle("Administrador Productos");
        this.gerente = gerente;
        this.txtIdProducto.setEnabled(false);
        //this.initTablaClientes();
        //this.llenarTabla();
        this.llenarTablaProductos();
        this.llenarComboBox();
    }
    
    private void llenarTablaProductos()
    {
        List<Producto> listaProductos = CtrlProductos.getInstance().consultarTodos();
        DefaultTableModel modeloTabla = (DefaultTableModel)this.tblProductos.getModel();
        modeloTabla.setRowCount(0);
        listaProductos.forEach(producto -> {
            Object[] fila = new Object[7];
            fila[0] = producto.getIdProducto();
            fila[1] = producto.getNombre();
            fila[2] = producto.getPrecioCompra();    
            fila[3] = producto.getPrecioVenta();
            if(producto.getStock()==-1){
                fila[4] = "N/A";
            }else{
               fila[4] = producto.getStock(); 
            }           
            fila[5] = producto.getUnidadMedida();
            modeloTabla.addRow(fila); 
        });
    }
    
    private void llenarComboBox()
    {
        this.cbxCategoria.removeAllItems();
        this.cbxProveedor.removeAllItems();
        this.cbxBuscadorPorCategoria.removeAllItems();
        List<Categoria> listaCategorias = CtrlCategorias.getInstance().consultarTodos();
        int i = 0;
        while(i < listaCategorias.size())
        {
            this.cbxCategoria.addItem(listaCategorias.get(i));
            this.cbxBuscadorPorCategoria.addItem(listaCategorias.get(i));
            i++;
        }
        List<Proveedor> listaProveedores = new ArrayList<>();
        Proveedor proveedor1 = new Proveedor(1L, "Proveedor Ejemplo", "6445676532", null);
        listaProveedores.add(proveedor1);
        int j = 0;
        while(j < listaProveedores.size())
        {
            this.cbxProveedor.addItem(listaProveedores.get(j));
            j++;
        }
    }
    
    private Producto construirProducto()
    {
        Producto productoContruido = new Producto();
        productoContruido.setDescripcion(this.txtDescripcion.getText());
        Categoria categoria = (Categoria) this.cbxCategoria.getSelectedItem();
        productoContruido.setIdCategoria(categoria.getIdCategoria());
        productoContruido.setIdGerente(gerente.getIdUsuario());
        productoContruido.setIdMenu(1L);
        Proveedor proveedor = (Proveedor) this.cbxProveedor.getSelectedItem();
        productoContruido.setIdProveedor(proveedor.getIdProveedor());
        productoContruido.setNombre(this.txtNombre.getText());
        productoContruido.setPrecioCompra(Float.parseFloat(this.txtPrecioCompra.getText()));
        productoContruido.setPrecioVenta(Float.parseFloat(this.txtPrecioVenta.getText()));
        if(cbxNoAplica.isSelected()){
            productoContruido.setStock(-1);
        }else{
            productoContruido.setStock(Integer.parseInt(this.txtStock.getText()));
        }
        productoContruido.setUnidadMedida((String) this.cbxUnidadMedida.getSelectedItem());
        return productoContruido;
    }
    
    private void accion()
    {
        if (txtNombre.getText().equals("") || txtDescripcion.getText().equals("") || txtPrecioCompra.getText().equals("") || txtPrecioVenta.getText().equals("")
        || (txtStock.getText().equals("") && !cbxNoAplica.isSelected())) {
            JOptionPane.showMessageDialog(this, "Debes llenar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            
        }
        
        String accion = btnAccion.getText();
        switch(accion)
        {
            case "Registrar":
            {
                int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Estás seguro de registrar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcionSeleccionada == JOptionPane.YES_OPTION) {
                    Producto productoRegistrar = construirProducto();
                    if (CtrlProductos.getInstance().agregar(productoRegistrar)) {
                        JOptionPane.showMessageDialog(this, "Se registró el producto correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                        txtStock.setEnabled(true); 
                        this.llenarTablaProductos();
                        this.llenarComboBox();
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al intentar registrar el producto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            }
            case "Actualizar":
            {
                int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Estás seguro de actualizar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcionSeleccionada == JOptionPane.YES_OPTION) {
                    Producto productoActualizar = construirProducto();
                    if (CtrlProductos.getInstance().actualizar(Long.parseLong(this.txtIdProducto.getText()), productoActualizar)) {
                        JOptionPane.showMessageDialog(this, "Se actualizó el producto correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                        txtStock.setEnabled(true); 
                        this.llenarTablaProductos();
                        this.llenarComboBox();
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al intentar actualizar el producto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                break;
            }
        }
    }
    
    private void limpiarCampos()
    {
        this.txtIdProducto.setText("");
        this.txtNombre.setText("");
        this.txtPrecioCompra.setText("");
        this.txtPrecioVenta.setText("");
        this.txtStock.setText("");
        this.txtDescripcion.setText("");
        this.cbxNoAplica.setSelected(false);
    }
    
    private void cargarDatosProducto()
    {
        Producto productoSeleccionado = getProductoSeleccionado();
        if(productoSeleccionado == null)
        {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.txtIdProducto.setText(String.valueOf(productoSeleccionado.getIdProducto()));
        this.txtNombre.setText(productoSeleccionado.getNombre());
        this.txtPrecioCompra.setText(String.valueOf(productoSeleccionado.getPrecioCompra()));
        this.txtPrecioVenta.setText(String.valueOf(productoSeleccionado.getPrecioVenta()));
        if (productoSeleccionado.getStock() == -1) {
                cbxNoAplica.setSelected(true);
                txtStock.setEnabled(false); 
            } else{
            this.txtStock.setText(String.valueOf(productoSeleccionado.getStock()));
            cbxNoAplica.setSelected(false);
        }
        this.txtDescripcion.setText(productoSeleccionado.getDescripcion());
        int i = 0;
        while(i < this.cbxCategoria.getItemCount())
        {
            if(this.cbxCategoria.getItemAt(i).getIdCategoria().equals(productoSeleccionado.getIdCategoria()))
            {
                this.cbxCategoria.setSelectedIndex(i);
            }
            i++;
        }
        i = 0;
        while(i < this.cbxProveedor.getItemCount())
        {
            if(this.cbxProveedor.getItemAt(i).getIdProveedor().equals(productoSeleccionado.getIdProveedor()))
            {
                this.cbxProveedor.setSelectedIndex(i);
            }
            i++;
        }
        i = 0;
        while(i < this.cbxUnidadMedida.getItemCount())
        {
            if(this.cbxUnidadMedida.getItemAt(i).equals(productoSeleccionado.getUnidadMedida()))
            {
                this.cbxUnidadMedida.setSelectedIndex(i);
            }
            i++;
        }
    }
    
    private Producto getProductoSeleccionado()
    {
        final int columnaId = 0;
        int filaSeleccionada = tblProductos.getSelectedRow();
        if(filaSeleccionada == -1)
        {
            return null;
        }
        idProductoSeleccionado = (Long) tblProductos.getValueAt(filaSeleccionada, columnaId);
        Producto productoSeleccionado = CtrlProductos.getInstance().consultarPorId(idProductoSeleccionado);
        return productoSeleccionado;
    }
    
    private void buscarPorNombre()
    {
        Producto productoBuscado = CtrlProductos.getInstance().consultarPorNombre(this.txtBuscador.getText());
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(productoBuscado);
        DefaultTableModel modeloTabla = (DefaultTableModel)this.tblProductos.getModel();
        modeloTabla.setRowCount(0);
        if(listaProductos.isEmpty() || productoBuscado == null)
        {
            return;
        }
        listaProductos.forEach(producto -> {
            Object[] fila = new Object[7];
            fila[0] = producto.getIdProducto();
            fila[1] = producto.getNombre();
            fila[2] = producto.getPrecioCompra();    
            fila[3] = producto.getPrecioVenta();
            fila[4] = producto.getStock();
            fila[5] = producto.getUnidadMedida();
            modeloTabla.addRow(fila); 
        });
    }
    
    private void buscarPorCategoria()
    {
        Categoria categoriaBuscarSeleccionada = (Categoria) this.cbxBuscadorPorCategoria.getSelectedItem();
        List<Producto> listaProductos = CtrlProductos.getInstance().consultarPorCategoria(categoriaBuscarSeleccionada.getIdCategoria());
        DefaultTableModel modeloTabla = (DefaultTableModel)this.tblProductos.getModel();
        modeloTabla.setRowCount(0);
        if(listaProductos.isEmpty())
        {
            return;
        }
        listaProductos.forEach(producto -> {
            Object[] fila = new Object[7];
            fila[0] = producto.getIdProducto();
            fila[1] = producto.getNombre();
            fila[2] = producto.getPrecioCompra();    
            fila[3] = producto.getPrecioVenta();
            fila[4] = producto.getStock();
            fila[5] = producto.getUnidadMedida();
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

        pnlHeader = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        panMenu = new javax.swing.JPanel();
        panBusqueda = new javax.swing.JPanel();
        txtBuscador = new javax.swing.JTextField();
        btnBuscarPorNombre = new javax.swing.JButton();
        panBuscador = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnAgregarNuevo = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbxBuscadorPorCategoria = new javax.swing.JComboBox<>();
        btnBuscarPorCategoria = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRestaurar = new javax.swing.JButton();
        panRegistros = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblPrecioCompra = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblPrecioVenta = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAccion = new javax.swing.JButton();
        lblRegistroCliente = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblUnidadMedida = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        cbxCategoria = new javax.swing.JComboBox<>();
        cbxProveedor = new javax.swing.JComboBox<>();
        cbxUnidadMedida = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        cbxNoAplica = new javax.swing.JCheckBox();
        lblCategorias1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrar  Productos");
        setResizable(false);

        pnlHeader.setBackground(new java.awt.Color(222, 202, 184));

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(18, 93, 54));
        jLabel4.setText("Café Tatiaxca");

        panMenu.setBackground(new java.awt.Color(255, 255, 255));
        panMenu.setMaximumSize(new java.awt.Dimension(852, 405));
        panMenu.setMinimumSize(new java.awt.Dimension(852, 405));
        panMenu.setPreferredSize(new java.awt.Dimension(1084, 634));

        panBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        panBusqueda.setMaximumSize(new java.awt.Dimension(220, 300));
        panBusqueda.setMinimumSize(new java.awt.Dimension(220, 300));

        btnBuscarPorNombre.setText("Buscar");
        btnBuscarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorNombreActionPerformed(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Producto", "Nombre", "Precio Compra", "Precio Venta", "Stock", "Unidad Medida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panBuscador.setViewportView(tblProductos);

        btnAgregarNuevo.setBackground(new java.awt.Color(114, 199, 245));
        btnAgregarNuevo.setText("Agregar Nuevo");
        btnAgregarNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNuevoActionPerformed(evt);
            }
        });

        btnVer.setBackground(new java.awt.Color(193, 232, 213));
        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(193, 232, 213));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(193, 232, 213));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Buscar por categoria");

        btnBuscarPorCategoria.setText("Buscar");
        btnBuscarPorCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Buscar por nombre:");

        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBusquedaLayout = new javax.swing.GroupLayout(panBusqueda);
        panBusqueda.setLayout(panBusquedaLayout);
        panBusquedaLayout.setHorizontalGroup(
            panBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBusquedaLayout.createSequentialGroup()
                .addGap(0, 52, Short.MAX_VALUE)
                .addGroup(panBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBusquedaLayout.createSequentialGroup()
                        .addGroup(panBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panBuscador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarNuevo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBusquedaLayout.createSequentialGroup()
                                .addGroup(panBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panBusquedaLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panBusquedaLayout.createSequentialGroup()
                                        .addGroup(panBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnRestaurar)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxBuscadorPorCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(12, 12, 12)
                                .addGroup(panBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBuscarPorNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscarPorCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBusquedaLayout.createSequentialGroup()
                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        panBusquedaLayout.setVerticalGroup(
            panBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPorNombre))
                .addGap(24, 24, 24)
                .addGroup(panBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxBuscadorPorCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPorCategoria))
                .addGap(18, 18, 18)
                .addGroup(panBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarNuevo)
                    .addComponent(btnRestaurar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panRegistros.setBackground(new java.awt.Color(204, 204, 204));
        panRegistros.setMaximumSize(new java.awt.Dimension(330, 325));
        panRegistros.setMinimumSize(new java.awt.Dimension(330, 325));

        lblNombre.setBackground(new java.awt.Color(39, 76, 119));
        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombre.setText("Nombre:");
        lblNombre.setMaximumSize(new java.awt.Dimension(72, 25));
        lblNombre.setMinimumSize(new java.awt.Dimension(72, 25));
        lblNombre.setPreferredSize(new java.awt.Dimension(72, 25));

        lblPrecioCompra.setBackground(new java.awt.Color(39, 76, 119));
        lblPrecioCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecioCompra.setText("Precio Compra:");
        lblPrecioCompra.setMaximumSize(new java.awt.Dimension(68, 25));
        lblPrecioCompra.setMinimumSize(new java.awt.Dimension(68, 25));
        lblPrecioCompra.setPreferredSize(new java.awt.Dimension(68, 25));

        lblStock.setBackground(new java.awt.Color(39, 76, 119));
        lblStock.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStock.setText("Stock:");
        lblStock.setMaximumSize(new java.awt.Dimension(68, 25));
        lblStock.setMinimumSize(new java.awt.Dimension(68, 25));
        lblStock.setPreferredSize(new java.awt.Dimension(68, 25));

        lblPrecioVenta.setBackground(new java.awt.Color(39, 76, 119));
        lblPrecioVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecioVenta.setText("Precio Venta:");
        lblPrecioVenta.setMaximumSize(new java.awt.Dimension(72, 25));
        lblPrecioVenta.setMinimumSize(new java.awt.Dimension(72, 25));
        lblPrecioVenta.setPreferredSize(new java.awt.Dimension(72, 25));

        txtStock.setMinimumSize(new java.awt.Dimension(4, 25));
        txtStock.setPreferredSize(new java.awt.Dimension(4, 25));
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        txtPrecioVenta.setMinimumSize(new java.awt.Dimension(4, 23));
        txtPrecioVenta.setName(""); // NOI18N
        txtPrecioVenta.setPreferredSize(new java.awt.Dimension(4, 23));
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });

        txtPrecioCompra.setMinimumSize(new java.awt.Dimension(4, 25));
        txtPrecioCompra.setPreferredSize(new java.awt.Dimension(4, 25));
        txtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyTyped(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAccion.setBackground(new java.awt.Color(193, 232, 213));
        btnAccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAccion.setText("Registrar");
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });

        lblRegistroCliente.setBackground(new java.awt.Color(39, 76, 119));
        lblRegistroCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRegistroCliente.setText("ID Producto:");
        lblRegistroCliente.setMaximumSize(new java.awt.Dimension(72, 25));
        lblRegistroCliente.setMinimumSize(new java.awt.Dimension(72, 25));
        lblRegistroCliente.setPreferredSize(new java.awt.Dimension(72, 25));

        txtNombre.setMinimumSize(new java.awt.Dimension(4, 25));
        txtNombre.setPreferredSize(new java.awt.Dimension(4, 25));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        lblUnidadMedida.setBackground(new java.awt.Color(39, 76, 119));
        lblUnidadMedida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUnidadMedida.setText("Unidad Medida:");
        lblUnidadMedida.setMaximumSize(new java.awt.Dimension(68, 25));
        lblUnidadMedida.setMinimumSize(new java.awt.Dimension(68, 25));
        lblUnidadMedida.setPreferredSize(new java.awt.Dimension(68, 25));

        lblCategoria.setBackground(new java.awt.Color(39, 76, 119));
        lblCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCategoria.setText("Categoria:");
        lblCategoria.setMaximumSize(new java.awt.Dimension(68, 25));
        lblCategoria.setMinimumSize(new java.awt.Dimension(68, 25));
        lblCategoria.setPreferredSize(new java.awt.Dimension(68, 25));

        lblProveedor.setBackground(new java.awt.Color(39, 76, 119));
        lblProveedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProveedor.setText("Proveedor:");
        lblProveedor.setMaximumSize(new java.awt.Dimension(68, 25));
        lblProveedor.setMinimumSize(new java.awt.Dimension(68, 25));
        lblProveedor.setPreferredSize(new java.awt.Dimension(68, 25));

        lblDescripcion.setBackground(new java.awt.Color(39, 76, 119));
        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDescripcion.setText("Descripción:");
        lblDescripcion.setMaximumSize(new java.awt.Dimension(68, 25));
        lblDescripcion.setMinimumSize(new java.awt.Dimension(68, 25));
        lblDescripcion.setPreferredSize(new java.awt.Dimension(68, 25));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        cbxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedorActionPerformed(evt);
            }
        });

        cbxUnidadMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidades", "gr" }));

        txtIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProductoActionPerformed(evt);
            }
        });

        cbxNoAplica.setText("No aplica");
        cbxNoAplica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNoAplicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panRegistrosLayout = new javax.swing.GroupLayout(panRegistros);
        panRegistros.setLayout(panRegistrosLayout);
        panRegistrosLayout.setHorizontalGroup(
            panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegistrosLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(btnAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panRegistrosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panRegistrosLayout.createSequentialGroup()
                        .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addGroup(panRegistrosLayout.createSequentialGroup()
                        .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panRegistrosLayout.createSequentialGroup()
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxNoAplica))
                            .addComponent(cbxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(panRegistrosLayout.createSequentialGroup()
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panRegistrosLayout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegistrosLayout.createSequentialGroup()
                            .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(panRegistrosLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblRegistroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panRegistrosLayout.createSequentialGroup()
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panRegistrosLayout.createSequentialGroup()
                        .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(cbxProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );
        panRegistrosLayout.setVerticalGroup(
            panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegistrosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxNoAplica))
                .addGap(11, 11, 11)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAccion, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lblCategorias1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 30)); // NOI18N
        lblCategorias1.setForeground(new java.awt.Color(91, 91, 91));
        lblCategorias1.setText("Administrar | Productos");

        javax.swing.GroupLayout panMenuLayout = new javax.swing.GroupLayout(panMenu);
        panMenu.setLayout(panMenuLayout);
        panMenuLayout.setHorizontalGroup(
            panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMenuLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategorias1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        panMenuLayout.setVerticalGroup(
            panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMenuLayout.createSequentialGroup()
                .addGroup(panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblCategorias1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panMenuLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(panBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addComponent(panMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        char c= evt.getKeyChar();
        if (c != '\b' && (c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Has ingresado un carácter no válido. Solo se permiten números.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        if (txtStock.getText().length() >= 15) {
            JOptionPane.showMessageDialog(null, "Has superado el límite de caracteres permitidos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        char c= evt.getKeyChar();
        if (c != '\b' && (c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Has ingresado un carácter no válido. Solo se permiten números.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        if (txtPrecioVenta.getText().length() >= 15) {
            JOptionPane.showMessageDialog(null, "Has superado el límite de caracteres permitidos.", "Advertencia", JOptionPane.WARNING_MESSAGE);            
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtPrecioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyTyped
        char c= evt.getKeyChar();
        if (c != '\b' && (c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Has ingresado un carácter no válido. Solo se permiten números.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        if (txtPrecioCompra.getText().length() >= 15) {
            JOptionPane.showMessageDialog(null, "Has superado el límite de caracteres permitidos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtPrecioCompraKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.tblProductos.clearSelection();
        this.limpiarCampos();
        this.idProductoSeleccionado = 0L;
        new frmMenu(gerente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        
        this.accion();
    }//GEN-LAST:event_btnAccionActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        if (txtNombre.getText().length() >= 45) {
            JOptionPane.showMessageDialog(null, "Has superado el límite de caracteres permitidos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    
    private void btnBuscarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorNombreActionPerformed
        if(txtBuscador.getText().equals(""))
        {
            this.llenarTablaProductos();
        }
        else
        {
            this.buscarPorNombre();
        }
    }//GEN-LAST:event_btnBuscarPorNombreActionPerformed

    private void txtIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProductoActionPerformed

    private void cbxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProveedorActionPerformed

    private void btnAgregarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNuevoActionPerformed
        this.limpiarCampos();
        this.btnAccion.setText("Registrar");
        this.btnAccion.setEnabled(true);
    }//GEN-LAST:event_btnAgregarNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.cargarDatosProducto();
        this.btnAccion.setText("Actualizar");
        this.btnAccion.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcionSeleccionada == JOptionPane.YES_OPTION) 
        {
            if(CtrlProductos.getInstance().eliminar(getProductoSeleccionado().getIdProducto()))
            {
                JOptionPane.showMessageDialog(this, "Se eliminó el producto correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.llenarTablaProductos();
                this.limpiarCampos();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Hubo un error al intentar eliminar el producto", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }  
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        this.cargarDatosProducto();
        this.btnAccion.setEnabled(false);
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnBuscarPorCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorCategoriaActionPerformed
        this.buscarPorCategoria();
    }//GEN-LAST:event_btnBuscarPorCategoriaActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        // TODO add your handling code here:
        llenarTablaProductos();
        txtBuscador.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtStock.setText("");
        txtPrecioCompra.setText("");
        txtPrecioVenta.setText("");
        txtIdProducto.setText("");
        this.cbxNoAplica.setSelected(false);
        txtStock.setEnabled(true);
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void cbxNoAplicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNoAplicaActionPerformed
        // TODO add your handling code here:
        if(cbxNoAplica.isSelected()){
            txtStock.setEnabled(false);
            txtStock.setText("");
        }else{
            txtStock.setEnabled(true); 
        }
    }//GEN-LAST:event_cbxNoAplicaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccion;
    private javax.swing.JButton btnAgregarNuevo;
    private javax.swing.JButton btnBuscarPorCategoria;
    private javax.swing.JButton btnBuscarPorNombre;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnVer;
    private javax.swing.JComboBox<Categoria> cbxBuscadorPorCategoria;
    private javax.swing.JComboBox<Categoria> cbxCategoria;
    private javax.swing.JCheckBox cbxNoAplica;
    private javax.swing.JComboBox<Proveedor> cbxProveedor;
    private javax.swing.JComboBox<String> cbxUnidadMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCategorias1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecioCompra;
    private javax.swing.JLabel lblPrecioVenta;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblRegistroCliente;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JScrollPane panBuscador;
    private javax.swing.JPanel panBusqueda;
    private javax.swing.JPanel panMenu;
    private javax.swing.JPanel panRegistros;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
