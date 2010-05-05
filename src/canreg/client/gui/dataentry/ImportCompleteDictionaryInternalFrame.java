/*
 * ImportCompleteDictionaryInternalFrame.java
 *
 * Created on 26 September 2008, 14:46
 */
package canreg.client.gui.dataentry;

import canreg.client.CanRegClientApp;
import canreg.client.LocalSettings;
import canreg.common.GlobalToolBox;
import canreg.common.Globals;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author  ervikm
 */
public class ImportCompleteDictionaryInternalFrame extends javax.swing.JInternalFrame {

    private LocalSettings localSettings;
    private String path;
    private JFileChooser chooser;
    private GlobalToolBox globalToolBox;

    /** Creates new form ImportCompleteDictionaryInternalFrame */
    public ImportCompleteDictionaryInternalFrame() {
        initComponents();
        localSettings = CanRegClientApp.getApplication().getLocalSettings();
        globalToolBox = CanRegClientApp.getApplication().getGlobalToolBox();
        path = localSettings.getProperty("dictionary_import_path");

        if (path == null) {
            chooser = new JFileChooser();
        } else {
            chooser = new JFileChooser(path);
        }

        // get the available charsets
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        charsetsComboBox.setModel(new javax.swing.DefaultComboBoxModel(charsets.values().toArray()));
        // set the default mapping
        charsetsComboBox.setSelectedItem(Charset.defaultCharset());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseFilePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fileNameTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        previewPanel = new javax.swing.JPanel();
        previewScrollPane = new javax.swing.JScrollPane();
        previewTextArea = new javax.swing.JTextArea();
        previewButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cr4dictionaryCheckBox = new javax.swing.JCheckBox();
        importButton = new javax.swing.JButton();
        charsetsComboBox = new javax.swing.JComboBox();
        fileEncodingLabel = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(ImportCompleteDictionaryInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N

        chooseFilePanel.setName("chooseFilePanel"); // NOI18N

        jLabel1.setName("jLabel1"); // NOI18N

        fileNameTextField.setName("fileNameTextField"); // NOI18N
        fileNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fileNameTextFieldFocusLost(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(ImportCompleteDictionaryInternalFrame.class, this);
        browseButton.setAction(actionMap.get("browseAction")); // NOI18N
        browseButton.setName("browseButton"); // NOI18N
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        previewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Preview"));
        previewPanel.setEnabled(false);
        previewPanel.setName("previewPanel"); // NOI18N

        previewScrollPane.setFocusable(false);
        previewScrollPane.setName("previewScrollPane"); // NOI18N

        previewTextArea.setColumns(20);
        previewTextArea.setEditable(false);
        previewTextArea.setRows(5);
        previewTextArea.setName("previewTextArea"); // NOI18N
        previewScrollPane.setViewportView(previewTextArea);

        javax.swing.GroupLayout previewPanelLayout = new javax.swing.GroupLayout(previewPanel);
        previewPanel.setLayout(previewPanelLayout);
        previewPanelLayout.setHorizontalGroup(
            previewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(previewScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        previewPanelLayout.setVerticalGroup(
            previewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(previewScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
        );

        previewButton.setAction(actionMap.get("previewAction")); // NOI18N
        previewButton.setName("previewButton"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        cr4dictionaryCheckBox.setAction(actionMap.get("canreg4FormatTicked")); // NOI18N
        cr4dictionaryCheckBox.setText(resourceMap.getString("cr4dictionaryCheckBox.text")); // NOI18N
        cr4dictionaryCheckBox.setToolTipText(resourceMap.getString("cr4dictionaryCheckBox.toolTipText")); // NOI18N
        cr4dictionaryCheckBox.setName("cr4dictionaryCheckBox"); // NOI18N

        importButton.setAction(actionMap.get("importAction")); // NOI18N
        importButton.setName("importButton"); // NOI18N

        charsetsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        charsetsComboBox.setName("charsetsComboBox"); // NOI18N

        fileEncodingLabel.setText(resourceMap.getString("fileEncodingLabel.text")); // NOI18N
        fileEncodingLabel.setName("fileEncodingLabel"); // NOI18N

        javax.swing.GroupLayout chooseFilePanelLayout = new javax.swing.GroupLayout(chooseFilePanel);
        chooseFilePanel.setLayout(chooseFilePanelLayout);
        chooseFilePanelLayout.setHorizontalGroup(
            chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chooseFilePanelLayout.createSequentialGroup()
                        .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chooseFilePanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fileNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(browseButton))
                            .addGroup(chooseFilePanelLayout.createSequentialGroup()
                                .addComponent(fileEncodingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(charsetsComboBox, 0, 196, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cr4dictionaryCheckBox)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(importButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(previewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        chooseFilePanelLayout.setVerticalGroup(
            chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton)
                    .addComponent(previewButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(charsetsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileEncodingLabel)
                    .addComponent(importButton)
                    .addComponent(cr4dictionaryCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chooseFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chooseFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void fileNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fileNameTextFieldFocusLost
// changeFile();
}//GEN-LAST:event_fileNameTextFieldFocusLost

private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_browseButtonActionPerformed

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
            } catch (IOException ex) {
                Logger.getLogger(ImportView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * 
     */
    @Action
    public void previewAction() {
        // show the contents of the file
        BufferedReader br = null;
        try {
            FileInputStream fis = new FileInputStream(fileNameTextField.getText().trim());
            InputStreamReader isr = new InputStreamReader(fis, (Charset) charsetsComboBox.getSelectedItem());
            br = new BufferedReader(isr);
            int i = 0;
            String text = new String();
            String line = br.readLine();

            while (line != null && i < Globals.NUMBER_OF_LINES_IN_IMPORT_PREVIEW) {
                text += line + "\n";
                line = br.readLine();
                i++;
            }
            previewTextArea.setText(text);
            previewTextArea.setCaretPosition(0);
            previewPanel.setVisible(true);
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/ImportCompleteDictionaryInternalFrame").getString("COULD_NOT_PREVIEW_THE_FILE:_")+"\'" + fileNameTextField.getText().trim() + "\'.", java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/ImportCompleteDictionaryInternalFrame").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ImportView.class.getName()).log(Level.SEVERE, null, fileNotFoundException);
        } catch (IOException ex) {
            Logger.getLogger(ImportView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ImportView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * 
     * @return
     */
    @Action
    public Task importAction() {
        // this.dispose();
        return new ImportActionTask(org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class));
    }

    private class ImportActionTask extends org.jdesktop.application.Task<Object, Void> {

        boolean cr4dictionary;
        String fileName;

        ImportActionTask(org.jdesktop.application.Application app) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to ImportActionTask fields, here.
            super(app);
            browseButton.setEnabled(false);
            importButton.setEnabled(false);
            previewButton.setEnabled(false);
            cr4dictionary = cr4dictionaryCheckBox.isSelected();
            fileName = fileNameTextField.getText().trim();
            Cursor hourglassCursor = new Cursor(Cursor.WAIT_CURSOR);
            setCursor(hourglassCursor);
        }

        @Override
        protected Object doInBackground() {
            // Your Task's code here.  This method runs
            // on a background thread, so don't reference
            // the Swing GUI from here.
            BufferedReader br = null;
            Map<Integer, Map<Integer, String>> allErrors = new TreeMap<Integer, Map<Integer, String>>();
            try {
                FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader isr = new InputStreamReader(fis, (Charset) charsetsComboBox.getSelectedItem());
                br = new BufferedReader(isr);
                String dictionaryString = new String();
                String line = br.readLine();
                int dictionaryID = -1;
                while (line != null) {

                    while (line != null && line.trim().length() == 0) {
                        // skip empty lines
                        line = br.readLine();
                    }
                    if (line == null) {
                        JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/ImportCompleteDictionaryInternalFrame").getString("FILE_IS_NOT_CORRECT_FORMAT:_")+"\'" + fileNameTextField.getText().trim() + "\'.", java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/ImportCompleteDictionaryInternalFrame").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
                        return ("Error");
                    }
                    // first line contains the dictionary id
                    // remove leading #
                    if (line.startsWith("#")) {
                        line = line.substring(1);
                    }

                    line = line.replace(' ', '\t');
                    String[] lineElements = line.split("\t");
                    dictionaryID = Integer.parseInt(lineElements[0]);
                    if (cr4dictionary) {
                        dictionaryID--;
                    }

                    // read next line;
                    line = br.readLine();

                    // read untill blank line
                    while (line != null && line.trim().length() > 0) {
                        if (cr4dictionary) {
                            line = line.replaceFirst("  ", "\t ");
                        }
                        dictionaryString += line + "\n";
                        line = br.readLine();
                    }

                    if (dictionaryString.trim().length() > 0) {
                        try {
                            Map<Integer, String> errors = canreg.client.dataentry.DictionaryHelper.testDictionary(null, dictionaryString);
                            if (errors.size() > 0) {
                                allErrors.put(dictionaryID, errors);
                                Logger.getLogger(EditDictionaryInternalFrame.class.getName()).log(Level.WARNING, errors.size() + " errors in dictionary: " + dictionaryID, new Exception());
                            } else {
                                canreg.client.dataentry.DictionaryHelper.replaceDictionary(dictionaryID, dictionaryString, CanRegClientApp.getApplication());
                            }
                            dictionaryString = new String();
                        } catch (RemoteException ex) {
                            Logger.getLogger(EditDictionaryInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    // Read next line 
                    line = br.readLine();
                    // Skip trailing blank lines
                    while (line != null && line.trim().length() == 0) {
                        line = br.readLine();
                    }
                }

                CanRegClientApp.getApplication().refreshDictionary();

            } catch (FileNotFoundException fileNotFoundException) {
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Could not preview file: \'" + fileNameTextField.getText().trim() + "\'.", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ImportView.class.getName()).log(Level.WARNING, null, fileNotFoundException);
            } catch (IOException ex) {
                Logger.getLogger(ImportView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException nfe) {
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Something wrong with the dictionary: \'" + fileNameTextField.getText().trim() + "\'.", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ImportView.class.getName()).log(Level.WARNING, null, nfe);
            } finally {
                try {
                    br.close();

                } catch (IOException ex) {
                    Logger.getLogger(ImportView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return allErrors;  // return your result
        }

        @Override
        protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
            Map<Integer, Map<Integer, String>> allErrors = (Map<Integer, Map<Integer, String>>) result;
            File file = new File(fileName);
            localSettings.setProperty("dictionary_import_path", file.getParent());
            localSettings.writeSettings();
            Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
            setCursor(normalCursor);
            if (allErrors.size() == 0) {
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/ImportCompleteDictionaryInternalFrame").getString("SUCCESSFULLY_IMPORTED_DICTIONARIES_FROM_FILE."), java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/ImportCompleteDictionaryInternalFrame").getString("DICTIONARY_SUCCESSFULLY_IMPORTED"), JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), allErrors.size() + java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/ImportCompleteDictionaryInternalFrame").getString("_DICTIONARIES_WERE_NOT_IMPORTED..."), java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/ImportCompleteDictionaryInternalFrame").getString("DICTIONARY_NOT_SUCCESSFULLY_IMPORTED."), JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Action
    public void canreg4FormatTicked() {
        if (cr4dictionaryCheckBox.isSelected()) {
            charsetsComboBox.setSelectedItem(globalToolBox.getStandardCharset());
        } else {
            charsetsComboBox.setSelectedItem(Charset.defaultCharset());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JComboBox charsetsComboBox;
    private javax.swing.JPanel chooseFilePanel;
    private javax.swing.JCheckBox cr4dictionaryCheckBox;
    private javax.swing.JLabel fileEncodingLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton previewButton;
    private javax.swing.JPanel previewPanel;
    private javax.swing.JScrollPane previewScrollPane;
    private javax.swing.JTextArea previewTextArea;
    // End of variables declaration//GEN-END:variables
}
