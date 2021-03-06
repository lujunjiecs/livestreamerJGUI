package livestreamerJGUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AddFavoriteDialog extends javax.swing.JFrame {

    /**
     * Creates new form AddFavoriteDialog
     */
    private AddFavoriteDialog() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ListPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listUIElement = new javax.swing.JList();
        tfNewUrl = new javax.swing.JTextField();
        ButtonPanel = new javax.swing.JPanel();
        bAdd = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        bOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Edit Favorites");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        ListPanel.setLayout(new javax.swing.BoxLayout(ListPanel, javax.swing.BoxLayout.PAGE_AXIS));

        listUIElement.setModel(this.getModel());
        jScrollPane1.setViewportView(listUIElement);

        ListPanel.add(jScrollPane1);

        tfNewUrl.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfNewUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNewUrlActionPerformed(evt);
            }
        });
        ListPanel.add(tfNewUrl);

        getContentPane().add(ListPanel);

        bAdd.setText("Add");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });
        ButtonPanel.add(bAdd);

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });
        ButtonPanel.add(bDelete);

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });
        ButtonPanel.add(bCancel);

        bOk.setText("OK");
        bOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkActionPerformed(evt);
            }
        });
        ButtonPanel.add(bOk);

        getContentPane().add(ButtonPanel);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkActionPerformed
        try {
            FileWriter writer = new FileWriter("favorites.txt");
            for (Object str : ((DefaultListModel<String>) listUIElement.getModel()).toArray()) {
                writer.write((String) str + "\n");
            }
            writer.close();
        } catch (IOException e) {
        }
        this.dispose();
        LivestreamerJGUI.getInstance().setEnabled(true);
        LivestreamerJGUI.getInstance().toFront();
        LivestreamerJGUI.getInstance().setEditDialogButtonEnabled(true);
        LivestreamerJGUI.getInstance().refreshFavoriteList();

    }//GEN-LAST:event_bOkActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
        LivestreamerJGUI.getInstance().setEnabled(true);
        LivestreamerJGUI.getInstance().toFront();
        LivestreamerJGUI.getInstance().setEditDialogButtonEnabled(true);
    }//GEN-LAST:event_bCancelActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        List<String> toDelete = new ArrayList<>();
        for (int i : listUIElement.getSelectedIndices()) {
            toDelete.add((String) listUIElement.getModel().getElementAt(i));
        }

        for (String s : toDelete) {
            ((DefaultListModel) listUIElement.getModel()).removeElement(s);
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        String newFavorite = tfNewUrl.getText();
        if (!newFavorite.equals("")) {
            ((DefaultListModel) listUIElement.getModel()).addElement(newFavorite);
        }
        tfNewUrl.setText("");
    }//GEN-LAST:event_bAddActionPerformed

    private void tfNewUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNewUrlActionPerformed
        this.bAddActionPerformed(evt);
    }//GEN-LAST:event_tfNewUrlActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFavoriteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                }
                final AddFavoriteDialog afd = new AddFavoriteDialog();
                afd.setVisible(true);
                afd.pack();
                afd.setLocationRelativeTo(LivestreamerJGUI.getInstance());
                LivestreamerJGUI.getInstance().setEnabled(false);
                try {
                    BufferedReader br = new BufferedReader(new FileReader("favorites.txt"));
                    while (br.ready()) {
                        afd.getModel().addElement(br.readLine());
                    }
                    br.close();
                } catch (IOException e) {
                }
                afd.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        afd.bCancelActionPerformed(null);
                    }
                });
            }
        });
    }
    private final DefaultListModel<String> model = new DefaultListModel<>();

    public DefaultListModel<String> getModel() {
        return model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JPanel ListPanel;
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bOk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listUIElement;
    private javax.swing.JTextField tfNewUrl;
    // End of variables declaration//GEN-END:variables
}
