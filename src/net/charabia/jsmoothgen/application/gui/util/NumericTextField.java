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

package net.charabia.jsmoothgen.application.gui.util;

import javax.swing.*;
import javax.swing.text.*;

public class NumericTextField extends javax.swing.JPanel
{
	static class IntegerDocument extends PlainDocument
	{
		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
		{
			if (str == null)
			{
				return;
			}
			for (int i=0; i<str.length(); i++)
			{
				if (Character.isDigit(str.charAt(i)) == false)
					return;
			}
			super.insertString(offs, str, a);
		}
	}
	
	/** Creates new form BeanForm */
	public NumericTextField()
	{
		initComponents();
		m_data.setDocument(new NumericTextField.IntegerDocument());
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	private void initComponents()//GEN-BEGIN:initComponents
	{
		m_data = new javax.swing.JTextField();
		
		setLayout(new java.awt.BorderLayout());
		
		m_data.setText("jTextField1");
		add(m_data, java.awt.BorderLayout.CENTER);
		
	}//GEN-END:initComponents
	
	public void setValue(int val)
	{
		m_data.setText(new Integer(val).toString());
	}
	
	public int getValue()
	{
		if (m_data.getText().trim().length() == 0)
			return Integer.MAX_VALUE;
		else
			return Integer.parseInt(m_data.getText());
	}
	
	public void clear()
	{
		m_data.setText("");
	}
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField m_data;
	// End of variables declaration//GEN-END:variables
	
}
