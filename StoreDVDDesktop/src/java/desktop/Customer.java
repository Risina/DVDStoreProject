/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.StoreCustomerFacadeLocal;
import services.StoreDVDCopyFacadeLocal;
import services.StoreDvdFacadeLocal;
import services.StoreEmployeeFacadeLocal;
import util.StoreDVDCopyUtil;
import util.StoreDVDUtil;

/**
 *
 * @author Risina
 */
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    StoreDvdFacadeLocal storeDVDFacade;
    StoreCustomerFacadeLocal storeCustomerFacadeLocal;
    StoreDVDCopyFacadeLocal storedvdcopyfacade;
    Long customerId;
    
    public Customer() {
        initComponents();
    }
    
    public Customer(StoreDvdFacadeLocal storeDVDFacade, 
            StoreCustomerFacadeLocal storeCustomerFacadeLocal, 
            StoreDVDCopyFacadeLocal storedvdcopyfacade, 
            Long customerId){
        
        initComponents();
        this.storeDVDFacade = storeDVDFacade;
        this.storeCustomerFacadeLocal = storeCustomerFacadeLocal;
        this.storedvdcopyfacade = storedvdcopyfacade;
        this.customerId = customerId;
        
        updateTable(storeDVDFacade.getDVDs());
        updateCombobox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dvdTable = new javax.swing.JTable();
        searchCombobox = new javax.swing.JComboBox();
        searchButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        copySearchButton = new javax.swing.JButton();
        dvdIdTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dvdCopyTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        dvdTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(dvdTable);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(resetButton)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        copySearchButton.setText("Search for copies");
        copySearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copySearchButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("DVD ID");

        dvdCopyTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(dvdCopyTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(dvdIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copySearchButton)
                        .addGap(352, 352, 352))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dvdIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copySearchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        updateTable(storeDVDFacade.getDVDs());
    }//GEN-LAST:event_resetButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        int index = searchCombobox.getSelectedIndex();
        String searchString = searchTextField.getText();

        List<StoreDVDUtil> list = null;

        switch(index) {
            case 0:
            list = storeDVDFacade.getDVDsByTitle(searchString);
            break;
            case 1:
            list = storeDVDFacade.getDVDsByYear(searchString);
            break;
            case 2:
            list = storeDVDFacade.getDVDsByRating(searchString);
            break;
            case 3:
            list = storeDVDFacade.getDVDsByFormat(searchString);
            break;
            default:
            break;
        }

        updateTable(list);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void copySearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copySearchButtonActionPerformed

        updateCopyTable(storedvdcopyfacade.getCopiedByDVDId(Long.parseLong(dvdIdTextField.getText())));
    }//GEN-LAST:event_copySearchButtonActionPerformed

    private void updateTable(List<StoreDVDUtil> dvds) {
                
        DefaultTableModel model = new DefaultTableModel();
        dvdTable.setModel(model);
        
        String[] columnNames = {"Id",
        "Title",
        "Year",
        "Actors",
        "Rating", 
        "format",
        };

        model.setColumnIdentifiers(columnNames);
        
        for(StoreDVDUtil dvd: dvds) {
            String[] s = new String[6];
            s[0] = Long.toString(dvd.getId());
            s[1] = dvd.getTitle();
            s[2] = dvd.getReleasedYear();
            s[3] = dvd.getActors();
            s[4] = dvd.getRating();
            s[5] = dvd.getFormat();
            model.addRow(s);
        }
        
    }
    
    public void updateCopyTable(List<StoreDVDCopyUtil> dvds) {
        DefaultTableModel model = new DefaultTableModel();
        dvdCopyTable.setModel(model);
        
        String[] columnNames = {"Copy ID",
        "DVD ID",
        "DVD Title",
        "Shelf No",
        "Isle No",
        };

        model.setColumnIdentifiers(columnNames);
        
        for(StoreDVDCopyUtil dvd: dvds) {
            String[] s = new String[6];
            s[0] = Long.toString(dvd.getId());
            s[1] = Long.toString(dvd.getDvdId().getId());
            s[2] = dvd.getDvdId().getTitle();
            s[3] = Integer.toString(dvd.getShelf());
            s[4] = Integer.toString(dvd.getIsle());
            model.addRow(s);
        }
    }
    
    private void updateCombobox() {
        searchCombobox.addItem("Title");
        searchCombobox.addItem("Year");
        searchCombobox.addItem("Rating");
        searchCombobox.addItem("Format");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton copySearchButton;
    private javax.swing.JTable dvdCopyTable;
    private javax.swing.JTextField dvdIdTextField;
    private javax.swing.JTable dvdTable;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox searchCombobox;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
