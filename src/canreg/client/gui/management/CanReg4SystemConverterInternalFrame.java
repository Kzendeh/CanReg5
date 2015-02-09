/**
 * CanReg5 - a tool to input, store, check and analyse cancer registry data.
 * Copyright (C) 2008-2015  International Agency for Research on Cancer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @author Morten Johannes Ervik, CSU/IARC, ervikm@iarc.fr
 */

/*
 * CanReg4SystemConverterInternalFrame.java
 *
 * Created on 01 July 2008, 13:56
 */
package canreg.client.gui.management;

import canreg.client.CanRegClientApp;
import canreg.client.LocalSettings;
import canreg.client.gui.CanRegClientView;
import canreg.common.Globals;
import canreg.server.management.SystemDefinitionConverter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import org.jdesktop.application.Action;
import org.xml.sax.SAXException;

/**
 *
 * @author  ervikm
 */
public class CanReg4SystemConverterInternalFrame extends javax.swing.JInternalFrame {

    private JFileChooser chooser;
    private JDesktopPane dtp;
    private String DEF_FILE_EXTENSION = "DEF";

    /** Creates new form CanReg4SystemConverterInternalFrame */
    public CanReg4SystemConverterInternalFrame() {
        initComponents();

        File file = new File(Globals.CANREG4_SYSTEM_FOLDER);

        if (!file.exists()) {
            chooser = new JFileChooser();
        } else {
            chooser = new JFileChooser(Globals.CANREG4_SYSTEM_FOLDER);
        }
        // Filter only the DEF-files.
        FileNameExtensionFilter filter = new FileNameExtensionFilter(java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/CanReg4SystemConverterInternalFrame").getString("CANREG4 SYSTEM DEFINITION FILE"), DEF_FILE_EXTENSION);
        chooser.addChoosableFileFilter(filter);

        // get the available charsets
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        charsetsComboBox.setModel(new javax.swing.DefaultComboBoxModel(charsets.values().toArray()));
        // set the default mapping
        charsetsComboBox.setSelectedItem(Charset.forName(Globals.CHARSET_ENGLISH));
        // initializeVariableMappingTab();
    }

    public void setDesktopPane(JDesktopPane dtp) {
        this.dtp = dtp;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileNameTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        convertButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codeField = new javax.swing.JTextField();
        charsetsComboBox = new javax.swing.JComboBox();
        fileEncodingLabel = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(CanReg4SystemConverterInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N

        fileNameTextField.setText(resourceMap.getString("fileNameTextField.text")); // NOI18N
        fileNameTextField.setName("fileNameTextField"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(CanReg4SystemConverterInternalFrame.class, this);
        browseButton.setAction(actionMap.get("browseAction")); // NOI18N
        browseButton.setText(resourceMap.getString("browseButton.text")); // NOI18N
        browseButton.setName("browseButton"); // NOI18N

        convertButton.setAction(actionMap.get("convertAction")); // NOI18N
        convertButton.setText(resourceMap.getString("convertButton.text")); // NOI18N
        convertButton.setName("convertButton"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jButton1.setAction(actionMap.get("cancelAction")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        nameTextField.setEditable(false);
        nameTextField.setName("nameTextField"); // NOI18N

        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        codeField.setEditable(false);
        codeField.setText(resourceMap.getString("codeField.text")); // NOI18N
        codeField.setName("codeField"); // NOI18N

        charsetsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        charsetsComboBox.setName("charsetsComboBox"); // NOI18N

        fileEncodingLabel.setText(resourceMap.getString("fileEncodingLabel.text")); // NOI18N
        fileEncodingLabel.setName("fileEncodingLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(fileEncodingLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fileNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                    .addComponent(charsetsComboBox, 0, 213, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(convertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(browseButton)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileEncodingLabel)
                    .addComponent(charsetsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(convertButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(jLabel2)
                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     */
    @Action
    public void browseAction() {
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                //set the file name
                fileNameTextField.setText(chooser.getSelectedFile().getCanonicalPath());
                // changeFile();
            } catch (IOException ex) {
                Logger.getLogger(CanReg4SystemConverterInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * 
     */
    @Action
    public void cancelAction() {
        this.dispose();
    }

    /**
     * 
     */
    @Action
    public void convertAction() {
        SystemDefinitionConverter sdc = new SystemDefinitionConverter();
        try {
            sdc.setNameField(nameTextField);
            sdc.setCodeField(codeField);
            sdc.setFileEncoding((Charset) charsetsComboBox.getSelectedItem());
            sdc.convertAndSaveInSystemFolder(fileNameTextField.getText());

            int addServer = JOptionPane.showInternalConfirmDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/CanReg4SystemConverterInternalFrame").getString("SUCCESSFULLY_CREATED_XML: ") + "\'"
                    + Globals.CANREG_SERVER_SYSTEM_CONFIG_FOLDER + Globals.FILE_SEPARATOR
                    + codeField.getText() + "\'.\n"
                    + java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/CanReg4SystemConverterInternalFrame").getString("ADD_IT_TO_FAV_SERVERS?"), "Success", JOptionPane.YES_NO_OPTION);

            if (addServer == JOptionPane.YES_OPTION) {
                LocalSettings localSettings = CanRegClientApp.getApplication().getLocalSettings();
                localSettings.addServerToServerList(nameTextField.getText(), "localhost", Globals.DEFAULT_PORT, codeField.getText());
                // JOptionPane.showInternalMessageDialog(this, "Please restart CanReg5 after reviewing the database variables.");
                localSettings.writeSettings();
            }

            EditDatabaseVariableTableAssociationInternalFrame edvif = new EditDatabaseVariableTableAssociationInternalFrame();
            try {
                edvif.loadSystemDefinition(Globals.CANREG_SERVER_SYSTEM_CONFIG_FOLDER + Globals.FILE_SEPARATOR + codeField.getText() + ".xml");
                edvif.setDesktopPane(dtp);
                CanRegClientView.showAndPositionInternalFrame(dtp, edvif);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(CanReg4SystemConverterInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(CanReg4SystemConverterInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CanReg4SystemConverterInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.dispose();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CanReg4SystemConverterInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/management/resources/CanReg4SystemConverterInternalFrame").getString("COULD_NOT_OPEN_FILE:_") + "\'" + fileNameTextField.getText().trim() + "\'.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JComboBox charsetsComboBox;
    private javax.swing.JTextField codeField;
    private javax.swing.JButton convertButton;
    private javax.swing.JLabel fileEncodingLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    // End of variables declaration//GEN-END:variables
}
