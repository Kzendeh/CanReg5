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
 * DatabaseDictionaryEditorPanel.java
 *
 * Created on 26-Jan-2010, 10:44:53
 */
package canreg.client.gui.management.systemeditor;

import canreg.common.DatabaseDictionaryListElement;
import canreg.common.Globals;
import canreg.common.TranslatableListElement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 *
 * @author ervikm
 */
public class DatabaseDictionaryEditorPanel extends javax.swing.JPanel {

    private DatabaseDictionaryListElement databaseDictionaryListElement;

    /** Creates new form DatabaseDictionaryEditorPanel */
    public DatabaseDictionaryEditorPanel() {
        initComponents();
        fontComboBox.setModel(new DefaultComboBoxModel(
                new TranslatableListElement[]{
                    new TranslatableListElement(Globals.FONT_LATIN, "Latin"),
                    new TranslatableListElement(Globals.FONT_ASIAN, "Asian")
                }));
        typeComboBox.setModel(new DefaultComboBoxModel(
                new TranslatableListElement[]{
                    new TranslatableListElement(Globals.DICTIONARY_TYPE_SIMPLE, "Simple"),
                    new TranslatableListElement(Globals.DICTIONARY_TYPE_COMPOUND, "Compound")
                }));
    }

    public void setDatabaseDictionaryListElement(DatabaseDictionaryListElement databaseDictionaryListElement) {
        this.databaseDictionaryListElement = databaseDictionaryListElement;
        nameTextField.setText(databaseDictionaryListElement.getName());
        fullCodeLengthTextField.setText(databaseDictionaryListElement.getFullDictionaryCodeLength() + "");
        codeLengthTextField.setText(databaseDictionaryListElement.getCodeLength() + "");
        String type = databaseDictionaryListElement.getType();
        typeComboBox.setSelectedItem(new TranslatableListElement(type, type));
        String font = databaseDictionaryListElement.getFont();
        typeComboBox.setSelectedItem(new TranslatableListElement(font, font));
        lockedCheckBox.setSelected(databaseDictionaryListElement.isLocked());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameTextField = new javax.swing.JTextField();
        fontComboBox = new javax.swing.JComboBox();
        nameLabel = new javax.swing.JLabel();
        fontLabel = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        typeLabel = new javax.swing.JLabel();
        fullCodeLengthTextField = new javax.swing.JTextField();
        codeLengthTextField = new javax.swing.JTextField();
        fullCodeLengthLabel = new javax.swing.JLabel();
        codeLengthLabel = new javax.swing.JLabel();
        lockedCheckBox = new javax.swing.JCheckBox();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(DatabaseDictionaryEditorPanel.class);
        nameTextField.setText(resourceMap.getString("nameTextField.text")); // NOI18N
        nameTextField.setName("nameTextField"); // NOI18N

        fontComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fontComboBox.setEnabled(false);
        fontComboBox.setName("fontComboBox"); // NOI18N

        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N

        fontLabel.setText(resourceMap.getString("fontLabel.text")); // NOI18N
        fontLabel.setEnabled(false);
        fontLabel.setName("fontLabel"); // NOI18N

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(DatabaseDictionaryEditorPanel.class, this);
        typeComboBox.setAction(actionMap.get("dictionaryTypeChanged")); // NOI18N
        typeComboBox.setName("typeComboBox"); // NOI18N

        typeLabel.setText(resourceMap.getString("typeLabel.text")); // NOI18N
        typeLabel.setName("typeLabel"); // NOI18N

        fullCodeLengthTextField.setBackground(resourceMap.getColor("fullCodeLengthTextField.background")); // NOI18N
        fullCodeLengthTextField.setText(resourceMap.getString("fullCodeLengthTextField.text")); // NOI18N
        fullCodeLengthTextField.setName("fullCodeLengthTextField"); // NOI18N
        fullCodeLengthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullCodeLengthTextFieldActionPerformed(evt);
            }
        });
        fullCodeLengthTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fullCodeLengthTextFieldFocusLost(evt);
            }
        });

        codeLengthTextField.setText(resourceMap.getString("codeLengthTextField.text")); // NOI18N
        codeLengthTextField.setEnabled(false);
        codeLengthTextField.setName("codeLengthTextField"); // NOI18N
        codeLengthTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codeLengthTextFieldFocusLost(evt);
            }
        });

        fullCodeLengthLabel.setText(resourceMap.getString("fullCodeLengthLabel.text")); // NOI18N
        fullCodeLengthLabel.setName("fullCodeLengthLabel"); // NOI18N

        codeLengthLabel.setText(resourceMap.getString("codeLengthLabel.text")); // NOI18N
        codeLengthLabel.setEnabled(false);
        codeLengthLabel.setName("codeLengthLabel"); // NOI18N

        lockedCheckBox.setText(resourceMap.getString("lockedCheckBox.text")); // NOI18N
        lockedCheckBox.setName("lockedCheckBox"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameLabel)
                    .addComponent(fontLabel)
                    .addComponent(typeLabel)
                    .addComponent(fullCodeLengthLabel)
                    .addComponent(codeLengthLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lockedCheckBox)
                    .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(fontComboBox, 0, 130, Short.MAX_VALUE)
                    .addComponent(typeComboBox, 0, 130, Short.MAX_VALUE)
                    .addComponent(fullCodeLengthTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(codeLengthTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fontComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fontLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullCodeLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fullCodeLengthLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeLengthLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lockedCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fullCodeLengthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullCodeLengthTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullCodeLengthTextFieldActionPerformed

    private void fullCodeLengthTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fullCodeLengthTextFieldFocusLost
        try {
            Integer.parseInt(fullCodeLengthTextField.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showInternalMessageDialog(this, nfe);
        }
    }//GEN-LAST:event_fullCodeLengthTextFieldFocusLost

    private void codeLengthTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codeLengthTextFieldFocusLost
        try {
            int length = Integer.parseInt(codeLengthTextField.getText());
            int fullLength = Integer.parseInt(fullCodeLengthTextField.getText());
            if (length >= fullLength || length <= 0) {
                JOptionPane.showInternalMessageDialog(this,
                        java.util.ResourceBundle.getBundle("canreg/client/gui/management/systemeditor/resources/DatabaseDictionaryEditorPanel").getString("CODE_LENGTH_SHOULD_BE_LESS..."));
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showInternalMessageDialog(this, nfe);
        }
    }//GEN-LAST:event_codeLengthTextFieldFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codeLengthLabel;
    private javax.swing.JTextField codeLengthTextField;
    private javax.swing.JComboBox fontComboBox;
    private javax.swing.JLabel fontLabel;
    private javax.swing.JLabel fullCodeLengthLabel;
    private javax.swing.JTextField fullCodeLengthTextField;
    private javax.swing.JCheckBox lockedCheckBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

    public void refreshDatabaseDictionaryListElement() {
        databaseDictionaryListElement.setName(nameTextField.getText());

        TranslatableListElement tleFont = (TranslatableListElement) fontComboBox.getSelectedItem();
        databaseDictionaryListElement.setFont(tleFont.getOriginalName());

        TranslatableListElement tleType = (TranslatableListElement) typeComboBox.getSelectedItem();
        databaseDictionaryListElement.setType(tleType.getOriginalName());

        try {
            databaseDictionaryListElement.setFullDictionaryCodeLength(Integer.parseInt(fullCodeLengthTextField.getText()));
            databaseDictionaryListElement.setCodeLength(Integer.parseInt(codeLengthTextField.getText()));
        } catch (NumberFormatException nfe) {
            throw nfe;
        }

        databaseDictionaryListElement.setLocked(lockedCheckBox.isSelected());

        // set some defaults
        databaseDictionaryListElement.setCategoryDescriptionLength(Globals.DICTIONARY_DESCRIPTION_LENGTH);
        databaseDictionaryListElement.setFullDictionaryCategoryDescriptionLength(Globals.DICTIONARY_DESCRIPTION_LENGTH);

    }

    @Action
    public void dictionaryTypeChanged() {
        if (typeComboBox.getSelectedItem().equals(new TranslatableListElement(Globals.DICTIONARY_TYPE_COMPOUND, Globals.DICTIONARY_TYPE_COMPOUND))) {
            codeLengthLabel.setEnabled(true);
            codeLengthTextField.setEnabled(true);
            codeLengthTextField.setEditable(true);
        } else {
            codeLengthLabel.setEnabled(false);
            codeLengthTextField.setEnabled(false);
            codeLengthTextField.setEditable(false);
        }
    }
}
