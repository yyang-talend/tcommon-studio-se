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
package tosstudio.metadata.filemanipulation;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
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
public class DeleteXmlFileTest extends TalendSwtBotForTos {

    private SWTBotTree tree;

    private SWTBotView view;

    private static final String FILENAME = "test_xml"; //$NON-NLS-1$

    private static final String SAMPLE_RELATIVE_FILEPATH = "test.xml"; //$NON-NLS-1$

    private static final String LOOP = "/schema/column"; //$NON-NLS-1$

    private static final String[] SCHEMA = { "comment", "default", "key" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    @Before
    public void createXmlFile() throws IOException, URISyntaxException {
        view = gefBot.viewByTitle("Repository");
        view.setFocus();

        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
        tree.setFocus();

        tree.expandNode("Metadata").getNode("File xml").contextMenu("Create file xml").click();
        gefBot.waitUntil(Conditions.shellIsActive("New Xml File"));
        gefBot.shell("New Xml File").activate();

        gefBot.textWithLabel("Name").setText(FILENAME);
        gefBot.button("Next >").click();
        gefBot.button("Next >").click();
        gefBot.textWithLabel("XML").setText(
                Utilities.getFileFromCurrentPluginSampleFolder(SAMPLE_RELATIVE_FILEPATH).getAbsolutePath());
        gefBot.button("Next >").click();

        gefBot.tableInGroup("Target Schema", 0).click(0, 2);
        gefBot.text().setText(LOOP);
        for (int i = 0; i < 3; i++) {
            gefBot.buttonWithTooltip("Add").click();
            gefBot.tableInGroup("Target Schema", 1).click(i, 2);
            gefBot.text().setText("@" + SCHEMA[i]);
            gefBot.tableInGroup("Target Schema", 1).click(i, 3);
            gefBot.text().setText(SCHEMA[i]);
        }

        gefBot.button("Next >").click();
        gefBot.button("Finish").click();

        SWTBotTreeItem newXmlItem = null;
        try {
            newXmlItem = tree.expandNode("Metadata").expandNode("File xml").getNode(FILENAME + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("file xml item is not created", newXmlItem);
        }
    }

    @Test
    public void deleteXmlFile() {
        tree.expandNode("Metadata", "File xml").getNode(FILENAME + " 0.1").contextMenu("Delete").click();

        SWTBotTreeItem newXmlItem = null;
        try {
            newXmlItem = tree.expandNode("Recycle bin").select(FILENAME + " 0.1" + " ()");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("file xml item is not deleted to recycle bin", newXmlItem);
        }
    }

    @After
    public void removePreviouslyCreateItems() {
        Utilities.emptyRecycleBin(gefBot, tree);
    }
}
