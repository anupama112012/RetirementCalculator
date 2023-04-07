package pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.TestBase;

public class RetirementPageClass extends TestBase{
	@FindBy(id="current-age")
	//@FindBy(xpath="//input[@id='current-age']")
	WebElement CurrentAge;
	@FindBy(id="retirement-age")
	WebElement RetAge;
	//@FindBy(id="current-income")
	@FindBy(xpath="//input[@id='current-income']")
	WebElement CurrentIncome;
	@FindBy(id="current-total-savings")
	WebElement SavingsBalance;
	@FindBy(id="current-annual-savings")
	WebElement AnnualSavings;
	@FindBy(id="savings-increase-rate")
	WebElement SavingsRate;
	@FindBy(id="yes-social-benefits")
	WebElement SocialSecurityYes;
	@FindBy(id="single")
	WebElement singleMaritalStatus;
	@FindBy(id="married")
	WebElement marriedMaritalStatus;
	@FindBy(id="social-security-override")
	WebElement socialSecurityOverrideAmount;
	@FindBy(id="no-social-benefits")
	WebElement SocialSecurityNo;
	@FindBy(xpath="//button[text()='Calculate']")
	WebElement calculateBtn;
	
	By ResultTitle=By.xpath("//div[@id='calculator-results-container']/h3[text()='Results']");	
	
	@FindBy(xpath="//a[text()='Adjust default values']")
	WebElement defaultValues;
	By DefaultValuesTitle=By.xpath("//h1[@id='default-values-modal-title' and text()='Default calculator values']");	
	@FindBy(id="additional-income")
	WebElement additionalIncome;
	@FindBy(id="retirement-duration")
	WebElement retirementDuration;
	@FindBy(id="retirement-annual-income")
	WebElement retirementAnnualIncome;
	@FindBy(id="include-inflation")
	WebElement InflationYes;
	@FindBy(id="exclude-inflation")
	WebElement InflationNo;
	@FindBy(id="expected-inflation-rate")
	WebElement expInflationRate;
	@FindBy(id="pre-retirement-roi")
	WebElement preRetirementRoi;
	@FindBy(id="post-retirement-roi")
	WebElement postRetirementRoi;
	@FindBy(xpath="//button[text()='Save changes']")
	WebElement btnSave;
	@FindAll({@FindBy(xpath="//span[text()='Input required']")})
	List<WebElement> MandatoryMessage;
	@FindBy(xpath="//p[@id='calculator-input-alert-desc' and text()='Please fill out all required fields']")	
	WebElement ReqFieldMsg;
String result;
JavascriptExecutor js = (JavascriptExecutor)driver;
SoftAssert softAssert = new SoftAssert();
String newstr;
WebDriverWait wait;
//=new WebDriverWait(driver, 20);

public RetirementPageClass() {
//	System.out.println("driver.toString()"+driver.toString());
PageFactory.initElements(driver, this);
}
public String validateTitle(){
return driver.getTitle();
}

//This method is to enter that details in relevant fields
public void enterDetails(String cAge,String rAge,String cInc,String savBal,String annSav,String savRate){
CurrentAge.sendKeys(cAge);
RetAge.sendKeys(rAge);
//click clear methods are used since the fields have default input as $
CurrentIncome.click();
CurrentIncome.clear();
CurrentIncome.sendKeys(cInc);
//click clear methods are used since the fields have default input as $
SavingsBalance.click();
SavingsBalance.clear();
SavingsBalance.sendKeys(savBal);
AnnualSavings.sendKeys(annSav);
SavingsRate.sendKeys(savRate);
checkDetails(cAge, rAge, cInc, savBal, annSav, savRate);
}

//This method verifies that details entered are present in relevant fields
public void checkDetails(String cAge,String rAge,String cInc,String savBal,String annSav,String savRate){
softAssert.assertEquals(CurrentAge.getAttribute("value"),cAge);
softAssert.assertEquals(RetAge.getAttribute("value"), rAge);
newstr=replaceSeperatorInString(CurrentIncome);
softAssert.assertEquals(newstr,cInc);
newstr=replaceSeperatorInString(SavingsBalance);
softAssert.assertEquals(newstr,savBal);
softAssert.assertEquals(AnnualSavings.getAttribute("value"), annSav+"%");
softAssert.assertEquals(SavingsRate.getAttribute("value"),savRate+"%");
softAssert.assertAll();
}

//This method replaces content in String based on separator being set
public String replaceSeperatorInString(WebElement e){
String str=e.getAttribute("value");
String separator ="$";
int sepPos = str.indexOf(separator);
String newstr=str.substring(sepPos + separator.length());
newstr=newstr.replace(",", "");
//System.out.println("Substring after separator = "+newstr);
return newstr;
}

//This method is to select SocialSecurity as Yes
public void selectSocialSecurityYes(){
	js.executeScript("arguments[0].scrollIntoView(true);", SocialSecurityYes);
	js.executeScript("arguments[0].click();", SocialSecurityYes);
	//SocialSecurityYes.click();	
}

//This method is to enter SocialSecurity details
public void enterSocialSecurityDetails(String MaritalStatus,String sSOA){
	if (MaritalStatus=="Single")
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", singleMaritalStatus);
	}
	else
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", marriedMaritalStatus);
	}
driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("timeOut")), TimeUnit.SECONDS);
socialSecurityOverrideAmount.click();
driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("timeOut")), TimeUnit.SECONDS);
socialSecurityOverrideAmount.clear();
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
socialSecurityOverrideAmount.click();
socialSecurityOverrideAmount.sendKeys(sSOA);
checkSocSecDetails(sSOA);
}

//This method verifies that details entered are present in relevant fields
public void checkSocSecDetails(String sSOA){
	newstr=replaceSeperatorInString(socialSecurityOverrideAmount);
	//System.out.println("newstr & sSOA "+newstr+" "+sSOA);
	softAssert.assertEquals(newstr,sSOA);
	softAssert.assertAll();
}

//This method is to select SocialSecurity as No
public void selectSocialSecurityNo(){
	js.executeScript("arguments[0].scrollIntoView(true);", SocialSecurityNo);
	js.executeScript("arguments[0].click();", SocialSecurityNo);
	//SocialSecurityNo.click();	
	}

//This method verifies that Social Security Fields are not visible
public void socialSecurityFieldsNotVisible(){
softAssert.assertFalse(singleMaritalStatus.isDisplayed());
softAssert.assertFalse(socialSecurityOverrideAmount.isDisplayed());
}

public void scrollToLastField(){
	js.executeScript("arguments[0].scrollIntoView(true);", SavingsRate);
}

//This method is to click Calculate
public void calculate() throws Exception{
//driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("timeOut")), TimeUnit.SECONDS);
calculateBtn.click();
}

//This method verifies mandatory fields
public void mandatoryfieldcheck(){
	String CI=CurrentIncome.getText();
	/*if((CurrentAge.getAttribute("value").isEmpty())){
		System.out.println("Current Age field is empty");
		}*/
	try{
		softAssert.assertNotEquals(CurrentAge.getAttribute("value"),"");
		//System.out.println("Current Age field is not empty");
		softAssert.assertNotEquals(RetAge.getAttribute("value"),"");
		//System.out.println("Retirement Age field is not empty");
		softAssert.assertNotEquals(CurrentIncome.getAttribute("value"),"");
		//System.out.println("Current Income field is not empty");
		softAssert.assertNotEquals(SavingsBalance.getAttribute("value"),"");
		//System.out.println("Savings Balance field is not empty");
		softAssert.assertNotEquals(AnnualSavings.getAttribute("value"),"");
		//System.out.println("Annual Savings field is not empty");
		softAssert.assertNotEquals(SavingsRate.getAttribute("value"),"");
		//System.out.println("Savings Rate field is not empty");
		softAssert.assertAll();
		}
		catch (Error e){
			Assert.assertTrue(ReqFieldMsg.isDisplayed());
			System.out.println("Mandatory missing fields = "+MandatoryMessage.size());
		}
	
	/*for(WebElement mf:MandatoryMessage){
		System.out.println("Fields "+mf.getText());
		}*/

}
public String ResultTitleCheck(){
	wait=new WebDriverWait(driver, 20);
	WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(ResultTitle));
	return title.getText();
//return result=ResultTitle.getAttribute("value");
}

public void clickDefaultValuesLink(){
defaultValues.click();
}

public String DefaultValuesTitleCheck(){
	wait=new WebDriverWait(driver, 20);
	WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(DefaultValuesTitle));
	return title.getText();
//return result=ResultTitle.getAttribute("value");
}

public void enterdefaultCalcValues(String addInc,String retDur,String retAnnInc,String preROI,String postROI){
js.executeScript("arguments[0].click();",additionalIncome);
additionalIncome.clear();
additionalIncome.click();
additionalIncome.sendKeys(addInc);
retirementDuration.sendKeys(retDur);
retirementAnnualIncome.sendKeys(retAnnInc);
preRetirementRoi.sendKeys(preROI);
postRetirementRoi.sendKeys(postROI);
checkDefaultDetails(addInc, retDur, retAnnInc, preROI, postROI);
}

//This method verifies that details entered are present in relevant fields
public void checkDefaultDetails(String addInc,String retDur,String retAnnInc,String preROI,String postROI){
newstr=replaceSeperatorInString(additionalIncome);
softAssert.assertEquals(newstr,addInc);
softAssert.assertEquals(retirementDuration.getAttribute("value"),retDur);
softAssert.assertEquals(retirementAnnualIncome.getAttribute("value"), retAnnInc+"%");
softAssert.assertEquals(preRetirementRoi.getAttribute("value"),preROI+"%");
softAssert.assertEquals(postRetirementRoi.getAttribute("value"),postROI+"%");
softAssert.assertAll();
}

public void selectInflationNo(){
	js.executeScript("arguments[0].click();", InflationNo);
	//InflationNo.click();
}

public void selectInflationYes(String expInfRate){
	js.executeScript("arguments[0].click();", InflationYes);
	//InflationYes.click();
	wait=new WebDriverWait(driver, 20);
	WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("expected-inflation-rate")));
	//js.executeScript("arguments[0].click();", expInflationRate);
	expInflationRate.click();
	expInflationRate.clear();
	expInflationRate.click();
	expInflationRate.sendKeys(expInfRate);
}

public void Save(){
btnSave.click();
}

}