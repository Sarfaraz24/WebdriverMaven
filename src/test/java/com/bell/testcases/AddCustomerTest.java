package com.bell.testcases;
import java.util.Hashtable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.bell.base.TestBase;
public class AddCustomerTest extends TestBase {
	@Test(dataProvider="getData")
public void addCustomerTest(Hashtable<String,String> data) throws InterruptedException{
		
		if(!data.get("runmode").equals("Y")){
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		click("addCustBtn_CSS");
		type("firstname_CSS",data.get("firstname"));
		type("lastname_XPATH",data.get("lastname"));
		type("postcode_CSS",data.get("postcode"));
		click("addbtn_CSS");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();
		//Assert.fail("customer not added successfully");
		System.out.println("This is addcustomertest run successfully");
	}
	@DataProvider
	public Object[][] getData(){
		String sheetName="AddCustomerTest";
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][1];
		Hashtable<String,String> table = null;
		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2
			table = new Hashtable<String,String>();
				for (int colNum = 0; colNum < cols; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}}
		return data;
	}
}
