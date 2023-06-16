/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.EquipoData;
import AccesoADatos.EquipoMiembroData;
import AccesoADatos.MiembroData;
import Entidades.Equipo;
import Entidades.EquipoMiembro;
import Entidades.Miembro;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thefl
 */
public class ViewEquipoMiembro extends javax.swing.JInternalFrame {

    private DefaultTableModel tabla;
    private DefaultTableModel tabla2;
    private EquipoData equipoData;
    private EquipoMiembroData meD;
    private MiembroData mD;

    /**
     * Creates new form ViewEquipoMiembro
     */
    public ViewEquipoMiembro() {
        initComponents();
        meD = new EquipoMiembroData();
        equipoData = new EquipoData();
        tabla = new DefaultTableModel();
        tabla2 = new DefaultTableModel();
        mD = new MiembroData();
        crearTabla();
        crearTabla2();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        lbAddME = new javax.swing.JLabel();
        bAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaIns = new javax.swing.JTable();
        bInscripciones = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaE = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        bListaE = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        dateIncor = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jScrollPane3.setViewportView(jTree1);

        lbAddME.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbAddME.setText("Agregar Miembro a un Equipo");

        bAgregar.setText("Agregar");
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });

        tablaIns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N° Inscripcion", "Fecha de Incorporacion", "N° Equipo", "N° Miembro"
            }
        ));
        jScrollPane2.setViewportView(tablaIns);

        bInscripciones.setText("Inscripciones");
        bInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInscripcionesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nombre: ");

        tablaE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre de Equipo", "Cantidad de Miembros"
            }
        ));
        jScrollPane4.setViewportView(tablaE);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Apellido: ");

        tfApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfApellidoActionPerformed(evt);
            }
        });

        bListaE.setText("Lista de Equipos");
        bListaE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bListaEActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Fecha de Incorporacion: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(lbAddME))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfApellido))))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(bInscripciones)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bListaE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAgregar)
                        .addGap(138, 138, 138))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(dateIncor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbAddME)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateIncor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bListaE)
                            .addComponent(bAgregar))
                        .addGap(78, 78, 78)
                        .addComponent(bInscripciones)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfApellidoActionPerformed

    private void bListaEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bListaEActionPerformed
        borrarTabla();
        List<Equipo> dato;
        String[] fila = new String[2];
        dato = equipoData.listaEquipo();
        for (int i = 0; i < dato.size(); i++) {
            fila[0] = dato.get(i).getNombre();
            String n = meD.devolverEquiposId(dato.get(i).getIdEquipo());
            fila[1] = n;
            tabla.addRow(fila);
        }
        tablaE.setModel(tabla);
    }//GEN-LAST:event_bListaEActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        int filaSelec = tablaE.getSelectedRow();
        String nombreEq = (String) tabla.getValueAt(filaSelec, 0);

        String nombre = tfNombre.getText();
        String apellido = tfApellido.getText();

        Date fechaSql = new Date(dateIncor.getDate().getTime());
        LocalDate fechaIncor = fechaSql.toLocalDate();

        Equipo equipo = equipoData.devolverEq(nombreEq);

        Miembro miembro = mD.devolverMi(nombre, apellido);

        meD.guardarEquipoMiembro(new EquipoMiembro(equipo, miembro, fechaIncor));

    }//GEN-LAST:event_bAgregarActionPerformed

    private void bInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInscripcionesActionPerformed
        borrarTabla2();
        List<EquipoMiembro> dato;
        String[] fila = new String[4];
        dato = meD.listarEM();
        for (int i = 0; i < dato.size(); i++) {
            fila[0] = dato.get(i).getIdMiembroEq()+"";
            fila[1] = dato.get(i).getFechaIncorporacion()+"";
            fila[2] = dato.get(i).getEquipoId().getIdEquipo()+"";
            fila[3] = dato.get(i).getMiembroId().getIdMiembro()+"";
            tabla2.addRow(fila);
        }
        tablaIns.setModel(tabla2);
    }//GEN-LAST:event_bInscripcionesActionPerformed

    public void crearTabla2() {
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("N° Inscripcion");
        columnas.add("Fecha de Incorporacion");
        columnas.add("N° Equipo");
        columnas.add("N° Miembro");
        for (Object iter : columnas) {
            tabla2.addColumn(iter);
        }
        tablaIns.setModel(tabla2);
    }
    
    public void crearTabla() {
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("Nombre de Equipo");
        columnas.add("Cantidad de Miembros");
        for (Object iter : columnas) {
            tabla.addColumn(iter);
        }
        tablaE.setModel(tabla);
    }

    public void borrarTabla() {
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tabla.removeRow(i);
        }
    }
    
    public void borrarTabla2() {
        int a = tabla2.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tabla2.removeRow(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bInscripciones;
    private javax.swing.JButton bListaE;
    private com.toedter.calendar.JDateChooser dateIncor;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lbAddME;
    private javax.swing.JTable tablaE;
    private javax.swing.JTable tablaIns;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
