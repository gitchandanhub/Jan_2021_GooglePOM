package Execution;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.AppDriver;
import Modules.Verifyongoogle;
import Modules.verifyongoogle1;

public class ExecuteVerifyongoogle extends AppDriver
{
   /*   @Test
      public void verifygo() throws IOException, InterruptedException
      {
    	 Verifyongoogle  vgobj = new Verifyongoogle();
    	 vgobj.createexcel("D:\\Software\\Database_2020\\db shop database\\allindiaschooldatabase (1)\\May 2020\\", "VerifiedSchool");
    	 driver.navigate().to("https://www.google.com/search?tbm=lcl&ei=9xIIXK3rBNey9QPIl6fIBA&q=furniture+dealer&oq=furniture+dealer&gs_l=psy-ab.3..35i39k1j0l9.1603425.1614009.0.1614899.16.16.0.0.0.0.247.2142.0j15j1.16.0....0...1c.1.64.psy-ab..0.16.2137...0i131k1j0i67k1.0.GAisbOSxAYE#rlfi=hd:;si:;mv:!1m2!1d28.667845699999997!2d77.4001945!2m2!1d28.5082693!2d77.1836514;tbs:lrf:!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:10");
  		 Thread.sleep(30000);
  		 vgobj.sendtogoogle("D:\\Software\\Database_2020\\db shop database\\allindiaschooldatabase (1)\\May 2020\\verifyongoogle.xlsx");
      }*/
      @Test
      public void verifygo1() throws IOException, InterruptedException
      {
    	  verifyongoogle1  vgobj = new verifyongoogle1();
    	 vgobj.createexcel("D:\\Software\\Database_2020\\db shop database\\allindiaschooldatabase (1)\\May 2020\\", "VerifiedSchool");
    	 driver.navigate().to("https://www.google.com/search?tbm=lcl&ei=9xIIXK3rBNey9QPIl6fIBA&q=furniture+dealer&oq=furniture+dealer&gs_l=psy-ab.3..35i39k1j0l9.1603425.1614009.0.1614899.16.16.0.0.0.0.247.2142.0j15j1.16.0....0...1c.1.64.psy-ab..0.16.2137...0i131k1j0i67k1.0.GAisbOSxAYE#rlfi=hd:;si:;mv:!1m2!1d28.667845699999997!2d77.4001945!2m2!1d28.5082693!2d77.1836514;tbs:lrf:!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:10");
  		 Thread.sleep(3000);
  		 vgobj.sendtogoogle("D:\\Software\\Database_2020\\db shop database\\allindiaschooldatabase (1)\\May 2020\\verifyongoogle.xlsx");
      }
}
