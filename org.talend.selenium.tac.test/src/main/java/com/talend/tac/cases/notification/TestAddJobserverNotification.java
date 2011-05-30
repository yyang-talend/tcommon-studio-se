package com.talend.tac.cases.notification;

import java.awt.event.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestAddJobserverNotification extends Login {
	
    //add a jobserver'notification(JobServerAlertNotification)
	@Test(groups={"AddJobserverNotification"}, dependsOnGroups={"AddTaskNotification"})
	@Parameters({"categoryJobServer","descriptionTaskFailed","eventJobServerAlert","descriptionJobServerAlert","ServerForUseAvailable"})
	public void testAddJobserversJobServerAlertNotification(String categoryJobServer,String descriptionTaskFailed, String eventJobServerAlert,
			String descriptionJobServerAlert, String jobServer) {
		
		addNotification(3, categoryJobServer, 1, eventJobServerAlert, descriptionJobServerAlert, jobServer);
	    
		selenium.click("idFormSaveButton");//clcik 'save'
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventJobServerAlert+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='true']"));
		selenium.setSpeed(MIN_SPEED);
		
	}
	//add a jobserver'notification(uncheck Active)
	@Test(dependsOnMethods={"testAddJobserversJobServerAlertNotification"})
	@Parameters({"categoryJobServer","descriptionTaskFailed","eventJobServerAlert","descriptionJobServerAlert","ServerForUseAvailable"})
	public void testAddJobserversNotificationUncheckActive(String categoryJobServer, String descriptionTaskFailed,String eventJobServerAlert,
			String descriptionJobServerAlert,String jobServer) {
		
		addNotification(3, categoryJobServer, 1, eventJobServerAlert, descriptionJobServerAlert, jobServer);

		selenium.click("idActiveInput");//uncheck  'Active'
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isChecked("idActiveInput"));
		selenium.setSpeed(MIN_SPEED);
				
		selenium.click("idFormSaveButton");//clcik 'save'
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventJobServerAlert+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='false']"));
		selenium.setSpeed(MIN_SPEED);
	}
	
	public void addNotification(int LabelInput,String LabelInputValue,int DescriptionInput,
			String DescriptionInputValue,String notificationInformation,String jobServer) {
		
		this.clickWaitForElementPresent("!!!menu.notification.element!!!");//into notification
		selenium.click("idSubModuleAddButton");//click add button
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//img[@class='gwt-Image x-component ']"));
		selenium.setSpeed(MIN_SPEED);
		this.selectDropDownList("//input[@id='idLabelInput']", LabelInput);//choose a notification type
		Assert.assertEquals(selenium.getValue("idLabelInput"), LabelInputValue);
		this.selectDropDownList("//input[@id='idDescriptionInput']", DescriptionInput);//choose a event
		String description = selenium.getValue("idDescriptionInput");
		System.out.println(description);
		selenium.setSpeed(MID_SPEED);
		Assert.assertEquals(description , DescriptionInputValue);
		Assert.assertTrue(selenium.isTextPresent(notificationInformation));
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idLabelInput");
		selenium.mouseDownAt("//div[@role='listitem']["+LabelInput+"]", ""+KeyEvent.VK_ENTER);
		
		selenium.click("//i[text()='"+notificationInformation+"']//ancestor::tbody//" +
		"button[@id='idNotificationRepUserButton']");//choose event trigger users
		selenium.mouseDown("//div[text()='testChooseTypeDataQuality@126.com']/parent::td/preceding-sibling::td");//choose event trigger users
		selenium.click("//button[text()='Apply']");
		selenium.click("idNotificationJobserverButton");
		selenium.mouseDown("//div[text()='"+jobServer+"']/parent::td/preceding-sibling::td");//choose event trigger jobServer
		selenium.click("//button[text()='Apply']");	


	}
}
