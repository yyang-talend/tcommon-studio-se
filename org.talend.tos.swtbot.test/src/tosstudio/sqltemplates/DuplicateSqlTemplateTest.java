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
package tosstudio.sqltemplates;

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
public class DuplicateSqlTemplateTest extends TalendSwtBotForTos {

    private SWTBotView view;

    private SWTBotTree tree;

    private SWTBotShell shell;

    private static final String SQLTEMPLATENAME = "sqlTemplate1"; //$NON-NLS-1$

    private static final String NEW_SQLTEMPLATENAME = "duplicate_sqlTemplate1"; //$NON-NLS-1$

    @Before
    public void createSqlTemplate() {
        view = gefBot.viewByTitle("Repository");
        view.setFocus();
        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
        Utilities.createSqlTemplate(SQLTEMPLATENAME, tree, gefBot, shell);
    }

    @Test
    public void duplicateSqlTemplate() {
        tree.expandNode("SQL Templates", "Generic", "UserDefined").getNode(SQLTEMPLATENAME + " 0.1").contextMenu("Duplicate")
                .click();
        gefBot.shell("Please input new name ").activate();
        gefBot.text("Copy_of_" + SQLTEMPLATENAME).setText(NEW_SQLTEMPLATENAME);
        gefBot.button("OK").click();

        SWTBotTreeItem newSqlTemplateItem = null;
        try {
            newSqlTemplateItem = tree.expandNode("SQL Templates", "Generic", "UserDefined").select(NEW_SQLTEMPLATENAME + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("SQL Template item is not duplicated", newSqlTemplateItem);
        }
    }

    @After
    public void removePreviouslyCreateItems() {
        gefBot.cTabItem(SQLTEMPLATENAME + " 0.1").close();
        tree.expandNode("SQL Templates", "Generic", "UserDefined").getNode(SQLTEMPLATENAME + " 0.1").contextMenu("Delete")
                .click();
        tree.expandNode("SQL Templates", "Generic", "UserDefined").getNode(NEW_SQLTEMPLATENAME + " 0.1").contextMenu("Delete")
                .click();

        Utilities.emptyRecycleBin(gefBot, tree);
    }
}
