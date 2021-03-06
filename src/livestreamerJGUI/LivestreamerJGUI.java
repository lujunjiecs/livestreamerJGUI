package livestreamerJGUI;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LivestreamerJGUI extends javax.swing.JFrame {
    private static LivestreamerJGUI instance;
    private static final String DEFAULT_QUALITY_SETTING = "defaultQuality";
    
    public static LivestreamerJGUI getInstance() {
        return instance;
    }

    private LivestreamerJGUI() {
        initComponents();
        String defaultQuality = PreferenceHandler.getInstance().get(DEFAULT_QUALITY_SETTING);
        if(defaultQuality != null) {
            this.tfQuality.setText(defaultQuality);
            this.dropQuality.setSelectedItem(Quality.valueOf(defaultQuality));
        } else {
            this.tfQuality.setText(((DefaultComboBoxModel<Quality>)this.dropQuality.getModel()).getElementAt(this.dropQuality.getSelectedIndex()).toString());
        }
        SwingUtilities.getRootPane(this).setDefaultButton(bGo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fd = new javax.swing.JFileChooser();
        selectGroup = new javax.swing.ButtonGroup();
        bFile = new javax.swing.JButton();
        labelFile = new javax.swing.JLabel();
        rbRecord = new javax.swing.JRadioButton();
        rbWatch = new javax.swing.JRadioButton();
        bGo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taOutput = new javax.swing.JTextArea();
        labelOutput = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        labelStreamUrl = new javax.swing.JLabel();
        bStop = new javax.swing.JButton();
        tfStreamUrl = new javax.swing.JTextField();
        tfQuality = new javax.swing.JTextField();
        labelQuality = new javax.swing.JLabel();
        tfFile = new javax.swing.JTextField();
        dropFavorites = new javax.swing.JComboBox<String>();
        cbFavorites = new javax.swing.JCheckBox();
        bOpenEditFavDialog = new javax.swing.JButton();
        bBrowseTwitch = new javax.swing.JButton();
        dropQuality = new javax.swing.JComboBox();

        bSetSelectedQualityAsDefault = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("livestreamerJGUI" +BuildInfo.version);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/icon.png")));
        setMinimumSize(new java.awt.Dimension(626, 481));
        setResizable(false);

        bFile.setText("File");
        bFile.setEnabled(false);
        bFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFileActionPerformed(evt);
            }
        });

        labelFile.setText("File name:");
        labelFile.setEnabled(false);

        selectGroup.add(rbRecord);
        rbRecord.setText("Record to file");
        rbRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRecordActionPerformed(evt);
            }
        });

        selectGroup.add(rbWatch);
        rbWatch.setSelected(true);
        rbWatch.setText("Watch stream in player (Default: VLC)");
        rbWatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbWatchActionPerformed(evt);
            }
        });

        bGo.setText("GO!");
        bGo.setMaximumSize(new java.awt.Dimension(70, 35));
        bGo.setMinimumSize(new java.awt.Dimension(70, 35));
        bGo.setPreferredSize(new java.awt.Dimension(55, 23));
        bGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGoActionPerformed(evt);
            }
        });

        taOutput.setEditable(false);
        taOutput.setColumns(20);
        taOutput.setLineWrap(true);
        taOutput.setRows(5);
        taOutput.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taOutput);

        labelOutput.setText("Output:");

        labelStreamUrl.setText("Stream URL:");

        bStop.setText("Stop");
        bStop.setEnabled(false);
        bStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStopActionPerformed(evt);
            }
        });

        tfQuality.setToolTipText("Leave empty and ceck output if you are unsure about available bitrates.");

        labelQuality.setText("Quality:");

        tfFile.setEditable(false);
        tfFile.setEnabled(false);

        dropFavorites.setEnabled(false);

        cbFavorites.setText("Favorites:");
        cbFavorites.setToolTipText("");
        cbFavorites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFavoritesActionPerformed(evt);
            }
        });

        bOpenEditFavDialog.setText("Edit Favorites");
        bOpenEditFavDialog.setEnabled(false);
        bOpenEditFavDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOpenEditFavDialogActionPerformed(evt);
            }
        });

        bBrowseTwitch.setText("Browse Twitch");
        bBrowseTwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBrowseTwitchActionPerformed(evt);
            }
        });

        dropQuality.setMaximumRowCount(16);
        dropQuality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DefaultComboBoxModel<Quality> aModel = new DefaultComboBoxModel();
        for(Quality q : Quality.values()) {
            aModel.addElement(q);
        }
        dropQuality.setModel(aModel);
        dropQuality.setSelectedItem(Quality.best);
        dropQuality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropQualityActionPerformed(evt);
            }
        });

        bSetSelectedQualityAsDefault.setText("Set quality as default");
        bSetSelectedQualityAsDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSetSelectedQualityAsDefaultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFile)
                                    .addComponent(tfFile, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labelOutput)
                            .addComponent(rbRecord)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelStreamUrl)
                                            .addComponent(cbFavorites, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(dropFavorites, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bOpenEditFavDialog))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfStreamUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bBrowseTwitch)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelQuality))
                                    .addComponent(rbWatch))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfQuality)
                                    .addComponent(dropQuality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bSetSelectedQualityAsDefault, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bGo, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(bStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSetSelectedQualityAsDefault, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbWatch)
                        .addComponent(bGo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dropFavorites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFavorites)
                            .addComponent(bOpenEditFavDialog)
                            .addComponent(dropQuality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelStreamUrl)
                            .addComponent(tfStreamUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQuality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelQuality)
                            .addComponent(bBrowseTwitch))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bStop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbRecord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bFile)
                    .addComponent(tfFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelOutput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    ArrayList<String> favoritesList = new ArrayList<String>();
    
    private void toggleRec(){
        if (rbWatch.isEnabled()){
            rbWatch.setEnabled(false);
            rbRecord.setEnabled(false);
            if (!cbFavorites.isSelected())
                tfStreamUrl.setEnabled(false);
            else {
                dropFavorites.setEnabled(false);
                bOpenEditFavDialog.setEnabled(false);
            }
            tfQuality.setEnabled(false);
            bFile.setEnabled(false);
            tfFile.setEnabled(false);
            cbFavorites.setEnabled(false);
            bBrowseTwitch.setEnabled(false);
            bSetSelectedQualityAsDefault.setEnabled(false);
            dropQuality.setEnabled(false);
        }
        else{
            rbWatch.setEnabled(true);
            rbRecord.setEnabled(true);
            if (!cbFavorites.isSelected())
                tfStreamUrl.setEnabled(true);
            else {
                dropFavorites.setEnabled(true);
                bOpenEditFavDialog.setEnabled(true);
            }
            tfQuality.setEnabled(true);
            bFile.setEnabled(true);
            tfFile.setEnabled(true);
            cbFavorites.setEnabled(true);
            bBrowseTwitch.setEnabled(true);
            bSetSelectedQualityAsDefault.setEnabled(true);
            dropQuality.setEnabled(true);
        } 
    }
    private void toggleWatch(){
        if (rbRecord.isEnabled()){
            rbWatch.setEnabled(false);
            rbRecord.setEnabled(false);
            if (!cbFavorites.isSelected())
                tfStreamUrl.setEnabled(false);
            else {
                dropFavorites.setEnabled(false);
                bOpenEditFavDialog.setEnabled(false);
            }
            tfQuality.setEnabled(false);
            bFile.setEnabled(false);
            tfFile.setEnabled(false);
            cbFavorites.setEnabled(false);
            bBrowseTwitch.setEnabled(false);
            bSetSelectedQualityAsDefault.setEnabled(false);
            dropQuality.setEnabled(false);
        }
        else{
            rbWatch.setEnabled(true);
            rbRecord.setEnabled(true);
            if (!cbFavorites.isSelected())
                tfStreamUrl.setEnabled(true);
            else {
                dropFavorites.setEnabled(true);
                bOpenEditFavDialog.setEnabled(true);
            }
            tfQuality.setEnabled(true);
            cbFavorites.setEnabled(true);
            bBrowseTwitch.setEnabled(true);
            bSetSelectedQualityAsDefault.setEnabled(true);
            dropQuality.setEnabled(true);
        } 
    }
    
    private String addFileExtIfNecessary(String file,String ext) {
        if(file.lastIndexOf('.') == -1) {
            file = ext;
            return file;
        }
        return "";
    }
    private boolean filterCheck = false;
    private String fileName = "no";
    private void bFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFileActionPerformed
        if (!filterCheck) {
        FileFilter ft = new FileNameExtensionFilter("Transport Streams (*.ts)", "ts");
        fd.setAcceptAllFileFilterUsed(false);
        fd.addChoosableFileFilter( ft );
        filterCheck = true;
        }
        int returnVal = fd.showOpenDialog( this );
        String fileExt = ".ts";
        
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            String extCheck = fd.getSelectedFile().getPath() + addFileExtIfNecessary(fd.getSelectedFile().getName(),fileExt);
            tfFile.setText(extCheck);
            fileName = tfFile.getText();
        }
    }//GEN-LAST:event_bFileActionPerformed

    private void rbRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRecordActionPerformed
        bFile.setEnabled(true);
        tfFile.setEnabled(true);
        tfFile.setEnabled(true);
        labelFile.setEnabled(true);
    }//GEN-LAST:event_rbRecordActionPerformed

    private void rbWatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbWatchActionPerformed
        fileName = "no";
        tfFile.setText("");
        bFile.setEnabled(false);
        tfFile.setEnabled(false);
        labelFile.setEnabled(false);
    }//GEN-LAST:event_rbWatchActionPerformed
    
LivestreamerExe le = new LivestreamerExe();

    private void bGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGoActionPerformed
        bGo.setEnabled(false);
        taOutput.setText("");
        if (rbWatch.isSelected()) {
            if (cbFavorites.isSelected()) {
                String[] cl = { "livestreamer", dropFavorites.getSelectedItem().toString(), tfQuality.getText()};
                le.runLivestreamer(cl, taOutput);
            }
            else {
                String[] cl = { "livestreamer", tfStreamUrl.getText(), tfQuality.getText()};
                le.runLivestreamer(cl, taOutput);
            }
            bStop.setEnabled(true);
            toggleWatch();
            new Thread() {
                public void run() {
                    try{
                        le.getProc().waitFor();
                    }
                    catch (Exception err){
                    }
                    bGo.setEnabled(true);
                    bStop.setEnabled(false);
                    toggleWatch();
                }
            }.start();
            le.nullProc();
        }
        if (rbRecord.isSelected() && !"no".equals(fileName)) {
            if (cbFavorites.isSelected()) {
                String[] cl = { "livestreamer", dropFavorites.getSelectedItem().toString(), tfQuality.getText(), "-o", fileName};
                le.runLivestreamer(cl, taOutput);
            }
            else {
                String[] cl = { "livestreamer", tfStreamUrl.getText(), tfQuality.getText(), "-o", fileName};
                le.runLivestreamer(cl, taOutput);
            }
            bStop.setEnabled(true);
            toggleRec();
            new Thread() {
                public void run() {
                    try{
                        le.getProc().waitFor();
                    }
                    catch (Exception err){
                    }
                    bGo.setEnabled(true);
                    bStop.setEnabled(false);
                    toggleRec();
                }
            }.start();
            le.nullProc();
        }
        if (rbRecord.isSelected() && "no".equals(fileName)) {
            JOptionPane.showMessageDialog(this,"Please choose a filename");
            bGo.setEnabled(true);
            bStop.setEnabled(false);
        }
    }//GEN-LAST:event_bGoActionPerformed

    public JTextArea getTaOutput() {
        return taOutput;
    }

    private void bStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStopActionPerformed
        le.killLivestreamer();
        bGo.setEnabled(true);
        bStop.setEnabled(false);
    }//GEN-LAST:event_bStopActionPerformed

    private void cbFavoritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFavoritesActionPerformed
        favoritesList.clear();
        dropFavorites.removeAllItems();
        if (dropFavorites.isEnabled()) {
            dropFavorites.setEnabled(false);
            tfStreamUrl.setEnabled(true);
            bOpenEditFavDialog.setEnabled(false);
            setBrowseTwitchButtonEnabled(true);
        }
        else {
            refreshFavoriteList();
            dropFavorites.setEnabled(true);
            bOpenEditFavDialog.setEnabled(true);
            tfStreamUrl.setEnabled(false);
            setBrowseTwitchButtonEnabled(false);
        }

    }//GEN-LAST:event_cbFavoritesActionPerformed

    private void bOpenEditFavDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOpenEditFavDialogActionPerformed
        AddFavoriteDialog.main(null);
        this.setEditDialogButtonEnabled(false);
    }//GEN-LAST:event_bOpenEditFavDialogActionPerformed

    private void bBrowseTwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBrowseTwitchActionPerformed
        TwitchPicker.main(null);
        this.setBrowseTwitchButtonEnabled(false);
    }//GEN-LAST:event_bBrowseTwitchActionPerformed

    private void dropQualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropQualityActionPerformed
        Quality q = ((DefaultComboBoxModel<Quality>)dropQuality.getModel()).getElementAt(dropQuality.getSelectedIndex());
        this.tfQuality.setText(q.toString());
    }//GEN-LAST:event_dropQualityActionPerformed

    private void bSetSelectedQualityAsDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSetSelectedQualityAsDefaultActionPerformed
        PreferenceHandler.getInstance().set(DEFAULT_QUALITY_SETTING, dropQuality.getSelectedItem().toString());
    }//GEN-LAST:event_bSetSelectedQualityAsDefaultActionPerformed

    public void setEditDialogButtonEnabled(boolean b) {
        bOpenEditFavDialog.setEnabled(b);
    }
    
    public void setBrowseTwitchButtonEnabled(boolean b) {
        bBrowseTwitch.setEnabled(b);
    }
    
    public void refreshFavoriteList() {
        favoritesList.clear();
        dropFavorites.removeAllItems();
        try {
            BufferedReader br = new BufferedReader(new FileReader("favorites.txt"));
            while (br.ready()) {
                favoritesList.add(br.readLine());
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LivestreamerJGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LivestreamerJGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int x = 0; x < favoritesList.size(); x++) {
            dropFavorites.insertItemAt(favoritesList.get(x), x);
        }
    }
    
    public void setURLFieldText(String url) {
        this.tfStreamUrl.setText(url);
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } 
                catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                }
                instance = new LivestreamerJGUI();
                instance.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBrowseTwitch;
    private javax.swing.JButton bFile;
    private javax.swing.JButton bGo;
    private javax.swing.JButton bOpenEditFavDialog;
    private javax.swing.JButton bSetSelectedQualityAsDefault;
    private javax.swing.JButton bStop;
    private javax.swing.JCheckBox cbFavorites;
    private javax.swing.JComboBox<String> dropFavorites;
    private javax.swing.JComboBox dropQuality;
    private javax.swing.JFileChooser fd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelFile;
    private javax.swing.JLabel labelOutput;
    private javax.swing.JLabel labelQuality;
    private javax.swing.JLabel labelStreamUrl;
    private javax.swing.JRadioButton rbRecord;
    private javax.swing.JRadioButton rbWatch;
    private javax.swing.ButtonGroup selectGroup;
    private javax.swing.JTextArea taOutput;
    private javax.swing.JTextField tfFile;
    private javax.swing.JTextField tfQuality;
    private javax.swing.JTextField tfStreamUrl;
    // End of variables declaration//GEN-END:variables
}
