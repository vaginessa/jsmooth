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

/*
 * Sample.java
 *
 * Created on 3 ao�t 2003, 14:26
 */
import javax.swing.*;
/**
 *
 * @author  Rodrigo
 */
public class Sample extends javax.swing.JDialog
{
	
	/** Creates new form Sample */
	public Sample(java.awt.Frame parent, boolean modal)
	{
		super(parent, modal);
		initComponents();
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	private void initComponents()//GEN-BEGIN:initComponents
	{
		jPanel1 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("JSmooth Sample");
		setModal(true);
		addWindowListener(new java.awt.event.WindowAdapter()
		{
			public void windowClosed(java.awt.event.WindowEvent evt)
			{
				formWindowClosed(evt);
			}
			public void windowClosing(java.awt.event.WindowEvent evt)
			{
				closeDialog(evt);
			}
		});
		
		jButton1.setText("Exit");
		jButton1.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton1ActionPerformed(evt);
			}
		});
		
		jPanel1.add(jButton1);
		
		getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);
		
		jPanel2.setLayout(new java.awt.BorderLayout());
		
		jPanel2.setBorder(new javax.swing.border.EtchedBorder());
		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gnome-application-x-gzip.png")));
		jLabel1.setText("Sample Application for JSmooth");
		jLabel1.setAlignmentX(0.5F);
		jLabel1.setFocusable(false);
		jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);
		
		getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
		
		pack();
	}//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
	{//GEN-HEADEREND:event_jButton1ActionPerformed
		// Add your handling code here:
		System.exit(0);
	}//GEN-LAST:event_jButton1ActionPerformed

	private void formWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosed
	{//GEN-HEADEREND:event_formWindowClosed
		// Add your handling code here:
		System.exit(0);
	}//GEN-LAST:event_formWindowClosed
	
	/** Closes the dialog */
	private void closeDialog(java.awt.event.WindowEvent evt)//GEN-FIRST:event_closeDialog
	{
		setVisible(false);
		dispose();
	}//GEN-LAST:event_closeDialog
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		new Sample(new javax.swing.JFrame(), true).show();
	}
	
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	// End of variables declaration//GEN-END:variables
	
}
