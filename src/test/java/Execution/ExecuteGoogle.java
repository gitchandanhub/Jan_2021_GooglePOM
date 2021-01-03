package Execution;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.AppDriver;
import Modules.GoogleUrl;

public class ExecuteGoogle  extends AppDriver 
{
     
/*	@Test
	public void captureUrl() throws IOException, InterruptedException
	{
		GoogleUrl guobj = new GoogleUrl();
		guobj.CreateExcel("D:\\Software\\Database_2020\\db shop database\\Restaurant_mains\\google\\Resta_Url_2.xlsx");
		driver.navigate().to("https://www.google.com/search?tbm=lcl&ei=9xIIXK3rBNey9QPIl6fIBA&q=furniture+dealer&oq=furniture+dealer&gs_l=psy-ab.3..35i39k1j0l9.1603425.1614009.0.1614899.16.16.0.0.0.0.247.2142.0j15j1.16.0....0...1c.1.64.psy-ab..0.16.2137...0i131k1j0i67k1.0.GAisbOSxAYE#rlfi=hd:;si:;mv:!1m2!1d28.667845699999997!2d77.4001945!2m2!1d28.5082693!2d77.1836514;tbs:lrf:!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:10");
		Thread.sleep(30000);
		String citypath = "D:\\Software\\Database_2020\\db shop database\\Restaurant_mains\\google\\city_input_main.xlsx";
		String Categorypath = "D:\\Software\\Database_2020\\db shop database\\Restaurant_mains\\google\\category_input_new.xlsx";
		guobj.GetUrl(citypath, 0, 168, 498,  Categorypath, 0, 5);
	}*/
	@Test
	public void captureUrl() throws IOException, InterruptedException
	{
		GoogleUrl guobj = new GoogleUrl();
		guobj.CreateExcel("D:\\Software\\Database_2020\\db shop database\\Google_da\\WildlifeTA2.xlsx");
		driver.navigate().to("https://www.google.com/search?sxsrf=ALeKk00gHLf2tjJRoPVp4OfoDJrQrG79HQ:1598625759071&q=doctor+in+delhi&npsic=0&rflfq=1&rlha=0&rllag=28614116,77169018,9200&tbm=lcl&ved=2ahUKEwj94v2Dkb7rAhVzzzgGHVDlAJMQjGp6BAgMEE8&rldoc=1");
		Thread.sleep(3000);
		String citypath = "D:\\Software\\Database_2020\\db shop database\\Google_da\\city_input_main.xlsx";
		String Categorypath = "D:\\Software\\Database_2020\\db shop database\\Google_da\\Category.xlsx";
		guobj.GetUrl(citypath, 0, 45, 90,  Categorypath, 0, 2);
	}
}
