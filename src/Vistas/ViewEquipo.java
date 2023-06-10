/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.EquipoData;
import AccesoADatos.EquipoMiembroData;
import AccesoADatos.MiembroData;
import AccesoADatos.ProyectoData;
import AccesoADatos.TareaData;
import Entidades.Equipo;
import Entidades.EquipoMiembro;
import Entidades.Miembro;
import Entidades.Proyecto;
import Entidades.Tarea;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edu-1
 */
public class ViewEquipo extends javax.swing.JInternalFrame {

    private Equipo equipo;
    private EquipoData equipoData;
    private Proyecto proyecto;
    private ProyectoData proData;
    private MiembroData mData;
    private EquipoMiembroData eqMdata;
    private EquipoMiembro eqMiembro;
    private Miembro miembro;
    private TareaData tData;
    private Tarea tarea;

    private DefaultTableModel tabla, tablaB;

    public ViewEquipo() {
        initComponents();
        equipo = new Equipo();
        equipoData = new EquipoData();
        proyecto = new Proyecto();
        proData = new ProyectoData();
        eqMiembro = new EquipoMiembro();
        miembro = new Miembro();
        tarea = new Tarea();
        tData = new TareaData();
        mData = new MiembroData();
        eqMdata = new EquipoMiembroData();
        tabla = new DefaultTableModel();
        crearTabla();
        tablaB = new DefaultTableModel();
        crearTablaB();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdEq = new javax.swing.JTextField();
        txtIdPro = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jCalendario = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaEq = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLista = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        jEstado = new javax.swing.JCheckBox();
        btnDesactivar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListaIntegranteEq = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnIntegrantes = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("EQUIPO");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("N° de Identificacion:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("N° de Identificación de Proyecto:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Fecha de Creación:");

        txtIdPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdProMouseClicked(evt);
            }
        });
        txtIdPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProActionPerformed(evt);
            }
        });

        jListaEq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° Poryecto", "N° Equipo", "Nombre", "Fecha de Creación", "Estado"
            }
        ));
        jListaEq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaEqMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListaEq);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");

        btnLista.setText("Lista");
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });

        btnActivar.setText("Activar");

        jEstado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jEstado.setText("Estado");

        btnDesactivar.setText("Desactivar");

        jButton6.setText("Buscar");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Listado de Equipos Activos/No Activos");

        jListaIntegranteEq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Tareas Asignadas", "Fecha de Creación", "Fecha de Incorporación"
            }
        ));
        jScrollPane2.setViewportView(jListaIntegranteEq);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Integrantes del Equipo");

        btnIntegrantes.setText("Ver Integrantes");
        btnIntegrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntegrantesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActivar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDesactivar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5))
                                            .addGap(103, 103, 103)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(97, 97, 97)
                                                    .addComponent(txtIdEq, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(83, 83, 83)
                                            .addComponent(jButton6))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jEstado)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(44, 44, 44)
                                    .addComponent(btnIntegrantes)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel6)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdEq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jEstado))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnBorrar)
                    .addComponent(btnLista)
                    .addComponent(btnActivar)
                    .addComponent(btnDesactivar))
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIntegrantes)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
            int idP = Integer.parseInt(txtIdPro.getText());
            proyecto = proData.buscarProyectoPorId(idP);
            String nombre = txtNombre.getText();

            Date fechaSql = new Date(jCalendario.getDate().getTime());
            LocalDate fechaCreacion = fechaSql.toLocalDate();

            boolean estado = jEstado.isSelected();

            equipo = new Equipo(proyecto, nombre, fechaCreacion, estado);
            equipoData.guardarEquipo(equipo);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR ");

        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtIdProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtIdProActionPerformed

    private void txtIdProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdProMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_txtIdProMouseClicked

    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        List<Equipo> dato;

        String[] fila = new String[5];

        dato = equipoData.listaEquipo();
        for (int i = 0; i < dato.size(); i++) {
            fila[0] = dato.get(i).getProyectoId().getIdProyecto() + "";
            fila[1] = dato.get(i).getIdEquipo() + "";
            fila[2] = dato.get(i).getNombre();
            fila[3] = dato.get(i).getFechaCreacion() + "";
            fila[4] = dato.get(i).isEstado() + "";
            tabla.addRow(fila);
        }
        jListaEq.setModel(tabla);


    }//GEN-LAST:event_btnListaActionPerformed

    private void btnIntegrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntegrantesActionPerformed
        try {
            List<Equipo> datoA = new ArrayList<>();
            List<EquipoMiembro> datoB = new ArrayList<>();
            List<Tarea> datoC;

//  List<EquipoData> datoeq;
            int idBB = 0;
            int filaSelec = jListaEq.getSelectedRow();
            if (filaSelec != -1) {
                String idEquipo = (String) tabla.getValueAt(filaSelec, 1);
                int id = Integer.parseInt(idEquipo);

                String[] fila = new String[5];
//
                for (int i = 0; i < 1; i++) {
                    fila[0] = eqMdata.buscarEquipoMiembroPorId(id).getMiembroId().getNombre();
                    fila[1] = eqMdata.buscarEquipoMiembroPorId(id).getMiembroId().getApellido();
                    fila[2] = eqMdata.buscarEquipoMiembroPorId(id).getMiembroId().getDni() + "";

                    int idT = tData.buscarTareaPorIdMiEq(eqMdata.buscarEquipoMiembroPorIdMiembro(id).getIdMiembroEq()).getIdTarea();

                   
                    if (tData.buscarTareaPorId(idT).getNombre().concat(" - " + tData.buscarTareaPorId(idT + 1).getNombre())!=null) {
                         fila[3]=tData.buscarTareaPorIdMiEq(eqMdata.buscarEquipoMiembroPorIdMiembro(idT).getIdMiembroEq()).getNombre();
                    }else{
                         fila[3] = tData.buscarTareaPorId(idT).getNombre().concat(" - " + tData.buscarTareaPorId(idT + 1).getNombre());
                    }
                    // fila[3]=tData.buscarTareaPorIdMiEq(eqMdata.buscarEquipoMiembroPorIdMiembro(idT).getIdMiembroEq()).getNombre() ;
                    fila[4] = eqMdata.buscarEquipoMiembroPorId(id).getFechaIncorporacion() + "";

                    tablaB.addRow(fila);
                }
            }
            jListaIntegranteEq.setModel(tablaB);

//          System.out.println("Nombre del Miembro:       " + miembro.getNombre());
//                System.out.println("Apellido del Miembro:     " + miembro.getApellido());
//                System.out.println("DNI del Miembro:          " + miembro.getDni());
//                System.out.println("Tareas asignadas:         " + tarea.getNombre());
//                System.out.println("Fecha de Incorporación:   " + eqm.getFechaIncorporacion());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnIntegrantesActionPerformed

    private void jListaEqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaEqMouseClicked


    }//GEN-LAST:event_jListaEqMouseClicked
    public void crearTabla() {
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("id Proyecto");
        columnas.add("id Equipo");
        columnas.add("Nombre");
        columnas.add("Fecha de Creación");
        columnas.add("Estado");
        for (Object iter : columnas) {
            tabla.addColumn(iter);
        }
        jListaEq.setModel(tabla);
    }

    public void borrarTabla() {
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tabla.removeRow(i);
        }
    }

    public void crearTablaB() {
        ArrayList<Object> columnasB = new ArrayList<Object>();
        columnasB.add("Nombre");
        columnasB.add("Apellido");
        columnasB.add("DNI");
        columnasB.add("Tarea Asignadas");
        columnasB.add("Fecha de Incorporación");
        for (Object iter : columnasB) {
            tablaB.addColumn(iter);
        }
        jListaIntegranteEq.setModel(tablaB);
    }

    public void borrarTablaB() {
        int a = tablaB.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tablaB.removeRow(i);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIntegrantes;
    private javax.swing.JButton btnLista;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jCalendario;
    private javax.swing.JCheckBox jEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTable jListaEq;
    private javax.swing.JTable jListaIntegranteEq;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtIdEq;
    private javax.swing.JTextField txtIdPro;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
