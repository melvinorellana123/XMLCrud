/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyectoxml.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import proyectoxml.Alumno.Alumno;
import proyectoxml.xmlManager.XmlManager;

/**
 * @author melvi
 */
public class PanelAlumnos extends javax.swing.JPanel {

    private VentaPrincipal ventanaPrincipal;
    private XmlManager xmlManager = new XmlManager();
    private ArrayList<Alumno> alumnos = null;

    DefaultTableModel dtm;

    public PanelAlumnos(VentaPrincipal vp) {
        initComponents();
        this.ventanaPrincipal = vp;
        dtm = (DefaultTableModel) JTAlumnos.getModel();
        getAlumnos();
        refreshTable();
    }

    public void refreshTable() {
        if (alumnos == null) {
            return;
        }
        dtm.setRowCount(0);
        alumnos.forEach((alumno) -> {
            dtm.addRow(alumno.toRow());
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

        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btbCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTAlumnos = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(800, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnBuscarKeyTyped(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btbCrear.setText("Crear");
        btbCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbCrearMouseClicked(evt);
            }
        });
        btbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btbCrear)
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar)
                    .addComponent(btbCrear))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        JTAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Edad", "Teléfono", "Identidad", "Correo", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTAlumnosMouseClicked(evt);
            }
        });
        JTAlumnos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                JTAlumnosComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(JTAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbCrearActionPerformed
        onCreateAlumno();
    }//GEN-LAST:event_btbCrearActionPerformed

    private void btbCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbCrearMouseClicked

    }//GEN-LAST:event_btbCrearMouseClicked

    private void JTAlumnosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_JTAlumnosComponentShown
     }//GEN-LAST:event_JTAlumnosComponentShown

    private void onCreateAlumno() {
        ventanaPrincipal.setIsEditingAlumno(false);
        ventanaPrincipal.mostrarPanelAlumnoDetalle();
    }

    private void JTAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTAlumnosMouseClicked
//        String row = dtm.getDataVector().elementAt(JTAlumnos.convertRowIndexToModel()) + " ";

        if (evt.getClickCount() == 2) {
            onRowDobleClick(evt);
        }

        if (evt.getClickCount() == 1) {
            onRowClick(evt);
        }

    }//GEN-LAST:event_JTAlumnosMouseClicked

    private void onRowDobleClick(MouseEvent evt) {
        ventanaPrincipal.setIsEditingAlumno(true);
        ventanaPrincipal.mostrarPanelAlumnoDetalle();
    }

    private void onRowClick(MouseEvent evt) {

        int rowIndex = JTAlumnos.getSelectedRow();
        Alumno selectedAlumno = alumnos.get(rowIndex);

        ventanaPrincipal.setSelectedAlumno(selectedAlumno);

        txtBuscar.setText(selectedAlumno.getNombre());

    }

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        eliminarAlumno();

    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        searchByName();
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String seachhWord = this.txtBuscar.getText().trim();

        System.out.println(evt.getKeyCode() == KeyEvent.VK_ENTER);
        if (seachhWord.isEmpty()) {
            try {
                getAlumnos();
                refreshTable();
            } catch (Exception e) {
                ventanaPrincipal.setGeneralError(e.getMessage());
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            searchByName();
        }

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyTyped

    }//GEN-LAST:event_btnBuscarKeyTyped

    private void searchByName() {
        String seachhWord = this.txtBuscar.getText().trim();

        try {
            if (seachhWord.isEmpty()) {
                alumnos = xmlManager.listarAlumnos();
            } else {
                alumnos = xmlManager.searchByName(seachhWord);
            }

        } catch (Exception e) {
            ventanaPrincipal.setGeneralError(e.getMessage());
        }
        refreshTable();
    }

    private void eliminarAlumno() {
        try {
            if (ventanaPrincipal.getSelectedAlumno() == null) {
                throw new Exception("Debe seleccionar un alumno");
            }
            xmlManager.deleteAlumno(ventanaPrincipal.getSelectedAlumno().getId());
            getAlumnos();
            refreshTable();
            this.txtBuscar.setText("");
            ventanaPrincipal.setSelectedAlumno(null);
        } catch (Exception e) {
            ventanaPrincipal.setGeneralError(e.getMessage());
        }
    }

    public void getAlumnos() {

        alumnos = xmlManager.listarAlumnos();

        if (alumnos.size() == 0) {
            ventanaPrincipal.setGeneralError("No hay alumnos para mostrar");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTAlumnos;
    private javax.swing.JButton btbCrear;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
