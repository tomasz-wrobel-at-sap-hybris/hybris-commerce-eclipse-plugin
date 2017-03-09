package com.hybris.yps.hyeclipse.wizards;

import java.io.File;

import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Page for a wizard to present a selector for a source archive. Includes validation logic of the selected file.
 * 
 * 
 * @author mheuer
 *
 */
public class CreateWorkingSetPage extends WizardPage 
{
	private Button createFromLocalExtensions;
	private Button createFromExtensionDirectories;
	
	public CreateWorkingSetPage() 
	{
		super("Create Working Sets");
		setTitle("Create Working Sets");
		setDescription("Create Working Sets");
	}

	public void createControl( Composite parent )
	{
		Composite container = new Composite( parent, SWT.NONE );
		container.setLayout( new GridLayout( 2, false ) );
		
		Label createFromExtensionDirectoriesLabel = new Label( container, 0 );
		createFromExtensionDirectoriesLabel.setText( "Create from directories of extensions (e.g. ext-commerce)");
		createFromExtensionDirectories = new Button( container, 32 );
		createFromExtensionDirectories.setSelection( true );
		
		Label createFromLocalExtensionsLabel = new Label( container, 0 );
		createFromLocalExtensionsLabel.setText( "Create from comments in localextensions.xml" );
		createFromLocalExtensions = new Button( container, 32 );
		createFromLocalExtensions.setSelection( false );
		
		setControl( container );
		setPageComplete( true );
	}

	
	/**
	 * Check if the contents of the page are valid.
	 * 
	 * Remember that the source file could be optional. So any checks will only apply if there is actually anything specified.
	 * 
	 * @return true if the picked archive exists and is readable. False otherwise.
	 */
	public boolean validatePage() 
	{
		if (!createFromExtensionDirectories.getSelection() && !createFromLocalExtensions.getSelection())
		{
			setErrorMessage("At least one of the options must be selected");
			return false;
		}
		return true;
	}

	public Button getCreateFromExtensionDirectories() {
		return createFromExtensionDirectories;
	}

	public Button getCreateFromLocalExtensions() {
		return createFromLocalExtensions;
	}

}
