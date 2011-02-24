// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package tosstudio.businessmodels;

import junit.framework.Assert;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DeleteBusinessModelTest extends TalendSwtBotForTos {

    private SWTBotTree tree;

    private SWTBotShell shell;

    private SWTBotView view;

    private static final String BUSINESSMODELNAME = "businessModel1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() {
        view = gefBot.viewByTitle("Repository");
        view.setFocus();
        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
        Utilities.createBusinessModel(BUSINESSMODELNAME, tree, gefBot, shell);
    }

    @Test
    public void deleteBusinessModel() {
        gefBot.cTabItem("Model " + BUSINESSMODELNAME).close();
        tree.expandNode("Business Models").getNode(BUSINESSMODELNAME + " 0.1").contextMenu("Delete").click();

        SWTBotTreeItem newBusinessModelItem = null;
        try {
            newBusinessModelItem = tree.expandNode("Recycle bin").select(BUSINESSMODELNAME + " 0.1" + " ()");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("business model is not deleted to recycle bin", newBusinessModelItem);
        }
    }

    @After
    public void removePreviouslyCreateItems() {
        Utilities.emptyRecycleBin(gefBot, tree);
    }
}
