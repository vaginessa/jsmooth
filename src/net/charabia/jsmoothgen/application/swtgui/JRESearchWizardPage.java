/*
 * Created on Nov 21, 2003
 */
package net.charabia.jsmoothgen.application.swtgui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

/**
 * @author Dumon
 */
public class JRESearchWizardPage extends WizardPage {
	private static final int BUTTON_EXTRA_WIDTH = 6;
	private static final int VERSION_TEXT_WIDTH = 40;
	private static final int VERSION_TEXT_LIMIT = 5;
	private static final int JRE_SEARCH_HEIGHT = 10;
	private static final String JRE_WIZBAN =
		JSmoothResources.JRE_WIZBAN;
	private static final String ADD_ITEM =
		JSmoothResources.ADD_ITEM;
	private static final String REMOVE_ITEM =
		JSmoothResources.REMOVE_ITEM;
	private static final String EDIT_ITEM =
		JSmoothResources.EDIT_ITEM;
	private static final String MOVE_UP =
		JSmoothResources.MOVE_UP;
	private static final String MOVE_DOWN =
		JSmoothResources.MOVE_DOWN;
	 
	public JRESearchWizardPage() {
		super("wizard.jre_search");
		setTitle("JRE Search");
		setMessage("Locations to search the Java Runtime Environment.");
		setImageDescriptor(
			JSmoothResources.getDescriptor(JRE_WIZBAN));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		GridLayout layout = null;
		GridData layoutData = null;
		
		Composite comp = new Composite(parent, SWT.NONE);
		layout = new GridLayout(2, false);
		comp.setLayout(layout);
		
		createJRESearch(comp);
		
		setControl(comp);
	}
	
	private void createJRESearch(Composite parent) {
		GridData layoutData = null;
		
		List list = new List(parent, SWT.BORDER);
		layoutData = new GridData(GridData.FILL_BOTH);
		list.setLayoutData(layoutData);
		
		Composite jreSearchButtonBar = new Composite(parent, SWT.NONE);
		jreSearchButtonBar.setLayout(new GridLayout());
		layoutData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		layoutData.heightHint =
			list.getItemHeight() * JRE_SEARCH_HEIGHT;
		jreSearchButtonBar.setLayoutData(layoutData);
		
		createButtonForJRESearch(jreSearchButtonBar, "Add...");		
		createButtonForJRESearch(jreSearchButtonBar, "Remove...");
		createButtonForJRESearch(jreSearchButtonBar, "Edit...");
	}
	
	private int computeButtonWidth(Button button, String text) {
		initializeDialogUnits(button);
		return convertWidthInCharsToPixels(
			text.toCharArray().length + BUTTON_EXTRA_WIDTH);
	}
	
	private Button createButtonForJRESearch(
		Composite parent,
		String text,
		Image image) {
			
		Button button = new Button(parent, SWT.PUSH);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.widthHint = computeButtonWidth(button, text);
		button.setLayoutData(layoutData);
		button.setText(text);
		button.setImage(image);
		
		return button;
	}
	
	private Button createButtonForJRESearch(Composite parent, String text) {
		return createButtonForJRESearch(parent, text, null);
	}
	
	private Button createButtonForJRESearch(Composite parent, Image image) {
		return createButtonForJRESearch(parent, "", image);
	}
	
}