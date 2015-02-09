/*
 * JChartViewerInternalFrame.java
 *
 * Created on 23-May-2011, 14:15:27
 */
package canreg.client.gui.analysis;

import com.itextpdf.text.DocumentException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.jdesktop.application.Action;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author ErvikM
 */
public class JChartViewerInternalFrame extends javax.swing.JInternalFrame {

    private ChartPanel chartPanel;
    private JFreeChart chart;

    /** Creates new form JChartViewerInternalFrame */
    public JChartViewerInternalFrame() {
        initComponents();
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
        // remove old chart
        jPanel1.removeAll();
        // change the title
        this.setTitle(chart.getTitle().getText());

        // create new panel and add it
        chartPanel = new ChartPanel(chart);
        chartPanel.getPopupMenu().add(saveAsSVGAvtion, 4);
        chartPanel.getPopupMenu().add(saveAsPDFAvtion, 5);
        chartPanel.getPopupMenu().add(copyDataToClipboardAvtion, 6);
        jPanel1.add(chartPanel);

        chartPanel.setVisible(true);
        jPanel1.doLayout();

        jPanel1.validate();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        saveAsSVGAvtion = new javax.swing.JMenuItem();
        saveAsPDFAvtion = new javax.swing.JMenuItem();
        copyDataToClipboardAvtion = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(JChartViewerInternalFrame.class, this);
        saveAsSVGAvtion.setAction(actionMap.get("saveAsSVGAction")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(JChartViewerInternalFrame.class);
        saveAsSVGAvtion.setText(resourceMap.getString("saveAsSVGAvtion.text")); // NOI18N
        saveAsSVGAvtion.setName("saveAsSVGAvtion"); // NOI18N
        jPopupMenu1.add(saveAsSVGAvtion);

        saveAsPDFAvtion.setAction(actionMap.get("saveAsPDFAction")); // NOI18N
        saveAsPDFAvtion.setText(resourceMap.getString("saveAsPDFAvtion.text")); // NOI18N
        saveAsPDFAvtion.setName("saveAsPDFAvtion"); // NOI18N
        jPopupMenu1.add(saveAsPDFAvtion);

        copyDataToClipboardAvtion.setAction(actionMap.get("copyDataToClipboardAction")); // NOI18N
        copyDataToClipboardAvtion.setName("copyDataToClipboardAvtion"); // NOI18N
        jPopupMenu1.add(copyDataToClipboardAvtion);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setName("chartHolderPanel"); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copyDataToClipboardAvtion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem saveAsPDFAvtion;
    private javax.swing.JMenuItem saveAsSVGAvtion;
    // End of variables declaration//GEN-END:variables

    @Action
    public void saveAsSVGAction() {
        if (chart != null) {
            JFileChooser chooser = new JFileChooser();
            FileFilter filter = new FileFilter() {

                @Override
                public boolean accept(File f) {
                    return f.isDirectory() || f.getName().toLowerCase().endsWith("svg"); //NOI18N
                }

                @Override
                public String getDescription() {
                    return java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/PDSEditorInternalFrame").getString("SVG GRAPHICS FILES");
                }
            };
            chooser.setFileFilter(filter);
            int result = chooser.showDialog(this, java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/PDSEditorInternalFrame").getString("CHOOSE FILENAME"));
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = chooser.getSelectedFile();
                    if (!file.getName().toLowerCase().endsWith("svg")) { //NOI18N
                        file = new File(file.getAbsolutePath() + ".svg"); //NOI18N
                    }
                    canreg.client.analysis.Tools.exportChartAsSVG(chart, new Rectangle(chartPanel.getWidth(), chartPanel.getHeight()), file);
                } catch (IOException ex) {
                    Logger.getLogger(JChartViewerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Action
    public void saveAsPDFAction() {
        if (chart != null) {
            JFileChooser chooser = new JFileChooser();
            FileFilter filter = new FileFilter() {

                @Override
                public boolean accept(File f) {
                    return f.isDirectory() || f.getName().toLowerCase().endsWith("pdf"); //NOI18N
                }

                @Override
                public String getDescription() {
                    return java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/PDSEditorInternalFrame").getString("PORTABLE DOCUMENT FORMAT (PDF) FILES");
                }
            };
            chooser.setFileFilter(filter);
            int result = chooser.showDialog(this, java.util.ResourceBundle.getBundle("canreg/client/gui/dataentry/resources/PDSEditorInternalFrame").getString("CHOOSE FILENAME"));
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = chooser.getSelectedFile();
                    if (!file.getName().toLowerCase().endsWith("pdf")) { //NOI18N
                        file = new File(file.getAbsolutePath() + ".pdf"); //NOI18N
                    }
                    canreg.client.analysis.Tools.exportChartAsPDF(chart, new Rectangle(chartPanel.getWidth(), chartPanel.getHeight()), file);
                } catch (IOException ex) {
                    Logger.getLogger(JChartViewerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(JChartViewerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Action
    public void copyDataToClipboardAction() {
        String data = canreg.client.analysis.Tools.getChartData(chart, "\t", false);
        StringSelection stsel = new StringSelection(data);
        Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
        system.setContents(stsel, stsel);
    }
}
