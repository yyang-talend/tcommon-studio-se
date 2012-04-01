// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.repository.viewer.action;

import org.talend.repository.ui.actions.DeleteAction;
import org.talend.repository.ui.actions.EmptyRecycleBinAction;
import org.talend.repository.ui.actions.RestoreAction;

/**
 * DOC ggu class global comment. Detailled comment
 */
public class RecycleBinActionProvider extends AbstractRepositoryActionProvider {

    public RecycleBinActionProvider() {
        super();
    }

    @Override
    protected void makeContextualActions() {
        super.makeContextualActions();

        addContextualAction(new EmptyRecycleBinAction());
        addContextualAction(new DeleteAction());
        addContextualAction(new RestoreAction());
    }

}
