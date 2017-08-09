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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.ui.swt.formtools.LabelledCombo;
import org.talend.commons.utils.platform.PluginChecker;
import org.talend.core.database.EDatabaseTypeName;
import org.talend.core.database.conn.template.EDatabaseConnTemplate;
import org.talend.core.model.metadata.builder.connection.DatabaseConnection;
import org.talend.core.model.metadata.builder.database.ExtractMetaDataFromDataBase;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.ui.branding.IBrandingConfiguration;
import org.talend.metadata.managment.utils.MetadataConnectionUtils;
import org.talend.repository.metadata.i18n.Messages;

/**
 * DOC hwang  class global comment. Detailled comment
 */
public class DBTypeForm {
    
    private static final int VISIBLE_DATABASE_COUNT = 20;
    
    private LabelledCombo dbTypeCombo;
    
    private ConnectionItem connectionItem;
    
    private boolean isReadOnly;
    
    private DatabaseWizardPage wizardPage;
    
    private Composite parent;
    
    private String dbType;
    
    public DBTypeForm(DatabaseWizardPage wizardPage, Composite parent, ConnectionItem connectionItem,int style, boolean readOnly) {
        this.parent = parent;
        this.wizardPage = wizardPage;
        this.connectionItem = connectionItem;
        this.isReadOnly = readOnly;
        initialize();
    }
    
    public void initialize() {
        addDBSelectCombo();
        EDatabaseConnTemplate template = EDatabaseConnTemplate.indexOfTemplate(getConnection().getDatabaseType());
        if (template != null) {
            if (dbTypeCombo.getText().length() == 0 || !dbTypeCombo.getText().equals(template.getDbType().getDisplayName())) {
                dbTypeCombo.setText(template.getDbType().getDisplayName());
            }
        }
        addListerner();
    }
    
    protected void adaptFormToReadOnly() {
        dbTypeCombo.setReadOnly(isReadOnly);
    }
    
    private void addDBSelectCombo() {
        // PTODO cantoine : HIDDEN some Database connection in function of
        // project MODE (Perl/Java).

        List<String> dbTypeDisplayList = EDatabaseConnTemplate.getDBTypeDisplay();

        // added by dlin for 21721,only a temporary approach to resolve it -begin
        IWorkbenchWindow workBenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (workBenchWindow != null) {
            IWorkbenchPage page = workBenchWindow.getActivePage();
            if (page != null) {
                String perId = page.getPerspective().getId();
                if ((!"".equals(perId) && null != perId)) { //$NON-NLS-1$
                    // eg : use DI, then switch to DQ : All view from DI must be hidden when switch
                    // MOD qiongli 2012-7-10 TDQ-5801,hide also 'MSsql 2005/2008' for DQ after delete that MS jars.
                    if (perId.equalsIgnoreCase(IBrandingConfiguration.PERSPECTIVE_DI_ID)
                            || perId.equalsIgnoreCase(IBrandingConfiguration.PERSPECTIVE_DQ_ID)) {
                        if (dbTypeDisplayList != null) {
                            ArrayList<String> newList = new ArrayList<String>(dbTypeDisplayList);
                            for (int i = 0; i < newList.size(); i++) {
                                if (newList.get(i).equalsIgnoreCase(("Microsoft SQL Server 2005/2008"))) {
                                    newList.remove(i);
                                }
                            }
                            dbTypeDisplayList = newList;
                        }
                    }
                }
            }
        }

        // added by dlin for 21721,only a temporary approach to resolve it -end
        if (PluginChecker.isOnlyTopLoaded()) {
            dbTypeDisplayList = filterUnavailableType(dbTypeDisplayList);
        }
        filterTypesUnloadProviders(dbTypeDisplayList);

        filterUnsupportedDBType(dbTypeDisplayList);

//        this.setLayout(new GridLayout());
        dbTypeCombo = new LabelledCombo(parent, Messages.getString("DatabaseForm.dbType"), Messages //$NON-NLS-1$
                .getString("DatabaseForm.dbTypeTip"), dbTypeDisplayList.toArray(new String[0]), 2, true); //$NON-NLS-1$

        // configure the visible item of database combo
        int visibleItemCount = dbTypeCombo.getCombo().getItemCount();
        if (visibleItemCount > VISIBLE_DATABASE_COUNT) {
            visibleItemCount = VISIBLE_DATABASE_COUNT;
        }
        dbTypeCombo.getCombo().setVisibleItemCount(visibleItemCount);
    }
    
    private void filterUnsupportedDBType(List<String> dbTypeDisplayList) {
        Iterator<String> it = dbTypeDisplayList.iterator();
        while (it.hasNext()) {
            String displayName = it.next();
            EDatabaseTypeName type = EDatabaseTypeName.getTypeFromDisplayName(displayName);
            if (!type.isSupport()) {
                it.remove();
            }
        }
    }

    private void filterTypesUnloadProviders(List<String> dbTypeDisplayList) {
        Iterator<String> it = dbTypeDisplayList.iterator();
        while (it.hasNext()) {
            String displayName = it.next();
            EDatabaseTypeName type = EDatabaseTypeName.getTypeFromDisplayName(displayName);
            // if can't find the provider for current typename,remove it from combo
            if (type != null && type.isUseProvider()) {
                String dbtypeString = type.getXmlName();
                if (dbtypeString != null && ExtractMetaDataFromDataBase.getProviderByDbType(dbtypeString) == null) {
                    it.remove();
                }
            }
        }

    }

    private List<String> filterUnavailableType(List<String> dbTypeDisplayList) {
        List<String> resultList = new ArrayList<String>();

        List<String> tdqSupportDBList = MetadataConnectionUtils.getTDQSupportDBTemplate();
        for (String dbType : dbTypeDisplayList) {
            if (tdqSupportDBList.contains(dbType)) {
                resultList.add(dbType);
            }
        }

        return resultList;
    }
    
    protected final boolean isContextMode() {
        if (connectionItem != null) {
            return connectionItem.getConnection().isContextMode();
        }
        return false;
    }
    
    private void addListerner(){
        dbTypeCombo.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(final ModifyEvent e) {
                dbType = dbTypeCombo.getText();
                String oldType = getConnection().getDatabaseType();
                if(dbType.equals(oldType)){
                    return;
                }
                getConnection().setDatabaseType(dbType);
                if(wizardPage.isGeneralJDBC(dbType) || wizardPage.isGeneralJDBC(oldType)){
                    getConnection().getParameters().clear();
                    getConnection().setDbVersionString(null);
                    wizardPage.disposeDBForm();
                    wizardPage.createDBForm();
                }else{
                    wizardPage.refreshDBForm();
                }
            }
        });
    }
    
    public DatabaseConnection getConnection(){
        return (DatabaseConnection) connectionItem.getConnection();
    }
    
    public String getDBType(){
        return this.dbType;
    }

}
