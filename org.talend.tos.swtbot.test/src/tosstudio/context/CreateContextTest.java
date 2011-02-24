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
package tosstudio.context;

import junit.framework.Assert;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
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
import org.talend.swtbot.SWTBotTreeItemExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateContextTest extends TalendSwtBotForTos {

    private SWTBotTree tree;

    private SWTBotShell shell;

    private SWTBotView view;

    private static final String CONTEXTNAME = "context1"; //$NON-NLS-1$

    private static final String[] TYPE = { "int | Integer", "String", "float | Float" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    private static final String[] VALUE = { "1", "a", "2" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    @Before
    public void initialisePrivateFields() {
        view = gefBot.viewByTitle("Repository");
        view.setFocus();
        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
    }

    @Test
    public void createContext() {
        tree.setFocus();
        tree.select("Contexts").contextMenu("Create context group").click();

        gefBot.waitUntil(Conditions.shellIsActive("Create / Edit a context group"));
        shell = gefBot.shell("Create / Edit a context group");
        shell.activate();

        gefBot.textWithLabel("Name").setText(CONTEXTNAME);
        gefBot.button("Next >").click();

        SWTBotTreeItem treeItem;
        SWTBotTreeItemExt treeItemExt;
        for (int i = 0; i < 3; i++) {
            gefBot.button(0).click();
            treeItem = gefBot.tree(0).getTreeItem("new1").click();
            treeItemExt = new SWTBotTreeItemExt(treeItem);
            treeItemExt.click(0);
            gefBot.text("new1").setText("var" + (i + 1));
            treeItemExt.click(1);
            gefBot.ccomboBox("String").setSelection(TYPE[i]);
            treeItemExt.click(2);
        }

        gefBot.cTabItem("Values as tree").activate();

        for (int j = 0; j < 3; j++) {
            treeItem = gefBot.tree(0).expandNode("var" + (j + 1)).getNode(0).select().click();
            treeItemExt = new SWTBotTreeItemExt(treeItem);
            treeItemExt.click(4);
            gefBot.text().setText(VALUE[j]);
        }

        gefBot.button("Finish").click();

        SWTBotTreeItem newContextItem = null;
        try {
            newContextItem = tree.expandNode("Contexts").select(CONTEXTNAME + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("context is not created", newContextItem);
        }
    }

    @After
    public void removePreviouslyCreateItems() {
        tree.expandNode("Contexts").getNode(CONTEXTNAME + " 0.1").contextMenu("Delete").click();

        Utilities.emptyRecycleBin(gefBot, tree);
    }
}
