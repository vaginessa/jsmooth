
/*
  JSmooth: a VM wrapper toolkit for Windows
  Copyright (C) 2003 Rodrigo Reyes <reyes@charabia.net>

  This program is free software; you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation; either version 2 of the License, or
  (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.

*/

package net.charabia.jsmoothgen.application.gui;

import net.charabia.jsmoothgen.*;
import net.charabia.jsmoothgen.application.gui.util.*;
import net.charabia.jsmoothgen.application.*;
import java.util.*;
import javax.swing.*;

public class JVMSelectionPanel extends javax.swing.JPanel implements ModelUpdater
{
	private JSmoothModelBean m_model;
	private JFileChooser m_bundlefilechooser = new JFileChooser();
	/** Creates new form BeanForm */
	public JVMSelectionPanel()
	{
		initComponents();
                m_bundlefilechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	}

	public void updateModel()
	{
		m_model.setMinimumVersion(m_minimumVersion.getVersion());
		m_model.setMaximumVersion(m_maximumVersion.getVersion());
		System.out.println("min: " + m_model.getMinimumVersion() + " / max: " + m_model.getMaximumVersion());
		String[] ids = new String[m_vmSearch.dataSize()];
		Object[] data = m_vmSearch.getData();
		for (int i=0; i<ids.length; i++)
		{
			ids[i] = ((JVMSearchElement)data[i]).getId();
		}
		m_model.setJVMSearchPath(ids);
		if (m_cbBundled.isSelected())
		{
			if (m_chooserBundled.getFile() != null)
				m_model.setBundledJVMPath(m_chooserBundled.getFile().toString());
		} else
		{
			m_model.setBundledJVMPath(null);
		}
	}

	public void setModel(java.io.File basedir, JSmoothModelBean model)
	{
	    m_model = model;
		m_minimumVersion.setVersion(m_model.getMinimumVersion());
		m_maximumVersion.setVersion(m_model.getMaximumVersion());
		if (m_model.getJVMSearchPath() == null)
		{
			m_vmSearch.setData(JVMSearchElement.Elements);
		} else
		{
			Vector v = new Vector();
			String[] els = m_model.getJVMSearchPath();
			for (int i=0; i<els.length; i++)
			{
				JVMSearchElement el = JVMSearchElement.getStandardElement(els[i]);
				if (el != null)
					v.add(el);
			}
			m_vmSearch.setData(v.toArray());
		}
                
                m_bundlefilechooser.setCurrentDirectory(basedir);
                
		if (m_model.getBundledJVMPath() == null) 
		{
			m_cbBundled.setSelected(false);
			m_chooserBundled.setEnabled(false);
                        m_chooserBundled.setFile(null);
		} else
		{
			m_cbBundled.setSelected(true);
			m_chooserBundled.setEnabled(true);
			if (basedir != null)
				m_chooserBundled.setBaseDir(basedir);
			m_chooserBundled.setFile(new java.io.File(m_model.getBundledJVMPath()));
                        System.out.println("set selected file: " + m_model.getBundledJVMPath());
                        m_bundlefilechooser.setSelectedFile(new java.io.File(m_model.getBundledJVMPath()));
		}
	}


	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    private void initComponents()//GEN-BEGIN:initComponents
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        m_minimumVersion = new net.charabia.jsmoothgen.application.gui.util.VersionEditor();
        jLabel2 = new javax.swing.JLabel();
        m_maximumVersion = new net.charabia.jsmoothgen.application.gui.util.VersionEditor();
        jPanel3 = new javax.swing.JPanel();
        m_cbBundled = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        m_chooserBundled = new net.charabia.jsmoothgen.application.gui.util.FileSelectionTextField();
        jPanel2 = new javax.swing.JPanel();
        m_vmSearch = new net.charabia.jsmoothgen.application.gui.util.SortedEditableList();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder("Version of Target VM"), new javax.swing.border.EmptyBorder(new java.awt.Insets(1, 1, 1, 1))));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Minimum Version");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel1.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.9;
        jPanel1.add(m_minimumVersion, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Maximum Version");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel1.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.9;
        jPanel1.add(m_maximumVersion, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        add(jPanel1, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(new javax.swing.border.TitledBorder("JVM Bundle"));
        m_cbBundled.setText("Use JVM Bundle");
        m_cbBundled.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cbBundledActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.9;
        jPanel3.add(m_cbBundled, gridBagConstraints);

        jLabel3.setText("Directory Location");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel3.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(m_chooserBundled, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        add(jPanel3, gridBagConstraints);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder("JVM Search"), new javax.swing.border.EmptyBorder(new java.awt.Insets(1, 1, 1, 1))));
        m_vmSearch.setEditableItems(false);
        jPanel2.add(m_vmSearch, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        add(jPanel2, gridBagConstraints);

    }//GEN-END:initComponents

	private void cbBundledActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cbBundledActionPerformed
	{//GEN-HEADEREND:event_cbBundledActionPerformed
		// Add your handling code here:
		System.out.println("chooser enabled: "+m_cbBundled.isSelected());
		if (m_cbBundled.isSelected())
		{
			m_chooserBundled.setEnabled(true);
		} else
		{
			m_chooserBundled.setEnabled(false);
		}
	}//GEN-LAST:event_cbBundledActionPerformed

	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JCheckBox m_cbBundled;
    private net.charabia.jsmoothgen.application.gui.util.FileSelectionTextField m_chooserBundled;
    private net.charabia.jsmoothgen.application.gui.util.VersionEditor m_maximumVersion;
    private net.charabia.jsmoothgen.application.gui.util.VersionEditor m_minimumVersion;
    private net.charabia.jsmoothgen.application.gui.util.SortedEditableList m_vmSearch;
    // End of variables declaration//GEN-END:variables
	
}
