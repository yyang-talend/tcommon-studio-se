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
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
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
public class CopyPasteDelimitedFileTest extends TalendSwtBotForTos {

    private SWTBotTree tree;

    private SWTBotView view;

    private static final String FILENAME = "test_delimited"; //$NON-NLS-1$

    private static final String SAMPLE_RELATIVE_FILEPATH = "test.csv"; //$NON-NLS-1$

    @Before
    public void createDelimitedFile() throws IOException, URISyntaxException {
        view = gefBot.viewByTitle("Repository");
        view.setFocus();

        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
        tree.setFocus();

        tree.expandNode("Metadata").getNode("File delimited").contextMenu("Create file delimited").click();
        gefBot.waitUntil(Conditions.shellIsActive("New Delimited File"));
        gefBot.shell("New Delimited File").activate();

        gefBot.textWithLabel("Name").setText(FILENAME);
        gefBot.button("Next >").click();
        gefBot.textWithLabel("File").setText(
                Utilities.getFileFromCurrentPluginSampleFolder(SAMPLE_RELATIVE_FILEPATH).getAbsolutePath());
        gefBot.button("Next >").click();
        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {

                return gefBot.button("Next >").isEnabled();
            }

            public String getFailureMessage() {
                gefBot.shell("New Delimited File").close();
                return "next button was never enabled";
            }
        }, 60000);
        gefBot.button("Next >").click();
        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {

                return gefBot.button("Finish").isEnabled();
            }

            public String getFailureMessage() {
                gefBot.shell("New Delimited File").close();
                return "finish button was never enabled";
            }
        });
        gefBot.button("Finish").click();

        SWTBotTreeItem newCsvItem = null;
        try {
            newCsvItem = tree.expandNode("Metadata", "File delimited").select(FILENAME + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("file delimited is not created", newCsvItem);
        }
    }

    @Test
    public void copyAndPasteDelimitedFile() {
        tree.expandNode("Metadata", "File delimited").getNode(FILENAME + " 0.1").contextMenu("Copy").click();
        tree.select("Metadata", "File delimited").contextMenu("Paste").click();

        SWTBotTreeItem newCsvItem = null;
        try {
            newCsvItem = tree.expandNode("Metadata", "File delimited").select("Copy_of_" + FILENAME + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("file delimited is not copied", newCsvItem);
        }
    }

    @After
    public void removePreviouslyCreateItems() {
        tree.expandNode("Metadata", "File delimited").getNode(FILENAME + " 0.1").contextMenu("Delete").click();
        tree.expandNode("Metadata", "File delimited").getNode("Copy_of_" + FILENAME + " 0.1").contextMenu("Delete").click();

        Utilities.emptyRecycleBin(gefBot, tree);
    }
}
