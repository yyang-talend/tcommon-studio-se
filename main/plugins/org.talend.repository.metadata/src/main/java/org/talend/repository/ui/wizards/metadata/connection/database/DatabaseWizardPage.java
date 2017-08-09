// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.repository.ui.wizards.metadata.connection.database;


import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.database.conn.template.EDatabaseConnTemplate;
import org.talend.core.model.metadata.IMetadataConnection;
import org.talend.core.model.process.EComponentCategory;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.runtime.services.IGenericWizardService;
import org.talend.designer.core.model.utils.emf.talendfile.ContextType;
import org.talend.metadata.managment.ui.wizard.AbstractForm;
import org.talend.metadata.managment.ui.wizard.RepositoryWizard;

/**
 * DatabaseWizard present the DatabaseForm. Use to Use to manage the metadata connection. Page allows setting a
 * database.
 */
public class DatabaseWizardPage extends WizardPage {

    private ConnectionItem connectionItem;

    private DatabaseForm databaseForm;
    
    private Composite dynamicForm;
    
    private Composite dynamicParentForm;
    
    private Composite compositeDbSettings;
    
    private DBTypeForm dbTypeForm;

    private final String[] existingNames;

    private final boolean isRepositoryObjectEditable;
    
    private Composite parentContainer;
    
    private boolean isCreation = false;

    /**
     * DatabaseWizardPage constructor.
     * 
     * @param connection
     * @param isRepositoryObjectEditable
     * @param existingNames
     */
    public DatabaseWizardPage(ConnectionItem connectionItem, boolean isRepositoryObjectEditable, String[] existingNames) {
        super("wizardPage"); //$NON-NLS-1$
        this.connectionItem = connectionItem;
        this.existingNames = existingNames;
        this.isRepositoryObjectEditable = isRepositoryObjectEditable;
    }

    /**
     * Create the composites, initialize it and add controls.
     * 
     * @see IDialogPage#createControl(Composite)
     */
    @Override
    public void createControl(final Composite parent) {
        if (this.getWizard() instanceof RepositoryWizard) {
            isCreation = ((RepositoryWizard) getWizard()).isCreation();
        }
        
        parentContainer = new Composite(parent, SWT.NONE);
        FillLayout fillLayout = new FillLayout();
        fillLayout.spacing = 1;
        fillLayout.marginHeight = 0;
        fillLayout.marginWidth = 0;
        parentContainer.setLayout(new FormLayout());
        GridData parentGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        parentContainer.setLayoutData(parentGridData);
        compositeDbSettings = new Composite(parentContainer, SWT.NULL);
        compositeDbSettings.setLayout(new GridLayout(3, false));
        
        FormData data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        compositeDbSettings.setLayoutData(data);
        dbTypeForm = new DBTypeForm(this, compositeDbSettings, connectionItem, SWT.NONE, !isRepositoryObjectEditable);
        
        createDBForm();
        setControl(parentContainer);
    }
    
    public void createDBForm(){
        if(parentContainer == null || parentContainer.isDisposed()){
            return;
        }
        FormData data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(compositeDbSettings, 0);
        data.bottom = new FormAttachment(100, 0);
        if(isGeneralJDBC(dbTypeForm.getDBType())){
            IGenericWizardService wizardService = null;
            if (GlobalServiceRegister.getDefault().isServiceRegistered(IGenericWizardService.class)) {
                wizardService = (IGenericWizardService) GlobalServiceRegister.getDefault().getService(
                        IGenericWizardService.class);
            }
            dynamicParentForm = new Composite(parentContainer, SWT.NONE);
            dynamicParentForm.setLayoutData(data);
            dynamicParentForm.setLayout(new FormLayout());
            
            if(wizardService == null){
                return;
            }
            dynamicForm = wizardService.creatDBDynamicComposite(dynamicParentForm, EComponentCategory.BASIC, true, connectionItem.getProperty(), 
                    ERepositoryObjectType.JDBC.getType());
            dynamicForm.layout();
            dynamicParentForm.layout();
        }else{
            
            databaseForm = new DatabaseForm(parentContainer, connectionItem, existingNames, isCreation);
            databaseForm.setLayoutData(data);
            databaseForm.setReadOnly(!isRepositoryObjectEditable);
            databaseForm.updateSpecialFieldsState();

            AbstractForm.ICheckListener listener = new AbstractForm.ICheckListener() {

                @Override
                public void checkPerformed(final AbstractForm source) {
                    if (source.isStatusOnError()) {
                        DatabaseWizardPage.this.setPageComplete(false);
                        setErrorMessage(source.getStatus());
                    } else {
                        DatabaseWizardPage.this.setPageComplete(isRepositoryObjectEditable);
                        setErrorMessage(null);
                        setMessage(source.getStatus(), source.getStatusLevel());
                    }
                }
            };
            databaseForm.setListener(listener);
            if (connectionItem.getProperty().getLabel() != null && !connectionItem.getProperty().getLabel().equals("")) { //$NON-NLS-1$
                databaseForm.checkFieldsValue();
            }
        }
        parentContainer.layout();
    }
    
    public boolean isGeneralJDBC(String type){
        if(type == null){
            return false;
        }
        return EDatabaseConnTemplate.GENERAL_JDBC.getDBDisplayName().equals(type);
    }
    
    public void refreshDBForm(){
        if(databaseForm == null || databaseForm.isDisposed()){
            return;
        }
        databaseForm.refreshDBForm();
    }

    
    public void disposeDBForm(){
        if(databaseForm != null && !databaseForm.isDisposed()){
            databaseForm.dispose();
        }
        if(dynamicParentForm != null && !dynamicParentForm.isDisposed()){
            dynamicParentForm.dispose();
        }
        if(dynamicForm != null && !dynamicForm.isDisposed()){
            dynamicForm.dispose();
        }
    }
    /**
     * 
     * DOC zshen Comment method "getMetadataConnection".
     * 
     * @return
     */
    public IMetadataConnection getMetadataConnection() {
        return databaseForm.getMetadataConnection();
    }

    public ContextType getSelectedContextType() {
        return databaseForm.getSelectedContextType();
    }
    
}
