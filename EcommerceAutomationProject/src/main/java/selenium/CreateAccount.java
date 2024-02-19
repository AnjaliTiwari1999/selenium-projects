package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		//accountCreation();
		 WebDriver driver = signIn();
		addWomenTopToCart(driver);
//		addBagToCart(driver);
		 checkout(driver);
	}

	private static void shippingAddress(WebDriver driver) throws InterruptedException {

	     
	 //Fill out the shipping Address
	     WebElement streetAddress=driver.findElement(By.name("street[0]"));
	     streetAddress.sendKeys("street number-17, Sector-49 Barola ");
	     Thread.sleep(5000);
	     System.out.println("Street deatils fill ho chuki h");
	     Thread.sleep(1000);
	     WebElement cityName=driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[4]/div/input"));
	     cityName.sendKeys("Noida");
	     Thread.sleep(5000);
	     WebElement zipCode=driver.findElement(By.name("postcode"));
	     System.out.println("Zipcode tk aa gaya h");
	     zipCode.sendKeys("201304");
	     System.out.println("Zipcode fill ho gaya h");
	     

	     
	     System.out.println("Country tk nhi gaya h");
	     Thread.sleep(10000);
	     WebElement countryDropdown=driver.findElement(By.name("country_id"));
	     System.out.println("Country tk aa gaya h");
	     List<WebElement> allOptions=driver.findElements(By.xpath("//select[@name='country_id']/option"));
        countryDropdown.click();
	    	       
	       String option="India";

	         for(int i=0; i<allOptions.size(); i++) {

	            if(allOptions.get(i).getText().equals(option)) {

	                     allOptions.get(i).click();

	                     System.out.println("clicked");

	                     break;

	               }

	         }
	         
		     Thread.sleep(2000);
		     WebElement phoneNumber=driver.findElement(By.name("telephone"));
		     System.out.println("Phone number tk aa gaya h");
		     phoneNumber.sendKeys("8881801503");
		     
		     driver.findElement(By.id("tooltip")).click();
	         
	         
	         
	         
	 // Create a Select object
   // Select selectCountry = new Select(countryDropdown);
  // Select "India" from the drop down by its visible text
 // selectCountry.selectByVisibleText("India");
// Wait for a few seconds (adjust according to your needs)
	        Thread.sleep(5000);
	     // Find the state drop down element
	        WebElement stateDropdown = driver.findElement(By.name("region_id"));
	        System.out.println("State tk aa gaya h");
        //	stateDropdown.click();
	        System.out.println("State drop down pr click ho gaya h");
	     // Create a Select object for state drop down
	        Select selectState = new Select(stateDropdown);   

	     // Select a state from the drop down by its visible text
	        selectState.selectByVisibleText("Uttar Pradesh");
    		Thread.sleep(4000);

	        
		
	}

	private static void checkout(WebDriver driver) throws InterruptedException {

	     Thread.sleep(10000);
	     
		//Checkout the product from cart
	     WebElement productCheckout = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]"));
	     productCheckout.click();
	     
	     WebElement productCheckout1 = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[3]/div/button"));
	     productCheckout1.click();
	     
	    
	     System.out.println("Product checkout h");
	     Thread.sleep(10000);
	     //shippingAddress(driver);
	     
	     
	     
	        //click on Next button to go on next page
			System.out.println("next btn tk aa gaya h");
		    WebElement nextButton=driver.findElement(By.xpath("//button[@type='submit' and @class='button action continue primary']"));
	        nextButton.click();
	        System.out.println("next btn click ho chuka h");
	        //we are on payment and review page 
     		Thread.sleep(4000);
     		
		    WebElement placeOrderButton=driver.findElement(By.xpath("//button[@title='Place Order']"));
		    placeOrderButton.click();
		    
		    //For printing order number in console
		     Thread.sleep(4000);
		     WebElement orderNumber=driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/p[1]/a/strong"));
		     System.out.println("My order number is "+orderNumber.getText());
		    
		  
	      
		
	}

	private static void addBagToCart(WebDriver driver) throws InterruptedException {
		// you are adding the product in to the cart from woman category
		 Thread.sleep(1000);
		// Locating the Main Menu (Parent element)
		 WebElement gearWebElement = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[4]/a/span[2]"));
		 
		 
		//Instantiating Actions class
		 Actions actions = new Actions(driver);
		//Hovering on main menu
		 actions.moveToElement(gearWebElement);
		 Thread.sleep(2000);

	   // Locating the element from Sub Menu
       WebElement subMenu = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[4]/ul/li[1]/a/span"));
      //To mouse over on sub menu
       actions.moveToElement(subMenu);
		Thread.sleep(2000);
	   //build()- used to compile all the actions into a single step 
	    actions.click().build().perform();
	   //adding second product of page which is a bag
	     WebElement addingSecondBag=driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[4]/ol/li[2]/div/a/span/span/img"));
	     addingSecondBag.click();
	     Thread.sleep(1000);
	  //Add to cart
	     WebElement bagAddToCart=driver.findElement(By.id("product-addtocart-button"));
	     bagAddToCart.click();
	     Thread.sleep(2000);
	  // Getting the element 

	     WebElement productAddedNotification = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div"));
	     System.out.println(productAddedNotification.getText());
	     
	  //Getting the product count
	     WebElement availableProductCountIncart=driver.findElement(By.xpath("//span[@class='counter-number']"));
	     System.out.println(availableProductCountIncart.getText());

		
	}

	private static void addWomenTopToCart(WebDriver driver) throws InterruptedException {
		// you are adding the product in to the cart from woman category
		 Thread.sleep(1000);
	     WebElement addingProduct=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/nav/ul/li[2]/a/span[2]"));
	     addingProduct.click();
	     Thread.sleep(1000);
	   //adding top in to cart
	     WebElement addingTops=driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[1]/div[2]/dl/dd/ol/li[1]/a"));
	     addingTops.click();
	     Thread.sleep(1000);
	     System.out.println("tank top selection k pahle");
	   //adding first product of page which is a tank top
	     WebElement addingFirstTop=driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[4]/ol/li[1]/div/a/span/span/img"));
	     addingFirstTop.click();
	      Thread.sleep(1000);
	      System.out.println("tank top size selection k pahle");
	   //you need to choose the Size S
	     WebElement selectingSize=driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/form/div[1]/div/div/div[1]/div[1]/div[2]"));
	     selectingSize.click();
	     System.out.println("tank top color selection k pahle");
	   //you need to choose color purple
	     WebElement selectingColor=driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/form/div[1]/div/div/div[2]/div[1]/div[1]"));
	     selectingColor.click();
	     System.out.println("tank top kart me add hone k pahle");
	   //you need to add product in cart
	     WebElement productAddToCart=driver.findElement(By.id("product-addtocart-button"));
	     productAddToCart.click();
	     System.out.println("product added successfully");
	     Thread.sleep(1000);
	     driver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
//	     webDriver.FindElement(By.TagName("body")).SendKeys(Keys.Home);
	     

	     
	}

	private static WebDriver signIn() {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		// Launch the application
		 driver.get("https://magento.softwaretestingboard.com/");
		//Resize current window to the set dimension
	     driver.manage().window().maximize();
	   //Now you need to click on SignIn link
	     WebElement SignInAccount=driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
	     SignInAccount.click();
	   //Registered Customers - If you have an account, sign in with your email address. 
	     WebElement emailToSignIn=driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/div[2]/form/fieldset/div[2]/div/input"));
	     emailToSignIn.sendKeys("sweetyanjalit@gmail.com");
//	     emailToSignIn.sendKeys("anjali@grr.la");
	     
	     WebElement enterPasswordToSignIn=driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/div[2]/form/fieldset/div[3]/div/input"));
	     enterPasswordToSignIn.sendKeys("sweety24@sweety");
	     
	     WebElement signInButton=driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button"));
	     signInButton.click();
	     return driver;
	}

	private static void accountCreation() {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		// Launch the application
		 driver.get("https://magento.softwaretestingboard.com/");
		
	    //Resize current window to the set dimension
	      driver.manage().window().maximize();
	      
	      
	    //Now you need to click on Create An Account link
	      WebElement createAnAccount=driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
	      createAnAccount.click();
	      
	    //Now you need to fill the First Name
	      WebElement inputFirstName=driver.findElement(By.id("firstname"));
	      inputFirstName.sendKeys("Anjali");
	      
	    //Now you need to fill the Last Name
	      WebElement inputLastName=driver.findElement(By.id("lastname"));
	      inputLastName.sendKeys("Tiwari");
	      
	   //Now You need to fill Sign-in Information    
	      WebElement enterEmail=driver.findElement(By.id("email_address"));
//	      enterEmail.sendKeys("sweetyanjalit@gmail.com");
	      enterEmail.sendKeys("anjali@grr.la");
	      
	      WebElement enterPassword=driver.findElement(By.id("password"));
	      enterPassword.sendKeys("sweety24@sweety");
	      
	      
	      WebElement enterConfirmPassword=driver.findElement(By.id("password-confirmation"));
	      enterConfirmPassword.sendKeys("sweety24@sweety");
	      System.out.println("password confirmation box k bahar nhi aaya h");
	      
	      WebElement createAnAccountButton= driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/form/div/div[1]/button/span"));
	      System.out.println("password confirmation box k bahar button tk aaya h");
	      createAnAccountButton.click();
	      System.out.println("button click kr chuka h");
	      
	      //yaha tk code ne account create kr diya h ab agr account created hai to sign in krenge.
	      
	}

}
