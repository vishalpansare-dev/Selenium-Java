package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumberFramework.helper.WaitHelper;

public class LoginLogoutPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement userName;
	@FindBy(xpath="//div[@id='center_column']/h1[text()='My account']")
	public WebElement myaccount;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a[@title='View my customer account']")
	public WebElement profile;
	@FindBy(xpath="//*[@id='columns']//div//span[text()='Women']")
	public WebElement womenPage;
	@FindBy(xpath="//*[@id='columns']//div//span[contains(text(),'Dresses')]")
	public WebElement DRESSESPage;
	@FindBy(xpath="//*[@id='columns']//div//span[contains(text(),'T-shirts')]")
	public WebElement TshirtsPage;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
	public WebElement firstProduct;
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	public WebElement proceedtocheckout;
	@FindBy(xpath="(//p[@class='product-name'])[2]")
	public WebElement cartitem;
	@FindBy(xpath="//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span[text()='Add to cart']")
	public WebElement addCart;
	
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li/a[text()='Women']")
	public WebElement womenMenu;
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li/a[text()='Dresses']")
	public WebElement DRESSESMenu;
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li/a[text()='T-shirts']")
	public WebElement TshirtsMenu;
	

	@FindBy(xpath="//div[@class='alert alert-danger']")
	public WebElement errormsg;
	@FindBy(xpath="//*[@id='block_top_menu']/ul")
	public WebElement menuItem;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement Continue;
	
	@FindBy(xpath="//input[@id='passwd']")
	public WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='header_user_info']/a[@class='login']")
	WebElement SignInfromNav;
	
	@FindBy(xpath="//div[@class='header_user_info']/a[@class='logout']")
	public WebElement logoutBtn;
	
	@FindBy(xpath="//div[@id='nav-shop']/a")
	public WebElement allShopNav;

	@FindBy(xpath="//span[@data-nav-panelkey='TvApplElecPanel']")
	public WebElement TvApplElecPanel;
	
	@FindBy(xpath="//span[contains(text(),'Headphones')]/parent::a")
	public WebElement headPhonesCatLnk;
	
	@FindBy(xpath="//div[@id='mainResults']/ul/li[1]/div/div/div/a[contains(@class,'access-detail-page')]")
	public WebElement firstHeadPhoneLnk;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	public WebElement addToCartBtn;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	public WebElement cartButton;
	
	@FindBy(xpath="//form[@id='activeCartViewForm']/div[@data-name='Active Items' or contains(@class,'sc-list-body')]//input[@value='Delete']")
	public List<WebElement> itemList;
	
	//form[@id='activeCartViewForm']/div[@data-name='Active Items' or contains(@class,'sc-list-body')]//input[@value='Delete']
	
	@FindBy(xpath="//form[@id='searchbox']/input[@id='search_query_top']")
	public WebElement itemSearchField;
	
	@FindBy(xpath="//div[starts-with(@class,'sg-col-4')]/div[@class='sg-col-inner']/div/h5/a")
	public WebElement secondMacbookItem;
	
	@FindBy(xpath="//select[@id='quantity' or @name='quantity']")
	public List<WebElement> qtyField;
	
	
	WaitHelper waitHelper;
	
	public LoginLogoutPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
	
	public void enterUserName(String userName){
		this.userName.sendKeys(userName);
	}
	
	public void enterPassword(String password){
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton(){
		loginButton.click();
	}
	
	public void enterSearchItemandAddToCart(String item){
		String mainWindow=driver.getWindowHandle();
		this.itemSearchField.sendKeys(item);
		this.itemSearchField.submit();
		secondMacbookItem.click();
		Set<String> set =driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
		 String childWindow=itr.next();
		 if(!mainWindow.equals(childWindow)){
			 driver.switchTo().window(childWindow);
			 System.out.println(driver.switchTo().window(childWindow).getTitle());
			 if(qtyField.size()>=1){
				 
				 Select sel = new Select(qtyField.get(0));
				 sel.selectByValue("2");
			 }
			 
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].scrollIntoView(true);",addToCartBtn);
			 js.executeScript("arguments[0].click();", addToCartBtn);
			 if(driver.findElements(By.xpath("//div[@class='a-popover-inner']//button[contains(text(),'Skip')]")).size()>=1){
				 
				 driver.findElements(By.xpath("//div[@class='a-popover-inner']//button[contains(text(),'Skip')]")).get(0).click();
			 }
			 //addToCartBtn.click();
			 //driver.close();
		 }
		}
		driver.switchTo().window(mainWindow);
	}
	
	public void clickSignInButton(){
		Actions builder = new Actions(driver);
		builder.moveToElement(SignInfromNav).build().perform();
		SignInfromNav.click();
	}
	
	public void clearCartItemifExist(){
		cartButton.click();
		int i = itemList.size();
		if(i>=1){
			itemList.get(0).click();
			i = itemList.size();
		}
	}
	
	public void clickHeadphonesLnk(){
		Actions builder = new Actions(driver);
		builder.moveToElement(allShopNav).build().perform();
		builder.moveToElement(TvApplElecPanel).build().perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", headPhonesCatLnk);
		
	}
	
	public void AddHeadphoneToCart(){
		
		firstHeadPhoneLnk.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", addToCartBtn);
	}

	
	public void clickContinueButton(){
		Continue.click();
	}
	
	public void addProductToCart(){
		Actions builder = new Actions(driver);
		builder.moveToElement(firstProduct).build().perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", addCart);
		 
		 js.executeScript("arguments[0].click();", proceedtocheckout);
		 
	}
	
	public void clickLogoutButton(){
		Actions builder = new Actions(driver);
		builder.moveToElement(logoutBtn).build().perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", logoutBtn);;
	}

	public void checkMenu(List<List<String>> item) {
		
		for (List<String> string : item) {
			WebElement menu=driver.findElement(By.xpath("//*[@id='center_column']/div/div/ul/li/a/span[text()='"+string.get(0)+"']"));
			assertEquals(true, menu.isDisplayed(), string+" Menu not displayed on page");
		}
		
		
		
	}
}
