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
 * JSmoothModelBean.java
 *
 * Created on 7 ao�t 2003, 18:32
 */

package net.charabia.jsmoothgen.application;

import java.util.*;
import java.beans.*;
import java.io.*;

public class JSmoothModelBean
{
	private String m_skeletonName;
	private String m_executableName;
	private String m_iconLocation;
	private String m_jarLocation;
	private String m_mainClassName;
	private String m_arguments;
	private String[] m_classPath;
	private String m_minimumVersion = "";
	private String m_maximumVersion = "";
	private String[] m_jvmSearch = null;
	
	transient Vector m_listeners = new Vector();

	public static interface Listener
	{
		public void dataChanged();
	}
	
	/** Creates a new instance of JSmoothModelBean */
	public JSmoothModelBean()
	{
	}
	
	public void addListener(JSmoothModelBean.Listener l)
	{
		m_listeners.add(l);
	}
	
	public void removeListener(JSmoothModelBean.Listener l)
	{
		m_listeners.remove(l);
	}
	
	private void fireChanged()
	{
		for (Iterator i=m_listeners.iterator(); i.hasNext(); )
		{
			JSmoothModelBean.Listener l = (JSmoothModelBean.Listener)i.next();
			l.dataChanged();
		}
	}
	
	public void setSkeletonName(String name)
	{
		m_skeletonName = name;
	}
	
	public String getSkeletonName()
	{
		return m_skeletonName;
	}
	
	public void setExecutableName(String name)
	{
		m_executableName = name;
		fireChanged();
	}
		
	public String getExecutableName()
	{
		return m_executableName;
	}

	public void setIconLocation(String name)
	{
		m_iconLocation = name;
		fireChanged();
	}

	public String getIconLocation()
	{
		return m_iconLocation;
	}

	public void setJarLocation(String name)
	{
		m_jarLocation = name;
		fireChanged();
	}

	public String getJarLocation()
	{
		return m_jarLocation;
	}


	public void setMainClassName(String name)
	{
		m_mainClassName = name;
		fireChanged();
	}

	public String getMainClassName()
	{
		return m_mainClassName;
	}

	public void setArguments(String args)
	{
		m_arguments = args;
		fireChanged();
	}
	
	public String getArguments()
	{
		return m_arguments;
	}

	public void setClassPath(String[] cp)
	{
		m_classPath = cp;
		fireChanged();
	}
	
	public String[] getClassPath()
	{
		return m_classPath;
	}

	public void setMaximumVersion(String version)
	{
		m_maximumVersion = version;
		fireChanged();
	}
	
	public String getMaximumVersion()
	{
		return m_maximumVersion;
	}
	
	public void setMinimumVersion(String version)
	{
		m_minimumVersion = version;
		fireChanged();
	}
	
	public String getMinimumVersion()
	{
		return m_minimumVersion;
	}
	
	public void setJVMSearchPath(String[] path)
	{
		m_jvmSearch = path;
		fireChanged();
	}
	
	public String[] getJVMSearchPath()
	{
		return m_jvmSearch;
	}
	
	public String[] normalizePaths(java.io.File root)
	{
		Vector result = new Vector();
		
		m_iconLocation = checkRelativePath(root, m_iconLocation, result, "Icon location");
		m_jarLocation = checkRelativePath(root, m_jarLocation, result, "Jar location");
		for (int i=0; i<m_classPath.length; i++)
		{
			m_classPath[i] = checkRelativePath(root, m_classPath[i], result, "Classpath entry (" + i + ")");
		}
		
		if (result.size() == 0)
			return null;
		
		String[] res = new String[result.size()];
		result.toArray(res);
		
		return res;
	}
	
	private String checkRelativePath(java.io.File root, String value, java.util.Vector errors, String name)
	{
		if (value == null)
			value = "";
		
		File nf = JSmoothModelPersistency.makePathRelativeIfPossible(root, new File(value));
		if (nf.isAbsolute())
		{
			errors.add(name);
		}
		return nf.toString();
	}
}