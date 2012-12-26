/**
 * CanReg5 - a tool to input, store, check and analyse cancer registry data.
 * Copyright (C) 2008-2011  International Agency for Research on Cancer
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
 * @author Morten Johannes Ervik, CIN/IARC, ervikm@iarc.fr
 */
package canreg.client.gui;

import canreg.client.gui.tools.globalpopup.MyPopUpMenu;
import canreg.common.Globals;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import org.jdesktop.application.Action;

public class CanRegClientAboutBox extends javax.swing.JDialog implements HyperlinkListener {

    private Properties appInfoProperties;

    /**
     * 
     * @param parent
     */
    public CanRegClientAboutBox(java.awt.Frame parent) {
        super(parent);
        InputStream in = null;
        appInfoProperties = new Properties();
        try {

            //
            // load properties file
            //
            //
            // get Application information
            //
            in = getClass().getResourceAsStream(Globals.APPINFO_PROPERTIES_PATH);
            appInfoProperties.load(in);
            in.close();
            initComponents();
            getRootPane().setDefaultButton(closeButton);
            aboutEditorPane.addHyperlinkListener(this);
        } catch (IOException ex) {
            Logger.getLogger(CanRegClientAboutBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     */
    @Action
    public void closeAboutBox() {
        setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - unknown
    private void initComponents() {
        ResourceBundle bundle = ResourceBundle.getBundle("canreg.client.gui.resources.CanRegClientAboutBox");
        closeButton = new JButton();
        JLabel appTitleLabel = new JLabel();
        aboutScrollPane = new JScrollPane();
        aboutEditorPane = new JEditorPane();
        JLabel versionLabel = new JLabel();
        JLabel appVersionLabel = new JLabel();
        JLabel vendorLabel = new JLabel();
        JLabel appVendorLabel = new JLabel();
        JLabel homepageLabel = new JLabel();
        JLabel appHomepageLabel = new JLabel();
        JLabel appDescLabel = new JLabel();
        JLabel imageLabel = new JLabel();

        //======== this ========
        setDefaultCloseOperation(2);
        setAlwaysOnTop(true);
        setModal(true);
        setName("aboutBox");
        Container contentPane = getContentPane();

        //---- closeButton ----
        closeButton.setName("closeButton");

        //---- appTitleLabel ----
        appTitleLabel.setText(bundle.getString("Application.title"));
        appTitleLabel.setName("appTitleLabel");

        //======== aboutScrollPane ========
        {
            aboutScrollPane.setName("aboutScrollPane");

            //---- aboutEditorPane ----
            aboutEditorPane.setContentType(bundle.getString("aboutEditorPane.contentType"));
            aboutEditorPane.setEditable(false);
            aboutEditorPane.setText(bundle.getString("aboutEditorPane.text"));
            aboutEditorPane.setName("aboutEditorPane");
            aboutEditorPane.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    aboutEditorPaneMousePressed(e);
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    aboutEditorPaneMouseReleased(e);
                }
            });
            aboutScrollPane.setViewportView(aboutEditorPane);
        }

        //---- versionLabel ----
        versionLabel.setText(bundle.getString("versionLabel.text"));
        versionLabel.setName("versionLabel");

        //---- appVersionLabel ----
        appVersionLabel.setText(bundle.getString("Application.version"));
        appVersionLabel.setName("appVersionLabel");

        //---- vendorLabel ----
        vendorLabel.setText(bundle.getString("vendorLabel.text"));
        vendorLabel.setName("vendorLabel");

        //---- appVendorLabel ----
        appVendorLabel.setText(bundle.getString("Application.vendor"));
        appVendorLabel.setName("appVendorLabel");

        //---- homepageLabel ----
        homepageLabel.setText(bundle.getString("homepageLabel.text"));
        homepageLabel.setName("homepageLabel");

        //---- appHomepageLabel ----
        appHomepageLabel.setText(bundle.getString("Application.homepage"));
        appHomepageLabel.setName("appHomepageLabel");
        appHomepageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homepageLabelMouseClick(e);
            }
        });

        //---- appDescLabel ----
        appDescLabel.setText(bundle.getString("appDescLabel.text"));
        appDescLabel.setName("appDescLabel");

        //---- imageLabel ----
        imageLabel.setIcon(new ImageIcon(getClass().getResource("about.png")));
        imageLabel.setName("imageLabel");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(imageLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(209, 209, 209)
                            .addComponent(closeButton))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(versionLabel)
                                .addComponent(vendorLabel)
                                .addComponent(homepageLabel))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(appVersionLabel)
                                .addComponent(appVendorLabel)
                                .addComponent(appHomepageLabel)))
                        .addComponent(appTitleLabel)
                        .addComponent(appDescLabel, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                        .addComponent(aboutScrollPane, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(appTitleLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(appDescLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(versionLabel)
                                .addComponent(appVersionLabel))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(vendorLabel)
                                .addComponent(appVendorLabel))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(homepageLabel)
                                .addComponent(appHomepageLabel))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(aboutScrollPane, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(closeButton))
                        .addComponent(imageLabel, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

private void homepageLabelMouseClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepageLabelMouseClick
    try {
        canreg.common.Tools.browse(java.util.ResourceBundle.getBundle("canreg/client/gui/resources/CanRegClientAboutBox").getString("http://canreg.iarc.fr/"));
    } catch (IOException ex) {
        Logger.getLogger(CanRegClientAboutBox.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_homepageLabelMouseClick

private void aboutEditorPaneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutEditorPaneMouseReleased
    MyPopUpMenu.potentiallyShowPopUpMenuTextComponent(aboutEditorPane, evt);
}//GEN-LAST:event_aboutEditorPaneMouseReleased

private void aboutEditorPaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutEditorPaneMousePressed
    MyPopUpMenu.potentiallyShowPopUpMenuTextComponent(aboutEditorPane, evt);
}//GEN-LAST:event_aboutEditorPaneMousePressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton closeButton;
    private JScrollPane aboutScrollPane;
    private JEditorPane aboutEditorPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void hyperlinkUpdate(HyperlinkEvent event) {
        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                canreg.common.Tools.browse(event.getURL().toString());
            } catch (IOException ex) {
                Logger.getLogger(CanRegClientAboutBox.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
