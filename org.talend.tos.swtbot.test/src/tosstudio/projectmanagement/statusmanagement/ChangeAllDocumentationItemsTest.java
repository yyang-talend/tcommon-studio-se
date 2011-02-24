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
package tosstudio.projectmanagement.statusmanagement;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ChangeAllDocumentationItemsTest extends TalendSwtBotForTos {

    private SWTBotView view;

    private SWTBotTree tree;

    private SWTBotShell shell;

    private static final String BUSINESSMODELNAME = "businessModel1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        view = gefBot.viewByTitle("Repository");
        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
        tree.setFocus();
        tree.select("Business Models").contextMenu("Create Business Model").click();
        gefBot.waitUntil(Conditions.shellIsActive("New Business Model"));
        shell = gefBot.shell("New Business Model");
        shell.activate();
        gefBot.textWithLabel("Name").setText(BUSINESSMODELNAME);
        gefBot.button("Finish").click();
        gefBot.cTabItem("Model " + BUSINESSMODELNAME).close();
    }

    @Test
    public void changeAllDocumentationItems() {
        gefBot.toolbarButtonWithTooltip("Project settings").click();
        gefBot.shell("Project Settings").activate();
        gefBot.tree().expandNode("General").select("Status Management").click();
        gefBot.radio("Change all documentation items to a fixed status.").click();

        gefBot.tree(1).getTreeItem("Business Models").check();
        gefBot.comboBox().setSelection("checked");
        gefBot.button("OK").click();
        gefBot.shell("Confirm").activate();
        gefBot.button("OK").click();

        tree.expandNode("Business Models").getNode(BUSINESSMODELNAME + " 0.1").contextMenu("Edit properties").click();
        shell = gefBot.shell("Edit properties");
        shell.activate();
        Assert.assertEquals("Business Models status", "checked", gefBot.ccomboBoxWithLabel("Status").getText());
        shell.close();

    }

    @After
    public void removePreviouslyCreateItems() {
        shell.close();
        tree.expandNode("Business Models").getNode(BUSINESSMODELNAME + " 0.1").contextMenu("Delete").click();

        Utilities.emptyRecycleBin(gefBot, tree);
    }
}
