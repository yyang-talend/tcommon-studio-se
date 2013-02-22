// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.rcp.exportLogs;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * DOC wzhang class global comment. Detailled comment
 */
public class ExportLogsAction extends Action {

    private static final String ACTION_ID = "org.talend.rcp.intro.exportLogsAction"; //$NON-NLS-1$

    public ExportLogsAction() {
        super();
        this.setId(ACTION_ID);
        this.setText("Export logs");
    }

    @Override
    public void run() {
        ExportLogsWizard wizard = new ExportLogsWizard();
        wizard.setWindowTitle("Export Logs");
        Shell activeShell = Display.getCurrent().getActiveShell();
        WizardDialog dialog = new WizardDialog(activeShell, wizard);
        dialog.open();
    }

}
