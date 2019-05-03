package newModule.NewProject;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestCase {
	@Test
	public void TC01() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://twitter.com/stepin_forum");
		
		List<WebElement> lstWe = driver.findElements(By.xpath("//div[@title='Retweet']/following-sibling::span/span[@class='ProfileTweet-actionCountForPresentation']"));
		int highest = 0;
		for(WebElement we : lstWe)
		{
			int temp = Integer.parseInt(we.getText());
			
			if(temp>highest)
			{
				highest = temp;
			}
		}
		
		System.out.println(highest);
		
		
		lstWe = driver.findElements(By.xpath("//div[@title='Like']/following-sibling::span/span[@class='ProfileTweet-actionCountForPresentation']"));
		int highestLike = 0;
		for(WebElement we : lstWe)
		{
			if(!we.getText().equals(""))
			{
				int temp = Integer.parseInt(we.getText());
				
				if(temp>highestLike)
				{
					highestLike = temp;
				}
			}
		}
		
		System.out.println(highestLike);
		//div[@title='Like']/following-sibling::span/span[@class='ProfileTweet-actionCountForPresentation']
		
//		boolean bln = true;
//		
//		while(bln)
//		{
//			int val = driver.findElements(By.xpath("//div[@title='Retweet']/following-sibling::span/span[@class=\"ProfileTweet-actionCountForPresentation\"]")).size();
//			
//			if(val>=50)
//			{
//				bln=false;
//			}
//			else
//			{
//				Thread.sleep(2000);
//				JavascriptExecutor js = (JavascriptExecutor)driver;
//				js.executeScript("window.scrollTo(0,document.body.scrollheight)");
//				System.out.println(driver.findElements(By.xpath("//div[@title='Retweet']/following-sibling::span/span[@class=\"ProfileTweet-actionCountForPresentation\"]")).size());
//			}
//		}
	}
}
