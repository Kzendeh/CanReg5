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
 * EditDictionaryInternalFrame.java
 *
 * Created on 29 February 2008, 14:06
 */
package canreg.client.gui.dataentry;

import canreg.client.CanRegClientApp;
import canreg.client.LocalSettings;
import canreg.client.gui.CanRegClientView;
import canreg.client.gui.tools.globalpopup.MyPopUpMenu;
import canreg.common.DatabaseDictionaryListElement;
import canreg.common.Globals;
import canreg.common.database.Dictionary;
import canreg.common.database.DictionaryEntry;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
import org.w3c.dom.Document;

/**
 *
 * @author  morten
 */
public class EditDictionaryInternalFrame extends javax.swing.JInternalFrame {

    private DatabaseDictionaryListElement[] dictionariesInDB;
    private Document doc;
    private JDesktopPane desktopPane;
    private JFileChooser chooser;
    private LocalSettings localSettings;
    private String path;

    /** Creates new form EditDictionaryInternalFrame
     * @param dtp 
     */
    public EditDictionaryInternalFrame(JDesktopPane dtp) {
        this.desktopPane = dtp;
        localSettings = CanRegClientApp.getApplication().getLocalSettings();
        path = localSettings.getProperty("dictionary_import_path");

        if (path == null) {
            chooser = new JFileChooser();
        } else {
            chooser = new JFileChooser(path);
        }
        initComponents();
        initValues();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        allFieldsPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        oneFieldPanel = new javax.swing.JPanel();
        displayEditLabel = new javax.swing.JLabel();
        chooseDictionaryComboBox = new javax.swing.JComboBox();
        displayScrollPane = new javax.swing.JScrollPane();
        editorTextArea = new javax.swing.JTextArea();
        updateButton = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(EditDictionaryInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        allFieldsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("allFieldsPanel.border.title"))); // NOI18N
        allFieldsPanel.setName("allFieldsPanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(EditDictionaryInternalFrame.class, this);
        jButton1.setAction(actionMap.get("exportCompleteDictionaryAction")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jButton2.setAction(actionMap.get("importCompleteDictionaryAction")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        javax.swing.GroupLayout allFieldsPanelLayout = new javax.swing.GroupLayout(allFieldsPanel);
        allFieldsPanel.setLayout(allFieldsPanelLayout);
        allFieldsPanelLayout.setHorizontalGroup(
            allFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allFieldsPanelLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
        );
        allFieldsPanelLayout.setVerticalGroup(
            allFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allFieldsPanelLayout.createSequentialGroup()
                .addGroup(allFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        oneFieldPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("oneFieldPanel.border.title"))); // NOI18N
        oneFieldPanel.setName("oneFieldPanel"); // NOI18N

        displayEditLabel.setText(resourceMap.getString("displayEditLabel.text")); // NOI18N
        displayEditLabel.setName("displayEditLabel"); // NOI18N

        chooseDictionaryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RecordStatus", "Sex", "PersonSearch" }));
        chooseDictionaryComboBox.setAction(actionMap.get("refreshSelectedDictionaryAction")); // NOI18N
        chooseDictionaryComboBox.setName("chooseDictionaryComboBox"); // NOI18N

        displayScrollPane.setName("displayScrollPane"); // NOI18N

        editorTextArea.setColumns(20);
        editorTextArea.setRows(5);
        editorTextArea.setName("editorTextArea"); // NOI18N
        editorTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editorTextAreaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editorTextAreaMouseReleased(evt);
            }
        });
        displayScrollPane.setViewportView(editorTextArea);

        updateButton.setAction(actionMap.get("updateDictionaryAction")); // NOI18N
        updateButton.setText(resourceMap.getString("updateButton.text")); // NOI18N
        updateButton.setName("updateButton"); // NOI18N

        messageLabel.setText(resourceMap.getString("messageLabel.text")); // NOI18N
        messageLabel.setName("messageLabel"); // NOI18N

        javax.swing.GroupLayout oneFieldPanelLayout = new javax.swing.GroupLayout(oneFieldPanel);
        oneFieldPanel.setLayout(oneFieldPanelLayout);
        oneFieldPanelLayout.setHorizontalGroup(
            oneFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oneFieldPanelLayout.createSequentialGroup()
                .addComponent(displayEditLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooseDictionaryComboBox, 0, 444, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oneFieldPanelLayout.createSequentialGroup()
                .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateButton))
            .addComponent(displayScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );
        oneFieldPanelLayout.setVerticalGroup(
            oneFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oneFieldPanelLayout.createSequentialGroup()
                .addGroup(oneFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayEditLabel)
                    .addComponent(chooseDictionaryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(oneFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(messageLabel)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(oneFieldPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(allFieldsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(allFieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oneFieldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editorTextAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editorTextAreaMousePressed
        MyPopUpMenu.potentiallyShowPopUpMenuTextComponent(editorTextArea, evt);
    }//GEN-LAST:event_editorTextAreaMousePressed

    private void editorTextAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editorTextAreaMouseReleased
         MyPopUpMenu.potentiallyShowPopUpMenuTextComponent(editorTextArea, evt);
    }//GEN-LAST:event_editorTextAreaMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allFieldsPanel;
    private javax.swing.JComboBox chooseDictionaryComboBox;
    private javax.swing.JLabel displayEditLabel;
    private javax.swing.JScrollPane displayScrollPane;
    private javax.swing.JTextArea editorTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JPanel oneFieldPanel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void initValues() {
        doc = CanRegClientApp.getApplication().getDatabseDescription();
        // variablesInDB = canreg.common.Tools.getVariableListElements(doc, Globals.NAMESPACE);
        dictionariesInDB = canreg.common.Tools.getDictionaryListElements(doc, Globals.NAMESPACE);
        chooseDictionaryComboBox.setModel(new javax.swing.DefaultComboBoxModel(dictionariesInDB));
        chooseDictionaryComboBox.setSelectedIndex(0);
    }

    /**
     * 
     */
    @Action
    public void exportCompleteDictionaryAction() {
        int returnVal = chooser.showSaveDialog(this);
        String fileName = null;
        BufferedWriter bw;
        int selectedDbdle = chooseDictionaryComboBox.getSelectedIndex();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                //set the file name
                fileName = chooser.getSelectedFile().getCanonicalPath();
                File file = new File(fileName);
                if (file.exists()) {
                    int choice = JOptionPane.showInternalConfirmDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("FILE_EXISTS")+": " + fileName + ".\n "+java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("OVERWRITE?"), java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("FILE_EXISTS")+".", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (choice == JOptionPane.CANCEL_OPTION) {
                        return;
                    } else if (choice == JOptionPane.NO_OPTION) {
                        // choose a new file
                        exportCompleteDictionaryAction();
                        return;
                    }
                }

                localSettings.setProperty("dictionary_import_path", file.getParent());
                localSettings.writeSettings();

                bw = new BufferedWriter(new FileWriter(file));

                for (DatabaseDictionaryListElement dbdle : dictionariesInDB) {
                    bw.write("#" + dbdle.getDictionaryID() + "\t----" + dbdle.getName() + Globals.newline);
                    // chooseDictionaryComboBox.setSelectedItem(dbdle);
                    // refreshSelectedDictionaryAction();
                    Dictionary dic = CanRegClientApp.getApplication().getDictionary().get(dbdle.getDictionaryID());
                    if (dic != null) {
                        // Map sortedMap = new TreeMap(map);
                        Map<String, DictionaryEntry> map = dic.getDictionaryEntries();
                        Iterator<Entry<String, DictionaryEntry>> iterator = map.entrySet().iterator();
                        while (iterator.hasNext()) {
                            DictionaryEntry entry = iterator.next().getValue();
                            bw.write(entry.getCode() + "\t" + entry.getDescription() + Globals.newline);
                        }
                    }
                    bw.write(Globals.newline);
                }
                bw.flush();
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(ImportView.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("SUCCESSFULLY_WROTE_DICTIONARIES")+": " + fileName, java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("DICTIONARIES_SUCCESSFULLY_WRITTEN"), JOptionPane.INFORMATION_MESSAGE);
            }
        }
        chooseDictionaryComboBox.setSelectedIndex(selectedDbdle);
    }

    /**
     * 
     */
    @Action
    public void importCompleteDictionaryAction() {
        JInternalFrame importFrame = new ImportCompleteDictionaryInternalFrame();
        CanRegClientView.showAndPositionInternalFrame(desktopPane, importFrame);
        this.dispose();
    }

    /**
     * 
     */
    @Action
    public void selectDictionaryAction() {
        //TODO select dictionary action
    }

    /**
     * 
     * @return
     */
    @Action
    public Task updateDictionaryAction() {
        return new UpdateDictionaryActionTask(org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class));
    }

    private class UpdateDictionaryActionTask extends org.jdesktop.application.Task<Object, Void> {

        String dictionaryString;
        DatabaseDictionaryListElement dbdle;
        boolean testOK = false;
        private Map<Integer, String> errors;

        UpdateDictionaryActionTask(org.jdesktop.application.Application app) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to UpdateDictionaryActionTask fields, here.
            super(app);
            // first check to see if we have anything at all here
            dictionaryString = editorTextArea.getText().trim();
            dbdle = (DatabaseDictionaryListElement) chooseDictionaryComboBox.getSelectedItem();
            errors = canreg.client.dataentry.DictionaryHelper.testDictionary(dbdle, dictionaryString);
            if (errors.isEmpty()) {
                testOK = true;
            } else {
                testOK = false;
                String errorString = new String();
                Iterator<Integer> iterator = errors.keySet().iterator();
                int errorLines = 0;
                while (iterator.hasNext() && errorLines<Globals.MAX_ERROR_LINES) {
                    Integer line = iterator.next();
                    errorString += errors.get(line) + "\n";
                    errorLines++;
                }
                if (iterator.hasNext()){
                    errorString += "...and more.";
                }
                JOptionPane.showInternalMessageDialog(rootPane, errorString, java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        protected Object doInBackground() {
            // Your Task's code here.  This method runs
            // on a background thread, so don't reference
            // the Swing GUI from here.

            if (testOK && dictionaryString.trim().length() > 0) {
                int dictionaryID = dbdle.getDictionaryID();
                try {
                    canreg.client.dataentry.DictionaryHelper.replaceDictionary(dictionaryID, dictionaryString, CanRegClientApp.getApplication());
                } catch (RemoteException ex) {
                    Logger.getLogger(EditDictionaryInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                return "Error.";
            }
            return null;  // return your result
        }

        @Override
        protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
            if (result == null) {
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Successfully updated dictionary: " + dbdle.getName() + ".", "Dictionary successfully updated.", JOptionPane.INFORMATION_MESSAGE);
                try {
                    CanRegClientApp.getApplication().refreshDictionary();
                } catch (SecurityException ex) {
                    Logger.getLogger(EditDictionaryInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(EditDictionaryInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            dictionaryString = null;
            dbdle = null;
        }
    }

    /**
     * 
     */
    @Action
    public void refreshSelectedDictionaryAction() {
        DatabaseDictionaryListElement dbdle = (DatabaseDictionaryListElement) chooseDictionaryComboBox.getSelectedItem();
        Dictionary dic = CanRegClientApp.getApplication().getDictionary().get(dbdle.getDictionaryID());
        StringBuilder b = new StringBuilder();
        if (dic != null) {
            // Map sortedMap = new TreeMap(map);
            Map<String, DictionaryEntry> map = dic.getDictionaryEntries();
            Iterator<Entry<String, DictionaryEntry>> iterator = map.entrySet().iterator();
            int numberOfLinesShown = 0;

            while (iterator.hasNext() && numberOfLinesShown < Globals.MAX_DICTIONARY_DISPLAY_SIZE) {
                DictionaryEntry entry = iterator.next().getValue();
                b.append(entry.getCode()).append("\t").append(entry.getDescription()).append("\n");
                numberOfLinesShown++;
            }
            if (map.size() > Globals.MAX_DICTIONARY_DISPLAY_SIZE) {
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("THE_DICTIONARY_") + dbdle.getName() + java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("_IS_TOO_LARGE.")+"\n" + java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("ONLY_THE_FIRST_") + Globals.MAX_DICTIONARY_DISPLAY_SIZE + java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("_ENTRIES_ARE_DISPLAYED_HERE.")+"\n"+java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("TO_EDIT_THIS..."), java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/EditDictionaryInternalFrame").getString("DICTIONARY_TOO_LARGE_FOR_DISPLAY"), JOptionPane.WARNING_MESSAGE);
                editorTextArea.setEditable(false);
                messageLabel.setVisible(true);
                updateButton.setEnabled(false);
            } else if (dbdle.isLocked()) {
                updateButton.setEnabled(false);
                editorTextArea.setEditable(false);
                messageLabel.setVisible(true);
            } else {
                updateButton.setEnabled(true);
                editorTextArea.setEditable(true);
                messageLabel.setVisible(false);
            }
        }
        editorTextArea.setText(b.toString());
        editorTextArea.setCaretPosition(0);
    }
}